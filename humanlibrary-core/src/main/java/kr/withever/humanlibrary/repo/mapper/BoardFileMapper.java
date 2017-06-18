package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.board.BoardFile;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by hyunseunglee on 2017. 2. 28..
 */
@Mapper
public interface BoardFileMapper {

    int insertBoardFile(BoardFile boardFile);
    
    List<BoardFile> selectBoardFile(BoardFile boardFile);

    int updateBoardFile(BoardFile boardFile);

    int deleteBoardFile(Long boardId);

}
