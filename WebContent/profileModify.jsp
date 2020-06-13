<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bukku</title>
<link href="css/profileModify.css" rel="stylesheet" type="text/css"></link>
<script src="javascript/profileModify.js" type="text/javascript"
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
	$(function() {
        var $modifyButton = $("#profileModifyBtn");
	
        $modifyButton.click(function(e) {
     	
     		$("#profileModifyFrm").submit();
          
        });
     });
	/* 
	<span ><img src="${userBean.profileImg}" class="profileM" id = "newImg" name="newImg"></span>
	
	<span><input type="file" name="file" id="fileImg" onChange="new preview()" ></span>
 */

	function preview(){
	  var tmp = new Image;
	 
	 	var img = $("#fileImg").val();
	/* 	alert(img.substr(12, img.length)); */
	 	  $("#newImg").attr("src","image/profileImg/"+img.substr(12,img.length));
	
	  };
	
	
	</script>
</head>
	<body>
		<%@ include file="bukkuHeader.jsp" %>
			
		<div id="allDiv">
			<div id="profileMain">
				<table>
					<tr>
						<td id="profileImage"><input type="image" src="${userBean.profileImg}" id="img"/></td>
					</tr>
					<tr><td id="profileName">${userBean.name}</td></tr>
				</table>
				<table id="profile">
					<tr><td id="profileInfo">${userBean.school}</td></tr>
					<tr><td id="profileInfo">${userBean.location}</td></tr>
					<tr><td id="profileInfo">
					<c:if test= "${userBean.gender==1}">남자</c:if>
					<c:if test= "${userBean.gender==2}">여자</c:if></td></tr>
				</table>
			</div>
			<br/>
			<div id="profileModifyDiv">
			<form method ="post" action="profileModify" id = "profileModifyFrm">
					<div id="profileModifyDiv2">
						<p id="profileModifyCaption">프로필수정</p>
						<hr>
						<div>						
							<span class="profileTitle">프로필사진</span>
							<span ><img src="${userBean.profileImg}" class="profileM" id = "newImg" name="newImg"></span>
							
							<span><input type="file" name="file" id="fileImg" onChange="new preview()" ></span>
						</div>
						<div>
							<span class="profileTitle">학교</span>
							<br/><br/>
							<span><select name="schoolArea">
									<option value="">학교지역</option>
									<option value="area1">서울시</option>
									<option value="area2">경기도</option>
									<option value="area3">함경도</option>
									<option value="area4">평안도</option>
									<option value="area5">강원도</option>
									<option value="area6">황해도</option>
									<option value="area7">충청도</option>
									<option value="area8">경상도</option>
									<option value="area9">전라도</option>
									<option value="area10">인천시</option>
									<option value="area11">제주시</option>
							</select>
							</span>
							<span><select name="school">
									<option value="">학교선택</option>
									<option value="banghakPri">방학초등학교</option>
									<!-- <option value="bundangMiddle">분당중학교</option> -->
									<option value="seonlinHigh">선린인터넷고등학교</option>
									<option value="soongsilUni">숭실대학교</option>
									<option value="shamyookUni">삼육대학교	</option>
									<option value="sechoHigh">서초고등학교</option>
									<option value="sechoMiddle">서초중학교</option>
									<option value="geongmoonHigh">경문고등학교</option>
							
							</select></span>
						</div>
						<div>
							<span class="profileTitle">거주</span>
							<br/><br/>
							<span><select name="location">
									<option value="area1">서울시</option>
									<option value="area2">경기도</option>
									<option value="area3">함경도</option>
									<option value="area4">평안도</option>
									<option value="area5">강원도</option>
									<option value="area6">황해도</option>
									<option value="area7">충청도</option>
									<option value="area8">경상도</option>
									<option value="area9">전라도</option>
									<option value="area10">인천시</option>
									<option value="area11">제주시</option>
							</select>
							</span>
						</div>
						<div id="bottomTd">
							<span>			
								<input type="button" value="수정" id="profileModifyBtn" class="btn btn-info"/>
							</span>
						</div>
					</div>
					</form>
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