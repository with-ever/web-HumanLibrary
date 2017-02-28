package kr.withever.humanlibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.withever.humanlibrary.domain.humanbook.ServiceDay;
import kr.withever.humanlibrary.repo.ServiceDayRepository;
import kr.withever.humanlibrary.service.ServiceDayService;

@Service
public class ServiceDayServiceImpl implements ServiceDayService {

	@Autowired
	private ServiceDayRepository serviceDayRepository;
	
	@Override
	public ServiceDay retrieveServiceDay(Long id) {
		return this.serviceDayRepository.retrieveServiceDay(id);
	}

	@Override
	public ServiceDay retrieveServiceDayByDay(String day) {
		return this.serviceDayRepository.retrieveServiceDayByDay(day);
	}

	@Override
	public int insertServiceDay(ServiceDay serviceDay) {
		return this.serviceDayRepository.insertServiceDay(serviceDay);
	}

	@Override
	public int updateServiceDay(ServiceDay serviceDay) {
		return this.serviceDayRepository.updateServiceDay(serviceDay);
	}

	@Override
	public int deleteServiceDay(Long id) {
		return this.serviceDayRepository.deleteServiceDay(id);
	}

}
