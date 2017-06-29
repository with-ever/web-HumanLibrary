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
					var subCategoryId = $('#selectedSubCategoryId').val();
					if(subCategoryId == result[index].id){
						$('#subCategory').append("<option value='"+result[index].id+"' selected='selected'>" + result[index].desc + "</option>"); 
					} else {
						$('#subCategory').append("<option value='"+result[index].id+"'>" + result[index].desc + "</option>"); 
					}
					
				});
			}
		});
		
		(function setServiceTime(){
			var selectedTime = $('#selectedServiceTime').val();
			$('#serviceTime').val(selectedTime).attr("selected","selected");
		})();
		
		
		(function setServiceDay(){
			var serviceDays = $('.selectedServiceDay');
			var serviceDaysCheckBox = $(".serviceDayCheckBox").find('input');
			
			for(var i=0 ; i<serviceDays.length ; i++){
				for (var j=0 ; j<serviceDaysCheckBox.length ; j++) {
					if(serviceDays[i].value == serviceDaysCheckBox[j].value){
						serviceDaysCheckBox[j].setAttribute("checked","checked");
					}
				}
			}
		})();
		
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