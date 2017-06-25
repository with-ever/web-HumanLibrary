<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
	<script src="${ctx}/resources/js/humanlib/category-list.js"></script>
</head>
<body>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">카테고리관리</h1>
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
                <div class="panel-body">
	                <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th class="col-lg-5">이름</th>
                                <th class="col-lg-4">설명</th>
                                <th>부모 카테고리</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="category" items="${searchModel.results}">
	                            <tr>
	                                <td class="currentCategoryId">
                                        <a href="${ctx}/categories/${category.id}">
                                            ${category.id}
                                        </a>
                                    </td>
	                                <td>${category.categoryName}</td>
	                                <td>${category.desc}</td>
	                                <td>${category.parentCategoryId}</td>
	                                <td>
					                    <button type="button" class="btn btn-danger" id="${category.id}">삭제</button>
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
                                <a href="categories?pageNo=${(searchModel.pageNo - 1) == 0 ? 1 : searchModel.pageNo - 1}" aria-label="Previous">
                                    Previous
                                </a>
                            </li>
                            <c:forEach var="pageNo" begin="${searchModel.navigateStartPage}" end="${searchModel.navigateStartPage + searchModel.navigatePageCount - 1}" varStatus="s">
                                <c:choose>
                                    <c:when test="${pageNo == searchModel.pageNo}">
                                        <li class="active"><a href="categories?pageNo=${pageNo}">${pageNo}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><a href="categories?pageNo=${pageNo}">${pageNo}</a></li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            <li class="${searchModel.pageNo == searchModel.totalPageNo ? 'disabled' : ''}">
                                <a href="categories?pageNo=${(searchModel.pageNo + 1) > searchModel.totalPageNo ? searchModel.totalPageNo : searchModel.pageNo + 1}" aria-label="Next">
                                    Next
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- /.panel-body -->
                <!-- @TODO paging fragment로 재구성 필요.-->
                <div class="panel-footer text-right">
                    <a href="${ctx}/categories/new">
                        <button type="button" class="btn btn-default">등록하기</button>
                    </a>
                </div>
            </div>
            <!-- /.panel -->
        </div>
    </div>
    <!-- /.row -->
</body>