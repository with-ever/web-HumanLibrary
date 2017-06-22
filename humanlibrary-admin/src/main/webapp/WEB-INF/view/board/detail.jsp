<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<body>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">게시판 상세</h1>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<span class="form-group-static">${board.subject}</span>
				</div>
				<div class="panel-body">
					<div class="form-group text-right">
						<label>작성자 </label> <span class="form-group-static">${board.userLoginId}</span> /
						<label>등록일 </label> <span class="form-group-static">${board.cvtCreateTime}</span> /
						<label>타입 </label> <span class="form-group-static">${board.cvtType}</span> /
						<label>조회수 </label> <span class="form-group-static">${board.views}</span>
					</div>
					<div class="form-group">
					</div>
					<div class="form-group">
					</div>
					<div class="form-group">
					</div>
					<div class="form-group">
					</div>
					<!-- /.panel-heading -->

					<div class="form-group">
						<label>내용 : </label>
						<textarea class="form-control" cols="10" rows="10" disabled="disabled">${board.contents}</textarea>
					</div>
					<c:forEach var="boardFile" items="${board.boardFileList}"
						varStatus="status">
						<p>
							<img alt="첨부파일"
								src="${boardFile.relativePath}${boardFile.fileName}.${boardFile.suffix}">
						</p>
					</c:forEach>
					<div class="form-group">
						<label>첨부파일 : </label>
						<c:forEach var="boardFile" items="${board.boardFileList}" varStatus="status">
							<p>
								<a href="boardFileDown.do/${board.id}/${boardFile.fileName}"
									class="form-group-static">${boardFile.fileName}.${boardFile.suffix}</a>
							</p>
						</c:forEach>
					</div>

					<div class="form-group text-right">
						<a href="${ctx}/board/${board.id}/edit">
							<button type="button" class="btn btn-primary">수정하기</button>
						</a>
						<button type="button" class="btn btn-danger">취소</button>
					</div>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
	</div>
</body>

