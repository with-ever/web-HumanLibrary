package kr.withever.humanlibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.withever.humanlibrary.domain.common.humanbook.HumanbookState;
import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.domain.humanbook.HumanbookSearch;
import kr.withever.humanlibrary.repo.CategoryRepository;
import kr.withever.humanlibrary.repo.HumanbookRepository;
import kr.withever.humanlibrary.repo.SubCategoryRepository;
import kr.withever.humanlibrary.service.HumanbookService;

@Service
public class HumanbookServiceImpl implements HumanbookService {

	@Autowired
	private HumanbookRepository humanbookRepository;

	
	@Override
	public Long createHumanbook(Humanbook humanbook){
		return this.humanbookRepository.createHumanbook(humanbook);
	}

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
	public HumanbookSearch retrieveHumanbooksBySearch(HumanbookSearch search) {
		return this.humanbookRepository.retrieveHumanbooksBySearch(search);
	}
	
	@Override
	public HumanbookSearch retrieveHumanbooksByCategory(HumanbookSearch search){
		return this.humanbookRepository.retrieveHumanbooksByCategory(search);
	}
	
	@Override
	public HumanbookSearch retrieveHumanbooksBySubCategory(HumanbookSearch search){
		return this.humanbookRepository.retrieveHumanbooksByCategoryBySubCategory(search);
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
	public void rejectHumanbookRegister(Long id) {
		this.humanbookRepository.modifyHumanbookState(id, HumanbookState.REJECT);
	}
	
	@Override
	public void acceptHumanbookRegister(Long id) {
		this.humanbookRepository.modifyHumanbookState(id, HumanbookState.ACCEPT);
	}
	
	@Override
	public void removeHumanbook(Long id){
		this.humanbookRepository.removeHumanbook(id);
	}
}
