package kr.withever.humanlibrary.api.controller;

import kr.withever.humanlibrary.domain.Board;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youngjinkim on 2017. 3. 6..
 */

@RestController
@RequestMapping(value = "/api/boards")
public class BoardController {

    @RequestMapping(value = "/{boardId}", method = RequestMethod.GET)
    public Board retrieveBoard(@PathVariable(value = "boardId") Long boardId) {
        return new Board();
    }
}
