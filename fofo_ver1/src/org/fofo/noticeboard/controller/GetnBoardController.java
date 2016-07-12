package org.fofo.noticeboard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.dao.NoticeBoardDAO;
import org.fofo.board.dao.NoticeCommentDAO;
import org.fofo.board.vo.NoticeComment;
import org.fofo.board.vo.NoticePost;
import org.fofo.common.Controller;

public class GetnBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		NoticeBoardDAO dao = new NoticeBoardDAO();
		NoticePost noticepost = new NoticePost();
		
		noticepost.setnPostId(Integer.parseInt(request.getParameter("nPostId")));
		dao.doGetBoard(noticepost);
		
		NoticeCommentDAO cdao = new NoticeCommentDAO();
		NoticeComment noticecomment = new NoticeComment();
		
		noticecomment.setnPostId(Integer.parseInt(request.getParameter("nPostId")));
		ArrayList<NoticeComment> clist = cdao.doListComment(noticecomment);
		
		request.setAttribute("clist", clist);
		System.out.println(clist);
		
		request.setAttribute("noticepost", noticepost);
		
		return "/noticeboard/read.jsp";
	}

}