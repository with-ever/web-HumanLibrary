package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.board.Board;
import kr.withever.humanlibrary.domain.board.BoardSearch;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by hyunseunglee on 2017. 2. 28..
 */
@Mapper
public interface BoardMapper {

    int insertBoard(Board board);

    Board selectBoard(Long id);

    int updateBoard(Board board);

    int deleteBoard(Long id);
    
    List<Board> selectBoardBySearch(BoardSearch search);
    
    int selectBoardTotalCountBySearch(BoardSearch search);

}
