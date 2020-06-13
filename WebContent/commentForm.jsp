<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td rowspan="2"><a href="#"><img class="profile"></a></td>
			<td><a href="#" class="name"></a></td>
			<td class="dateCommentTd">date<a href="#" id="editComment">
			<img src="image/edit.JPG" id="editCommentImg"/></a> <a href="deleteComment?commentNo=commentNo" id="deleteCommentBtn">X</a>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="recommendP">content</td>
		</tr>
	</table>
</body>
</html>