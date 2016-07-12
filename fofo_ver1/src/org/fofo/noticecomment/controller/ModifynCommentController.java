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

public class ModifynCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		NoticeCommentDAO dao = new NoticeCommentDAO();
		NoticeComment noticecomment = new NoticeComment();

		noticecomment.setnPostId(Integer.parseInt(request.getParameter("nPostId")));
		noticecomment.setnCommentId(Integer.parseInt(request.getParameter("nCommentId")));
		noticecomment.setnCommentContent(request.getParameter("nCommentContent"));
		
		request.setAttribute("nPostId", noticecomment.getnPostId());
		request.setAttribute("nCommentId", noticecomment.getnCommentId());
		request.setAttribute("nCommentContent", noticecomment.getnCommentContent());
		
		dao.doUpdateComment(noticecomment);
		
		return "/getnoticeboard.do?nPostId="+noticecomment.getnPostId();
	}
}