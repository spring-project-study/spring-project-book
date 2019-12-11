<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/left-navi.jsp" %>
<%@include file="../includes/top-bar.jsp" %>
<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Board Register</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Board Register</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <form action="/board/register" method="post">
                    <div>
                        <label>Title</label>
                        <input type="text" name="title">
                    </div>
                    <div>
                        <label>Writer</label>
                        <input type="text" name="writer">
                    </div>
                    <div>
                        <label>Content</label>
                        <textarea name="content"></textarea>
                    </div>
                    <button type="submit">SUBMIT button</button>
                    <button type="reset">RESET button</button>
                </form>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
<%@include file="../includes/footer.jsp"%>
