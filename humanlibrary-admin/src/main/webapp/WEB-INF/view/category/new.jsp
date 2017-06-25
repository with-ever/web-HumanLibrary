<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
	<script src="${ctx}/resources/js/humanlib/category-newNedit.js"></script>
</head>
<body>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">카테고리등록</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    등록
                </div>
                <div class="panel-body">
	                <form role="form" action="${ctx}/categories/new" method="POST">
	                    <div class="form-group">
	                        <label>카테고리 이름 (eng)</label>
	                        <input class="form-control" name="categoryName">
	                    </div>
	                    <div class="form-group">
	                        <label>카테고리 설명 (kor)</label>
	                        <input class="form-control" name="desc">
	                    </div>
	                    <div class="form-group">
	                        <label>카테고리 구분</label>
	                        <select class="form-control" id="categoryClass">
	                            <option value="parent">상위 카테고리</option>
	                            <option value="sub">하위 카테고리</option>
	                        </select>
	                    </div>
	                    <div class="form-group" id="parentCategorySelectBox">
	                        <label>부모 카테고리</label>
	                        <select class="form-control" name="parentCategoryId" id="parentCategoryId">
	                            <option value="0">없음</option>
	                        	<c:forEach var="category" items="${searchModel.results}">
                        			<c:if test="${category.parentCategoryId eq null}">
			                            <option value="${category.id}">${category.desc}</option>
                        			</c:if>
	                        	</c:forEach>
	                        </select>
	                    </div>
	                    <div class="form-group text-right">
	                        <button type="submit" class="btn btn-default js-submit">등록하기</button>
	                        <a href="${ctx}/categories">
	                            <button type="button" class="btn btn-default">취소</button>
	                        </a>
                    	</div>
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