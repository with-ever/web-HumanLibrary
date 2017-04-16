package kr.withever.humanlibrary.domain.contract;

import kr.withever.humanlibrary.domain.common.PageSearch;

import java.util.List;

/**
 * Created by youngjinkim on 2017. 4. 4..
 */
public class ContractSearch extends PageSearch{

    private List<String> state;

    /** yyyyMM 날짜 조회 조건은 무조건 STATE ACCEPT **/
    private String startDate;

    /** yyyyMM 날짜 조회 조건은 무조건 STATE ACCEPT **/
    private String endDate;

    private Long userId;

    private Long hbId;

    // utime 기준
    private String orderBy;

    public ContractSearch() {
        this.orderBy = "DESC";
    }

    public List<String> getState() {
        return state;
    }

    public void setState(List<String> state) {
        this.state = state;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHbId() {
        return hbId;
    }

    public void setHbId(Long hbId) {
        this.hbId = hbId;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy.toUpperCase().equals("ASC") ? "ASC" : "DESC";
    }
}
