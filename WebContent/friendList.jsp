<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bukku</title>
<link href="css/friendList.css" rel="stylesheet" type="text/css"></link>
<script src="javascript/friendList.js" type="text/javascript"
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
		 
		 
		</script>
		<div id="allDiv">
			<div id="profileMain">
				<table>
					<tr>
						<td id="profileImage"><a href="#"><img src="${sessionScope.userPublicBean.profileImg}" class="myProfile"/></a></td>
					</tr>
					<tr><td id="profileName">${sessionScope.userPublicBean.name}</td></tr>
				</table>
				<table id="profile">
					<tr><td id="profileInfo">${userBean.school}</td></tr>
					<tr><td id="profileInfo">${userBean.location}</td></tr>
					<tr><td id="profileInfo"><c:if test= "${userBean.gender==1}">남자</c:if>
					<c:if test= "${userBean.gender==2}">여자</c:if></td></tr>
				</table>
			</div>
			<br/>
		<div id="myFriendsDiv">
			<c:forEach var="friendInfoViewBean" items="${friendInfoViewBeans}">
			<%-- 	<form action="" method="get" id="friendForm">
					<input type="hidden" name="userId"
						value="${friendInfoViewBean.friendId}"></form> --%>
						
					<table class="friendTb">
						<tr>
							<td rowspan="2"><a
								href="showUserPost?id=${friendInfoViewBean.friendId}"><img
									src="${friendInfoViewBean.friendProfileImg}" class="profileM"></a></td>
							<td colspan="2"><a
								href="showUserPost?id=${friendInfoViewBean.friendId}"
								class="nameB">${friendInfoViewBean.friendName}</a></td>
						</tr>

						<tr>

							<td class="btnTd ffriendBtnTd friendBtnTd" id="friendBtnTd">
								<form action="#" method="post">
									<input type="hidden" id="userId" name="userId"
										value="${friendInfoViewBean.friendId}" />
									<button class="btn btn-small btn-info ffriendBtn friendBtnTd"
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
											value="${friendInfoViewBean.friendId}" />
										<li><a href="#" id="blockBtn" class="friendBtn"><div
													id="btnDiv">회원차단</div></a></li>
									</form>

									<form method="POST" action="#" class="friendBtnTd">
										<input type="hidden" id="userId" name="userId"
											value="${friendInfoViewBean.friendId}" />
										<li><a href="#" id="removeBtn" class="friendBtn"><div
													id="btnDiv">친구끊기</div></a></li>
									</form>
								</ul>
							</td>
						</tr>
					</table>
			</c:forEach>

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