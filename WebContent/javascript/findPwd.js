onload	=function(){
	//�����ڵ� �Է¹�ư
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
				document.getElementById('codeKind').innerHTML="�Է��Ͻ� �̸��Ϸ� �����ڵ带 �߼��߽��ϴ�.";
			}
			else{
				document.getElementById('codeKind').innerHTML="�Է��Ͻ� �ڵ������� �����ڵ带 �߼��߽��ϴ�.";
			}
			document.getElementById('all_popup').style.display=''; 
			document.body.className='mpopup';	
		});
	});
	
}