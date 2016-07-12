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

public class ModifyfCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		FreeCommentDAO dao = new FreeCommentDAO();
		FreeComment freecomment = new FreeComment();

		freecomment.setfPostId(Integer.parseInt(request.getParameter("fPostId")));
		freecomment.setfCommentId(Integer.parseInt(request.getParameter("fCommentId")));
		freecomment.setfCommentContent(request.getParameter("fCommentContent"));
		
		request.setAttribute("fPostId", freecomment.getfPostId());
		request.setAttribute("fCommentId", freecomment.getfCommentId());
		request.setAttribute("fCommentContent", freecomment.getfCommentContent());
		
		dao.doUpdateComment(freecomment);
		
		return "/getfreeboard.do?fPostId="+freecomment.getfPostId();
	}
}