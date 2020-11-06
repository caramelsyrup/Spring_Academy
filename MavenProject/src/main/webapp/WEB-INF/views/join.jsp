<%@ include file="includes/header.jsp" %>

<form action="/user/join" method="post" >
<div class="container-md">
  <div class="row">
    <div class="col-10" align="center"><h1 class="h1">Join View</h1></div>
    <div class="col-8">Please write your information.</div>
  	<div class="w-100"></div>
    <div class="col-2"><h5 class="h5">Account</h5></div>
    <div class="col-9"><input type="text" id="account" name="account"></div>
    <div class="col-2"><h5 class="h5">Password</h5></div>
    <div class="col-9"><input type="text" id="password" name="password"></div>
    <div class="col-2"><h5 class="h5">Name</h5></div>
    <div class="col-9"><input type="text" id="name" name="name"></div>
    <div class="col-2"><h5 class="h5">Gender</h5></div>
    <div class="col-9">
    	<input type="checkbox" id="gender" name="gender" value="male">Male
    	<input type="checkbox" id="gender" name="gender" value="female">Female
    </div>
    <div class="col-2"><h5 class="h5">Age</h5></div>
    <div class="col-9"><input type="number" id="age" name="age"></div>
    <div class="w-100"></div>
    <div class="col-3"><input type="submit" id="btnJoin" value="Join"></div>
    <div class="col-3"><input type="reset" id="btnReset" value="Reset"></div>
    <div class="col-3"><input type="button" id="btnback" value="Back"></div>
  </div>
</div>
</form>

<footer class="footer">
<%@ include file="includes/footer.jsp" %>
</footer>
