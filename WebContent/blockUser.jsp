<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bukku</title>
<link href="css/blockUser.css" rel="stylesheet" type="text/css"></link>
<script src="javascript/blockUser.js" type="text/javascript"
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
	<script>
	$(function(){
	     var $unlock = $('#unlockBtn');
	     
	     $unlock.click(function(e) {
	     	alert("차단버튼 눌림");
	     	$("$cancelBlockForm").submit();
	     });
	});
	
	</script>
</head>
<body>
	<%@ include file="bukkuHeader.jsp" %>
	<div id="allDiv">
	<br/><br/><br/><br/>
	<div id="blockUserDiv">
		<table>
		<tr>
			<td id="blockTitle">
				차단한계정
			</td>
		</tr>
		<tr>
			<td>
				<strong>${user.name}</strong>님의 계정을 차단한 상태입니다.<br/>차단 해제 시키시겠습니까?
			</td>
		</tr>
		<tr>
			<td>
			<form method="GET" action="cancelBlockUser" id="cancelBlockForm">
				<input type="hidden" name="userId" value="${user.id}"/>
				<button class="btn btn-small btn-info" id="unlockBtn" type="button">차단해제</button>
				<button class="btn btn-small btn-info" id="cancelBtn" type="button">취소</button>
			</form>
			</td>
		</tr>
			
		</table>	
	</div>
	<br/>

	</div>

</body>
</html>