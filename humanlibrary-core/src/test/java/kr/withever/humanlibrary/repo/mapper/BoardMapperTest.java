package kr.withever.humanlibrary.repo.mapper;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.Board;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by hyunseunglee on 2017. 2. 28..
 */

@DatabaseSetup(value = { "/dataset/Board.xml" }, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = { "/dataset/Board.xml" }, type = DatabaseOperation.DELETE_ALL)
public class BoardMapperTest extends WitheverDbUnitTestConfig {

	@Autowired
	private BoardMapper boardMapper;

	@Test
	public void selectBoard() throws Exception {
		Board notice = this.boardMapper.selectBoard(1L);
		assertEquals("NT", notice.getType());
	}

	@Test
	public void updateBoard() throws Exception {
		Board notice = new Board();
		notice.setId(1L);
		notice.setViews(16);
		notice.setType("NN");
		int update = this.boardMapper.updateBoard(notice);
		assertEquals(1, update);
	}

	@Test
	public void deleteBoard() throws Exception {
		int delete = this.boardMapper.deleteBoard(1L);
		assertEquals(1, delete);
	}

	@Test
	public void insertBoard() throws Exception {
		Board notice = new Board();
		notice.setType("NN");
		notice.setViews(1);
		notice.setUserId(1L);
		notice.setContents("test");
		notice.setSubject("test sub");
		notice.setCreateTime(11111L);
		int insert = this.boardMapper.insertBoard(notice);
		assertEquals(1, insert);
		notice = this.boardMapper.selectBoard(2L);
		assertEquals("NN", notice.getType());
	}
}