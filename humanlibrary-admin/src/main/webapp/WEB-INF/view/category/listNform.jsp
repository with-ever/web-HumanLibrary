<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<body>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">CATEGORY</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-6">
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
                                <th>CATEGORY</th>
                                <th>DESC</th>
                                <th>PARENT</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="category" items="${searchModel.results}">
	                            <tr>
	                                <td>
                                        <a href="${ctx}/categories/${category.id}">
                                            ${category.id}
                                        </a>
                                    </td>
	                                <td>${category.categoryName}</td>
	                                <td>${category.desc}</td>
	                                <td>${category.parentCategoryId}</td>
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
                                        <li class="active"><a href="catgories?pageNo=${pageNo}">${pageNo}</a></li>
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
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-6 -->
        <div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    CATEGORY FORM
                </div>
                <div class="panel-body">
	                <form role="form">
	                    <div class="form-group">
	                        <label>CATEGORY NAME (eng)</label>
	                        <input class="form-control">
	                        <p class="help-block">Example block-level help text here.</p>
	                    </div>
	                    <div class="form-group">
	                        <label>CATEGORY DESC (kor)</label>
	                        <input class="form-control" placeholder="Enter text">
	                    </div>
	                    <div class="form-group">
	                        <label>Parent Category</label>
	                        <select class="form-control">
	                            <option>1</option>
	                            <option>2</option>
	                            <option>3</option>
	                            <option>4</option>
	                            <option>5</option>
	                        </select>
	                    </div>
	                    <button type="submit" class="btn btn-default">저장</button>
	                    <button type="reset" class="btn btn-default">초기화</button>
	                </form>
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-6 -->
    </div>
    <!-- /.row -->
</body>