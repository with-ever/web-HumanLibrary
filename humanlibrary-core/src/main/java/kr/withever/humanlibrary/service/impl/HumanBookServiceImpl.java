package kr.withever.humanlibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.common.humanbook.HumanbookState;
import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.domain.humanbook.HumanbookSearch;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import kr.withever.humanlibrary.repo.HumanbookRepository;
import kr.withever.humanlibrary.service.HumanbookService;

@Service
public class HumanbookServiceImpl implements HumanbookService {

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
	public Long createHumanbook(Humanbook humanbook){
		return this.humanbookRepository.createHumanbook(humanbook);
	}
	
	@Override
	public void removeHumanbook(Long id){
		this.humanbookRepository.removeHumanbook(id);
	}
	
	@Override
	public void modifyHumanbook(Humanbook humanbook){
		this.humanbookRepository.modifyHumanbook(humanbook);
	}

	@Override
	public void modifyHumanbookState(Long id, HumanbookState state) {
		this.humanbookRepository.modifyHumanbookState(id, state);
	}

	@Override
	public HumanbookSearch retrieveHumanbooksBySearch(HumanbookSearch search) {
		return this.humanbookRepository.selectHumanbooksBySearch(search);
	}
}
