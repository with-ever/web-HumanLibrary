package kr.withever.humanlibrary.service;

import kr.withever.humanlibrary.domain.humanbook.ServiceDay;

public interface ServiceDayService {
	
	ServiceDay retrieveServiceDay(Long id);
	
	ServiceDay retrieveServiceDayByDay(String day);
	
	int createServiceDay(ServiceDay serviceDay);
	
	int modifyServiceDay(ServiceDay serviceDay);
	
	int removeServiceDay(Long id);
}
