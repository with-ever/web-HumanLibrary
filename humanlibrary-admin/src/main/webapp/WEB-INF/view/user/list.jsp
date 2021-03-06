<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<body>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">사용자관리</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    목록
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>로그인ID</th>
                                <th>EMAIL</th>
                                <th>이름</th>
                                <th>역할</th>
                                <th>성별</th>
                                <th>전화번호</th>
                                <th>휴대폰번호</th>
                                <th>주소</th>
                                <th>생성날짜</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="user" items="${searchModel.results}">
                                <tr>
                                        <td>
                                            <a href="${ctx}/user/${user.userId}">
                                                ${user.userId}
                                            </a>
                                        </td>
                                        <td>${user.loginId}</td>
                                        <td>${user.email}</td>
                                        <td>${user.name}</td>
                                        <td>
                                            <c:forEach var="role" items="${user.roleTextList}" varStatus="status">
                                                <c:choose>
                                                    <c:when test="${!status.last}">
                                                        ${role},
                                                    </c:when>
                                                    <c:otherwise>
                                                        ${role}
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </td>
                                        <td>${user.genderText}</td>
                                        <td>${user.phoneNo}</td>
                                        <td>${user.mPhoneNo}</td>
                                        <td>${user.address}</td>
                                        <td><fmt:formatDate value="${user.createDate}" pattern="MM/dd/yyyy HH:mm"/></td>
                                    </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.table-responsive -->
                    <div class="text-center">
                        <ul class="pagination">
                            <li class="${searchModel.pageNo == 1 ? 'disabled' : '' }">
                                <a href="user?pageNo=${(searchModel.pageNo - 1) == 0 ? 1 : searchModel.pageNo - 1}" aria-label="Previous">
                                    Previous
                                </a>
                            </li>
                            <c:forEach var="pageNo" begin="${searchModel.navigateStartPage}" end="${searchModel.navigateStartPage + searchModel.navigatePageCount - 1}" varStatus="s">
                                <c:choose>
                                    <c:when test="${pageNo == searchModel.pageNo}">
                                        <li class="active"><a href="user?pageNo=${pageNo}">${pageNo}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><a href="user?pageNo=${pageNo}">${pageNo}</a></li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            <li class="${searchModel.pageNo == searchModel.totalPageNo ? 'disabled' : ''}">
                                <a href="user?pageNo=${(searchModel.pageNo + 1) > searchModel.totalPageNo ? searchModel.totalPageNo : searchModel.pageNo + 1}" aria-label="Next">
                                    Next
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- /.panel-body -->
                <!-- @TODO paging fragment로 재구성 필요.-->
                <div class="panel-footer text-right">
                    <a href="${ctx}/user/new">
                        <button type="button" class="btn btn-default">등록하기</button>
                    </a>
                </div>
            </div>
            <!-- /.panel -->
        </div>
    </div>
</body>

