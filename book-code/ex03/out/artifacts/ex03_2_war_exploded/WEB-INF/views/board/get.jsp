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
                <form id="boardForm"action="/board/modify" method="get">
                    <div>
                        <label>bno</label>
                        <input type="text" name="bno" readonly="readonly" value="${board.bno}"/>
                    </div>
                    <div>
                        <label>Title</label>
                        <input type="text" name="title" readonly="readonly" value="${board.title}"/>
                    </div>
                    <div>
                        <label>Writer</label>
                        <input type="text" name="writer" readonly="readonly" value="${board.writer}" />
                    </div>
                    <div>
                        <label>Content</label>
                        <textarea name="content" readonly="readonly" >${board.content}</textarea>
                    </div>
                    <button data-oper="modify">MODIFY button</button>
                    <button data-oper="remove">REMOVE button</button>
                    <button data-oper="list">List button</button>
                </form>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>
<script>
    $(function(){
        $('button').on('click',function(e){
            e.preventDefault();
            var operation = $(this).data("oper");
            if(operation =="remove"){
                $('#boardForm').attr("action","/board/remove");
            } else if (operation =="list") {
                self.location = "/board/list"
            }
            $('#boardForm').submit();
        })


    })

</script>
<!-- End of Main Content -->
<%@include file="../includes/footer.jsp"%>
