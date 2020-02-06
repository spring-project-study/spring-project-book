<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java"  pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ include file="../include/header.jsp"%>
<div class="row">
		<h1>문제리스트 </h1>
</div>
<!-- /.row -->
<div class="container h-100">
	<div class="row h-100 align-items-center justify-content-center text-center">
		<div class="col-lg-10 align-self-end">
			<div class="panel-heading">
				Question List Page
				<button id='regBtn' type="button" class="btn btn-xs pull-right">Register New Question</button>
			</div>
			<!-- /.panel-heading -->
			<div class='container'>
				<div class="col-lg-12">
					<form id='searchForm' action="/problem/list" method='get'>
						<select name='type'>
                    		<option value="T">제목</option>
                    		<option value="W">출제자</option>
                    		<option value="C">내용</option>
                    	</select>
                    	<input type='text' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>'/>
                    	<input type='hidden' name='pageNum' value = '${pageMaker.cri.pageNum}'>          
  						<input type='hidden' name='amount' value = '${pageMaker.cri.amount}'>  
   						<button class='btn btn-primary btn-xs'>Search</button>
                    </form>
                </div>
            </div>
			<div class="container">
				<table class="table">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>유형</th>
							<th>출제자</th>
							<th>등록일</th>
						</tr>
					</thead>
					<c:forEach items="${list}" var="problem">
						<tr>
							<td><c:out value="${problem.problem_id}" /></td>
							<td><a class='move' href='<c:out value="${problem.problem_id}"/>'>
									<c:out value="${problem.problem_title}" />
							</a></td>
							<td>
								<c:set var="problem_type" value="${problem.problem_type}"/>
								<c:if test="${fn:contains(problem_type, 'M')}">객관식</c:if>
								<c:if test="${fn:contains(problem_type, 'S')}">주관식</c:if>
							</td>
							<td><c:out value="${problem.user_name}" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${problem.reg_date}" /></td>
						</tr>
					</c:forEach>
				</table>
				<!-- /.panel-body -->
				<div class="align-items-center justify-content-center text-center">
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li class="paginate_button prev page-link"><a href="${pageMaker.startPage-1}">Prev</a></li>
						</c:if>
						<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<li class="paginate_button page-link ${pageMaker.cri.pageNum == num ? "active":""}"><a href="${num}">${num}</a></li>
						</c:forEach>
						<c:if test="${pageMaker.next}">
							<li class="paginate_button next page-link"><a href="${pageMaker.endPage+1}">Next</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-6 -->
	</div>
</div>
<!-- /.row -->
<form id='actionForm' action="/problem/list" method="get">
	<input type='hidden' name='pageNum' value = '${pageMaker.cri.pageNum}'>          
  	<input type='hidden' name='amount' value = '${pageMaker.cri.amount}'>   
  	<input type='hidden' name='keyword' value = '${pageMaker.cri.keyword}'>
  	<input type='hidden' name='type' value='${pageMaker.cri.type}'>
</form>
<script type="text/javascript">
$(document).ready(function() {
	var actionForm = $("#actionForm");
    $(".paginate_button a").on("click", function(e) {
    	e.preventDefault();
		console.log('click');
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	});
    
    var searchForm = $("#searchForm");
	$("#searchForm button").on("click", function(e) {
		if (!searchForm.find("input[name='keyword']").val()) {
			alert("input a keyword . ");
			return false;
		}	
		searchForm.find("input[name='pageNum']").val("1");
		e.preventDefault();

		searchForm.submit();
	});
});
</script>
<%@ include file="../include/footer.jsp"%>
