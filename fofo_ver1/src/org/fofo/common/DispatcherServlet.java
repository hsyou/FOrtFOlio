package org.fofo.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberDispatcherServlet
 */
@WebServlet("/MemberDispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring( uri.lastIndexOf("/"));
		System.out.println("connected");
		System.out.println("uri : " + uri);
		System.out.println("path: " + path);
		
		String returnURL = "/home.jsp";	
		
		HandlerMapping mappings = new HandlerMapping();	
		Controller controller = mappings.getController(path);
		
		if(controller != null){
			returnURL = controller.handleRequest(request, response);
		}
		
			RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
			dispatcher.forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}