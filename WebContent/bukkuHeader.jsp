<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Bukku</title>
		<link href="css/bukkuHeader.css" rel="stylesheet" type="text/css"></link>
		<script src = "javascript/bukkuHeader.js" type="text/javascript" charset="UTF-8"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
		   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		   <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	</head>
	<body>
		<!-- 페이지 만들기 -->
		<div id="all_popup" style="display: none;">
		 <div class="popupLayer">
			  <div class="back"></div>
			  <iframe src='about:blank'  mce_src='about:blank' scrolling='no' frameborder='0' title="전체 아이프레임 영역"></iframe>
		 </div>
		<div class="popup_box" style="width: 660px; height: 520px; margin-top:-220px; margin-left:-380px;">
			<!-- 변경될 수 있는값은 html에서 작성 -->
			<iframe src='about:blank' mce_src='about:blank' scrolling='no' frameborder='0' title="팝업 아이프레임 영역"></iframe>
			<div class="popup_contents">
				<!-- popup_contents 안에서 자유 디자인 -->
				<div id="mainDiv">
				<h1 id="makeH1">페이지 만들기</h1>
				<form method="post" action="make_page.do" id="makePageFrm">
						<table id="pageTable">
							<tr>
								<td>페이지 타이틀</td>
								<td><input type="text" name="myPageTitle" id="myPageTitle" /></td>
							</tr>
							<tr>
								<td>페이지 소개글</td>
								<td><textarea name="intro"></textarea></td>
							</tr>
							<tr>
								<td>페이지 사진</td>
								<td><input type="file" name="file" id="file"/></td>
							</tr>
							<tr>
								<td colspan="2" id="bottomTd">
									<input type="button" value="페이지 만들기" id="makeMyPageBtn" class="btn btn-default" />
									<input type="button" value="취소" id="cancelMyPageBtn" class="btn btn-default" />
								</td>
							</tr>
						</table>
					</form>
			</div>
			</div>
		</div>
	</div>
	
	<!-- 도움말 -->
	
	<div id="all_popup2" style="display:none;">
		 <div class="popupLayer">
		  <div class="back"></div>
		  <iframe src='about:blank'  mce_src='about:blank' scrolling='no' frameborder='0' title="전체 아이프레임 영역"></iframe>
		 </div>

		 <div class="popup_box" style="width:500px; height:500px; margin-left:-250px; margin-top:-250px; "> <!-- 변경될 수 있는값은 html에서 작성 -->
		  <iframe src='about:blank'  mce_src='about:blank' scrolling='no' frameborder='0' title="팝업 아이프레임 영역"></iframe>
		  <div class="popup_contents"><!-- popup_contents 안에서 자유 디자인 -->
		  	<div id="helpHeader"><img src="image/help.png"/><h1> Bukku Helper</h1>
		  	<button type="button" class="btn btn-default btn-sm" id="closePop">
  				<span class="glyphicon glyphicon-remove"></span>
			</button></div>
		  	<hr>
			<div class="panel-group" id="accordion">
			  <div class="panel panel-default">
			    <div class="panel-heading">
			      <h4 class="panel-title">
			        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
			         	 나의 소식 보기
			        </a>
			      </h4>
			    </div>
			    <div id="collapseOne" class="panel-collapse collapse in">
			      <div class="panel-body">
			      	내가 작성한 글이나 친구가 나에게 작성한 글, 친구가 나를 태그 한 글을 볼 수 있습니다~
			      </div>
			    </div>
			  </div>
			  <div class="panel panel-default">
			    <div class="panel-heading">
			      <h4 class="panel-title">
			        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
			          	그룹 이용하기
			        </a>
			      </h4>
			    </div>
			    <div id="collapseTwo" class="panel-collapse collapse">
			      <div class="panel-body">
			      	좋아하는 친구들과 그룹을 만들어 보세요! 그룹은 여러 사람과 업데이트, 사진 또는 문서를 공유하며 교류할 수 있는 공간입니다.
			      </div>
			    </div>
			  </div>
			  <div class="panel panel-default">
			    <div class="panel-heading">
			      <h4 class="panel-title">
			        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
			        	 마이페이지 이용하기
			        </a>
			      </h4>
			    </div>
			    <div id="collapseThree" class="panel-collapse collapse">
			      <div class="panel-body">
			      	나만의 마이페이지를 만들어 부끄 회원들에게 정보를 공유하고, 다른 부끄 회원들의 페이지를 팔로우 해서 정보를 얻어가세요!
			      </div>
			    </div>
			  </div>
			  <div class="panel panel-default">
			    <div class="panel-heading">
			      <h4 class="panel-title">
			        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapsefour">
			        	 친구 만들기
			        </a>
			      </h4>
			    </div>
			    <div id="collapsefour" class="panel-collapse collapse">
			      <div class="panel-body">
			      	오랫동안 연락하지 않은 친구, 나와 공통된 관심사가 많은 친구! 모두 Bukku를 통해 찾아보세요~
			      </div>
			    </div>
			  </div>
			  <div class="panel panel-default">
			    <div class="panel-heading">
			      <h4 class="panel-title">
			        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapsefive">
			        	 글 작성하기
			        </a>
			      </h4>
			    </div>
			    <div id="collapsefive" class="panel-collapse collapse">
			      <div class="panel-body">
			      	나의 소식에 나만의 글! 친구의 소식에 친구에게 남길글! 남겨보세요~ 아띠가 되는 지름길!!
			      </div>
			    </div>
			  </div>
			  <div class="panel panel-default">
			    <div class="panel-heading">
			      <h4 class="panel-title">
			        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapsesix">
			        	 설정하기
			        </a>
			      </h4>
			    </div>
			    <div id="collapsesix" class="panel-collapse collapse">
			      <div class="panel-body">
			      	내가 원하는 대로 환경설정을 할 수 있습니다~
			      </div>
			    </div>
			  </div>
			</div>
		  </div> 
		 </div>
		</div>
		
		<!-- 그룹 만들기 -->
		<div id="all_popup3" style="display: none;">
		 <div class="popupLayer">
			  <div class="back"></div>
			  <iframe src='about:blank'  mce_src='about:blank' scrolling='no' frameborder='0' title="전체 아이프레임 영역"></iframe>
		 </div>
		<div class="popup_box" style="width: 550px; height: 400px; margin-top:-220px; margin-left:-380px;">
			<!-- 변경될 수 있는값은 html에서 작성 -->
			<iframe src='about:blank' mce_src='about:blank' scrolling='no' frameborder='0' title="팝업 아이프레임 영역"></iframe>
			<div class="popup_contents">
				<!-- popup_contents 안에서 자유 디자인 -->
				<div id="mainDiv">
				<h1 id="makeH1">그룹 만들기</h1>
				<form method="" action="" id="makeGroupFrm">
						<table id="pageTable">
							<tr>
								<td>그룹 명</td>
								<td><input type="text" name="groupTitle" id="groupTitle" /></td>
							</tr>
							<tr>
								<td>그룹 공개여부</td>
								<td><input type="radio" name="open" value="public" />공개
									<input type="radio" name="open" value="private" />비공개  
								</td>
							</tr>
							<tr>
								<td colspan="2" id="bottomTd">
									<input type="button" value="그룹 만들기" id="makeGroupBtn" class="btn btn-default" />
									<input type="button" value="취소" id="cancelGroupBtn" class="btn btn-default" />
								</td>
							</tr>
						</table>
					</form>
			</div>
			</div>
		</div>
	</div>
	
		
		<!-- 건의사항 -->
		<div id="all_popup4" style="display: none;">
		 <div class="popupLayer">
			  <div class="back"></div>
			  <iframe src='about:blank'  mce_src='about:blank' scrolling='no' frameborder='0' title="전체 아이프레임 영역"></iframe>
		 </div>
		<div class="popup_box" style="width: 660px; height: 520px; margin-top:-220px; margin-left:-380px;">
			<!-- 변경될 수 있는값은 html에서 작성 -->
			<iframe src='about:blank' mce_src='about:blank' scrolling='no' frameborder='0' title="팝업 아이프레임 영역"></iframe>
			<div class="popup_contents">
				<!-- popup_contents 안에서 자유 디자인 -->
				<div id="mainDiv">
				<h1 id="opinionWrite">건의사항 작성</h1>
				<form method="" action="" id="opinionFrm">
						<table id="opinionTb">
							<tr>
								<td>건의사항 제목</td>
								<td><input type="text" name="opinionTitle" id="opinionTitle" /></td>
							</tr>
							<tr>
								<td>건의사항 내용</td>
								<td><textarea name="opinionContent"></textarea></td>
							</tr>
							<tr>
								<td colspan="2" id="bottomTd">
									<input type="button" value="건의사항 작성" id="writeOpinionBtn" class="btn btn-default" />
									<input type="button" value="취소" id="cancelOpinionBtn" class="btn btn-default" />
								</td>
							</tr>
						</table>
					</form>
			</div>
			</div>
		</div>
	</div>		
		
		<header id="titleHeader">
				<h1 id="title"><a href="home"><img src="image/title.jpg"></a></h1>
				<form id="searchForm" method="post" action="searchTotal">
					<input type="text" name="keyword" id="searchText" />
					<input type="image" src="image/search.jpg" id="searchBtn" />
				</form>
				<a href="myPost" id="#myNameA"><img src="${ userPublicBean.profileImg }" id="headerProfile"><span id="myName">${ userPublicBean.name }</span></a>
				<a href="home"><img src="image/home.jpg" class="topBtn"></a>
				<a href="myPost"><img src="image/myNews.jpg" class="topBtn"></a>
				<a href="friendManage" id="friendManage"><img src="image/friends.jpg" class="topBtn"></a>
				<a href="alarm.do" id="alarms"><img src="image/alarm.jpg" class="topBtn"></a>
				<a href="#" id="settings"><img src="image/config.jpg" class="topBtn"></a>
				
				<table class="sub-wrapper alarms">
					<tr id="alarmName">
						<td colspan="2">알림</td>
					</tr>
				</table>
				
				<!-- 환경설정 버튼누르면 나오는 메뉴 -->
				<ul class="sub-wrapper setting">
					<li><a href="#">환경설정</a></li>
					<li><a href="#" id="makePageA">페이지만들기</a></li>
					<li><a href="#" id="makeGroupA">그룹만들기</a></li>
					<li><a href="accountManage">계정관리</a></li>
					<li><a href="#" id="helpBtn">도움말</a></li>
					<li><a href="#" id="opinionBtn">건의사항</a></li>
					<li><a href="logout">로그아웃</a></li>
				</ul>
		</header>
			
			
			
			
			
		<section>
			<div id="menuContainer">
				<span id ="tab"></span> <!-- 사이드 바 탭을 위한 span -->
				<div id ="container"></div> <!-- 메뉴아이템 컨테이너용 div -->
			</div>
		</section>
	</body>
</html>