package kr.withever.humanlibrary.repo;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.common.humanbook.HumanbookState;
import kr.withever.humanlibrary.domain.humanbook.Category;
import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.domain.humanbook.HumanbookSearch;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import kr.withever.humanlibrary.repo.mapper.CategoryMapper;
import kr.withever.humanlibrary.repo.mapper.HumanbookMapper;
import kr.withever.humanlibrary.repo.mapper.HumanbookServiceDayMapper;

@Repository
public class HumanbookRepository {
	
	@Autowired
	private HumanbookMapper humanbookMapper;
	@Autowired
	private HumanbookServiceDayMapper humanbookServiceDayMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	
	/* 휴먼북 추가 */
	public Long createHumanbook(Humanbook humanbook){
		this.humanbookMapper.insertHumanbook(humanbook);
		Set<String> availableServiceDay = humanbook.getServiceDay();
		Long humanbookId = humanbook.getId();
		if (availableServiceDay != null) {
			for (String serviceDay : availableServiceDay) { //서비스 데이 DB 등
				humanbookServiceDayMapper.insertHumanbookServiceDay(humanbookId, serviceDay);
			}
		}
		return humanbook.getId();
	}
	
	/* id로 휴먼북 한명 얻기 */
	public Humanbook retrieveHumanbook(Long id){ 
		Humanbook humanbook = this.humanbookMapper.selectHumanbook(id);
		if(humanbook != null){  //휴먼북의 서비스 데이, 카테고리, 서브 카테고리 추가부분
			setServiceDaysAndCategoriesInHumanbook(humanbook);
		}
		return humanbook;
	}
	
	/* search로 휴먼북 리스트 얻기 */
	public HumanbookSearch retrieveHumanbooksBySearch(HumanbookSearch search){
		List<Humanbook> humanbooks = this.humanbookMapper.selectHumanbooksBySearch(search);
		search.setResults(humanbooks);
		if(humanbooks.size() != 0){
			int totalCount = this.humanbookMapper.selectHumanbooksTotalCountBySearch(search);
			search.setTotalCount(totalCount);
			Humanbook currentHumanbook;
			for (int i = 0; i < humanbooks.size(); i++) { //return된 휴먼북 리스트에 서비스데이, (서브)카테고리 세팅
				currentHumanbook = humanbooks.get(i);
				setServiceDaysAndCategoriesInHumanbook(currentHumanbook);
			}
		}
		return search;
	}
	
	/* 카테고리에 해당하는 휴먼북 리스트 얻기 */
	public HumanbookSearch retrieveHumanbooksByCategory(HumanbookSearch search){
		Category searchCategory = this.categoryMapper.selectCategory(search.getCategoryId());
		if(searchCategory.getParentCategoryId() != null){ //검색조건의 카테고리가 서브카테고리 categorySearch객체의 (sub)categoryId 세팅
			search.setCategoryId(null);
			search.setSubCategoryId(searchCategory.getId());
		}
		
		List<Humanbook> humanbooks = this.humanbookMapper.selectHumanbooksBySearch(search);
		search.setResults(humanbooks);
		if(humanbooks.size() != 0){
			int totalCount = this.humanbookMapper.selectHumanbooksTotalCountBySearch(search);
			search.setTotalCount(totalCount);
			
			Humanbook currentHumanbook;
			for (int i = 0; i < humanbooks.size(); i++) { //return된 휴먼북 리스트에 서비스데이, (서브)카테고리 세팅
				currentHumanbook = humanbooks.get(i);
				setServiceDaysAndCategoriesInHumanbook(currentHumanbook);
			}
		}
		return search;
	}
	
	/* 휴먼북 수정 */
	public void modifyHumanbook(Humanbook humanbook){
		try {
			Set<String> availableServiceDay = humanbook.getServiceDay();
			Long humanbookId = humanbook.getId();
			this.humanbookServiceDayMapper.deleteHumanbookServiceDay(humanbookId, null);
			if (availableServiceDay != null) {
				for (String serviceDay : availableServiceDay) { //서비스 데이 DB 등
					this.humanbookServiceDayMapper.insertHumanbookServiceDay(humanbookId, serviceDay);
				}
			}
			this.humanbookMapper.updateHumanbook(humanbook);
		} catch (Exception e) {
			throw new HumanLibraryException(e, ExceptionType.HB_500_001);
		}
	}

	/* 휴먼북 상태 변경 */
	public void modifyHumanbookState(Long id, HumanbookState state){
		try {
			this.humanbookMapper.updateHumanbookState(id, state);
		} catch (Exception e) {
			// @TODO exception 코드 정리 필요.
			throw new HumanLibraryException(e, ExceptionType.HB_500_003);
		}
	}
	
	public void removeHumanbook(Long id){
		try{
			this.humanbookServiceDayMapper.deleteHumanbookServiceDay(id, null);
			this.humanbookMapper.deleteHumanbook(id);
		}catch(Exception e){
			// @TODO exception 코드 정리 필요.
			throw new HumanLibraryException(e, ExceptionType.HB_500_002);
		}
	}

	// @TODO 성능 이슈. refactoring.
	private void setServiceDaysAndCategoriesInHumanbook(Humanbook humanbook){
		Set<String> dayList = this.humanbookServiceDayMapper.selectHumanbookServiceDayList(humanbook.getId());
		humanbook.setServiceDay(dayList);
		
		Category parentCategory = categoryMapper.selectCategory(humanbook.getParentCategory().getId());
		humanbook.setParentCategory(parentCategory);
		
		Category subCategory = categoryMapper.selectCategory(humanbook.getSubCategory().getId());
		humanbook.setSubCategory(subCategory);
	}
}
