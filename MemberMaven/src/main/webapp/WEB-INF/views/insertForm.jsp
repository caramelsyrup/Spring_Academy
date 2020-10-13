<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsertForm</title>
</head>
<body>
	<h1>회원가입 페이지</h1>
	<form action="insert" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td>성명</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr"></td>
			</tr>
			<tr>
				<td>메모</td>
				<td><textarea rows="10" cols="22" name="memo"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="가입">
					<input type="reset" value="취소">
					<input type="button" value="뒤로" onclick="history.back()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>