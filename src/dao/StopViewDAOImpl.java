package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.StopViewDTO;



public class StopViewDAOImpl extends BaseDAO implements StopViewDAO {
	private final static String GET_STOP_VIEW_SQL = "SELECT * FROM stop_view";
	private final static String GET_STOP_VIEW_BY_USER_STOP_SQL = "SELECT * FROM stop_view WHERE user_stop=?";
	private final static String GET_STOP_VIEW_BY_ID_SQL = "SELECT * FROM stop_view WHERE id=?";
	@Override
	public List<StopViewDTO> getStopView() throws DAOException {
		// TODO Auto-generated method stub

		List<StopViewDTO> stopViewDTOs = new ArrayList<StopViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_STOP_VIEW_SQL );
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				StopViewDTO stopViewDTO = new StopViewDTO();
				stopViewDTO.setId(resultSet.getString("id"));
				stopViewDTO.setUserStop(resultSet.getBoolean("user_stop"));
				stopViewDTO.setName(resultSet.getString("name"));
				stopViewDTO.setProfileImg(resultSet.getString("profile_img"));
				stopViewDTOs.add(stopViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting StopViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return stopViewDTOs;
	}
	@Override
	public List<StopViewDTO> getStopViewByUserStop(Integer userStop)
			throws DAOException {
		// TODO Auto-generated method stub
		List<StopViewDTO> stopViewDTOs = new ArrayList<StopViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_STOP_VIEW_BY_USER_STOP_SQL );
			pStatement.setInt(1,userStop);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				StopViewDTO stopViewDTO = new StopViewDTO();
				stopViewDTO.setId(resultSet.getString("id"));
				stopViewDTO.setUserStop(resultSet.getBoolean("user_stop"));
				stopViewDTO.setName(resultSet.getString("name"));
				stopViewDTO.setProfileImg(resultSet.getString("profile_img"));
				stopViewDTOs.add(stopViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting StopViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return stopViewDTOs;
	}
	@Override
	public StopViewDTO getStopViewById(String id) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		StopViewDTO stopViewDTO=null;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_STOP_VIEW_BY_ID_SQL );
			pStatement.setString(1,id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				stopViewDTO = new StopViewDTO();
				stopViewDTO.setId(resultSet.getString("id"));
				stopViewDTO.setUserStop(resultSet.getBoolean("user_stop"));
				stopViewDTO.setName(resultSet.getString("name"));
				stopViewDTO.setProfileImg(resultSet.getString("profile_img"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting stopViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return stopViewDTO;
	}
	/* public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      DependencyInjector injector = new DependencyInjector();
	      try{
	         injector.start();
	         StopViewDAO stopViewDAO = (StopViewDAO)injector.getObject(StopViewDAO.class);
	         
	         try{
	            System.out.println(stopViewDAO.getStopView());
	            System.out.println("=============================");
	            System.out.println(stopViewDAO.getStopViewById("id1"));
	            System.out.println("=============================");
	            System.out.println(stopViewDAO.getStopViewByUserStop(0));
	            System.out.println("=============================");
	           
	            
	            //productDAO.insert(product);
	         }catch(Exception e){
	            e.printStackTrace();
	         }
	      }finally{
	         injector.shutDown();
	      }

	   }*/
}