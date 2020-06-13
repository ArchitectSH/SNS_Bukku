package dao ;

import java.util.List ;

import dto.UserDTO;

public interface UserDAO extends DAO{
	public List<UserDTO> getUser() throws DAOException;
		
	 
	
	public UserDTO getUserById(String id) throws DAOException;
	
	 
	
	public List<UserDTO> getUserByName(String name) throws DAOException;
	
	 
	
	public UserDTO getUserByEmail(String email) throws DAOException;
	
	 
	
	public UserDTO getUserByPhoneNumber(String phoneNumber) throws DAOException;
	
	 
	
	public List<UserDTO> getUserByGender(Integer gender) throws DAOException;
	
	 
	
	public List<UserDTO> getUserByBirth(String birth) throws DAOException;
	
	 
	
	public List<UserDTO> getUserBySchool(String school) throws DAOException;
	
	 
	
	public List<UserDTO> getUserByLocation(String location) throws DAOException;
	
	 
	
	public List<UserDTO> getUserByAllInfo(String id, String name, String email, String phoneNumber, Integer gender, String birth, String school, String location) throws DAOException;
	public List<UserDTO> getUserByNameSchool(String name, String school) throws DAOException;
	public List<UserDTO> getUserByNameGenderBirth(String name,Integer gender, String birth) throws DAOException;
	//Ãß°¡Áß
	/*public String getUserIdByNameAndPhone(String name,String phoneNumber)throws DAOException;
	public String getUserIdByNameAndEmail(String name,String email)throws DAOException;
	public String getUserPwByIdAndEmail(String id,String email)throws DAOException;
	public String getUserPwByIdAndPhone(String id,String phoneNumber)throws DAOException;
	 */
	 
	
	public void updateUserPassword(String id, String password, String newPassword) throws DAOException;
	
	 
	
	public void updateUserProfileImg(String id, String password, String newProfileImg) throws DAOException;
	
	 
	
	public void updateUserEmail(String id, String password, String newEmail) throws DAOException;
	
	 
	
	public void updateUserPhoneNumber(String id, String password, String newPhoneNumber) throws DAOException;
	
	 
	
	public void updateUserGender(String id, String password, Integer newGender) throws DAOException;
	
	public void updateUserSchool(String id,String password,String newSchool)throws DAOException;
	public void updateUserLocation(String id,String password,String newLocation)throws DAOException;
	public void updateUserInfo(String newPassword, String newEmail,String newPhoneNumber, Integer newGender, String id, String password) throws DAOException;
	public void updateUserProfile(String newProfileImg, String newSchool,String newLocation,String id, String password) throws DAOException;
	public void deleteUser(String id,String password)throws DAOException;
	public void insertUser(String id,String name,String password,String email,String phoneNumber,Integer gender,String birth,String school,String location) throws DAOException;
}