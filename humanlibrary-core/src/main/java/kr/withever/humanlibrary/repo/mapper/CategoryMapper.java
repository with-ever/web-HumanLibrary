package kr.withever.humanlibrary.repo.mapper;

import java.util.List;

import kr.withever.humanlibrary.domain.humanbook.Category;
import kr.withever.humanlibrary.domain.humanbook.CategorySearch;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
	
	int insertCategory(Category category);

	Category selectCategory(Long id);
	
	Category selectCategoryByCategoryName(String categoryName);
	
	List<Category> selectCategoriesBySearch(CategorySearch search);
	
	int selectCategoriesTotalCountBySearch(CategorySearch search);
	
	int updateCategory(Category category);
	
	int deleteCategory(Long id);
	
	int countCategory();
	
}
