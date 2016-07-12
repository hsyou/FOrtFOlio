package org.fofo.message.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.vo.FreeComment;
import org.fofo.common.Controller;
import org.fofo.message.dao.MessageDAO;
import org.fofo.message.vo.Message;

public class GetMessageController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MessageDAO dao = new MessageDAO();
		Message message = new Message();
		
		System.out.println("보낸이 : "+request.getParameter("SuserId"));
		System.out.println("받은이 : "+request.getParameter("RuserId"));
		
		message.setSuserId(Integer.parseInt(request.getParameter("SuserId")));
		message.setRuserId(Integer.parseInt(request.getParameter("RuserId")));
		ArrayList<Message> mlist = dao.doGetMessage(message.getSuserId(), message.getRuserId());

		request.setAttribute("mlist", mlist);
		request.setAttribute("SuserId", message.getSuserId());
		request.setAttribute("RuserId", message.getRuserId());
		//request.setAttribute("RuserId", message.getRuserId());
		
		return "/message/messageRead.jsp";
	}
}