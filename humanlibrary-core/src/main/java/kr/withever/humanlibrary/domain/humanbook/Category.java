package kr.withever.humanlibrary.domain.humanbook;

import java.util.List;

import org.springframework.util.StringUtils;

public class Category {
	private Long id;
	private Long parentCategoryId;
	private String categoryName;
	private String desc;
	private String imageUrl;
	private List<Category> subCategories;
	
	public Category(){
	}

	public Category(Long id, String categoryName, String desc, Long parentCategoryId){
		this.id = id;
		this.categoryName = categoryName;
		this.desc = desc;
		this.parentCategoryId = parentCategoryId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Category> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}

	public Long getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(Long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	
	public void setUpdatedCategory(Category updatedCategory){ 
		this.categoryName = StringUtils.isEmpty(updatedCategory.getCategoryName()) ? this.categoryName : updatedCategory.getCategoryName();
		this.desc = StringUtils.isEmpty(updatedCategory.getDesc()) ? this.desc : updatedCategory.getDesc();
		this.imageUrl = StringUtils.isEmpty(updatedCategory.getImageUrl()) ?  this.imageUrl :  updatedCategory.getImageUrl();
		if(!StringUtils.isEmpty(updatedCategory.getParentCategoryId())){
			this.parentCategoryId = updatedCategory.getParentCategoryId();
			if(this.parentCategoryId == 0) this.parentCategoryId = null;
		}
	}
}
