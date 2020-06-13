package validator;

import java.util.ArrayList;
import java.util.List;

import form.MyPageForm;

public class MyPageValidator {
	public List<String> validate(MyPageForm myPageForm) {
		List<String> errors = new ArrayList<String>();
		String check = myPageForm.getTitle();
		if(check == null || check.trim().isEmpty()){
			errors.add("���������� �̸��� �Է��ϼ���!!");
		}
		check = myPageForm.getMyPageIntroduction();
		if(check == null || check.trim().isEmpty()){
			errors.add("���������� �Ұ����� �Է��ϼ���!!");
		}
		check = myPageForm.getImg();
		if(check == null || check.trim().isEmpty()){
			errors.add("���������� �̹����� ÷���ϼ���!!");
		}
		else{
			int lastIndex = check.lastIndexOf(".");
			String imgName = check.substring(lastIndex+1);
			//System.out.println(imgName);
			if(!imgName.toLowerCase().equals("jpg") && !imgName.toLowerCase().equals("png")){
				errors.add("�̹����� jpg�� png�� ÷�ΰ����մϴ�!");
			}
		}
		return errors;
	}
	
	public String searchValidate(String myPageTitle) {
		return null;
	}
}
