<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@include file="/WEB-INF/views/includes/header.jsp"%>

<h1 class="title">문제 등록</h1>


<form method="post" action="/problem/register">
	<div> 제목을 입력하세요.</div>
	<div>
		<input type="text" name="problem_title" >
	</div>
	<br>
	
	<div> 내용을 입력하세요.</div>
	<div>
		<textarea name="problem_content" rows=20></textarea>
	</div>
	<br>
	
	<c:forEach var="i" begin="1" end="10">
		<div>
			<input type="checkbox" name="choice_list[${i}].chk_answer"> 
			<input type="text" name="choice_list[${i}].choice_content">
		</div>
	</c:forEach>

	<div>
		<input type="submit" value="등록">
	</div>
	<input type="hidden" name="user_id" 
		value="<sec:authentication property="principal.member.user_id" />" />
	<input type="hidden" name="user_name" 
		value="<sec:authentication property="principal.member.user_name" />" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<%@include file="/WEB-INF/views/includes/footer.jsp"%>







