package org.fofo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.fofo.board.vo.FreePost;
import org.fofo.common.JDBCUtil;

public class FreeBoardDAO {

	private static String addBoardSQL = "insert into freepost (boardID, fpostTitle, userID, fpostContent, ftags) values(1, ?, ?, ?, ?)";
	private static String listBoardSQL = "select * from freepost order by fpostdate desc";
	private static String getBoardSQL = "select * from freepost where fPostId = ?";
	private static String countBoardSQL = "update freepost set fhitNum = fhitNum + 1 where fPostId = ?";
	private static String updateBoardSQL = "update freepost set fpostTitle = ?, fpostContent = ?, ftags = ? where fPostId = ?";
	private static String deleteCommentSQL = "delete from freecomment where fPostId = ?";
	private static String deleteBoardSQL = "delete from freepost where fPostId = ?";
	
	public void doDeleteBoard(FreePost freepost){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(deleteCommentSQL);
			stmt.setInt(1, freepost.getfPostId());
			stmt.executeUpdate();
			stmt.clearParameters();
			
			stmt = conn.prepareStatement(deleteBoardSQL);
			stmt.setInt(1, freepost.getfPostId());
			int cnt = stmt.executeUpdate();
			if(cnt == 1){
				System.out.println("deleteBoard success");
			}else{
				System.out.println("deleteBoard fail");
			}
		}catch(SQLException e){
			System.out.println("deleteBoard error : " + e);
		}finally{
			JDBCUtil.close(stmt, conn);
		}
	}
	public void doUpdateBoard(FreePost freepost){
			
			Connection conn = null;
			PreparedStatement stmt = null;
			try{
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(updateBoardSQL);
				stmt.setString(1, freepost.getfPostTitle());
				stmt.setString(2, freepost.getfPostContent());
				stmt.setString(3, freepost.getfTags());
				stmt.setInt(4, freepost.getfPostId());
				int cnt = stmt.executeUpdate();
				if(cnt == 1){
					System.out.println("updateBoard success");
				}else{
					System.out.println("updateBoard fail");
				}
			}catch(SQLException e){
				System.out.println("updateBoard error : " + e);
			}finally{
				JDBCUtil.close(stmt, conn);
			}
		}
		
	
	public void doGetBoard(FreePost freepost){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(countBoardSQL);
			stmt.setInt(1, freepost.getfPostId());
			stmt.executeUpdate();
			stmt.clearParameters();
			
			stmt = conn.prepareStatement(getBoardSQL);
			stmt.setInt(1, freepost.getfPostId());
			rst = stmt.executeQuery();
			if(rst.next()){
				
				freepost.setBoardId(rst.getInt("BoardId"));
				freepost.setUserId(rst.getInt("UserId"));
				freepost.setfHitNum(rst.getInt("fHitNum"));
				freepost.setfRecommendNum(rst.getInt("fRecommendNum"));
				freepost.setfCommentNum(rst.getInt("fCommentNum"));
				freepost.setfBookmarkNum(rst.getInt("fBookmarkNum"));
				freepost.setfPostDate(rst.getString("fPostDate"));
				freepost.setfPostTitle(rst.getString("fPostTitle"));
				freepost.setfPostContent(rst.getString("fPostContent"));
				freepost.setfTags(rst.getString("fTags"));
				//System.out.println("글 정보 : " + freepost);
			}
		}catch(SQLException e){
			System.out.println("list error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
	}
		
	public ArrayList<FreePost> doListBoard(){
		ArrayList<FreePost> list = new ArrayList<FreePost>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		FreePost freepost = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(listBoardSQL);
			rst = stmt.executeQuery();
			while(rst.next()){
				freepost = new FreePost();
				freepost.setfPostId(rst.getInt("fPostId"));
				freepost.setBoardId(rst.getInt("BoardId"));
				freepost.setUserId(rst.getInt("UserId"));
				freepost.setfHitNum(rst.getInt("fHitNum"));
				freepost.setfRecommendNum(rst.getInt("fRecommendNum"));
				freepost.setfCommentNum(rst.getInt("fCommentNum"));
				freepost.setfBookmarkNum(rst.getInt("fBookmarkNum"));
				freepost.setfPostDate(rst.getString("fPostDate"));
				freepost.setfPostTitle(rst.getString("fPostTitle"));
				freepost.setfPostContent(rst.getString("fPostContent"));
				freepost.setfTags(rst.getString("fTags"));
				list.add(freepost);
			}
		}catch(SQLException e){
			System.out.println("list error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
		//System.out.println("리스트정보 : " + list);
		return list;
		
	}
	
	public void doAddBoard(FreePost freepost){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(addBoardSQL);
			stmt.setString(1, freepost.getfPostTitle());
			stmt.setInt(2, freepost.getUserId());
			stmt.setString(3, freepost.getfPostContent());
			stmt.setString(4, freepost.getfTags());
			int cnt = stmt.executeUpdate();
			if(cnt == 1){
				System.out.println("addBoard success");
			}else{
				System.out.println("addBoard fail");
			}
		}catch(SQLException e){
			System.out.println("addBoard error : " + e);
		}finally{
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public FreeBoardDAO() {
		// TODO Auto-generated constructor stub
	}
}
