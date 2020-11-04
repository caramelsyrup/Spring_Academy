<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>리스트</h1>
<table border="1">
	<thead>
		<tr>
			<td>Id</td>
			<td>name</td>
			<td>addr</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="user">
			<tr>
				<td>${user.id}</td>
				<td><a href="${user.id}">${user.name}</a></td>
				<td>${user.addr}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>