package org.fofo.noticeboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.dao.NoticeBoardDAO;
import org.fofo.board.vo.NoticePost;
import org.fofo.common.Controller;

public class AddnBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		NoticeBoardDAO dao = new NoticeBoardDAO();
		NoticePost noticepost = new NoticePost();
		
		request.setCharacterEncoding("utf-8");
		noticepost.setnPostTitle(request.getParameter("title"));
		noticepost.setnPostContent(request.getParameter("content"));
		noticepost.setUserId(Integer.parseInt(request.getParameter("writer")));
		noticepost.setnTags(request.getParameter("tags"));
		
		dao.doAddBoard(noticepost);
		
		return "/noticeboard.do";
	}
}