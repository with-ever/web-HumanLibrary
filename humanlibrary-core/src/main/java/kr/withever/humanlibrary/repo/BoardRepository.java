package kr.withever.humanlibrary.repo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.withever.humanlibrary.domain.board.Board;
import kr.withever.humanlibrary.domain.board.BoardFile;
import kr.withever.humanlibrary.domain.board.BoardSearch;
import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.repo.mapper.BoardFileMapper;
import kr.withever.humanlibrary.repo.mapper.BoardMapper;
import kr.withever.humanlibrary.repo.mapper.UserMapper;

/**
 * Created by hyunseunglee on 2017. 3. 6..
 */
@Repository
public class BoardRepository {

	@Autowired
	private BoardMapper boardMapper;

	@Autowired
	private BoardFileMapper boardFileMapper;

	@Autowired
	private UserMapper userMapper;

	public Board retrieveBoard(Long id) {
		Board board = this.boardMapper.selectBoard(id);
		BoardFile boardFile = new BoardFile();
		boardFile.setBoardId(id);
		board.setBoardFileList(this.boardFileMapper.selectBoardFiles(boardFile));
		String dataFormat = "yyy-MM-dd HH:mm:ss";
		SimpleDateFormat f = new SimpleDateFormat(dataFormat);

		f.setTimeZone(TimeZone.getTimeZone("GMT+9"));

		Date d = new Date(board.getCreateTime() * 1000L);

		board.setCvtCreateTime(f.format(d));

		
		User user = this.userMapper.selectUser(board.getUserId());

		board.setUserLoginId(user.getLoginId());
		
		if(board.getType().equals("MP")){
			board.setCvtType("주요프로그램");
		}else if(board.getType().equals("PT")){
			board.setCvtType("게시물");
		}else if(board.getType().equals("NT")){
			board.setCvtType("공지사항");
		}

		return board;

	}

	public void createBoard(Board board) {
		this.boardMapper.insertBoard(board);
	}

	public void modifyBoard(Board board) {
		this.boardMapper.updateBoard(board);
	}

	public void removeBoard(Long id) {
		try {
			this.boardMapper.deleteBoard(id);
		} catch (Exception e) {
			// @TODO error code update
			// throw new HumanLibraryRuntimeException(e, ExceptionType.US10000);
		}
	}

	public BoardSearch retrieveBoardBySearch(BoardSearch search) {

		List<Board> boardList = this.boardMapper.selectBoardBySearch(search);

		String dataFormat = "yyy-MM-dd HH:mm:ss";

		SimpleDateFormat f = new SimpleDateFormat(dataFormat);

		f.setTimeZone(TimeZone.getTimeZone("GMT+9"));

		for (int i = 0; i < boardList.size(); i++) {

			Board board = boardList.get(i);

			Date d = new Date(board.getCreateTime() * 1000L);

			boardList.get(i).setCvtCreateTime(f.format(d));

			User user = this.userMapper.selectUser(board.getUserId());

			boardList.get(i).setUserLoginId(user.getLoginId());
		}

		search.setResults(boardList);
		if (boardList.size() != 0) {
			int totalCount = this.boardMapper.selectBoardTotalCountBySearch(search);
			search.setTotalCount(totalCount);
		}
		return search;
	}

}
