package kr.withever.humanlibrary.service.impl;

import kr.withever.humanlibrary.domain.common.humanbook.ContractState;
import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.domain.contract.ContractSearch;
import kr.withever.humanlibrary.domain.contract.ContractTime;
import kr.withever.humanlibrary.repo.ContractRepository;
import kr.withever.humanlibrary.repo.ContractTimeRepository;
import kr.withever.humanlibrary.repo.HumanbookRepository;
import kr.withever.humanlibrary.repo.UserRepository;
import kr.withever.humanlibrary.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public ContractSearch retrieveContractBySearch(ContractSearch search) {
        // endDate 값 없을 경우 기본 한달까지
        // startdate 1보다 작으면 기본 1
        // enddate 12보다 크면 기본 12
//        if (search.getStartDate() != null && search.getEndDate() == null) {
//            String startDate = search.getStartDate();
//            String year = startDate.substring(0, 4);
//            String startMonth = startDate.substring(4);
//            int month = Integer.parseInt(startMonth) + 1;
//            String endMonth = month < 10 ? String.format("%02d", month) : String.valueOf(month);
//            search.setEndDate(year + endMonth);
//        }
        return this.contractRepository.retrieveContractBySearch(search);
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
    public void rejectContract(Long contractId) {
        // @TODO 푸쉬 메시지 보내기
        Contract updatedContract = new Contract();
        updatedContract.setContractTime(null);
        updatedContract.setState(ContractState.REJECT.name());

        Contract previousContract = this.contractRepository.retrieveContract(contractId);
        previousContract.setUpdatedContract(updatedContract);

        this.contractRepository.modifyContract(previousContract);
    }
}
