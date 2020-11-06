<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</head>
<body>
	<h1>수정하기 폼</h1>
	<form>
		<table border="1">
			<thead>
				<tr>
					<td>아이디</td>
					<td>이름</td>
					<td>주소</td>
					<td>수정</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" value="${user.id}" size="1" id="id" name="id" readonly="readonly"></td>
					<td><input type="text" value="${user.name}" size="7" id="name" name="name" ></td>
					<td><input type="text" value="${user.addr}" size="10" id="addr" name="addr" ></td>
					<td><input type="button" id="btnUpdate" value="수정하기"/></td>
				</tr>
			</tbody>
		</table>
	</form>	
	<h2><a href="/list">목록으로</a></h2>
	<script src="/js/member1.js"></script>
</body>
</html>