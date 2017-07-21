package kr.withever.humanlibrary.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

import kr.withever.humanlibrary.domain.board.Board;
import kr.withever.humanlibrary.domain.board.BoardFile;
import kr.withever.humanlibrary.domain.board.BoardSearch;

/**
 * Created by hyunseunglee on 2017. 3. 6..
 */
public interface BoardFileService {

    List<BoardFile> retrieveBoardFile(BoardFile boardFile);

    void createBoardFile(BoardFile boardFile);

	void modifyBoardFile(BoardFile boardFile);

	void removeBoardFile(Long id);
	
	void removeBoardFileEdit(String fileName);
	
	int retrieveBoardFileCount(BoardFile boardFile);

}
