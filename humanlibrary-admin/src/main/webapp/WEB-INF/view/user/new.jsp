<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<head>
    <script src="${ctx}/resources/js/jquery.validate.js"></script>
    <script src="${ctx}/resources/js/messages_ko.js"></script>
    <script src="${ctx}/resources/js/humanlib/user-new.js"></script>
</head>
<body>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">사용자등록</h1>
        </div>
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    등록
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form action="${ctx}/user" method="post" class="js-form">
                                <div class="form-group">
                                    <label class="control-label">로그인 아이디</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control js-loginId" placeholder="로그인아이디" name="loginId">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="button" onclick="userNew.verifyLoginId();">중복체크</button>
                                        </span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">비밀번호</label>
                                    <input type="password" class="form-control" placeholder="비밀번호" name="password" id="password">
                                </div>

                                <div class="form-group">
                                    <label class="control-label">비밀번호 확인</label>
                                    <input type="password" class="form-control" placeholder="비밀번호 확인" name="repassword">
                                </div>
                                <div class="form-group">
                                    <label class="control-label">역할</label>
                                    <div class="input-group">
                                        <c:forEach var="role" items="${roles}">
                                            <label class="checkbox-inline">
                                                <input type="checkbox" name="roles" value="${role.name}"> ${role.desc}
                                            </label>
                                        </c:forEach>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">이메일</label>
                                    <input class="form-control" placeholder="이메일" name="email">
                                </div>
                                <div class="form-group">
                                    <label class="control-label">이름</label>
                                    <input class="form-control" placeholder="이름" name="name">
                                </div>
                                <div class="form-group">
                                    <label class="control-label">성별</label>
                                    <div class="input-group">
                                        <label class="radio-inline">
                                            <input type="radio" name="gender" value="MALE" checked>
                                            남자
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="gender" value="FEMALE">
                                            여자
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">전화번호</label>
                                    <input class="form-control" placeholder="전화번호" name="phoneNo">
                                </div>
                                <div class="form-group">
                                    <label class="control-label">휴대폰번호</label>
                                    <input class="form-control" placeholder="휴대폰번호" name="mPhoneNo">
                                </div>
                                <div class="form-group">
                                    <label class="control-label">생년월일</label>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <input type="number" class="form-control" placeholder="년도" id="year">
                                        </div>
                                        <div class="col-lg-3">
                                            <select class="form-control" id="month">
                                                <c:forEach var="month" begin="1" end="12">
                                                    <option><fmt:formatNumber minIntegerDigits="2" value="${month}" /></option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-lg-3">
                                            <select class="form-control" id="day">
                                                <c:forEach begin="1" end="31" var="day">
                                                    <option><fmt:formatNumber minIntegerDigits="2" value="${day}" /></option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <input type="hidden" id="birth" name="birth"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">우편번호</label>
                                    <input class="form-control" placeholder="우편번호" name="zipCode">
                                </div>
                                <div class="form-group">
                                    <label class="control-label">주소</label>
                                    <input class="form-control" placeholder="주소" name="address">
                                </div>
                                <div class="form-group">
                                    <label>이미지</label>
                                    <input type="file" name="imageUrl">
                                </div>
                                <div class="form-group text-right">
                                    <button type="submit" class="btn btn-default js-submit">등록하기</button>
                                    <a href="${ctx}/user">
                                        <button type="button" class="btn btn-default">취소</button>
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

