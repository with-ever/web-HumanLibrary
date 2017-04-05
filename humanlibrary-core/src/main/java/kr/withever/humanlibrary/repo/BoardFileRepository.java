package kr.withever.humanlibrary.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.withever.humanlibrary.domain.board.BoardFile;
import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.repo.mapper.BoardFileMapper;

/**
 * Created by hyunseunglee on 2017. 4. 1..
 */
@Repository
public class BoardFileRepository {

	@Autowired
	private BoardFileMapper boardFileMapper;

	public BoardFile retrieveBoardFile(Long id) {
		BoardFile boardFile = this.boardFileMapper.selectBoardFile(id);
		return boardFile;

	}

	public void createBoardFile(BoardFile boardFile) {
		this.boardFileMapper.insertBoardFile(boardFile);
	}

	public void modifyBoardFile(BoardFile boardFile) {
		this.boardFileMapper.updateBoardFile(boardFile);
	}

	public void removeBoardFile(Long id) {
		try {
			this.boardFileMapper.deleteBoardFile(id);
		} catch (Exception e) {
			// @TODO error code update
			// throw new HumanLibraryRuntimeException(e, ExceptionType.US10000);
		}
	}

}