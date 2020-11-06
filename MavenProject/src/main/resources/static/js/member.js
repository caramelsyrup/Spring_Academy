$(document).on(function(){

});

let member={
	init:function(){
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
		alert('회원삭제합니다.');
		var id = $("#userId").text();	
		$.ajax({
			type:"DELETE",
			url:"/user/delete/"+id// val은 input에서 값을 찾을떄
		})
		.done(function(resp){
			alert('삭제성공');
			location.href="/user/list";
		})
		.fail(function(error){
			alert(error);
		})
	},
	
	update:function(){
		var gender ="";
		if($('input:checkbox[id="mgender"]').is(":checked")==true){
			gender = 'male';
		}else{
			gender = 'female';
		}
		var dataParam = {
			"account":$("#account").val(),
			"name":$("#name").val(),
			"gender":gender,
			"age":$("#age").val(),
			"id":$("#id").val()
		}
		
		var id = $("#id").val();
		
		$.ajax({
			type:"PUT",
			url:"/user/update/"+id,
			data:JSON.stringify(dataParam),
			contentType:"application/json;charset=utf-8"
		})
		.done(function(resp){
			alert('수정성공!');
			location.href="/user/list";
		})
		.fail(function(error){
			alert('수정실패');
		});
	},
	
}
	member.init();
