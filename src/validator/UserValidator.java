package validator;

import java.util.ArrayList;
import java.util.List;

import form.UserInfoForm;
import form.UserProfileForm;
import form.UserSearchForm;

public class UserValidator {
	public List<String> validate(UserSearchForm userSearchForm){
		return new ArrayList<String>();
	}
	public List<String> validate(UserProfileForm userProfileForm){
		return null;
	}
	public List<String> validate(UserInfoForm userInfoForm){
		/*추후 제대로 유효성 검증 필요*/
		System.out.println();
		List<String> errors= new ArrayList<String>();
		String birth = userInfoForm.getBirth();
		if(birth ==null || birth.trim().isEmpty()){
			errors.add("날짜를 입력하세요");
		}		
		String email = userInfoForm.getEmail();
		String id = userInfoForm.getId();
		String name = userInfoForm.getName();
		String password = userInfoForm.getPassword();
		String phoneNumber = userInfoForm.getPhoneNumber();
		String gender = userInfoForm.getGender();

		try{
			Integer.parseInt(gender);
		}catch(NumberFormatException e)
		{
			errors.add("성별 값이 잘못되었습니다.");
		}
		return errors;
	}

}
