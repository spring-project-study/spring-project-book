<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@include file="/WEB-INF/views/includes/header.jsp" %>


<h1>Logout Page</h1>
<form action="/customLogout" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<button>로그아웃</button>
</form>

