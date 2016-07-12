package org.fofo.freeboard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.dao.FreeBoardDAO;
import org.fofo.board.vo.FreePost;
import org.fofo.common.Controller;

public class GetfBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FreeBoardDAO dao = new FreeBoardDAO();
		ArrayList<FreePost> list = dao.doListBoard();

		request.setAttribute("list", list);
		
		return "/freeboard/listAll.jsp";
	}
}



