package kr.withever.humanlibrary.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.repo.mapper.HumanbookMapper;

@Repository
public class HumanbookRepository {
	
	@Autowired
	private HumanbookMapper humanbookMapper;
	
	public Humanbook retrieveHumanbook(Long hbId){
		Humanbook humanbook = this.humanbookMapper.selectHumanbook(hbId);
		return humanbook;
	}
	
	public Humanbook retrieveHumanbookById(String loginId){
		Humanbook humanbook = this.humanbookMapper.selectHumanbookByLoginId(loginId);
		return humanbook;
	}
	
	public int insertHumanbook(Humanbook humanbook){
		try{
			this.humanbookMapper.insertHumanbook(humanbook);
			return 1;
		}catch(Exception e){
			return 0;
		}
	}
	
	public int deleteHumanbook(Long hbId){
		try{
			this.humanbookMapper.deleteHumanbook(hbId);
			return 1;
		}catch(Exception e){
			return 0;
		}
	}
	
	public int updateHumanbook(Humanbook humanbook){
		try {
			this.humanbookMapper.updateHumanbook(humanbook);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
}
