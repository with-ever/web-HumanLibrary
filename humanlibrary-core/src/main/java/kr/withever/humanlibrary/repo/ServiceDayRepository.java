package kr.withever.humanlibrary.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.withever.humanlibrary.domain.humanbook.ServiceDay;
import kr.withever.humanlibrary.repo.mapper.ServiceDayMapper;

@Repository
public class ServiceDayRepository {
	
	@Autowired
	private ServiceDayMapper serviceDayMapper;
	
	public ServiceDay retrieveServiceDay(Long id){
		ServiceDay serviceDay = this.serviceDayMapper.selectServiceDay(id);
		return serviceDay;
	}
	
	public ServiceDay retrieveServiceDayByDay(String day){
		ServiceDay serviceDay = this.serviceDayMapper.selectServiceDayByDay(day);
		return serviceDay;
	}
	
	public int insertServiceDay(ServiceDay serviceDay){
		try{
			this.serviceDayMapper.insertServiceDay(serviceDay);
			return 1;
		}catch (Exception e) {
			return 0;
		}
	}

	public int updateServiceDay(ServiceDay serviceDay){
		try {
			this.serviceDayMapper.updateServiceDay(serviceDay);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int deleteServiceDay(Long id){
		try {
			this.serviceDayMapper.deleteServiceDay(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
}
