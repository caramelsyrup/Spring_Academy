<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<table class="table">
  <thead class="thead-dark">
  	<tr>
  		<td colspan="4"><h4 class="h4">Total User : ${count}</h4></td>
  		<td colspan="1"><h4 class="h4"><a href="join">추가하기</a></h4></td>
  	</tr>
    <tr>
      <th scope="col">Num</th>
      <th scope="col">Name</th>
      <th scope="col">Account</th>
      <th scope="col">Age</th>
      <th scope="col">Gender</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list.content}" var="user">
    <tr>
      <th scope="row" id="userId">${user.id}</th>
      <td>${user.name}</td>
      <td><a href="view/${user.id}">${user.account}</a></td>
      <td>${user.age}</td>
      <td>${user.gender}</td>
      <td><button type="button" class="btn-btn-dark" id="btnDelete">Delete</button></td>
    </tr>
   </c:forEach>
  </tbody>
  <tfoot>
  	<tr>
  		<td>
		  	<a href="?page=${list.number-1}">Back</a>
			<a href="?page=${list.number+1}">Next</a>
		</td>
	</tr>
  </tfoot>
</table>
<footer class="footer">
<%@ include file="includes/footer.jsp" %>
</footer>
