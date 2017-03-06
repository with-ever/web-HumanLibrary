package kr.withever.humanlibrary.repo.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.humanbook.ServiceDay;

//@DatabaseSetup(value={"/dataset/ServiceDay.xml"}, type=DatabaseOperation.INSERT)
//@DatabaseTearDown(value={"/dataset/ServiceDay.xml"}, type=DatabaseOperation.DELETE_ALL)
public class ServiceDayMapperTest extends WitheverDbUnitTestConfig {
	
//	@Autowired
//	private ServiceDayMapper serviceDayMapper;

	@Test
	public void selectServiceDay() throws Exception{
//		ServiceDay serviceDay = this.serviceDayMapper.selectServiceDay(1L);
//		assertEquals("MON",serviceDay.getDay());
	}
//
//	@Test
//	public void selectServiceDayByDay() throws Exception{
//		ServiceDay serviceDay = this.serviceDayMapper.selectServiceDayByDay("MON");
//		assertEquals(new Long(1L), serviceDay.getId());
//	}
//
//	@Test
//	public void insertServiceDay() throws Exception{
//		ServiceDay newServiceDay = new ServiceDay();
//		newServiceDay.setId(3L);
//		newServiceDay.setDay("WEDS");
//		this.serviceDayMapper.insertServiceDay(newServiceDay);
//
//		ServiceDay serviceDay = this.serviceDayMapper.selectServiceDay(3L);
//		assertEquals("WEDS",serviceDay.getDay());
//	}
//
//	@Test
//	public void countServiceDay() throws Exception{
//		assertEquals(1,this.serviceDayMapper.countServiceDay());
//	}
//
//	@Test
//	public void deleteServiceDay() throws Exception{
//		this.serviceDayMapper.deleteServiceDay(1L);
//		assertEquals(0, this.serviceDayMapper.countServiceDay());
//	}
//
//	@Test
//	public void updateServiceDay() throws Exception{
//		ServiceDay serviceDay = new ServiceDay();
//		serviceDay.setId(1L);
//		serviceDay.setDay("TUE");
//		this.serviceDayMapper.updateServiceDay(serviceDay);
//
//		ServiceDay updatedServiceDay = this.serviceDayMapper.selectServiceDay(1L);
//		assertEquals("TUE", updatedServiceDay.getDay());
//	}
}
