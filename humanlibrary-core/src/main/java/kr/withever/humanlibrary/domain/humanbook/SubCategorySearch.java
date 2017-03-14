package kr.withever.humanlibrary.domain.humanbook;

import kr.withever.humanlibrary.domain.common.PageSearch;

public class SubCategorySearch extends PageSearch<SubCategory> {
	
	private Long id;
	private String categoryName;
	private Long parentCategoryId;
	
	
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

	public Long getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(Long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	
	
	
}
