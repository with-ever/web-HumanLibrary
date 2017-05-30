package kr.withever.humanlibrary.repo;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.domain.contract.ContractSearch;
import kr.withever.humanlibrary.exception.HumanLibraryRuntimeException;
import kr.withever.humanlibrary.repo.mapper.ContractMapper;
import kr.withever.humanlibrary.repo.mapper.ContractTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by youngjinkim on 2017. 3. 21..
 */
@Repository
public class ContractRepository {

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private ContractTimeMapper contractTimeMapper;

    public Long createContract(Contract contract) {
        this.contractMapper.insertContract(contract);
        return contract.getId();
    }

    public Contract retrieveContract(Long contractId) {
        Contract contract = this.contractMapper.selectContract(contractId);
        contract.setAvailableContractTimes(this.contractTimeMapper.selectContractTimes(contractId));
//        if (contract.getContractTime() != null) contract.setContractTime(this.contractTimeMapper.selectContractTime(contract.getContractTime().getId()));
        return contract;
    }

    public ContractSearch retrieveContractBySearch(ContractSearch search) {
        List<Contract> contracts = this.contractMapper.selectContractsBySearch(search);
        search.setResults(contracts);
        if (contracts.size() != 0) {
            int totalCount = this.contractMapper.selectContractsTotalCountBySearch(search);
            search.setTotalCount(totalCount);
        }
        return search;
    }

    public void modifyContract(Contract contract) {
        try {
            this.contractMapper.updateContract(contract);
        } catch (Exception e) {
            throw new HumanLibraryRuntimeException(e, ExceptionType.CT_500_001);
        }

    }

    public void removeContract(Long contractId) {
        try {
            this.contractMapper.deleteContract(contractId);
        } catch (Exception e) {
            throw new HumanLibraryRuntimeException(e, ExceptionType.CT_500_002);
        }
    }

    public void modifyContractState(Long contractId, String state) {
        try {
            this.contractMapper.updateContractState(contractId, state);
        } catch (Exception e) {
            throw new HumanLibraryRuntimeException(e, ExceptionType.US_500_003);
        }
    }
    
    public int isExistAcceptedContractBetweenUserAndHumanbook(Long userId, Long humanbookId){
    	return this.contractMapper.selectAcceptedContractBetweenUserAndHumanbook(userId, humanbookId);
    }

    public ContractSearch retrieveContractsForNotification(ContractSearch search) {
        List<Contract> contracts = this.contractMapper.selectContractsForNotification(search);
        search.setResults(contracts);
        if (contracts.size() != 0) {
            int totalCount = this.contractMapper.selectContractsTotalCountForNotification(search);
            search.setTotalCount(totalCount);
        }
        return search;
    }
}
