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
<a href="mInsert">추가하기</a>
<table border="1">
	<thead>
		<tr>
			<td colspan="3">
				총 회원 수 : ${total}
			</td>
		</tr>
		<tr>
			<td>Id</td>
			<td>name</td>
			<td>addr</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list.content}" var="user">
			<tr>
				<td>${user.id}</td>
				<td><a href="${user.id}">${user.name}</a></td>
				<td>${user.addr}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
	<a href="?page=${list.number-1}">이전</a>
	<a href="?page=${list.number+1}">다음</a>
</body>
</html>