package org.fofo.member.dao;

import org.fofo.member.vo.Member;
import org.fofo.member.vo.Resume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.fofo.common.JDBCUtil;

public class MemberDAOImpl implements MemberDAO{
	
	private static String doJoinSQL = "INSERT INTO user(nickname, email, pw) VALUES(?, ?, ?)";
	private static String createResumeSQL="INSERT INTO resume(userId) VALUES(?)";
	private static String doGetUserSQL = "SELECT * FROM user WHERE email = ?";
	private static String doGetResumeSQL="SELECT * FROM resume WHERE userId = ?";

	
	public MemberDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int doJoin(Member vo) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;
		int joinResult=0;
		result=doIdCheck(vo);
		
		
		if(result==1){// 중복이 아닐 경우 실행
			try{
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(doJoinSQL);
				stmt.setString(1, vo.getuNickname());
				stmt.setString(2, vo.getuEmail());
				stmt.setString(3, vo.getuPw());
				
				int cnt = stmt.executeUpdate();	
				if(cnt == 1){
					System.out.println("joining success");
				}else{
					System.out.println("joining failed");
				}
				
			}catch(SQLException e){
				System.out.println("SQLException : MemberDAO - doJoin");
				e.printStackTrace();
			}finally{
				JDBCUtil.close(stmt, conn);
			}

			joinResult=1;
			doCreateResume(vo);
		}else{//중복일 경우
			System.out.println("중복이라 가입 실패");

			joinResult=0;
		}
		return joinResult;

	}
	
	@Override
	public int doCreateResume(Member vo)throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		int userId=-1;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(doGetUserSQL);
			stmt.setString(1, vo.getuEmail());
			System.out.println("에러찾기 email: "+vo.getuEmail());
			ResultSet cnt = stmt.executeQuery();	
			if(cnt.next()){
				userId=cnt.getInt("userId");
				System.out.println("aa"+userId);
			}else{
				System.out.println("asd");
			}
			
			
		}catch(SQLException e){
			System.out.println("SQLException : MemberDAO - doCreateResume (doGetUserSQL)");
			e.printStackTrace();
		}
		
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(createResumeSQL);
			stmt.setInt(1, userId);
			
			int cnt = stmt.executeUpdate();
			
			if(cnt == 1){
				System.out.println("createResume success");
			}else{
				System.out.println("createResume failed");
			}
		}catch(SQLException e){
			System.out.println("SQLException : MemberDAO - doCreateResume (createResumeSQL)");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		
		return 0;
		
	}
	

	@Override
	public Member doLogin(Member vo) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(doGetUserSQL);
			stmt.setString(1, vo.getuEmail());
			String pw=vo.getuPw();
			ResultSet cnt = stmt.executeQuery();	
			if(cnt.next()){
				if(cnt.getString("pw")!=null&&cnt.getString("pw").equals(pw)){
					//일치하면
					//회원정보를 가져옴
					vo.setuNickname(cnt.getString("nickname"));
					vo.setUserId(cnt.getInt("userId"));
					System.out.println("Login success");
				
				}else{
					System.out.println("Login failed");
				}
			}
			
			
		}catch(SQLException e){
			System.out.println("SQLException : MemberDAO - doLogin");
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		return vo;
	}

	@Override
	public int doIdCheck(Member vo) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(doGetUserSQL);
			stmt.setString(1, vo.getuEmail());
			
			
			ResultSet cnt = stmt.executeQuery();	
			if(cnt.next()){
				
					System.out.println("memberDAOImpl - doIdCheck 중복");
					result=-1;
				
			}else{
				System.out.println("memberDAOImpl - doIdCheck 안중복");

				result=1;
			}
			
		}catch(SQLException e){
			System.out.println("SQLException : MemberDAO - idCheck");
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		return result;
	}

	@Override
	public void doLeave(Member vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Member listAll(Member vo) throws Exception {
		// TODO Auto-generated method stub\
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet cnt=null;
		System.out.println("listAll Member");
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(doGetUserSQL);
			stmt.setString(1, vo.getuEmail());
			cnt = stmt.executeQuery();	
			
			if(cnt.next()){

				vo.setuEmail(cnt.getString("email"));
				vo.setuNickname(cnt.getString("nickname"));
				//겟 리스트
				//스쿨,경력 ... 리스트 받아
			}
			
			
		}catch(SQLException e){
			System.out.println("SQLException : MemberDAO - listAll");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		
		return vo;
	}
	
	@Override
	public Resume listResume(Member vo) throws Exception {
		// TODO Auto-generated method stub\
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet cnt=null;
		System.out.println("listAll Resume");
		Resume rVo=new Resume();
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(doGetResumeSQL);
			stmt.setInt(1, vo.getUserId());
			cnt = stmt.executeQuery();	
			
			if(cnt.next()){

				rVo.setName(cnt.getString("name"));
				rVo.setEngName(cnt.getString("engName"));
				rVo.setBirth(cnt.getString("birth")); //date를 어케 받지?
				rVo.setSchool(cnt.getString("school"));
				rVo.setSkill(cnt.getString("skill"));
				rVo.setCareer(cnt.getString("career"));
				rVo.setAward(cnt.getString("award"));
				rVo.setLanguage(cnt.getString("language"));
			
			}
			
			
		}catch(SQLException e){	
			System.out.println("SQLException : MemberDAO - listResume");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		
		return rVo;
	}


}
