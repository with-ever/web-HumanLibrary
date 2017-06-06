package kr.withever.humanlibrary.api.controller;

import kr.withever.humanlibrary.domain.board.Board;
import kr.withever.humanlibrary.domain.board.BoardSearch;
import kr.withever.humanlibrary.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hyunseunglee on 2017. 3. 6..
 */

@RestController
@RequestMapping(value = "/api/board")
public class BoardController {
	
	@Autowired
    private BoardService boardService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Board retrieveBoard(@PathVariable(value = "id") Long id) {
        return this.boardService.retrieveBoard(id);
    }
     
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void removeBoard(@PathVariable(value = "id") Long id) {
        this.boardService.removeBoard(id);
    }
    
    
    @RequestMapping(method = RequestMethod.GET)
    public BoardSearch retrieveBoardList(BoardSearch search) {
        return this.boardService.retrieveBoardBySearch(search);
    }
    
}
