package kr.withever.humanlibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.repo.HumanbookRepository;
import kr.withever.humanlibrary.service.HumanBookService;

@Service
public class HumanBookServiceImpl implements HumanBookService {

	@Autowired
	private HumanbookRepository humanbookRepository;
	
	@Override
	public Humanbook retrieveHumanbookByUserId(String userId) {
		return this.humanbookRepository.retrieveHumanbookByUserId(userId);
	}
	
	@Override
	public Humanbook retrieveHumanbook(Long id){
		return this.humanbookRepository.retrieveHumanbook(id);
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
