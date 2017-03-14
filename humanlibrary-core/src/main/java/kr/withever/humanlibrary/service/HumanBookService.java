package kr.withever.humanlibrary.service;

import kr.withever.humanlibrary.domain.common.humanbook.HumanbookState;
import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.domain.humanbook.HumanbookSearch;

public interface HumanbookService {
	
	Humanbook retrieveHumanbookByUserId(String userId);
	
	Humanbook retrieveHumanbook(Long id);
	
	Long createHumanbook(Humanbook humanBook);
	
	void modifyHumanbook(Humanbook humanbook);
	
	void removeHumanbook(Long id);
	
	void modifyHumanbookState(Long id, HumanbookState state);
	
	HumanbookSearch retrieveHumanbooksBySearch(HumanbookSearch search);
	
}
