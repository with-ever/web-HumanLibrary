package kr.withever.humanlibrary.service;

import kr.withever.humanlibrary.domain.humanbook.Humanbook;

public interface HumanBookService {
	
	Humanbook retrieveHumanbookByUserId(String userId);
	
	Humanbook retrieveHumanbook(Long id);
	
	int createHumanbook(Humanbook humanBook);
	
	int modifyHumanbook(Humanbook humanbook);
	
	int removeHumanbook(Long id);
}
