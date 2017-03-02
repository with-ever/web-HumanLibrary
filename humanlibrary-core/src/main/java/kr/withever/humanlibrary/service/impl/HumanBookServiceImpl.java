package kr.withever.humanlibrary.service.impl;

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
		if(humanbook == null) throw new HumanLibraryException(ExceptionType.US10002, String.valueOf(id), "success");
		return humanbook;
	}

	@Override
	public Humanbook retrieveHumanbookByUserId(String userId) {
		Humanbook humanbook = this.humanbookRepository.retrieveHumanbookByUserId(userId);
		if(humanbook == null) throw new HumanLibraryException(ExceptionType.US10002, String.valueOf(userId), "success");
		return humanbook;
	}
	
	@Override
	public int insertHumanbook(Humanbook humanbook){
		return this.humanbookRepository.insertHumanbook(humanbook);
	}
	
	@Override
	public int deleteHumanbook(Long id){
		return this.humanbookRepository.deleteHumanbook(id);
	}
	
	@Override
	public int updateHumanbook(Humanbook humanbook){
		return this.humanbookRepository.updateHumanbook(humanbook);
	}
}
