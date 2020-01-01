<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@include file="/WEB-INF/views/includes/header.jsp" %>

<h1 class="contents">user info page</h1>

<p> 아이디 : <sec:authentication property="principal.member.userid" /></p>
<p> 닉네임 : <sec:authentication property="principal.member.userName" /></p>
<p> 가입일 : <sec:authentication property="principal.member.regDate" /></p>


<br>
<a href="/">※ 탈퇴 (미구현) </a>

<%@include file="/WEB-INF/views/includes/footer.jsp" %>
