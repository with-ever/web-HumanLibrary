package kr.withever.humanlibrary.repo;

import java.util.List;
import java.util.Map;

import kr.withever.humanlibrary.exception.HumanLibraryRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import kr.withever.humanlibrary.domain.board.Board;
import kr.withever.humanlibrary.domain.board.BoardFile;
import kr.withever.humanlibrary.domain.board.BoardSearch;
import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.domain.user.UserSearch;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import kr.withever.humanlibrary.repo.mapper.BoardFileMapper;
import kr.withever.humanlibrary.repo.mapper.BoardMapper;

/**
 * Created by hyunseunglee on 2017. 3. 6..
 */
@Repository
public class BoardRepository {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private BoardFileMapper boardFileMapper;
	
		
	public Board retrieveBoard(Long id){
	 Board board =this.boardMapper.selectBoard(id);
	 if(board != null ){
		 BoardFile boardFile =  this.boardFileMapper.selectBoardFile(id);		 
		 board.setFileName(boardFile.getFileName());
	 }	
		return board;
		
	}
		
	public void createBoard(ModelMap result){
		Board board = (Board) result.get("board");
		BoardFile boardFile = (BoardFile) result.get("boardFile");
			this.boardMapper.insertBoard(board);
			if(boardFile != null ){
				this.boardFileMapper.insertBoardFile(boardFile);
	 }
	}
	
	public void modifyBoard(ModelMap result){
		try {
			Board board = (Board) result.get("board");
			BoardFile boardFile = (BoardFile) result.get("boardFile");
			this.boardMapper.updateBoard(board);
			if(boardFile != null ){
				this.boardFileMapper.updateBoardFile(boardFile);
			}
		} catch (Exception e) {
			// @TODO error code update
			// throw new HumanLibraryRuntimeException(e, ExceptionType.US10000);
        }
	}

	public void removeBoard(Long id){
		try{
			this.boardMapper.deleteBoard(id);
			this.boardFileMapper.deleteBoardFile(id);
		}catch (Exception e) {
			// @TODO error code update
			// throw new HumanLibraryRuntimeException(e, ExceptionType.US10000);
        }
	}
	
	public BoardSearch retrieveBoardBySearch(BoardSearch search) {
        List<Board> board = this.boardMapper.selectBoardBySearch(search);
        search.setResults(board);
        if (board.size() != 0) {
            int totalCount = this.boardMapper.selectBoardTotalCountBySearch(search);
            search.setTotalCount(totalCount);
        }
        return search;
    }
	
}
