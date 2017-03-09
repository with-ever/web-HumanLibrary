package kr.withever.humanlibrary.repo.mapper;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.board.BoardFile;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by hyunseunglee on 2017. 2. 28..
 */

@DatabaseSetup(value = { "/dataset/BoardFile.xml" }, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = { "/dataset/BoardFile.xml" }, type = DatabaseOperation.DELETE_ALL)
public class BoardFileMapperTest extends WitheverDbUnitTestConfig {

	@Autowired
	private BoardFileMapper boardFileMapper;

	@Test
	public void selectBoardFile() throws Exception {
		BoardFile boardFile = this.boardFileMapper.selectBoardFile(1L);
		assertEquals("test_name", boardFile.getFileName());
	}

	@Test
	public void updateBoardFile() throws Exception {
		BoardFile boardFile = new BoardFile();
		boardFile.setBoardId(1L);;
		boardFile.setFileName("update_name");;
		int update = this.boardFileMapper.updateBoardFile(boardFile);
		assertEquals(1, update);
	}

	@Test
	public void deleteBoardFile() throws Exception {
		int delete = this.boardFileMapper.deleteBoardFile(1L);
		assertEquals(1, delete);
	}

	@Test
	public void insertBoardFile() throws Exception {
		BoardFile noticeFile = new BoardFile();
		noticeFile.setFileName("2test_name");;
		noticeFile.setBoardId(2L);;
		noticeFile.setRelativePath("test/test/test/");;
		noticeFile.setSuffix(".test");;
		int insert = this.boardFileMapper.insertBoardFile(noticeFile);
		assertEquals(1, insert);
		noticeFile = this.boardFileMapper.selectBoardFile(2L);
		assertEquals("2test_name", noticeFile.getFileName());
	}
}