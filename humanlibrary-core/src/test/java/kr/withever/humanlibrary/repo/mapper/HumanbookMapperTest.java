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

@DatabaseSetup(value={"/dataset/Humanbook.xml", "/dataset/User.xml"}, type=DatabaseOperation.INSERT)
@DatabaseTearDown(value={"/dataset/Humanbook.xml", "/dataset/User.xml"}, type=DatabaseOperation.DELETE_ALL)
public class HumanbookMapperTest extends WitheverDbUnitTestConfig{

	@Autowired
	private HumanbookMapper humanbookMapper;

	@Test
	public void selectHumanbooksBySearch() throws Exception{
		HumanbookSearch search = new HumanbookSearch();
		search.setUserId("1");
		List<Humanbook> list = this.humanbookMapper.selectHumanbooksBySearch(search);
		
		assertEquals(1, list.size());
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
		assertEquals(Long.valueOf(1L), humanbook.getUser().getUserId());
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
		humanbook.setUser(new User(3L));
		humanbook.setServiceTime("aa");
		humanbook.setParentCategory(category);
		humanbook.setSubCategory(subCategory);
		humanbook.setDescription("kkkkk");
		humanbook.setCreateTime(123L);
		humanbook.setUpdateTime(123L);
		this.humanbookMapper.insertHumanbook(humanbook);
	
		Humanbook testHumanbook = this.humanbookMapper.selectHumanbook(3L);
		assertEquals(new Long(3L), testHumanbook.getId());
		assertEquals(new Long(3L), testHumanbook.getUser().getUserId());
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
		humanbook.setUser(new User(3L));
		humanbook.setServiceTime("aa");
		humanbook.setParentCategory(category);
		humanbook.setSubCategory(subCategory);
		humanbook.setUpdateTime(123L);

		this.humanbookMapper.updateHumanbook(humanbook);
		Humanbook updatedHumanbook = this.humanbookMapper.selectHumanbook(1L);
		assertEquals(new Long(3L), updatedHumanbook.getUser().getUserId());
	}
}
