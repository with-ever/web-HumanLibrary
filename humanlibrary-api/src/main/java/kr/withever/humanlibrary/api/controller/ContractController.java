package kr.withever.humanlibrary.api.controller;

import jdk.nashorn.internal.ir.RuntimeNode;
import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.service.ContractService;
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
    public Long createContract(
            @RequestBody Contract contract
    ) {
        return this.contractService.createContract(contract);
    }

    @RequestMapping(value = "/{contractId}", method = RequestMethod.GET)
    public Contract retrieveContract(@PathVariable(value = "contractId") Long contractId) {
        return this.contractService.retrieveContract(contractId);
    }

    @RequestMapping(value = "/{contractId}", method = RequestMethod.PUT)
    public void modifyContract(
            @PathVariable(value = "contractId") Long contractId,
            @RequestBody Contract contract
    ) {
        this.contractService.modifyContract(contract);
    }

    @RequestMapping(value = "/{contractId}", method = RequestMethod.DELETE)
    public void removeContract(
            @PathVariable(value = "contractId") Long contractId
    ) {
        this.contractService.removeContract(contractId);
    }
}
