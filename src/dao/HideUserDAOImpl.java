package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.HideUserDTO;


public class HideUserDAOImpl extends BaseDAO implements HideUserDAO {
	private final static String GET_HIDE_USER_SQL = "SELECT * FROM hide_user_tb";
	private final static String GET_HIDE_USER_BY_HIDENUM_SQL = "SELECT * FROM hide_user_tb WHERE hide_no =?";
	private final static String GET_HIDE_USER_BY_POSTNUM_SQL = "SELECT * FROM hide_user_tb WHERE post_no = ?";
	private final static String GET_HIDE_USER_BY_ID_SQL = "SELECT * FROM hide_user_tb WHERE id = ?";
	private final static String GET_HIDE_USER_COUNT_SQL = "SELECT COUNT(*) FROM hide_user_tb WHERE post_no=?";
	private final static String DELETE_HIDE_USER_BY_POSTNUM_SQL = "DELETE hide_user_tb WHERE post_no =?";
	private final static String DELETE_HIDE_USER_BY_HIDENUM_SQL = "DELETE hide_user_tb WHERE hide_no = ?";
	private final static String DELETE_HIDE_USER_BY_ID_SQL = "DELETE hide_user_tb WHERE id =?";
	private final static String DELETE_HIDE_USER_BY_ID_POSTNUM_SQL = "DELETE hide_user_tb WHERE id =? AND post_no=?";
	private final static String INSERT_HIDE_USER_SQL = "INSERT into hide_user_tb values(hide_user_seq.NEXTVAL,?,?)";
	@Override
	public List<HideUserDTO> getHideUser() throws DAOException {
		// TODO Auto-generated method stub

		List<HideUserDTO> hideUserDTOs = new ArrayList<HideUserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_HIDE_USER_SQL );
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				HideUserDTO hideUserDTO = new HideUserDTO();
				hideUserDTO.setHideNo(resultSet.getInt("hide_no"));
				hideUserDTO.setPostNo(resultSet.getInt("post_no"));
				hideUserDTO.setId(resultSet.getString("id"));
				hideUserDTOs.add(hideUserDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting HideUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return hideUserDTOs;
	}
	@Override
	public HideUserDTO getHideUserByHideNum(Integer hideNum)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		HideUserDTO hideUserDTO=null;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_HIDE_USER_BY_HIDENUM_SQL );
			pStatement.setInt(1,hideNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				hideUserDTO = new HideUserDTO();
				hideUserDTO.setHideNo(resultSet.getInt("hide_no"));
				hideUserDTO.setPostNo(resultSet.getInt("post_no"));
				hideUserDTO.setId(resultSet.getString("id"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting hideUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return hideUserDTO;
	}
	@Override
	public List<HideUserDTO> getHideUserByPostNum(Integer postNum)
			throws DAOException {
		// TODO Auto-generated method stub
		List<HideUserDTO> hideUserDTOs = new ArrayList<HideUserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_HIDE_USER_BY_POSTNUM_SQL );
			pStatement.setInt(1,postNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				HideUserDTO hideUserDTO = new HideUserDTO();
				hideUserDTO.setHideNo(resultSet.getInt("hide_no"));
				hideUserDTO.setPostNo(resultSet.getInt("post_no"));
				hideUserDTO.setId(resultSet.getString("id"));
				hideUserDTOs.add(hideUserDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting HideUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return hideUserDTOs;
	}
	@Override
	public List<HideUserDTO> getHideUserById(String id) throws DAOException {
		// TODO Auto-generated method stub
		List<HideUserDTO> hideUserDTOs = new ArrayList<HideUserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_HIDE_USER_BY_ID_SQL );
			pStatement.setString(1,id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				HideUserDTO hideUserDTO = new HideUserDTO();
				hideUserDTO.setHideNo(resultSet.getInt("hide_no"));
				hideUserDTO.setPostNo(resultSet.getInt("post_no"));
				hideUserDTO.setId(resultSet.getString("id"));
				hideUserDTOs.add(hideUserDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting HideUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return hideUserDTOs;
	}
	@Override
	public Integer getHideUserCount(Integer postNum) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		int num = 0;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_HIDE_USER_COUNT_SQL );
			pStatement.setInt(1,postNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				
				num=resultSet.getInt("COUNT(*)");
			
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting hideUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return num;

	}
	@Override
	public void deleteHideUserByPostNum(Integer postNum) throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_HIDE_USER_BY_POSTNUM_SQL );
			pStatement.setInt(1, postNum);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting hideUserDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	

	}
	@Override
	public void deleteHideUserByHideNum(Integer hideNum) throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_HIDE_USER_BY_HIDENUM_SQL );
			pStatement.setInt(1, hideNum);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting hideUserDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	

	}
	@Override
	public void deleteHideUserById(String id) throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_HIDE_USER_BY_ID_SQL );
			pStatement.setString(1, id);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting hideUserDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	

	}
	@Override
	public void deleteHideUserByIdPostNum(String id, Integer postNum)
			throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_HIDE_USER_BY_ID_POSTNUM_SQL );
			pStatement.setString(1, id);
			pStatement.setInt(2, postNum);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting hideUserDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	

	}
	@Override
	public void insertHideUser(Integer postNum, String id) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_HIDE_USER_SQL );
			pStatement.setInt(1, postNum);
			pStatement.setString(2,id);
		   pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error inserting hideUserDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}


	}
	/*public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      DependencyInjector injector = new DependencyInjector();
	      try{
	         injector.start();
	         HideUserDAO hideUserDAO = (HideUserDAO)injector.getObject(HideUserDAO.class);
	         
	         try{
	            
	            System.out.println("=============================");
	           /* hideUserDAO.insertHideUser(18, "id3");
	            hideUserDAO.insertHideUser(18, "id4");
	            hideUserDAO.insertHideUser(19, "id4");
	            hideUserDAO.insertHideUser(20, "id1");
	            System.out.println(hideUserDAO.getHideUser());
	            System.out.println("=============================");
	            System.out.println(hideUserDAO.getHideUserByHideNum(1));
	            System.out.println("=============================");
	            System.out.println(hideUserDAO.getHideUserById("id3"));
	            System.out.println("=============================");
	            System.out.println(hideUserDAO.getHideUserByPostNum(20));
	            System.out.println("=============================");
	            System.out.println(hideUserDAO.getHideUserCount(18));
	            System.out.println("=============================");
	           
	            System.out.println("=============================");*/
	       /*    hideUserDAO.deleteHideUserByHideNum(1);
	            System.out.println("=============================");
	           hideUserDAO.deleteHideUserById("id1");
	            System.out.println("=============================");
	           hideUserDAO.deleteHideUserByIdPostNum("id4", 19);
	            System.out.println("=============================");
	            hideUserDAO.deleteHideUserByPostNum(18);
	            System.out.println(hideUserDAO.getHideUser());
	            
	            //productDAO.insert(product);
	         }catch(Exception e){
	            e.printStackTrace();
	         }
	      }finally{
	         injector.shutDown();
	      }

	   }*/
}