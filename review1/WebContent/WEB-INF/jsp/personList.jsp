<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체보기</title>
</head>
<body>
<h1>전체보기</h1>
<p>
	<a href="personForm.sp">추가하기</a>
</p>
<table style="border: 1px,thin,solid; border-color: blue;">
	<thead>
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>성별</td>
			<td>직업</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${userlist}" var="user">
			<tr>
				<td><a href="personView.sp?id=${user.id}">${user.id}</a></td>
				<td>${user.name}</td>
				<td>${user.gender}</td>
				<td>${user.job}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>