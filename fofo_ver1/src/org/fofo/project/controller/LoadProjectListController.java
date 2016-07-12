package org.fofo.project.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.common.Controller;
import org.fofo.member.vo.Member;
import org.fofo.project.dao.ProjectDAOImpl;
import org.fofo.project.vo.Project;


public class LoadProjectListController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String returnURL = "/project/projectList.jsp";
		
		ProjectDAOImpl dao = new ProjectDAOImpl();
		Member member = new Member();
		
		member.setUserId(Integer.parseInt(request.getParameter("userId")));
		try{
			ArrayList<Project> list = dao.doListAll(member);

			request.setAttribute("projectList", list);

			
		}catch(Exception e){
			System.out.println("get project editor occured an ERROR");
			e.printStackTrace();
		}finally{
			
			
		}
		
		
		
		
		
		return returnURL;
	}

}
