package kr.withever.humanlibrary.domain.humanbook;

public class Category {
	private Long id;
	private String categoryName;
//	private List<Category> parentCategory;
	//root category has null in 'parentCategory'
	//child category has parentCategory's id in 'parentCategory'
	
	public Category(){
	}
	
	public Category(Long id, String categoryName){
		this.id = id;
		this.categoryName = categoryName;
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
}
