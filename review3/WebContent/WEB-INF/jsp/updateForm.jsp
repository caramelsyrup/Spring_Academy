<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsertForm</title>
</head>
<body>
	<h1>회원정보 수정 페이지</h1>
	<input type="button" value="목록" onclick="location.href='member_list.me'">
	<form action="member_update.me" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="${user.id}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass" value="${user.pass}"></td>
			</tr>
			<tr>
				<td>성명</td>
				<td><input type="text" name="name" value="${user.name}"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" value="${user.addr}"></td>
			</tr>
			<tr>
				<td>메모</td>
				<td><input type="text" name="memo" value="${user.memo}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="수정"></td>
				<td><input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>