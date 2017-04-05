package kr.withever.humanlibrary.domain.humanbook;

import java.util.List;

public class Category {
	private Long id;
	private String categoryName;
	private String desc;
	private List<SubCategory> childCategories;
	
	public Category(){
	}

	public Category(Long id, String categoryName, String desc){
		this.id = id;
		this.categoryName = categoryName;
		this.desc = desc;
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

	public List<SubCategory> getChildCategories() {
		return childCategories;
	}

	public void setChildCategories(List<SubCategory> childCategories) {
		this.childCategories = childCategories;
	}
}
