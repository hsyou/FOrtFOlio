package org.fofo.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.common.Controller;
import org.fofo.member.dao.MemberDAOImpl;
import org.fofo.member.vo.Member;

public class DoJoinController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String returnURL = "/home.jsp";
		int result=0;
		MemberDAOImpl dao = new MemberDAOImpl();
		Member vo = new Member();
		
		vo.setuNickname(request.getParameter("name"));
		vo.setuEmail(request.getParameter("email"));
		vo.setuPw(request.getParameter("pw"));

		try {
			result=dao.doJoin(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==1){//중복이 아닐 경우
			request.setAttribute("join", "success");
			returnURL="/home.jsp";
		}else{//중복
			request.setAttribute("join", "error");
			returnURL="/user/register.jsp";
		}

		return returnURL;
	}

}
