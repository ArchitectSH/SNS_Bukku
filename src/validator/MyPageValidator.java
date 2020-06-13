package validator;

import java.util.ArrayList;
import java.util.List;

import form.MyPageForm;

public class MyPageValidator {
	public List<String> validate(MyPageForm myPageForm) {
		List<String> errors = new ArrayList<String>();
		String check = myPageForm.getTitle();
		if(check == null || check.trim().isEmpty()){
			errors.add("마이페이지 이름을 입력하세요!!");
		}
		check = myPageForm.getMyPageIntroduction();
		if(check == null || check.trim().isEmpty()){
			errors.add("마이페이지 소개글을 입력하세요!!");
		}
		check = myPageForm.getImg();
		if(check == null || check.trim().isEmpty()){
			errors.add("마이페이지 이미지를 첨부하세요!!");
		}
		else{
			int lastIndex = check.lastIndexOf(".");
			String imgName = check.substring(lastIndex+1);
			//System.out.println(imgName);
			if(!imgName.toLowerCase().equals("jpg") && !imgName.toLowerCase().equals("png")){
				errors.add("이미지는 jpg와 png만 첨부가능합니다!");
			}
		}
		return errors;
	}
	
	public String searchValidate(String myPageTitle) {
		return null;
	}
}
