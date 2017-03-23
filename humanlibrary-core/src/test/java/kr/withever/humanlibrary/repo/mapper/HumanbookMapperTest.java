package kr.withever.humanlibrary.repo.mapper;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
import kr.withever.humanlibrary.domain.humanbook.SubCategory;

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
		
		assertEquals(1, list.size());
	}
	
	@Test
	public void selectHumanbooksTotalCountBySearch() throws Exception{
		HumanbookSearch search = new HumanbookSearch();
		search.setId(1L);
		int count = this.humanbookMapper.selectHumanbooksTotalCountBySearch(search);
		
		assertEquals(1, count);
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
		assertEquals("SEUNG1107", humanbook.getUserId());
	}

	@Test
	public void selectHumanbookById() throws Exception{
		Humanbook humanbook = this.humanbookMapper.selectHumanbookByUserId("SEUNG1107");
		assertEquals(new Long(1L), humanbook.getId());
	}

	@Test
	public void insertHumanbook() throws Exception{
		Category category = new Category(1L,"IT");
		SubCategory subCategory = new SubCategory(1L, "DEVELOP", 1L);
		Humanbook humanbook = new Humanbook();
		humanbook.setId(3L);
		humanbook.setMainCareer("aa");
		humanbook.setState(HumanbookState.ACCEPT);
		humanbook.setTitle("aa");
		humanbook.setUserId("aa");
		humanbook.setServiceTime("aa");
		humanbook.setParentCategory(category);
		humanbook.setSubCategory(subCategory);
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
		Humanbook humanbook = this.humanbookMapper.selectHumanbook(1L);
		assertEquals(HumanbookState.ACCEPT,humanbook.getState());
		this.humanbookMapper.deleteHumanbook(1L);
		humanbook = this.humanbookMapper.selectHumanbook(1L);
		assertEquals(HumanbookState.CANCEL,humanbook.getState());
	}

	@Test
	public void updateHumanbook() throws Exception{
		Category category = new Category(1L,"IT");
		SubCategory subCategory = new SubCategory(2L, "DBA", 1L);
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
