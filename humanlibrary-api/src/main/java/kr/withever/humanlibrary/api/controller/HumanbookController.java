package kr.withever.humanlibrary.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.domain.humanbook.HumanbookSearch;
import kr.withever.humanlibrary.service.HumanbookService;
import kr.withever.humanlibrary.util.HumanLibraryResponse;
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
	
	@RequestMapping(value= "/subcategory/{subCategoryId}", method = RequestMethod.GET)
	public HumanbookSearch retrieveHumanbooksBySubCategory(
			@PathVariable(value = "subCategoryId") Long subCategoryId 
			,HumanbookSearch search
	){
		search.setSubCategoryId(subCategoryId);
		return this.humanbookService.retrieveHumanbooksBySubCategory(search);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void modifyHumanbook(
			@RequestBody Humanbook humanbook
	){
		this.humanbookService.modifyHumanbook(humanbook);
	}
    
    @RequestMapping(value = "/{hbId}/reject", method = RequestMethod.PUT)
    public void rejectHumanbook(
    		@PathVariable(value = "hbId") Long hbId
    ){
    	this.humanbookService.rejectHumanbookRegister(hbId);
    }
    
    @RequestMapping(value = "/{hbId}/accept", method = RequestMethod.PUT)
    public void acceptHumanbook(
    		@PathVariable(value = "hbId") Long hbId
    ){
    	this.humanbookService.acceptHumanbookRegister(hbId);
    }
    
    @RequestMapping(value = "/{hbId}", method = RequestMethod.DELETE)
    public void removeHumanbook(
    		@PathVariable(value = "hbId") Long hbId
    ){
    	this.humanbookService.removeHumanbook(hbId);
    }
  
}
