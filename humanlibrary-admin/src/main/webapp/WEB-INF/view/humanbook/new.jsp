<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
	<script src="${ctx}/resources/js/humanlib/humanbook-new.js"></script>
</head>
<body>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">휴먼북등록</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
		<div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    등록
                </div>
                <div class="panel-body">
	                <form role="form" action="${ctx}/humanbooks/new" method="POST">
	                	<div class="form-group col-lg-6">
	                        <label>유저 ID</label>
	                        <input class="form-control" name="userId">
	                    </div>
  	                  	<div class="form-group col-lg-6">
	                        <label>시간</label> <!-- 서브카테고리만 선택하도록 -->
	                        <select class="form-control" name="serviceTime">
	                            <option>ALL</option>
	                            <option>AM</option>
	                            <option>PM</option>
	                        </select>
	                    </div>
	                    <div class="form-group col-lg-6">
	                        <label>제목</label>
	                        <input class="form-control" name="title">
	                    </div>
	                    <div class="form-group col-lg-6">
	                        <label>경력</label>
	                        <input class="form-control" name="mainCareer">
	                    </div>
	                    <div class="form-group text-left col-lg-6">
	                        <label>상위 카테고리</label> 
	                        <select class="form-control" id="parentCategory" name="parentCategory">
	                        	<option value="0">선택</option>
	                            <c:forEach var="category" items="${categoryList}">
	                            		<option value="${category.id}">${category.desc}</option>
	                            </c:forEach>
	                        </select>
	                    </div>
	                    <div class="form-group col-lg-6">
	                        <label>하위 카테고리</label>
	                        <select class="form-control" id="subCategory" name="subCategory">
	                        </select>
	                    </div>
                        <div class="form-group col-lg-12">
                            <label>설명</label>
                            <textarea class="form-control" rows="3" name="description"></textarea>
                        </div>
	                    <div class="form-group col-lg-6">
                            <label>날짜</label>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="serviceDay" value="MONDAY">월
                                </label>
                                <label>
                                    <input type="checkbox" name="serviceDay" value="TUESDAY">화
                                </label>
                                <label>
                                    <input type="checkbox" name="serviceDay" value="WEDNESDAY">수
                                </label>
                                <label>
                                    <input type="checkbox" name="serviceDay" value="THURSDAY">목
                                </label>
                                <label>
                                    <input type="checkbox" name="serviceDay" value="FRIDAY">금
                                </label>
                                <label>
                                    <input type="checkbox" name="serviceDay" value="SATURDAY">토
                                </label>
                                <label>
                                    <input type="checkbox" name="serviceDay" value="SUNDAY">일
                                </label>
                            </div>
                        </div>
	                    <div class="form-group col-lg-6">
                        	<label>이미지</label>
                           	<input type="file" name="imageURL">
                        </div>
                         <div class="form-group text-right col-lg-12">
	                        <button type="submit" class="btn btn-default js-submit">등록하기</button>
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