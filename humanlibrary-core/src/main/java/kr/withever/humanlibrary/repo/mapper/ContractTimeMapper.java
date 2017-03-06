package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.contract.ContractTime;

import java.util.List;

/**
 * Created by youngjinkim on 2017. 3. 6..
 */
public interface ContractTimeMapper {

    int insertContractTime(ContractTime contractTime);

    ContractTime selectContractTime(Long contractTimeId);

    List<ContractTime> selectContractTimes(Long contractId);

    int updateContractTime(ContractTime contractTime);

    int deleteContractTime(Long contractId);

}
