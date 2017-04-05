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
import kr.withever.humanlibrary.domain.humanbook.SubCategory;
import kr.withever.humanlibrary.domain.humanbook.SubCategorySearch;

@DatabaseSetup(value={"/dataset/SubCategory.xml"}, type=DatabaseOperation.INSERT)
@DatabaseTearDown(value={"/dataset/SubCategory.xml"}, type=DatabaseOperation.DELETE_ALL)
public class SubCategoryMapperTest extends WitheverDbUnitTestConfig{
	
	@Autowired
	private SubCategoryMapper subCategoryMapper;
	
	SubCategory subCategory;
	
	@Test
	public void selectSubCategoryList() throws Exception{
		SubCategorySearch search = new SubCategorySearch();
		search.setId(1L);
		search.setCategoryName("DEVELOP");
		List<SubCategory> list = this.subCategoryMapper.selectSubCategoriesBySearch(search);
		assertEquals(2, list.size());
	}
	
	@Test
	public void selectSubCategoriesTotalCountBySearch() throws Exception{
		SubCategorySearch search = new SubCategorySearch();
		search.setCategoryName("DEVELOP");
		search.setId(1L);
		search.setParentCategoryId(1L);
		int count = this.subCategoryMapper.selectSubCategoriesTotalCountBySearch(search);
		
		assertEquals(2, count);
	}
	
	@Test
	public void selectSubCategory() throws Exception{
		subCategory = this.subCategoryMapper.selectSubCategory(1L);
		assertEquals("DEVELOP", subCategory.getCategoryName());
	}
	
	@Test
	public void selectSubCategoryByCategoryName() throws Exception{
		subCategory = this.subCategoryMapper.selectSubCategoryByCategoryName("DEVELOP");
		assertEquals(new Long(1L), subCategory.getId());
	}
	
	@Test
	public void insertSubCategory() throws Exception{
		SubCategory testSubCategory = new SubCategory();
		testSubCategory.setId(3L);
		testSubCategory.setCategoryName("OPERATION");
		testSubCategory.setDesc("경영");
		testSubCategory.setParentCategoryId(1L);
		this.subCategoryMapper.insertSubCategory(testSubCategory);
		
		subCategory = this.subCategoryMapper.selectSubCategory(2L);
		assertEquals("OPERATION", testSubCategory.getCategoryName());
	}
	
	@Test
	public void updateSubCategory() throws Exception{
		SubCategory testSubCategory = new SubCategory();
		testSubCategory.setId(1L);
		testSubCategory.setCategoryName("SOFTWARE");
		testSubCategory.setDesc("소프트웨어");
		testSubCategory.setParentCategoryId(1L);
		this.subCategoryMapper.updateSubCategory(testSubCategory);
		
		subCategory = this.subCategoryMapper.selectSubCategory(1L);
		assertEquals("SOFTWARE", subCategory.getCategoryName());
		assertEquals("소프트웨어", subCategory.getDesc());
	}
	
	@Test
	public void deleteSubCategory() throws Exception{
		this.subCategoryMapper.deleteSubCategory(1L);
		assertEquals(1, this.subCategoryMapper.countSubCategory());
	}
	
	@Test
	public void countSubCategory() throws Exception{
		assertEquals(2,this.subCategoryMapper.countSubCategory());
	}
	
}
