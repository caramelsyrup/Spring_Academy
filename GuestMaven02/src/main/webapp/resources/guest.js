$(function(){
	getData(1,"","");
});

// 템플릿, for문이나 for-each문을 사용하지 않고 ``를 이용한 방법.
function createHtmlStr(item){
	
	return`
			<tr>
				<td>${item.num}</td>
				<td><a href='javascript:void(0);' onclick='getView("+${item.num}+")'>${item.writter}</a></td>
				<td>${item.content}</td>
				<td>${item.grade}</td>
				<td>${item.created}</td>
				<td>${item.ipaddr}</td>
				<td><a href='javascript:void(0);' onclick='delData("+${item.num}+")'>삭제</a></td>
			</tr>
		`;
}

// 전체 조회, 페이징, 검색기능
function getData(pageNum,field,word){
	$.get("glist",{"pageNum":pageNum,"field":field,"word":word},
		function(resp){
			// 개수세기
			var countStr = "<div align='center'>총 게시물 수 : "+resp.count+"</div>";
			$("#count").html(countStr);
			// 리스트
			var listTitle = "";
			listTitle += "<tr><td>글번호</td><td>작성자</td><td>내용</td><td>등급</td><td>작성일</td><td>주소</td></tr>";
			$("#listArea thead").addClass().html(listTitle);
			
/*			var listContent ="";
				$.each(resp.list,function(key,val){
					// listStr += "<td>"+val.num+"</td>"
					// ``를 이용하는 방법
					listContent +=
						`<tr>
							<td>${val.num}</td>
							<td><a href='javascript:void(0);' onclick='getView("+${val.num}+")'>${val.writter}</a></td>
							<td>${val.content}</td>
							<td>${val.grade}</td>
							<td>${val.created}</td>
							<td>${val.ipaddr}</td>
							<td><a href='javascript:void(0);' onclick='delData("+${val.num}+")'>"+"삭제</a></td>
						</tr>
						`;
				});
			$("#listArea tbody").html(listContent);	
*/
			
/*			for(i=0; i<resp.list.length;i++){
				listStr += "<tr><td>"+resp.list[i].num+"</td>";
				listStr += "<td><a href='javascript:void(0);' onclick='getView("+resp.list[i].num+")'>"+resp.list[i].writter+"</a></td>";
				listStr += "<td>"+resp.list[i].content+"</td>";
				listStr += "<td>"+resp.list[i].grade+"</td>";
				listStr += "<td>"+resp.list[i].created+"</td>";
				listStr += "<td>"+resp.list[i].ipaddr+"</td>";
				listStr += "<td><a href='javascript:void(0);' onclick='delData("+resp.list[i].num+")'>"+"삭제</a></td></tr>";
			}*/
		//	$("#listArea").html(listStr);
			// 해당 영역에 화면 출력.
			var container = document.querySelector("#listArea tbody");
			// 함수를 작성하여서, 출력.
			container.innerHTML=resp.list.map(item=>createHtmlStr(item)).join('').replace(/null/gi,"");
			
			// 페이징
			var pageStr = "<div align='center'>"+resp.pageHtml+"</div>";
			$("#pageHtml").html(pageStr);
		}	// 콜백시 실행되는 함수
	);	// get 콜백 함수
}	// getData 비동기 실행을 위한 함수

// 상세보기 함수
function getView(num){
	$.get("gview",{"num":num},
		function(resp){
			// resp는 JSON형태의 데이터.
			var TittleStr="";
			TittleStr+="상세보기화면";
			$("#viewArea h2").html(TittleStr);
			var viewTit = "";
			viewTit += "<tr><td>글번호</td><td>작성자</td><td>내용</td><td>등급</td><td>작성일</td><td>주소</td></tr>"
			$("#viewArea thead").html(viewTit);
			var viewCon = "";
			viewCon+="<tr><td>"+resp.num+"</td>";
			viewCon+="<td>"+resp.writter+"</td>";
			viewCon+="<td>"+resp.content+"</td>";
			viewCon+="<td>"+resp.grade+"</td>";
			viewCon+="<td>"+resp.created+"</td>";
			viewCon+="<td>"+resp.ipaddr+"</td>";
			viewCon+="<td><a href='javascript:void(0);'onclick='upData("+resp.num+")'>"+"수정</a></td></tr>";
			$("#viewArea tbody").html(viewCon);
		}
	);
}

// 수정하기 함수
function upData(num){
	$.get("gupdate",{"num":num},
		function(){
			
		}
	);
}

// 삭제하기 함수
function delData(num){
	$.get("gdelete",{"num":num},
		function(resp){
			if(resp=="success"){
				alert("삭제성공");
				getData(1,"","");
			}
		}
	);
}	
	