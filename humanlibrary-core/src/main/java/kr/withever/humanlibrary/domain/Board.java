package kr.withever.humanlibrary.domain;


/**
 * Created by hyunSeungLee on 2017. 2. 28..
 */
public class Board {

    private Long id;

    private String type;
    
    private Long createTime;

    private Long updateTime;

    private String subject;

    private String contents;
    
    private int views;
    
    private Long userId;

 
    public Board() {
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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


	public int getViews() {
		return views;
	}


	public void setViews(int views) {
		this.views = views;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}

    
}
