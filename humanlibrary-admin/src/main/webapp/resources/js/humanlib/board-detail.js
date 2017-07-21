function delBtn_event(id) {
	var result = confirm('삭제 하시겠습니까?');
	if (result) {
		$.ajax({
			url : $CTX_ROOT + '/board/' + id+'/delete',
			method : 'GET',
			success : function(){
				history.back()
			}
		});
	} else {

	}

}
