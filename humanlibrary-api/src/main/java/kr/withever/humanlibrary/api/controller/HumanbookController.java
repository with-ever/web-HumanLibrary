package kr.withever.humanlibrary.api.controller;

import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.domain.humanbook.HumanbookSearch;
import kr.withever.humanlibrary.service.HumanbookService;
import kr.withever.humanlibrary.util.HumanLibraryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * Created by youngjinkim on 2017. 3. 6..
 */

@RestController
@RequestMapping(value = "/api/humanbooks")
public class HumanbookController {
	
	@Autowired
	private HumanbookService humanbookService;
	
	@RequestMapping(method = RequestMethod.POST)
	public HumanLibraryResponse createHumanbook(
			@RequestBody Humanbook humanbook
			){
		return new HumanLibraryResponse(this.humanbookService.createHumanbook(humanbook));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public HumanbookSearch retrieveAllHumanbooks(
			HumanbookSearch search
			){
		//  userId로 휴먼북 검색에는 이 api에 쿼리스트링 사용
		//  api/humanbooks?userId=seung1107
		//  카테고리고 휴먼북리스트 검색을 병합한다면? --> api/humanbooks?categoryId=123 
		return this.humanbookService.retrieveHumanbooksBySearch(search);
	}
	
	@RequestMapping(value = "/{hbId}", method = RequestMethod.GET)
	public Humanbook retrieveHumanbook(
			@PathVariable(value = "hbId") Long hbId
	) {
		Humanbook humanbook = new Humanbook();
		humanbook = this.humanbookService.retrieveHumanbook(hbId);
		return humanbook;
	}
    
	@RequestMapping(value= "/category/{categoryId}", method = RequestMethod.GET)
	public HumanbookSearch retrieveHumanbooksByCategory(
			@PathVariable(value = "categoryId") Long categoryId 
			,HumanbookSearch search
	){
		search.setCategoryId(categoryId);
		return this.humanbookService.retrieveHumanbooksByCategory(search);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public HumanLibraryResponse modifyHumanbook(
			@RequestBody Humanbook humanbook
	){
		this.humanbookService.modifyHumanbook(humanbook);
		return HumanLibraryResponse.successMessage();
	}
    
    @RequestMapping(value = "/{hbId}/reject", method = RequestMethod.PUT)
    public HumanLibraryResponse rejectHumanbook(
    		@PathVariable(value = "hbId") Long hbId
    ){
    	this.humanbookService.rejectHumanbookRegister(hbId);
    	return HumanLibraryResponse.successMessage();
    }
    
    @RequestMapping(value = "/{hbId}/accept", method = RequestMethod.PUT)
    public HumanLibraryResponse acceptHumanbook(
    		@PathVariable(value = "hbId") Long hbId
    ){
    	this.humanbookService.acceptHumanbookRegister(hbId);
    	return HumanLibraryResponse.successMessage();
    }
    
    @RequestMapping(value = "/{hbId}", method = RequestMethod.DELETE)
    public HumanLibraryResponse removeHumanbook(
    		@PathVariable(value = "hbId") Long hbId
    ){
		this.humanbookService.cancelHumanbook(hbId);
    	return HumanLibraryResponse.successMessage();
    }
  
}
