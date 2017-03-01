package kr.withever.humanlibrary.repo.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.humanbook.SubCategory;

@DatabaseSetup(value={"/dataset/SubCategory.xml"}, type=DatabaseOperation.INSERT)
@DatabaseTearDown(value={"/dataset/SubCategory.xml"}, type=DatabaseOperation.DELETE_ALL)
public class SubCategoryMapperTest extends WitheverDbUnitTestConfig{
	
	@Autowired
	private SubCategoryMapper subCategoryMapper;
	
	SubCategory subCategory;
	
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
		testSubCategory.setId(2L);
		testSubCategory.setCategoryName("OPERATION");
		testSubCategory.setUpperCategoryId(1L);
		this.subCategoryMapper.insertSubCategory(testSubCategory);
		
		subCategory = this.subCategoryMapper.selectSubCategory(2L);
		assertEquals("OPERATION", testSubCategory.getCategoryName());
	}
	
	@Test
	public void updateSubCategory() throws Exception{
		SubCategory testSubCategory = new SubCategory();
		testSubCategory.setId(1L);
		testSubCategory.setCategoryName("SOFTWARE");
		testSubCategory.setUpperCategoryId(1L);
		this.subCategoryMapper.updateSubCategory(testSubCategory);
		
		subCategory = this.subCategoryMapper.selectSubCategory(1L);
		assertEquals("SOFTWARE", subCategory.getCategoryName());
	}
	
	@Test
	public void deleteSubCategory() throws Exception{
		this.subCategoryMapper.deleteSubCategory(1L);
		assertEquals(0, this.subCategoryMapper.countSubCategory());
	}
	
	@Test
	public void countSubCategory() throws Exception{
		assertEquals(1,this.subCategoryMapper.countSubCategory());
	}
	
}
