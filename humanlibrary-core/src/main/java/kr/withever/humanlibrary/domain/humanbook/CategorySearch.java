package kr.withever.humanlibrary.domain.humanbook;

import kr.withever.humanlibrary.domain.common.PageSearch;

public class CategorySearch extends PageSearch<Category>{
	
	private Long id;
	private Long parentCategoryId;
	private String categoryName;
	private String desc;
	
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(Long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	

}
