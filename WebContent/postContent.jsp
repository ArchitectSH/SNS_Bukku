<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="postAllInfoBean" items="${ homePosts }">
					<div class="postDiv">
						<input type="hidden" class="postNoHidden" value="${postAllInfoBean.postingViewBean.postNo}"/>
							${ postAllInfoBean.postingViewBean.postNo} /
							${postAllInfoBean.activityKind}
							<div class="modifyDiv" style="display:none">
								<form class="modifyForm" method="post" action="modifyPost" enctype="multipart/form-data">
									<input type="hidden" name="privacyLevel" id="privacyLevel" value="2">
									<textarea class="modifyText" name="contents"></textarea><br />
										<table id="modifyTable" >
											<tbody>
											<tr>
												<td rowspan="2"><input type="file" name="f1" id="f1"/><img src="image/photo.jpg" id="imageBtn"></td>
												<td rowspan="2"><input type="file" name="f2" id="f2"/><img src="image/video.jpg" id="videoBtn"></td>
												<td><a href="#"><img src="image/all.jpg" class="allBtn" /></a></td>
												<td><a href="#"><img src="image/friend.jpg" class="friendBtn" /></a></td>
												<td><a href="#"><img src="image/secret.jpg" class="secretBtn" /></a></td>
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
								<c:choose>	
									<c:when test="${postAllInfoBean.activityKind==3}">
										<tr>
											<td colspan="3" class="likeTd">${postAllInfoBean.postingViewBean.friendName}님이 좋아하셨습니다.</td>
										</tr>
									</c:when>
									<c:when test="${postAllInfoBean.activityKind==4}">
										<tr>
											<td colspan="3" class="commentTd">${postAllInfoBean.postingViewBean.friendName}님이 댓글을 남기셨습니다.</td>
										</tr>
									</c:when>
								</c:choose>
								<tr>
									<c:choose>
										<c:when test="${postAllInfoBean.postingViewBean.mypageTitle!=null}">
											<td  rowspan="2" class="profileTd"><a href="#"><img src="${postAllInfoBean.postingViewBean.mypageImg}" class="profile"></a></td>
											<td class="profileTd"><a href="#" id="nameA">${ postAllInfoBean.postingViewBean.mypageTitle }</a></td>
										</c:when>
										<c:when test="${postAllInfoBean.postingViewBean.groupNo!=0}">
											<td  rowspan="2" class="profileTd"><a href="#"><img src="${postAllInfoBean.postingViewBean.profileImg}" class="profile"></a></td>
											<td class="profileTd"><a href="#" id="nameA">${ postAllInfoBean.postingViewBean.name }</a></td>
										</c:when>
										<c:otherwise>
											<td  rowspan="2" class="profileTd"><a href="#"><img src="${postAllInfoBean.postingViewBean.profileImg}" class="profile"></a></td>
											<td class="profileTd">
											<c:choose>
												<c:when test="${ postAllInfoBean.postingViewBean.guestId!=null }">
													<a href="#" id="guestWriterA">${ postAllInfoBean.postingViewBean.name }</a>
													<a href="#" id="guestNameA"> ▶ ${ postAllInfoBean.postingViewBean.guestName }</a>
												</c:when>
												<c:otherwise>
													<a href="#" id="nameA">${ postAllInfoBean.postingViewBean.name }</a>
												</c:otherwise>
											</c:choose>
											</td>
										</c:otherwise>
									</c:choose>
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
										  <c:when test="${ postAllInfoBean.postingViewBean.privacyLevel==5 }">
												그룹 공개
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
								<td class="hateNumTd"><span>${ postAllInfoBean.postingViewBean.hateNum }</span></td>
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
										<td><a href="#">${ commentViewBean.writerName }</a></td>
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
										<td><a href="#">${ commentViewBean.writerName }</a></td>
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
</body>
</html>