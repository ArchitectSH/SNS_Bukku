package dao;

import java.util.List;

import dto.ImageContentDTO;

public interface ImageContentDAO extends DAO{
	public List<ImageContentDTO> getImage() throws DAOException;
	public List<ImageContentDTO> getImageByNum(Integer imageNum) throws DAOException;
	public List<ImageContentDTO> getImageByContentNum(Integer contentNum) throws DAOException;
	public List<ImageContentDTO> getImageByPostNum(Integer postNum) throws DAOException;
	public void updateImage(String image, Integer imageNum) throws DAOException;
	public void deleteImage(Integer imageNum)  throws DAOException;
	public void deleteImageByContentNum(Integer contentNum)  throws DAOException;
	public void deleteImageByPostNum(Integer postNum) throws DAOException;
	public void insertImage(String image, Integer postContentNum) throws DAOException;
}