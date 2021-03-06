package kr.withever.humanlibrary.domain.board;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.withever.humanlibrary.domain.user.User;


/**
 * Created by hyunseunglee on 2017. 2. 28..
 */
public class Board {

    private Long id;

	private Long userId;
	
    private String type;
    
    private String cvtType;

    private String subject;

    private String contents;
    
    private int views;

	private Long createTime;
	
	private Long updateTime;
			    
    private List<BoardFile> boardFileList;
    
    private String url;
    
    private User user;
    
    private List<String> originalImage;
        
 
    public Board() {
    	this.createTime = System.currentTimeMillis() / 1000;
    	this.updateTime = System.currentTimeMillis() / 1000;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCvtType() {
		return cvtType;
	}

	public void setCvtType(String cvtType) {
		this.cvtType = cvtType;
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
	

	public List<BoardFile> getBoardFileList() {
		return boardFileList;
	}

	public void setBoardFileList(List<BoardFile> boardFileList) {
		this.boardFileList = boardFileList;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
    public Date getCreateDate() {
        return new Date(this.createTime * 1000);
    }

    public Date getUpdateDate() {
        return new Date(this.updateTime * 1000);
    }

	public List<String> getOriginalImage() {
		return originalImage;
	}

	public void setOriginalImage(List<String> originalImage) {
		this.originalImage = originalImage;
	}
	
	
}
