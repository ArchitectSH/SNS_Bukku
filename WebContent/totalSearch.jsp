<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bukku</title>
<link href="css/totalSearch.css" rel="stylesheet" type="text/css"></link>
<script src="javascript/totalSearch.js" type="text/javascript"
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
		/*요기 자바 스크립트 손봐야대...에이젝스.......(친구부분만손보면됨).안해안해........흑흑흑흑*/
	/* 		$(function() {
				var $friendButtons = $('button.btn-info');
	
				$friendButtons.click(function(e) {
					e.preventDefault();
					$(this).parent().find('ul.friendButtons').toggle();
				});
			});
			

	         $(function() {      		
	       	    $('#addFriendBtnTd #addFriendBtn').click(function(e){
	       	   //  	alert("친구추가버튼 눌림"); 
	       	  	   var $this = $(this);
	       	  	   var form = $(this).parents();
	       	  	   var change = $(this).parents("#addFriendBtnTd");
	       	  
	       	
	                var id2= form.serialize(); 
	                
	                jQuery.ajax({
	                    type:"POST",
	                    url:"addFriend",
	                    data: id2,
	                    success:function(){
	                    	//나중에  변경 필요 
	                       change.load("search2.jsp #waitingFriendBtn"); 
	                                           
	                    }, 
	                    error:function(xhr,status,error){
	                       alert(error);
	                    }
	                    });
	                 return false; 
	            });
	       	    
	        });
	         

	         $(function() {      		
	       	    $('#cancelBlockUserBtnTd #cancelBlockUserBtn').click(function(e){
	       	    // 	alert("차단해제버튼 눌림"); 
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
	        	    	// alert("친구끊기버튼 눌림"); 
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
	     	    	// alert("회원차단버튼 눌림"); 
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
 $(function(){
     var $toggleButton = $('.friendButtons form li .friendBtn');
     
     $toggleButton.click(function(e) {
     	
   
        /*  e.preventDefault(); */
         var $b = $(this).find("#fbtnDiv");
         var $c = $(this).find("#btnDiv");
	    	var str2 = $b.text();  
	    	var str = $c.text();
	    	/* console.log(str);  */
	    	console.log($c);
	    	 console.log(str2); 
	  		   var replaceBtnDiv = $(this).find("#btnDiv");
   	 	
	    	if(str=="친구끊기"){
	  		 
	 			
	 			/////////////////////////////////////////
    	    	/* alert("친구끊기버튼 눌림"); */
     	  	   var $this = $(this);
     	  	   var form = $(this).parents();
     	  	   var change = $(this).parents("#friendBtnTd");
     	  //	   console.log($(this).parents("#friendBtnTd"));
     	  
     				$(this).parents().parents().parents().first().toggle(); 
     				var div =  $(this).parent().parent().parent().parent().find("#fbtnDiv");
            	  		 /*   	console.log(div); */
            	  		 $(this).parent().find('ul.friendButtons').toggle(); 
            	  			var	$str = '<div id ="btnDiv" style="margin-bottom: 5px;"><span class="glyphicon glyphicon-plus" aria-hidden="true">친구추가</div>';
            	 			$($str).replaceAll(div);
              var id2= form.serialize(); 
              
              jQuery.ajax({
                  type:"POST",
                  url:"removeFriend",
                  data: id2,
                  success:function(){                    	//나중에  변경 필요 
                 		
            	 	
                                         
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
  	  
             		$(this).parents().parents().parents().first().toggle(); 
             		var div =  $(this).parent().parent().parent().parent().find("#fbtnDiv");
	       	 	/* 	console.log(div); */
	       	 	  $(this).parent().find('ul.friendButtons').toggle(); 
	       	  		var	$str = '<div id ="btnDiv" style="margin-bottom: 5px;"><span class="glyphicon glyphicon-ban-circle" aria-hidden="true">차단해제</div>';
	   	 			$($str).replaceAll(div);
  	
           var id2= form.serialize(); 
           
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
	  	   }
	    	
	    	});
 });
 
 
 
 
 
 
 
 $(function(){
     var $friendButtons = $('.friendBtnTd form button.btn-info');
     
     $friendButtons.click(function(e) {
     
        /*  e.preventDefault(); */
         var $b = $(this).find("#fbtnDiv");
         var $c = $(this).find("#btnDiv");
	    	var str2 = $b.text();  
	    	var str = $c.text();
	    	/* console.log(str);  */
	    	console.log($c);
	    	 console.log(str2); 
	  		   var replaceBtnDiv = $(this).find("#btnDiv");
   	 	
	    	if(str=="친구추가"){
    	  	
    	 		///////////////////
    	 		
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
  	  
             		$(this).parents().parents().parents().first().toggle(); 
   	  			var div =  $(this).parents().parents().parents().parents().find("#fbtnDiv");
	       	 	/* 	console.log(div); */
	       	 	  $(this).parent().find('ul.friendButtons').toggle(); 
	       	  		var	$str = '<div id ="btnDiv" style="margin-bottom: 5px;"><span class="glyphicon glyphicon-ban-circle" aria-hidden="true">차단해제</div>';
	   	 			$($str).replaceAll(div);
  	
           var id2= form.serialize(); 
           
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
 			
 			 $(this).parent().parent().find('ul.friendButtons').toggle(); 
         	  console.log($(this).parent().parent().find('ul.friendButtons'));
 			
  			if($c.text()=="친구"){
  				
          	  $(this).parent().parent().find('ul.friendButtons').toggle(); 
          	  console.log($(this).parent().parent().find('ul.friendButtons'));
    	    }	
	    
	    
	    	
     });
  });
 

	         //요기부터 마이페이지 부분
          $(function() {      		
       	    $('.mypage form button.btn-info').click(function(e){
       	   
	       	 	var $b = $(this).find("#btnDiv");
	   	    	var str = $b.text();  
	   	    	/* alert(str); */
       	  	   
       	  	   var form = $(this).parent();
	   	    	
       	  	  /*  var change = $(this).parents("#addFriendBtnTd"); */
       	  	   var replaceBtnDiv = $(this).find("#btnDiv");
       	  	console.log(replaceBtnDiv);
       	  	   if(str=="팔로잉취소"){
       	  		console.log(replaceBtnDiv);
					///////////////////
	       	 	
	                 var id2= form.serialize();
	                 
	                 jQuery.ajax({
	                    type:"GET",
	                    url:"cancel_follow.do",
	                    data: id2,
	                    success:function(){
	                    	
	                		var	$str2 = '<div id ="btnDiv" style="margin-bottom: 5px;"><span class="glyphicon glyphicon-hand-up" aria-hidden="true">팔로잉하기</div>';
	    	       	 		
	                		$($str2).replaceAll(replaceBtnDiv);	    	       	 		
	                                           
	                    }, 
	                    error:function(xhr,status,error){
	                       alert(error);
	                    }
	                    });   
	                 /*  return false;  */
       	  	   
       	  	   }else if(str=="팔로잉하기"){
       	  
	                 var id3= form.serialize();
	                
	                 jQuery.ajax({
	                    type:"GET",
	                    url:"myPage_follow.do",
	                    data: id3,
	                    success:function(){
	                    	
	                		var	$str2 = '<div id ="btnDiv" style="margin-bottom: 5px;"><span class="glyphicon glyphicon-hand-down" aria-hidden="true">팔로잉취소</div>';
	    	       	 		$($str2).replace(replaceBtnDiv);	    	       	 		
	                                           
	                    }, 
	                    error:function(xhr,status,error){
	                       alert(error);
	                    }
	                    });   
	                /*   return false;  */
       	  		  
       	  	   }else{
       	  	
       	
       	 		
		      	  	   
                var id3= form.serialize();
             
                jQuery.ajax({
                   type:"GET",
                   url:"myPage_follow.do",
                   data: id3,
                   success:function(){
                   	
               		var	$str = '<div id ="btnDiv" style="margin-bottom: 5px;"><span class="glyphicon glyphicon-hand-down" aria-hidden="true">팔로잉취소</div>';
   	       	 		$($str).replaceAll(replaceBtnDiv);	    	       	 		
                                          
                   }, 
                   error:function(xhr,status,error){
                      alert(error);
                   }
                   });   
               /*   return false;  */
       	  	   }
       	  	   
       	    });
          });

		</script>
		<div id="allDiv">
			<div id="myFriendsDiv">
			<c:if test="${not empty friendSearch}">
			<div class="border">
			<table class="friendResultTable">
				<caption>내 친구</caption>
				<tr class="friendResultTr">
				
				<c:forEach var ="user" items = "${friendSearch}">
			
				<c:set var ="blockedState" value="false"></c:set>
									
					<c:forEach var ="blockedEach" items = "${blocked}">										
						<c:if test="${blockedEach.id == user.id}">			
						  <c:set var ="blockedState" value="true"></c:set>								   												    
						</c:if>	
					</c:forEach>
				
											
					<c:if test="${blockedState == 'false'}">
												
					<td class="resultTd">				
						<input type ="hidden" id = "resultId" name = "resultId" value="${user.id}"/>
						<table class="friendTb">
							<tr>
								<td rowspan="2"><a href="showUserPost?id=${user.id}"><img
										src="${user.profileImg}" class="profileM"></a></td>
								<td colspan="2"><a href="showUserPost?id=${user.id}" class="nameB">${user.name}</a></td>
							</tr>
							<tr>


							<td class="btnTd ffriendBtnTd friendBtnTd"
									id="friendBtnTd">
									<form action="#" method="post">
										<input type="hidden" id="userId" name="userId"
											value="${user.id}" />
										<button
											class="btn btn-small btn-info ffriendBtn friendBtnTd"
											id="friendBtn" type="button">
											<div id="fbtnDiv" class="btbt">
												<span class="glyphicon glyphicon-chevron-down"
													aria-hidden="true"></span>친구
											</div>
										</button>
									</form>
									<ul class="sub-wrapper friendButtons">
										<form method="POST" action="#" class="friendBtnTd">
											<input type="hidden" id="userId" name="userId"
												value="${user.id}" />
											<li><a href="#" id="blockBtn" class="friendBtn"><div
														id="btnDiv">회원차단</div></a></li>
										</form>

										<form method="POST" action="#" class="friendBtnTd">
											<input type="hidden" id="userId" name="userId"
												value="${user.id}" />
											<li><a href="#" id="removeBtn" class="friendBtn"><div
														id="btnDiv">친구끊기</div></a></li>
										</form>
									</ul>
								</td>
							</tr>
						</table>
					</td>
					</c:if>
				
				</c:forEach>
				
				</tr>
			</table>
			</div>
			</c:if>
			
			
				<c:if test="${not empty followingSearch}">
				<div class="border">
			<table class="mypageResultTable">
				<caption>내가 팔로잉하는 마이페이지</caption>
				<tr class = "mypageResultTd">
					<c:forEach var ="following" items = "${followingSearch}">
					<td class="resultTd">
						<table class="friendTb">
							<tr>
								<td rowspan="2"><a href="showMyPagePost?title=${following.title}"><img
										src="${following.img}" class="profileM"></a></td>
								<td colspan="2"><a href="showMyPagePost?title=${following.title}" class="nameB">${following.title}</a></td>
							</tr>
							<tr>
								<td class="btnTd mypage">
								<form action="#" method="get">
								<button class="btn btn-small btn-info"
										id="cancelFollowBtn" type="button">
										
										<div id="btnDiv"><input type="hidden" name="title" value="${following.title}"><span class="glyphicon glyphicon-hand-down"
											aria-hidden="true"></span>팔로잉취소</div>
									</button></form>
									
									
									<!--요기위에 버튼 아이콘모양변경해야함  -->
									</td>
							</tr>
						</table>
					</td>
					</c:forEach>
				
				</tr>
			</table>
			</div>
			</c:if>
			
			<c:if test="${not empty onlyUserSearch}">
			<div class="border">
			<table class="friendResultTable">
				<caption>아직 친구가 아닌 사람</caption>
				<tr class ="friendResultTr">
					<c:forEach var ="user" items = "${onlyUserSearch}">
					<c:if test="${user.id != sessionScope.userPublicBean.id}">
					<c:set var ="blockedState" value="false"></c:set>
					 <c:set var ="requestState" value="false"></c:set>
					<c:set var ="blockingState" value="false"></c:set>		
				
					<c:forEach var ="blockedEach" items = "${blocked}">										
						<c:if test="${blockedEach.id == user.id}">			
						  <c:set var ="blockedState" value="true"></c:set>								   												    
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
					
					
											
					<c:if test="${blockedState == 'false'}">
					
					<td class="resultTd">
					<input type="hidden" id = "resultId" name = "resultId" value="${user.id}"/> 
						<table class="friendTb">
							<tr>
								<td rowspan="2"><a href="showUserPost?id=${user.id}"><img
										src="${user.profileImg}" class="profileM"></a></td>
								<td colspan="2"><a href="showUserPost?id=${user.id}" class="nameB">${user.name}</a></td>
							</tr>
							<tr>
							
							
							
									<c:choose>
									<c:when test="${friend == 'true'}">											
												<td class="btnTd ffriendBtnTd friendBtnTd" id = "friendBtnTd">
												 <form action="#" method="post">
													<input type="hidden" id ="userId" name="userId" value="${user.id}"/>	
												<button class="btn btn-small btn-info ffriendBtn friendBtnTd" id="friendBtn" type="button">																					
													<div id ="fbtnDiv" class = "btbt"><span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>친구</div></button>
													</form>		
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
												<form action="#" method="post">
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
					</c:if>
				</c:forEach>
				</tr>
			</table>
			</div>
			</c:if>
			<br/>
			<c:if test="${not empty onlyMypageSearch}">
			<div class="border">
			<table class="mypageResultTable">
				<caption>마이페이지</caption>
				<tr class="mypageResultTr">
					<c:forEach var ="mypage" items = "${onlyMypageSearch}">
					<td class = "resultTd">
						<table class="friendTb">
							<tr>
								<td rowspan="2"><a href="showMyPagePost?title=${mypage.title}"><img
										src="${mypage.img}" class="profileM"></a></td>
								<td colspan="2"><a href="showMyPagePost?title=${mypage.title}" class="nameB">${mypage.title}</a></td>
							</tr>
							<tr>
								<td class="btnTd mypage">
								<form action="#" method="get">
								<button class="btn btn-small btn-info"
										id="followBtn" type="button">
										<div id="btnDiv"><input type="hidden" name="title" value="${mypage.title}">
										<span class="glyphicon glyphicon-hand-up"
											aria-hidden="true"></span>팔로잉하기</div>
									</button>
									</form></td>			
									
							</tr>
						</table>
					</td>
					</c:forEach>
				</tr>
			</table>
			</div>
			</c:if>		
		</div>
		</div>
			
	</body>
</html>