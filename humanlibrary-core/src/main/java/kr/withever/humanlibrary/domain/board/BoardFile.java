package kr.withever.humanlibrary.domain.board;


/**
 * Created by hyunseunglee on 2017. 2. 28..
 */
public class BoardFile  {

    private Long id;

    private String fileName;

    private String relativePath;

    private String suffix;

    private Long boardId;

  
    public BoardFile() {
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getRelativePath() {
		return relativePath;
	}


	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}


	public String getSuffix() {
		return suffix;
	}


	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}


	public Long getBoardId() {
		return boardId;
	}


	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}



   
}
