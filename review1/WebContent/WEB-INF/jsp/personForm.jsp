<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>개인 정보 수정</h1>
	<form action="personInsert.sp" method="post">
		<label>이름:</label><input type="text" name="name" id="name" /><br>
		<label>아이디:</label><input type="text" name="id" id="id"/><br>
		<label>패스워드:</label><input type="password" name="pwd" id="password"/><br>
		<label>성별:</label>
		남<input type="radio" name="gender"  value="male"/>
		여<input type="radio"  name="gender" value="female"/><br>
		<label>직업:</label>
		<select name="job">
			<option value="default">-선택-</option>
			<option value="company">회사원</option>
			<option value="actor">배우</option>
			<option value="sportsMan">운동선수</option>
			<option value="teacher">선생</option>
			<option value="student">학생</option>
			<option value="other">기타</option>
		</select>
		<br><br>
		<input type="submit" value="확인"/>
		<input type="reset" value="취소"/>
	</form>
</body>
</html>