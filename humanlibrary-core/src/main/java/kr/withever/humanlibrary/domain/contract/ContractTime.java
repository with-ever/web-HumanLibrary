package kr.withever.humanlibrary.domain.contract;

/**
 * Created by youngjinkim on 2017. 3. 6..
 */
public class ContractTime {

    private Long id;

    private Long contractId;

    private String date;

    private String time;

    public ContractTime() {
    }

    public ContractTime(Long id) {
        this.id = id;
    }

    public ContractTime(Long contractId, String date, String time) {
        this.contractId = contractId;
        this.date = date;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
