package kr.withever.humanlibrary.repo.mapper;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.contract.ContractTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by youngjinkim on 2017. 3. 6..
 */
@DatabaseSetup(value = {"/dataset/ContractTime.xml"}, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = {"/dataset/ContractTime.xml"}, type = DatabaseOperation.DELETE_ALL)
public class ContractTimeMapperTest extends WitheverDbUnitTestConfig{

    @Autowired
    private ContractTimeMapper contractTimeMapper;

    @Test
    public void insertContractTime() throws Exception {
        ContractTime contractTime = new ContractTime(2L, "20170306", "12");
        this.contractTimeMapper.insertContractTime(contractTime);

        ContractTime insertedContractTime = this.contractTimeMapper.selectContractTime(2L);
        assertEquals(contractTime.getDate(), insertedContractTime.getDate());
    }

    @Test
    public void selectContractTime() throws Exception {
        ContractTime contractTime = this.contractTimeMapper.selectContractTime(1L);
        assertEquals(1L, (long) contractTime.getId());
        assertEquals("20170306", contractTime.getDate());
        assertEquals("17", contractTime.getTime());
    }

    @Test
    public void selectContractTimes() throws Exception {
        List<ContractTime> contractTimes = this.contractTimeMapper.selectContractTimes(1L);
        assertEquals(3, contractTimes.size());
    }

    @Test
    public void updateContractTime() throws Exception {
        ContractTime contractTime = this.contractTimeMapper.selectContractTime(1L);
        contractTime.setDate("20170307");
        contractTime.setTime("13");

        this.contractTimeMapper.updateContractTime(contractTime);

        ContractTime updatedContractTime = this.contractTimeMapper.selectContractTime(1L);
        assertEquals(contractTime.getDate(), updatedContractTime.getDate());
        assertEquals(contractTime.getTime(), updatedContractTime.getTime());

    }

    @Test
    public void deleteContractTime() throws Exception {
        this.contractTimeMapper.deleteContractTime(1L);
        ContractTime contractTime = this.contractTimeMapper.selectContractTime(1L);
        assertNull(contractTime);
    }

}