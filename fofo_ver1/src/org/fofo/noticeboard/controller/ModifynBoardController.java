package org.fofo.noticeboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.dao.NoticeBoardDAO;
import org.fofo.board.vo.NoticePost;
import org.fofo.common.Controller;

public class ModifynBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		NoticeBoardDAO dao = new NoticeBoardDAO();
		NoticePost noticepost = new NoticePost();
		
		noticepost.setnPostId(Integer.parseInt(request.getParameter("nPostId")));
		noticepost.setnPostTitle(request.getParameter("title"));
		noticepost.setnPostContent(request.getParameter("content"));
		noticepost.setnTags(request.getParameter("tags"));
		
		dao.doUpdateBoard(noticepost);
		
		return "/noticeboard.do";
	}
}