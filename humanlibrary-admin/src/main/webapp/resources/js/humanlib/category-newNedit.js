$(function(){
	$(document).ready(function(){
		var parentCategory = $('#parentCategoryId').val();
		if(parentCategory != 0){ 	//child category
			$('#parentCategorySelectBox').removeAttr('hidden');
			$('#categoryClass').val('child').attr('selected')
		} else { 					//parent category
			$('#parentCategorySelectBox').attr('hidden','hidden');
		}
	});
	
	$('#categoryClass').change(function(){
		var categoryClassValue = this.value;
		controlParentCategorySelectBox(categoryClassValue);
	});
	
	function controlParentCategorySelectBox(value){
		if(value == 'child'){
			$('#parentCategorySelectBox').removeAttr('hidden');
		} else{
			$('#parentCategorySelectBox').attr('hidden','hidden');
			$('#parentCategoryId').val(0).attr('selected')
		}
	}
});