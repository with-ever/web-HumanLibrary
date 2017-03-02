package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.humanbook.Humanbook;

public interface HumanbookMapper {
	
	Humanbook selectHumanbook(Long id);
	
	Humanbook selectHumanbookByUserId(String userId);
	
	int insertHumanbook(Humanbook humanbook);
	
	int updateHumanbook(Humanbook humanbook);
	
	int deleteHumanbook(Long id);
	
}
