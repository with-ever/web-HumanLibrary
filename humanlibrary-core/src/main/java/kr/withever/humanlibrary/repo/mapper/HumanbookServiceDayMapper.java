package kr.withever.humanlibrary.repo.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HumanbookServiceDayMapper {
	
	Set<String> selectHumanbookServiceDayList(Long id);
	
	int insertHumanbookServiceDay(@Param("humanbookId") Long humanbookId, @Param("day") String day);
	
	int deleteHumanbookServiceDay(@Param("humanbookId") Long humanbookId, @Param("day") String day);
}
