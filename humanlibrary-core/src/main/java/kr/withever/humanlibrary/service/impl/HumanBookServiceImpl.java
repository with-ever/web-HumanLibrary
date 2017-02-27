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
	public Humanbook retrieveHumanbookByLoginId(String loginId) {
		return this.humanbookRepository.retrieveHumanbookById(loginId);
	}
	
	@Override
	public Humanbook retrieveHumanbook(Long hbId){
		return this.humanbookRepository.retrieveHumanbook(hbId);
	}
	
	@Override
	public int insertHumanbook(Humanbook humanbook){
		return this.humanbookRepository.insertHumanbook(humanbook);
	}
	
	@Override
	public int deleteHumanbook(Long hbId){
		return this.humanbookRepository.deleteHumanbook(hbId);
	}
	
	@Override
	public int updateHumanbook(Humanbook humanbook){
		return this.humanbookRepository.updateHumanbook(humanbook);
	}
}
