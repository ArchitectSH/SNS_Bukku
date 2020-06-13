<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bukku</title>
<link href="css/search.css" rel="stylesheet" type="text/css"></link>
<script src="javascript/search.js" type="text/javascript"
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
            var $friendButtons = $('.friendBtnTd form button.btn-info');
            
            $friendButtons.click(function(e) {
            	
            	
               /*  e.preventDefault(); */
                var $b = $(this).find("#fbtnDiv");
                var $c = $(this).find("#btnDiv");
       	    	var str2 = $b.text();  
       	    	var str = $c.text();
       	    	console.log(str); 
       	    	 console.log(str2); 
       	  		   var replaceBtnDiv = $(this).find("#btnDiv");
	       	 	
       	    	if(str=="친구추가"){
	       	  	
	       	 		///////////////////
	       	 		/* alert("친구추가버튼 눌림"); */
	       	 		var $this = $(this);
	      	  	   var form = $(this).parents();
	      	  	   console.log(form);
	      	  	   
	      	  	    var change = $(this).parents("#friendBtnTd");
	               var id2= form.serialize();  
	                 
	                 jQuery.ajax({
	                    type:"POST",
	                    url:"addFriend",
	                    data: id2,
	                    success:function(){
	                    	var	$str = '<div id ="btnDiv" style="margin-bottom: 5px;"><span class="glyphicon glyphicon-user" aria-hidden="true">친구수락대기</div>';
	    	       	 		$($str).replaceAll(replaceBtnDiv);
	                                           
	                    }, 
	                    error:function(xhr,status,error){
	                       alert(error);
	                    }
	                    });   
	                  return false;  
	       	 		
    	  	   }else if(str=="친구끊기"){
    	  		 
    	 			
    	 			/////////////////////////////////////////
	       	    	/* alert("친구끊기버튼 눌림"); */
	        	  	   var $this = $(this);
	        	  	   var form = $(this).parents();
	        	  	   var change = $(this).parents("#friendBtnTd");
	        	  //	   console.log($(this).parents("#friendBtnTd"));
	        	  
	        	
	                 var id2= form.serialize(); 
	                 
	                 jQuery.ajax({
	                     type:"POST",
	                     url:"removeFriend",
	                     data: id2,
	                     success:function(){                    	//나중에  변경 필요 
	                    		$(this).parents().parents().parents().first().toggle(); 
	                    	  	var div =  $(this).parents().parents().parents().parents().find("#fbtnDiv");
	               	  		 /*   	console.log(div); */
	               	  		 $(this).parent().find('ul.friendButtons').toggle(); 
	               	  			var	$str = '<div id ="btnDiv" style="margin-bottom: 5px;"><span class="glyphicon glyphicon-plus" aria-hidden="true">친구추가</div>';
	               	 			$($str).replaceAll(div);
	               	 	
	                                            
	                     }, 
	                     error:function(xhr,status,error){
	                        alert(error);
	                     }
	                     });
	                  return false; 
	  	  	  		
    	 			
    	  	   }else if(str=="회원차단"){
    	  		
	   	 			////////////////////
	   	 		/* alert("회원차단버튼 눌림"); */
	     	  	   var $this = $(this);
	     	  	   var form = $(this).parents();
	     	  	   var change = $(this).parents("#friendBtnTd");
	     	  	//   console.log($(this).parents("#friendBtnTd"));
	     	  
	     	
	              var id2= form.serialize(); 
	              
	              jQuery.ajax({
	                  type:"POST",
	                  url:"blockUser",
	                  data: id2,
	                  success:function(){                    	 
	                  	
	                		$(this).parents().parents().parents().first().toggle(); 
	      	  			var div =  $(this).parents().parents().parents().parents().find("#fbtnDiv");
	  	       	 	/* 	console.log(div); */
	  	       	 	  $(this).parent().find('ul.friendButtons').toggle(); 
	  	       	  		var	$str = '<div id ="btnDiv" style="margin-bottom: 5px;"><span class="glyphicon glyphicon-ban-circle" aria-hidden="true">차단해제</div>';
	  	   	 			$($str).replaceAll(div);
	  	   	 	
	  	   	 			
	                                         
	                  }, 
	                  error:function(xhr,status,error){
	                     alert(error);
	                  }
	                  });
	               return false; 
    	  	   }else if(str=="차단해제"){
    	  		
	   	 			
	  				///////////////////
	   	 	/* 	alert("차단해제버튼 눌림"); */
	       	  	   var $this = $(this);
	       	  	   var form = $(this).parents();
	       	  	   var change = $(this).parents("#cancelBlockUserBtnTd");
	       	  
	       	
	                var id2= form.serialize(); 
	                
	                jQuery.ajax({
	                    type:"POST",
	                    url:"cancelBlockUser",
	                    data: id2,
	                    success:function(){
	                    	//나중에  변경 필요                     	
	                    	   
	    	       	  		var	$str = '<div id ="btnDiv" style="margin-bottom: 5px;"><span class="glyphicon glyphicon-plus" aria-hidden="true">친구추가</div>';
	    	   	 			$($str).replaceAll(replaceBtnDiv);                                       
	                    }, 
	                    error:function(xhr,status,error){
	                       alert(error);
	                    }
	                    });
	                 return false; 
    	  	   }	
       	    	
       	    	if(str2=="친구"){       	    	
	             	  $(this).parent().parent().find('ul.friendButtons').toggle(); 
	       	    }       
       	    
       	    	
            });
         });

         $(function(){
            var $searchUserBtn = $('#searchUserBtn');
            $searchUserBtn.click(function(e){
               var form = document.getElementById("searchFrm");
               
               form.submit();   
            });
         });
         
         

         $(function() {      		
       	    $('.friendBtnTd .friendBtn').click(function(e){
	       	 	var $b = $(this).find("#btnDiv");
	   	    	var str = $b.text();  
	   	    	/* alert(str); */
       	  	   var $this = $(this);
       	  	   var form = $(this).parents();
       	  	   var change = $(this).parents("#addFriendBtnTd");
       	  	   var replaceBtnDiv = $(this).find("#btnDiv");
       	  	   
       	  	   if(str=="친구추가"){
	       	  
					///////////////////
	       	 	/* 	alert("친구추가버튼 눌림"); */
	       	 		var $this = $(this);
	      	  	   var form = $(this).parents();
	      	  	   var change = $(this).parents("#friendBtnTd");
	                 var id2= form.serialize();  
	                 
	                 jQuery.ajax({
	                    type:"POST",
	                    url:"addFriend",
	                    data: id2,
	                    success:function(){
	                    	
	                		var	$str = '<div id ="btnDiv" style="margin-bottom: 5px;"><span class="glyphicon glyphicon-user" aria-hidden="true">친구수락대기</div>';
	    	       	 		$($str).replaceAll(replaceBtnDiv);
	    	       	 		
	                                           
	                    }, 
	                    error:function(xhr,status,error){
	                       alert(error);
	                    }
	                    });   
	                  return false;  
       	  	   }else if(str=="친구끊기"){
       	  			
	  	  	  		/////////////////////////////////////////
	       	    /* 	alert("친구끊기버튼 눌림"); */
	        	  	   var $this = $(this);
	        	  	   var form = $(this).parents();
	        	  	   var change = $(this).parents("#friendBtnTd");
	        	  //	   console.log($(this).parents("#friendBtnTd"));
	        	/*    $(this).parents().parents().parents().first().toggle();  */
	         	 
	        	/* 
	        	var div =  $(this).parents().parents().parents().parents().find("#fbtnDiv");
	               	  			var	$str = '<div id ="btnDiv" style="margin-bottom: 5px;"><span class="glyphicon glyphicon-plus" aria-hidden="true">친구추가</div>';
	               	 			$($str).replaceAll(div);  */
               	 		 $(this).parents().parents().parents().first().toggle();  
   	                     
                   	    	var div =  $(this).parents().parents().parents().parents().find("#fbtnDiv");
              	  			var	$str = '<div id ="btnDiv" style="margin-bottom: 5px;"><span class="glyphicon glyphicon-plus" aria-hidden="true">친구추가</div>';
              	 			$($str).replaceAll(div);  
	               	 			
	                 var id2= form.serialize(); 
	                 
	                  jQuery.ajax({
	                     type:"POST",
	                     url:"removeFriend",
	                     data: id2,
	                     success:function(){                    	//나중에  변경 필요 
	                    	
	               	 			/* console.log( $(this).parents().parents().parents().first());  */
	        	                
	                     }, 
	                     error:function(xhr,status,error){
	                        alert(error);
	                     }
	                     });
       	  	   }else if(str=="회원차단"){
       	  		 
 	  	  		
 	  	  		////////////////////// 
  	  	   var $this = $(this);
  	  	   var form = $(this).parents();
  	  	   var change = $(this).parents("#friendBtnTd");
  	  	//   console.log($(this).parents("#friendBtnTd"));
  	  
  	
           var id2= form.serialize(); 
           
           $(this).parents().parents().parents().first().toggle(); 
	  			var div =  $(this).parents().parents().parents().parents().find("#fbtnDiv");
	  		 $(this).first().toggle();
	    	console.log( $(this).parents().parents().find('ul.friendButtons')); 
  	  		var	$str = '<div id ="btnDiv" style="margin-bottom: 5px;"><span class="glyphicon glyphicon-ban-circle" aria-hidden="true">차단해제</div>';
	 			$($str).replaceAll(div);
           
           jQuery.ajax({
               type:"POST",
               url:"blockUser",
               data: id2,
               success:function(){                    	 
               	
            	 
                                      
               }, 
               error:function(xhr,status,error){
                  alert(error);
               }
               });
            return false; 
       	  	   }else if(str=="차단해제"){
       	  		
	   	 			//////////////////
	   	 	/* 	alert("차단해제버튼 눌림"); */
	       	  	   var $this = $(this);
	       	  	   var form = $(this).parents();
	       	  	   var change = $(this).parents("#cancelBlockUserBtnTd");
	       	  
	       	
	                var id2= form.serialize(); 
	                
	                jQuery.ajax({
	                    type:"POST",
	                    url:"cancelBlockUser",
	                    data: id2,
	                    success:function(){
	                    	//나중에  변경 필요                     	
	                    	   
	    	       	  		var	$str = '<div id ="btnDiv" style="margin-bottom: 5px;"><span class="glyphicon glyphicon-plus" aria-hidden="true">친구추가</div>';
	    	   	 			$($str).replaceAll(replaceBtnDiv);                                    
	                    }, 
	                    error:function(xhr,status,error){
	                       alert(error);
	                    }
	                    });
	                 return false; 
       	  	   }
       	  		   
       	  	   
       	  	
       	 	

            });       	    
        });
      
    /* 

         $(function() {      		
       	    $('#cancelBlockUserBtnTd #cancelBlockUserBtn').click(function(e){
       	    	alert("차단해제버튼 눌림");
       	  	   var $this = $(this);
       	  	   var form = $(this).parents();
       	  	   var change = $(this).parents("#cancelBlockUserBtnTd");
       	  
       	
                var id2= form.serialize(); 
                
                jQuery.ajax({
                    type:"POST",
                    url:"cancelBlockUser",
                    data: id2,
                    success:function(){
                    	//나중에  변경 필요                     	
                       change.load("search2.jsp #addFriendBtn");                                            
                    }, 
                    error:function(xhr,status,error){
                       alert(error);
                    }
                    });
                 return false; 
            });
       	    
        });
         $(function() {      		
        	    $('#friendBtnTd #removeBtn').click(function(e){
        	    	alert("친구끊기버튼 눌림");
        	  	   var $this = $(this);
        	  	   var form = $(this).parents();
        	  	   var change = $(this).parents("#friendBtnTd");
        	  //	   console.log($(this).parents("#friendBtnTd"));
        	  
        	
                 var id2= form.serialize(); 
                 
                 jQuery.ajax({
                     type:"POST",
                     url:"removeFriend",
                     data: id2,
                     success:function(){                    	//나중에  변경 필요 
                     	
                        change.load("search2.jsp #removingFriendBtn"); 
                                            
                     }, 
                     error:function(xhr,status,error){
                        alert(error);
                     }
                     });
                  return false; 
             });
        	    
         });
         
         $(function() {      		
     	    $('#friendBtnTd #blockBtn').click(function(e){
     	    	alert("회원차단버튼 눌림");
     	  	   var $this = $(this);
     	  	   var form = $(this).parents();
     	  	   var change = $(this).parents("#friendBtnTd");
     	  	//   console.log($(this).parents("#friendBtnTd"));
     	  
     	
              var id2= form.serialize(); 
              
              jQuery.ajax({
                  type:"POST",
                  url:"blockUser",
                  data: id2,
                  success:function(){                    	 
                  	
                     change.load("search2.jsp #blockingFriendBtn"); 
                                         
                  }, 
                  error:function(xhr,status,error){
                     alert(error);
                  }
                  });
               return false; 
          });
     	    
      }); 
*/
		</script>
		<div id="allDiv">
			<div id="myFriendsDiv">
			
			
				<table id="allTable">
					<tr>
						<td>
							<table id="resultTable">
							<c:if test ="${first == true}">
				<div id = "searchPage">회원 검색을 위한 페이지입니다</div>
			</c:if>
			
				<c:if test = "${empty userPublicBeans and first !=true}">
					<div id ="noResult">검색 결과가 없습니다 </div>
				</c:if>
								<tr>
								<c:forEach var ="user" items = "${userPublicBeans}" >
								
								 <c:set var ="blockedState" value="false"></c:set>
											
									<c:forEach var ="blockedEach" items = "${blocked}">										
										<c:if test="${blockedEach.id == user.id}">			
										  <c:set var ="blockedState" value="true"></c:set>								   												    
										</c:if>	
									</c:forEach>
											
									<c:if test="${blockedState == 'false'}">
												
									<td id="user">
									
									<input type ="hidden" id = "resultId" name = "id" value="${user.id}"/>
										<table class="friendTb">
										
											<tr>
												<td rowspan="2"><a href="showUserPost?id=${user.id}"><img src="${user.profileImg}" class="profileM"></a></td>
												<td colspan="2"><a href="showUserPost?id=${user.id}" class="nameB">${user.name}</a></td>
											</tr>
											<tr>
											 <c:set var ="friend" value="false"></c:set>
											 <c:set var ="requestState" value="false"></c:set>
											  <c:set var ="blockingState" value="false"></c:set>
											    <c:set var ="blockedState" value="false"></c:set>
											
											<c:forEach var ="friendInfoViewBean" items = "${friendInfoViewBeans}">	
											
												<c:if test="${friendInfoViewBean.friendId == user.id}">
												    <c:set var ="friend" value="true"></c:set>												    
												</c:if>	
											</c:forEach>
											
											<c:forEach var ="requestUser" items = "${requestList}">
											
												<c:if test="${requestUser.id == user.id}">
												    <c:set var ="requestState" value="true"></c:set>												    
												</c:if>	
											</c:forEach>
											
											<c:forEach var ="blockingEach" items = "${blocking}">	
											
												<c:if test="${blockingEach.id == user.id}">
												    <c:set var ="blockingState" value="true"></c:set>												    
												</c:if>	
											</c:forEach>
											
								
											
											<c:choose>
										
												<c:when test="${friend == 'true'}">											
												<td class="btnTd ffriendBtnTd friendBtnTd" id = "friendBtnTd">
												 <form action="#" method="post">
													<input type="hidden" id ="userId" name="userId" value="${user.id}"/>	
												<button class="btn btn-small btn-info ffriendBtn friendBtnTd" id="friendBtn" type="button">																					
													<div id ="fbtnDiv" class = "btbt"><span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>친구</div></button></form>		
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
												
												
												
												<c:when test="${requestState == 'true'}">												 										
												<td class="btnTd friendBtnTd"><button class="btn btn-small btn-info friendBtn" id="requestFriendBtn" type="button">																						
													<div id ="btnDiv" class = "btbt"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>친구수락대기</div></button>	
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
												
												<c:when test="${blockingState == 'true'}">	
																					
												<td class="btnTd friendBtnTd" id = "cancelBlockUserBtnTd">
												 <form action="#" method="post">
													<input type="hidden" id ="userId" name="userId" value="${user.id}"/>	
													<button class="btn btn-small btn-info friendBtn" id="cancelBlockUserBtn" type="button">																						
													<div id ="btnDiv" class = "btbt"><span class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span>차단해제</div></button>
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
												</form>
												</td>
												</c:when>
												
												
												
												<c:otherwise>
												<td class="btnTd friendBtnTd" id = "addFriendBtnTd">
												<form action="addFriend" method="post">
													<input type="hidden" id ="userId" name="userId" value="${user.id}"/>
													<button class="btn btn-small btn-info friendBtn" id="addFriendBtn" type="button">																						
														<div id="btnDiv"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>친구추가</div>
													</button>
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
												</form>
												</td>						
												</c:otherwise>
												
											</c:choose>
												
											</tr>
										</table>
								
									</td>
									</c:if>
								
									</c:forEach>

								</tr>
							</table>
						</td>
						<td>
							<table>
								<tr>
									<td>
										<table id="titleTable">
											<tr>
												<td rowspan="2" id="joinTd">
													<div id="joinDiv">
													<form method="post" action="searchMember" id="searchFrm">
													<table id="joinTable">
														<caption id="joinCaption">회원 찾기</caption>
														<tr>
															<td>아이디</td>
															<td><input type="text" name="id" id="id" /></td>
														</tr>
														<tr>
															<td>이름</td>
															<td><input type="text" name="name" id="name" /></td>
														</tr>
														<tr>
															<td>성별</td>
															<td><input type="radio" name="gender" value="1" />남자 <input
																type="radio" name="gender" value="2" /> 여자</td>
														</tr>
														<tr>
															<td>학교</td>
															<td>
																<select name="schoolLocation">
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
																<select name="school">
																	<option value="">학교선택</option>
									<option value="banghakPri">방학초등학교</option>
									<!-- <option value="bundangMiddle">분당중학교</option> -->
									<option value="seonlinHigh">선린인터넷고등학교</option>
									<option value="soongsilUni">숭실대학교</option>
									<option value="shamyookUni">삼육대학교	</option>
									<option value="sechoHigh">서초고등학교</option>
									<option value="sechoMiddle">서초중학교</option>
									<option value="geongmoonHigh">경문고등학교</option>
																
																</select>
															</td>
														</tr>
														<tr>
															<td>거주</td>
															<td><input type="text" name="location" id="location" /></td>
														</tr>
														<tr>
															<td>생년월일</td>
															<td>
																<input type="number" name="year" max="2015" min="1" id="year" />년 
																<input type="number" name="month" max="12" min="1" id="month" />월 
																<input type="number" name="day" max="31" min="1" id="day" />일
															</td>
														</tr>
														<tr>
															<td>이메일</td>
															<td><input type="text" name="email" id="email" />@ <select
																name="emailAddr">
																	<option value="">이메일</option>
																	<option value="@naver.com">naver.com</option>
																	<option value="@daum.net">daum.net</option>
																	<option value="@google.com">google.com</option>
																	<option value="@nate.com">nate.com</option>
																	<option value="etc">기타</option>
															</select></td>
														</tr>
														<tr>
															<td>핸드폰 번호</td>
															<td>
															<input type="text" name="phoneNum1" id="phoneNum1" />- 
															<input type="text" name="phoneNum2" id="phoneNum2" />- 
															<input type="text" name="phoneNum3" id="phoneNum3" /></td>
														</tr>
														<tr>
															<td colspan="2" id="bottomSearchTd">
																<input type="button" value="검색" id="searchUserBtn" class="btn btn-info" />
															</td>
														</tr>
													</table>
													</form>
													</div>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				
			</div>
		</div>
			
	</body>
</html>