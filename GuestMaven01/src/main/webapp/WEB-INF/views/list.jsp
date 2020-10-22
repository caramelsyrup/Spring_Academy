<%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<a href="gInsert">guest 추가</a>
	<div align="center">
		<table>
			<tr>
				<td>총 게시물 수 : </td>
				<td>${count}</td>
			</tr>
			<tr>
				<td>NUM</td>
				<td>작성자</td>
				<td>내용</td>
				<td>등급</td>
				<td>작성일</td>
				<td>IP주소</td>
			</tr>
			<c:forEach items="${list}" var="user">
			<tr>
				<td><a href="javascript:view(${user.num})">${user.num}</a></td>
				<td>${user.writter}</td>
				<td>${user.content}</td>
				<td>${user.grade}</td>
				<td>${user.created}</td>
				<td>${user.ipaddr}</td>
				<td><a href="javascript:fdelete(${user.num})">삭제</a></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="2">
					<select name="field">
						<option>==선택==</option>
						<option value="num">번호</option>
						<option value="writter">작성자</option>
					</select>
				</td>
				<td colspan="3">
					<input type="text" name="word" id="word">
				</td>
				<td>
					<input type="button" value="검색" name="search" onclick="location.href()">
				</td>
			</tr>
		</table>
	</div>	
<%-- 	<div align="center">
		<!-- 이전 -->
		<c:if test="${pu.startPage>pu.pageBlock}">
			<a href="javascript:getdata(${pu.startPage-pu.pageBlock},'${pu.field}','${pu.word}')">[이전]</a>
		</c:if>
		<!-- 페이지 출력 -->
		<c:forEach begin="${pu.startPage}" end="${pu.endPage}" var="i">
			<c:if test="${i==pu.currentPage}">
				<c:out value="${i}"/>
			</c:if>
			<c:if test="${i!=pu.currentPage}">
				<a href="javascript:getdata(${i},'${pu.field}','${pu.word}')">${i}</a>
			</c:if>
		</c:forEach>
		<!-- 다음 -->
		<c:if test="${pu.endPage<pu.totalpage}">
			<a href="javascript:getdata(${pu.endPage+1},'${pu.field}','${pu.word}')">[다음]</a>
		</c:if>
	</div> --%>
	<div align="center">
		${pageHtml}
	</div>
	
</body>
</html>
