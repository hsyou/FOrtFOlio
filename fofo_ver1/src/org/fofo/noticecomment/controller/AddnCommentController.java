package org.fofo.noticecomment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		noticecomment.setUserId(Integer.parseInt(session.getAttribute("uid").toString()));
		noticecomment.setUserNick((session.getAttribute("nickname").toString()));
		noticecomment.setnPostId(Integer.parseInt(request.getParameter("nPostId")));
		noticecomment.setnCommentContent(request.getParameter("nCommentContent"));
		
		dao.doAddComment(noticecomment);
		
		return "/getnoticeboard.do";
	}
}