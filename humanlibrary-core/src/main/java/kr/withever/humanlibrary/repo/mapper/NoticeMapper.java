package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.Notice;
import org.apache.ibatis.annotations.Param;

/**
 * Created by hyunseunglee on 2017. 2. 28..
 */
public interface NoticeMapper {

    int insertNotice(Notice notice);

    Notice selectNotice(Long id);

    int updateNotice(Notice notice);

    int deleteNotice(Long id);

}
