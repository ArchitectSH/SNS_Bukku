package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dto.BlockUserDTO;



public class BlockUserDAOImpl extends BaseDAO implements BlockUserDAO {
	private final static String GET_BLOCK_USER_SQL = "SELECT * FROM block_user_tb";
	private final static String GET_BLOCK_USER_BY_REQID_SQL = "SELECT * FROM block_user_tb WHERE block_request_id=?";
	private final static String GET_BLOCK_USER_BY_BLOCKEDID_SQL = "SELECT * FROM block_user_tb WHERE blocked_id=?";
	private final static String GET_BLOCK_USER_PAIR_SQL = "SELECT * FROM block_user_tb WHERE block_request_id=? AND blocked_id=?";
	private final static String DELETE_BLOCKED_USER_SQL = "DELETE FROM block_user_tb WHERE blocked_id=?";
	private final static String DELETE_BLOCK_REQUEST_USER_SQL = "DELETE FROM block_user_tb WHERE block_request_id=?";
	private final static String DELETE_BLOCK_USER_SQL = "DELETE FROM block_user_tb WHERE blocked_id=? AND block_request_id=?";
	private final static String INSERT_BLOCK_USER_SQL = "INSERT INTO block_user_tb VALUES(block_user_seq.nextval, ?, ?)";
	@Override
	public List<BlockUserDTO> getBlockUser() throws DAOException {
		// TODO Auto-generated method stub
		List<BlockUserDTO> blockUserDTOs = new ArrayList<BlockUserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_BLOCK_USER_SQL );
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				BlockUserDTO blockUserDTO = new BlockUserDTO();
				blockUserDTO.setBlockUserNo(resultSet.getInt("block_user_no"));
				blockUserDTO.setBlockedId(resultSet.getString("blocked_id"));
				blockUserDTO.setBlockRequestId(resultSet.getString("block_request_id"));
				blockUserDTOs.add(blockUserDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting BlockUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return blockUserDTOs;
	}
	@Override
	public List<BlockUserDTO> getBlockUserByReqId(String requestId)
			throws DAOException {
		// TODO Auto-generated method stub
		List<BlockUserDTO> blockUserDTOs = new ArrayList<BlockUserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_BLOCK_USER_BY_REQID_SQL );
			pStatement.setString(1,requestId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				BlockUserDTO blockUserDTO = new BlockUserDTO();
				blockUserDTO.setBlockUserNo(resultSet.getInt("block_user_no"));
				blockUserDTO.setBlockedId(resultSet.getString("blocked_id"));
				blockUserDTO.setBlockRequestId(resultSet.getString("block_request_id"));
				blockUserDTOs.add(blockUserDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting BlockUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return blockUserDTOs;
	}
	@Override
	public List<BlockUserDTO> getBlockUserByBlockedId(String blockedId)
			throws DAOException {
		// TODO Auto-generated method stub
		List<BlockUserDTO> blockUserDTOs = new ArrayList<BlockUserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_BLOCK_USER_BY_BLOCKEDID_SQL );
			pStatement.setString(1,blockedId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				BlockUserDTO blockUserDTO = new BlockUserDTO();
				blockUserDTO.setBlockUserNo(resultSet.getInt("block_user_no"));
				blockUserDTO.setBlockedId(resultSet.getString("blocked_id"));
				blockUserDTO.setBlockRequestId(resultSet.getString("block_request_id"));
				blockUserDTOs.add(blockUserDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting BlockUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return blockUserDTOs;
	}
	@Override
	public BlockUserDTO getBlockUserPair(String requestId, String blockedId)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		BlockUserDTO blockUserDTO=null;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_BLOCK_USER_PAIR_SQL);
			pStatement.setString(1,requestId);
			pStatement.setString(2,blockedId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				blockUserDTO = new BlockUserDTO();
				blockUserDTO.setBlockUserNo(resultSet.getInt("block_user_no"));
				blockUserDTO.setBlockedId(resultSet.getString("blocked_id"));
				blockUserDTO.setBlockRequestId(resultSet.getString("block_request_id"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting blockUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return blockUserDTO;

	}
	@Override
	public void deleteBlockedUser(String blockedId) throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_BLOCKED_USER_SQL );
			pStatement.setString(1,blockedId);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting blockUserDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void deleteBlockRequestUser(String requestId) throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_BLOCK_REQUEST_USER_SQL );
			pStatement.setString(1,requestId);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting blockUserDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void deleteBlockUserPair(String requestId, String blockedId)
			throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_BLOCK_USER_SQL );
			
			pStatement.setString(1,blockedId);
			pStatement.setString(2,requestId);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting blockUserDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void insertBlockUser(String blockedId, String blockRequestId)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_BLOCK_USER_SQL);
			pStatement.setString(1,blockedId);
			pStatement.setString(2,blockRequestId);
		   pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error inserting blockUserDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	}
	  /* public static void main(String[] args) {
		      // TODO Auto-generated method stub
		      DependencyInjector injector = new DependencyInjector();
		      try{
		         injector.start();
		         BlockUserDAO blockUserDAO = (BlockUserDAO)injector.getObject(BlockUserDAO.class);
		         
		         try{
		           /* blockUserDAO.insertBlockUser("id1", "id2");
		            blockUserDAO.insertBlockUser("id2", "id5");
		       /*     blockUserDAO.insertBlockUser("id3", "id4");
		            blockUserDAO.insertBlockUser("id5", "id1");*/
		         /*   System.out.println("=============================");
		            System.out.println(blockUserDAO.getBlockUser());
		            System.out.println("=============================");
		            System.out.println(blockUserDAO.getBlockUserByBlockedId("id3"));
		            System.out.println("=============================");
		            System.out.println(blockUserDAO.getBlockUserByReqId("id3"));
		      /*      System.out.println("=============================");
		            System.out.println(blockUserDAO.getBlockUserPair("id1", "id5"));
		            System.out.println("=============================");
		           blockUserDAO.deleteBlockedUser("id3");
		            System.out.println("=============================");
		           blockUserDAO.deleteBlockRequestUser("id3");
		            System.out.println("=============================");
		            blockUserDAO.deleteBlockUserPair("id1", "id5");
		            
		            System.out.println("=============================");
		            System.out.println(blockUserDAO.getBlockUser());
		            
		            
		            //productDAO.insert(product);
		         }catch(Exception e){
		            e.printStackTrace();
		         }
		      }finally{
		         injector.shutDown();
		      }

		   }*/
}