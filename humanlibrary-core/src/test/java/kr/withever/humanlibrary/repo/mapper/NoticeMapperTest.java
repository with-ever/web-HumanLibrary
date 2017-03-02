package kr.withever.humanlibrary.repo.mapper;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.Notice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by hyunseunglee on 2017. 2. 28..
 */

@DatabaseSetup(value = { "/dataset/Notice.xml" }, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = { "/dataset/Notice.xml" }, type = DatabaseOperation.DELETE_ALL)
public class NoticeMapperTest extends WitheverDbUnitTestConfig {

	@Autowired
	private NoticeMapper noticeMapper;

	@Test
	public void selectNotice() throws Exception {
		Notice notice = this.noticeMapper.selectNotice(1L);
		assertEquals("NT", notice.getType());
	}

	@Test
	public void updateNotice() throws Exception {
		Notice notice = new Notice();
		notice.setId(1L);
		notice.setViews(16);
		notice.setType("NN");
		int update = this.noticeMapper.updateNotice(notice);
		assertEquals(1, update);
	}

	@Test
	public void deleteNotice() throws Exception {
		int delete = this.noticeMapper.deleteNotice(1L);
		assertEquals(1, delete);
	}

	@Test
	public void insertNotice() throws Exception {
		Notice notice = new Notice();
		notice.setType("NN");
		notice.setViews(1);
		notice.setUserId(1L);
		notice.setContents("test");
		notice.setSubject("test sub");
		notice.setCreateTime(11111L);
		int insert = this.noticeMapper.insertNotice(notice);
		assertEquals(1, insert);
		notice = this.noticeMapper.selectNotice(2L);
		assertEquals("NN", notice.getType());
	}
}