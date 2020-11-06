<%@ include file="includes/header.jsp" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Get Hotel</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="user/login">Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="join">Join</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
      </li>
    </ul>
  </div>
</nav>
<form action="" method="post">
<div class="container" align="center">
  <div class="row">
    <div class="col-9"><h1 class="h1">Login View</h1></div>
    <div class="col-10"><img src="/resources/img/bell.jpg" class="img-fluid" alt="Responsive image" align="middle"></div>
    <div class="col-4"><h3 class="h3">UserAccount</h3></div>
    <div class="col-6"><input type="text" placeholder="write your Account" id="account" name="account"></div>
    <div class="col-4"><h3 class="h3">UserPassword</h3></div>
    <div class="col-6"><input type="password" placeholder="write your Password" id="password" name="password"></div>
    <div class="col-5"><input type="button" class="btn btn-dark" id="btnLogin" value="Login"></div>
    <div class="col-5"><input type="reset" class="btn btn-light" id="btnLogin" value="reset"></div>
  </div>
</div>
</form>
