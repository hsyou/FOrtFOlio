package org.fofo.freecomment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.dao.FreeBoardDAO;
import org.fofo.board.dao.FreeCommentDAO;
import org.fofo.board.vo.FreeComment;
import org.fofo.board.vo.FreePost;
import org.fofo.common.Controller;

public class RemovefCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		FreeCommentDAO dao = new FreeCommentDAO();
		FreeComment freecomment = new FreeComment();
		
		//freecomment.setfPostId(Integer.parseInt(request.getParameter("fPostId")));
		freecomment.setfCommentId(Integer.parseInt(request.getParameter("fCommentId")));
		dao.doDeleteComment(freecomment);
		
		return "/getfreeboard.do";
	}
}