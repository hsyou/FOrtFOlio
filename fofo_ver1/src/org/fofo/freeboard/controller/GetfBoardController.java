package org.fofo.freeboard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fofo.board.dao.FreeBoardDAO;
import org.fofo.board.dao.FreeCommentDAO;
import org.fofo.board.vo.FreeComment;
import org.fofo.board.vo.FreePost;
import org.fofo.common.Controller;
import org.fofo.member.dao.MemberDAOImpl;
import org.fofo.member.vo.Member;

public class GetfBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		FreeBoardDAO dao = new FreeBoardDAO();
		FreePost freepost = new FreePost();
		
		freepost.setfPostId(Integer.parseInt(request.getParameter("fPostId")));
		dao.doGetBoard(freepost);
		
		FreeCommentDAO cdao = new FreeCommentDAO();
		FreeComment freecomment = new FreeComment();
		
		freecomment.setfPostId(Integer.parseInt(request.getParameter("fPostId")));
		ArrayList<FreeComment> clist = cdao.doListComment(freecomment);
		
		request.setAttribute("clist", clist);
		System.out.println(clist);
		
		MemberDAOImpl mdao = new MemberDAOImpl();
		HttpSession session = request.getSession();
		String postUserName = "";
		try {
			 postUserName = mdao.getNick(freepost.getUserId());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("PostUserName", postUserName);
		session.setAttribute("PostUserId", freepost.getUserId());
		
		request.setAttribute("freepost", freepost);
		
		return "/freeboard/read.jsp";
	}

}