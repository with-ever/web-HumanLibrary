<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<body>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">게시판관리</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">게시판 목록</div>
			<!-- /.panel-heading -->
			<div class="panel-body">


				<form class="form-inline" method="GET">
					<div class="form-group center-block">
						<select style="width: 50px" name="searchOption">
							<option value="subject">제목</option>
							<option value="contents">내용</option>
						</select> <input type="text" class="form-control" name="keyword"> <span>
							<button class="btn btn-default" type="submit">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
				
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>등록일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="board" items="${searchModel.results}" varStatus="status">
								<tr>
									<%-- <td>${(searchModel.totalCount - status.index) - ( (searchModel.pageNo-1) * (searchModel.limit))}</td> --%>
									<td>${board.id}</td>
									<td><a href="${ctx}/board/${board.id}">
											${board.subject} </a></td>
									<td>${board.userLoginId}</td>
									<td>${board.cvtCreateTime}</td>
									<td>${board.views}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.table-responsive -->
				<div class="text-center">
					<ul class="pagination">
						<li class="${searchModel.pageNo == 1 ? 'disabled' : '' }"><a
							href="board?pageNo=${(searchModel.pageNo - 1) == 0 ? 1 : searchModel.pageNo - 1}"
							aria-label="Previous"> Previous </a></li>
						<c:forEach var="pageNo" begin="${searchModel.navigateStartPage}"
							end="${searchModel.navigateStartPage + searchModel.navigatePageCount - 1}"
							varStatus="s">
							<c:choose>
								<c:when test="${pageNo == searchModel.pageNo}">
									<li class="active"><a href="board?pageNo=${pageNo}">${pageNo}</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="board?pageNo=${pageNo}">${pageNo}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<li
							class="${searchModel.pageNo == searchModel.totalPageNo ? 'disabled' : ''}">
							<a
							href="board?pageNo=${(searchModel.pageNo + 1) > searchModel.totalPageNo ? searchModel.totalPageNo : searchModel.pageNo + 1}"
							aria-label="Next"> Next </a>
						</li>
					</ul>
				</div>
			</div>
			<!-- /.panel-body -->
			<!-- @TODO paging fragment로 재구성 필요.-->
			<div class="panel-footer text-right">
				<a href="${ctx}/board/new">
					<button type="button" class="btn btn-primary">등록하기</button>
				</a>
			</div>
		</div>
		<!-- /.panel -->
	</div>
</body>

