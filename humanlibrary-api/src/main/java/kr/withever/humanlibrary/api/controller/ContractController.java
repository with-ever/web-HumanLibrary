package kr.withever.humanlibrary.api.controller;

import io.swagger.annotations.ApiParam;
import kr.withever.humanlibrary.domain.common.client.FCMData;
import kr.withever.humanlibrary.domain.common.client.FCMInfo;
import kr.withever.humanlibrary.domain.common.client.FCMNotification;
import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.domain.contract.ContractSearch;
import kr.withever.humanlibrary.service.ContractService;
import kr.withever.humanlibrary.service.FCMInfoService;
import kr.withever.humanlibrary.util.FCMUtil;
import kr.withever.humanlibrary.util.HumanLibraryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

/**
 * Created by youngjinkim on 2017. 3. 6..
 */

@RestController
@RequestMapping(value = "/api/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private FCMInfoService fcmInfoService;

    @RequestMapping(method = RequestMethod.POST)
    public HumanLibraryResponse createContract(
            @RequestBody Contract contract
    ) throws IOException {
        Long contractId = this.contractService.createContract(contract);
        // 구독자가 구독 신청을 한 경우 휴먼북에게 푸시메시지 보내기.
        Contract createdContract = this.contractService.retrieveContract(contractId);
        FCMInfo fcmInfo = fcmInfoService.retrieveFCMInfoByUserId(createdContract.getHumanbook().getUser().getUserId());
        FCMUtil.sendMessage(fcmInfo.getToken(), FCMNotification.requestHumanbook(createdContract.getUser().getName()), FCMData.contract(String.valueOf(contractId)));
        return new HumanLibraryResponse(contractId);
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
    public HumanLibraryResponse modifyContract(
            @PathVariable(value = "contractId") Long contractId,
            @RequestBody Contract contract
    ) {
        if (contract.getId() == null) contract.setId(contractId);
        this.contractService.modifyContract(contract);
        return HumanLibraryResponse.successMessage();
    }

    @RequestMapping(value = "/{contractId}", method = RequestMethod.DELETE)
    public HumanLibraryResponse removeContract(
            @PathVariable(value = "contractId") Long contractId
    ) {
        this.contractService.removeContract(contractId);
        return HumanLibraryResponse.successMessage();
    }

    @RequestMapping(value = "/{contractId}/accept/{contractTimeId}", method = RequestMethod.PUT)
    public HumanLibraryResponse acceptContract(
            @PathVariable(value = "contractId") Long contractId,
            @PathVariable(value = "contractTimeId") Long contractTimeId
    ) throws IOException {
        this.contractService.acceptContract(contractId, contractTimeId);
        // 휴먼북이 구독 신청 수락을 한 경우 구독자에게 푸시메시지 보내기.
        Contract contract = this.contractService.retrieveContract(contractId);
        FCMInfo fcmInfo = fcmInfoService.retrieveFCMInfoByUserId(contract.getUser().getUserId());
        FCMUtil.sendMessage(fcmInfo.getToken(), FCMNotification.acceptHumanbook(contract.getHumanbook().getUser().getName()), FCMData.contract(String.valueOf(contractId)));
        return HumanLibraryResponse.successMessage();
    }

    @RequestMapping(value = "/{contractId}/reject", method = RequestMethod.PUT)
    public HumanLibraryResponse rejectContract(
            @PathVariable(value = "contractId") Long contractId
            ,@ApiParam(name = "rejectMsg", value = "reject message", required = true) @RequestBody Map<String, Object> requestMap
    ) throws IOException {
    	String rejectMsg = (String) requestMap.get("rejectMsg");
        this.contractService.rejectContract(contractId, rejectMsg);
        // 휴먼북이 구독 신청 거절을 한 경우 구독자에게 푸시메시지 보내기.
        Contract contract = this.contractService.retrieveContract(contractId);
        FCMInfo fcmInfo = fcmInfoService.retrieveFCMInfoByUserId(contract.getUser().getUserId());
        FCMUtil.sendMessage(fcmInfo.getToken(), FCMNotification.rejectHumanbook(contract.getHumanbook().getUser().getName()), FCMData.contract(String.valueOf(contractId)));
        return HumanLibraryResponse.successMessage();
    }

    @RequestMapping(value = "/{userId}/{humanbookId}", method = RequestMethod.GET)
    public HumanLibraryResponse isExistContractBetweenUserAndHumanbook(
    		@PathVariable(value = "userId") Long userId,
    		@PathVariable(value = "humanbookId") Long humanbookId
    		){
    	//Accept된 계약이 없으면 0이 return, 있으면 1 return
        int isExisted = this.contractService.isExistAcceptedContractBetweenUserAndHumanbook(userId, humanbookId);
        return isExisted > 0 ? HumanLibraryResponse.isExisted() : HumanLibraryResponse.isNotExisted();
    }

    @RequestMapping(value = "/notification/{userId}", method = RequestMethod.GET)
    public ContractSearch retrieveContractsForNotification(
            @PathVariable(value = "userId") Long userId,
            ContractSearch search

    ) {
        return this.contractService.retrieveContractsForNotification(search);
    }

}
