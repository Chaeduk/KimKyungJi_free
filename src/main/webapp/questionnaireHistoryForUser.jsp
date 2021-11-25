<%@page import="java.util.List"%>
<%@page import="kpu.web.club.domain.QuestionnaireVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
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
		<div class="heading"><%=request.getAttribute("name") %>님의 문진표 작성 내역</div>
	  <mytag:item/>
      <div style="text-align:center; margin-top: 20px; margin-bottom: 50px;">
				<button id="home_btn" onclick="location.href='./main.html'">처음으로</button>
	  </div>
		
	</div>

</body>
</html>