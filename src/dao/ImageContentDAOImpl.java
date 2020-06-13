package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ImageContentDTO;

public class ImageContentDAOImpl extends BaseDAO implements ImageContentDAO {
	private final static String GET_IMAGE_SQL = "SELECT * FROM image_content_tb";
	private final static String GET_IMAGE_BY_NUM_SQL = "SELECT * FROM image_content_tb WHERE image_content_no=?";
	private final static String GET_IMAGE_SQL_BY_CONTETNUM = "SELECT * FROM image_content_tb WHERE post_content_no=?";
	private final static String GET_IMAGE_SQL_BY_POSTNUM = "SELECT * FROM image_content_tb WHERE  post_content_no=(SELECT post_content_no FROM post_tb WHERE post_no=?)";
	private final static String UPDATE_IMAGE_SQL = "UPDATE image_content_tb SET image = ? WHERE image_content_no = ?";
	private final static String DELETE_IMAGE_SQL = "DELETE image_content_tb WHERE image_content_no = ?";
	private final static String DELETE_IMAGE_BY_CONTENTNUM_SQL = "DELETE image_content_tb WHERE post_content_no=?";
	private final static String DELETE_IMAGE_BY_POSTNUM_SQL = "DELETE image_content_tb WHERE post_content_no = (SELECT post_content_no FROM post_tb WHERE post_no =?)";
	private final static String INSERT_IMAGE_SQL = "INSERT INTO image_content_tb VALUES(image_content_seq.NEXTVAL,?,?)";

	public List<ImageContentDTO> getImage() throws DAOException {
		List<ImageContentDTO> imageContents = new ArrayList<ImageContentDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_IMAGE_SQL);
			resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				ImageContentDTO imageContent = new ImageContentDTO();
				imageContent.setImage(resultSet.getString("image"));
				imageContent.setImageContentNo(resultSet.getInt("image_content_no"));
				imageContent.setPostContentNo(resultSet.getInt("post_content_no"));
				imageContents.add(imageContent);
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			closeDBObjects(resultSet, pStatement, connection);
		}
		return imageContents;
	}

	public List<ImageContentDTO> getImageByNum(Integer imageNum)
			throws DAOException {
		List<ImageContentDTO> imageContents = new ArrayList<ImageContentDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_IMAGE_BY_NUM_SQL);
			pStatement.setInt(1, imageNum);
			resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				ImageContentDTO imageContent = new ImageContentDTO();
				imageContent.setImage(resultSet.getString("image"));
				imageContent.setImageContentNo(resultSet.getInt("image_content_no"));
				imageContent.setPostContentNo(resultSet.getInt("post_content_no"));
				imageContents.add(imageContent);
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			closeDBObjects(resultSet, pStatement, connection);
		}
		return imageContents;
	}

	public List<ImageContentDTO> getImageByContentNum(Integer contentNum)
			throws DAOException {
		List<ImageContentDTO> imageContents = new ArrayList<ImageContentDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			pStatement = connection
					.prepareStatement(GET_IMAGE_SQL_BY_CONTETNUM);
			pStatement.setInt(1, contentNum);
			resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				ImageContentDTO imageContent = new ImageContentDTO();
				imageContent.setImage(resultSet.getString("image"));
				imageContent.setImageContentNo(resultSet.getInt("image_content_no"));
				imageContent.setPostContentNo(resultSet.getInt("post_content_no"));
				imageContents.add(imageContent);
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			closeDBObjects(resultSet, pStatement, connection);
		}
		return imageContents;
	}

	public List<ImageContentDTO> getImageByPostNum(Integer postNum)
			throws DAOException {
		List<ImageContentDTO> imageContents = new ArrayList<ImageContentDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_IMAGE_SQL_BY_POSTNUM);
			pStatement.setInt(1, postNum);
			resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				ImageContentDTO imageContent = new ImageContentDTO();
				imageContent.setImage(resultSet.getString("image"));
				imageContent.setImageContentNo(resultSet.getInt("image_content_no"));
				imageContent.setPostContentNo(resultSet.getInt("post_content_no"));
				imageContents.add(imageContent);
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			closeDBObjects(resultSet, pStatement, connection);
		}
		return imageContents;
	}

	public void updateImage(String image, Integer imageNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_IMAGE_SQL);
			pStatement.setString(1, image);
			pStatement.setInt(2, imageNum);
			pStatement.executeQuery();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			closeDBObjects(null, pStatement, connection);
		}
	}

	public void deleteImage(Integer imageNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_IMAGE_SQL);
			pStatement.setInt(1, imageNum);
			pStatement.executeQuery();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			closeDBObjects(null, pStatement, connection);
		}
	}

	public void deleteImageByContentNum(Integer contentNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection
					.prepareStatement(DELETE_IMAGE_BY_CONTENTNUM_SQL);
			pStatement.setInt(1, contentNum);
			pStatement.executeQuery();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			closeDBObjects(null, pStatement, connection);
		}
	}

	public void deleteImageByPostNum(Integer postNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection
					.prepareStatement(DELETE_IMAGE_BY_POSTNUM_SQL);
			pStatement.setInt(1, postNum);
			pStatement.executeQuery();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			closeDBObjects(null, pStatement, connection);
		}
	}

	public void insertImage(String image, Integer postContentNum)
			throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_IMAGE_SQL);
			pStatement.setString(1, image);
			pStatement.setInt(2, postContentNum);
			pStatement.executeQuery();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			closeDBObjects(null, pStatement, connection);
		}
	}

	public static void main(String[] args) {
		DependencyInjector di = new DependencyInjector();
		di.start();
		ImageContentDAO imageContentDAO = di.createImageContentDAO();
		try {
			System.out.println(imageContentDAO.getImage());
			System.out.println(imageContentDAO.getImageByContentNum(10));
			System.out.println(imageContentDAO.getImageByNum(1));
			System.out.println(imageContentDAO.getImageByPostNum(10));
			//imageContentDAO.insertImage("wow", 4);
			//imageContentDAO.updateImage("wowoww", 9);
			//imageContentDAO.deleteImage(9);
			//imageContentDAO.deleteImageByContentNum(4);
			//imageContentDAO.deleteImageByPostNum(10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
