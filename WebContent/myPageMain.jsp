<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title>Bukku</title>
		<link href="css/myPageMain.css" rel="stylesheet" type="text/css"></link>
		<script src = "javascript/myPageMain.js" type="text/javascript" charset="UTF-8"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
		   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		   <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	</head>
	<body>
		<%@ include file="bukkuHeader.jsp" %>
		
		<script>
		function scroll_follow( id )
		{
		  $(window).scroll(function( )  //스크롤이 움직일때마다 이벤트 발생
		  { 
			  var position = $(window).scrollTop(); // 현재 스크롤바의 위치값을 반환합니다.
			  $( id ).stop().animate({top:position+100+"px"}, 0); //해당 오브젝트 위치값 재설정
		   });
		}
		scroll_follow( "#rightMenu" );
		//스크롤이 생기도록 <br> 을 여러게 넣은 부분..
		$(document).ready(function(){ for( var i=0; i<200; i++ ) {$('#brr').html($('#brr').html());} });
		
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
			var $writePostBtn = $('button.btn.btn-small.btn-danger.writeBtn');
			$writePostBtn.click(function(e) {
				document.getElementById('writeForm').submit();
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
//				$postNo = $(this).parents('.postDiv').find('input.recommendHidden').val();
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
//				$postNo = $(this).parents('.postDiv').find('input.recommendHidden').val();
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
//				$postNo = $(this).parents('.postDiv').find('input.recommendHidden').val();
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
			<!-- 마이페이지 프로필 정보 -->
			<div id="profileMain">
				<table>
					<tr>
						<td><a href=""><img src="${myPageInfo.img }" id="mypageImage"/></a></td>
					</tr>
					<tr><td id="mypageTitle">${myPageInfo.title }</td></tr>
					<c:if test="${userPublicBean.id!=myPageInfo.masterId}">
						<tr>
							<c:choose>
								<c:when test="${follow}">
									<td><a href="cancel_follow.do?title=${myPageInfo.title }"><button class="btn btn-small btn-info"
									id="cancleFollowBtn" type="button"><span class="glyphicon glyphicon-hand-down" aria-hidden="true"></span> 팔로잉취소</button></a>
									</td>
								</c:when>
								<c:otherwise>
									<td><a href="myPage_follow.do?title=${myPageInfo.title }"><button class="btn btn-small btn-info"
									id="followBtn" type="button"><span class="glyphicon glyphicon-hand-up" aria-hidden="true"></span> 팔로잉</button></a>
									</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:if>
				</table>
				<div id="introduction">
					${myPageInfo.introduction }
				</div>
				
				<table id="followerTb">
					<tr>
						<td>
							<c:choose>
								<c:when test="${userPublicBean.id==myPageInfo.masterId}"><a href="follow_member.do?title=${myPageInfo.title }" id="followMem">팔로잉</a></c:when>
								<c:otherwise>팔로잉</c:otherwise>		
							</c:choose>
						</td>
					</tr>
					<tr>
						<td id="followerNum">${myPageInfo.followerNum }</td>
					</tr>
				</table>
			</div>
			<c:if test="${userPublicBean.id==myPageInfo.masterId}">
				<div id="writeDiv">
						<form id="writeForm" method="post" action="writeMyPagePost" enctype="multipart/form-data">
							<input type="hidden" name="privacyLevel" id="privacyLevel" value="1">
							<input type="hidden" name="title" value="${myPageInfo.title}">
							<textarea id="writeText" name="contents"></textarea><br />
								<table id="writeTable" >
									<tbody>
									<tr>
										<td rowspan="2"><input type="file" name="f1" id="f1"/><img src="image/photo.jpg" id="imageBtn"></td>
										<td rowspan="2"><input type="file" name="f2" id="f2"/><img src="image/video.jpg" id="videoBtn"></td>
										<td rowspan="2" id="writeTd"><button class="btn btn-small btn-danger writeBtn">게시</button></td>
									</tr>
									</tbody>
								</table>
						</form>				
					</div>
				</c:if>
				<br />
				<c:forEach var="postAllInfoBean" items="${ myPosts }">
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
												<td rowspan="2" id="writeTd"><button class="btn btn-small btn-danger modifyBtn">수정</button></td>
											</tr>
											</tbody>
										</table>
								</form>				
							</div>
							<table class="postTable">
								<tr>
										<td  rowspan="2" class="profileTd"><a href="showMyPagePost?title=${postAllInfoBean.postingViewBean.mypageTitle}"><img src="${postAllInfoBean.postingViewBean.mypageImg}" class="profile"></a></td>
										<td class="profileTd"><a href="showMyPagePost?title=${postAllInfoBean.postingViewBean.mypageTitle}" id="nameA">${ postAllInfoBean.postingViewBean.mypageTitle }</a></td>
									<c:if test="${userPublicBean.id==myPageInfo.masterId}">	
										<td>
											<a href="#" class="postMenu">v</a>				
											<!-- v버튼 누르면 나오는 메뉴 -->
											
											<ul class="sub-wrapper postUl">
												<c:choose>
												  <c:when test="${ postAllInfoBean.postingViewBean.id == userPublicBean.id  }">
												    	<li><button class="modifyPostBtn">수정하기</button></li>
														<li><button class="deletePostBtn">삭제하기</button></li>
												  </c:when>							  
												</c:choose>
											</ul>
										</td>
									</c:if>
								</tr>
								<tr>
									<td class="dateTd">${ postAllInfoBean.postingViewBean.postDate }</td>
									<td class="public" colspan="2">
										  전체 공개
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
						</c:forEach>
			</div>
				<div id="rightMenu">
				<c:if test="${myPageInfo.masterId==userPublicBean.id}">
					<div id="mymenu">
			            <ul>
			               <li><a href="page_main.do?title=${myPageInfo.title }" class="mymenus" id="myPagePost">페이지글</a></li>
			               <li><a href="invite_page.do?title=${myPageInfo.title }&masterId=${myPageInfo.masterId}" class="mymenus" id="mypageInvite">초대</a></li>
			               <li><a href="set_page.do?title=${myPageInfo.title }" class="mymenus" id="mypageSetting">설정</a></li>
			            </ul>
		 			</div>
	 			</c:if>
	 			<c:choose>
	 			<c:when test="${myPageInfo.masterId!=userPublicBean.id}">
	 				<div id="searchPost" style="top:120px;">
	 			</c:when>
	 			<c:otherwise>
	 				<div id="searchPost" style="top:250px;">
	 			</c:otherwise>
	 			</c:choose>
				<form id="searchPostForm" method="post" action="">
					<table>
						<tr>
							<td><input type="text" id="searchPostText" />
							<input type="image" src="image/searchPost.jpg" id="searchPostBtn"/></td>
						</tr>
						<tr>
							<td><input type="date" id="dateSearch"></td>
						</tr>
						<tr>
							<td><input type="date" id="dateSearch"></td>
						</tr>
					</table>
				</form>
				</div>
	</body>
</html>