package kr.withever.humanlibrary.repo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.repo.mapper.HumanbookMapper;
import kr.withever.humanlibrary.repo.mapper.HumanbookServiceDayMapper;

@Repository
public class HumanbookRepository {
	
	@Autowired
	private HumanbookMapper humanbookMapper;
	
	@Autowired
	private HumanbookServiceDayMapper humanbookServiceDayMapper;
	
	public Humanbook retrieveHumanbook(Long id){
		Humanbook humanbook = this.humanbookMapper.selectHumanbook(id);
		if(humanbook != null){
			Set<String> dayList = this.humanbookServiceDayMapper.selectHumanbookServiceDayList(id);
			humanbook.setServiceDay(dayList);
		}
		return humanbook;
	}
	
	public Humanbook retrieveHumanbookByUserId(String userId){
		Humanbook humanbook = this.humanbookMapper.selectHumanbookByUserId(userId);
		if(humanbook != null){
			Set<String> dayList = this.humanbookServiceDayMapper.selectHumanbookServiceDayList(humanbook.getId());
			humanbook.setServiceDay(dayList);
		}
		return humanbook;
	}
	
	public int createHumanbook(Humanbook humanbook){
		try{
			this.humanbookMapper.insertHumanbook(humanbook);
			return 1;
		}catch(Exception e){
			return 0;
		}
	}
	
	public int modifyHumanbook(Humanbook humanbook){
		try {
			this.humanbookMapper.updateHumanbook(humanbook);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int removeHumanbook(Long id){
		try{
			this.humanbookMapper.deleteHumanbook(id);
			return 1;
		}catch(Exception e){
			return 0;
		}
	}
	
}
