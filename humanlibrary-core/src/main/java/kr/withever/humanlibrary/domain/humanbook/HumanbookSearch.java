package kr.withever.humanlibrary.domain.humanbook;

import kr.withever.humanlibrary.domain.common.PageSearch;

public class HumanbookSearch extends PageSearch<Humanbook>{
	
	private Long id;
	private Long parentCategoryId;
	private Long subCategoryId;

	public Long getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(Long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
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
