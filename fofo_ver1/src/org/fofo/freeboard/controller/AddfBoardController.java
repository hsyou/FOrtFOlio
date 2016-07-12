package org.fofo.freeboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fofo.board.dao.FreeBoardDAO;
import org.fofo.board.vo.FreePost;
import org.fofo.common.Controller;

public class AddfBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		FreeBoardDAO dao = new FreeBoardDAO();
		FreePost freepost = new FreePost();
		
		request.setCharacterEncoding("utf-8");
		freepost.setfPostTitle(request.getParameter("title"));
		freepost.setfPostContent(request.getParameter("content"));
		HttpSession session = request.getSession();
		freepost.setUserId(Integer.parseInt(session.getAttribute("uid").toString()));
		freepost.setfTags(request.getParameter("tags"));
		
		dao.doAddBoard(freepost);
		
		return "/freeboard.do";
	}
}