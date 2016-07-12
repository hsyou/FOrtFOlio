package org.fofo.noticecomment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.dao.NoticeBoardDAO;
import org.fofo.board.dao.NoticeCommentDAO;
import org.fofo.board.vo.NoticeComment;
import org.fofo.board.vo.NoticePost;
import org.fofo.common.Controller;

public class RemovenCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		NoticeCommentDAO dao = new NoticeCommentDAO();
		NoticeComment noticecomment = new NoticeComment();
		
		//noticecomment.setfPostId(Integer.parseInt(request.getParameter("fPostId")));
		noticecomment.setnCommentId(Integer.parseInt(request.getParameter("nCommentId")));
		dao.doDeleteComment(noticecomment);
		
		return "/getnoticeboard.do";
	}
}