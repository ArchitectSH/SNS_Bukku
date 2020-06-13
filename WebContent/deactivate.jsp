<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/deactivate.css" rel="stylesheet" type="text/css"></link>

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
	     var $acti = $('#actiBtn');
	     
	     $acti.click(function() {
	    	
	    	 $("#actiForm").submit();	   
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
				비활성화 계정
			</td>
		</tr>
		<tr>
			<td>
				<strong>${sessionScope.userPublicBean.name}</strong>님의 계정은 비활성화 상태입니다.<br/>다시 활성화 시키시겠습니까?
			</td>
		</tr>
		<tr>
			<td>
			<form method="POST" action="acti" id="actiForm">
				<input type="hidden" name="userId" value="${sessionScope.userPublicBean.name}"/>
				<button class="btn btn-small btn-info" id="actiBtn" type="button">활성화</button>
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