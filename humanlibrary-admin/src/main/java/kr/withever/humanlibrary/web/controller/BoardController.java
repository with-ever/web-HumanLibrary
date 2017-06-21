package kr.withever.humanlibrary.web.controller;

import kr.withever.humanlibrary.domain.board.Board;
import kr.withever.humanlibrary.domain.board.BoardFile;
import kr.withever.humanlibrary.domain.board.BoardSearch;
import kr.withever.humanlibrary.service.BoardService;
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

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView retrieveBoardList(BoardSearch search) {

		String searchOption = search.getSearchOption();
		String Keyword = search.getKeyword();

		if (searchOption != null || Keyword != null) {

			if (searchOption.equals("subject")) {
				search.setSubject(Keyword);
			} else if (searchOption.equals("contents")) {
				search.setContents(Keyword);
			}
		}

		BoardSearch boardSearch = this.boardService.retrieveBoardBySearch(search);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/list");
		mav.addObject("searchModel", boardSearch);
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView retreiveBoard(@PathVariable(value = "id") Long id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/detail");
		mav.addObject("board", this.boardService.retrieveBoard(id));
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

		List<BoardFile> boardFileList = new ArrayList<BoardFile>();

		String filePath = mhsq.getSession().getServletContext().getRealPath("/WEB-INF/file/");

		System.out.println("filePath:" + filePath);

		File dir = new File(filePath);

		if (!dir.isDirectory()) { // 폴더가 없을시 만듬

			dir.mkdirs();

		}

		Long userId = 2L; // loginUser사용

		board.setUserId(userId);

		Long boardId = this.boardService.retrieveBoardId();

		// 넘어온 파일을 리스트로 저장
		List<MultipartFile> mf = mhsq.getFiles("image");

		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

			this.boardService.createBoard(board);

		} else {
			for (int i = 0; i < mf.size(); i++) {

				// 본래 파일명
				String originalfileName = mf.get(i).getOriginalFilename();

				if (!originalfileName.equals("")) {

					String suffix = originalfileName.substring(originalfileName.lastIndexOf(".") + 1, originalfileName.length());
					
					String fileName = originalfileName.substring(0, originalfileName.lastIndexOf("."));

					String saveFileName = boardId + 1L+"_"+i + "_" + fileName;
					// 저장되는 파일 이름

					String savePath = filePath + saveFileName+"."+suffix; // 저장 될 파일 경로

					long fileSize = mf.get(i).getSize(); // 파일 사이즈


					String relativePath = filePath;

					BoardFile boardFile = new BoardFile();
					boardFile.setFileName(saveFileName);
					boardFile.setSuffix(suffix);
					boardFile.setRelativePath(relativePath);
					boardFile.setBoardId(boardId + 1L);

					boardFileList.add(boardFile);

					board.setBoardFileList(boardFileList);
					mf.get(i).transferTo(new File(savePath)); // 파일 저장
				}

			}

			this.boardService.createBoard(board);

		}

		response.sendRedirect("/board");

	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView showModifyBoardForm(@PathVariable(value = "id") Long id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/edit");
		mav.addObject("board", this.boardService.retrieveBoard(id));
		return mav;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView modifyBoard(HttpServletResponse response, MultipartHttpServletRequest mhsq, Board board) throws IllegalStateException, IOException {
		ModelAndView mav = new ModelAndView();
		
		Long boardid = board.getId();
		boardService.modifyBoard(board);
		
		List<BoardFile> boardFileList = new ArrayList<BoardFile>();

		String filePath = mhsq.getSession().getServletContext().getRealPath("/WEB-INF/file/");

		System.out.println("filePath:" + filePath);

		File dir = new File(filePath);

		if (!dir.isDirectory()) { // 폴더가 없을시 만듬

			dir.mkdirs();

		}

		Long boardId = board.getId();

		// 넘어온 파일을 리스트로 저장
		List<MultipartFile> mf = mhsq.getFiles("image");

		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

			boardService.modifyBoard(board);

		} else {
			for (int i = 0; i < mf.size(); i++) {

				// 본래 파일명
				String originalfileName = mf.get(i).getOriginalFilename();

				if (!originalfileName.equals("")) {

					String suffix = originalfileName.substring(originalfileName.lastIndexOf(".") + 1, originalfileName.length());
					
					String fileName = originalfileName.substring(0, originalfileName.lastIndexOf("."));

					String saveFileName = boardId + 1L+"_"+i + "_" + fileName;
					// 저장되는 파일 이름

					String savePath = filePath + saveFileName+"."+suffix; // 저장 될 파일 경로

					long fileSize = mf.get(i).getSize(); // 파일 사이즈


					String relativePath = filePath;

					BoardFile boardFile = new BoardFile();
					boardFile.setFileName(saveFileName);
					boardFile.setSuffix(suffix);
					boardFile.setRelativePath(relativePath);
					boardFile.setBoardId(boardId);

					boardFileList.add(boardFile);

					board.setBoardFileList(boardFileList);
					mf.get(i).transferTo(new File(savePath)); // 파일 저장
				}

			}

			boardService.modifyBoard(board);

		}

		mav.setViewName("/board/detail");
		mav.addObject("board", this.boardService.retrieveBoard(boardid));
		return mav;
		
	}

	@RequestMapping(value = "/boardFileDown.do/{id}/{fileName}", method = RequestMethod.GET)
	public void boardFileDown(@PathVariable(value = "id") Long id, @PathVariable(value = "fileName") String fileName,
			HttpServletRequest req, HttpServletResponse resp) {

		BoardFile boardFile = new BoardFile();
		boardFile.setBoardId(id);
		boardFile.setFileName(fileName);

		List<BoardFile> boardFileList = boardService.retrieveBoardFile(boardFile);
		boardFile = boardFileList.get(0);

		OutputStream outputStream = null;
		String relativePath = boardFile.getRelativePath();
		fileName = boardFile.getFileName();
		String suffix = boardFile.getSuffix();

		String uploadPath = relativePath + fileName + "." + suffix;

		try {
			File file = new File(uploadPath);

			if (suffix.trim().equalsIgnoreCase("txt")) {
				resp.setContentType("text/plain");
			} else {
				resp.setContentType("application/octet-stream");
			}

			resp.setContentLength((int) file.length());

			boolean ie = req.getHeader("User-Agent").indexOf("MSIE") != -1;
			if (ie) {
				fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", " ");
			} else {
				fileName = new String(fileName.getBytes("UTF-8"), "8859_1");
			}

			resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "." + suffix + "\"");

			outputStream = resp.getOutputStream();
			FileInputStream fis = null;

			try {
				fis = new FileInputStream(file);
				FileCopyUtils.copy(fis, outputStream);
			} finally {
				if (fis != null) {
					fis.close();
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				outputStream.close();
				resp.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
