package org.fofo.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.fofo.common.JDBCUtil;
import org.fofo.member.vo.Award;
import org.fofo.member.vo.Career;
import org.fofo.member.vo.Language;
import org.fofo.member.vo.Member;
import org.fofo.member.vo.School;
import org.fofo.member.vo.Skill;

public class ProfileDAO {

	private static String addSchoolSQL="UPDATE user SET uSchoolIds=? WHERE uEmail=?";
	private static String addMySchoolSQL="INSERT INTO myschool(mySchoolId) VALUES(?)";
	private static String addMySkillSQL="INSERT INTO myskill(userId,skillId,level,levelComment) VALUES(?, ?, ?, ?)";
	private static String addMyCareerSQL="INSERT INTO mycareer(userId,careerId,position,startDate,endDate) VALUES(?, ?, ?, ?, ?)";
	private static String addAwardSQL="INSERT INTO award(userId,institution,awardName,awardDate) VALUES(?,?,?,?)";
	private static String addLanguageSQL="INSERT INTO mylanguage(userId,languageId,level) VALUES(?, ?, ?)";
	
	public ProfileDAO(){
		 
	}

	public int addSchool (Member vo,School sVo){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;
		
		try{
		
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(addSchoolSQL);
			//stmt.setString(1, vo.getUSchoolIds());
			//stmt.setString(2, vo.getuEmail());
			//디비 정리
			
			int cnt = stmt.executeUpdate();	
			
			if(cnt == 1){
				System.out.println("update had succeed");
				result=1;
			}else{
				System.out.println("update had failed");
			}
			
		}catch(SQLException e){
			System.out.println("update occured an ERROR");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		
		try{
			
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(addMySchoolSQL);
		//	stmt.setInt(1, sVo.getMySchoolId());
			
			int cnt = stmt.executeUpdate();	
			
			if(cnt == 1){
				System.out.println("insert had succeed");
				result=1;
			}else{
				System.out.println("insert had failed");
			}
			
		}catch(SQLException e){
			System.out.println("insert occured an ERROR");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		
		
		return result;
	}
	public int addSkill (Member vo,Skill sVo){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;
		
		try{
		
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(addMySkillSQL);
		//	stmt.setInt(1, vo.getUserId());
			stmt.setInt(2, sVo.getSkillId());
			//stmt.setString(3, sVo.getLevel());
			//stmt.setString(4, sVo.getLevelComment());
			
			int cnt = stmt.executeUpdate();	
			
			if(cnt == 1){
				System.out.println("insert had succeed");
				result=1;
			}else{
				System.out.println("insert had failed");
			}
			
		}catch(SQLException e){
			System.out.println("insert occured an ERROR");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		
		return result;
	}
	public int addLanguage (Member vo,Language lVo){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;

		
		try{
			
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(addLanguageSQL);
		//	stmt.setInt(1, vo.getUserId());
		//	stmt.setInt(2, lVo.getLanguageId());
			//stmt.setString(3, lVo.getLevel());
	
			int cnt = stmt.executeUpdate();	
			
			if(cnt == 1){
				System.out.println("update had succeed");
				result=1;
			}else{
				System.out.println("update had failed");
			}
			
		}catch(SQLException e){
			System.out.println("update occured an ERROR");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		
		
		return result;
	}
	public int addCareer (Member vo,Career cVo){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;
		
		try{
		
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(addMyCareerSQL);
		//	stmt.setInt(1, vo.getUserId());
			stmt.setInt(2, cVo.getCareerId());
			stmt.setString(3, cVo.getPosition());
		//	stmt.setString(4, cVo.getStartDate());
		//	stmt.setString(5, cVo.getEndDate());
			
			int cnt = stmt.executeUpdate();	
			
			if(cnt == 1){
				System.out.println("insert had succeed");
				result=1;
			}else{
				System.out.println("insert had failed");
			}
			
		}catch(SQLException e){
			System.out.println("insert occured an ERROR");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		
		return result;
	}
	public int addAward (Member vo,Award aVo){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;
		
		try{
		
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(addAwardSQL);
		//	stmt.setInt(1, vo.getUserId());
		//	stmt.setString(2, aVo.getInstitution());
		//	stmt.setString(3, aVo.getAwardName());
		//	stmt.setString(4, aVo.getAwardDate());
			
			int cnt = stmt.executeUpdate();	
			
			if(cnt == 1){
				System.out.println("insert had succeed");
				result=1;
			}else{
				System.out.println("insert had failed");
			}
			
		}catch(SQLException e){
			System.out.println("insert occured an ERROR");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		
		return result;
	}
}
