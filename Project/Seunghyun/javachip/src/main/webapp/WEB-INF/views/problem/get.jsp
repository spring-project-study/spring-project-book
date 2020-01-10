<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp" %>


<ul>
	<h1>${problem.problem_id}. ${problem.problem_title}</h1>	
	<div>출제자: ${problem.user_name }</div>
	<div>출제일: <fmt:formatDate pattern="yyyy-MM-dd" value="${problem.reg_date}"/></div>
	<div>수정일: <fmt:formatDate pattern="yyyy-MM-dd" value="${problem.update_date}"/></div>
	
	<h1>문제</h1>
	<p>${problem.problem_content}</p>
	
	<h1>보기</h1>
	<ol>
		<form = method="post" action="/problem/${problem.problem_id}">
		<c:forEach items="${choicelist}" var="choice">
			<div>
				<input type="checkbox" name="userInputArray" value="${choice.choice_id}"> 
				${choice.choice_content}
			</div>
		</c:forEach>
		<input type="submit" value="제출">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</ol>
</ul>

<%@include file="/WEB-INF/views/includes/footer.jsp" %>

<script>
	if(${isAnswer} == false){
		alert("오답입니다.");
	}
	else{
		alert("정답입니다.");
	}
</script>