package kr.withever.humanlibrary.service;

import java.util.Map;

import org.springframework.ui.ModelMap;

import kr.withever.humanlibrary.domain.board.Board;
import kr.withever.humanlibrary.domain.board.BoardSearch;

/**
 * Created by hyunseunglee on 2017. 3. 6..
 */
public interface BoardService {

    Board retrieveBoard(Long id);

    void createBoard(ModelMap result);

	void modifyBoard(ModelMap result);

	void removeBoard(Long id);

	BoardSearch retrieveBoardBySearch(BoardSearch search);
}
