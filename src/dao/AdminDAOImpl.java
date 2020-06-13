package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.AdminDTO;



public class AdminDAOImpl extends BaseDAO implements AdminDAO {
	private final static String GET_ADMIN_SQL = "SELECT * FROM admin_tb";
	private final static String GET_ADMIN_BY_ID_SQL = "SELECT admin_pass FROM admin_tb WHERE admin_id=?";
	private final static String UPDATE_ADMIN_SQL = "UPDATE admin_tb SET admin_pass =? WHERE admin_id=?";
	private final static String DELETE_ADMIN_SQL = "DELETE FROM admin_tb WHERE admin_id=? AND admin_pass=?";
	private final static String INSERT_ADMIN_SQL = "INSERT INTO admin_tb VALUES(?,?)";
	@Override
	public List<AdminDTO> getAdmin() throws DAOException {
		// TODO Auto-generated method stub

		List<AdminDTO> adminDTOs = new ArrayList<AdminDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ADMIN_SQL );
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				AdminDTO adminDTO = new AdminDTO();
				adminDTO.setAdminId(resultSet.getString("admin_id"));
				adminDTO.setAdminPass(resultSet.getString("admin_pass"));
				adminDTOs.add(adminDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting AdminDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return adminDTOs;
	}
	@Override
	public AdminDTO getAdminById(String adminId) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		AdminDTO adminDTO=null;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ADMIN_BY_ID_SQL );
			pStatement.setString(1,adminId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				adminDTO = new AdminDTO();
				adminDTO.setAdminId(resultSet.getString("admin_id"));
				adminDTO.setAdminPass(resultSet.getString("admin_pass"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting adminDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return adminDTO;
	}
	@Override
	public void updateAdmin(String password, String adminId)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_ADMIN_SQL );
		
			pStatement.setString(1, password);
			pStatement.setString(2, adminId);
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating adminDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	}
	@Override
	public void deleteAdmin(String adminId, String password)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_ADMIN_SQL );
			pStatement.setString(1, adminId);
			pStatement.setString(2, password);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting adminDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	

	}
	@Override
	public void insertAdmin(String adminId, String password)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_ADMIN_SQL );
			pStatement.setString(1, adminId);
			pStatement.setString(2,password);
		   pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error inserting adminDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}

	}
}