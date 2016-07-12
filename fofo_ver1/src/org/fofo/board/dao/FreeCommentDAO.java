package org.fofo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.fofo.board.vo.FreeComment;
import org.fofo.board.vo.FreePost;
import org.fofo.common.JDBCUtil;

public class FreeCommentDAO {

	private static String addCommentSQL = "insert into freecomment (fpostId, boardID, userID, fcommentContent) values(?, 1, ?, ?)";
	private static String listCommentSQL = "select * from freecomment where fPostId = ? order by fcommentDate desc";
	private static String getBoardSQL = "select * from freecomment where fCommentId = ?";
	private static String countCommentSQL = "update freepost set fCommentNum = fCommentNum + 1 where fPostId = ?";
	private static String updateCommentSQL = "update freecomment set fCommentContent = ? where fCommentId = ?";
	private static String deleteCommentSQL = "delete from freecomment where fCommentId = ?";
	
	public void doDeleteComment(FreeComment freecomment){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(deleteCommentSQL);
			stmt.setInt(1, freecomment.getfCommentId());
			int cnt = stmt.executeUpdate();
			if(cnt == 1){
				System.out.println("deleteComment success");
			}else{
				System.out.println("deleteComment fail");
			}
		}catch(SQLException e){
			System.out.println("deleteComment error : " + e);
		}finally{
			JDBCUtil.close(stmt, conn);
		}
	}
	public void doUpdateComment(FreeComment freecomment){
			
			Connection conn = null;
			PreparedStatement stmt = null;
			try{
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(updateCommentSQL);
				stmt.setString(1, freecomment.getfCommentContent());
				stmt.setInt(2, freecomment.getfCommentId());
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
		
	
	public void doGetBoard(FreeComment freecomment){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		try{
			
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(countCommentSQL);
			stmt.setInt(1, freecomment.getfPostId());
			stmt.executeUpdate();
			stmt.clearParameters();
			
			stmt = conn.prepareStatement(getBoardSQL);
			stmt.setInt(1, freecomment.getfPostId());
			rst = stmt.executeQuery();
			if(rst.next()){				
//				freepost.setBoardId(rst.getInt("BoardId"));
//				freepost.setUserId(rst.getInt("UserId"));
//				freepost.setfHitNum(rst.getInt("fHitNum"));
//				freepost.setfRecommendNum(rst.getInt("fRecommendNum"));
//				freepost.setfCommentNum(rst.getInt("fCommentNum"));
//				freepost.setfBookmarkNum(rst.getInt("fBookmarkNum"));
//				freepost.setfPostDate(rst.getString("fPostDate"));
//				freepost.setfPostTitle(rst.getString("fPostTitle"));
//				freepost.setfPostContent(rst.getString("fPostContent"));
//				freepost.setfTags(rst.getString("fTags"));
				//System.out.println("글 정보 : " + freepost);
			}
		}catch(SQLException e){
			System.out.println("list error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
	}
		
	public ArrayList<FreeComment> doListComment(FreeComment freecomment){
		ArrayList<FreeComment> clist = new ArrayList<FreeComment>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		try{
			conn = JDBCUtil.getConnection();			
			stmt = conn.prepareStatement(listCommentSQL);
			stmt.setInt(1, freecomment.getfPostId());
			rst = stmt.executeQuery();
			while(rst.next()){
				freecomment = new FreeComment();
				freecomment.setfCommentId(rst.getInt("fCommentId"));
				freecomment.setfPostId(rst.getInt("fPostId"));
				freecomment.setBoardId(rst.getInt("BoardId"));
				freecomment.setUserId(rst.getInt("userId"));
				freecomment.setuProfileImg(rst.getString("uProfileImg"));
				freecomment.setFcommentDate(rst.getString("fcommentDate"));
				freecomment.setfCommentContent(rst.getString("fCommentContent"));
				freecomment.setfCLikeNum(rst.getInt("fCLikeNum"));
				clist.add(freecomment);
			}
		}catch(SQLException e){
			System.out.println("clist error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
		//System.out.println("리스트정보 : " + list);
		return clist;
	}
	
	public void doAddComment(FreeComment freecomment){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(countCommentSQL);
			stmt.setInt(1, freecomment.getfPostId());
			stmt.executeUpdate();
			stmt.clearParameters();
			
			stmt = conn.prepareStatement(addCommentSQL);
			stmt.setInt(1, freecomment.getfPostId());
			stmt.setInt(2, freecomment.getUserId());
			stmt.setString(3, freecomment.getfCommentContent());
			int cnt = stmt.executeUpdate();
			if(cnt == 1){
				System.out.println("addComment success");
			}else{
				System.out.println("addComment fail");
			}
		}catch(SQLException e){
			System.out.println("addComment error : " + e);
		}finally{
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public FreeCommentDAO() {
		// TODO Auto-generated constructor stub
	}
}
