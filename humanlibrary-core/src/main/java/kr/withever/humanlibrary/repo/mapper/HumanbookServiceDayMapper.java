package kr.withever.humanlibrary.repo.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface HumanbookServiceDayMapper {
	
	Set<String> selectHumanbookServiceDayList(Long id);
	
	int insertHumanbookServiceDay(@Param("humanbookId") Long humanbookId, @Param("dayId") String dayId);
	
	int deleteHumanbookServiceDay(@Param("humanbookId") Long humanbookId, @Param("dayId") String dayId);
}
