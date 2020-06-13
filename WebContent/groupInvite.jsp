<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bukku</title>
<link href="css/groupInvite.css" rel="stylesheet" type="text/css"></link>
<script src="javascript/groupInvite.js" type="text/javascript"
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
			<div id="profileMain">
				<table>
					<tr><td id="profileName">그룹이름</td></tr>
				</table>
			
			</div>
			<br/>
			<div id="myFriendsDiv">
			<table class="friendTb">
				<tr>
					<td rowspan="2"><a href="#"><img src="image/profileImg/profile1.jpg" class="profileM"></a></td>
					<td colspan="2"><a href="#" class="nameB">황희빈</a></td>
				</tr>
				<tr>
				<td class="btnTd"><button class="btn btn-small btn-info"
						id="inviteBtn" type="button"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>초대하기</button>		
					</td>
				</tr>
			</table>
		
			<table class="friendTb">
				<tr>
					<td rowspan="2"><a href="#"><img src="image/profileImg/profile2.jpg" class="profileM"></a></td>
					<td colspan="2"><a href="#" class="nameB">한정우</a></td>
				</tr>
				<tr>
				<td class="btnTd"><button class="btn btn-small btn-info"
						id="inviteBtn" type="button"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>초대하기</button></td>
				</tr>
			</table>
		
			<table class="friendTb">
				<tr>
					<td rowspan="2"><a href="#"><img src="image/profileImg/profile3.jpg" class="profileM"></a></td>
					<td colspan="2"><a href="#" class="nameB">이호준</a></td>
				</tr>
				<tr>
				<td class="btnTd"><button class="btn btn-small btn-info"
						id="inviteBtn" type="button"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>초대하기</button></td>
				</tr>
			</table>
		
			<table class="friendTb">
				<tr>
					<td rowspan="2"><a href="#"><img src="image/profileImg/profile4.jpg" class="profileM"></a></td>
					<td colspan="2"><a href="#" class="nameB">이언정</a></td>
				</tr>
				<tr>
				<td class="btnTd"><button class="btn btn-small btn-info"
						id="inviteBtn" type="button"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span> 초대중 </button></td>
				</tr>
			</table>
		
			<table class="friendTb">
				<tr>
					<td rowspan="2"><a href="#"><img src="image/profileImg/profile5.jpg" class="profileM"></a></td>
					<td colspan="2"><a href="#" class="nameB">장한이</a></td>
				</tr>
				<tr>
				<td class="btnTd"><button class="btn btn-small btn-info"
						id="inviteBtn" type="button"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span>초대중</button></td>
				</tr>
			</table>
		
			<table class="friendTb">
				<tr>
					<td rowspan="2"><a href="#"><img src="image/profileImg/profile6.jpg" class="profileM"></a></td>
					<td colspan="2"><a href="#" class="nameB">경수정</a></td>
				</tr>
				<tr>
				<td class="btnTd"><button class="btn btn-small btn-info"
						id="inviteBtn" type="button"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>초대하기</button></td>
				<!--친구버튼누르면 나오는 메뉴 -->
					
				</tr>
			</table>
			
			<table class="friendTb">
				<tr>
					<td rowspan="2"><a href="#"><img src="image/profileImg/profile1.jpg" class="profileM"></a></td>
					<td colspan="2"><a href="#" class="nameB">황희빈</a></td>
				</tr>
				<tr>
				<td class="btnTd"><button class="btn btn-small btn-info"
						id="inviteBtn" type="button"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>초대하기</button></td>
				</tr>
			</table>
			
			<table class="friendTb">
				<tr>
					<td rowspan="2"><a href="#"><img src="image/profileImg/profile2.jpg" class="profileM"></a></td>
					<td colspan="2"><a href="#" class="nameB">한정우</a></td>
				</tr>
				<tr>
				<td class="btnTd"><button class="btn btn-small btn-info"
						id="inviteBtn" type="button"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>초대하기</button></td>
				</tr>
			</table>
		
			<table class="friendTb">
				<tr>
					<td rowspan="2"><a href="#"><img src="image/profileImg/profile3.jpg" class="profileM"></a></td>
					<td colspan="2"><a href="#" class="nameB">이호준</a></td>
				</tr>
				<tr>
				<td class="btnTd"><button class="btn btn-small btn-info"
						id="inviteBtn" type="button"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>초대하기</button></td>
				</tr>
			</table>
		

			</div>

		
			<div id="mymenu">
				<ul>
					<li><a href="" class="mymenus" id="groupPost">그룹글</a></li>
					<li><a href="" class="mymenus" id="groupInvite">초대</a></li>
					<li><a href="" class="mymenus" id="groupApproval">가입승인</a></li>
					<li><a href="" class="mymenus" id="groupMember">그룹멤버</a></li>
					<li><a href="" class="mymenus" id="groupSetting">설정</a></li>
				</ul>
			</div>
		</div>
			
	</body>
</html>