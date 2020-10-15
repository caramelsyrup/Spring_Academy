<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체보기</h1>
	<a href="insert">사용자 추가하기</a>
	<h2>총 사용자 : ${count}</h2>
	<form action="list">
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
			<c:forEach items="${list}" var="user">
				<tr>
					<td><a href="view?id=${user.id}">${user.id}</a></td>
					<td>${user.name}</td>
					<td>${user.gender}</td>
					<td>${user.job}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tbody>
			<tr>
				<td>
					<select name="field">
						<option>==선택==</option>
						<option value="id">[아이디]</option>
						<option value="name">[이름]</option>
					</select>
				</td>
				<td colspan="2">
					<input type="text" name="word">
				</td>
				<td>
					<input type="submit" value="검색하기">
				</td>
			</tr>
		</tbody>
	</table>
	</form>
</body>
</html>