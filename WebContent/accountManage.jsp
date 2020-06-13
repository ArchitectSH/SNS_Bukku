<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bukku</title>
		<link href="css/AccountManage.css" rel="stylesheet" type="text/css"></link>
		<script src="javascript/accountManage.js" type="text/javascript" charset="UTF-8"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
		   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		   <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	</head>
	<body>
		<%@ include file="bukkuHeader.jsp" %>
		<script>
		var modifyFlag=0;
		var withdrawFlag=0;
		//회원정보 수정
			$(function() {
				var $modifyBtn = $('#modifyBtn');
				$modifyBtn.click(function(e) {
					if(modifyFlag==0){
						document.getElementById('modifyExecuteDiv').style.display='';
						modifyFlag=1;
					}
					else{
						document.getElementById('modifyExecuteDiv').style.display='none';
						modifyFlag=0;
					}
				});
			});
			
			//회원 탈퇴
			$(function() {
				var $withdrawBtn = $('#withdrawBtn');
				$withdrawBtn.click(function(e) {
					if(withdrawFlag==0){
						document.getElementById('withdrawExecuteDiv').style.display='';
						withdrawFlag=1;
					}
					else{
						document.getElementById('withdrawExecuteDiv').style.display='none';
						withdrawFlag=0;
					}
				});
			});
			
			//탈퇴 여부
			$(function() {
				var $inputPwdBtn = $('#inputPwdBtn');
				$inputPwdBtn.click(function(e) {
					document.getElementById('withdrawPopup').style.display=''; 
					document.body.className='mpopup';
				});
			});
			$(function() {
				var $cancelWithdrawBtn = $('#cancelWithdrawBtn');
				$cancelWithdrawBtn.click(function(e) {
					document.getElementById('withdrawPopup').style.display='none';
					document.body.className='';
				});
			});
			$(function() {
				var $withdrawExecuteBtn = $('#withdrawExecuteBtn');
				$withdrawExecuteBtn.click(function(e) {
					document.getElementById('withdrawPopup').style.display='none';
					document.getElementById('withdrawPopup2').style.display='';
					document.body.className='';
				});
			});
			
			//비활성화
			$(function() {
				var $deactivateBtn = $('#deactivateBtn');
				$deactivateBtn.click(function(e) {
					if(withdrawFlag==0){
						document.getElementById('deactivateExecuteDiv').style.display='';
						withdrawFlag=1;
					}
					else{
						document.getElementById('deactivateExecuteDiv').style.display='none';
						withdrawFlag=0;
					}
				});
			});
			
			
			//비활성화여부			
			$(function(){
				var $deactivatePwdBtn = $('#deactivatePwdBtn');
				$deactivatePwdBtn.click(function(e) {
					document.getElementById('deactivatePopup').style.display=''; 
					document.body.className='mpopup';
				});
			});
			
			//회원정보 수정 서브밋
			$(function() {
		        var $modifyButton = $("#modifyExecuteBtn");
			
		        $modifyButton.click(function(e) {
		     	  		$("#modifyForm").submit();
		          
		        });
		     });
			
			
			//비활성화 서브밋
			$(function() {
		        var $deactButton = $("#deactivateConfirmBtn");
			
		        $deactButton.click(function(e) {
		     		$("#deactivatePwdForm").submit();
		          
		        });
		     });
			
			
			//탈퇴
			$(function() {
		        var $withdrawButton = $("#withdrawExecuteBtn");
			
		        $withdrawButton.click(function(e) {
		     	 	$("#withdrawPwd").submit(); 
		          
		        });
		     });
			
		</script>
		<div id="withdrawPopup" style="display: none;">
		 <div class="popupLayer">
			  <div class="back"></div>
			  <iframe src='about:blank'  mce_src='about:blank' scrolling='no' frameborder='0' title="전체 아이프레임 영역"></iframe>
		 </div>
		<div class="popup_box" style="width: 350px; height: 120px; margin-top:-100px; margin-left:-200px;">
			<!-- 변경될 수 있는값은 html에서 작성 -->
			<iframe src='about:blank' mce_src='about:blank' scrolling='no' frameborder='0' title="팝업 아이프레임 영역"></iframe>
			<div class="popup_contents">
				<!-- popup_contents 안에서 자유 디자인 -->
				회원 탈퇴하시면, Bukku의 모든 서비스를 이용할 수 없습니다.
				정말 탈퇴하시겠습니까?<br />
				<div id="withdrawConfirmDiv">
					<form method="post" action="withdraw" id="withdrawExecuteFrm">	
						<input type="button" id="withdrawExecuteBtn"  class="btn btn-info" value="탈퇴">
					</form>
					<form method="" action="" id="cancelWithdrawFrm">
						<input type="button" id="cancelWithdrawBtn"  class="btn btn-info" value="취소">
					</form>
				</div>
			</div>
		</div>
	</div>
	
	
	<div id="withdrawPopup2" style="display: none;">
		 <div class="popupLayer">
			  <div class="back"></div>
			  <iframe src='about:blank'  mce_src='about:blank' scrolling='no' frameborder='0' title="전체 아이프레임 영역"></iframe>
		 </div>
		<div class="popup_box" style="width: 350px; height: 120px; margin-top:-100px; margin-left:-200px;">
			<!-- 변경될 수 있는값은 html에서 작성 -->
			<iframe src='about:blank' mce_src='about:blank' scrolling='no' frameborder='0' title="팝업 아이프레임 영역"></iframe>
			<div class="popup_contents">
				<!-- popup_contents 안에서 자유 디자인 -->
				정상적으로 회원탈퇴되었습니다.<br />
				<div id="withdrawConfirmDiv">
					<form method="" action="" id="withdrawConfirm">	
						<input type="button" id="withdrawConfirmBtn"  class="btn btn-info" value="확인">
					</form>
				</div>
			</div>
		</div>
	</div>
	
	
	<div id="deactivatePopup" style="display: none;">
		 <div class="popupLayer">
			  <div class="back"></div>
			  <iframe src='about:blank'  mce_src='about:blank' scrolling='no' frameborder='0' title="전체 아이프레임 영역"></iframe>
		 </div>
		<div class="popup_box" style="width: 350px; height: 120px; margin-top:-100px; margin-left:-200px;">
			<!-- 변경될 수 있는값은 html에서 작성 -->
			<iframe src='about:blank' mce_src='about:blank' scrolling='no' frameborder='0' title="팝업 아이프레임 영역"></iframe>
			<div class="popup_contents">
				<!-- popup_contents 안에서 자유 디자인 -->
				비활성화 되었습니다.<br />
				로그인 시 비활성화가 해제됩니다.
				<div id="deactivateConfirmDiv">
					<form method="post" action="deacti" id="deactivateConfirmFrm">
						<input type="button" id="deactivateConfirmBtn"  class="btn btn-info" value="확인">
					</form>
				</div>
			</div>
		</div>
	</div>
	
		<div id="allDiv">
			<div id="modifyDiv">
				<h1 id="modifyH1">회원정보 수정</h1>
				<form method="" action="" id="modifyFrm">
				<input type="button" id = "modifyBtn" class="btn btn-small btn-info" value="수정">
				</form>
				<div id="modifyExecuteDiv" style="display: none;">
					<form method="post" action="modifyUserInfo" id="modifyForm">
						<table id="modifyTable">
							<tr>
								<td>아이디</td>
								<td>${sessionScope.userPublicBean.id}</td>
							</tr>
							<tr>
								<td>기존 비밀번호</td>
								<td><input type="password" name="pwd" id="pwd" /></td>
							</tr>
							<tr>
								<td>변경할 비밀번호</td>
								<td><input type="password" name="pwd2" id="pwd2" /></td>
							</tr>
							<tr>
								<td>비밀번호 확인</td>
								<td><input type="password" name="pwd3" id="pwd3" /></td>
							</tr>
							<tr>
								<td>성별</td>
								<td><input type="radio" name="gender" value="man" />남자 <input
									type="radio" name="gender" value="woman" /> 여자</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td><input type="text" name="email" id="email" />@ <select
									name="emailAddr">
										<option value="@naver.com">naver.com</option>
										<option value="@daum.net">daum.net</option>
										<option value="@google.com">google.com</option>
										<option value="@nate.com">nate.com</option>
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
								<td colspan="2" id="bottomTd">
									<input type="button" value="수정" id="modifyExecuteBtn" class="btn btn-info" />
									<input type="reset" value="취소" id="cancelBtn" class="btn btn-info" />
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<br />
			<div id="deactivateDiv">
				<h1 id="deactivateH1">계정 비활성화</h1>	
				<hr />
				<table>
					<tr>
						<td>비활성화 한 계정은 로그인을 제외한 시스템이 제공하는<br /> 모든 서비스를 이용할 수 없게 됩니다.</td>
						<td><form method="get" action="deacti" id="modifyFrm"><input type="button" id = "deactivateBtn" class="btn btn-small btn-info" value="비활성화"></form></td>
					</tr>
				</table>
				<div id="deactivateExecuteDiv" style="display: none;">
					<form method="POST" action="deacti" id="deactivatePwdForm">
						비밀번호 <input type="password" name="pwd" id="deactivatePwd"/>
						<input type="button" id="deactivatePwdBtn" class="btn btn-info" value="입력">
					</form>
				</div>
			</div>
			<div id="withdrawDiv">
				<h1 id="withdrawH1">회원 탈퇴</h1>
				<input type="button" id = "withdrawBtn" class="btn btn-small btn-info" value="탈퇴">
				<div id="withdrawExecuteDiv"  style="display: none;">
					<form method="post" action="withdraw" id="withdrawPwd">
						비밀번호 <input type="password" name="pwd" id="withdrawPwd"/>
						<input type="button" id="inputPwdBtn" class="btn btn-info" value="입력">
					</form>
				</div>
			</div>
		</div>
			
</body>
</html>