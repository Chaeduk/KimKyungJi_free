<%@page import="kpu.web.club.domain.QuestionnaireVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코로나 19 사전 온라인 문진</title>
<link rel="stylesheet" href="resources/main.css" type="text/css"/>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Nanum+Gothic:wght@700&display=swap" rel="stylesheet">
</head>
<body>
	<div class="content">
		<div class="heading">관리자 페이지</div>
      <div style="width: 100%; text-align: right; margin-bottom: 7px;">
        <button class="control_btn" style="width: 180px" onclick="location.href='./QuestionnaireServlet?cmd=sort&par=${ par}'"><%=request.getAttribute("btnValue") %></button>
        <button class="control_btn" onclick="location.href='./QuestionnaireServlet?cmd=delete'">내역 삭제</button>
      </div>
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
        </tr>
        <%
        	}
        %>
      </table>

      <div style="text-align:center; margin-top: 20px; margin-bottom: 50px;">
				<button id="home_btn" onclick="location.href='./main.html'">처음으로</button>
	  </div>
	</div>
</body>
</html>