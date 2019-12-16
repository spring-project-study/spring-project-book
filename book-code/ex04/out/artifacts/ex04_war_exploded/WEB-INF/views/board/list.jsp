<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: gwangyukim
  Date: 2019/12/02
  Time: 10:21 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/left-navi.jsp" %>
<%@include file="../includes/top-bar.jsp" %>
<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Board List</h1>
    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">DataTables Example
                <span style="float:right;"><button id="regBtn" type="button">Register new Board</button></span>
            </h6>

        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>#번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>수정일</th>
                    </tr>
                    </thead>
                    <tbody>
                ${board.get(0)}
<%--                    <c:forEach items="${list}" var="board">--%>
<%--                        <tr>--%>
<%--                            <td>${board.bno}</td>--%>
<%--                            <td><a href="/board/get?bno=<c:out value="${board.bno}"/>">${board.title}</a></td>--%>
<%--                            <td>${board.writer}</td>--%>
<%--                            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}"/></td>--%>
<%--                            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>--%>
<%--                        </tr>--%>
<%--                    </c:forEach>--%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>

<script type="text/javascript">
    $(document).ready(function(){
        var result = '<c:out value="${result}"/>'
        console.log(result)

        $('#regBtn').on("click",function(){
            self.location ="/board/register";
        })

        checkRedirect(result);
        history.replaceState({},null,null); //동작 순서


        function checkRedirect(result){
            if(result ==='' || history.state) {
                return;
            }
            if(result >0) {
                alert(result)
            }
        }
    })

</script>
<!-- End of Main Content -->
<%@include file="../includes/footer.jsp"%>
