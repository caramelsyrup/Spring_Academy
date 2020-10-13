<%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	회원관리
</h1>
<P> ${serverTime}. </P>
<P> <a href="list">전체명단</a> </P>
<P> <a href="insert">회원가입</a> </P>
</body>
</html>
