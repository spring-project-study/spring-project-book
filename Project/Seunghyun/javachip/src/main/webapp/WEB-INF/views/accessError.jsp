<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<title>accessError</title>
</head>
<body>
	<h1>Access Denied Page</h1>
	<h2>${SPRING_SECURITY_403_EXCEPTION.getMessage()}</h2>
	
	<h2>${msg}</h2>

</body>
</html>


