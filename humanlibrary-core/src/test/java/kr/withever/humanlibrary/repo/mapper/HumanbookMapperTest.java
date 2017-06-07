package kr.withever.humanlibrary.repo.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import kr.withever.humanlibrary.domain.user.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.common.humanbook.HumanbookState;
import kr.withever.humanlibrary.domain.humanbook.Category;
import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.domain.humanbook.HumanbookSearch;

@DatabaseSetup(value={"/dataset/Humanbook.xml"}, type=DatabaseOperation.INSERT)
@DatabaseTearDown(value={"/dataset/Humanbook.xml"}, type=DatabaseOperation.DELETE_ALL)
public class HumanbookMapperTest extends WitheverDbUnitTestConfig{

	@Autowired
	private HumanbookMapper humanbookMapper;

	@Test
	public void selectHumanbooksBySearch() throws Exception{
		HumanbookSearch search = new HumanbookSearch();
		search.setId(1L);
		List<Humanbook> list = this.humanbookMapper.selectHumanbooksBySearch(search);
		
		assertEquals(2, list.size());
	}
	
	@Test
	public void selectHumanbooksTotalCountBySearch() throws Exception{
		HumanbookSearch search = new HumanbookSearch();
		search.setId(1L);
		int count = this.humanbookMapper.selectHumanbooksTotalCountBySearch(search);
		
		assertEquals(2, count);
	}
	
	@Test
	public void updateHumanbookState() throws Exception{
		this.humanbookMapper.updateHumanbookState(1L, HumanbookState.REJECT);
		Humanbook humanbook = this.humanbookMapper.selectHumanbook(1L);
		assertEquals(HumanbookState.REJECT, humanbook.getState());
	}
	
	@Test
	public void selectHumanbook() throws Exception{
		Humanbook humanbook = this.humanbookMapper.selectHumanbook(1L);
		System.out.println(humanbook.getParentCategory().getId());
		System.out.println(humanbook.getSubCategory().getId());
		assertEquals("4", humanbook.getUserId());
		assertEquals("설명글입니다", humanbook.getDescription());
	}

	@Test
	public void insertHumanbook() throws Exception{
		Category category = new Category(1L,"IT","아이티", null);
		Category subCategory = new Category(3L, "DEVELOP", "개발자", 1L);
		Humanbook humanbook = new Humanbook();
		humanbook.setId(3L);
		humanbook.setMainCareer("aa");
		humanbook.setState(HumanbookState.ACCEPT);
		humanbook.setTitle("aa");
		humanbook.setUserId("aa");
		humanbook.setServiceTime("aa");
		humanbook.setParentCategory(category);
		humanbook.setSubCategory(subCategory);
		humanbook.setDescription("kkkkk");
		humanbook.setCreateTime(123L);
		humanbook.setUpdateTime(123L);
		this.humanbookMapper.insertHumanbook(humanbook);
	
		Humanbook testHumanbook = this.humanbookMapper.selectHumanbook(3L);
		System.out.println(testHumanbook.getParentCategory().getId());
		System.out.println(testHumanbook.getParentCategory().getCategoryName());
		assertEquals(new Long(3L),testHumanbook.getId());
	}

	@Test
	public void deleteHumanbook() throws Exception{
		this.humanbookMapper.deleteHumanbook(1L);
		Humanbook humanbook = this.humanbookMapper.selectHumanbook(1L);
		assertNull(humanbook);
	}

	@Test
	public void updateHumanbook() throws Exception{
		Category category = new Category(1L,"IT","아이티", null);
		Category subCategory = new Category(2L, "DBA", "DB관리자", 1L);
		Humanbook humanbook = new Humanbook();
		humanbook.setId(1L);
		humanbook.setMainCareer("aa");
		humanbook.setState(HumanbookState.ACCEPT);
		humanbook.setTitle("aa");
		humanbook.setUserId("aa");
		humanbook.setServiceTime("aa");
		humanbook.setParentCategory(category);
		humanbook.setSubCategory(subCategory);
		humanbook.setUpdateTime(123L);

		this.humanbookMapper.updateHumanbook(humanbook);
		Humanbook updatedHumanbook = this.humanbookMapper.selectHumanbook(1L);
		assertEquals("aa",updatedHumanbook.getUserId());
	}
}
