package kr.withever.humanlibrary.repo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.withever.humanlibrary.domain.board.Board;
import kr.withever.humanlibrary.domain.board.BoardFile;
import kr.withever.humanlibrary.domain.board.BoardSearch;
import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.repo.mapper.BoardFileMapper;
import kr.withever.humanlibrary.repo.mapper.BoardMapper;
import kr.withever.humanlibrary.repo.mapper.UserMapper;

/**
 * Created by hyunseunglee on 2017. 3. 6..
 */
@Repository
public class BoardRepository {

	@Autowired
	private BoardMapper boardMapper;

	@Autowired
	private UserMapper userMapper;

	public Board retrieveBoard(Long id) {
		
		return this.boardMapper.selectBoard(id);


	}
	
	public Long retrieveBoardId(){
	  return this.boardMapper.selectBoardId();	
	}

	public void createBoard(Board board) {
		this.boardMapper.insertBoard(board);
	}

	public void modifyBoard(Board board) {
		this.boardMapper.updateBoard(board);
	}

	public void removeBoard(Long id) {
		try {
			this.boardMapper.deleteBoard(id);
		} catch (Exception e) {
			// @TODO error code update
			// throw new HumanLibraryRuntimeException(e, ExceptionType.US10000);
		}
	}

	public BoardSearch retrieveBoardBySearch(BoardSearch search) {

		List<Board> boardList = this.boardMapper.selectBoardBySearch(search);

		search.setResults(boardList);
		
		if (boardList.size() != 0) {
			int totalCount = this.boardMapper.selectBoardTotalCountBySearch(search);
			search.setTotalCount(totalCount);
		}
		return search;
	}

}
