package kr.withever.humanlibrary.repo.mapper;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.board.Board;
import kr.withever.humanlibrary.domain.board.BoardSearch;
import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.domain.user.UserSearch;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
		Board board = new Board();
		board.setType("NN");
		board.setViews(1);
		board.setUserId(1L);
		board.setContents("test");
		board.setSubject("test sub");
		board.setCreateTime(11111L);
		int insert = this.boardMapper.insertBoard(board);
		assertEquals(1, insert);
		board = this.boardMapper.selectBoard(3L);
		assertEquals("test", board.getContents());
	}
	
	 @Test
	    public void selectBoardBySearch() throws Exception {
	        BoardSearch search = new BoardSearch();
	        search.setSubject("TEST SUBJECT");
	        List<Board> board = this.boardMapper.selectBoardBySearch(search);
	        assertEquals(2, board.size());
	    }

	    @Test
	    public void selectUsersTotalCountBySearch() throws Exception {
	    	BoardSearch search = new BoardSearch();
	        int count = this.boardMapper.selectBoardTotalCountBySearch(search);
	        assertEquals(2, count);
	    }
}