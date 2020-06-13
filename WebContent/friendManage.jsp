<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bukku</title>
<link href="css/friendManage.css" rel="stylesheet" type="text/css"></link>
<script src="javascript/friendManage.js" type="text/javascript"
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
	<%@ include file="bukkuHeader.jsp"%>
	<script>
	  $(function() {
          var $acceptBtn = $('#acceptBtn');
          $acceptBtn.click(function(e){
             /* var form = document.getElementById("acceptForm"); */
             
            /*  form.submit();   */ 
          });
       });
	  
	  $(function() {
          var $refuseBtn = $('#refuseBtn');
          $refuseBtn.click(function(e){
             /* var form = document.getElementById("refuseForm"); */
            /*  form.submit();   */ 
          });
       });
	
	</script>
	<div id="allDiv">
		<div id="profileMain">
			<table>
				<tr>
					<td id="profileImage"><a href="#"><img
						src="${sessionScope.userPublicBean.profileImg}" /></a></td>
				</tr>
				<tr>
					<td id="profileName">${sessionScope.userPublicBean.name}</td>
				</tr>
			</table>
		</div>
		<br />
		<div id="friendManageDiv">
			<table id="friendManageTable">
				<tr>
					<td class="manageTitle" colspan="3">친구요청 수신
						<hr />
					</td>
				</tr>
				<c:forEach var ="receiveUser" items = "${receiveList}">
				<tr>
				
				
					<td rowspan="2"><a href="showUserPost?id=${receiveUser.id}"><img
							src="${receiveUser.profileImg}" class="profileM"></a>
					<td><strong>${receiveUser.name}</strong>님의 친구요청을 수락하시겠습니까?
					<td></td>
				</tr>
				<tr>
					<td class="manageBtn">	
						<a href="acceptFriend?id=${receiveUser.id}">
						<button class="btn btn-small btn-info"
							id="acceptBtn" type="button">
							<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>친구수락
						</button>
						</a>
					
						<a href="refuseFriend?id=${receiveUser.id}">
						<button class="btn btn-small btn-info" id="refuseBtn"
							type="button">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>거절
						</button>
						</a>				
					</td>
						
				</tr>
				</c:forEach>
				
			</table>
		</div>
		<br />
		<div id="friendManageDiv">
			<table id="friendManageTable">
				<tr>
					<td class="manageTitle" colspan="3">친구요청 전송
						<hr />
					</td>
				</tr>
				<c:forEach var ="requestUser" items = "${requestList}">
			
				<input type ="hidden" name ="requestUserId" id = "requestUserId" value="${requestUser.id}"/>
				<tr>
					<td rowspan="2"><a href="showUserPost?id=${requestUser.id}"><img
							src="${requestUser.profileImg}" class="profileM"></a>
					<td><strong>${requestUser.name}</strong>님에게 친구요청을 전송하였습니다.
					<td></td>
				</tr>
				<tr>
			
					<td class="manageBtn"><button class="btn btn-small btn-info"
							id="waitingBtn" >
							<span class="glyphicon glyphicon-user" aria-hidden="true"></span>친구수락대기
						</button>
						
						
						<a href="cancelFriend?requestUserId=${requestUser.id}">
						<button class="btn btn-small btn-info" id="cancelBtn" type="button">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>요청취소
						</button>
						</a>
						</td>
						
				</tr>
				
				</c:forEach>
			</table>
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