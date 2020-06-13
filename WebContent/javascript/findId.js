onload	=function(){
	//인증코드 입력버튼
	$(function() {
		var $inputCodeBtn = $('#inputCodeBtn');
		$inputCodeBtn.click(function(e) {
			document.getElementById('all_popup').style.display='none';
			document.body.className='';
			document.getElementById('all_popup2').style.display='';
			document.body.className='';
		});
	});
	
	$(function() {
		var $cancelCodeBtn = $('#cancelCodeBtn');
		$cancelCodeBtn.click(function(e) {
			document.getElementById('all_popup').style.display='none';
			document.body.className='';
		});
	});
	
	$(function() {
		var $nextBtn = $('#nextBtn');
		$nextBtn.click(function(e) {
			if(document.getElementById('choice').checked){
				document.getElementById('codeKind').innerHTML="입력하신 이메일로 인증코드를 발송했습니다.";
			}
			else{
				document.getElementById('codeKind').innerHTML="입력하신 핸드폰으로 인증코드를 발송했습니다.";
			}
			document.getElementById('all_popup').style.display=''; 
			document.body.className='mpopup';
		});
	});
	
}