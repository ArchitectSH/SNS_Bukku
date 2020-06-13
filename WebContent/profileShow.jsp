<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bukku</title>
<link href="css/profileShow.css" rel="stylesheet" type="text/css"></link>
<script src="javascript/profileShow.js" type="text/javascript"
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

	<div id="allDiv">
	<br />
	<div id="profileSection" class="sectionDisplay">
		<div id="myProfile">
			<!-- 내 프로필 -->
			<table class="tb">
				<tr>
					<td><a href="#"><img src="${userBean.profileImg}"
							class="myProfile"></a></td>
				</tr>
				<tr>
					<td><a href="#" class="myName">${userBean.name}</a></td>
				</tr>
			</table>
		</div>
		<br />
		<a href="profileModify"><img src="image/modifyProfileButton.PNG" id="modifyProfileButton"></a>
		
	</div>
	<div id="mainSection" class="sectionDisplay">
		<div id="myProfileInfo">
			<!-- 프로필 정보들 -->
			<ul>
				<!--li하나에 프로필 하나씩-->
				<li class="profileInfo">${userBean.school}<c:if test="${userBean.school==null }">학교를 등록하지 않았습니다.</c:if></li>
				<li class="profileInfo">${userBean.location}<c:if test="${userBean.location==null }">지역을 등록하지 않았습니다.</c:if></li>
				<li class="profileInfo"><c:if test= "${userBean.gender==1}">남자</c:if>
					<c:if test= "${userBean.gender==2}">여자</c:if></li>
			</ul>
		</div>
	</div>
	<div id="mymenu">
				<ul>
					<li><a href="myPost" class="mymenus" id="myPost">소식</a></li>
					<li><a href="myProfile" class="mymenus" id="information">정보</a></li>
					<li><a href="friendList" class="mymenus" id="friendList">친구</a></li>
				</ul>
			</div>
	</div>
</body>
</html>
