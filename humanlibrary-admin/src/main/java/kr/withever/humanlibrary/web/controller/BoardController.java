package kr.withever.humanlibrary.web.controller;

import kr.withever.humanlibrary.domain.board.Board;
import kr.withever.humanlibrary.domain.board.BoardFile;
import kr.withever.humanlibrary.domain.board.BoardSearch;
import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.security.LoginUser;
import kr.withever.humanlibrary.service.BoardFileService;
import kr.withever.humanlibrary.service.BoardService;
import kr.withever.humanlibrary.service.UserService;
import kr.withever.humanlibrary.util.AWSS3Util;
import kr.withever.humanlibrary.util.FileUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hyunseung on 2017. 3. 20..
 */
@RestController
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private BoardFileService boardFileService;

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView retrieveBoardList(BoardSearch search) {

		String searchOption = search.getSearchOption();
		String searchOptionType = search.getSearchOptionType();
		String Keyword = search.getKeyword();

		if (searchOption != null || Keyword != null) {

			if (searchOption.equals("subject")) {
				search.setSubject(Keyword);
			} else if (searchOption.equals("contents")) {
				search.setContents(Keyword);
			}
		}

		if (searchOptionType != null) {
			if (searchOptionType.equals("MP")) {
				search.setType("MP");
			} else if (searchOptionType.equals("PT")) {
				search.setType("PT");
			} else if (searchOptionType.equals("NT")) {
				search.setType("NT");
			}
		}

		BoardSearch boardSearch = this.boardService.retrieveBoardBySearch(search);

		List<Board> boardList = boardSearch.getResults();

		for (int i = 0; i < boardList.size(); i++) {

			Board board = boardList.get(i);

			User user = this.userService.retrieveUser(board.getUserId());

			boardList.get(i).setUser(user);
		}

		search.setResults(boardList);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/list");
		mav.addObject("searchModel", boardSearch);
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView retreiveBoard(@PathVariable(value = "id") Long id) {

		Board board = this.boardService.retrieveBoard(id);
		BoardFile boardFile = new BoardFile();
		boardFile.setBoardId(board.getId());
		List<BoardFile> boardFileList = this.boardFileService.retrieveBoardFile(boardFile);
		board.setBoardFileList(boardFileList);

		userService.retrieveUser(board.getId());
		board.setUser(userService.retrieveUser(board.getId()));

		if (board.getType().equals("MP")) {
			board.setCvtType("주요프로그램");
		} else if (board.getType().equals("PT")) {
			board.setCvtType("게시물");
		} else if (board.getType().equals("NT")) {
			board.setCvtType("공지사항");
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/detail");
		mav.addObject("board", board);
		return mav;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView showCreateBoardForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/new");
		return mav;
	}

	@RequestMapping(value = "/new/create", method = RequestMethod.POST)
	public void createBoard(HttpServletResponse response, MultipartHttpServletRequest mhsq, Board board)
			throws IllegalStateException, IOException {

		Long boardId = this.boardService.retrieveBoardId();
		String loginId = LoginUser.getLoginUser().getUsername();
		User user = userService.retrieveUserByLoginId(loginId);
		Long userId = user.getUserId();
		board.setUserId(userId);

		// 넘어온 파일을 리스트로 저장
		List<MultipartFile> mf = mhsq.getFiles("image");

		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

			boardService.createBoard(board);

		} else {
			for (int i = 0; i < mf.size(); i++) {

				// 본래 파일명
				String originalfileName = mf.get(i).getOriginalFilename();

				if (!originalfileName.equals("")) {

					String suffix = originalfileName.substring(originalfileName.lastIndexOf(".") + 1,
							originalfileName.length());
					AWSS3Util s3Util = new AWSS3Util();
					String bucketName = s3Util.createBuckectName("boardImage");
					String fileName = s3Util.createFileName(String.valueOf(boardId + 1L) + '_' + (i + 1), originalfileName);
					s3Util.fileUpload(bucketName, fileName, FileUtil.convertMultipartFileToFile(mf.get(i)));
					String url = s3Util.getFileURL(bucketName, fileName);

					BoardFile boardFile = new BoardFile();
					boardFile.setFileName(fileName.substring(0, fileName.lastIndexOf(".") - 1));
					boardFile.setSuffix(suffix);
					boardFile.setRelativePath(url.split("\\?")[0]);
					boardFile.setBoardId(boardId + 1L);
					boardFileService.createBoardFile(boardFile);
				}
			}
			boardService.createBoard(board);
		}

		response.sendRedirect("/board");

	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView showModifyBoardForm(@PathVariable(value = "id") Long id) {
		Board board = this.boardService.retrieveBoard(id);
		BoardFile boardFile = new BoardFile();
		boardFile.setBoardId(board.getId());
		;
		List<BoardFile> boardFileList = this.boardFileService.retrieveBoardFile(boardFile);
		board.setBoardFileList(boardFileList);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/edit");
		mav.addObject("board", board);
		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView modifyBoard(HttpServletResponse response, MultipartHttpServletRequest mhsq, Board board)
			throws IllegalStateException, IOException {

		String[] originalImageArray = mhsq.getParameterValues("originalImage");

		Long boardId = board.getId();
		BoardFile boardFile = new BoardFile();
		boardFile.setBoardId(boardId);

		List<BoardFile> boardFileList = boardFileService.retrieveBoardFile(boardFile);
		for (int i = 0; i < boardFileList.size(); i++) {

			String fileName = boardFileList.get(i).getFileName();

			String fileCheck = null;

			if (originalImageArray != null) {
				for (int a = 0; a < originalImageArray.length; a++) {
					String originalFileName = originalImageArray[a].substring(0, originalImageArray[a].lastIndexOf("."));
					if (fileName.equals(originalFileName)) {

						fileCheck = "ok";

					}else{
						fileCheck = "delete";
					}

				}
			}

			if (fileCheck.equals("delete")) {

				boardFileService.removeBoardFileEdit(fileName);
			}

		}

		// 넘어온 파일을 리스트로 저장
		List<MultipartFile> mf = mhsq.getFiles("image");

		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

			boardService.modifyBoard(board);

		} else {
			for (int i = 0; i < mf.size(); i++) {

				// 본래 파일명
				String originalfileName = mf.get(i).getOriginalFilename();

				int count = boardFileService.retrieveBoardFileCount(boardFile);
				
				if (!originalfileName.equals("")) {

					String suffix = originalfileName.substring(originalfileName.lastIndexOf(".") + 1,
							originalfileName.length());
					AWSS3Util s3Util = new AWSS3Util();
					String bucketName = s3Util.createBuckectName("boardImage");
					
					
					String fileName = s3Util.createFileName(String.valueOf(boardId) + '_' + (count + 1), originalfileName);
					s3Util.fileUpload(bucketName, fileName, FileUtil.convertMultipartFileToFile(mf.get(i)));
					String url = s3Util.getFileURL(bucketName, fileName);

					boardFile.setFileName(fileName.substring(0, fileName.lastIndexOf(".") - 1));
					boardFile.setSuffix(suffix);
					boardFile.setRelativePath(url.split("\\?")[0]);
					boardFile.setBoardId(boardId);
					boardFileService.createBoardFile(boardFile);
				}
			}
			boardService.modifyBoard(board);
		}

		return (ModelAndView)new ModelAndView("redirect:/board/" + boardId );


	}

	// @RequestMapping(value = "/boardFileDown.do/{id}/{fileName}", method =
	// RequestMethod.GET)
	// public void boardFileDown(@PathVariable(value = "id") Long id,
	// @PathVariable(value = "fileName") String fileName,
	// HttpServletRequest req, HttpServletResponse resp) {
	//
	// BoardFile boardFile = new BoardFile();
	// boardFile.setBoardId(id);
	// boardFile.setFileName(fileName);
	//
	// List<BoardFile> boardFileList =
	// boardService.retrieveBoardFile(boardFile);
	// boardFile = boardFileList.get(0);
	//
	// OutputStream outputStream = null;
	// String relativePath = boardFile.getRelativePath();
	// fileName = boardFile.getFileName();
	// String suffix = boardFile.getSuffix();
	//
	// String uploadPath = relativePath + fileName + "." + suffix;
	//
	// try {
	// File file = new File(uploadPath);
	//
	// if (suffix.trim().equalsIgnoreCase("txt")) {
	// resp.setContentType("text/plain");
	// } else {
	// resp.setContentType("application/octet-stream");
	// }
	//
	// resp.setContentLength((int) file.length());
	//
	// boolean ie = req.getHeader("User-Agent").indexOf("MSIE") != -1;
	// if (ie) {
	// fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", " ");
	// } else {
	// fileName = new String(fileName.getBytes("UTF-8"), "8859_1");
	// }
	//
	// resp.setHeader("Content-Disposition", "attachment; filename=\"" +
	// fileName + "." + suffix + "\"");
	//
	// outputStream = resp.getOutputStream();
	// FileInputStream fis = null;
	//
	// try {
	// fis = new FileInputStream(file);
	// FileCopyUtils.copy(fis, outputStream);
	// } finally {
	// if (fis != null) {
	// fis.close();
	// }
	// }
	// } catch (IOException e) {
	// throw new RuntimeException(e);
	// } finally {
	// try {
	// outputStream.close();
	// resp.flushBuffer();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// }

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public void removeBoard(@PathVariable(value = "id") Long id) {
		this.boardService.removeBoard(id);
	}

}
