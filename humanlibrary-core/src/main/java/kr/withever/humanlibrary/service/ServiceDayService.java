package kr.withever.humanlibrary.service;

import kr.withever.humanlibrary.domain.humanbook.ServiceDay;

public interface ServiceDayService {
	
	ServiceDay retrieveServiceDay(Long id);
	
	ServiceDay retrieveServiceDayByDay(String day);
	
	int insertServiceDay(ServiceDay serviceDay);
	
	int updateServiceDay(ServiceDay serviceDay);
	
	int deleteServiceDay(Long id);
}
