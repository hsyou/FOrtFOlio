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


public class GetProjectEditorController implements Controller{

	public GetProjectEditorController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String returnURL = "/project/project.jsp";
		
		/*ProjectDAOImpl dao = new ProjectDAOImpl();
		Project project = new Project();*/
		
//		project.setProjectTitle(request.getParameter("title"));
//		project.setUserId(Integer.parseInt(request.getParameter("title")));

		
		ProjectDAOImpl dao = new ProjectDAOImpl();
		Member member = new Member();

		member.setUserId(123);
		try{
			ArrayList<Project> list = dao.doListAll(member);

			request.setAttribute("projectList", list);
			
			
			/*for(Project i : list){
				System.out.println(i.getProjectName());
			}*/
			
//			request.setAttribute("test", "this is test2");
			
		}catch(Exception e){
			System.out.println("get project editor occured an ERROR");
			e.printStackTrace();
		}finally{
			
			
		}
		
		
		/*try {
			dao.doAddProject(project);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		return returnURL;
	}

}
