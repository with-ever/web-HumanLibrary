package kr.withever.humanlibrary.domain.contract;

import kr.withever.humanlibrary.domain.common.humanbook.ContractState;
import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.domain.user.User;

import java.util.List;

/**
 * Created by youngjinkim on 2017. 3. 6..
 */
public class Contract {

    private Long id;

    private User user;

    private Humanbook humanbook;

    private String state;

    private ContractTime contractTime;

    private List<ContractTime> availableContractTimes;

    private Long createTime;

    private Long updateTime;

    public Contract() {
        this.createTime = System.currentTimeMillis() / 1000;
        this.updateTime = System.currentTimeMillis() / 1000;
    }

    public Contract(Long contractId) {
        this.id = contractId;
        this.createTime = System.currentTimeMillis() / 1000;
        this.updateTime = System.currentTimeMillis() / 1000;
    }

    public Contract(User user, Humanbook humanbook, String state, Long createTime, Long updateTime) {
        this.user = user;
        this.humanbook = humanbook;
        this.state = state;
        this.createTime = System.currentTimeMillis() / 1000;
        this.updateTime = System.currentTimeMillis() / 1000;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Humanbook getHumanbook() {
        return humanbook;
    }

    public void setHumanbook(Humanbook humanbook) {
        this.humanbook = humanbook;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ContractTime getContractTime() {
        return contractTime;
    }

    public void setContractTime(ContractTime contractTime) {
        this.contractTime = contractTime;
    }

    public List<ContractTime> getAvailableContractTimes() {
        return availableContractTimes;
    }

    public void setAvailableContractTimes(List<ContractTime> availableContractTimes) {
        this.availableContractTimes = availableContractTimes;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public void setUpdatedContract(Contract contract) {
        this.state = contract.getState();
        this.contractTime = contract.getContractTime();
        this.updateTime = System.currentTimeMillis();
    }
}