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
		search.setId(1L);
		search.setCategoryName("IT");
		List<Category> list = this.categoryMapper.selectCategoriesBySearch(search);
		assertEquals(2, list.size());
	}
	
	@Test
	public void selectCategoriesTotalCountBySearch() throws Exception{
		CategorySearch search = new CategorySearch();
		search.setId(1L);
		search.setCategoryName("IT");
		int count = this.categoryMapper.selectCategoriesTotalCountBySearch(search);
		
		assertEquals(2, count);
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
	public void selectCategoryByCategoryName() throws Exception{
		Category category = this.categoryMapper.selectCategoryByCategoryName("IT");
		assertEquals(new Long(1L), category.getId());
	}
	
	@Test
	public void insertCategory() throws Exception{
		Category newCategory = new Category();
		newCategory.setId(3L);
		newCategory.setCategoryName("TOURISM");
		newCategory.setDesc("관광");
		this.categoryMapper.insertCategory(newCategory);
		
		Category category = this.categoryMapper.selectCategory(3L);
		assertEquals("TOURISM",category.getCategoryName());
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
		assertEquals(2, this.categoryMapper.countCategory());
	}
	
	@Test
	public void deleteCategory() throws Exception{
		this.categoryMapper.deleteCategory(2L);
		assertEquals(1, this.categoryMapper.countCategory());
	}

	@Test
	public void selectCategories() throws Exception {
		List<Category> categories = this.categoryMapper.selectCategories();
		assertEquals(2, categories.size());
	}
}
