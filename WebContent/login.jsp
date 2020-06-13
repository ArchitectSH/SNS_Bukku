<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bukku</title>
		<link href="css/login.css" rel="stylesheet" type="text/css"></link>
		<script src = "javascript/login.js" type="text/javascript" charset="UTF-8"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
		   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		   <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	</head>
	<body>
		<header id="titleHeader">
		</header>
			<table id="titleTable">
				<tr>
					<td>
						<img src="image/mainIcon.jpg" id="mainIcon"/>
					</td>
					<td rowspan="2" id="formTd">
						<div id="loginDiv">
							<span id="welcome">Bukku에 오신 것을 환영합니다!</span>
							<form method="post" action="login" id="loginFrm">
								<table id="loginTable">
									<tr>
										<td>아이디</td>
										<td><input type="text" name="id" />
										<td rowspan="2"><input id="login" type="button" class="btn btn-small btn-danger" value="로그인"/></td>
									</tr>
									<tr>
										<td>비밀번호</td>
										<td><input type="password" name="pwd" /></td>
									</tr>
								</table>
							</form>
						</div>
					</td>
				</tr>
				<tr>
					<td  id="titleTd">
						Bukku
					</td>
				</tr>
				<tr>
					<td colspan="2" id="bottomTd">
						<form method="get" action="join" id="joinFrm">
						<input type="button"  class="btn btn-info" id="joinBtn" value="회원가입">
						</form>
						<form method="get" action="findAccount" id="findFrm">
						<input type="button"  class="btn btn-info" id="findBtn" value="계정찾기">
						</form>
				</tr>
		</table>
		<footer id="titleFooter"></footer>	
</body>
</html>