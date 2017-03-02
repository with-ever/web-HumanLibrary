package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.NoticeFile;
import org.apache.ibatis.annotations.Param;

/**
 * Created by hyunseunglee on 2017. 2. 28..
 */
public interface NoticeFileMapper {

    int insertNoticeFile(NoticeFile noticeFile);

    NoticeFile selectNoticeFile(Long id);

    int updateNoticeFile(NoticeFile noticeFile);

    int deleteNoticeFile(Long id);

}
