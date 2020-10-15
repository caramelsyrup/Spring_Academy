<%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<a href="gInsert">guest 추가</a>
	<table>
		<tr>
			<td>NUM</td>
			<td>작성자</td>
			<td>내용</td>
			<td>등급</td>
			<td>작성일</td>
			<td>IP주소</td>
		</tr>
		<c:forEach items="${list}" var="user">
		<tr>
			<td><a href="location.href=view?${user.num}">${user.num}</a></td>
			<td>${user.writter}</td>
			<td>${user.content}</td>
			<td>${user.grade}</td>
			<td>${user.created}</td>
			<td>${user.ipaddr}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
