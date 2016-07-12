package org.fofo.noticeboard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.dao.NoticeBoardDAO;
import org.fofo.board.vo.NoticePost;
import org.fofo.common.Controller;

public class GetnBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		NoticeBoardDAO dao = new NoticeBoardDAO();
		ArrayList<NoticePost> list = dao.doListBoard();

		request.setAttribute("list", list);
		
		return "/noticeboard/listAll.jsp";
	}
}



