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
		<div class="heading">코로나 19 사전 온라인 문진 수정</div>
		<form action="./QuestionnaireServlet?cmd=edit" method="post">
			<div class="form">
				이름<br>
				<input type="text" class="blank" name="name" required placeholder="이름을 입력하세요"><br>

				전화번호<br>
				<input type="text" class="blank" name="tel" required placeholder="전화번호를 입력하세요"><br>

				생년월일<br>
				<input type="text" class="blank" name="birth" required placeholder="생년월일 6자리를 입력하세요"><br>
				
				성별<br>
				<select class="blank" name="sex" id="sex">
					<option value="none" selected disabled hidden>성별을 선택하세요</option>
					<option value="man">남성</option>
					<option value="women">여성</option>
				</select>
				<br>
				
				Q1. 현재 코로나19 의심증상[발열(37.5도 이상), 기침, 호흡곤란,
				오한, 근육통,<br> 두통 인후통, 후각·미각 소실 등]이 있습니까?<br>
				<div class="choose">
					<label style="margin-right: 40px"><input type="radio" name="Q1" value="true" required>예</label>
					<label><input type="radio" name="Q1" value="false">아니요</label>
				</div>
			

				Q2. 최근 14일 이내 코로나19 확진환자와 접촉하신적이 있습니까?<br>
				<div class="choose">
					<label style="margin-right: 40px"><input type="radio" name="Q2" value="true" required>예</label>
					<label><input type="radio" name="Q2" value="false">아니요</label>
				</div>

				Q3. 본인 포함 가족 또는 동거인 중 자가격리 대상자가 있습니까?<br>
				<div class="choose">
					<label style="margin-right: 40px"><input type="radio" name="Q3" value="true" required>예</label>
					<label><input type="radio" name="Q3" value="false">아니요</label>
				</div>
			</div>
			<div style="text-align:center; margin-top: 20px; margin-bottom: 50px;">
				<button id="confirm_btn">수정</button>
			</div>
		</form>
		
		
	</div>
	
</body>
</html>