<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
    <script src="${ctx}/resources/js/jquery.validate.js"></script>
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
                            <form>
                                <div class="form-group">
                                    <label>로그인 아이디</label>
                                    <div class="form-group input-group">
                                        <input type="text" class="form-control js-loginId" placeholder="로그인아이디" name="loginId">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="button" onclick="userNew.verifyLoginId();">중복체크</button>
                                        </span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>역할</label>
                                    <div class="input-group">
                                        <c:forEach var="role" items="${roles}">
                                            <label class="checkbox-inline">
                                                <input type="checkbox" name="roles" value="${role.name}"> ${role.desc}
                                            </label>
                                        </c:forEach>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>이메일</label>
                                    <input class="form-control" placeholder="이메일" name="email">
                                </div>
                                <div class="form-group">
                                    <label>이름</label>
                                    <input class="form-control" placeholder="이름" name="name">
                                </div>
                                <div class="form-group">
                                    <label>성별</label>
                                    <div class="input-group">
                                        <label class="radio-inline">
                                            <input type="radio" name="gender" value="male" checked>
                                            남자
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="gender" value="female">
                                            여자
                                        </label>
                                    </div>
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
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <select class="form-control">
                                                <option>1980</option>
                                                <option>1980</option>
                                                <option>1980</option>
                                                <option>1980</option>
                                                <option>1980</option>
                                            </select>
                                        </div>
                                        <div class="col-lg-3">
                                            <select class="form-control">
                                                <option>01</option>
                                                <option>02</option>
                                                <option>03</option>
                                                <option>04</option>
                                            </select>
                                        </div>
                                        <div class="col-lg-3">
                                            <select class="form-control">
                                                <option>01</option>
                                                <option>02</option>
                                                <option>03</option>
                                                <option>04</option>
                                                <option>05</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>우편번호</label>
                                    <input class="form-control" placeholder="우편번호" name="zipcode">
                                </div>
                                <div class="form-group">
                                    <label>주소</label>
                                    <input class="form-control" placeholder="주소" name="address">
                                </div>
                                <div class="form-group">
                                    <label>상세주소</label>
                                    <input class="form-control" placeholder="상세주소" name="detailAddress">
                                </div>
                                <div class="form-group">
                                    <label>이미지</label>
                                    <input type="file" name="imageUrl">
                                </div>
                                <div class="form-group text-right">
                                    <button type="button" class="btn btn-default js-submit">등록하기</button>
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

