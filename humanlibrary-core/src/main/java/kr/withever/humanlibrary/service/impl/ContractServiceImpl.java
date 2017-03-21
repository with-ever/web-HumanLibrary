package kr.withever.humanlibrary.service.impl;

import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.repo.ContractRepository;
import kr.withever.humanlibrary.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by youngjinkim on 2017. 3. 21..
 */
@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Long createContract(Contract contract) {

        return this.contractRepository.createContract(contract);
    }

    @Override
    public Contract retrieveContract(Long contractId) {
        return this.contractRepository.retrieveContract(contractId);
    }

    @Override
    public void modifyContract(Contract contract) {
        this.contractRepository.modifyContract(contract);
    }

    @Override
    public void removeContract(Long contractId) {
        this.contractRepository.removeContract(contractId);
    }
}
