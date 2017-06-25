$(function(){
	$(document).ready(function(){
		var parentCategory = $('#parentCategoryId').val();
		if(parentCategory != 0){ 	//sub category
			$('#parentCategorySelectBox').removeAttr('hidden');
			$('#categoryClass').val('sub').attr('selected')
		} else { 					//parent category
			$('#parentCategorySelectBox').attr('hidden','hidden');
		}
	});
	
	$('#categoryClass').change(function(){
		var categoryClassValue = this.value;
		controlParentCategorySelectBox(categoryClassValue);
	});
	
	function controlParentCategorySelectBox(value){
		if(value == 'sub'){
			$('#parentCategorySelectBox').removeAttr('hidden');
		} else{
			$('#parentCategorySelectBox').attr('hidden','hidden');
			$('#parentCategoryId').val(0).attr('selected')
		}
	}
});