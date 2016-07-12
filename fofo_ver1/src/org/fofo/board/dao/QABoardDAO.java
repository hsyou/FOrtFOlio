package org.fofo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.fofo.board.vo.FreePost;
import org.fofo.board.vo.QAPost;
import org.fofo.common.JDBCUtil;

public class QABoardDAO {
	
	private static String addBoardSQL = "insert into qapost (boardID, qapostTitle, userID, qapostContent, qatags) values(1, ?, ?, ?, ?)";
	private static String listBoardSQL = "select * from qapost order by qapostdate desc";
	private static String getBoardSQL = "select * from qapost where qaPostId = ?";
	private static String countBoardSQL = "update qapost set qahitNum = qahitNum + 1 where qaPostId = ?";
	private static String updateBoardSQL = "update qapost set qapostTitle = ?, qapostContent = ?, qatags = ? where qaPostId = ?";
	private static String deleteBoardSQL = "delete from qapost where qaPostId = ?";
	
	public void doDeleteBoard(QAPost qapost){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(deleteBoardSQL);
			stmt.setInt(1, qapost.getqaPostId());
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
		
	
	public void doGetBoard(QAPost qapost){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(countBoardSQL);
			stmt.setInt(1, qapost.getqaPostId());
			stmt.executeUpdate();
			stmt.clearParameters();
			
			stmt = conn.prepareStatement(getBoardSQL);
			stmt.setInt(1, qapost.getqaPostId());
			rst = stmt.executeQuery();
			if(rst.next()){
				
				qapost.setBoardId(rst.getInt("BoardId"));
				qapost.setUserId(rst.getInt("UserId"));
				qapost.setqaHitNum(rst.getInt("qaHitNum"));
				qapost.setqaRecommendNum(rst.getInt("qaRecommendNum"));
				qapost.setqaCommentNum(rst.getInt("qaCommentNum"));
				qapost.setqaBookmarkNum(rst.getInt("qaBookmarkNum"));
				qapost.setqaPostDate(rst.getString("qaPostDate"));
				qapost.setqaPostTitle(rst.getString("qaPostTitle"));
				qapost.setqaPostContent(rst.getString("qaPostContent"));
				qapost.setqaTags(rst.getString("qaTags"));
				//System.out.println("글 정보 : " + qapost);
			}
		}catch(SQLException e){
			System.out.println("list error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
	}
		
	public ArrayList<QAPost> doListBoard(){
		ArrayList<QAPost> list = new ArrayList<QAPost>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		QAPost qapost = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(listBoardSQL);
			rst = stmt.executeQuery();
			while(rst.next()){
				qapost = new QAPost();
				qapost.setqaPostId(rst.getInt("qaPostId"));
				qapost.setBoardId(rst.getInt("BoardId"));
				qapost.setUserId(rst.getInt("UserId"));
				qapost.setqaHitNum(rst.getInt("qaHitNum"));
				qapost.setqaRecommendNum(rst.getInt("qaRecommendNum"));
				qapost.setqaCommentNum(rst.getInt("qaCommentNum"));
				qapost.setqaBookmarkNum(rst.getInt("qaBookmarkNum"));
				qapost.setqaPostDate(rst.getString("qaPostDate"));
				qapost.setqaPostTitle(rst.getString("qaPostTitle"));
				qapost.setqaPostContent(rst.getString("qaPostContent"));
				qapost.setqaTags(rst.getString("qaTags"));
				list.add(qapost);
			}
		}catch(SQLException e){
			System.out.println("list error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
		//System.out.println("리스트정보 : " + list);
		return list;
		
	}
	
	public void doAddBoard(QAPost qapost){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(addBoardSQL);
			stmt.setString(1, qapost.getqaPostTitle());
			stmt.setInt(2, qapost.getUserId());
			stmt.setString(3, qapost.getqaPostContent());
			stmt.setString(4, qapost.getqaTags());
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
	
	public QABoardDAO() {
		// TODO Auto-generated constructor stub
	}
}
