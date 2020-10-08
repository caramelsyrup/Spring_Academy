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
	<h1>정보 상세 보기</h1>
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
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.addr}</td>
				<td>${user.memo}</td>
				<td>${user.reg_date}</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td><button type="button" onclick="location.href='update.my?id=${user.id}'" >수정하기</button></td>
				<td><button type="reset" onclick="location.href='delete.my?id=${user.id}'" >삭제하기</button></td>
				<td><button type="reset" onclick="location.href='list.my'" >목록으로</button></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>