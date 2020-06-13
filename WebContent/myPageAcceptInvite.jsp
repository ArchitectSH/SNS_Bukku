<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bukku</title>
<link href="css/myPageAcceptInvite.css" rel="stylesheet" type="text/css"></link>
<script src="javascript/myPageAcceptInvite.js" type="text/javascript"
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
	$(function(){
		var $acceptBtn = $("#acceptBtn");
		$acceptBtn.click(function(e) {
			$("#acceptFrm").submit();
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
	<br />
	<div id="friendManageDiv">
		<table id="friendManageTable">
			<tr>
				<td class="manageTitle" colspan="3">페이지초대요청 수신
					<hr />
				</td>
			</tr>
			<c:forEach var="info" items="${list}">
				<tr>
					<td rowspan="2"><a href="#"><img src="mypageImg/${info.img }"
							class="profileM"></a>
					</td>
					<td><strong>${info.title }</strong> 페이지 초대를 수락하시겠습니까?<td>
					</td>
				</tr>
				<tr>
					<td class="manageBtn">
						<a href="myPage_Accept_Invite.do?title=${info.title }"><button class="btn btn-small btn-info"
							id="acceptBtn" type="button"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span>초대수락</button></a>
						<a href="myPage_remove_Invite.do?title=${info.title }"><button class="btn btn-small btn-info" 
							id="refuseBtn" type="button"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>거절</button></a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br/>
	<div id="mymenu">
		<ul>
			<li><a href="myPage_list.do" class="mymenus" id="myPageList">페이지목록</a></li>
			<li><a href="myPage_Accept.do" class="mymenus" id="myPageInvite">페이지초대</a></li>
		</ul>
	</div>
	</div>

</body>
</html>