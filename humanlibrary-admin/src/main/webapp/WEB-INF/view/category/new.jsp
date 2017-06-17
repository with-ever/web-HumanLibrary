<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
    <script src="${ctx}/resources/js/humanlib/category-new.js"></script>
</head>
<body>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">CATEGORY</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    카테고리 등록
                </div>
                <div class="panel-body">
	                <form role="form" id="newCategoryForm" method="POST">
	                    <div class="form-group">
	                        <label>CATEGORY NAME (eng)</label>
	                        <input class="form-control" name="categoryName">
	                        <p class="help-block">Example block-level help text here.</p>
	                    </div>
	                    <div class="form-group">
	                        <label>CATEGORY DESC (kor)</label>
	                        <input class="form-control" name="desc">
	                    </div>
	                    <div class="form-group">
	                        <label>Parent Category</label>
	                        <select class="form-control" name="parentCategoryId">
	                        	<c:forEach var="category" items="${searchModel.results}">
	                        			<c:if test="${category.parentCategoryId eq null}">
				                            <option>${category.desc}, ${category.id}</option>
	                        			</c:if>
<%-- 	                        			<c:otherwise>
				                            <option>${category.desc}</option>
	                        			</c:otherwise> --%>
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