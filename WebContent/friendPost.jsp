<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>Bukku</title>
		<link href="css/friendPost.css" rel="stylesheet" type="text/css"></link>
		<script src = "javascript/frinedPost.js" type="text/javascript" charset="UTF-8"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
		  <link href='http://fonts.googleapis.com/css?family=Sigmar+One' rel='stylesheet' type='text/css'>
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">

	</head>
	<body>
		<%@ include file="bukkuHeader.jsp" %>
		<script>
			$(function() {
				var $postMenu = $('a.postMenu');
				$postMenu.click(function(e) {
					e.preventDefault();
					$(this).parent().find('ul.postUl').toggle();
				});
			});
			
			/*$(function() {
				var $modifyBtn = $('a.modifyPostA');
				$modifyBtn.click(function(e) {
					document.getElementByClass('modifyForm').style.display='';
				});
			});*/
			
			$(function(){
				$allBtn = $('img.allBtn');
				$allBtn.click(function(e){
					document.getElementById('privacyLevel').value="1";
					$allBtn.attr('src','image/selectedAll.png');
					$friendBtn = $('img.friendBtn');
					$friendBtn.attr('src','image/friend.png');
					$secretBtn = $('img.secretBtn');
					$secretBtn.attr('src','image/secret.png');
				});
			});
			$(function(){
				$friendBtn = $('img.friendBtn');
				$friendBtn.click(function(e){
					document.getElementById('privacyLevel').value="2";
					$friendBtn.attr('src','image/selectedFriend.png');
					$allBtn = $('img.allBtn');
					$allBtn.attr('src','image/all.png');
					$secretBtn = $('img.secretBtn');
					$secretBtn.attr('src','image/secret.png');
				});
			});
			
			/*$(function(){
				var $writeCommentBtn = $('button.btn.btn-small.btn-info.writeCommentBtn');
				$writeCommentBtn.click(function(e) {
					document.getElementById('.writeCommentForm').submit();
				});
			});*/
			
			$(function() {
				$('button.btn.btn-small.btn-info.writeCommentBtn').click(function() {
					var $this = $(this);
					var str = $(this).parents().parents().parents().serialize();
					// alert(str);
					$.ajax({
						type:"POST",
						url: "writeComment",
						//contentType: "application/x-www-form-urlencoded; charset=utf-8",
						data: str,
						datatype:"json", 
						success: function(data, status, xhr) {
							// console.log(data); // 이건 지금 데이터가 넘오온 값을 담은 변수이고
							// $table = $this.parents('.commentDiv').find('table:not(.addComment)');
							$addComment = $this.parents('.commentDiv').find('div._addComment');
							$newComment = "<table><tr><td rowspan='2'><a href=''#''><img src="+data.img+" class='profile'></a>"
															+"</td><td><a href=''#'>"+data.writer+"</a></td><td class='dateCommentTd'>"+data.commentDate
															+"<input type='hidden' class='commentNoHidden' value="+data.commentNo+" />"+"<a href='#' id='newEditComment'><img src='image/edit.JPG' id='editCommentImg'/></a>" 
															+" <button class='deleteCommentBtn'>X</button></td>"
															+"</tr><tr><td colspan='2' class='recommendP'>"+data.content+"</td></tr></table>";
							$addComment.append($newComment).hide().slideDown(500);
							$commentCount = $this.parents('div.commentDiv').siblings('div.postDiv').filter(':eq(0)').find('span.commentCount');
							var count = parseInt($commentCount.text())+1;
							$commentCount.text(count);
						},
						error: function(e) {
							console.log(e);
						}			
					});
				});
			});
			
			$(function() { //좋아 버튼
				$('input.likeBtn').click(function(){
//					$postNo = $(this).parents('.postDiv').find('input.recommendHidden').val();
					$this = $(this);
					$str = "postNo="+$this.parents('.postDiv').find('input.postNoHidden').val()+"&recommendKind=1";
					$.ajax({
						type:"GET",
						url: "recommendPost",
						//contentType: "application/x-www-form-urlencoded; charset=utf-8",
						data: $str,
						success: function(data, status, xhr) {
							$likeBukkuDiv = $this.parents('.recommendTable').find('div');
							var likeBukkuNum=parseInt($likeBukkuDiv.text());
							if($this.attr("src")=="image/like.jpg"){
								likeBukkuNum = parseInt($likeBukkuDiv.text())+1;
								$likeBukkuDiv.html(likeBukkuNum);
								$this.attr("src","image/selectedLike.jpg");
							}else{
								likeBukkuNum = parseInt($likeBukkuDiv.text())-1;
								$likeBukkuDiv.html(likeBukkuNum);
								$this.attr("src","image/like.jpg");
							}
						},
						error: function(e) {
							alert("에러발생");
						}			
					});
					
				});
			});
			
			$(function() { //부끄 버튼
				$('input.bukkuBtn').click(function(){
//					$postNo = $(this).parents('.postDiv').find('input.recommendHidden').val();
					$this = $(this);
					$str = "postNo="+$this.parents('.postDiv').find('input.postNoHidden').val()+"&recommendKind=2";
					$.ajax({
						type:"GET",
						url: "recommendPost",
						//contentType: "application/x-www-form-urlencoded; charset=utf-8",
						data: $str,
						success: function(data, status, xhr) {
							$likeBukkuDiv = $this.parents('.recommendTable').find('div');
							var likeBukkuNum=parseInt($likeBukkuDiv.text());
							if($this.attr("src")=="image/bukku.jpg"){
								likeBukkuNum = parseInt($likeBukkuDiv.text())+1;
								$likeBukkuDiv.html(likeBukkuNum);
								$this.attr("src","image/selectedBukku.jpg");
							}else{
								likeBukkuNum = parseInt($likeBukkuDiv.text())-1;
								$likeBukkuDiv.html(likeBukkuNum);
								$this.attr("src","image/bukku.jpg");
							}
						},
						error: function(e) {
							alert("에러발생");
						}			
					});
					
				});
			});
			
			
			$(function() { //글쎄 버튼
				$('input.hateBtn').click(function(){
//					$postNo = $(this).parents('.postDiv').find('input.recommendHidden').val();
					$this = $(this);
					$str = "postNo="+$this.parents('.postDiv').find('input.postNoHidden').val()+"&recommendKind=3";
					$.ajax({
						type:"GET",
						url: "recommendPost",
						//contentType: "application/x-www-form-urlencoded; charset=utf-8",
						data: $str,
						success: function(data, status, xhr) {
							$likeBukkuDiv = $this.parents('.recommendTable').find('span.hateNumSpan');
							var likeBukkuNum=parseInt($likeBukkuDiv.text());
							if($this.attr("src")=="image/hate.jpg"){
								likeBukkuNum = parseInt($likeBukkuDiv.text())+1;
								console.log($likeBukkuDiv);
								$likeBukkuDiv.html(likeBukkuNum);
								$this.attr("src","image/selectedHate.jpg");
							}else{
								likeBukkuNum = parseInt($likeBukkuDiv.text())-1;
								$likeBukkuDiv.html(likeBukkuNum);
								$this.attr("src","image/hate.jpg");
							}
						},
						error: function(e) {
							alert("에러발생");
						}			
					});
					
				});
			});
			
			$(function(){ //글 수정(수정 폼 불러오는)
				$('button.modifyPostBtn').click(function(){
					$this = $(this);
					$modifyDiv = $this.parents('div').children('div.modifyDiv');
					$modifyDiv.show();
					$this.parents('div').children('table.postTable').hide();
					$this.parents('div').children('p.postContent').hide();
					$this.parents('div').children('table.recommendTable').hide();
					var text = $this.parents('div').children('p.postContent').text();
					text = text.trim();
					$modifyText = $modifyDiv.children().children('textarea.modifyText');
					$modifyText.html(text);
				});
			});
			
			/*$(function(){ //글 수정(진짜 수정)
				$('button.modifyBtn').click(function(){
					$this = $(this);
					$modifyDiv = $this.parents('div').children('div.modifyDiv');
					$modifyDiv.show();
					$this.parents('div').children('table.postTable').hide();
					$this.parents('div').children('p.postContent').hide();
					$this.parents('div').children('table.recommendTable').hide();
					var text = $this.parents('div').children('p.postContent').text();
					text = text.trim();
					$modifyText = $modifyDiv.children().children('textarea.modifyText');
					$modifyText.html(text);
				});
			});*/
			
			$(function(){ //글 삭제
				$('button.deletePostBtn').click(function(){
					$this = $(this);
					$str = "postNo="+$this.parents('.postDiv').find('input.postNoHidden').val();
					
					var retVal = confirm("정말로 삭제 하시겠습니까?");
					if(retVal==true){
						$.ajax({
							type:"GET",
							url: "deletePost",
							//contentType: "application/x-www-form-urlencoded; charset=utf-8",
							data: $str,
							success: function(data, status, xhr) {
								$this.parents('.postDiv').siblings('.commentDiv').filter(':eq(0)').remove();
								$this.parents('.postDiv').remove();
							},
							error: function(e) {
								alert("에러발생");
							}			
						});
					}
				});
			});
			
				$(function(){ //댓글 삭제
					$('button.deleteCommentBtn').click(function(){
						$this = $(this);
						$str = "commentNo="+$this.parents('table').find('input.commentNoHidden').filter(':eq(0)').val();
						//alert($this.parents().find('input.commentNoHidden').val());
						var retVal = confirm("정말로 삭제 하시겠습니까?");
						if(retVal==true){
							$.ajax({
								type:"GET",
								url: "deleteComment",
								//contentType: "application/x-www-form-urlencoded; charset=utf-8",
								data: $str,
								success: function(data, status, xhr) {
									$this.parents('table').filter(':eq(0)').hide();
									$commentCount = $this.parents('div.commentDiv').siblings('div.postDiv').filter(':eq(0)').find('span.commentCount');
									var count = parseInt($commentCount.text())-1;
									$commentCount.text(count);
								},
								error: function(e) {
									alert("에러발생");
								}			
							});
						}
					});
				});
				
				$(function(){
					$('#searchPostBtn').click(function(){
							$('#searchPostForm').submit();
					});
				});
			
		</script>
			<div id="allDiv">
				<div id="profileMain">
				<table>
					<tr>
						<td id="profileImage"><img src="${userBean.profileImg}"/></td>
					</tr>
					<tr><td id="profileName">${ userBean.name }</td></tr>
				</table>
				<table id="profile">
					<c:if test="${userBean.school!=null}"><tr><td class="profileInfo">${userBean.school}</td></tr></c:if>
					<c:if test="${userBean.location!=null}"><tr><td class="profileInfo">${userBean.location}출신</td></tr></c:if> 
					<c:if test="${userBean.gender==1}"><tr><td class="profileInfo">남자</td></tr></c:if>
					<c:if test="${userBean.gender==2}"><tr><td class="profileInfo">여자</td></tr></c:if>
					<c:if test="${limitPrivacy>=2}">
					<tr><td id="bukkuLevelTd">부끄 단계</td></tr>
					<tr><td id="bukkuLevelTd2">${bukkuLevel}</td></tr>
					<tr><td>
							<c:if test="${bukkuLevel=='이제 막 친구가 된 사이'}"><img src="image/humanBukkuLevel1.png" /></c:if>
							<c:if test="${bukkuLevel=='어색한 친구사이'}"><img src="image/humanBukkuLevel2.png" /></c:if>
							<c:if test="${bukkuLevel=='서로를 알아가는 사이'}"><img src="image/humanBukkuLevel3.png" /></c:if>
							<c:if test="${bukkuLevel=='터울없는 사이'}"><img src="image/humanBukkuLevel4.png" /></c:if>
							<c:if test="${bukkuLevel=='아띠'}"><img src="image/humanBukkuLevel5.png" style="width:200px; height:193px;"/></c:if>
							</td>
					</tr>
					</c:if>
				</table>
			</div>
			<br/>
				<c:if test="${limitPrivacy>=2}">
				<div id="writeDiv">
					<form id="writeForm" method="post" action="writeGuestPost" enctype="multipart/form-data">
						<input type="hidden" name="privacyLevel" id="privacyLevel" value="2">
						<input type="hidden" name="currentPage" value="myPost">
						<input type="hidden" name="guestId" value="${userBean.id}">
						<textarea id="writeText" name="contents"></textarea><br />
							<table id="writeTable" >
								<tbody>
								<tr>
									<td rowspan="2"><input type="file" name="f1" id="f1"/><img src="image/photo.jpg" id="imageBtn"></td>
									<td rowspan="2"><input type="file" name="f2" id="f2"/><img src="image/video.jpg" id="videoBtn"></td>
									<td><a href="#"><img src="image/all.png" class="allBtn" /></a></td>
									<td><a href="#"><img src="image/friend.png" class="friendBtn" /></a></td>
									<td rowspan="2" id="writeTd"><button class="btn btn-small btn-danger writeBtn">게시</button></td>
								</tr>
								<tr>
									<td class="allTd">&nbsp;전체</td>
									<td class="friendTd">&nbsp;친구</td>
								</tr>
								</tbody>
							</table>
					</form>				
				</div>
				</c:if>
				<br />
				<c:forEach var="postAllInfoBean" items="${ myPosts }">

					<c:if test="${!postAllInfoBean.block&&(postAllInfoBean.postingViewBean.id==userPublicBean.id||postAllInfoBean.postingViewBean.privacyLevel<=limitPrivacy||(postAllInfoBean.commentTagFriends[userPublicBean.id]!=null&&postAllInfoBean.postingViewBean.privacyLevel==4))}">				
					<div class="postDiv">
						<input type="hidden" class="postNoHidden" value="${postAllInfoBean.postingViewBean.postNo}"/>
							<div class="modifyDiv" style="display:none">
								<form class="modifyForm" method="post" action="modifyPost" enctype="multipart/form-data">
									<input type="hidden" name="privacyLevel" id="privacyLevel" value="2">
									<textarea class="modifyText" name="contents"></textarea><br />
										<table id="modifyTable" >
											<tbody>
											<tr>
												<td rowspan="2"><input type="file" name="f1" id="f1"/><img src="image/photo.jpg" id="imageBtn"></td>
												<td rowspan="2"><input type="file" name="f2" id="f2"/><img src="image/video.jpg" id="videoBtn"></td>
												<td><a href="#"><img src="image/all.png" class="allBtn" /></a></td>
												<td><a href="#"><img src="image/friend.png" class="friendBtn" /></a></td>
												<td><a href="#"><img src="image/secret.png" class="secretBtn" /></a></td>
												<td rowspan="2" id="writeTd"><button class="btn btn-small btn-danger modifyBtn">수정</button></td>
											</tr>
											<tr>
												<td class="allTd">&nbsp;전체</td>
												<td class="friendTd">&nbsp;친구</td>
												<td class="secretTd">&nbsp;비밀</td>
											</tr>
											</tbody>
										</table>
								</form>				
							</div>
							<table class="postTable">
								<tr>
									<td  rowspan="2" class="profileTd"><a href="#"><img src="${postAllInfoBean.postingViewBean.profileImg}" class="profile"></a></td>
									<td class="profileTd">
									<c:choose>
										<c:when test="${ postAllInfoBean.postingViewBean.guestId!=null }">
											<a href="showUserPost?id=${postAllInfoBean.postingViewBean.id}" id="guestWriterA">${ postAllInfoBean.postingViewBean.name }</a>
											<a href="showUserPost?id=${postAllInfoBean.postingViewBean.guestId}" id="guestNameA"> ▶ ${ postAllInfoBean.postingViewBean.guestName }</a>
										</c:when>
										<c:otherwise>
											<a href="showUserPost?id=${postAllInfoBean.postingViewBean.id}" id="nameA">${ postAllInfoBean.postingViewBean.name }</a>
										</c:otherwise>
									</c:choose>
									</td>
									<td>
										<a href="#" class="postMenu">v</a>				
										<!-- v버튼 누르면 나오는 메뉴 -->
										
										<ul class="sub-wrapper postUl">
											<c:choose>
											  <c:when test="${ postAllInfoBean.postingViewBean.id == userPublicBean.id  }">
											    	<li><button class="modifyPostBtn">수정하기</button></li>
													<li><button class="deletePostBtn">삭제하기</button></li>
											  </c:when>
											  <c:otherwise>
													<li><a href="#">신고하기</a></li>
													<c:choose>
													  <c:when test=" ${postAllInfoBean.hide==true}">
													    	<li><a href="#">숨김해제</a></li>
													  </c:when>
													  <c:otherwise>
													  		<li><a href="#">숨기기</a></li>
													  </c:otherwise>
													</c:choose>
													<li><a href="#">작성자차단</a></li>
											  </c:otherwise>
											</c:choose>
										</ul>
									</td>
								</tr>
								<tr>
									<td class="dateTd">${ postAllInfoBean.postingViewBean.postDate }</td>
									<td class="public" colspan="2">
										<c:choose>
										  <c:when test="${ postAllInfoBean.postingViewBean.privacyLevel==1 }">
										    	전체 공개
										  </c:when>
										  <c:when test="${ postAllInfoBean.postingViewBean.privacyLevel==2 }">
												친구 공개
										  </c:when>
										  <c:when test="${ postAllInfoBean.postingViewBean.privacyLevel==3 }">
												비공개
										  </c:when>
										  <c:when test="${ postAllInfoBean.postingViewBean.privacyLevel==4 }">
												태그 공개
										  </c:when>
										</c:choose>
									</td>
								</tr>
							</table>
						<p class="postContent">
							${ postAllInfoBean.postingViewBean.postContent }<br /><br />
							<c:if test="${ postAllInfoBean.imageList!=null }">
								<c:forEach var="image" items="${ postAllInfoBean.imageList }">
									<div class="postImgDiv"><img src="${ image }" class="postImg" /><br /></div>
								</c:forEach>
							</c:if>
						</p>
						<table class="recommendTable">
							<tr>
								<td rowspan="2" class="commentTd">댓글 <span class="commentCount">${ postAllInfoBean.postingViewBean.commentNum }</span>개</td>
								<td rowspan="2" class="shareTd">&nbsp;공유 ${ postAllInfoBean.postingViewBean.shareNum }개</td>
								<td><c:choose><c:when test="${postAllInfoBean.recommend==1}"><input type="image" src="image/selectedLike.jpg" class="likeBtn" /></c:when><c:otherwise><input type="image" src="image/like.jpg" class="likeBtn" /></c:otherwise></c:choose></td>
								<td><c:choose><c:when test="${postAllInfoBean.recommend==2}"><input type="image" src="image/selectedBukku.jpg" class="bukkuBtn" /></c:when><c:otherwise><input type="image" src="image/bukku.jpg" class="bukkuBtn" /></c:otherwise></c:choose></td>
								<td><c:choose><c:when test="${postAllInfoBean.recommend==3}"><input type="image" src="image/selectedHate.jpg" class="hateBtn" /></c:when><c:otherwise><input type="image" src="image/hate.jpg" class="hateBtn" /></c:otherwise></c:choose></td>
							</tr>
							<tr>
								<td colspan="2" class="likeNumTd"><div>${ postAllInfoBean.postingViewBean.likeNBukkuNum }</div></td>
								<td class="hateNumTd"><span class="hateNumSpan">${ postAllInfoBean.postingViewBean.hateNum }</span></td>
							</tr>
						</table>
					</div>
						<div class="commentDiv">
							<c:set var="commentCount" scope="page" value="${1}" />
							<c:forEach var="commentViewBean" items="${postAllInfoBean.commentViewBeanList}">
								<c:set var="commentCount" scope="page" value="${commentCount+1}"/>	
							</c:forEach>
							<c:forEach var="commentViewBean" items="${postAllInfoBean.commentViewBeanList}" varStatus="count" begin="0" end="2">
								
								<table>
									<tr>
										<td rowspan="2"><a href="#"><img src="${ commentViewBean.writerPorifleImg }" class="profile"></a></td>
										<td><a href="showUserPost?id=${commentViewBean.writerId}">${ commentViewBean.writerName }</a></td>
										<td class="dateCommentTd">${ commentViewBean.commentDate }
											<input type="hidden" class="commentNoHidden" value="${ commentViewBean.commentNo }" />
											<c:if test="${commentViewBean.writerId==userPublicBean.id}">
												<a href="#" id="editComment"><img src="image/edit.JPG" id="editCommentImg"/></a> <button class="deleteCommentBtn">X</button>
											</c:if>
										</td>
									</tr>
									<tr>
										<td colspan="2" class="recommendP">${ commentViewBean.commentContent }</td>
									</tr>
								</table>
							</c:forEach>
							<c:if test="${commentCount>=2}">
							<c:forEach var="commentViewBean" items="${postAllInfoBean.commentViewBeanList}" varStatus="count" begin="${3}" end="${commentCount}">
								<table id="${commentViewBean.postNo}_${count}">
									<tr>
										<td rowspan="2"><a href="#"><img src="${ commentViewBean.writerPorifleImg }" class="profile"></a></td>
										<td><a href="showUserPost?id=${commentViewBean.writerId}">${ commentViewBean.writerName }</a></td>
										<td class="dateCommentTd">${ commentViewBean.commentDate }
											<input type="hidden" class="commentNoHidden" value="${ commentViewBean.commentNo }" />
											<c:if test="${commentViewBean.writerId==userPublicBean.id}">
												<a href="#" id="editComment"><img src="image/edit.JPG" id="editCommentImg"/></a> <button class="deleteCommentBtn">X</button>
											</c:if>
										</td>
									</tr>
									<tr>
										<td colspan="2" class="recommendP">${ commentViewBean.commentContent }</td>
									</tr>
								</table>
							</c:forEach>
							</c:if>
							<div class="_addComment">
							</div>
							<c:if test="${postAllInfoBean.postingViewBean.commentNum>3}">
								<a href="#" class="moreComment">▲ 댓글 더 보기</a><br />
							</c:if>
							<form class="writeCommentForm" method="post" action="writeComment">
								<input type="hidden" name="postNo" value="${ postAllInfoBean.postingViewBean.postNo }" >
								<table class="addComment">
									<tr>
										<td rowspan="2"><a href="#"><img src="${ userPublicBean.profileImg }" class="profile"></a></td>
										<td rowspan="2"><textarea name="commentText" class="commentText"></textarea></td>
										<td>비공개 <input type="checkbox" id = "commentPrivacy" name="commentPrivacy"></td>
									</tr>
									<tr>
										<td ><button class="btn btn-small btn-info writeCommentBtn" type="button">작성</button></td>
									</tr>
								</table>
							</form>
						</div>
						</c:if>
						</c:forEach>
			</div>
			<div id="mymenu">
				<ul>
					<li><a href="myPost" class="mymenus" id="myPost">소식</a></li>
					<li><a href="myProfile?id=${userBean.id}" class="mymenus" id="information">정보</a></li>
					<li><a href="friendList" class="mymenus" id="friendList">친구</a></li>
				</ul>
			</div>
			<div id="searchPost">
			<form id="searchPostForm" method="post" action="searchMyPost">
				<table>
					<tr>
						<td><input type="text" id="searchPostText" name="content"/>
						<input type="image" src="image/searchPost.jpg" id="searchPostBtn"/></td>
					</tr>
					<tr>
						<td><input type="date" id="dateSearch" name="startDate"></td>
					</tr>
					<tr>
						<td><input type="date" id="dateSearch" name="lastDate"></td>
					</tr>
				</table>
			</form>
			</div>
		<!-- 팝업 E -->	
	</body>
</html>