package kr.withever.humanlibrary.service.impl;

import kr.withever.humanlibrary.domain.common.humanbook.ContractState;
import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.domain.contract.ContractTime;
import kr.withever.humanlibrary.repo.ContractRepository;
import kr.withever.humanlibrary.repo.ContractTimeRepository;
import kr.withever.humanlibrary.repo.HumanbookRepository;
import kr.withever.humanlibrary.repo.UserRepository;
import kr.withever.humanlibrary.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        contract.setState(ContractState.WAITING.name());
        Long contractId = this.contractRepository.createContract(contract);
        List<ContractTime> availableContractTimes = contract.getAvailableContractTimes();
        for (ContractTime contractTime : availableContractTimes) {
            contractTime.setContractId(contractId);
            this.contractTimeRepository.createContractTime(contractTime);
        }
        return contractId;
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
        Contract previousContract = this.contractRepository.retrieveContract(contract.getId());
        previousContract.setUpdatedContract(contract);
        this.contractRepository.modifyContract(contract);
    }

    @Override
    public void removeContract(Long contractId) {
        this.contractRepository.removeContract(contractId);
    }

    @Override
    public void acceptContract(Long contractId) {
        this.contractRepository.modifyContractState(contractId, ContractState.ACCEPT.name());
    }

    @Override
    public void rejectContract(Long contractId) {
        this.contractRepository.modifyContractState(contractId, ContractState.REJECT.name());
    }
}
