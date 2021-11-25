<%@tag import="kpu.web.club.domain.QuestionnaireVO"%>
<%@tag import="java.util.List"%>
<%@ tag language="java" body-content="empty" pageEncoding="UTF-8"%>

<table style="margin-left: auto; margin-right: auto; text-align: center width=100%" border="1" >
        <tr>
          <th>번호</th>
          <th>이름</th>
          <th>전화번호</th>
          <th>생년월일</th>
          <th>성별</th>
          <th>질문1</th>
          <th>질문2</th>
          <th>질문3</th>
          <th>작성날짜</th>
          <th>수정하기</th>
        </tr>
        <%
        	List<QuestionnaireVO> userlist = (List<QuestionnaireVO>) request.getAttribute("userlist");
        	for(QuestionnaireVO vo : userlist){
        %>
        <tr>
          <td><%=vo.getNo() %></td>
          <td><%=vo.getName() %></td>
          <td><%=vo.getTel() %></td>
          <td><%=vo.getBirth() %></td>
          <td><%=vo.getSex() %></td>
          <td><%=vo.getQ1() %></td>
          <td><%=vo.getQ2() %></td>
          <td><%=vo.getQ3() %></td>
          <td><%=vo.getRegister_date() %></td>
          <td><a href="./QuestionnaireServlet?cmd=edit&no=<%=vo.getNo()%>">수정하기</a></td>
        </tr>
        <%
        	}
        %>
      </table>