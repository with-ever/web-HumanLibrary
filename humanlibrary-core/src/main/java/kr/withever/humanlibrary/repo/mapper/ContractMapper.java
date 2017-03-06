package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.contract.Contract;

/**
 * Created by youngjinkim on 2017. 3. 6..
 */
public interface ContractMapper {

    int insertContract(Contract contract);

    Contract selectContract(Long contractId);

    int updateContract(Contract contract);

    int deleteContract(Long contractId);

}
