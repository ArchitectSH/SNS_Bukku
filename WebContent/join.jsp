<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bukku</title>
	<link href="css/join.css" rel="stylesheet" type="text/css"></link>
	<script src="javascript/join.js" type="text/javascript" charset="UTF-8"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
	<header id="titleHeader"> </header>
	<section>
		<table id="titleTable">
			<tr>
				<td id="iconTd"><img src="image/mainIcon.jpg" id="mainIcon" />
				<h1 id="title">Bukku</h1></td>
				<td rowspan="2" id="joinTd">
					<div id="joinDiv">
					<form method="post" action="join" id="joinFrm">
					<table id="joinTable">
						<caption id="joinCaption">회원가입</caption>
						<tr>
							<td>아이디</td>
							<td><input type="text" name="id" id="id" /></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="pwd" id="pwd" /></td>
						</tr>
						<tr>
							<td>비밀번호 확인</td>
							<td><input type="password" name="pwd2" id="pwd2" /></td>
						</tr>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name" id="name" /></td>
						</tr>
						<tr>
							<td>성별</td>
							<td><input type="radio" name="gender" value="1" />남자 <input
								type="radio" name="gender" value="2" /> 여자</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td><input type="text" name="email" id="email" />@ <select
								name="emailAddr">
									<option value="naver.com">naver.com</option>
									<option value="daum.net">daum.net</option>
									<option value="google.com">google.com</option>
									<option value="nate.com">nate.com</option>
									<option value="etc">기타</option>
							</select></td>
						</tr>
						<tr>
							<td>핸드폰 번호</td>
							<td>
							<input type="text" name="phoneNum1" id="phoneNum1" />- 
							<input type="text" name="phoneNum2" id="phoneNum2" />- 
							<input type="text" name="phoneNum3" id="phoneNum3" /></td>
						</tr>
						<tr>
							<td>생년월일</td>
							<td>
								<input type="number" name="year" max="2015" min="1" id="year" />년 
								<input type="number" name="month" max="12" min="1" id="month" />월 
								<input type="number" name="day" max="31" min="1" id="day" />일
							</td>
						</tr>
						<tr>
							<td colspan="2" id="bottomTd">
								<input type="button" value="가입" id="joinBtn" class="btn btn-info" />
								<input type="button" value="취소" id="cancelBtn" class="btn btn-info" />
							</td>
						</tr>
					</table>
					</form>
					</div>
				</td>
			</tr>
		</table>
		
	</section>
	<footer id="titleFooter"> </footer>
</body>
</html>