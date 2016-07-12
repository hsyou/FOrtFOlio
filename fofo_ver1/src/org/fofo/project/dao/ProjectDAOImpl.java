package org.fofo.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.fofo.project.vo.Project;

import org.fofo.common.JDBCUtil;
import org.fofo.member.vo.Member;

public class ProjectDAOImpl implements ProjectDAO {

	private static String addProjectSQL = "INSERT into project (userId , projectName, createDate, lastUpdate)"
									+"VALUES (123, ?, now(), now());";
	
	private static String deleteProjectSQL = "DELETE "
											+"FROM project "
											+"WHERE projectId = ?;";

	private static String loadProjectListSQL = "SELECT projectId, projectName, lastUpdate "
												+"FROM project "
												+"WHERE userId = ?;";
	
	/*private static String loadProjectContentSQL = "SELECT projectContent "
												+"FROM project "
												+"WHERE userId = ? and projectName = ?;";*/
	private static String loadProjectContentSQL = "SELECT projectName, projectContent "
												+"FROM project "
												+"WHERE projectId = ?;";
	
	private static String updateProjectSQL = "UPDATE project "
											+ "SET projectContent = ? "
											+ "WHERE projectId = ?;";
	
	public ProjectDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	@Override
	public void doUpdateThisProject(Project project) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;

		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(updateProjectSQL);
			
			stmt.setString(1, project.getProjectContent());
			stmt.setInt(2, project.getProjectId());
			
			System.out.println(project.getProjectId() + "/" + project.getProjectContent());
			
			int cnt = stmt.executeUpdate();
			
			System.out.println("영향받은 라인: " + cnt);
			
		}catch(SQLException e){
			System.out.println("<dao> updating project content occured an ERROR");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}
	}
	
	
	
	
	@Override
	public Project doGetProjectContent(Project project) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		
		Project pjt = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(loadProjectContentSQL);
			
			stmt.setInt(1, project.getProjectId());
			
			/*stmt.setInt(1, member.getUserId());
			stmt.setString(2, project.getProjectName());*/
			
			rst = stmt.executeQuery();
			
			if(rst.next()){
				project.setProjectName(rst.getString("projectName"));
				project.setProjectContent(rst.getString("projectContent"));
				System.out.println(project.getProjectContent());
			}
			
		}catch(SQLException e){
			System.out.println("<dao> load project content occured an ERROR");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		return project;
	}
	

	@Override
	public void doAddProject(Project project) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(addProjectSQL);
			
//			stmt.setInt(1, project.getUserId());
			
			stmt.setString(1, project.getProjectName());
			System.out.println("project name: " + project.getProjectName());
//			stmt.setString(3, project.getProjectContent());
			
			
			int cnt = stmt.executeUpdate();
			if(cnt == 1){
				System.out.println("adding project had completed");
			}else{
				System.out.println("adding project had failed");
			}
			
		}catch(SQLException e){
			System.out.println("<dao> adding project occured an ERROR");
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		
	}

	@Override
	public void doDeleteProject(Project project) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(deleteProjectSQL);
			stmt.setInt(1, project.getProjectId());
			
			int cnt = stmt.executeUpdate();
			
			if(cnt == 1){
				System.out.println("removing project had completed");
			}else{
				System.out.println("removing project had failed");
			}
			
		}catch(SQLException e){
			System.out.println("<dao> removing project occured an ERROR");
		}finally{
			JDBCUtil.close(stmt, conn);
		}
	}

	@Override
	public ArrayList<Project> doListAll(Member member) throws Exception {
		
		ArrayList<Project> list = new ArrayList<Project>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		Project project = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(loadProjectListSQL);
			
			stmt.setInt(1, 123);
			
			rst = stmt.executeQuery();	
			
			while(rst.next()){
				project = new Project();
				project.setProjectId(rst.getInt("projectId"));
				project.setProjectName(rst.getString("projectName"));
				project.setLastUpdate(rst.getString("lastUpdate"));
				
				
//				System.out.println(project.getProjectName());
				
				list.add(project);
				
			}
					
		}catch(SQLException e){
			System.out.println("<dao> failed: " + e);
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		return list;
		
	}

	

	

}
