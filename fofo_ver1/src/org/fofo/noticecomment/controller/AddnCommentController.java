package org.fofo.noticecomment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.dao.NoticeBoardDAO;
import org.fofo.board.dao.NoticeCommentDAO;
import org.fofo.board.vo.NoticeComment;
import org.fofo.board.vo.NoticePost;
import org.fofo.common.Controller;

public class AddnCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		NoticeCommentDAO dao = new NoticeCommentDAO();
		NoticeComment noticecomment = new NoticeComment();
		
		request.setCharacterEncoding("utf-8");
		noticecomment.setnPostId(Integer.parseInt(request.getParameter("nPostId")));
		noticecomment.setUserId(Integer.parseInt(request.getParameter("userId")));
		noticecomment.setnCommentContent(request.getParameter("nCommentContent"));
		
		dao.doAddComment(noticecomment);
		
		return "/getnoticeboard.do";
	}
}