let member={
	init:function(){
		$("#btnDelete").on("click",()=>{
			this.delete();
		});
	},
	delete:function(){
		alert("delete");
		$.ajax({
			type:"DELETE",
			url:$("#id").text(),
			dataType:"json"})
			.done(function(resp){
				alert(resp);
				location.href="/";
			})
			.fail(function(error){
				alert(error);
		});
	}
}
member.init();