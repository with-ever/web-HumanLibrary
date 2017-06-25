$(function(){
	$(document).ready(function(){
		var parentCategoryId = $('#parentCategory').val();
		
		$.ajax({
			url : $CTX_ROOT + '/humanbooks/subCategories?parentCategoryId=' + parentCategoryId,
			method : 'POST',
			dataType : 'json',
			success : function(result){
				$('#subCategory option').each( function() {
                    $(this).remove();
                });

				$(result).each(function( index ) {
					var subCategoryId = $('#originSubCategoryId').val();
					if(subCategoryId == result[index].id){
						$('#subCategory').append("<option value='"+result[index].id+"' selected='selected'>" + result[index].desc + "</option>"); 
					} else {
						$('#subCategory').append("<option value='"+result[index].id+"'>" + result[index].desc + "</option>"); 
					}
					
				});
			}
		});
		
		(function setServiceTime(){
			var selectedTime = $('#originServiceTime').val();
			$('#serviceTime').val(selectedTime).attr("selected","selected");
		})();
		
		//수정시 serviceDay check설정 부분 추가 필요 
//		(function setServiceDay(){
//			var selectedDay = $('#originServiceDay');
//			$(selectedDay).each(function(index){
//				alert(selectedDay[index]);
//			});
//		})();
	});
	
	$('#parentCategory').on('change', function(){
		var parentCategoryId = $('#parentCategory').val();
		
		$.ajax({
			url : $CTX_ROOT + '/humanbooks/subCategories?parentCategoryId=' + parentCategoryId,
			method : 'POST',
			dataType : 'json',
			success : function(result){
				$('#subCategory option').each( function() {
                    $(this).remove();
                });

				$(result).each(function( index ) {
					$('#subCategory').append("<option value='"+result[index].id+"'>" + result[index].desc + "</option>"); 
				});
			}
		});
	});
});