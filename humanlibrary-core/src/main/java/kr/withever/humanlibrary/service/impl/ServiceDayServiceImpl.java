package kr.withever.humanlibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.humanbook.ServiceDay;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import kr.withever.humanlibrary.repo.ServiceDayRepository;
import kr.withever.humanlibrary.service.ServiceDayService;

@Service
public class ServiceDayServiceImpl implements ServiceDayService {

	@Autowired
	private ServiceDayRepository serviceDayRepository;
	
	@Override
	public ServiceDay retrieveServiceDay(Long id) {
		ServiceDay serviceDay = this.serviceDayRepository.retrieveServiceDay(id);
		if(serviceDay == null) throw new HumanLibraryException(ExceptionType.US10002, String.valueOf(id), "success");
		return serviceDay;
	}

	@Override
	public ServiceDay retrieveServiceDayByDay(String day) {
		ServiceDay serviceDay = this.serviceDayRepository.retrieveServiceDayByDay(day);
		if(serviceDay == null) throw new HumanLibraryException(ExceptionType.US10002, String.valueOf(day), "success");
		return serviceDay;
	}

	@Override
	public int createServiceDay(ServiceDay serviceDay) {
		return this.serviceDayRepository.createServiceDay(serviceDay);
	}

	@Override
	public int modifyServiceDay(ServiceDay serviceDay) {
		return this.serviceDayRepository.modifyServiceDay(serviceDay);
	}

	@Override
	public int removeServiceDay(Long id) {
		return this.serviceDayRepository.removeServiceDay(id);
	}

}
