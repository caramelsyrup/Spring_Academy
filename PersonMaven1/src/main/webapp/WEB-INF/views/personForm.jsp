<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추가할 자료 양식</title>
</head>
<body>
	<h1>데이터 추가를 위한 작성 양식</h1>
	<form action="insert" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" id="id"/></td>	
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="password" id="password"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" id="name"/></td>
			</tr>	
			<tr>
				<td>성별</td>
				<td>남<input type="radio" name="gender" value="male"/>여<input type="radio" name="gender" value="female"/></td>
			</tr>	
			<tr>
				<td>직업</td>		
				<td>
					<select name="job">
						<option value="office">사무직</option>
						<option value="factory">공장</option>
						<option value="sports">운동선수</option>
						<option value="teacher">선생</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="확인"></td>
				<td><input type="reset" value="취소"></td>
			</tr>					
		</table>
	</form>
</body>
</html>