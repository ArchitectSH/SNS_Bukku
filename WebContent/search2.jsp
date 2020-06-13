<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<!-- 친구추가하면 바뀌는버튼 -->
<table>
	<tr>
		<td class="btnTd" id = "waitingFriendBtnTd"><button class="btn btn-small btn-info" id="waitingFriendBtn" type="button">																						
			<div id ="btnDiv"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>친구수락대기</div></button>	
		</td>
	</tr>
	<tr>
		<td class="btnTd" id = "removingFriendBtnTd"><button class="btn btn-small btn-info" id="removingFriendBtn" type="button">																						
			<div id ="btnDiv"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>친구끊는중</div></button>	
		</td>
	</tr>
		<tr>
		<td class="btnTd" id = "blockingFriendBtnTd"><button class="btn btn-small btn-info" id="blockingFriendBtn" type="button">																						
			<span class="glyphicon glyphicon-user" aria-hidden="true"></span>회원차단중</button>	
		</td>
	</tr>
	<tr>
		<td class="btnTd" id = "addFriendBtnTd">
		<form action="addFriend" method="post">
			<input type="hidden" id ="userId" name="userId" value="${user.id}"/>
			<button class="btn btn-small btn-info" id="addFriendBtn" type="button">																						
				<div id="btnDiv"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>친구추가</div>
			</button>
		</form>
		</td>	
	</tr>
	
	
	
	<!-- 테스트 -->
	<div id = "friendDiv">
	<button class="btn btn-small btn-info" id="inviteBtn" type="button">
						<span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>변경친구</button>
						<ul class="sub-wrapper friendButtons">	
						<form method="POST" action ="#">
							<input type="hidden" id ="userId" name="userId" value="${user.id}"/>
								<li><a href="#" id ="blockBtn">회원차단</a></li>
						</form>
					
						<form method="POST" action ="#">
							<input type="hidden" id ="userId" name="userId" value="${user.id}"/>
								<li><a href="#" id ="removeBtn">친구끊기</a></li>
						</form>
					</ul>	
			</div>	
			
			<div id ="none"></div>
			<c:when test="${friend == 'true'}">											
				<td class="btnTd ffriendBtnTd friendBtnTd" id = "friendBtnTd">
				<button class="btn btn-small btn-info ffriendBtn" id="friendBtn" type="button">																						
					<div id ="fbtnDiv" class = "friendBtn"><span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>친구</div></button>	
					<ul class="sub-wrapper friendButtons">
							<form method="POST" action ="#" class ="friendBtnTd">
								<input type="hidden" id ="userId" name="userId" value="${user.id}"/>
									<li><a href="#" id ="blockBtn" class="friendBtn"><div id ="btnDiv">회원차단</div></a></li>
							</form>
						
							<form method="POST" action ="#" class ="friendBtnTd">
								<input type="hidden" id ="userId" name="userId" value="${user.id}"/>
									<li><a href="#" id ="removeBtn" class="friendBtn"><div id ="btnDiv">친구끊기</div></a></li>
							</form>
						</ul>													
					</td>
				</c:when>

			
				<c:when test="${friend == 'true'}">											
					<td class="btnTd" id = "friendBtnTd">
					<button class="btn btn-small btn-info" id="friendBtn" type="button">																						
						<div id ="btnDiv"><span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>친구</div></button>	
						<ul class="sub-wrapper friendButtons">
								<form method="POST" action ="#">
									<input type="hidden" id ="userId" name="userId" value="${user.id}"/>
										<li><a href="#" id ="blockBtn">회원차단</a></li>
								</form>
							
								<form method="POST" action ="#">
									<input type="hidden" id ="userId" name="userId" value="${user.id}"/>
										<li><a href="#" id ="removeBtn">친구끊기</a></li>
								</form>
							</ul>													
						</td>
					</c:when>
					
					
					
					<c:when test="${requestState == 'true'}">												 										
					<td class="btnTd"><button class="btn btn-small btn-info" id="requestFriendBtn" type="button">																						
						<div id ="btnDiv"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>친구수락대기</div></button>	
					</td>
					</c:when>
					
					<c:when test="${blockingState == 'true'}">	
														
					<td class="btnTd" id = "cancelBlockUserBtnTd">
					 <form action="#" method="post">
						<input type="hidden" id ="userId" name="userId" value="${user.id}"/>	
						<button class="btn btn-small btn-info" id="cancelBlockUserBtn" type="button">																						
						<div id ="btnDiv"><span class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span>차단해제</div></button>	
					</form>
					</td>
					</c:when>
					
					
					
					<c:otherwise>
					<td class="btnTd" id = "addFriendBtnTd">
					<form action="addFriend" method="post">
						<input type="hidden" id ="userId" name="userId" value="${user.id}"/>
						<button class="btn btn-small btn-info" id="addFriendBtn" type="button">																						
							<div id="btnDiv"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>친구추가</div>
						</button>
					</form>
					</td>						
					</c:otherwise>
</table>

</body>
</html>