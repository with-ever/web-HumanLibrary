<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
	<script src="${ctx}/resources/js/humanlib/humanbook-edit.js"></script>
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
                    수정
                </div>
                <div class="panel-body">
	                <form role="form" action="${ctx}/humanbooks/edit/${selectedHumanbook.id}" method="POST">
	                	<div class="form-group col-lg-6">
	                        <label>유저 ID</label>
	                        <input class="form-control" name="userId" value="${selectedHumanbook.user.userId}">
	                    </div>
  	                  	<div class="form-group col-lg-6">
	                        <label>시간</label>
	                        <input id="selectedServiceTime" value="${selectedHumanbook.serviceTime}" hidden="hidden"/>
	                        <select class="form-control" id="serviceTime" name="serviceTime">
	                            <option>ALL</option>
	                            <option>AM</option>
	                            <option>PM</option>
	                        </select>
	                    </div>
	                    <div class="form-group col-lg-6">
	                        <label>상위 카테고리</label> 
	                        <select class="form-control" id="parentCategory" name="parentCategory">
	                        	<option value="0">선택</option>
	                            <c:forEach var="category" items="${categoryList}">
	                            		<option value="${category.id}"
	                            			<c:if test="${category.id eq selectedHumanbook.parentCategory.id}">selected="selected"</c:if> >
			                            	${category.desc}</option>
	                            </c:forEach>
	                        </select>
	                    </div>
	                    <div class="form-group col-lg-6">
	                        <label>하위 카테고리</label>
	                        <input type="text" id="selectedSubCategoryId" value="${selectedHumanbook.subCategory.id}" hidden="hidden"/>  
	                        <select class="form-control" id="subCategory" name="subCategory">
	                        </select>
	                    </div>
	                    <div class="form-group col-lg-6">
	                        <label>제목</label>
	                        <input class="form-control" name="title" value="${selectedHumanbook.title}">
	                    </div>
	                    <div class="form-group col-lg-6">
	                        <label>경력</label>
	                        <input class="form-control" name="mainCareer" value="${selectedHumanbook.mainCareer}">
	                    </div>
                        <div class="form-group col-lg-12">
                            <label>설명</label>
                            <textarea class="form-control" rows="3" name="description">${selectedHumanbook.description}</textarea>
                        </div>
	                    <div class="form-group col-lg-6">
                            <label>날짜</label>
                            <c:forEach var="serviceDay" items="${serviceDayList}">
                            	<input class="selectedServiceDay" value="${serviceDay}" hidden="hidden"/>
                            </c:forEach>
                            <div class="serviceDayCheckBox">
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
                           	<input type="file" name="imageURL" value="${selectedHumanbook.imageUrl}">${selectedHumanbook.imageUrl}
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