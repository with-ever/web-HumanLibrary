package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.contract.Contract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by youngjinkim on 2017. 3. 6..
 */
@Mapper
public interface ContractMapper {

    int insertContract(Contract contract);

    Contract selectContract(Long contractId);

    int updateContract(Contract contract);

    int deleteContract(Long contractId);

    int updateContractState(@Param("id") Long contractId, @Param("state") String state);

}
