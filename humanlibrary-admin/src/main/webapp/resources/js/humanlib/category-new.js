$(function(){
	$(".btn-danger").on("click", function(){
		if(confirm("삭제하시겠습니까?")){
			var categoryId = this.id;
			$.ajax({
				url : $CTX_ROOT + '/categories/' + categoryId,
				method : 'DELETE',
				async : false,
				success : function(){
					location.reload();
				}
			});
		}
	});
});

