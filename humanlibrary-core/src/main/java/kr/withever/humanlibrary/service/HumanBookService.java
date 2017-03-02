package kr.withever.humanlibrary.service;

import kr.withever.humanlibrary.domain.humanbook.Humanbook;

public interface HumanBookService {
	
	Humanbook retrieveHumanbookByUserId(String userId);
	
	Humanbook retrieveHumanbook(Long id);
	
	int insertHumanbook(Humanbook humanBook);
	
	int updateHumanbook(Humanbook humanbook);
	
	int deleteHumanbook(Long id);
}
