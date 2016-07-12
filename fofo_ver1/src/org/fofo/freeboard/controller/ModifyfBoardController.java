package org.fofo.freeboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.dao.FreeBoardDAO;
import org.fofo.board.vo.FreePost;
import org.fofo.common.Controller;

public class ModifyfBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		FreeBoardDAO dao = new FreeBoardDAO();
		FreePost freepost = new FreePost();
		
		freepost.setfPostId(Integer.parseInt(request.getParameter("fpostid")));
		freepost.setfPostTitle(request.getParameter("title"));
		freepost.setfPostContent(request.getParameter("content"));
		freepost.setfTags(request.getParameter("tags"));
		
		dao.doUpdateBoard(freepost);
		
		return "/freeboard.do";
	}
}