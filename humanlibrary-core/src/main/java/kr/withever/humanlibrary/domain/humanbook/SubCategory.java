package kr.withever.humanlibrary.domain.humanbook;

public class SubCategory {
	private Long id;
	private String categoryName;
	private Long parentCategoryId;
	
	public SubCategory(){
	}
	
	public SubCategory(Long id, String categoryName, Long upperCategoryId){
		this.id = id;
		this.categoryName = categoryName;
		this.parentCategoryId = upperCategoryId;
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
	public Long getParentCategoryId() {
		return parentCategoryId;
	}
	public void setParentCategoryId(Long upperCategoryId) {
		this.parentCategoryId = upperCategoryId;
	}
}
