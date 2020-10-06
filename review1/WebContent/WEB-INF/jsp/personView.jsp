<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상세보기</h1>
<table>
	<thead>
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>성별</td>
			<td>직업</td>
			<td>비밀번호</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.gender}</td>
			<td>${user.job}</td>
			<td>${user.password}</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td><input type="button" value="수정" onclick="location.href='updateForm.sp?id=${user.id}'"></td>
			<td><input type="button" value="삭제" onclick="location.href='personDelete.sp?id=${user.id}'"></td>
		</tr>
	</tfoot>
</table>
</body>
</html>