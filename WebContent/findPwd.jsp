<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bukku</title>
	<link href="css/findId.css" rel="stylesheet" type="text/css"></link>
	<script src="javascript/findId.js" type="text/javascript" charset="UTF-8"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="all_popup" style="display: none;">
		 <div class="popupLayer">
			  <div class="back"></div>
			  <iframe src='about:blank'  mce_src='about:blank' scrolling='no' frameborder='0' title="전체 아이프레임 영역"></iframe>
		 </div>
		<div class="popup_box" style="width: 350px; height: 160px; margin-top: -80px;">
			<!-- 변경될 수 있는값은 html에서 작성 -->
			<iframe src='about:blank' mce_src='about:blank' scrolling='no' frameborder='0' title="팝업 아이프레임 영역"></iframe>
			<div class="popup_contents">
				<!-- popup_contents 안에서 자유 디자인 -->
				<div id="codeKind"></div>인증코드를 입력해주세요.<br /><br />
				인증코드
				<form method="" action="" id="codeInputFrm">
					<input type="text " name="confirmCode" /><br /><br />
					<input type="button" id="inputCodeBtn"  class="btn btn-info" value="입력">
				</form>
				<form method="" action="" id="codeCancelFrm">
					<input type="button" id="cancelCodeBtn"  class="btn btn-info" value="취소">
				</form>
			</div>
		</div>
	</div>
	
	
	<div id="all_popup2" style="display: none;">
		 <div class="popupLayer">
			  <div class="back"></div>
			  <iframe src='about:blank'  mce_src='about:blank' scrolling='no' frameborder='0' title="전체 아이프레임 영역"></iframe>
		 </div>
		<div class="popup_box" style="width: 350px; height: 160px; margin-top: -80px;">
			<!-- 변경될 수 있는값은 html에서 작성 -->
			<iframe src='about:blank' mce_src='about:blank' scrolling='no' frameborder='0' title="팝업 아이프레임 영역"></iframe>
			<div class="popup_contents">
				<!-- popup_contents 안에서 자유 디자인 -->
				<div id="findResult">비밀번호를 찾았습니다!</div><br />
				회원님의 비밀번호 : 1234123<br />	<br />
				<form method="" action="" id="loginFrm">
					<input type="button" id="loginBtn"  class="btn btn-info" value="로그인">
				</form>
				<form method="" action="" id="mainFrm">
					<input type="button" id="mainBtn"  class="btn btn-info" value="메인화면">
				</form>
			</div>
		</div>
	</div>
	
	
	
	
	<header id="titleHeader"> </header>
	<section>
		<table id="titleTable">
			<tr>
				<td id="iconTd"><img src="image/mainIcon.jpg" id="mainIcon" />
				<h1 id="title">Bukku</h1></td>
				<td rowspan="2" id="findTd">
					<div id="findDiv">
						<form method="" action="" id="nextFrm">
							<table id="findTable">
								<tr>
									<td colspan="2" class="kindTd">
										<input type="radio" name="choice" id="choice" value="idEmail" />&nbsp;아이디와 이메일로 찾기
									</td>
								</tr>
								<tr>
									<td>이름</td>
									<td><input type="text" name="name"></td>
								</tr>
								<tr>
									<td>이메일</td>
									<td><input type="text" name="email"></td>
								</tr>
								<tr>
									<td colspan="2" class="kindTd">
										<input type="radio" name="choice" id="choice" value="idCellPhone" />&nbsp;아이디와 핸드폰번호로 찾기
									</td>
								</tr>
								<tr>
									<td>이름</td>
									<td><input type="text" name="name"></td>
								</tr>
								<tr>
									<td>핸드폰 번호</td>
									<td>
										<input type="text" name="phoneNum1" id="phoneNum1" /> - 
										<input type="text" name="phoneNum2" id="phoneNum2" /> - 
										<input type="text" name="phoneNum3" id="phoneNum3" />
									</td>
								</tr>
								<tr>
									<td colspan="2" id="nextTd">
										<input type="button" id="nextBtn" class="btn btn-info" value="다음"/>
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