<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<title>register page</title>
</head>
<body>
	<h1>Member Register Page</h1>
	
	<form method="post" action="/register">
		<div> 아이디를 입력하세요.(영어)</div>
		<div>
			<input type="text" name="userid">
		</div>
		<br>
		
		<div> 비밀번호를 입력하세요.</div>
		<div>
			<input type="password" name="userpw" >
		</div>
		<br>
		
		
		<div> 닉네임을 입력하세요.</div>
		<div>
			<input type="text" name="userName">
		</div>
		<br>
		
		<div>
			<input type="submit">
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>

</body>
</html>


