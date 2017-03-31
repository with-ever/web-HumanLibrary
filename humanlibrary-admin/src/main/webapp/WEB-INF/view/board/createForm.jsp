<%--
  Created by IntelliJ IDEA.
  User: hyunseunglee
  Date: 2017. 3. 22.
  Time: PM 11:30
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>게시판 수정</title>
</head>
<body>
	<form action="/board/create" method="post" enctype="multipart/form-data">

		<table>
			<tr>
				<th>타입</th>
				<td><input type="radio" id="type1" name="type" value="PT" checked="checked"/><label
					for="type1">게시물</label> <input type="radio" id="type2" name="type"
					value="NT" /><label for="type2">공지사항</label></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" required="required"
					placeholder="제목"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents" required="required">
				</textarea></td>

			</tr>
			<tr>
				<th>파일</th>
				<td><input type="file" name="files" required="required"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="작성"> <input
					type="reset" value="취소"></td>
			</tr>
		</table>




	</form>
</body>
</html>
