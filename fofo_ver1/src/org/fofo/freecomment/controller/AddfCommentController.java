package org.fofo.freecomment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.dao.FreeBoardDAO;
import org.fofo.board.dao.FreeCommentDAO;
import org.fofo.board.vo.FreeComment;
import org.fofo.board.vo.FreePost;
import org.fofo.common.Controller;

public class AddfCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		FreeCommentDAO dao = new FreeCommentDAO();
		FreeComment freecomment = new FreeComment();
		
		request.setCharacterEncoding("utf-8");
		freecomment.setfPostId(Integer.parseInt(request.getParameter("fPostId")));
		freecomment.setUserId(Integer.parseInt(request.getParameter("userId")));
		freecomment.setfCommentContent(request.getParameter("fCommentContent"));
		
		dao.doAddComment(freecomment);
		
		return "/getfreeboard.do";
	}
}