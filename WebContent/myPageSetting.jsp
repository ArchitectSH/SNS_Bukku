<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title>Bukku</title>
		<link href="css/myPageSetting.css" rel="stylesheet" type="text/css"></link>
		<script src = "javascript/myPageSetting.js" type="text/javascript" charset="UTF-8"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
		   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		   <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	</head>
	<body>
		<%@ include file="bukkuHeader.jsp" %>
		
		<script>
		function scroll_follow( id )
		{
		  $(window).scroll(function( )  //스크롤이 움직일때마다 이벤트 발생
		  { 
			  var position = $(window).scrollTop(); // 현재 스크롤바의 위치값을 반환합니다.
			  $( id ).stop().animate({top:position+100+"px"}, 0); //해당 오브젝트 위치값 재설정
		   });
		}
		scroll_follow( "#profileMain" );
		scroll_follow( "#mymenu" );
		//스크롤이 생기도록 <br> 을 여러게 넣은 부분..
			$(document).ready(function(){ for( var i=0; i<200; i++ ) {$('#brr').html($('#brr').html());} });
	
			$(function() {
				var $postMenu = $('a.postMenu');
				$postMenu.click(function(e) {
					e.preventDefault();
					$(this).parent().find('ul.postUl').toggle();
				});
			});
		//폐지신청 팝업
		$(function() {
			var $helpBtn = $('#removeBtn');
			$helpBtn.click(function(e) {
				document.getElementById('removePopup').style.display=''; 
				document.body.className='mpopup';
			});
		});
		$(function() {
			var $cancelBtn = $('#cancelremovePageBtn');
			$cancelBtn.click(function(e) {
				document.getElementById('removePopup').style.display='none'; 
				document.body.className='';
			});
		});
		//변경하기 할때
		$(function(){
			var $changeIntroBtn = $("#changeIntroBtn");
			$changeIntroBtn.click(function(e) {
				var intro = $("#changeIntroText").val();
				if(intro=="pageRemoveFrm"){
					alert("페이지 소개글을 입력해 주세요!");
				}
				else{
					$("#settingFrm").submit();
				}
			});	
		});
		//폐지 비밀번호 확인
		$(function(){
			var $changeIntroBtn = $("#removePageBtn");
			$changeIntroBtn.click(function(e) {
				var pwInput = $("#passwordInput").val();
				var pwCheck = $("#passwordCheck").val();
				if(pwInput==""){
					alert("비밀번호를 입력해 주세요!");
				}
				else if(pwCheck==""){
					alert("비밀번호 확인을 입력해주세요!")
				}
				else if(pwInput != pwCheck){
					alert("비빌번호와 비밀번호 확인을 동일하게 입력해주세요!")
				}
				else{
					$("#pageRemoveFrm").submit();
				}
			});	
		});
		</script>
			<div id="removePopup" style="display: none;">
				<div class="popupLayer">
					 <div class="back"></div>
					 <iframe src='about:blank'  mce_src='about:blank' scrolling='no' frameborder='0' title="전체 아이프레임 영역"></iframe>
				</div>
				<div class="popup_box" style="width: 350px; height: 400px; margin-top:-220px; margin-left:-380px;">
					<!-- 변경될 수 있는값은 html에서 작성 -->
					<iframe src='about:blank' mce_src='about:blank' scrolling='no' frameborder='0' title="팝업 아이프레임 영역"></iframe>
					<div class="popup_contents">
						<!-- popup_contents 안에서 자유 디자인 -->
						<div id="mainDiv">
						<h1 id="makeH1">폐지신청</h1>
						<form method="post" action="remove_page.do" id="pageRemoveFrm">
							<input type="hidden" id="hiddenTitle" name="hiddenTitle" value="${myPageInfo.title }"/>
								<table id="pageTable">
									<tr>
										<td>비밀번호</td>
										<td><input type="password" name="passwordInput" class="password" id="passwordInput" /></td>
									</tr>
									<tr>
										<td>비밀번호 확인</td>
										<td><input type="password" name="passwordCheck" class="password" id="passwordCheck" /></td>
									</tr>
									<tr>
										<td colspan="2" id="bottomTd">
											<input type="button" value="폐지하기" id="removePageBtn" class="btn btn-default" />
											<input type="button" value="취소" id="cancelremovePageBtn" class="btn btn-default" />
										</td>
									</tr>
								</table>
							</form>
					</div>
					</div>
				</div>
			</div>
			<div id="allDiv">	
			<!-- 마이페이지 프로필 정보 -->
			<div id="profileMain">
				<table>
					<tr>
						<td><input id="mypageImage" type="image" src="${myPageInfo.img }"/></td>
					</tr>
					<tr><td id="mypageTitle">${myPageInfo.title }</td></tr>
				</table>
			</div>
			<div id="settingDiv">
				<form id="settingFrm" method="post" action="setting_intro_page.do">
				<input type="hidden" id="hiddenTitle" name="hiddenTitle" value="${myPageInfo.title }"/>
					<table id="settingTb">
						<tr><td><h2>설정</h2></td></tr>
						<tr><td><h4>소개글 수정</h4></td></tr>
						<tr><td><textarea rows="50" id="changeIntroText" name="changeIntroText">${myPageInfo.introduction }</textarea></td></tr>
						<tr><td id="changeIntro"><button type="button" class="btn btn-default" id="changeIntroBtn">변경하기</button></td></tr>
						<tr><td><h4>페이지 폐지하기</h4></td></tr>
						<tr>
							<td id="remove"><button type="button" class="btn btn-default" id="removeBtn">폐지신청</button></td>
						</tr>
					</table>
				</form>				
			</div>
			<br />
			<div id="mymenu">
	            <ul>
	               <li><a href="page_main.do?title=${myPageInfo.title }" class="mymenus" id="myPagePost">페이지글</a></li>
	               <li><a href="invite_page.do?title=${myPageInfo.title }&masterId=${myPageInfo.masterId }" class="mymenus" id="mypageInvite">초대</a></li>
	               <li><a href="set_page.do?title=${myPageInfo.title }" class="mymenus" id="mypageSetting">설정</a></li>
	            </ul>
 			</div>
		</div>
	</body>
</html>