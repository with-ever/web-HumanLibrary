package kr.withever.humanlibrary.repo.mapper;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.common.DayOfWeek;
import kr.withever.humanlibrary.domain.humanbook.Humanbook;

@DatabaseSetup(value={"/dataset/Humanbook.xml"}, type=DatabaseOperation.INSERT)
@DatabaseTearDown(value={"/dataset/Humanbook.xml"}, type=DatabaseOperation.DELETE_ALL)
public class HumanbookMapperTest extends WitheverDbUnitTestConfig{
	
	@Autowired
	private HumanbookMapper humanbookMapper;
	
	@Test
	public void selectHumanbook() throws Exception{
		Humanbook humanbook = this.humanbookMapper.selectHumanbook(1L);
		
		assertEquals("SEUNG1107", humanbook.getUserId());
	}
	
	@Test
	public void selectHumanbookById() throws Exception{
		Humanbook humanbook = this.humanbookMapper.selectHumanbookByUserId("SEUNG1107");
		assertEquals(new Long(1L), humanbook.getId());
	}
	
	@Test
	public void insertHumanbook() throws Exception{
		Humanbook humanbook = new Humanbook();
		humanbook.setId(3L);
		humanbook.setMainCareer("aa");
		humanbook.setStatus("aa");
		humanbook.setTitle("aa");
		humanbook.setUserId("aa");
		humanbook.setServiceTime("aa");
		humanbook.setUpperCategory("aa");
		humanbook.setSubCategory("aa");
		humanbook.setCreateTime(123L);
		humanbook.setUpdateTime(123L);
		
		this.humanbookMapper.insertHumanbook(humanbook);
		assertEquals(new Long(3L),humanbook.getId());
	}
	
	@Test
	public void deleteHumanbook() throws Exception{
		this.humanbookMapper.deleteHumanbook(1L);
		Humanbook humanbook = this.humanbookMapper.selectHumanbook(1L);
		assertEquals("DELETED",humanbook.getStatus());
	}
	
	@Test
	public void updateHumanbook() throws Exception{
		Humanbook humanbook = new Humanbook();
		humanbook.setId(1L);
		humanbook.setMainCareer("aa");
		humanbook.setStatus("aa");
		humanbook.setTitle("aa");
		humanbook.setUserId("aa");
		humanbook.setServiceTime("aa");
		humanbook.setUpperCategory("aa");
		humanbook.setSubCategory("aa");
		humanbook.setUpdateTime(123L);

		this.humanbookMapper.updateHumanbook(humanbook);
		Humanbook updatedHumanbook = this.humanbookMapper.selectHumanbook(1L);
		assertEquals("aa",updatedHumanbook.getUserId());
	}
}
