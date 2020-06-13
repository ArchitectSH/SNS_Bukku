package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.CommonRelationDTO;


public class CommonRelationDAOImpl extends BaseDAO implements CommonRelationDAO {
	private final static String GET_COMMON_RELATION_SQL = "SELECT * FROM common_relation_tb";
	private final static String GET_COMMON_RELATION_BY_FRIEND_NUM_SQL = "SELECT * FROM common_relation_tb WHERE friend_no =?";
	private final static String GET_BUKKU_LIMIT_SQL = "SELECT bukku_limit FROM common_relation_tb WHERE friend_no =?";
	private final static String UPDATE_BUKKU_SQL = "UPDATE common_relation_tb SET bukku_limit = bukku_limit-1, bukku_act_date=sysdate WHERE friend_no=?";
	private final static String RESET_BUKKU_LIMIT_SQL = "UPDATE common_relation_tb SET bukku_limit = 5";
	private final static String DELETE_COMMON_RELATION_SQL = "DELETE FROM common_relation_tb WHERE friend_no=?";
	private final static String INSERT_COMMON_RELATION_SQL = "INSERT INTO common_relation_tb VALUES(common_relation_seq.nextval,5,sysdate)";
	@Override
	public List<CommonRelationDTO> getCommonRelation() throws DAOException {

		List<CommonRelationDTO> commonRelationDTOs = new ArrayList<CommonRelationDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_COMMON_RELATION_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				CommonRelationDTO commonRelationDTO = new CommonRelationDTO();
				commonRelationDTO.setFriendNo(resultSet.getInt("friend_no"));
				commonRelationDTO.setBukkuLimit(resultSet.getInt("bukku_limit"));
				commonRelationDTO.setBukkuActDate(resultSet.getString("bukku_act_date"));
				commonRelationDTOs.add(commonRelationDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting CommonRelationDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return commonRelationDTOs;
	}
	@Override
	public CommonRelationDTO getCommonRelationByFriendNum(Integer friendNum)
			throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		CommonRelationDTO commonRelationDTO=null;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_COMMON_RELATION_BY_FRIEND_NUM_SQL );
			pStatement.setInt(1,friendNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				commonRelationDTO = new CommonRelationDTO();
				commonRelationDTO.setFriendNo(resultSet.getInt("friend_no"));
				commonRelationDTO.setBukkuLimit(resultSet.getInt("bukku_limit"));
				commonRelationDTO.setBukkuActDate(resultSet.getString("bukku_act_date"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting commonRelationDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return commonRelationDTO;
	}
	@Override
	public Integer getBukkuLimit(Integer friendNum) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		int bukkuLimit = 0;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_BUKKU_LIMIT_SQL );
			pStatement.setInt(1,friendNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
		
				bukkuLimit = resultSet.getInt("bukku_limit");
				
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting commonRelationDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return new Integer(bukkuLimit);
	}
	@Override
	public void updateBukku(Integer friendNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_BUKKU_SQL );
	
			pStatement.setInt(1, friendNum);
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating commonRelationDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
		
	}
	@Override
	public void resetBukkuLimit() throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(RESET_BUKKU_LIMIT_SQL );

		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating commonRelationDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
		
	}
	@Override
	public void deleteCommonRelation(Integer friendNum) throws DAOException {
		// TODO Auto-generated method stub


		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_COMMON_RELATION_SQL );
			pStatement.setInt(1, friendNum);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting commonRelationDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	

	}
	@Override
	public Integer insertCommonRelation() throws DAOException {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement2 = null;
		int no =0;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_COMMON_RELATION_SQL );
		   pStatement.executeUpdate();
			pStatement2 = connection.prepareStatement("SELECT common_relation_seq.CURRVAL from dual");
			resultSet= pStatement2.executeQuery();
	
			while(resultSet.next()){				
				no = resultSet.getInt("CURRVAL");			
			}
		}catch(Exception e)
		{
			throw new DAOException("Error inserting commonRelationDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
		return new Integer(no);
	}
	
	
	   /*public static void main(String[] args) {
		      // TODO Auto-generated method stub
		      DependencyInjector injector = new DependencyInjector();
		      try{
		         injector.start();
		         CommonRelationDAO commonRelationDAO = (CommonRelationDAO)injector.getObject(CommonRelationDAO.class);
		         
		         try{
		            System.out.println(commonRelationDAO.getCommonRelation());
		            System.out.println("=============================");
		            System.out.println(commonRelationDAO.getCommonRelationByFriendNum(1));
		            System.out.println("=============================");
		            System.out.println(commonRelationDAO.getBukkuLimit(1));
		            System.out.println("=============================");
		            commonRelationDAO.insertCommonRelation();
		            System.out.println(commonRelationDAO.getCommonRelation());
		            System.out.println("=============================");
		            commonRelationDAO.updateBukku(1);
		            commonRelationDAO.resetBukkuLimit();
		                
		            System.out.println("=============================");
		            System.out.println(commonRelationDAO.getCommonRelation());
		            
		            //productDAO.insert(product);
		         }catch(Exception e){
		            e.printStackTrace();
		         }
		      }finally{
		         injector.shutDown();
		      }

		   }*/
}