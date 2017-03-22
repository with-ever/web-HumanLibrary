package kr.withever.humanlibrary.repo;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.domain.contract.ContractTime;
import kr.withever.humanlibrary.exception.HumanLibraryRuntimeException;
import kr.withever.humanlibrary.repo.mapper.ContractTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by youngjinkim on 2017. 3. 21..
 */
@Repository
public class ContractTimeRepository {

    @Autowired
    private ContractTimeMapper contractTimeMapper;

    public Long createContractTime(ContractTime contractTime) {
        this.contractTimeMapper.insertContractTime(contractTime);
        return contractTime.getId();
    }

    public ContractTime retrieveContractTime(Long contractTimeId) {
        return this.contractTimeMapper.selectContractTime(contractTimeId);
    }

    public List<ContractTime> retrieveContractTimes(Long contractId) {
        return this.contractTimeMapper.selectContractTimes(contractId);
    }

    public void modifyContractTime(ContractTime contractTime) {
        try {
            this.contractTimeMapper.updateContractTime(contractTime);
        } catch (Exception e) {
            throw new HumanLibraryRuntimeException(e, ExceptionType.CTT_500_001);
        }

    }

    public void removeContractTime(Long contractId) {
        try {
            this.contractTimeMapper.deleteContractTime(contractId);
        } catch (Exception e) {
            throw new HumanLibraryRuntimeException(e, ExceptionType.CTT_500_002);
        }
    }
}
