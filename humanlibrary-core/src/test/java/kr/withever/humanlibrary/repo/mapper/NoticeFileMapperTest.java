package kr.withever.humanlibrary.repo.mapper;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.NoticeFile;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by hyunseunglee on 2017. 2. 28..
 */

@DatabaseSetup(value = { "/dataset/NoticeFile.xml" }, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = { "/dataset/NoticeFile.xml" }, type = DatabaseOperation.DELETE_ALL)
public class NoticeFileMapperTest extends WitheverDbUnitTestConfig {

	@Autowired
	private NoticeFileMapper noticeFileMapper;

	@Test
	public void selectNoticeFile() throws Exception {
		NoticeFile noticeFile = this.noticeFileMapper.selectNoticeFile(1L);
		assertEquals("test_name", noticeFile.getFileName());
	}

	@Test
	public void updateNoticeFile() throws Exception {
		NoticeFile noticeFile = new NoticeFile();
		noticeFile.setId(1L);
		noticeFile.setFileName("update_name");;
		int update = this.noticeFileMapper.updateNoticeFile(noticeFile);
		assertEquals(1, update);
	}

	@Test
	public void deleteNoticeFile() throws Exception {
		int delete = this.noticeFileMapper.deleteNoticeFile(1L);
		assertEquals(1, delete);
	}

	@Test
	public void insertNoticeFile() throws Exception {
		NoticeFile noticeFile = new NoticeFile();
		noticeFile.setFileName("2test_name");;
		noticeFile.setNoticeId(2L);;
		noticeFile.setRelativePath("test/test/test/");;
		noticeFile.setSuffix(".test");;
		int insert = this.noticeFileMapper.insertNoticeFile(noticeFile);
		assertEquals(1, insert);
		noticeFile = this.noticeFileMapper.selectNoticeFile(2L);
		assertEquals("2test_name", noticeFile.getFileName());
	}
}