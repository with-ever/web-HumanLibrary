package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.humanbook.ServiceDay;

public interface ServiceDayMapper {
	
	ServiceDay selectServiceDay(Long id);

	ServiceDay selectServiceDayByDay(String day);
	
	int insertServiceDay(ServiceDay serviceday);
	
	int updateServiceDay(ServiceDay serviceday);
	
	int deleteServiceDay(Long id);
	
	int countServiceDay();
	
}
