<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bukku</title>
<link href="css/myPageInvite.css" rel="stylesheet" type="text/css"></link>
<script src="javascript/myPageInvite.js" type="text/javascript"
	charset="UTF-8"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
	<body>
		<%@ include file="bukkuHeader.jsp" %>
		<div id="allDiv">
			<div id="menuContainer">
				<span id ="tab"></span> <!-- 사이드 바 탭을 위한 span -->
				<div id ="container"></div> <!-- 메뉴아이템 컨테이너용 div -->
			</div>
			<div id="profileMain">
				<table>
					<tr>
						<td><input id="profileImage" type="image" src="${myPageInfo.img }"/></td>
					</tr>
					<tr><td id="profileName">${myPageInfo.title }</td></tr>
				</table>
			
			</div>
			<br/>

			<div id="myFriendsDiv">
			<h2>팔로워</h2><hr>
			<c:forEach var="info" items="${list}">
			<table class="friendTb">
				<tr>
					<td rowspan="2"><a href="#"><img src="${info.profileImg }" class="profileM"></a></td>
					<td colspan="2"><a href="#" class="nameB">${info.name }</a></td>
				</tr>
				<tr>
				<td class="btnTd"><a href="inviting_friend.do?title=${myPageInfo.title }&id=${info.id}"><button class="btn btn-small btn-info"
						id="followBtn" type="button" disabled><span class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span> 팔로잉중</button>		
				</a></td>
				</tr>
			</table>
			</c:forEach>
			</div>
		
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