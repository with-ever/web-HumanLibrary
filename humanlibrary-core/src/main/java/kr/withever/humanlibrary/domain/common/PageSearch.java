package kr.withever.humanlibrary.domain.common;

import java.util.List;

/**
 * Created by youngjinkim on 2017. 2. 13..
 */
public class PageSearch<E> {

    public PageSearch() {
        //
    }

    /** 결과 */
    List<E> results;

    /** 위치 값 */
    private int offset = 0;

    /** 데이터 개수 */
    private int limit = 10;

    /** 합계 */
    private int totalCount;

    /** 페이지 번호 */
    private int pageNo = 1;

    /** 전체 페이지 번호 */
    private int totalPageNo;
    
    /** 네비게이션 바에서 보여질 페이지 개수 */
    private int navigateLimit = 10;

    public List<E> getResults() {
        return results;
    }

    public void setResults(List<E> results) {
        this.results = results;
    }

    public int getOffset() {
        if (pageNo == 1) return offset;
        offset = (pageNo - 1) * limit;
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalPageNo = (totalCount / this.limit) + (totalCount % this.limit > 0 ? 1 : 0);
        this.totalCount = totalCount;
    }

    public int getPageNo() {
        if (offset == 0) return pageNo;
        pageNo = (offset / limit) + 1;
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalPageNo() {
        return totalPageNo;
    }

    public void setTotalPageNo(int totalPageNo) {
        this.totalPageNo = totalPageNo;
    }

    public int getNavigateLimit() {
		return navigateLimit;
	}

	public void setNavigateLimit(int navigateLimit) {
		this.navigateLimit = navigateLimit;
	}

	public int getNavigateStartPage() {
        return ((getPageNo() - 1) / this.navigateLimit) * this.navigateLimit + 1;
    }

    public int getNavigatePageCount() {
        return (getTotalPageNo() - getNavigateStartPage() + 1) > this.navigateLimit ? this.navigateLimit : (getTotalPageNo() - getNavigateStartPage() + 1);
    }
}
