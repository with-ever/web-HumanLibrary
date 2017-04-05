package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.domain.contract.ContractSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by youngjinkim on 2017. 3. 6..
 */
@Mapper
public interface ContractMapper {

    int insertContract(Contract contract);

    Contract selectContract(Long contractId);

    List<Contract> selectContractsBySearch(ContractSearch search);

    int selectContractsTotalCountBySearch(ContractSearch search);

    int updateContract(Contract contract);

    int deleteContract(Long contractId);

    int updateContractState(@Param("id") Long contractId, @Param("state") String state);

    int selectAcceptedContractBetweenUserAndHumanbook(@Param("userId") Long userId, @Param("humanbookId") Long humanbookId);
}
