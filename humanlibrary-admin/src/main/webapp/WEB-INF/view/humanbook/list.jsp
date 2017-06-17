<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<body>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">HUMANBOOK</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                	LIST
                </div>
                <div class="panel-body">
	                <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>USER</th>
                                <th class="col-lg-2">TITLE</th>
                                <th class="col-lg-3">MAIN CAREER</th>
                                <th>TIME</th>
                                <th class="col-lg-2">CATEGORY</th>
                                <th class="col-lg-2">DESC</th>
                                <th>-</th>
<!--                                 <th class="col-lg-1">ID</th>
                                <th class="col-lg-1">USER ID</th>
                                <th class="col-lg-2">TITLE</th>
                                <th class="col-lg-2">MAIN CAREER</th>
                                <th class="col-lg-1">SERVICE TIME</th>
                                <th class="col-lg-2">CATEGORY</th>
                                <th class="col-lg-1">DESC</th>
                                <th class="col-lg-2">-</th> -->
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="humanbook" items="${searchModel.results}">
	                            <tr>
	                                <td>
                                        <a href="${ctx}/humanbooks/${humanbook.id}">
                                            ${humanbook.id}
                                        </a>
                                    </td>
	                                <td>${humanbook.user.userId}</td>
	                                <td>${humanbook.title}</td>
	                                <td>${humanbook.mainCareer}</td>
	                                <td>${humanbook.serviceTime}</td>
	                                <td>${(humanbook.subCategory).categoryName}</td>
	                                <td>${humanbook.description}</td>
	                                <td>
		                                <c:choose>
			                                <c:when test="${humanbook.state eq 'ACCEPT'}">
				                                <button type="button" class="btn btn-success">수정</button>
				                                <button type="button" class="btn btn-danger">삭제</button>
			                                </c:when>
			                                <c:otherwise>
				                                <button type="button" id="acceptBtn" class="btn btn-info">수락</button>
				                                <button type="button" class="btn btn-warning">거절</button>
			                                </c:otherwise>
		                                </c:choose>
	                                </td>
	                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.table-responsive -->
                    <div class="text-center">
                        <ul class="pagination">
                            <li class="${searchModel.pageNo == 1 ? 'disabled' : '' }">
                                <a href="humanbooks?pageNo=${(searchModel.pageNo - 1) == 0 ? 1 : searchModel.pageNo - 1}" aria-label="Previous">
                                    Previous
                                </a>
                            </li>
                            <c:forEach var="pageNo" begin="${searchModel.navigateStartPage}" end="${searchModel.navigateStartPage + searchModel.navigatePageCount - 1}" varStatus="s">
                                <c:choose>
                                    <c:when test="${pageNo == searchModel.pageNo}">
                                        <li class="active"><a href="humanbooks?pageNo=${pageNo}">${pageNo}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><a href="humanbooks?pageNo=${pageNo}">${pageNo}</a></li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            <li class="${searchModel.pageNo == searchModel.totalPageNo ? 'disabled' : ''}">
                                <a href="humanbooks?pageNo=${(searchModel.pageNo + 1) > searchModel.totalPageNo ? searchModel.totalPageNo : searchModel.pageNo + 1}" aria-label="Next">
                                    Next
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- /.panel-body -->
                <!-- @TODO paging fragment로 재구성 필요.-->
                <div class="panel-footer text-right">
                    <a href="${ctx}/humanbooks/new">
                        <button type="button" class="btn btn-default">등록하기</button>
                    </a>
                </div>
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-6 -->
    </div>
</body>