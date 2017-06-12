package kr.withever.humanlibrary.service.impl;

import java.util.List;

import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.domain.humanbook.HumanbookSearch;
import kr.withever.humanlibrary.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.withever.humanlibrary.domain.common.humanbook.ContractState;
import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.domain.contract.ContractSearch;
import kr.withever.humanlibrary.domain.contract.ContractTime;
import kr.withever.humanlibrary.repo.ContractRepository;
import kr.withever.humanlibrary.repo.ContractTimeRepository;
import kr.withever.humanlibrary.repo.HumanbookRepository;
import kr.withever.humanlibrary.repo.UserRepository;
import kr.withever.humanlibrary.service.ContractService;

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
        contract.setUser(User.decryptUser(this.userRepository.retrieveUser(contract.getUser().getUserId())));
        contract.setHumanbook(this.humanbookRepository.retrieveHumanbook(contract.getHumanbook().getId()));
        contract.setAvailableContractTimes(this.contractTimeRepository.retrieveContractTimes(contractId));
        if (contract.getHumanbook().getUser() != null) contract.getHumanbook().setUser(User.decryptUser(this.userRepository.retrieveUser(contract.getHumanbook().getUser().getUserId())));
        return contract;
    }

    @Override
    public ContractSearch retrieveContractBySearch(ContractSearch search) {
        return decryptContractUser(this.contractRepository.retrieveContractBySearch(search));
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
    public void acceptContract(Long contractId, Long contractTimeId) {
        Contract updatedContract = new Contract();
        // @TODO not found contract time 처리.
        updatedContract.setContractTime(this.contractTimeRepository.retrieveContractTime(contractTimeId));
        updatedContract.setState(ContractState.ACCEPT.name());

        Contract previousContract = this.contractRepository.retrieveContract(contractId);
        previousContract.setUpdatedContract(updatedContract);

        this.contractRepository.modifyContract(previousContract);
        // @TODO 푸쉬 메시지 보내기
    }

    @Override
    public void rejectContract(Long contractId, String rejectMsg) {
        // @TODO 푸쉬 메시지 보내기
        Contract updatedContract = new Contract();
        updatedContract.setContractTime(null);
        updatedContract.setState(ContractState.REJECT.name());

        Contract previousContract = this.contractRepository.retrieveContract(contractId);
        previousContract.setUpdatedContract(updatedContract);
        previousContract.setRejectMsg(rejectMsg);

        this.contractRepository.modifyContract(previousContract);
    }

	@Override
	public int isExistAcceptedContractBetweenUserAndHumanbook(Long userId, Long humanbookId) {
		return this.contractRepository.isExistAcceptedContractBetweenUserAndHumanbook(userId, humanbookId);
	}

	@Override
    public ContractSearch retrieveContractsForNotification(ContractSearch search) {
        return decryptContractUser(this.contractRepository.retrieveContractsForNotification(search));
    }

    private ContractSearch decryptContractUser(ContractSearch search) {
        List<Contract> contracts = search.getResults();
        // 사용자 복호화.
        for (int index = 0; index < contracts.size(); index++) {
            Contract currentContract = contracts.get(index);
            if (currentContract.getUser() != null) currentContract.setUser(User.decryptUser(currentContract.getUser()));
            if (currentContract.getHumanbook() != null && currentContract.getHumanbook().getUser() != null) currentContract.getHumanbook().setUser(User.decryptUser(currentContract.getHumanbook().getUser()));
        }
        search.setResults(contracts);
        return search;
    }
}
