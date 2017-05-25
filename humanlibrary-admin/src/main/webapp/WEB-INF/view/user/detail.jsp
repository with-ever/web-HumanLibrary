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
                                    <p class="form-group-static">${user.loginId}</p>
                                </div>
                                <div class="form-group">
                                    <label>이메일</label>
                                    <p class="form-group-static">${user.email}</p>
                                </div>
                                <div class="form-group">
                                    <label>이름</label>
                                    <p class="form-group-static">${user.name}</p>
                                </div>
                                <div class="form-group">
                                    <label>성별</label>
                                    <%--@TODO gender to text--%>
                                    <p class="form-group-static">${user.gender}</p>
                                </div>
                                <div class="form-group">
                                    <label>전화번호</label>
                                    <p class="form-group-static">${user.phoneNo}</p>
                                </div>
                                <div class="form-group">
                                    <label>휴대폰번호</label>
                                    <p class="form-group-static">${user.mPhoneNo}</p>
                                </div>
                                <div class="form-group">
                                    <label>생년월일</label>
                                    <p class="form-group-static">${user.birth}</p>
                                </div>
                                <div class="form-group">
                                    <label>우편번호</label>
                                    <p class="form-group-static">${user.zipCode}</p>
                                </div>
                                <div class="form-group">
                                    <label>주소</label>
                                    <p class="form-group-static">${user.address}</p>
                                </div>
                                <div class="form-group">
                                    <label>상세주소</label>
                                    <p class="form-group-static">${user.detailAddress}</p>
                                </div>
                                <div class="form-group">
                                    <label>이미지</label>
                                    <img src="${user.imageUrl}" alt="">
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
        </div>
    </div>
</body>

