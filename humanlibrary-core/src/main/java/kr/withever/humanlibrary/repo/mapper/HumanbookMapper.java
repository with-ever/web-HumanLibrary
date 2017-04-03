package kr.withever.humanlibrary.repo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.withever.humanlibrary.domain.common.humanbook.HumanbookState;
import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.domain.humanbook.HumanbookSearch;

@Mapper
public interface HumanbookMapper {
	
	Humanbook selectHumanbook(Long id);
	
	Humanbook selectHumanbookByUserId(String userId);
	
	int insertHumanbook(Humanbook humanbook);
	
	int updateHumanbook(Humanbook humanbook);
	
	int deleteHumanbook(Long id);
	
	int updateHumanbookState(@Param("id") Long id, @Param("state") HumanbookState state);
	
	List<Humanbook> selectHumanbooksBySearch(HumanbookSearch search);
	
	int selectHumanbooksTotalCountBySearch(HumanbookSearch search);
}
