$(function() {
	
	$("#addFile").on("click", function(e) { // 파일 추가 버튼
		e.preventDefault();
		fn_addFile();
	});
	$("a[name='delete']").on("click", function(e) {
		e.preventDefault();
		fn_deleteFile($(this));
	});
});

function fn_addFile() {
	var str = "<p><input type='file' name='image' style='display:inline'><a href='#this' class='btn btn-danger btn-xs' name='delete'><i class='fa fa-times fa-fw'></i>삭제</a></p>";
	$("#fileDiv").append(str);
	$("a[name='delete']").on("click", function(e) {
		e.preventDefault();
		fn_deleteFile($(this));
	});
}

function fn_deleteFile(obj) {
	obj.parent().remove();
}
