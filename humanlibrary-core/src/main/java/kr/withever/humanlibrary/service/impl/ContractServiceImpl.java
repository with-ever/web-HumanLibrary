package kr.withever.humanlibrary.service.impl;

import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.repo.ContractRepository;
import kr.withever.humanlibrary.repo.ContractTimeRepository;
import kr.withever.humanlibrary.repo.HumanbookRepository;
import kr.withever.humanlibrary.repo.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HumanbookRepository humanbookRepository;

    @Autowired
    private ContractTimeRepository contractTimeRepository;

    @Override
    public Long createContract(Contract contract) {
        return this.contractRepository.createContract(contract);
    }

    @Override
    public Contract retrieveContract(Long contractId) {
        Contract contract = this.contractRepository.retrieveContract(contractId);
        contract.setUser(this.userRepository.retrieveUser(contract.getUser().getUserId()));
        contract.setHumanbook(this.humanbookRepository.retrieveHumanbook(contract.getHumanbook().getId()));
        contract.setAvailableContractTimes(this.contractTimeRepository.retrieveContractTimes(contractId));
        return contract;
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
