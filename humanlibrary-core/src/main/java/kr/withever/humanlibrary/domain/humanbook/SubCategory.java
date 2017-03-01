package kr.withever.humanlibrary.domain.humanbook;

public class SubCategory {
	private Long id;
	private String categoryName;
	private Long upperCategoryId;
	
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
	public Long getUpperCategoryId() {
		return upperCategoryId;
	}
	public void setUpperCategoryId(Long upperCategoryId) {
		this.upperCategoryId = upperCategoryId;
	}
}
