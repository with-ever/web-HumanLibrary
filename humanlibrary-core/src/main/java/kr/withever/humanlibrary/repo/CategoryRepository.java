package kr.withever.humanlibrary.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.withever.humanlibrary.domain.humanbook.Category;
import kr.withever.humanlibrary.repo.mapper.CategoryMapper;

@Repository
public class CategoryRepository {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	public Category selectCategory(Long id){
		return this.categoryMapper.selectCategory(id);
	}
	
	public Category selectCategoryByCategoryName(String categoryName){
		return this.categoryMapper.selectCategoryByCategoryName(categoryName);
	}
	
	public int insertCategory(Category category){
		try {
			this.categoryMapper.insertCategory(category);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int updateCategory(Category category){
		try {
			this.categoryMapper.updateCategory(category);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int deleteCategory(Long id){
		try {
			this.categoryMapper.deleteCategory(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int countCategory(){
		return this.categoryMapper.countCategory();
	}
}
