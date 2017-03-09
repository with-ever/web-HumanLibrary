package kr.withever.humanlibrary.domain.board;

import kr.withever.humanlibrary.domain.common.PageSearch;

/**
 * Created by hyunseunglee on 2017. 3. 8..
 */
public class BoardSearch extends PageSearch<Board> {

    private String name;

    private String type;

    private String subject;

    private String contents;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

  
}
