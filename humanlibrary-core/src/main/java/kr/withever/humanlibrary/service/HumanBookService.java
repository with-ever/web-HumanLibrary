package kr.withever.humanlibrary.service;

import kr.withever.humanlibrary.domain.humanbook.Humanbook;

public interface HumanBookService {
	
	Humanbook retrieveHumanbookByLoginId(String loginId);
	
	Humanbook retrieveHumanbook(Long hbId);
	
	int insertHumanbook(Humanbook humanBook);
	
	int deleteHumanbook(Long hbId);
	
	int updateHumanbook(Humanbook humanbook);
}
