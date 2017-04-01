package kr.withever.humanlibrary.repo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.withever.humanlibrary.domain.board.Board;
import kr.withever.humanlibrary.domain.board.BoardSearch;
import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.repo.mapper.BoardMapper;

/**
 * Created by hyunseunglee on 2017. 3. 6..
 */
@Repository
public class BoardRepository {

	@Autowired
	private BoardMapper boardMapper;

	public Board retrieveBoard(Long id) {
		Board board = this.boardMapper.selectBoard(id);
		return board;

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
		List<Board> board = this.boardMapper.selectBoardBySearch(search);
		search.setResults(board);
		if (board.size() != 0) {
			int totalCount = this.boardMapper.selectBoardTotalCountBySearch(search);
			search.setTotalCount(totalCount);
		}
		return search;
	}

}
