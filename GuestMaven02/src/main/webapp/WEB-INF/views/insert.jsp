<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/myapp/resources/guest.js"></script>
</head>
<body>
<form action="gInsert" method="post">
	<table>
		<tr>
			<td>
				글쓴이
			</td>
			<td>
				<input type="text" name="writter" id="writter">
			</td>
		</tr>
		<tr>
			<td>
				내용
			</td>
			<td>
				 <input type="text" name="content" id="content">
			</td>
		</tr>
		<tr>
			<td>
				평가
			</td>
			<td>
				매우잘함<input type="radio" name="grade" value="excellent">
				잘함<input type="radio" name="grade" value="good">
				보통<input type="radio" name="grade" value="normal">
				못함<input type="radio" name="grade" value="bad">
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="입력" name="submit" id="submit">
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="목록" name="list" id="list" onclick="location.href='gList'">
			</td>
		</tr>
	</table>
</form>
<br>
	<div id="count"></div>
	
	<div id ="listArea" align="center">
		<table>
			<thead></thead>
			<tbody></tbody>
			<tfoot></tfoot>
		</table>
	</div>
	
	<div id="pageHtml"></div>
	
	<div id="viewArea" align="center">
		<h2></h2>
		<table>
			<thead></thead>
			<tbody></tbody>
			<tfoot></tfoot>
		</table>
	</div>

</body>
</html>