package kr.withever.humanlibrary.repo.mapper;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.common.DayOfWeek;

@DatabaseSetup(value = {"/dataset/HumanbookServiceDay.xml"}, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = {"/dataset/HumanbookServiceDay.xml"}, type = DatabaseOperation.DELETE_ALL)
public class HumanbookServiceDayMapperTest extends WitheverDbUnitTestConfig{
	
	@Autowired
	private HumanbookServiceDayMapper humanbookServiceDayMapper;
	
	@Test
	public void selectHumanbookServiceDayList() throws Exception{
		Set<String> dayList = this.humanbookServiceDayMapper.selectHumanbookServiceDayList(1L);
		assertEquals(3, dayList.size());
	}
	
	@Test
	public void insertHumanbookServiceDay() throws Exception{
		this.humanbookServiceDayMapper.insertHumanbookServiceDay(2L, DayOfWeek.SATURDAY.name());
		Set<String> dayList = this.humanbookServiceDayMapper.selectHumanbookServiceDayList(2L);
		String day = dayList.iterator().next().toString();
		assertEquals(day, DayOfWeek.SATURDAY.name());
		assertEquals(1, dayList.size());
	}
	
	@Test
	public void deleteHumanbookServiceDay() throws Exception{
		Set<String> dayList = this.humanbookServiceDayMapper.selectHumanbookServiceDayList(1L);
		assertEquals(3, dayList.size());
		this.humanbookServiceDayMapper.deleteHumanbookServiceDay(1L, DayOfWeek.TUESDAY.name());
		dayList = this.humanbookServiceDayMapper.selectHumanbookServiceDayList(1L);
		assertEquals(2, dayList.size());
	}
}
