package org.fofo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.fofo.board.vo.NoticePost;
import org.fofo.common.JDBCUtil;

public class NoticeBoardDAO {

	private static String addBoardSQL = "insert into noticepost (boardID, nPostTitle, userID, nPostContent, ntags) values(1, ?, ?, ?, ?)";
	private static String listBoardSQL = "select * from noticepost order by nPostdate desc";
	private static String getBoardSQL = "select * from noticepost where nPostId = ?";
	private static String countBoardSQL = "update noticepost set nhitNum = nhitNum + 1 where nPostId = ?";
	private static String updateBoardSQL = "update noticepost set nPostTitle = ?, nPostContent = ?, ntags = ? where nPostId = ?";
	private static String deleteCommentSQL = "delete from noticecomment where nPostId = ?";
	private static String deleteBoardSQL = "delete from noticepost where nPostId = ?";
	
	public void doDeleteBoard(NoticePost noticepost){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(deleteCommentSQL);
			stmt.setInt(1, noticepost.getnPostId());
			stmt.executeUpdate();
			stmt.clearParameters();
			
			stmt = conn.prepareStatement(deleteBoardSQL);
			stmt.setInt(1, noticepost.getnPostId());
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
	public void doUpdateBoard(NoticePost noticepost){
			
			Connection conn = null;
			PreparedStatement stmt = null;
			try{
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(updateBoardSQL);
				stmt.setString(1, noticepost.getnPostTitle());
				stmt.setString(2, noticepost.getnPostContent());
				stmt.setString(3, noticepost.getnTags());
				stmt.setInt(4, noticepost.getnPostId());
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
		
	
	public void doGetBoard(NoticePost noticepost){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(countBoardSQL);
			stmt.setInt(1, noticepost.getnPostId());
			stmt.executeUpdate();
			stmt.clearParameters();
			
			stmt = conn.prepareStatement(getBoardSQL);
			stmt.setInt(1, noticepost.getnPostId());
			rst = stmt.executeQuery();
			if(rst.next()){
				
				noticepost.setBoardId(rst.getInt("BoardId"));
				noticepost.setUserId(rst.getInt("UserId"));
				noticepost.setnHitNum(rst.getInt("nHitNum"));
				noticepost.setnRecommendNum(rst.getInt("nRecommendNum"));
				noticepost.setnCommentNum(rst.getInt("nCommentNum"));
				noticepost.setnBookmarkNum(rst.getInt("nBookmarkNum"));
				noticepost.setnPostDate(rst.getString("nPostDate"));
				noticepost.setnPostTitle(rst.getString("nPostTitle"));
				noticepost.setnPostContent(rst.getString("nPostContent"));
				noticepost.setnTags(rst.getString("nTags"));
				//System.out.println("글 정보 : " + noticepost);
			}
		}catch(SQLException e){
			System.out.println("list error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
	}
		
	public ArrayList<NoticePost> doListBoard(){
		ArrayList<NoticePost> list = new ArrayList<NoticePost>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		NoticePost noticepost = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(listBoardSQL);
			rst = stmt.executeQuery();
			while(rst.next()){
				noticepost = new NoticePost();
				noticepost.setnPostId(rst.getInt("nPostId"));
				noticepost.setBoardId(rst.getInt("BoardId"));
				noticepost.setUserId(rst.getInt("UserId"));
				noticepost.setnHitNum(rst.getInt("nHitNum"));
				noticepost.setnRecommendNum(rst.getInt("nRecommendNum"));
				noticepost.setnCommentNum(rst.getInt("nCommentNum"));
				noticepost.setnBookmarkNum(rst.getInt("nBookmarkNum"));
				noticepost.setnPostDate(rst.getString("nPostDate"));
				noticepost.setnPostTitle(rst.getString("nPostTitle"));
				noticepost.setnPostContent(rst.getString("nPostContent"));
				noticepost.setnTags(rst.getString("nTags"));
				list.add(noticepost);
			}
		}catch(SQLException e){
			System.out.println("list error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
		//System.out.println("리스트정보 : " + list);
		return list;
		
	}
	
	public void doAddBoard(NoticePost noticepost){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(addBoardSQL);
			stmt.setString(1, noticepost.getnPostTitle());
			stmt.setInt(2, noticepost.getUserId());
			stmt.setString(3, noticepost.getnPostContent());
			stmt.setString(4, noticepost.getnTags());
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
	
	public NoticeBoardDAO() {
		// TODO Auto-generated constructor stub
	}
}
