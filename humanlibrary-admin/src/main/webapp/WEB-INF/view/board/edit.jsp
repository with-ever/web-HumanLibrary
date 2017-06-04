<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<body>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">게시판 수정</h1>
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
                        <form>                 
                            <div class="form-group">
                                <label>작성자</label>
                                <p class="form-group-static">
                                    ${board.userId}
                                </p>
                            </div>
                            <div class="form-group">
                                <label>제목</label>
                                 <input class="form-control" placeholder="제목" name="subject" value="${board.subject}">
                            </div>
                            <div class="form-group">
                                <label>타입</label>
                                    <label class="checkbox-inline">
                                        <input type="radio" name="TYPE" value="MP" checked>주요프로그램 
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="radio" name="TYPE" value="PT">게시물
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="radio" name="TYPE" value="NT">공지사항
                                    </label>
                            </div>
                            
                            <div class="form-group">
                                <label>내용</label>
                                <input class="form-control" placeholder="내용" name="contents" value="${board.contents}">
                            </div>
                            <div class="form-group">
                                <label>첨부파일</label>
                                         	<input type="file" name="imageUrl">
                            </div>
							<div class="form-group text-right">
                                <button type="button" class="btn btn-primary js-submit">수정하기</button>
                                <a href="${ctx}/board">
                                    <button type="button" class="btn btn-danger">취소</button>
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

