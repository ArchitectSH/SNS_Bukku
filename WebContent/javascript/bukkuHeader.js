	// 마우스 이벤트에 따른 margin값 참조 변수
	var startX;
	var targetX	=0;
	//  html요소 참조를 위한 변수 선언
	var mContainer;
	var container;
	var tab;
	var START_WIDTH =170; // 메뉴 가로 넓이 

	onload	=function(){
		
		// 브라우저 체크 
		var isIE	= ( navigator.userAgent.indexOf("MSIE") > 0 ) ;

		// 컨텐이너 참조 구하기  
		mContainer	= document.getElementById("menuContainer");
		container	= document.getElementById("container");
		tab			= document.getElementById("tab");
		
		// 메뉴 리스트 배열 선언
		var menuList=[];
		menuList.push( "Home" );
		menuList.push( "나의소식" );
		menuList.push( "그룹" );
		menuList.push( "페이지" );
		menuList.push( "나의친구" );
		menuList.push( "회원찾기" );

		// document에 동적으로 메뉴 구성
		var i;
		var menuItem;
		// menuList값에 따라 menuItem동적 생성
		for( i=0; i<menuList.length; i++ ){
			menuItem	= document.createElement( "a" );
			if(i==0){
				menuItem.setAttribute("href", "home");
			}else if(i==1){
				menuItem.setAttribute("href", "myPost");
			}else if(i==3){
				menuItem.setAttribute( "href", "myPage_list.do" );
			}else if(i==4){
				menuItem.setAttribute( "href", "friendList" );
			}else if(i==5){
				menuItem.setAttribute( "href", "search" );
			}else{
				menuItem.setAttribute( "href", "#" );
			}
			if( isIE ){
				menuItem.innerText	= menuList[i];
			} else {
				menuItem.textContent	= menuList[i];
			}
			container.appendChild( menuItem );
		}

		// getBoundingClientRect메서드호를 이용하여 요소의 현재 정보를 얻어올 수 있다. 
		var rect			= container.getBoundingClientRect();
		var tw				= rect.height;
		var gap				= tab.scrollWidth;
		// 메뉴 시작 위치 지정 
		startX	= parseInt(-START_WIDTH);      
		mContainer.style.width  	= START_WIDTH+gap+"px";
		mContainer.style.marginLeft	= startX+"px";
		container.style.width 		= START_WIDTH +"px";
		tab.style.height 			= tw+"px";
		
		var sidebar = document.getElementById("menuContainer");
		sidebar.addEventListener("mouseover", onMouseOver_Container);
		sidebar.addEventListener("mouseout", onMouseOut_Container);

		//환경설정메뉴
		$(function() {
			var $settings = $('a#settings');
			$settings.click(function(e) {
				e.preventDefault();
				$(this).parent().find('ul.setting').toggle();
			});
		});
		//알람 메뉴
		$(function() {
			var $alarms = $('a#alarms');
			$alarms.click(function(e2){
				e2.preventDefault();
				$(this).parent().find('table.alarms').toggle();
			});
		});
		//마이페이지
		$(function() {
			var $makePageA = $('#makePageA');
			$makePageA.click(function(e) {
				document.getElementById('all_popup').style.display=''; 
				document.body.className='mpopup';
			});
		});
		$(function() {
			var $cancelBtn = $('#cancelMyPageBtn');
			$cancelBtn.click(function(e) {
				document.getElementById('all_popup').style.display='none'; 
				document.body.className='';
			});
		});
		//도움말
		$(function() {
			var $helpBtn = $('#helpBtn');
			$helpBtn.click(function(e) {
				document.getElementById('all_popup2').style.display=''; 
				document.body.className='mpopup';
			});
		});
		$(function() {
			var $closePop = $('#closePop');
			$closePop.click(function(e) {
				document.getElementById('all_popup2').style.display='none'; 
				document.body.className='';
			});
		});
		//그룹
		$(function() {
			var $makeGroupA = $('#makeGroupA');
			$makeGroupA.click(function(e) {
				document.getElementById('all_popup3').style.display=''; 
				document.body.className='mpopup';
			});
		});
		$(function() {
			var $cancelGroupBtn = $('#cancelGroupBtn');
			$cancelGroupBtn.click(function(e) {
				document.getElementById('all_popup3').style.display='none'; 
				document.body.className='';
			});
		});
		//건의사항
		$(function() {
			var $opinionBtn = $('#opinionBtn');
			$opinionBtn.click(function(e) {
				document.getElementById('all_popup4').style.display=''; 
				document.body.className='mpopup';
			});
		});
		$(function() {
			var $cancelOpinionBtn = $('#cancelOpinionBtn');
			$cancelOpinionBtn.click(function(e) {
				document.getElementById('all_popup4').style.display='none'; 
				document.body.className='';
			});
		});
		//마이페이지 만들기 버튼
		$(function(){
			
			$("#makeMyPageBtn").click(function sb_fc(){
				var title = $("#myPageTitle").val();
				var intro = $("#intro").val();
				var file = $("#file").val();
				if(title=="" && intro=="" && file==""){
					alert("페이지 이름과 소개글을 입력하고, 페이지 사진을 첨부해 주세요!");
				}
				else if(title==""){
					alert("페이지 이름을 입력해 주세요!");
				}
				else if(intro==""){
					alert("페이지 소개글을 입력해 주세요!");
				}
				else if(file==""){
					alert("페이지 사진을 첨부해 주세요!");
				}
				else{
					$("#makePageFrm").submit();
				}
			});	
		});
		
		
		//알람
		$(function() {
               $.ajax({
                  type:"GET",
                  url: "alarm.do",
                  //contentType: "application/x-www-form-urlencoded; charset=utf-8",
                  //data: str,
                  datatype:"json", 
                  success: function(data) {
                     console.log(data); // 이건 지금 데이터가 넘오온 값을 담은 변수이고
                     // $table = $this.parents('.commentDiv').find('table:not(.addComment)');
                     var alarmCount=0;
                     if(data.length >= 7){data.length = 7;}
                     var i =0;
                     for(i =0; i<data.length; i++){
                    	 if(data[i].checkAlarm == 0){	//안읽은 글
			                  alarmCount++;
                    	 }
                    }
                     $alarms=$('#friendManage');
                     if(alarmCount!=0)
                    	 $alarms.append("<span class='badge' style='color:yellow'>"+alarmCount+"</span>");
                     },
                  error: function(e) {
                     console.log(e);
                     alert("에러발생");
                  }         
               });
         });
		
		
		$(function() {
               $("#alarmName").html('');
               $("#alarmName").html('<td colspan="2">알림</td>');
               //var str = $(this).parents(".HHG").parents().parents().serialize();
               // alert(str);
               //console.log()
               $.ajax({
                  type:"GET",
                  url: "alarm.do",
                  //contentType: "application/x-www-form-urlencoded; charset=utf-8",
                  //data: str,
                  datatype:"json", 
                  success: function(data) {
                     console.log(data); // 이건 지금 데이터가 넘오온 값을 담은 변수이고
                     // $table = $this.parents('.commentDiv').find('table:not(.addComment)');
                     if(data.length >= 7){data.length = 7;}
                     var i =0;
                     for(i =0; i<data.length; i++){
                    	 if(data[i].checkAlarm == 0){	//안읽은 글
	                    	 if(data[i].mypageTitle != null){	//마페로갈때
		                    	 if(data[i].activityKind == "님이 회원님을 마이페이지에 초대하셨습니다."){
		                    		 if(data[i].bukkuIndex <= 50){
					                     $newAlarm = "<tr style='background:rgb(185, 205, 229);'>"
					                    	 			+"<td><div><a href='alarm_page_go.do?title="+data[i].mypageTitle+"&alarmNo="+data[i].alarmNo+"&checkAlarm="+data[i].checkAlarm+"'><img src="+data[i].senderProfileImg+" class='profileS'>"
					                     				+"<span>"+data[i].senderName+"</span>"+data[i].activityKind+"</a></div></td></tr>";
			                    	 }
			                    	 else{
			                    		 $newAlarm = "<tr style='background: rgb(238, 238, 238);'>"
					                    	 			+"<td><div><a href='alarm_page_go.do?title="+data[i].mypageTitle+"&alarmNo="+data[i].alarmNo+"&checkAlarm="+data[i].checkAlarm+"'><img src="+data[i].senderProfileImg+" class='profileS'>"
					                     				+"<span>"+data[i].senderName+"</span>"+data[i].activityKind+"</a></div></td></tr>";
			                    	 }
		                    	 }
		                    	 else{
		                    		 if(data[i].bukkuIndex <= 50){
					                     $newAlarm = "<tr style='background: rgb(185, 205, 229);'>"
					                    	 			+"<td><div><a href='alarm_page_main.do?title="+data[i].mypageTitle+"&alarmNo="+data[i].alarmNo+"&checkAlarm="+data[i].checkAlarm+"'><img src="+data[i].senderProfileImg+" class='profileS'>"
					                     				+"<span>"+data[i].senderName+"</span>"+data[i].activityKind+"</a></div></td></tr>";
			                    	 }
			                    	 else{
			                    		 $newAlarm = "<tr style='background: rgb(238, 238, 238);'>"
			                    	 			+"<td><div><a href='alarm_page_main.do?title="+data[i].mypageTitle+"&alarmNo="+data[i].alarmNo+"&checkAlarm="+data[i].checkAlarm+"'><img src="+data[i].senderProfileImg+" class='profileS'>"
			                     				+"<span>"+data[i].senderName+"</span>"+data[i].activityKind+"</a></div></td></tr>";
			                    	 }
		                    	 }
	                    	 }
	                    	 else if(data[i].postNo != 0){	//포스트로갈때
	                    		 if(data[i].bukkuIndex <= 50){
				                     $newAlarm = "<tr style='background: rgb(185, 205, 229);'>"
				                    	 			+"<td><div><a href='alarm_post_go.do?postNo="+data[i].postNo+"&alarmNo="+data[i].alarmNo+"&checkAlarm="+data[i].checkAlarm+"'><img src="+data[i].senderProfileImg+" class='profileS'>"
				                     				+"<span>"+data[i].senderName+"</span>"+data[i].activityKind+"</a></div></td></tr>";
		                    	 }
		                    	 else{
		                    		 $newAlarm = "<tr style='background: rgb(238, 238, 238);'>"
		                    	 			+"<td><div><a href='alarm_post_go.do?postNo="+data[i].postNo+"&alarmNo="+data[i].alarmNo+"&checkAlarm="+data[i].checkAlarm+"'><img src="+data[i].senderProfileImg+" class='profileS'>"
		                     				+"<span>"+data[i].senderName+"</span>"+data[i].activityKind+"</a></div></td></tr>";
		                    	 }
	                    	 }
	                    	 else if(data[i].activityKind=="님이 친구추가를 요청하셨습니다."){	//걍 친구관련
		                    	$newAlarm = "<tr style='background: rgb(238, 238, 238);'>"
		                    	 	+"<td><div><a href='alarm_friend_accpet_go.do?senderId="+data[i].senderId+"&alarmNo="+data[i].alarmNo+"&checkAlarm="+data[i].checkAlarm+"'><img src="+data[i].senderProfileImg+" class='profileS'>"
		                     		+"<span>"+data[i].senderName+"</span>"+data[i].activityKind+"</a></div></td></tr>";
	                    	 }else{	//걍 친구관련
			                    	$newAlarm = "<tr style='background: rgb(238, 238, 238);'>"
			                    	 	+"<td><div><a href='alarm_friend_go.do?id="+data[i].senderId+"&senderId="+data[i].senderId+"&alarmNo="+data[i].alarmNo+"&checkAlarm="+data[i].checkAlarm+"'><img src="+data[i].senderProfileImg+" class='profileS'>"
			                     		+"<span>"+data[i].senderName+"</span>"+data[i].activityKind+"</a></div></td></tr>";
		                    	 }
                    	 }
                    	 else{	//읽은 글
	                    	 if(data[i].mypageTitle != null){	//마페로갈때
	                    		 if(data[i].activityKind == "님이 회원님을 마이페이지에 초대하셨습니다."){
			                    	 if(data[i].bukkuIndex <= 50){
					                     $newAlarm = "<tr style='background: rgb(217, 217, 217);'>"
						                    	 	+"<td><div><a href='alarm_page_go.do?title="+data[i].mypageTitle+"&alarmNo="+data[i].alarmNo+"&checkAlarm="+data[i].checkAlarm+"'><img src="+data[i].senderProfileImg+" class='profileS'>"
				                     				+"<span>"+data[i].senderName+"</span>"+data[i].activityKind+"</a></div></td></tr>";
			                    	 }
			                    	 else{
			                    		 $newAlarm = "<tr style='background: rgb(217, 217, 217);'>"
				                    			 		+"<td><div><a href='alarm_page_go.do?title="+data[i].mypageTitle+"&alarmNo="+data[i].alarmNo+"&checkAlarm="+data[i].checkAlarm+"'><img src="+data[i].senderProfileImg+" class='profileS'>"
				                    			 		+"<span>"+data[i].senderName+"</span>"+data[i].activityKind+"</a></div></td></tr>";
			                    	 }
	                    		 }
	                    		 else{
			                    	 if(data[i].bukkuIndex <= 50){
					                     $newAlarm = "<tr style='background: rgb(217, 217, 217);'>"
						                    	 	+"<td><div><a href='alarm_page_main.do?title="+data[i].mypageTitle+"&alarmNo="+data[i].alarmNo+"&checkAlarm="+data[i].checkAlarm+"'><img src="+data[i].senderProfileImg+" class='profileS'>"
				                     				+"<span>"+data[i].senderName+"</span>"+data[i].activityKind+"</a></div></td></tr>";
			                    	 }
			                    	 else{
			                    		 $newAlarm = "<tr style='background: rgb(217, 217, 217);'>"
				                    			 		+"<td><div><a href='alarm_page_main.do?title="+data[i].mypageTitle+"&alarmNo="+data[i].alarmNo+"&checkAlarm="+data[i].checkAlarm+"'><img src="+data[i].senderProfileImg+" class='profileS'>"
				                    			 		+"<span>"+data[i].senderName+"</span>"+data[i].activityKind+"</a></div></td></tr>";
			                    	 }
	                    		 }
	                    	 }
	                    	 else if(data[i].postNo != 0){	//포스트로갈때
	                    		 if(data[i].bukkuIndex <= 50){
				                     $newAlarm = "<tr style='background: rgb(217, 217, 217);'>"
				                    	 			+"<td><div><a href='alarm_post_go.do?postNo="+data[i].postNo+"&alarmNo="+data[i].alarmNo+"&checkAlarm="+data[i].checkAlarm+"'><img src="+data[i].senderProfileImg+" class='profileS'>"
				                     				+"<span>"+data[i].senderName+"</span>"+data[i].activityKind+"</a></div></td></tr>";
		                    	 }
		                    	 else{
		                    		 $newAlarm = "<tr style='background: rgb(217, 217, 217);'>"
		                    	 			+"<td><div><a href='alarm_post_go.do?postNo="+data[i].postNo+"&alarmNo="+data[i].alarmNo+"&checkAlarm="+data[i].checkAlarm+"'><img src="+data[i].senderProfileImg+" class='profileS'>"
		                     				+"<span>"+data[i].senderName+"</span>"+data[i].activityKind+"</a></div></td></tr>";
		                    	 }
	                    	 }else if(data[i].activityKind=="님이 친구추가를 요청하셨습니다."){	//걍 친구관련
			                    	$newAlarm = "<tr style='background: rgb(217, 217, 217);'>"
			                    	 	+"<td><div><a href='alarm_friend_accpet_go.do?senderId="+data[i].senderId+"&alarmNo="+data[i].alarmNo+"&checkAlarm="+data[i].checkAlarm+"'><img src="+data[i].senderProfileImg+" class='profileS'>"
			                     		+"<span>"+data[i].senderName+"</span>"+data[i].activityKind+"</a></div></td></tr>";
		                    	 }else{	//걍 친구관련
				                    	$newAlarm = "<tr style='background: rgb(217, 217, 217);'>"
				                    	 	+"<td><div><a href='alarm_friend_go.do?id="+data[i].senderId+"&senderId="+data[i].senderId+"&alarmNo="+data[i].alarmNo+"&checkAlarm="+data[i].checkAlarm+"'><img src="+data[i].senderProfileImg+" class='profileS'>"
				                     		+"<span>"+data[i].senderName+"</span>"+data[i].activityKind+"</a></div></td></tr>";
			                    	 }
                    	 }
                    	// alert($newAlarm);
                    	 $("#alarmName").append($newAlarm);//.hide().slideDown(500);
                     }
                  },
                  error: function(e) {
                     console.log(e);
                     alert("에러발생");
                  }         
               });
         });
		
		
		
		
		$(function() {      		
       	    $('#searchBtn').click(function(e){
       	    	$("#searchForm").submit();
            });
        });
	};

	
	// 마우스 이벤트에 따른 margin값 변경
	function onMouseOver_Container(){
		mContainer	= document.getElementById("menuContainer");
		mContainer.style.marginLeft= targetX+"px";
	};


	function onMouseOut_Container(){
		mContainer	= document.getElementById("menuContainer");
		mContainer.style.marginLeft=startX+"px";
	};