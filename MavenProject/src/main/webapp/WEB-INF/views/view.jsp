<%@ include file="includes/header.jsp" %>

<form>
<div class="container-md">
  <div class="row">
    <div class="col-10" align="center"><h1 class="h1">Join View</h1></div>
    <div class="col-8">Please write your information.</div>
  	<div class="w-100"></div>
  	 <div class="col-2"><h5 class="h5">Id</h5></div>
    <div class="col-9"><input type="text" id="id" name="id" value="${user.id}" readonly="readonly"></div>
    <div class="col-2"><h5 class="h5">Account</h5></div>
    <div class="col-9"><input type="text" id="account" name="account" value="${user.account}" readonly="readonly"></div>
    <div class="col-2"><h5 class="h5">Name</h5></div>
    <div class="col-9"><input type="text" id="name" name="name" value="${user.name}"></div>
    <div class="col-2"><h5 class="h5">Gender</h5></div>
    <div class="col-9">
    	<c:set var="gen" value="${user.gender}" />
    	<c:choose>
    		<c:when test="${gen eq 'male'}">
    			<input type="checkbox" id="mgender" name="gender" value="male" checked="checked">Male
    			<input type="checkbox" id="fgender" name="gender" value="female">Female
    		</c:when>
    		<c:when test="${gen eq 'female'}">
    			<input type="checkbox" id="mgender" name="gender" value="male">Male
    			<input type="checkbox" id="fgender" name="gender" value="female" checked="checked">Female
    		</c:when>
    		<c:otherwise>
	    		<input type="checkbox" id="mgender" name="gender" value="male">Male
	    		<input type="checkbox" id="fgender" name="gender" value="female">Female
    		</c:otherwise>
    	</c:choose>
    </div>
    <div class="col-2"><h5 class="h5">Age</h5></div>
    <div class="col-9"><input type="number" id="age" name="age" value="${user.age}"></div>
    <div class="w-100"></div>
    <div class="col-3"><input type="button" id="btnUpdate" value="Update"></div>
    <div class="col-3"><input type="reset" id="btnReset" value="Reset"></div>
    <div class="col-3"><input type="button" id="btnback" value="Back" onclick="history.back()"></div>
  </div>
</div>
</form>

<footer class="footer">
<%@ include file="includes/footer.jsp" %>
</footer>
