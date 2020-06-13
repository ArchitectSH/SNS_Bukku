<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bukku</title>
<link href="css/profileShowFriend.css" rel="stylesheet" type="text/css"></link>
<script src="javascript/profileShowFriend.js" type="text/javascript"
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
	<div id="profileSection" class="sectionDisplay">
		<div id="myProfile">
			<!-- 내 프로필 -->
			<table class="tb">
				<tr>
					<td><a href="#"><img src="${friendInfo.friendProfileImg}"
							class="myProfile"></a></td>
				</tr>
				<tr>
					<td><a href="#" class="myName">${friendInfo.friendName}</a></td>
				</tr>
			</table>
		</div>
		<br />
	</div>
	<div id="mainSection" class="sectionDisplay">
		<div id="myProfileInfo">
			<!-- 프로필 정보들 -->
			<ul>
				<!--li하나에 프로필 하나씩-->
				<li class="profileInfo">${friendInfo.friendSchool}<c:if test="${friendInfo.friendSchool==null }">학교를 등록하지 않았습니다.</c:if></li>
				<li class="profileInfo">${friendInfo.friendLocation}<c:if test="${friendInfo.friendLocation==null }">지역을 등록하지 않았습니다.</c:if></li>
				<li class="profileInfo"><c:if test= "${friendInfo.friendGender==1}">남자</c:if>
					<c:if test= "${friendInfo.friendGender==2}">여자</c:if></li>
			</ul>
		</div>
	</div>
	
	<br/>
	<div id="bukkuInfoDiv">
			<!--부끄 정보들 --><span id="bukkuInfoTitle">부끄지수 확인</span>
			<table>
				<tr>
					<td>부끄단계</td>
					<td id="bukkuLevel">${friendInfo.bukkuLevel }</td>
				</tr>
				<tr>
					<c:choose>
						<c:when test="${friendInfo.bukkuLevel == '아띠' }">
							<td><strong>진정한 친구가 되었습니다. 친구의 활동이 강조됩니다!</strong></td>
						</c:when>
						<c:otherwise>
							<td><strong>'${friendInfo.nextBukkuLevel }'</strong>가 되려면?</td>
							<td><span>${friendInfo.needCommunicationCnt}</span>번의 교류가 더 필요합니다.</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</table>
	</div>
	<div id="bukkuShowDiv"><!--부끄 정보들 이미지로 보여주기 -->
			<p id="bukkuInfoTitle">부끄단계</p>
			<div id="bukkuShowChoiceDiv">
			<c:choose>
				<c:when test="${friendInfo.bukkuLevel == '이제 막 친구가 된 사이' }">
					<img class="bukkuLevelChoice" src="image/bukkuLevelChoice.png">
				</c:when>
				<c:when test="${friendInfo.bukkuLevel == '어색한 친구 사이' }">
					<img class="bukkuLevelChoice" style="margin-left:110px;" src="image/bukkuLevelChoice.png">
				</c:when>
				<c:when test="${friendInfo.bukkuLevel == '서로를 알아가는 사이' }">
					<img class="bukkuLevelChoice" style="margin-left:220px;" src="image/bukkuLevelChoice.png">
				</c:when>
				<c:when test="${friendInfo.bukkuLevel == '터울없는 사이' }">
					<img class="bukkuLevelChoice" style="margin-left:340px;" src="image/bukkuLevelChoice.png">
				</c:when>
				<c:otherwise>
					<img class="bukkuLevelChoice" style="margin-left:455px;" src="image/bukkuLevelChoice.png">
				</c:otherwise>
			</c:choose>
			</div>
			<img id="bukkuFirstImg" src="image/bukkuLevel1.jpg">
			<img src="image/bukkuLevel2.jpg">
			<img src="image/bukkuLevel3.jpg">
			<img src="image/bukkuLevel4.jpg">
			<img src="image/bukkuLevel5.jpg">			
	</div>
	<div id="mymenu">
		<ul>
			<li><a href="showUserPost?id=${friendInfo.friendId }" class="mymenus" id="myPost">소식</a></li>
					<li><a href="myProfile" class="mymenus" id="information">정보</a></li>
					<li><a href="friendList" class="mymenus" id="friendList">친구</a></li>
		</ul>
	</div>
	</section>
</div>
</body>
</html>