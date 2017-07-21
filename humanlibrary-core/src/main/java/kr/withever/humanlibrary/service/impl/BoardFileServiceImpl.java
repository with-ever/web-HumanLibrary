package kr.withever.humanlibrary.service.impl;

import kr.withever.humanlibrary.domain.board.Board;
import kr.withever.humanlibrary.domain.board.BoardFile;
import kr.withever.humanlibrary.domain.board.BoardSearch;
import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import kr.withever.humanlibrary.repo.BoardFileRepository;
import kr.withever.humanlibrary.repo.BoardRepository;
import kr.withever.humanlibrary.service.BoardFileService;
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
public class BoardFileServiceImpl implements BoardFileService {

	@Autowired
	private BoardFileRepository boardFileRepository;

	@Override
	public List<BoardFile> retrieveBoardFile(BoardFile boardFile) {
		return this.boardFileRepository.retrieveBoardFile(boardFile);
	}
	
	@Override
	public int retrieveBoardFileCount(BoardFile boardFile) {
		return this.boardFileRepository.retrieveBoardFileCount(boardFile);
	}
	

	@Override
	public void createBoardFile(BoardFile boardFile) {
		this.boardFileRepository.createBoardFile(boardFile);

	}

	@Override
	public void modifyBoardFile(BoardFile boardFile) {
		
		this.boardFileRepository.modifyBoardFile(boardFile);;
		
	}

	@Override
	public void removeBoardFile(Long id) {
		this.boardFileRepository.removeBoardFile(id);
	}
	@Override
	public void removeBoardFileEdit(String fileName) {
		this.boardFileRepository.removeBoardFileEdit(fileName);
	}

}
