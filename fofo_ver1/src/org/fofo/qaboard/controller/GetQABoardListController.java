package org.fofo.qaboard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.dao.QABoardDAO;
import org.fofo.board.vo.QAPost;
import org.fofo.common.Controller;

public class GetQABoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		QABoardDAO dao = new QABoardDAO();
		ArrayList<QAPost> list = dao.doListBoard();

		request.setAttribute("list", list);
		
		return "/qaboard/qalist.jsp";
	}
}