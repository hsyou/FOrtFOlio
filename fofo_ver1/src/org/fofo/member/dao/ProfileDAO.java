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
import org.fofo.member.vo.Resume;
import org.fofo.member.vo.School;
import org.fofo.member.vo.Skill;

public class ProfileDAO {

	private static String editSchoolSQL="UPDATE resume SET school=? WHERE userId=?";
	private static String editSkillSQL="UPDATE resume SET skill=? WHERE userId=?";
	private static String editCareerSQL="UPDATE resume SET career=? WHERE userId=?";
	private static String editAwardSQL="UPDATE resume SET award=? WHERE userId=?";
	private static String editLanguageSQL="UPDATE resume SET language=? WHERE userId=?";
	
	private static String editFullNameSQL="UPDATE resume SET name=? WHERE userId=?";
	private static String editEngNameSQL="UPDATE resume SET engName=? WHERE userId=?";
	private static String editBirthSQL="UPDATE resume SET birth=? WHERE userId=?";
	private static String editNickNameSQL="UPDATE user SET nickname=? WHERE userId=?";
	
	public ProfileDAO(){
		 
	}
	
	public int editSchool (Member vo,Resume rVo){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;
		
		try{
		
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(editSchoolSQL);
			stmt.setString(1, rVo.getSchool());
			stmt.setInt(2, vo.getUserId());
			
		
			int cnt = stmt.executeUpdate();	
			
			if(cnt == 1){
				System.out.println("update school success");
				result=1;
			}else{
				System.out.println("update school failed");
			}
			
		}catch(SQLException e){
			System.out.println("update occured an ERROR");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}		
		
		return result;
	}
	public int editSkill (Member vo,Resume rVo){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;
		
		try{
		
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(editSkillSQL);
			stmt.setString(1, rVo.getSkill());
			stmt.setInt(2, vo.getUserId());
			
		
			int cnt = stmt.executeUpdate();	
			
			if(cnt == 1){
				System.out.println("update skill success");
				result=1;
			}else{
				System.out.println("update skill failed");
			}
			
		}catch(SQLException e){
			System.out.println("update occured an ERROR");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}		
		
		return result;
	}
	public int editCareer (Member vo,Resume rVo){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;
		
		try{
		
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(editCareerSQL);
			stmt.setString(1, rVo.getCareer());
			stmt.setInt(2, vo.getUserId());
			
		
			int cnt = stmt.executeUpdate();	
			
			if(cnt == 1){
				System.out.println("update career success");
				result=1;
			}else{
				System.out.println("update career failed");
			}
			
		}catch(SQLException e){
			System.out.println("update occured an ERROR");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}		
		
		return result;
	}
	public int editAward (Member vo,Resume rVo){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;
		
		try{
		
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(editAwardSQL);
			stmt.setString(1, rVo.getAward());
			stmt.setInt(2, vo.getUserId());
			
		
			int cnt = stmt.executeUpdate();	
			
			if(cnt == 1){
				System.out.println("update award success");
				result=1;
			}else{
				System.out.println("update award failed");
			}
			
		}catch(SQLException e){
			System.out.println("update occured an ERROR");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}		
		
		return result;
	}
	public int editLanguage (Member vo,Resume rVo){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;
		
		try{
		
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(editLanguageSQL);
			stmt.setString(1, rVo.getLanguage());
			stmt.setInt(2, vo.getUserId());
			
		
			int cnt = stmt.executeUpdate();	
			
			if(cnt == 1){
				System.out.println("update language success");
				result=1;
			}else{
				System.out.println("update language failed");
			}
			
		}catch(SQLException e){
			System.out.println("update occured an ERROR");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}		
		
		return result;
	}



	public int editFullName (Member vo,Resume rVo){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;
		
		try{
		
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(editFullNameSQL);
			stmt.setString(1, rVo.getName());
			stmt.setInt(2, vo.getUserId());
			
		
			int cnt = stmt.executeUpdate();	
			
			if(cnt == 1){
				System.out.println("update name success");
				result=1;
			}else{
				System.out.println("update name failed");
			}
			
		}catch(SQLException e){
			System.out.println("update occured an ERROR");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}		
		
		return result;
	}
	
	public int editEngName (Member vo,Resume rVo){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;
		
		try{
		
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(editEngNameSQL);
			stmt.setString(1, rVo.getEngName());
			stmt.setInt(2, vo.getUserId());
			
		
			int cnt = stmt.executeUpdate();	
			
			if(cnt == 1){
				System.out.println("update engname success");
				result=1;
			}else{
				System.out.println("update engname failed");
			}
			
		}catch(SQLException e){
			System.out.println("update occured an ERROR");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}		
		
		return result;
	}
	
	public int editBirth(Member vo,Resume rVo){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;
		
		try{
		
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(editBirthSQL);
			stmt.setString(1, rVo.getBirth());
			stmt.setInt(2, vo.getUserId());
			
		
			int cnt = stmt.executeUpdate();	
			
			if(cnt == 1){
				System.out.println("update birth success");
				result=1;
			}else{
				System.out.println("update birth failed");
			}
			
		}catch(SQLException e){
			System.out.println("update occured an ERROR");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}		
		
		return result;
	}
	
	public int editNickName (Member vo){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;
		
		try{
		
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(editNickNameSQL);
			stmt.setString(1, vo.getuNickname());
			stmt.setInt(2, vo.getUserId());
			
		
			int cnt = stmt.executeUpdate();	
			
			if(cnt == 1){
				System.out.println("update nickname success");
				result=1;
			}else{
				System.out.println("update nickname failed");
			}
			
		}catch(SQLException e){
			System.out.println("update occured an ERROR");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}		
		
		return result;
	}
}
