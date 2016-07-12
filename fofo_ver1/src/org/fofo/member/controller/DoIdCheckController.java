package org.fofo.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.common.Controller;
import org.fofo.member.dao.MemberDAOImpl;
import org.fofo.member.vo.Member;

public class DoIdCheckController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String returnURL = "/user/register.jsp";
		int result=-1;
		MemberDAOImpl dao = new MemberDAOImpl();
		Member vo = new Member();
	
		vo.setuEmail(request.getParameter("uId"));
		
		try {
			result=dao.doIdCheck(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return returnURL;
	}

}
