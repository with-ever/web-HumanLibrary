package kr.withever.humanlibrary.repo.mapper;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.humanbook.Category;
import kr.withever.humanlibrary.domain.humanbook.CategorySearch;

@DatabaseSetup(value={"/dataset/Category.xml"}, type=DatabaseOperation.INSERT)
@DatabaseTearDown(value={"/dataset/Category.xml"}, type=DatabaseOperation.DELETE_ALL)
public class CategoryMapperTest extends WitheverDbUnitTestConfig{

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Test
	public void selectCategoriesBySearch() throws Exception{
		CategorySearch search = new CategorySearch();
		search.setParentCategoryId(2L);
		List<Category> list = this.categoryMapper.selectCategoriesBySearch(search);
		assertEquals(2, list.size());
	}
	
	@Test
	public void selectCategoriesTotalCountBySearch() throws Exception{
		CategorySearch search = new CategorySearch();
		int count = this.categoryMapper.selectCategoriesTotalCountBySearch(search);
		assertEquals(5, count);

		search.setCategoryName("IT");
		count = this.categoryMapper.selectCategoriesTotalCountBySearch(search);
		assertEquals(1, count);
	}
	
	@Test
	public void selectCategory() throws Exception{
		Category category = this.categoryMapper.selectCategory(1L);
		assertEquals("IT", category.getCategoryName());
		
		category = this.categoryMapper.selectCategory(2L);
		assertEquals("COURSE", category.getCategoryName());
		assertEquals("코스",category.getDesc());
	}
	
	@Test
	public void insertCategory() throws Exception{
		Category newCategory = new Category();
		newCategory.setId(6L);
		newCategory.setCategoryName("TOURISM");
		newCategory.setDesc("관광");
		
		this.categoryMapper.insertCategory(newCategory);
		
		Category category = this.categoryMapper.selectCategory(6L);
		assertEquals(newCategory.getCategoryName(),category.getCategoryName());
	}
	
	@Test
	public void updateCategory() throws Exception{
		Category category = new Category();
		category.setId(2L);
		category.setCategoryName("TOURISM");
		this.categoryMapper.updateCategory(category);

//		category = this.categoryMapper.selectCategory(2L);
		Category updatedCategory = this.categoryMapper.selectCategory(2L);
//		assertEquals("TOURISM", updatedCategory.getCategoryName());
		assertEquals(category.getCategoryName(), updatedCategory.getCategoryName());
	}
	
	@Test
	public void countCategory() throws Exception{
		assertEquals(5, this.categoryMapper.countCategory());
	}
	
	@Test
	public void deleteCategory() throws Exception{
		this.categoryMapper.deleteCategory(2L);
		assertEquals(4, this.categoryMapper.countCategory());
	}

	@Test
	public void selectCategories() throws Exception {
		List<Category> categories = this.categoryMapper.selectCategories();
		assertEquals(5, categories.size());
	}
}
