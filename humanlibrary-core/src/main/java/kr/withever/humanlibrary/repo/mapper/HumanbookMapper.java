package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.humanbook.Humanbook;

public interface HumanbookMapper {
	
	Humanbook selectHumanbook(Long hbId);
	
	Humanbook selectHumanbookByLoginId(String loginId);
	
	int insertHumanbook(Humanbook humanbook);
	
	int updateHumanbook(Humanbook humanbook);
	
	int deleteHumanbook(Long hbId);
	
}
