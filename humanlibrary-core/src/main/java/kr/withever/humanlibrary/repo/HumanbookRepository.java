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
import kr.withever.humanlibrary.domain.humanbook.SubCategory;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import kr.withever.humanlibrary.repo.mapper.CategoryMapper;
import kr.withever.humanlibrary.repo.mapper.HumanbookMapper;
import kr.withever.humanlibrary.repo.mapper.HumanbookServiceDayMapper;
import kr.withever.humanlibrary.repo.mapper.SubCategoryMapper;

@Repository
public class HumanbookRepository {
	
	@Autowired
	private HumanbookMapper humanbookMapper;
	@Autowired
	private HumanbookServiceDayMapper humanbookServiceDayMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private SubCategoryMapper subCategoryMapper;

	
	public Long createHumanbook(Humanbook humanbook){
		this.humanbookMapper.insertHumanbook(humanbook);
		return humanbook.getId();
	}
	
	public Humanbook retrieveHumanbook(Long id){
		Humanbook humanbook = this.humanbookMapper.selectHumanbook(id);
		if(humanbook != null){
			Set<String> dayList = this.humanbookServiceDayMapper.selectHumanbookServiceDayList(id);
			humanbook.setServiceDay(dayList);
			
			Category parentCategory = categoryMapper.selectCategory(humanbook.getParentCategory().getId());
			humanbook.setParentCategory(parentCategory);
			
			SubCategory subCategory = subCategoryMapper.selectSubCategory(humanbook.getSubCategory().getId());
			humanbook.setSubCategory(subCategory);
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
	
	public HumanbookSearch retrieveHumanbooksBySearch(HumanbookSearch search){
		List<Humanbook> humanbooks = this.humanbookMapper.selectHumanbooksBySearch(search);
		search.setResults(humanbooks);
		if(humanbooks.size() != 0){
			int totalCount = this.humanbookMapper.selectHumanbooksTotalCountBySearch(search);
			search.setTotalCount(totalCount);
		}
		return search;
	}
	
	public HumanbookSearch retrieveHumanbooksByCategory(HumanbookSearch search){
		List<Humanbook> humanbooks = this.humanbookMapper.selectHumanbooksByCategory(search);
		search.setResults(humanbooks);
		if(humanbooks.size() != 0){
			int totalCount = this.humanbookMapper.selectHumanbooksTotalCountBySearch(search);
			search.setTotalCount(totalCount);
			
			Long currentHumanbookId; 
			Humanbook currentHumanbook;
			for (int i = 0; i < humanbooks.size(); i++) {
				currentHumanbook = humanbooks.get(i);
				currentHumanbookId = currentHumanbook.getId();
				Set<String> dayList = this.humanbookServiceDayMapper.selectHumanbookServiceDayList(currentHumanbookId);
				currentHumanbook.setServiceDay(dayList);
				
				Category parentCategory = categoryMapper.selectCategory(currentHumanbook.getParentCategory().getId());
				currentHumanbook.setParentCategory(parentCategory);
				
				SubCategory subCategory = subCategoryMapper.selectSubCategory(currentHumanbook.getSubCategory().getId());
				currentHumanbook.setSubCategory(subCategory);
			}
		}
		return search;
	}
	
	public HumanbookSearch retrieveHumanbooksByCategoryBySubCategory(HumanbookSearch search){
		List<Humanbook> humanbooks = this.humanbookMapper.selectHumanbooksBySubCategory(search);
		search.setResults(humanbooks);
		if(humanbooks.size() != 0){
			int totalCount = this.humanbookMapper.selectHumanbooksTotalCountBySearch(search);
			search.setTotalCount(totalCount);
			
			Long currentHumanbookId; 
			Humanbook currentHumanbook = null;
			for (int i = 0; i < humanbooks.size(); i++) {
				currentHumanbook = humanbooks.get(i);
				currentHumanbookId = currentHumanbook.getId();
				Set<String> dayList = this.humanbookServiceDayMapper.selectHumanbookServiceDayList(currentHumanbookId);
				currentHumanbook.setServiceDay(dayList);
				
				Category parentCategory = categoryMapper.selectCategory(currentHumanbook.getParentCategory().getId());
				currentHumanbook.setParentCategory(parentCategory);
				
				SubCategory subCategory = subCategoryMapper.selectSubCategory(currentHumanbook.getSubCategory().getId());
				currentHumanbook.setSubCategory(subCategory);
			}
			search.setParentCategoryId(currentHumanbook.getParentCategory().getId());
		}
		return search;
	}
	
	public void modifyHumanbook(Humanbook humanbook){
		try {
			this.humanbookMapper.updateHumanbook(humanbook);
		} catch (Exception e) {
			throw new HumanLibraryException(e, ExceptionType.HB_500_001);
		}
	}

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
			this.humanbookMapper.deleteHumanbook(id);
		}catch(Exception e){
			// @TODO exception 코드 정리 필요.
			throw new HumanLibraryException(e, ExceptionType.HB_500_002);
		}
	}
}
