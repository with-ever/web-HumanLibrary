package kr.withever.humanlibrary.service.impl;

import kr.withever.humanlibrary.exception.HumanLibraryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import kr.withever.humanlibrary.repo.HumanbookRepository;
import kr.withever.humanlibrary.service.HumanBookService;

@Service
public class HumanBookServiceImpl implements HumanBookService {

	@Autowired
	private HumanbookRepository humanbookRepository;
	
	@Override
	public Humanbook retrieveHumanbook(Long id){
		Humanbook humanbook = this.humanbookRepository.retrieveHumanbook(id);
		// @TODO error code update
		// if(humanbook == null) throw new HumanLibraryNotFoundException(ExceptionType.US10002, String.valueOf(id), "success");
		return humanbook;
	}

	@Override
	public Humanbook retrieveHumanbookByUserId(String userId) {
		Humanbook humanbook = this.humanbookRepository.retrieveHumanbookByUserId(userId);
		// @TODO error code update
		// if(humanbook == null) throw new HumanLibraryNotFoundException(ExceptionType.US10002, String.valueOf(userId), "success");
		return humanbook;
	}
	
	@Override
	public int createHumanbook(Humanbook humanbook){
		return this.humanbookRepository.createHumanbook(humanbook);
	}
	
	@Override
	public int removeHumanbook(Long id){
		return this.humanbookRepository.removeHumanbook(id);
	}
	
	@Override
	public int modifyHumanbook(Humanbook humanbook){
		return this.humanbookRepository.modifyHumanbook(humanbook);
	}
}
