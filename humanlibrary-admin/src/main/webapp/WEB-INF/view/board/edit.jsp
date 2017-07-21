<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
<script src="${ctx}/resources/js/humanlib/board-edit.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">게시판 수정</h1>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<span class="form-group-static">${board.subject}</span>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">
							<form action="/board/edit" method="POST" enctype="multipart/form-data">
							<input type="hidden" name="id" value="${board.id}">
								<div class="form-group">
									<label>작성자</label>
									<p class="form-group-static">${board.user.loginId}</p>
								</div>
								<div class="form-group">
									<label>제목</label> <input class="form-control" placeholder="제목"
										type="text" name="subject" value="${board.subject}">
								</div>
								<div class="form-group">
									<label>타입</label> <label class="checkbox-inline"> <input
										type="radio" name="type" value="MP" checked>주요프로그램
									</label> <label class="checkbox-inline"> <input type="radio"
										name="type" value="PT">게시물
									</label> <label class="checkbox-inline"> <input type="radio"
										name="type" value="NT">공지사항
									</label>
								</div>

								<div class="form-group">
									<textarea name="contents" class="form-control" cols="10" rows="10">${board.contents}</textarea>
								</div>
								<div id ="fileDiv" class="form-group">
									<label>첨부파일</label>
									<c:forEach var="boardFile" items="${board.boardFileList}" varStatus="status">
									<p><input type='text' name='originalImage' style='display:inline' value="${boardFile.fileName}.${boardFile.suffix}" readonly ><a href='#this' class='btn btn-danger btn-xs' name='delete' ><i class='fa fa-times fa-fw'></i>삭제</a></p>
											</c:forEach>
								<a href="#this" class="btn btn btn-info btn-xs" id="addFile"><i class="fa fa-photo fa-fw"></i> 파일 추가</a>
								</div>
								<div class="form-group text-right">
									<button type="submit" class="btn js-submit btn-primary"> <i class="fa fa-save fa-fw"></i>수정하기</button>
									<a href="${ctx}/board/${board.id}">
										<button type="button" class="btn btn-default"><i class="fa fa-reply fa-fw"> </i>이전으로</button>
									</a>
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

