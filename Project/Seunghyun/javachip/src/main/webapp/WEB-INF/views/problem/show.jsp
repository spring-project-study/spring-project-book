<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp" %>

<h1 class="title">모든 문제</h1>

<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>종류</th>
			<th>출제자</th>
			<th>등록일</th>
		</tr>
	</thead>
		
	<tbody>
		<c:forEach items="${list}" var="problem">
		<tr>
			<td>${problem.problem_id }</td>
			<td class="problem_title"  id="${problem.problem_id}">${problem.problem_title }</td>
			<td>
				${problem.problem_type.toString()=="m"?"객관식":"주관식"}
			</td>
			<td>${problem.user_name }</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${problem.reg_date}"/></td>
		</tr>
		</c:forEach>
	</tbody>
	
</table>
<%@include file="/WEB-INF/views/includes/footer.jsp" %>

<script type="text/javascript">

	$(document).ready(function(){
		
		var eleList = document.querySelectorAll(".problem_title");
		var len = eleList.length;
		for(var i=0; i<len; ++i){
			var element = eleList[i];
			element.addEventListener("click", function(argu_id){
				return function(){
					document.location.href = "/problem/" +argu_id;
				}
			}(element.id)
			);
		}
	});
	
</script>










