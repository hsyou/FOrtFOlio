package org.fofo.message.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.common.Controller;
import org.fofo.message.dao.MessageDAO;
import org.fofo.message.vo.Message;

public class GetMessageListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MessageDAO dao = new MessageDAO();
		ArrayList<Message> list = dao.doListMessage();

		request.setAttribute("list", list);
		
		return "/message/messageAll.jsp";
	}
}