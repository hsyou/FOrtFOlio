package org.fofo.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.common.Controller;
import org.fofo.member.vo.Member;
import org.fofo.project.dao.ProjectDAOImpl;
import org.fofo.project.vo.Project;

public class LoadProjectContentController implements Controller{


	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String returnURL = "/project/openedProject.jsp";
		
		ProjectDAOImpl dao = new ProjectDAOImpl();
		
		Project project = new Project();
//		Member member = new Member();

		/*member.setUserId(Integer.parseInt(request.getParameter("userId")));
		project.setProjectName(request.getParameter("projectName"));*/
		
		project.setProjectId(Integer.parseInt(request.getParameter("projectId")));
		
		
		try{
			dao.doGetProjectContent(project);

			
//			PrintWriter out = response.getWriter();
//			out.println(project.getProjectContent());
			
			request.setAttribute("projectContent", project.getProjectContent());
			
			System.out.println("content >> " + project.getProjectContent());
			
			
		}catch(Exception e){
			System.out.println("loading project content occured an ERROR");
			e.printStackTrace();
		}finally{
			
			
		}
		
		
		
		
		
		return returnURL;
	}

}
