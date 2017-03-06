package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.BoardFile;
import org.apache.ibatis.annotations.Param;

/**
 * Created by hyunseunglee on 2017. 2. 28..
 */
public interface BoardFileMapper {

    int insertBoardFile(BoardFile boardFile);

    BoardFile selectBoardFile(Long id);

    int updateBoardFile(BoardFile boardFile);

    int deleteBoardFile(Long id);

}
