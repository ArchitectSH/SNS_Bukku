<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title>Bukku</title>
		<link href="css/myPageMain.css" rel="stylesheet" type="text/css"></link>
		<script src = "javascript/myPageMain.js" type="text/javascript" charset="UTF-8"></script>
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
		function scroll_follow2( id )
		{
		  $(window).scroll(function( )  //스크롤이 움직일때마다 이벤트 발생
		  { 
			  var position = $(window).scrollTop(); // 현재 스크롤바의 위치값을 반환합니다.
			  $( id ).stop().animate({top:position+230+"px"}, 0); //해당 오브젝트 위치값 재설정
		   });
		}
		scroll_follow2( "#searchPost" );
		//스크롤이 생기도록 <br> 을 여러게 넣은 부분..
			$(document).ready(function(){ for( var i=0; i<200; i++ ) {$('#brr').html($('#brr').html());} });
	
			$(function() {
				var $postMenu = $('a.postMenu');
				$postMenu.click(function(e) {
					e.preventDefault();
					$(this).parent().find('ul.postUl').toggle();
				});
			});
		</script>
		
			<div id="allDiv">	
			<!-- 마이페이지 프로필 정보 -->
			<div id="profileMain">
				<table>
					<tr>
						<td><input id="mypageImage" type="image" src="myPageImg/${myPageInfo.img }"/></td>
					</tr>
					<tr><td id="mypageTitle">${myPageInfo.title }</td></tr>
					<tr>
						<c:choose>
							<c:when test="${follow == true }">
								<td><a href="cancel_follow.do?title=${myPageInfo.title }"><button class="btn btn-small btn-info"
								id="cancleFollowBtn" type="button"><span class="glyphicon glyphicon-hand-down" aria-hidden="true"></span> 팔로잉취소</button></a>
								</td>
							</c:when>
							<c:otherwise>
								<td><a href="myPage_follow.do?title=${myPageInfo.title }"><button class="btn btn-small btn-info"
								id="followBtn" type="button"><span class="glyphicon glyphicon-hand-up" aria-hidden="true"></span> 팔로잉</button></a>
								</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</table>
				<div id="introduction">
					${myPageInfo.introduction }
				</div>
				<table id="followerTb">
					<tr>
						<td>팔로잉</td>
					</tr>
					<tr>
						<td id="followerNum">${myPageInfo.followerNum }</td>
					</tr>
				</table>
			</div>
			<div id="writeDiv">
				<form id="writeForm" method="post" action="">
					<textarea id="writeText"></textarea><br />
						<table id="writeTable">
							<tbody>
							<tr>
								<td rowspan="2"><input type="image" src="image/photo.jpg" id="imageBtn" /></td>
								<td rowspan="2"><input type="image" src="image/video.jpg" id="videoBtn" /></td>
								<td><input type="image" src="image/all.jpg" id="allBtn" /></td>
								<td><input type="image" src="image/friend.jpg" id="friendBtn" /></td>
								<td><input type="image" src="image/secret.jpg" id="secretBtn" /></td>
								<td rowspan="2" id="writeTd"><button class="btn btn-small btn-danger" id="writeBtn" type="button">게시</button></td>
							</tr>
							<tr>
								<td id="allTd">&nbsp;전체</td>
								<td id="friendTd">&nbsp;친구</td>
								<td id="secretTd">&nbsp;비밀</td>
							</tr>
							</tbody>
						</table>
				</form>				
			</div>
			<br />
			<div class="postDiv">
					<table>
						<tr>
							<td  rowspan="2" class="profileTd"><a href="#"><img src="${myPageInfo.img }" class="profile"></a></td>
							<td class="profileTd"><a href="#" class="nameA">${myPageInfo.title }</a></td>
							<td>
								<a href="#" class="postMenu">v</a>				
								<!-- v버튼 누르면 나오는 메뉴 -->
								<ul class="sub-wrapper postUl">
									<li><a href="#">수정하기</a></li>
									<li><a href="#">삭제하기</a></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="dateTd">2015.01.10 오후 3:12</td>
							<td class="public" colspan="2">전체공개</td>
						</tr>
					</table>
				<p>
					스티치<br>많이 사랑해주세용~
				</p>
				<table class="recommentTable">
					<tr>
						<td rowspan="2" class="commentTd">댓글 0개</td>
						<td rowspan="2" class="shareTd">&nbsp;공유 0개</td>
						<td><a href="#" class="likeA"><img src="image/like.jpg" class="likeBtn"></a></td>
						<td><a href="#" class="bukkuA"><img src="image/bukku.jpg" class="bukkuBtn"></a></td>
						<td><a href="#" class="hateA"><img src="image/hate.jpg" class="hateBtn"></a></td>
					</tr>
					<tr>
						<td colspan="2" class="likeNumTd">1,003</td>
						<td class="hateNumTd">&nbsp;45</td>
					</tr>
				</table>
			</div>
			<div class="commentDiv">
				<a href="#">댓글 더 보기 ▼</a><br />
				<table>
					<tr>
						<td rowspan="2"><a href="#"><img src="image/profile2.jpg" class="profile"></a></td>
						<td><a href="#">황희빈</a></td>
						<td class="dateCommentTd">2015.01.10 오후 3:12</td>
					</tr>
					<tr>
						<td colspan="2" class="recommendP">스티치 넘넘좋아요~</td>
					</tr>
				</table>

				<form id="writeCommentForm" method="post" action="">
					<table>
						<tr>
							<td rowspan="2"><a href="#"><img src="image/profile2.jpg" class="profile"></a></td>
							<td rowspan="2"><textarea class="commentText"></textarea></td>
							<td>비공개 <input type="checkbox"></td>
						</tr>
						<tr>
							<td ><button class="btn btn-small btn-info" id="writeBtn" type="button">작성</button></td>
						</tr>
					</table>
				</form>
			</div>
			<div id="mymenu">
	            <ul>
	               <li><a href="page_go.do?title=${myPageInfo.title }&follow=${follow}" class="mymenus" id="myPagePost">페이지글</a></li>
	            </ul>
 			</div>
			<div id="searchPost">
			<form id="searchPostForm" method="post" action="">
				<table>
					<tr>
						<td><input type="text" id="searchPostText" />
						<input type="image" src="image/searchPost.jpg" id="searchPostBtn"/></td>
					</tr>
					<tr>
						<td><input type="date" id="dateSearch"></td>
					</tr>
					<tr>
						<td><input type="date" id="dateSearch"></td>
					</tr>
					<tr>
						<td id="writeTd"><button type="button" class="btn btn-default" id="searchPostDateBtn">날짜검색</button></td>
					</tr>
				</table>
			</form>
			</div>
		</div>
			
	</body>
</html>