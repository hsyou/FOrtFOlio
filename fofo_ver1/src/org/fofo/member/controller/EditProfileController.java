package org.fofo.member.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fofo.common.Controller;
import org.fofo.member.dao.MemberDAOImpl;
import org.fofo.member.dao.ProfileDAO;
import org.fofo.member.vo.Award;
import org.fofo.member.vo.Career;
import org.fofo.member.vo.Language;
import org.fofo.member.vo.Member;
import org.fofo.member.vo.Resume;
import org.fofo.member.vo.School;
import org.fofo.member.vo.Skill;

public class EditProfileController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String returnURL = "/listAll.do";
		int result=0;
		MemberDAOImpl dao = new MemberDAOImpl();
		Member vo = new Member();
		/*School sVo = new School();
		Career cVo= new Career();
		Award aVo=new Award();
		Language lVo=new Language();
		Skill skVo=new Skill();*/
		Resume rVo=new Resume();
		
		ProfileDAO pDao = new ProfileDAO();
		HttpSession session=request.getSession();
		
		
		String email=(String) session.getAttribute("email");
		int uid=(int) session.getAttribute("uid");		
		String action=request.getParameter("formName");
		vo.setUserId(uid);
		vo.setuEmail(email);

		System.out.println("DAO :  "+action);
		try {
			switch(action){
			
			case "school":
				rVo.setSchool(request.getParameter("school"));
				pDao.editSchool(vo, rVo);
				break;
				
			case "career":
				
				rVo.setCareer(request.getParameter("career"));
				pDao.editCareer(vo, rVo);
				break;

			case "skill":
				
				rVo.setSkill(request.getParameter("skill"));
				pDao.editSkill(vo, rVo);
				break;

			case "award":
				rVo.setAward(request.getParameter("award"));
				pDao.editAward(vo, rVo);
				break;

			case "language":
				rVo.setLanguage(request.getParameter("language"));
				pDao.editLanguage(vo, rVo);
				
				break;
				
			case "fullName":
				
				rVo.setName(request.getParameter("fullName"));
				pDao.editFullName(vo, rVo);
				System.out.println("DAO : fullName");
				System.out.println("Full Name : "+request.getParameter("fullName"));
				
				break;
				
			case "engName":
				rVo.setEngName(request.getParameter("engName"));
				pDao.editEngName(vo, rVo);
				System.out.println("DAO : engName");
				System.out.println("English Name : "+request.getParameter("engName"));
				
				break;
				
			case "nickName": //member
				vo.setuNickname(request.getParameter("nickName"));
				pDao.editNickName(vo);
				System.out.println("DAO : nickName");
				System.out.println("NickName : "+request.getParameter("nickName"));
				
				break;
				
			case "birth":
				rVo.setBirth(request.getParameter("birth"));
				pDao.editBirth(vo, rVo);
				System.out.println("DAO : birth");
				System.out.println("birth : "+request.getParameter("birth"));
				
				break;
				
				
			default:
				System.out.println("DAO : ?? "+action);
				break;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return returnURL;
	}

}
