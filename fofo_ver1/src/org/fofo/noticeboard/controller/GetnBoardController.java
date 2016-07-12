package org.fofo.noticeboard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fofo.board.dao.NoticeBoardDAO;
import org.fofo.board.dao.NoticeCommentDAO;
import org.fofo.board.vo.NoticeComment;
import org.fofo.board.vo.NoticePost;
import org.fofo.common.Controller;
import org.fofo.member.dao.MemberDAOImpl;

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
		
		MemberDAOImpl mdao = new MemberDAOImpl();
		HttpSession session = request.getSession();
		String postUserName = "";
		try {
			 postUserName = mdao.getNick(noticepost.getUserId());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("PostUserName", postUserName);
		session.setAttribute("PostUserId", noticepost.getUserId());
		
		request.setAttribute("noticepost", noticepost);
		
		return "/noticeboard/read.jsp";
	}

}