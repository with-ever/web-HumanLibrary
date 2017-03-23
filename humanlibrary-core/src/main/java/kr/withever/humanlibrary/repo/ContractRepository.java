package kr.withever.humanlibrary.repo;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.exception.HumanLibraryRuntimeException;
import kr.withever.humanlibrary.repo.mapper.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by youngjinkim on 2017. 3. 21..
 */
@Repository
public class ContractRepository {

    @Autowired
    private ContractMapper contractMapper;

    public Long createContract(Contract contract) {
        this.contractMapper.insertContract(contract);
        return contract.getId();
    }

    public Contract retrieveContract(Long contractId) {
        Contract contract = this.contractMapper.selectContract(contractId);
        return contract;
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
}
