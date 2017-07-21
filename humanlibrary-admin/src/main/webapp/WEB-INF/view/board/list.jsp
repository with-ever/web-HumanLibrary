<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			<div class="panel-heading ">게시판 목록</div>
			<!-- /.panel-heading -->
			<div class="panel-body">


				<form class="form-inline" method="GET">
					<div class="form-group center-block">
						<div class="form-group">
							<label class="radio-inline"> <input type="radio"
								name="searchOptionType" id="optionsRadiosInline1" value=""
								checked> 전체
							</label> <label class="radio-inline"> <input type="radio"
								name="searchOptionType" id="optionsRadiosInline1" value="MP">주요프로그램
							</label> <label class="radio-inline"> <input type="radio"
								name="searchOptionType" id="optionsRadiosInline2" value="PT">게시물
							</label> <label class="radio-inline"> <input type="radio"
								name="searchOptionType" id="optionsRadiosInline3" value="NT">공지사항
							</label>
						</div>
						&emsp; <select style="width: 50px" name="searchOption">
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
								<th>타입</th>
								<th>제목</th>
								<th>작성자</th>
								<th>등록일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<fmt:formatDate value="${user.createDate}"
								pattern="MM/dd/yyyy HH:mm" />
							<c:forEach var="board" items="${searchModel.results}"
								varStatus="status">
								<%-- <td>${(searchModel.totalCount - status.index) - ( (searchModel.pageNo-1) * (searchModel.limit))}</td> --%>
								<tr>
									<td>${board.id}</td>
									<c:choose>
										<c:when test="${board.type eq 'MP'}">
											<td>주요프로그램</td>
										</c:when>
										<c:when test="${board.type eq 'PT'}">
											<td>게시물</td>
										</c:when>
										<c:when test="${board.type eq 'NT'}">
											<td>공지사항</td>
										</c:when>
									</c:choose>
									<td><a href="${ctx}/board/${board.id}">
											${board.subject} </a></td>
									<td>${board.user.loginId}</td>
									<td><fmt:formatDate value="${board.createDate}"
											pattern="MM/dd/yyyy HH:mm" /></td>
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
					<button type="button" class="btn btn-primary">
						<i class="fa fa-edit fa-fw"></i> 등록
					</button>
				</a>
			</div>
		</div>
		<!-- /.panel -->
	</div>
</body>

