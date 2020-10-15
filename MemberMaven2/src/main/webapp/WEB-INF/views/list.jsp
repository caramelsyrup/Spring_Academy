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
	<h1>전체보기</h1>
	<a href="insert.my">회원 가입하기</a>
	<form action="list">
	<table style="border: 1px,thin,solid; border-color: blue;">
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>주소</td>
				<td>메모</td>
				<td>가입일</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="user">
				<tr>
					<td><a href="view.my?id=${user.id}">${user.id}</a></td>
					<td>${user.name}</td>
					<td>${user.addr}</td>
					<td>${user.memo}</td>
					<td>${user.reg_date}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					분류 : 
					<select name="category">
						<option>=선택=</option>
						<option value="name">[이름]</option>
						<option value="id">[아이디]</option>
					</select>
				</td>
				<td colspan="2">
					입력 : <input type="text" name="word">
				</td>
				<td>
					<input type="submit" name="searchBtn" value="검색">
				</td>
			</tr>
		</tfoot>
	</table>
	</form>
</body>
</html>