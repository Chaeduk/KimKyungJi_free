package kpu.web.club.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import kpu.web.club.domain.QuestionnaireVO;
import kpu.web.club.persistence.QuestionnaireDAO;

/**
 * Servlet implementation class QuestionnaireServlet
 */
@WebServlet("/QuestionnaireServlet")
public class QuestionnaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmdReq;
		String msg;
		cmdReq = request.getParameter("cmd");
		if(cmdReq.equals("delete")) {
			HttpSession session = request.getSession(true);
			if(session.getAttribute("id")==null) {
				msg = "잘못된 접근입니다.";
				request.setAttribute("msg", msg);
				RequestDispatcher view = request.getRequestDispatcher("message.jsp");
				view.forward(request, response);
				
			} else if(session.getAttribute("id").equals("admin")) {
				QuestionnaireDAO questionnairedao = new QuestionnaireDAO();
				if(questionnairedao.deleteHistory()) {
					msg = "전체 내역을 삭제하였습니다.";
					
				} else {
					msg = "오류가 발생하였습니다. 다시시도해주세요.";
				}
				request.setAttribute("msg", msg);
				RequestDispatcher view = request.getRequestDispatcher("message.jsp");
				view.forward(request, response);
				
			} else {
				msg = "잘못된 접근입니다.";
				request.setAttribute("msg", msg);
				RequestDispatcher view = request.getRequestDispatcher("message.jsp");
				view.forward(request, response);
			}
			
		} else if(cmdReq.equals("sort")) {
			HttpSession session = request.getSession(true);
			if(session.getAttribute("id")==null) {
				msg = "잘못된 접근입니다.";
				request.setAttribute("msg", msg);
				RequestDispatcher view = request.getRequestDispatcher("message.jsp");
				view.forward(request, response);
				
			} else if(session.getAttribute("id").equals("admin")) {
				if(request.getParameter("par").equals("false")) {
					QuestionnaireDAO questionnairedao = new QuestionnaireDAO();
					ArrayList<QuestionnaireVO> userlist = questionnairedao.getSortedUser();
					request.setAttribute("userlist", userlist);
					request.setAttribute("par", true);
					request.setAttribute("btnValue", "전체 대상자 보기");
					RequestDispatcher view = request.getRequestDispatcher("questionnaireHistoryForAdmin.jsp");
					view.forward(request, response);
				} else if(request.getParameter("par").equals("true")) {
					QuestionnaireDAO questionnairedao = new QuestionnaireDAO();
					ArrayList<QuestionnaireVO> userlist = questionnairedao.getAllUserlist();
					request.setAttribute("userlist", userlist);
					request.setAttribute("par", false);
					request.setAttribute("btnValue", "의심 대상자만 보기");
					RequestDispatcher view = request.getRequestDispatcher("questionnaireHistoryForAdmin.jsp");
					view.forward(request, response);
				}
				
			} else {
				msg = "잘못된 접근입니다.";
				request.setAttribute("msg", msg);
				RequestDispatcher view = request.getRequestDispatcher("message.jsp");
				view.forward(request, response);
			}
		} else if(cmdReq.equals("edit")) {
			QuestionnaireDAO questionnairedao = new QuestionnaireDAO();
			QuestionnaireVO user = questionnairedao.read(request.getParameter("no"));
			if(user.getName() == null) {
				msg = "잘못된 접근입니다.";
				request.setAttribute("msg", msg);
				RequestDispatcher view = request.getRequestDispatcher("message.jsp");
				view.forward(request, response);
			} else {
				request.setAttribute("user", user);
				RequestDispatcher view = request.getRequestDispatcher("update.jsp");
				view.forward(request, response);
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmdReq;
		String msg;
		cmdReq = request.getParameter("cmd");
		if(cmdReq.equals("register")) {
			QuestionnaireVO questionnairevo = new QuestionnaireVO();
			
			questionnairevo.setName(request.getParameter("name"));
			questionnairevo.setTel(request.getParameter("tel"));
			questionnairevo.setBirth(request.getParameter("birth"));
			questionnairevo.setSex(request.getParameter("sex"));
			questionnairevo.setQ1(Boolean.parseBoolean(request.getParameter("Q1")));
			questionnairevo.setQ2(Boolean.parseBoolean(request.getParameter("Q2")));
			questionnairevo.setQ3(Boolean.parseBoolean(request.getParameter("Q3")));
			
			QuestionnaireDAO questionnairedao = new QuestionnaireDAO();
			
			if(questionnairedao.add(questionnairevo)) {
				msg = request.getParameter("name") +"님, 사전 온라인 문진표 작성을 완료하였습니다.";
				request.setAttribute("msg", msg);
				RequestDispatcher view = request.getRequestDispatcher("message.jsp");
				view.forward(request, response);
			} else {
				msg = "오류가 발생하였습니다. 다시시도해주세요.";
				request.setAttribute("msg", msg);
				RequestDispatcher view = request.getRequestDispatcher("message.jsp");
				view.forward(request, response);
			}
			
		} else if(cmdReq.equals("find")) {
			QuestionnaireDAO questionnairedao = new QuestionnaireDAO();
			
			ArrayList<QuestionnaireVO> userlist = questionnairedao.getUserlist(request.getParameter("name"), request.getParameter("tel"));
			if(userlist.size() == 0) {
				msg = request.getParameter("name")+"님의 기록이 존재하지 않습니다.";
				request.setAttribute("msg", msg);
				RequestDispatcher view = request.getRequestDispatcher("message.jsp");
				view.forward(request, response);
			} else {
				request.setAttribute("userlist", userlist);
				request.setAttribute("name", request.getParameter("name"));
				RequestDispatcher view = request.getRequestDispatcher("questionnaireHistoryForUser.jsp");
				view.forward(request, response);
			}
			
		} else if(cmdReq.equals("admin")) {
			if(request.getParameter("id").equals("admin")&&request.getParameter("password").equals("1234")) {
				QuestionnaireDAO questionnairedao = new QuestionnaireDAO();
				HttpSession session = request.getSession();
				if(session!=null) {
					session.setAttribute("id", request.getParameter("id"));
				}
				ArrayList<QuestionnaireVO> userlist = questionnairedao.getAllUserlist();
				request.setAttribute("userlist", userlist);
				request.setAttribute("par", false);
				request.setAttribute("btnValue", "의심 대상자만 보기");
				RequestDispatcher view = request.getRequestDispatcher("questionnaireHistoryForAdmin.jsp");
				view.forward(request, response);
			} else {
				msg = "로그인에 실패하였습니다.";
				request.setAttribute("msg", msg);
				RequestDispatcher view = request.getRequestDispatcher("message.jsp");
				view.forward(request, response);
			}
		} else if(cmdReq.equals("edit")) {
			QuestionnaireVO questionnairevo = new QuestionnaireVO();
			
			questionnairevo.setName(request.getParameter("name"));
			questionnairevo.setTel(request.getParameter("tel"));
			questionnairevo.setBirth(request.getParameter("birth"));
			questionnairevo.setSex(request.getParameter("sex"));
			questionnairevo.setQ1(Boolean.parseBoolean(request.getParameter("Q1")));
			questionnairevo.setQ2(Boolean.parseBoolean(request.getParameter("Q2")));
			questionnairevo.setQ3(Boolean.parseBoolean(request.getParameter("Q3")));
			
			QuestionnaireDAO questionnairedao = new QuestionnaireDAO();
			if(questionnairedao.update(questionnairevo)) {
				msg = request.getParameter("name") +"님, 수정을 완료하였습니다.";
				request.setAttribute("msg", msg);
				RequestDispatcher view = request.getRequestDispatcher("message.jsp");
				view.forward(request, response);
			} else {
				msg = "오류가 발생하였습니다. 다시시도해주세요.";
				request.setAttribute("msg", msg);
				RequestDispatcher view = request.getRequestDispatcher("message.jsp");
				view.forward(request, response);
			}
		}
	}

}
