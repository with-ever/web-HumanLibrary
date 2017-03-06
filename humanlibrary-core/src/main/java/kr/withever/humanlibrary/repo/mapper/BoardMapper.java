package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.Board;
import org.apache.ibatis.annotations.Param;

/**
 * Created by hyunseunglee on 2017. 2. 28..
 */
public interface BoardMapper {

    int insertBoard(Board board);

    Board selectBoard(Long id);

    int updateBoard(Board board);

    int deleteBoard(Long id);

}
