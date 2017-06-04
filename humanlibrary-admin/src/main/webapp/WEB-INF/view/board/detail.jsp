<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<body>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">게시판 상세</h1>
        </div>
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    상세
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form role="form">
                                <div class="form-group">
                                    <label>제목</label>
                                    <p class="form-control-static">${board.subject}</p>
                                </div>
                                <div class="form-group">
                                    <label>작성자</label>
                                    <p class="form-group-static">${board.userId}</p>
                                </div>
                                <div class="form-group">
                                    <label>타입</label>
                                    <p class="form-group-static">${board.type}</p>
                                </div>
                                <div class="form-group">
                                    <label>등록일</label>
                                    <p class="form-group-static">${board.createTime}</p>
                                </div>
                                <div class="form-group">
                                    <label>내용</label>
                                    <p class="form-group-static">${board.contents}</p>
                                </div>
                                <div class="form-group">
                                    <label>첨부파일</label>
                                    <p class="form-group-static">test.jpg</p>
                                </div>
                                <div class="form-group">
                                    <label>조회수</label>
                                    <p class="form-group-static">${board.views}</p>
                                </div>
                              
                                <div class="form-group text-right">
                                    <a href="${ctx}/board/${board.id}/edit">
                                        <button type="button" class="btn btn-primary">수정하기</button>
                                    </a>
                                    <button type="button" class="btn btn-danger">취소</button>
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

