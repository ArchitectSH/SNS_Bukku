
window.onload=function(){
	
	
	document.getElementById("joinBtn").addEventListener("click",function(){
		
		location.href="join.jsp";
		
	});
	document.getElementById("findBtn").addEventListener("click",function(){
		location.href="findChoice.jsp";
	
	});
	document.getElementById("login").addEventListener("click",function(){
		var form = document.getElementById("loginFrm");
		
		form.submit();
	
	});
};
