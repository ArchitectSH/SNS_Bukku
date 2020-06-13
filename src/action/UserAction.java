package action;

import java.util.List;

import dao.DAOException;
import dao.UserDAO;
import dto.UserDTO;



public class UserAction {
	private UserDAO userDAO;
	

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public List<UserDTO> getUser(){
		List<UserDTO> userDTOs = null;
		try{
			userDTOs = userDAO.getUser();
		}catch(DAOException e){			
		}
		return userDTOs;
	}

	public UserDTO getUserById(String id){
		UserDTO userDTO = null;
		try{
			System.out.println("액션 : "+id);
			userDTO = userDAO.getUserById(id);
		}catch(DAOException e){	
		}
		return userDTO;
	}

	public List<UserDTO> getUserByName(String name){
		List<UserDTO> userDTOs = null;
		try{
			userDTOs = userDAO.getUserByName(name);
		}catch(DAOException e){			
		}
		return userDTOs;
	}

	public UserDTO getUserByEmail(String email){
		UserDTO userDTO = null;
		try{
			userDTO = userDAO.getUserByEmail(email);
		}catch(DAOException e){			
		}
		return userDTO;
	}

	public UserDTO getUserByPhoneNumber(String phoneNumber){
		UserDTO userDTO = null;
		try{
			userDTO = userDAO.getUserByPhoneNumber(phoneNumber);
		}catch(DAOException e){			
		}
		return userDTO;
	}

	public List<UserDTO> getUserByGender(Integer gender){
		List<UserDTO> userDTOs = null;
		try{
			userDTOs = userDAO.getUserByGender(gender);
		}catch(DAOException e){			
		}
		return userDTOs;
	}
	public List<UserDTO> getUserByBirth(String birth){
		List<UserDTO> userDTOs = null;
		try{
			userDTOs = userDAO.getUserByBirth(birth);
		}catch(DAOException e){			
		}
		return userDTOs;
	}

	public List<UserDTO> getUserBySchool(String school){
		List<UserDTO> userDTOs = null;
		try{
			userDTOs = userDAO.getUserBySchool(school);
		}catch(DAOException e){			
		}
		return userDTOs;
	}

	public List<UserDTO> getUserByLocation(String location){
		List<UserDTO> userDTOs = null;
		try{
			userDTOs = userDAO.getUserByLocation(location);
		}catch(DAOException e){			
		}
		return userDTOs;
	}

	public List<UserDTO> getUserByAllInfo(String id, String name, String email,
			String phoneNumber, Integer gender, String birth, String school,
			String location){
		List<UserDTO> userDTOs = null;
		try{
			userDTOs = userDAO.getUserByAllInfo(id, name, email, phoneNumber, gender, birth, school, location);
		}catch(DAOException e){			
		}
		return userDTOs;
	}
	public List<UserDTO> getUserByNameSchool(String name, String school){
		List<UserDTO> userDTOs = null;
		try{
			userDTOs = userDAO.getUserByNameSchool(name, school);
		}catch(DAOException e){			
		}
		return userDTOs;
	}
	public List<UserDTO> getUserByNameGenderBirth(String name,Integer gender, String birth){
		List<UserDTO> userDTOs = null;
		try{
			userDTOs = userDAO.getUserByNameGenderBirth(name, gender, birth);
		}catch(DAOException e){			
		}
		return userDTOs;
	}
	// 추가중
	/*
	 * public String getUserIdByNameAndPhone(String name,String
	 * phoneNumber)throws DAOException; public String
	 * getUserIdByNameAndEmail(String name,String email)throws DAOException;
	 * public String getUserPwByIdAndEmail(String id,String email)throws
	 * DAOException; public String getUserPwByIdAndPhone(String id,String
	 * phoneNumber)throws DAOException;
	 */

	public void updateUserPassword(String id, String password,
			String newPassword){
	
		try{
			userDAO.updateUserPassword(id, password, newPassword);
		}catch(DAOException e){			
		}		
	}

	public void updateUserProfileImg(String id, String password,
			String newProfileImg) {
		try{
			userDAO.updateUserProfileImg(id, password, newProfileImg);
		}catch(DAOException e){			
		}
	}

	public void updateUserEmail(String id, String password, String newEmail){
		try{
			userDAO.updateUserEmail(id, password, newEmail);;
		}catch(DAOException e){			
		}
	}
	public void updateUserPhoneNumber(String id, String password,
			String newPhoneNumber){
		try{
			userDAO.updateUserPhoneNumber(id, password, newPhoneNumber);;
		}catch(DAOException e){			
		}
	}

	public void updateUserGender(String id, String password, Integer newGender){
		try{
			userDAO.updateUserGender(id, password, newGender);
		}catch(DAOException e){			
		}
	}

	public void updateUserSchool(String id, String password, String newSchool){
		try{
			userDAO.updateUserSchool(id, password, newSchool);
		}catch(DAOException e){			
		}
	}

	public void updateUserLocation(String id, String password,
			String newLocation) {
		try{
			userDAO.updateUserLocation(id, password, newLocation);
		}catch(DAOException e){			
		}
	}

	public void updateUserInfo(String newPassword, String newEmail,
			String newPhoneNumber, Integer newGender, String id, String password)
			{
	
		try{
			userDAO.updateUserInfo(newPassword, newEmail, newPhoneNumber, newGender, id, password);
		}catch(DAOException e){			
		}

			}

	public void updateUserProfile(String newProfileImg, String newSchool,
			String newLocation, String id, String password){
		try{
			userDAO.updateUserProfile(newProfileImg, newSchool, newLocation, id, password);
		}catch(DAOException e){			
		}
	}

	public void deleteUser(String id, String password){
		try{
			userDAO.deleteUser(id, password);
		}catch(DAOException e){			
		}
	}

	public void insertUser(String id, String name, String password,
			String email, String phoneNumber, Integer gender, String birth,
			String school, String location){
		try{
			System.out.println("UserAction-> insertUser");
			userDAO.insertUser(id, name, password, email, phoneNumber, gender, birth, school, location);
		}catch(DAOException e){			
		}
	}

}
