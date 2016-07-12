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
import org.fofo.member.vo.School;
import org.fofo.member.vo.Skill;

public class EditProfileController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String returnURL = "/home.jsp";
		int result=0;
		MemberDAOImpl dao = new MemberDAOImpl();
		Member vo = new Member();
		School sVo = new School();
		Career cVo= new Career();
		Award aVo=new Award();
		Language lVo=new Language();
		Skill skVo=new Skill();
		
		ProfileDAO pDao = new ProfileDAO();
		HttpSession session=request.getSession();
		
		
		String email=(String) session.getAttribute("email");
		int uid=(int) session.getAttribute("uid");
		
		String action=request.getParameter("formName");

		vo.setuEmail(email);
		try {
			switch(action){
			
			case "school":
				sVo.setSchoolName(request.getParameter("schoolName"));
				sVo.setDegree(request.getParameter("degree"));
				sVo.setMajor(request.getParameter("major"));
				sVo.setEntrance(Integer.parseInt(request.getParameter("entrance")));
				sVo.setGraduation(Integer.parseInt(request.getParameter("graduation")));
				pDao.addSchool(vo, sVo);
				System.out.println("DAO : school");
				System.out.println("SchoolID : "+request.getParameter("schoolId"));
				System.out.println("Degree : "+request.getParameter("degree"));
				System.out.println("Major : "+request.getParameter("major"));
				System.out.println("Entrance ~ Graduation : "+request.getParameter("entrance")+" ~ "+request.getParameter("graduation"));
				break;
				
			case "career":
				
				cVo.setCareerName(request.getParameter("careerName"));
				cVo.setPosition(request.getParameter("position"));
				pDao.addCareer(vo, cVo);
				//cVo.setStartDate(request.getParameter("startDate"));
				//integer 
				//cVo.setEndDate(request.getParameter("endDate"));
				
				System.out.println("DAO : career");
				System.out.println("CareerId : "+request.getParameter("careerId"));
				System.out.println("Position : "+request.getParameter("position"));
				System.out.println("Start , End date : "+request.getParameter("startDate") +" to " +request.getParameter("endDate"));
				break;

			case "skill":
				
				skVo.setSkillName(request.getParameter("skillName"));
				skVo.setSkillComment(request.getParameter("skillComment"));
				pDao.addSkill(vo, skVo);
				System.out.println("DAO : skill");
				System.out.println("Skill : "+request.getParameter("skillId"));
				System.out.println("Level : "+request.getParameter("level"));
				break;

			case "award":
				//dao.addAward(vo);
				aVo.setAwardName(request.getParameter("awardName"));
				aVo.setAwardComment(request.getParameter("awardComment"));
				pDao.addAward(vo, aVo);
				System.out.println("DAO : award");
				System.out.println("Award Name : "+request.getParameter("awardName"));
				System.out.println("Institution : "+request.getParameter("institution"));
				System.out.println("Award Date : "+request.getParameter("awardDate"));
				
				break;

			case "language":
				//dao.addLanguage(vo);
				lVo.setLanguageName(request.getParameter("languageName"));
				lVo.setLanguageComment(request.getParameter("langaugeComment"));
				pDao.addLanguage(vo, lVo);
				
				System.out.println("DAO : language");
				System.out.println("Language Name : "+request.getParameter("languageName"));
				
				break;
				
			default:
				System.out.println("DAO : ??");
				break;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==0){
			returnURL="/user/editProfile.jsp";
		}

		return returnURL;
	}

}
