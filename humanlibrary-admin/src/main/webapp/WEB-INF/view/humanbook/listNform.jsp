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
                                <th>USER ID</th>
                                <th>TITLE</th>
                                <th>CATEGORY</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="humanbook" items="${searchModel.results}">
	                            <tr>
	                                <td>
                                        <a href="${ctx}/humanbook/${humanbook.id}">
                                            ${humanbook.id}
                                        </a>
                                    </td>
	                                <td>${humanbook.userId}</td>
	                                <td>${humanbook.title}</td>
	                                <td>${(humanbook.subCategory).categoryName}</td>
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
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-6 -->
        <div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    HUMANBOOK FORM
                </div>
                <div class="panel-body">
	                <form role="form">
	                	<div class="form-group">
	                        <label>USER ID</label>
	                        <input class="form-control">
	                    </div>
  	                  	<div class="form-group">
	                        <label>SERVICE TIME</label> <!-- 서브카테고리만 선택하도록 -->
	                        <select class="form-control">
	                            <option>ALL</option>
	                            <option>AM</option>
	                            <option>PM</option>
	                        </select>
	                    </div>
	                    <div class="form-group">
                            <label>SERVICE DAY</label>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="1">월
                                </label>
                                <label>
                                    <input type="checkbox" value="2">화
                                </label>
                                <label>
                                    <input type="checkbox" value="3">수
                                </label>
                                <label>
                                    <input type="checkbox" value="4">목
                                </label>
                                <label>
                                    <input type="checkbox" value="5">금
                                </label>
                                <label>
                                    <input type="checkbox" value="6">토
                                </label>
                                <label>
                                    <input type="checkbox" value="7">일
                                </label>
                            </div>
	                    <div class="form-group">
                        	<label>IMAGE FILE</label>
                           	<input type="file">
                        </div>
	                    <div class="form-group">
	                        <label>CATEGORY</label> <!-- 서브카테고리만 선택하도록 -->
	                        <select class="form-control">
	                            <option>1</option>
	                            <option>2</option>
	                            <option>3</option>
	                            <option>4</option>
	                            <option>5</option>
	                        </select>
	                    </div>
	                    <div class="form-group">
	                        <label>TITLE</label>
	                        <input class="form-control">
	                    </div>
	                    <div class="form-group">
	                        <label>MAIN CAREER</label>
	                        <input class="form-control" placeholder="Enter text">
	                    </div>
                        <div class="form-group">
                            <label>DESCRIPTION</label>
                            <textarea class="form-control" rows="3"></textarea>
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