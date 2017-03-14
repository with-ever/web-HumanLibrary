package kr.withever.humanlibrary.repo;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.common.humanbook.HumanbookState;
import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.domain.humanbook.HumanbookSearch;
import kr.withever.humanlibrary.exception.HumanLibraryException;
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
	
	public Long createHumanbook(Humanbook humanbook){
		this.humanbookMapper.insertHumanbook(humanbook);
		return humanbook.getId();
	}
	
	public void modifyHumanbook(Humanbook humanbook){
		try {
			this.humanbookMapper.updateHumanbook(humanbook);
		} catch (Exception e) {
			throw new HumanLibraryException(e, ExceptionType.US10000);
		}
	}

	public void removeHumanbook(Long id){
		try{
			this.humanbookMapper.deleteHumanbook(id);
		}catch(Exception e){
			throw new HumanLibraryException(e, ExceptionType.US10000);
		}
	}
	
	public void modifyHumanbookState(Long id, HumanbookState state){
		try {
			this.humanbookMapper.updateHumanbookState(id, state);
		} catch (Exception e) {
			throw new HumanLibraryException(e, ExceptionType.US10000);
		}
	}
	
	public HumanbookSearch selectHumanbooksBySearch(HumanbookSearch search){
		List<Humanbook> humanbooks = this.humanbookMapper.selectHumanbooksBySearch(search);
		search.setResults(humanbooks);
		if(humanbooks.size() != 0){
			int totalCount = this.humanbookMapper.selectHumanbooksTotalCountBySearch(search);
			search.setTotalCount(totalCount);
		}
		return search;
	}
	
}
