package kr.withever.humanlibrary.repo.mapper;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.common.humanbook.ContractState;
import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.domain.contract.ContractSearch;
import kr.withever.humanlibrary.domain.contract.ContractTime;
import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.domain.user.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by youngjinkim on 2017. 3. 6..
 */

@DatabaseSetup(value = {"/dataset/Contract.xml", "/dataset/User.xml", "/dataset/Humanbook.xml"}, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = {"/dataset/Contract.xml", "/dataset/User.xml", "/dataset/Humanbook.xml"}, type = DatabaseOperation.DELETE_ALL)
public class ContractMapperTest extends WitheverDbUnitTestConfig{

    @Autowired
    private ContractMapper contractMapper;
    
    @Test
    public void selectAcceptedContractBetweenUserAndHumanbook() throws Exception{
    	assertEquals(1, this.contractMapper.selectAcceptedContractBetweenUserAndHumanbook(1L, 1L));
    }

    @Test
    public void insertContract() throws Exception {
        Contract contract = new Contract();
        contract.setUser(new User(2L));
        contract.setHumanbook(new Humanbook(2L));
        contract.setState(ContractState.WAITING.name());
        contract.setContractTime(new ContractTime(1L, "20170404", "16"));
        contract.setApplyMsg("apply msg");
        this.contractMapper.insertContract(contract);

        Contract insertedContract = this.contractMapper.selectContract(6L);

        assertEquals(insertedContract.getState(), contract.getState());
        assertEquals(insertedContract.getApplyMsg(), contract.getApplyMsg());
    }

    @Test
    public void selectContract() throws Exception {
        Contract contract = this.contractMapper.selectContract(1L);
        assertEquals(1, (long) contract.getId());
        assertEquals("20170201", contract.getContractTime().getDate());
        assertEquals("12", contract.getContractTime().getTime());
    }

    @Test
    public void selectContractsBySearch() {
        ContractSearch search = new ContractSearch();
        search.setUserId(1L);
        search.setState(Arrays.asList(ContractState.ACCEPT.name(), ContractState.WAITING.name()));
        search.setStartDate("201702");
        search.setEndDate("201703");

        List<Contract> contracts = this.contractMapper.selectContractsBySearch(search);
        assertEquals(1, contracts.size());
    }
    
    @Test
    public void rejectContract(){
    	String rejectMsg = "시간부족";
    	Contract contract = this.contractMapper.selectContract(1L);
    	contract.setRejectMsg(rejectMsg);
    	contract.setContractTime(null);
    	contract.setState(ContractState.REJECT.name());
    	
    	this.contractMapper.updateContract(contract);

    	Contract rejectedContract = this.contractMapper.selectContract(1L);
    	assertEquals(contract.getRejectMsg(),rejectedContract.getRejectMsg());
    	assertEquals(ContractState.REJECT.name(), rejectedContract.getState());
    }

    @Test
    public void selectContractsTotalCountBySearch() {
        ContractSearch search = new ContractSearch();
        search.setHbId(1L);
        int count = this.contractMapper.selectContractsTotalCountBySearch(search);
        assertEquals(4, count);
    }

    @Test
    public void updateContract() throws Exception {
    	String applyMsg = "진로상담";
    	Contract contract = this.contractMapper.selectContract(1L);
    	contract.setApplyMsg(applyMsg);
        contract.setState(ContractState.ACCEPT.name());
        contract.setContractTime(new ContractTime(3L));
        

        this.contractMapper.updateContract(contract);

        Contract updatedContract = this.contractMapper.selectContract(1L);
        assertEquals(contract.getState(), updatedContract.getState());
        assertEquals(contract.getApplyMsg(), updatedContract.getApplyMsg());
        assertEquals(contract.getContractTime().getId(), updatedContract.getContractTime().getId());
    }

    @Test
    public void deleteContract() throws Exception {
        this.contractMapper.deleteContract(1L);

        Contract contract = this.contractMapper.selectContract(1L);
        assertNull(contract);
    }

    @Test
    public void updateContractState() throws Exception {
        Contract contract = this.contractMapper.selectContract(1L);
        this.contractMapper.updateContractState(1L, ContractState.ACCEPT.name());

        Contract updatedContract = this.contractMapper.selectContract(1L);
        assertEquals(updatedContract.getState(), ContractState.ACCEPT.name());
    }

    @Test
    public void selectContractsForNotification() {
        ContractSearch search = new ContractSearch();
        search.setUserId(1L);
        search.setState(Arrays.asList(ContractState.ACCEPT.name(), ContractState.WAITING.name()));
        search.setStartDate("201702");
        search.setEndDate("201703");

        List<Contract> contracts = this.contractMapper.selectContractsForNotification(search);
        assertEquals(2, contracts.size());
    }

    @Test
    public void selectContractsTotalCountForNotification() {
        ContractSearch search = new ContractSearch();
        search.setUserId(1L);
        int count = this.contractMapper.selectContractsTotalCountForNotification(search);
        assertEquals(3, count);
    }

}