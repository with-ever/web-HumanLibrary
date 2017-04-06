package kr.withever.humanlibrary.api.controller;

import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.domain.contract.ContractSearch;
import kr.withever.humanlibrary.domain.user.UserSearch;
import kr.withever.humanlibrary.service.ContractService;
import kr.withever.humanlibrary.util.HumanLibraryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void acceptContract(
            @PathVariable(value = "contractId") Long contractId,
            @PathVariable(value = "contractTimeId") Long contractTimeId
    ) {
        this.contractService.acceptContract(contractId, contractTimeId);
    }

    @RequestMapping(value = "/{contractId}/reject", method = RequestMethod.PUT)
    public void rejectContract(
            @PathVariable(value = "contractId") Long contractId
    ) {
        this.contractService.rejectContract(contractId);
    }
    
    @RequestMapping(value = "/{userId}/{humanbookId}", method = RequestMethod.GET)
    public int isExistContractBetweenUserAndHumanbook(
    		@PathVariable(value = "userId") Long userId,
    		@PathVariable(value = "humanbookId") Long humanbookId
    		){
    	//Accept된 계약이 없으면 0이 return, 있으면 1 return
    	return this.contractService.isExistAcceptedContractBetweenUserAndHumanbook(userId, humanbookId);
    }
}
