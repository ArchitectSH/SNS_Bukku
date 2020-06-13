<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bukku</title>
	<link href="css/findChoice.css" rel="stylesheet" type="text/css"></link>
	<script src="javascript/findChoice.js" type="text/javascript" charset="UTF-8"></script>
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
				<td rowspan="2" id="findTd">
					<div id="findDiv">
					<form method="" action="" id="findFrm">
						<table id="findTable">
							<tr>
								<td id="choiceTd">
									<div id="choiceDiv">찾으려는 회원정보를 선택해주세요.</div>
									<span id="idSelect"><input type="radio" name="choice" value="id" />아이디 찾기</span>
									<span id="pwdSelect"><input type="radio" name="choice" value="pwd" /> 비밀번호 찾기</span>
								</td>
							</tr>
							<tr>
								<td colspan="2" id="bottomTd">
									<input type="button" value="계정 찾기" id="findBtn" class="btn btn-info" />
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