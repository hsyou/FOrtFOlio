package org.fofo.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fofo.common.Controller;
import org.fofo.member.dao.MemberDAOImpl;
import org.fofo.member.vo.Member;
import org.fofo.member.vo.Resume;

public class ListAllController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String returnURL = "/user/profile.jsp";
		
		MemberDAOImpl dao = new MemberDAOImpl();
		Member vo = new Member();
		Resume rVo=new Resume();
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("email");
		int uid=(Integer)session.getAttribute("uid");
		System.out.println("현재 세션:"+email);
		vo.setuEmail(email);
		vo.setUserId(uid);
		
		
		try {
			vo=dao.listAll(vo);
			rVo=dao.listResume(vo);
			request.setAttribute("data", vo);
			request.setAttribute("resume", rVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return returnURL;
	}

}
