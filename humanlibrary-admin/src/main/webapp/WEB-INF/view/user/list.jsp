<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="user" items="${searchModel.results}">
	                            <tr>
	                                <td>${user.userId}</td>
	                                <td>${user.loginId}</td>
	                                <td>${user.email}</td>
	                                <td>${user.name}</td>
	                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.table-responsive -->
                </div>
                <!-- /.panel-body -->
                <!-- @TODO paging fragment로 재구성 필요.-->
                <div class="panel-footer text-right">
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
            <!-- /.panel -->
        </div>
    </div>
</body>

