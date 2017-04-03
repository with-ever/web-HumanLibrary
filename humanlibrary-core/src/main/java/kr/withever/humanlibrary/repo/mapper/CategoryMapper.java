package kr.withever.humanlibrary.repo.mapper;

import java.util.List;

import kr.withever.humanlibrary.domain.humanbook.Category;
import kr.withever.humanlibrary.domain.humanbook.CategorySearch;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
	
	Category selectCategory(Long id);
	
	Category selectCategoryByCategoryName(String categoryName);
	
	int insertCategory(Category category);
	
	int updateCategory(Category category);
	
	int deleteCategory(Long id);
	
	int countCategory();
	
	List<Category> selectCategoriesBySearch(CategorySearch search);
	
	int selectCategoriesTotalCountBySearch(CategorySearch search);
	
}
