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
                                    <label>로그인 아이디</label>
                                    <input class="form-control" placeholder="이름" name="loginId">
                                    <button type="button" class="btn btn-default">Default</button>
                                </div>
                                <div class="form-group">
                                    <label>이름</label>
                                    <input class="form-control" placeholder="이름" name="name">
                                </div>
                                <div class="form-group">
                                    <label>이메일</label>
                                    <input class="form-control" placeholder="이메일" name="email">
                                </div>
                                <div class="form-group">
                                    <label>전화번호</label>
                                    <input class="form-control" placeholder="전화번호" name="phoneNo">
                                </div>
                                <div class="form-group">
                                    <label>휴대폰번호</label>
                                    <input class="form-control" placeholder="휴대폰번호" name="mPhoneNo">
                                </div>
                                <div class="form-group">
                                    <label>생년월일</label>
                                    <select class="form-control">
                                        <option>1980</option>
                                        <option>1980</option>
                                        <option>1980</option>
                                        <option>1980</option>
                                        <option>1980</option>
                                    </select>
                                    <select class="form-control">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                    <select class="form-control">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>이메일</label>
                                    <input class="form-control" placeholder="이름" name="name">
                                </div>
                                <div class="form-group">
                                    <label>이메일</label>
                                    <input class="form-control" placeholder="이름" name="name">
                                </div>
                                <div class="form-group">
                                    <label>이메일</label>
                                    <input class="form-control" placeholder="이름" name="name">
                                </div>
                                <div class="form-group">
                                    <label>이메일</label>
                                    <input class="form-control" placeholder="이름" name="name">
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

