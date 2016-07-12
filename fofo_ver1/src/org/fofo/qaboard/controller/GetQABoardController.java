package org.fofo.qaboard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.dao.QABoardDAO;
import org.fofo.board.dao.QACommentDAO;
import org.fofo.board.vo.QAPost;
import org.fofo.board.vo.QAComment;
import org.fofo.common.Controller;

public class GetQABoardController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		QABoardDAO dao = new QABoardDAO();
		QAPost qapost = new QAPost();
		
		qapost.setqaPostId(Integer.parseInt(request.getParameter("qaPostId")));
		dao.doGetBoard(qapost);
		
		QACommentDAO cdao = new QACommentDAO();
		QAComment qacomment = new QAComment();
		
		qacomment.setqaPostId(Integer.parseInt(request.getParameter("qaPostId")));
		ArrayList<QAComment> clist = cdao.doListComment(qacomment);
		
		request.setAttribute("clist", clist);
		System.out.println(clist);
		
		request.setAttribute("qapost", qapost);
		
		return "/qaboard/qaRead.jsp";
	}

}
