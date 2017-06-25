$(function(){
	$(".deleteHumanbook").on("click", function(){
		if(confirm("삭제하시겠습니까?")){
			var humanbookId = this.id;
			$.ajax({
				url : $CTX_ROOT + '/humanbooks/' + humanbookId,
				method : 'DELETE',
				async : false,
				success : function(){
					location.reload();
				}
			});
		}
	});
	
	$(".acceptHumanbook").on("click", function(){
		if(confirm("수락하시겠습니까?")){
			var humanbookId = this.id;
			$.ajax({
				url : $CTX_ROOT + '/humanbooks/' + humanbookId + "/accept",
				method : 'PUT',
				success : function(){
					location.reload();
				}
			});
		}
	});

	$(".rejectHumanbook").on("click", function(){
		if(confirm("거절하시겠습니까?")){
			var humanbookId = this.id;
			$.ajax({
				url : $CTX_ROOT + '/humanbooks/' + humanbookId + "/reject",
				method : 'PUT',
				success : function(){
					location.reload();
				}
			});
		}
	});
});