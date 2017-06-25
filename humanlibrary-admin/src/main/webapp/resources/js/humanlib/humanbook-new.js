$(function(){
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