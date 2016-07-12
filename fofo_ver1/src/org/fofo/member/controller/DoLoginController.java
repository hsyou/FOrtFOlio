package org.fofo.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fofo.common.Controller;
import org.fofo.member.dao.MemberDAOImpl;
import org.fofo.member.vo.Member;

public class DoLoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String returnURL = "/home.jsp";
		
		MemberDAOImpl dao = new MemberDAOImpl();
		Member vo = new Member();
		
		vo.setuEmail(request.getParameter("email"));
		vo.setuPw(request.getParameter("pw"));
		
		try {
			vo=dao.doLogin(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(vo.getUserId()!= null){
			//로그인 성공시 세션
			HttpSession session = request.getSession();
			session.setAttribute("nickname", vo.getuNickname());
			session.setAttribute("email", vo.getuEmail());
			session.setAttribute("uid", vo.getUserId());
			System.out.println("login!");
			System.out.println("귀신이다!");
		}else{
			request.setAttribute("login", "invalid");
			returnURL="/user/login.jsp";
		}
		return returnURL;
	}

}
