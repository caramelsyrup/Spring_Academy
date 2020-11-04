<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>상세보기</h1>
	<table border="1">
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>주소</td>
				<td>삭제</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><span id="id">${user.id}</span></td>
				<td>${user.name}</td>
				<td>${user.addr}</td>
				<td><button id="btnDelete">삭제</button></td>
			</tr>
		</tbody>
	</table>
	<h2><a href="list">목록으로</a></h2>
	<script src="/js/member1.js"></script>
</body>
</html>