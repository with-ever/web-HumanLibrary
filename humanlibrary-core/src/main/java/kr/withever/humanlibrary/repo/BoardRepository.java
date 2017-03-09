package kr.withever.humanlibrary.repo;

import java.util.List;

import kr.withever.humanlibrary.exception.HumanLibraryRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
		 board.setBoardFile(boardFile);
	 }	
		return board;
		
	}
		
	public void createBoard(Board board){
		try{
			this.boardMapper.insertBoard(board);
			BoardFile boardFile = board.getBoardFile();
			if(boardFile != null ){
				this.boardFileMapper.insertBoardFile(boardFile);
			}
		}catch (Exception e) {
            // @TODO exception 코드 정리 필요.
			throw new HumanLibraryRuntimeException(e, ExceptionType.US10000);
        }
	}
	
	public void modifyBoard(Board board){
		try {
			this.boardMapper.updateBoard(board);
			BoardFile boardFile = board.getBoardFile();
			if(boardFile != null ){
				this.boardFileMapper.updateBoardFile(boardFile);
			}
		} catch (Exception e) {
            // @TODO exception 코드 정리 필요.
			throw new HumanLibraryRuntimeException(e, ExceptionType.US10000);
        }
	}

	public void removeBoard(Long id){
		try{
			this.boardMapper.deleteBoard(id);
			this.boardFileMapper.deleteBoardFile(id);
		}catch (Exception e) {
            // @TODO exception 코드 정리 필요.
			throw new HumanLibraryRuntimeException(e, ExceptionType.US10000);
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
