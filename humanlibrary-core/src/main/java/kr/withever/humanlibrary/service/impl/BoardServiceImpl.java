package kr.withever.humanlibrary.service.impl;

import kr.withever.humanlibrary.domain.board.Board;
import kr.withever.humanlibrary.domain.board.BoardFile;
import kr.withever.humanlibrary.domain.board.BoardSearch;
import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import kr.withever.humanlibrary.repo.BoardFileRepository;
import kr.withever.humanlibrary.repo.BoardRepository;
import kr.withever.humanlibrary.service.BoardService;

import java.io.File;
import java.io.OutputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hyunseunglee on 2017. 7. 3..
 */
@Service
@Transactional
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private BoardFileRepository boardFileRepository;

	@Override
	public Board retrieveBoard(Long id) {
		return this.boardRepository.retrieveBoard(id);
	}
	
	@Override
	public Long retrieveBoardId() {
		return this.boardRepository.retrieveBoardId();
	}
	
	public List<BoardFile> retrieveBoardFile(BoardFile boardFile) {
		return this.boardFileRepository.retrieveBoardFile(boardFile);
	}	

	@Override
	public void createBoard(Board board) {
		this.boardRepository.createBoard(board);

	}

	@Override
	public void modifyBoard(Board board) {	
		this.boardRepository.modifyBoard(board);
	}

	@Override
	public void removeBoard(Long id) {
		this.boardRepository.removeBoard(id);
	}

	@Override
	public BoardSearch retrieveBoardBySearch(BoardSearch search) {
		return this.boardRepository.retrieveBoardBySearch(search);
	}

}
