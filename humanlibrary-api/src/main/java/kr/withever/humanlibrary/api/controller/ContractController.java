package kr.withever.humanlibrary.api.controller;

import java.util.Map;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.domain.contract.ContractSearch;
import kr.withever.humanlibrary.service.ContractService;
import kr.withever.humanlibrary.util.HumanLibraryResponse;

/**
 * Created by youngjinkim on 2017. 3. 6..
 */

@RestController
@RequestMapping(value = "/api/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @RequestMapping(method = RequestMethod.POST)
    public HumanLibraryResponse createContract(
            @RequestBody Contract contract
    ) {
        return new HumanLibraryResponse(this.contractService.createContract(contract));
    }

    @RequestMapping(value = "/{contractId}", method = RequestMethod.GET)
    public Contract retrieveContract(@PathVariable(value = "contractId") Long contractId) {
        return this.contractService.retrieveContract(contractId);
    }


    @RequestMapping(method = RequestMethod.GET)
    public ContractSearch retrieveContractList(
            ContractSearch search
    ) {
        return this.contractService.retrieveContractBySearch(search);
    }

    @RequestMapping(value = "/{contractId}", method = RequestMethod.PUT)
    public void modifyContract(
            @PathVariable(value = "contractId") Long contractId,
            @RequestBody Contract contract
    ) {
        if (contract.getId() == null) contract.setId(contractId);
        this.contractService.modifyContract(contract);
    }

    @RequestMapping(value = "/{contractId}", method = RequestMethod.DELETE)
    public void removeContract(
            @PathVariable(value = "contractId") Long contractId
    ) {
        this.contractService.removeContract(contractId);
    }

    @RequestMapping(value = "/{contractId}/accept/{contractTimeId}", method = RequestMethod.PUT)
    public HumanLibraryResponse acceptContract(
            @PathVariable(value = "contractId") Long contractId,
            @PathVariable(value = "contractTimeId") Long contractTimeId
    ) {
        this.contractService.acceptContract(contractId, contractTimeId);
        return HumanLibraryResponse.successMessage();
    }

    @RequestMapping(value = "/{contractId}/reject", method = RequestMethod.PUT)
    public HumanLibraryResponse rejectContract(
            @PathVariable(value = "contractId") Long contractId
            ,@ApiParam(name = "rejectMsg", value = "reject message", required = true) @RequestBody Map<String, Object> requestMap
    ) {
    	String rejectMsg = (String) requestMap.get("rejectMsg");
        this.contractService.rejectContract(contractId, rejectMsg);
        return HumanLibraryResponse.successMessage();
    }

    @RequestMapping(value = "/{userId}/{humanbookId}", method = RequestMethod.GET)
    public HumanLibraryResponse isExistContractBetweenUserAndHumanbook(
    		@PathVariable(value = "userId") Long userId,
    		@PathVariable(value = "humanbookId") Long humanbookId
    		){
    	//Accept된 계약이 없으면 0이 return, 있으면 1 return
    	return new HumanLibraryResponse(this.contractService.isExistAcceptedContractBetweenUserAndHumanbook(userId, humanbookId));
    }
}
