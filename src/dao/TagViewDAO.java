package dao;

import java.util.List;

import dto.TagViewDTO;

public interface TagViewDAO extends DAO {
	public List<TagViewDTO> getTagView() throws DAOException;
	public List<TagViewDTO> getTagViewByCommentNo(Integer commentNo) throws DAOException;
	public List<TagViewDTO> getTagViewByPostNo(Integer postNo) throws DAOException;
	public List<TagViewDTO> getTagViewByPostNoAndTaggedUserId(Integer postNo, String taggedUserId) throws DAOException;
	public List<TagViewDTO> getTagViewByTaggedUserId(String taggedUserId) throws DAOException;
}
