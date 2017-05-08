package kr.withever.humanlibrary.domain.humanbook;

import kr.withever.humanlibrary.domain.common.PageSearch;

public class HumanbookSearch extends PageSearch<Humanbook>{
	
	private Long id;
	private Long categoryId;
	private Long subCategoryId;
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Long subCategory) {
		this.subCategoryId = subCategory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
