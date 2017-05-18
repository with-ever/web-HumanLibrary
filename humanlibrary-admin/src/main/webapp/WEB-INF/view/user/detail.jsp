<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<body>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">사용자상세</h1>
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
                        <div class="col-lg-6">
                            <form role="form">
                                <div class="form-group">
                                    <label>사용자 아이디</label>
                                    <p class="help-block">${user.userId}</p>
                                </div>
                                <div class="form-group">
                                    <label>로그인 아이디</label>
                                    <p class="help-block">${user.loginId}</p>
                                </div>
                                <div class="form-group">
                                    <label>이름</label>
                                    <input class="form-control" placeholder="이름" value="${user.name}">
                                </div>
                                <button type="submit" class="btn btn-default">수정하기</button>
                                <button type="reset" class="btn btn-default">취소</button>
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

