package kr.withever.humanlibrary.repo.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.humanbook.Category;

@DatabaseSetup(value={"/dataset/Category.xml"}, type=DatabaseOperation.INSERT)
@DatabaseTearDown(value={"/dataset/Category.xml"}, type=DatabaseOperation.DELETE_ALL)
public class CategoryMapperTest extends WitheverDbUnitTestConfig{

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Test
	public void selectCategory() throws Exception{
		Category category = this.categoryMapper.selectCategory(1L);
		assertEquals("IT", category.getCategoryName());
		
		category = this.categoryMapper.selectCategory(2L);
		assertEquals("COURSE", category.getCategoryName());
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

		category = this.categoryMapper.selectCategory(2L);
		assertEquals("TOURISM", category.getCategoryName());
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
}
