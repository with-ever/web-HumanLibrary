package kr.withever.humanlibrary.repo.mapper;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.common.humanbook.ContractState;
import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.domain.contract.ContractTime;
import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.domain.user.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by youngjinkim on 2017. 3. 6..
 */

@DatabaseSetup(value = {"/dataset/Contract.xml"}, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = {"/dataset/Contract.xml"}, type = DatabaseOperation.DELETE_ALL)
public class ContractMapperTest extends WitheverDbUnitTestConfig{

    @Autowired
    private ContractMapper contractMapper;

    @Test
    public void insertContract() throws Exception {
        Contract contract = new Contract();
        contract.setUser(new User(2L));
        contract.setHumanbook(new Humanbook(2L));
        contract.setState(ContractState.WAITING);
        this.contractMapper.insertContract(contract);

        Contract insertedContract = this.contractMapper.selectContract(2L);

        assertEquals(insertedContract.getState(), contract.getState());
    }

    @Test
    public void selectContract() throws Exception {
        Contract contract = this.contractMapper.selectContract(1L);
        assertEquals(1, (long) contract.getId());
    }

    @Test
    public void updateContract() throws Exception {
        Contract contract = this.contractMapper.selectContract(1L);
        contract.setState(ContractState.ACCEPT);
        contract.setContractTime(new ContractTime(3L));

        this.contractMapper.updateContract(contract);

        Contract updatedContract = this.contractMapper.selectContract(1L);
        assertEquals(contract.getState(), updatedContract.getState());
        assertEquals(contract.getContractTime().getId(), updatedContract.getContractTime().getId());
    }

    @Test
    public void deleteContract() throws Exception {
        this.contractMapper.deleteContract(1L);

        Contract contract = this.contractMapper.selectContract(1L);
        assertNull(contract);
    }

}