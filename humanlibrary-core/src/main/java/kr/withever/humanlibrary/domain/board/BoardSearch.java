package kr.withever.humanlibrary.domain.board;

import java.util.List;

import kr.withever.humanlibrary.domain.common.PageSearch;

/**
 * Created by hyunseunglee on 2017. 3. 8..
 */
public class BoardSearch extends PageSearch<Board> {
	
	private String searchOption;
	
	private String searchOptionType;
	
	private String keyword;
		
    private String subject;

    private String contents;
    
    private String type;
        
    private List<Long> userIdList;
    
    private String userLoginId;

    
	public String getSearchOption() {
		return searchOption;
	}

	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	public List<Long> getUserIdList() {
		return userIdList;
	}
	public void setUserIdList(List<Long> userIdList) {
		this.userIdList = userIdList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSearchOptionType() {
		return searchOptionType;
	}

	public void setSearchOptionType(String searchOptionType) {
		this.searchOptionType = searchOptionType;
	}
	
	
  
}
