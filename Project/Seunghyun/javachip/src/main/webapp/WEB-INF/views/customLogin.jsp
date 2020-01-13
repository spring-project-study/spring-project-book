<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@include file="/WEB-INF/views/includes/header.jsp" %>

<h1>로그인</h1>
<h2>${error}</h2>
<h2>${logout}</h2>

<form method="post" action="/login">
	<div>
		<input type="text" name="username">
	</div>
	<div>
		<input type="password" name="password">
	</div>
	<div>
		<input type="submit">
	</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>

<%@include file="/WEB-INF/views/includes/footer.jsp" %>
