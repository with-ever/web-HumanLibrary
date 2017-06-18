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
					<div class="row">
						<div class="col-md-12">
							<label>제목 : </label> <span class="form-group-static">${board.subject}</span>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3">
							<label>작성자 : </label> <span class="form-group-static">${board.userLoginId}</span>
						</div>
						<div class="col-md-3">
							<label>등록일 : </label> <span class="form-group-static">${board.cvtCreateTime}</span>
						</div>
						<div class="col-md-3">
							<label>타입 : </label> <span class="form-group-static">${board.cvtType}</span>
						</div>
						<div class="col-md-3">
							<label>조회수 : </label> <span class="form-group-static">${board.views}</span>
						</div>
					</div>
				</div>
				<!-- /.panel-heading -->

				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">
							<form role="form">
								<div class="form-group">
									<label>내용 : </label>
									<textarea class="form-control" maxlength="255"
										disabled="disabled">${board.contents}</textarea>
								</div>
								<c:forEach var="boardFile" items="${board.boardFileList
								}" varStatus="status">
								<div class="form-group">
									<label>첨부파일 : </label> <a href="boardFileDown.do/${board.id}/${boardFile.fileName}" class="form-group-static">${boardFile.fileName}.${boardFile.suffix}</a>
								</div>
								</c:forEach>

								<div class="form-group text-right">
									<a href="${ctx}/board/${board.id}/edit">
										<button type="button" class="btn btn-primary">수정하기</button>
									</a>
									<button type="button" class="btn btn-danger">취소</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
	</div>
</body>

