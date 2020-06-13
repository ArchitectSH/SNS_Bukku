<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bukku</title>
<link href="css/mypageList.css" rel="stylesheet" type="text/css"></link>
<script src="javascript/mypageList.js" type="text/javascript"
	charset="UTF-8"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
	<body>
		<%@ include file="bukkuHeader.jsp" %>
		<script>
			$(function() {
				var $friendButtons = $('button.btn-info');
	
				$friendButtons.click(function(e) {
					e.preventDefault();
					$(this).parent().find('ul.mypageButtons').toggle();
				});
			});
		</script>
		<div id="allDiv">
			<div id="profileMain">
				<table>
					<tr>
						<td id="profileImage"><a href=""><img src="${userPublicBean.profileImg}"/></a></td>
					</tr>
					<tr><td id="profileName">${ userPublicBean.name }</td></tr>
				</table>
			</div>
			<br/>
			<div id="userMadeMypageDiv">
			<span class="divTitle">내가 만든 페이지 </span>
			<hr>
			
			<c:forEach var="my" items="${ makeList}">
				<table class="mypageTb" id="mpage">
					<tr>
						<td rowspan="2"><a href="#"><img src="${my.img }" class="profileM"></a></td>
						<td colspan="2"><a href="page_main.do?title=${my.title }" class="nameB" id="mypageName">${my.title }</a></td>
					</tr>
				</table>
			</c:forEach>
			</div>
			
			<br>
	
			<div id="myMypageDiv">
			<span class="divTitle">팔로잉하는 페이지</span>
			<hr>
			
			<c:forEach var="fol" items="${ followList}">
				<table class="mypageTb" id="fpage">
					<tr>
						<td rowspan="2"><a href="#"><img src="${fol.img }" class="profileM"></a></td>
						<td colspan="2"><a href="follow_page_go.do?title=${fol.title }" class="nameB">${fol.title }</a></td>
					</tr>
					<tr>
					<td class="btnTd"><button class="btn btn-small btn-info"
							id="inviteBtn" type="button"><span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>팔로잉</button>
					<ul class="sub-wrapper mypageButtons">
									<li><a href="follow_page_go.do?title=${fol.title }">들어가기</a></li>
									<li><a href="cancel_list_follow.do?title=${fol.title }">팔로잉취소</a></li>
						</ul></td>
					</tr>
				</table>
			</c:forEach>
	
			</div>
			<div id="mymenu">
				<ul>
					<li><a href="myPage_list.do" class="mymenus" id="myPageList">페이지목록</a></li>
					<li><a href="myPage_Accept.do" class="mymenus" id="myPageInvite">페이지초대</a></li>
				</ul>
			</div>
		</div>
			
	</body>
</html>