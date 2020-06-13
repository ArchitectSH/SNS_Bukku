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
		menuList.push( "나의 소식" );
		menuList.push( "그룹" );
		menuList.push( "페이지" );
		menuList.push( "나의친구" );
		menuList.push( "회원찾기" );

		// document에 동적으로 메뉴 구성
		var i;
		var menuItem;
		var tabItem;
		// menuList값에 따라 menuItem동적 생성
		for( i=0; i<menuList.length; i++ ){
			menuItem	= document.createElement( "a" );
			menuItem.setAttribute( "href", "#" );
			if( isIE ){
				menuItem.innerText		= menuList[i];
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

		function scroll_follow( id )
		{
		  $(window).scroll(function( )  //스크롤이 움직일때마다 이벤트 발생
		  { 
			  var position = $(window).scrollTop(); // 현재 스크롤바의 위치값을 반환합니다.
			  $( id ).stop().animate({top:position+20+"px"}, 0); //해당 오브젝트 위치값 재설정
		   });
		}
		scroll_follow( "#mymenu" );
		scroll_follow( "#profileMain" );
		function scroll_follow2( id )
		{
		  $(window).scroll(function( )  //스크롤이 움직일때마다 이벤트 발생
		  { 
			  var position = $(window).scrollTop(); // 현재 스크롤바의 위치값을 반환합니다.
			  $( id ).stop().animate({top:position+150+"px"}, 0); //해당 오브젝트 위치값 재설정
		   });
		}
		scroll_follow2( "#searchPost" );
		//스크롤이 생기도록 <br> 을 여러게 넣은 부분..
		$(document).ready(function(){ for( var i=0; i<200; i++ ) {$('#brr').html($('#brr').html());} });

		//환경설정메뉴
		$(function() {
			var $settings = $('a#settings');

			$settings.click(function(e) {
				e.preventDefault();
				$(this).parent().find('ul.settings').toggle();
			});
		});
		
		//클릭이벤트리스너
		$(function(){
			$("#helpBtn").click(helpBtnClick);
			$("#closePop").click(closePopClick);
		});
	};

	// 마우스 이벤트에 따른 margin값 변경
	function onMouseOver_Container(){
		mContainer.style.marginLeft= targetX+"px";
	}


	function onMouseOut_Container(){
		mContainer.style.marginLeft=startX+"px";
	}
	
	function helpBtnClick(){
		$("#all_popup").css({"display":""});
	}
	
	function closePopClick(){
		$("#all_popup").css({"display":"none"});
	}