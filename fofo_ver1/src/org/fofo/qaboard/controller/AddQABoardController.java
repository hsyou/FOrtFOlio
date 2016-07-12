package org.fofo.qaboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.dao.QABoardDAO;
import org.fofo.board.vo.QAPost;
import org.fofo.common.Controller;

public class AddQABoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		QABoardDAO dao = new QABoardDAO();
		QAPost qapost = new QAPost();
		
		qapost.setqaPostTitle(request.getParameter("title"));
		qapost.setqaPostContent(request.getParameter("writer"));
		qapost.setUserId(Integer.parseInt(request.getParameter("content")));
		
		dao.doAddBoard(qapost);
		
		return "/getQABoardList.do";
	}

}
