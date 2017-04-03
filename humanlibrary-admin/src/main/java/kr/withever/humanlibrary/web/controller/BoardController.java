package kr.withever.humanlibrary.web.controller;

import kr.withever.humanlibrary.domain.board.Board;
import kr.withever.humanlibrary.domain.board.BoardFile;
import kr.withever.humanlibrary.service.BoardService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by youngjinkim on 2017. 3. 20..
 */
@RestController
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView retrieveBoardList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "board list");
		mav.setViewName("/board/list");
		return mav;
	}

	@RequestMapping(value = "/createForm", method = RequestMethod.GET)
	public ModelAndView createBoardForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/createForm");
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createBoard(Board board, HttpServletRequest request) throws IllegalStateException, IOException {

		List<BoardFile> boardFileList = new ArrayList<BoardFile>();

		String filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/file/");

		System.out.println("filePath:" + filePath);

		File dir = new File(filePath);

		if (!dir.isDirectory()) { // 폴더가 없을시 만듬

			dir.mkdirs();

		}

		Long userId = 123L;

		board.setUserId(userId);

		Long boardId = 123L; // 추후 insert된 board id로 수정(board row+1)

		if (board.getFiles() != null) {
			for (MultipartFile file : board.getFiles()) {

				String originalFilename = file.getOriginalFilename();

				String saveFileName = boardId + "_" + originalFilename;

				String fileName = saveFileName.substring(0, saveFileName.lastIndexOf("."));

				String suffix = saveFileName.substring(saveFileName.lastIndexOf(".") + 1, saveFileName.length());

				String relativePath = filePath;
				BoardFile boardFile = new BoardFile();
				boardFile.setFileName(fileName);
				boardFile.setSuffix(suffix);
				boardFile.setRelativePath(relativePath);
				boardFile.setBoardId(boardId);

				boardFileList.add(boardFile);
				
				board.setBoardFileList(boardFileList);
				
				file.transferTo(new File(filePath + saveFileName));
			}
		}
		
		this.boardService.createBoard(board);

	}

}
