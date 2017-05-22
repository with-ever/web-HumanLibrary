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
                        <div class="col-lg-12">
                            <form role="form">
                                <div class="form-group">
                                    <label>사용자 아이디</label>
                                    <p class="form-control-static">${user.userId}</p>
                                </div>
                                <div class="form-group">
                                    <label>로그인 아이디</label>
                                    <p class="form-control-static">${user.loginId}</p>
                                </div>
                                <div class="form-group">
                                    <label>이름</label>
                                    <input class="form-control" placeholder="이름" value="${user.name}">
                                </div>
                                <div class="form-group">
                                    <label>이메일</label>
                                    <input class="form-control" placeholder="이메일" value="${user.email}">
                                </div>
                                <div class="form-group">
                                    <label>이메일</label>
                                    <input class="form-control" placeholder="이메일" value="${user.email}">
                                </div>
                                <div class="form-group">
                                    <label>이메일</label>
                                    <input class="form-control" placeholder="이메일" value="${user.email}">
                                </div>
                                <div class="form-group">
                                    <label>이메일</label>
                                    <input class="form-control" placeholder="이메일" value="${user.email}">
                                </div>
                                <div class="form-group">
                                    <label>이메일</label>
                                    <input class="form-control" placeholder="이메일" value="${user.email}">
                                </div>
                                <div class="form-group">
                                    <label>이메일</label>
                                    <input class="form-control" placeholder="이메일" value="${user.email}">
                                </div>
                                <div class="form-group">
                                    <label>이메일</label>
                                    <input class="form-control" placeholder="이메일" value="${user.email}">
                                </div>
                                <div class="form-group">
                                    <label>이메일</label>
                                    <input class="form-control" placeholder="이메일" value="${user.email}">
                                </div>
                                <div class="form-group text-right">
                                    <a href="${ctx}/user/${user.userId}/edit">
                                        <button type="button" class="btn btn-default">수정하기</button>
                                    </a>
                                    <button type="button" class="btn btn-default">취소</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
            <%--this.name = user.getName();--%>
            <%--this.email = user.getEmail();--%>
            <%--this.phoneNo = user.getPhoneNo();--%>
            <%--this.mPhoneNo = user.getmPhoneNo();--%>
            <%--this.birth = user.getBirth();--%>
            <%--this.zipCode = user.getZipCode();--%>
            <%--this.address = user.getAddress();--%>
            <%--this.detailAddress = user.getDetailAddress();--%>
            <%--this.imageUrl = user.getImageUrl();--%>

        </div>
    </div>
</body>

