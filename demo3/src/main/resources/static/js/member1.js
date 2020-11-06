let member={
	init:function(){
		// function(){} 대신에 ()=>{}의 람다 식을 사용한다.
		// 콜백함수의 this는 윈도우 객체를 받게 된다. 콜백함수는 끝내고 다시 실행하는 것이기 떄문에.
		// 원래 의도의 this 원래 작업중인 어떤 것이지만...
		$("#btnDelete")
		.on("click",
			()=>{
				this.delete();
			}
		);
		
		$("#btnUpdate")
		.on("click",
			()=>{
				this.update();
			}
		);
		
	},
	
	delete:function(){
		alert('ajax - 삭제함수실행');
		$.ajax({
			type:"DELETE",
			url:$("#id").text()	// val은 input에서 값을 찾을떄
		})
		.done(function(resp){
			alert(resp);
			location.href="/";
		})
		.fail(function(error){
			alert(error);
		})
	},
	
	update:function(){
		
		var dataParam = {
			"name":$("#name").val(),
			"addr":$("#addr").val(),
			"id":$("#id").val()
		}
		
		var id = $("#id").val();
		
		$.ajax({
			type:"PUT",
			url:"/update/"+id,
			data:JSON.stringify(dataParam),
			contentType:"application/json;charset=utf-8"
		})
		.done(function(resp){
			alert('수정성공!');
			location.href="/list";
		})
		.fail(function(error){
			alert('수정실패');
		});
	}
}
member.init();