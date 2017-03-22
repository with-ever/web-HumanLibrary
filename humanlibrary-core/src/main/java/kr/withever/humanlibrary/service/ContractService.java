package kr.withever.humanlibrary.service;

import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.domain.user.User;

/**
 * Created by youngjinkim on 2017. 3. 21..
 */
public interface ContractService {

    Long createContract(Contract contract);

    Contract retrieveContract(Long contractId);

    void modifyContract(Contract contract);

    void removeContract(Long contractId);

}
