package kr.withever.humanlibrary.repo.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface HumanbookServiceDayMapper {
	
	Set<String> selectHumanbookServiceDayList(Long id);
	
	int insertHumanbookServiceDay(@Param("id") Long id, @Param("dayId") String day);
	
	int deleteHumanbookServiceDay(@Param("id") Long id, @Param("dayId") String day);
}
