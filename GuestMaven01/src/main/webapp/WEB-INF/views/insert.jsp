<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function(){
		$("#submit").on("click",function(){
				var writter = $("#writter").val();
				var content = $("#content").val();
				var grade = $("input:radio[name=grade]:checked").val();
				var postString = "writter="+writter+"&content="+content+"&grade="+grade;
				
				$.ajax({
					type:"post",
					url:"gInsert",
					data:postString,
					success:function(resp){
						alert(resp+"성공");
						},
					error:function(e){
						alert("error"+e);
						}	
					})
			})
		})
</script>
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
</body>
</html>