<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function(){
		// insert 실행 할 때, list load 하기.
		getData(1,"","");
		// insert 실행
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
						$("#listArea").html(resp);
						},
					error:function(e){
						alert("error"+e);
						}	
					})
			})
		})
		
	function getData(pageNum,field,word){
		$.get("gList",{"pageNum":pageNum,"field":field,"word":word},
				function(resp){
					$("#listArea").html(resp);
				}
			 );	// callback function get	
	}	// function	

	function view(num){
		$.get("gView",{"num":num},function(resp){
				resp = JSON.parse(resp);
				var htmlStr="";
				htmlStr+=resp.writter+"<br>";
				htmlStr+=resp.grade+"<br>";
				htmlStr+=resp.content+"<br>";
				htmlStr+=resp.created+"<br>";
				htmlStr+=resp.ipaddr+"<br>";
				$("#viewArea").html(htmlStr)
			})
	}
	function fdelete(num){
		var result = confirm("정말로 삭제 하시겠습니까?");
		if(result){
			
			$.get("gdelete",{"num":num},function(resp){
			});
			getData(1,"","");
		}else{

		}

	}
	
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
   <!--  <br></br>
		<div align="right">
			<form name="search" id="search">
				<select name="field" id="field">
					<option value="writter">이름</option>
					<option value="content">내용</option>
				</select>
				<input type="text" name="word" id="word">
				<input type="button" value="찾기" id="btnSearch">
			</form>
		</div>
	<br></br> -->
	<div id="listArea" align="center"></div>
	<div id="viewArea" align="center"></div>
</body>
</html>