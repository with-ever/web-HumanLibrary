package kr.withever.humanlibrary.api.controller;

import kr.withever.humanlibrary.domain.contract.Contract;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youngjinkim on 2017. 3. 6..
 */

@RestController
@RequestMapping(value = "/api/contracts")
public class ContractController {

    @RequestMapping(value = "/{contractId}", method = RequestMethod.GET)
    public Contract retrieveHumanbook(@PathVariable(value = "contractId") Long contractId) {
        Contract contract = new Contract();
        return contract;
    }
}
