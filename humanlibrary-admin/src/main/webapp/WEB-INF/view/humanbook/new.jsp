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
    <div class="row">
		<div class="col-lg-12">
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
	                            <c:forEach var="category" items="${categoryList}">
	                            	<%-- <c:if test="${category.parentCategoryId eq null}"> --%>
	                            		<option>${category.desc}</option>
	                            	<%-- </c:if> --%>
	                            </c:forEach>
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
                         <div class="form-group text-right">
	                        <button type="button" class="btn btn-default js-submit">등록하기</button>
	                        <a href="${ctx}/humanbooks">
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