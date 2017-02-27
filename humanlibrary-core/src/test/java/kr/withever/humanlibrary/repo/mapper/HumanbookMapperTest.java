package kr.withever.humanlibrary.repo.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.humanbook.Humanbook;

@DatabaseSetup(value={"/dataset/Humanbook.xml"}, type=DatabaseOperation.INSERT)
@DatabaseTearDown(value={"/dataset/Humanbook.xml"}, type=DatabaseOperation.DELETE_ALL)
public class HumanbookMapperTest extends WitheverDbUnitTestConfig{
	
	@Autowired
	private HumanbookMapper humanbookMapper;
	
	@Test
	public void selectHumanbook() throws Exception{
		Humanbook humanbook = this.humanbookMapper.selectHumanbook(1L);
		assertEquals("SEUNG1107", humanbook.getLoginId());
	}
	
	@Test
	public void selectHumanbookById() throws Exception{
		Humanbook humanbook = this.humanbookMapper.selectHumanbookByLoginId("SEUNG1107");
		assertEquals(new Long(1L), humanbook.getHbId());
	}
	
	@Test
	public void insertHumanbook() throws Exception{
		Humanbook humanbook = new Humanbook();
		humanbook.setHbId(3L);
		humanbook.setHbMainCareer("aa");
		humanbook.setHbStatus("aa");
		humanbook.setHbTitle("aa");
		humanbook.setLoginId("aa");
		humanbook.setServiceTime("aa");
		humanbook.setUpperCategory("aa");
		humanbook.setSubCategory("aa");
		humanbook.setHbCreateTime(123L);
		humanbook.setHbUpdateTime(123L);
		this.humanbookMapper.insertHumanbook(humanbook);
		assertEquals(new Long(3L),humanbook.getHbId());
	}
	
	@Test
	public void deleteHumanbook() throws Exception{
		this.humanbookMapper.deleteHumanbook(1L);
		Humanbook humanbook = this.humanbookMapper.selectHumanbook(1L);
		assertEquals("DELETED",humanbook.getHbStatus());
	}
	
	@Test
	public void updateHumanbook() throws Exception{
		Humanbook humanbook = new Humanbook();
		humanbook.setHbId(1L);
		humanbook.setHbMainCareer("aa");
		humanbook.setHbStatus("aa");
		humanbook.setHbTitle("aa");
		humanbook.setLoginId("aa");
		humanbook.setServiceTime("aa");
		humanbook.setUpperCategory("aa");
		humanbook.setSubCategory("aa");
		humanbook.setHbUpdateTime(123L);
		this.humanbookMapper.updateHumanbook(humanbook);
		
		assertEquals("aa",humanbook.getLoginId());
	}
}
