<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
	<script src="${ctx}/resources/js/humanlib/board-new.js"></script>
</head>
<body>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">게시판 등록</h1>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
               
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-12">
                        <form action="/board/new/create" method="post" enctype="multipart/form-data">

                            <div class="form-group">
                                <label>작성자</label>
                                <p class="form-group-static">
                                </p>
                            </div>
                            <div class="form-group">
                                <label>제목</label>
                                 <input class="form-control" placeholder="제목" name="subject">
                            </div>
                            <div class="form-group">
                                <label>타입</label>
                                    <label class="checkbox-inline">
                                        <input type="radio" name="type" value="MP" checked>주요프로그램 
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="radio" name="type" value="PT">게시물
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="radio" name="type" value="NT">공지사항
                                    </label>
                            </div>
                            
                            <div class="form-group">
                                <label>내용</label>
                                <textarea class="form-control" cols="10" rows="10" placeholder="내용" name="contents"></textarea>
                            </div>
                            <div id ="fileDiv" class="form-group">
                                <label>첨부파일</label>
                                         	
                            </div>
                            <a href="#this" class="btn btn btn-info btn-xs" id="addFile"> <i class="fa fa-photo fa-fw"></i>파일 추가</a>
                            
							<div class="form-group text-right">
                                <button type="submit" class="btn js-submit btn-primary"> <i class="fa fa-save fa-fw"></i> 등록하기 </button>
                                <a href="${ctx}/board">
                                    <button  class="btn btn-default "><i class="fa fa-reply fa-fw"> </i>이전으로</button>
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
</div>
</body>

