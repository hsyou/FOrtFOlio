package org.fofo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.fofo.board.vo.NoticeComment;
import org.fofo.common.JDBCUtil;

public class NoticeCommentDAO {

	private static String addCommentSQL = "insert into noticecomment (nPostId, boardID, userID, nCommentContent) values(?, 1, ?, ?)";
	private static String listCommentSQL = "select * from noticecomment where nPostId = ? order by nCommentDate desc";
	private static String getBoardSQL = "select * from noticecomment where nCommentId = ?";
	private static String countCommentSQL = "update noticepost set nCommentNum = nCommentNum + 1 where nPostId = ?";
	private static String updateCommentSQL = "update noticecomment set nCommentContent = ? where nCommentId = ?";
	private static String deleteCommentSQL = "delete from noticecomment where nCommentId = ?";
	
	public void doDeleteComment(NoticeComment noticecomment){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(deleteCommentSQL);
			stmt.setInt(1, noticecomment.getnCommentId());
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
	public void doUpdateComment(NoticeComment noticecomment){
			
			Connection conn = null;
			PreparedStatement stmt = null;
			try{
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(updateCommentSQL);
				stmt.setString(1, noticecomment.getnCommentContent());
				stmt.setInt(2, noticecomment.getnCommentId());
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
		
	
	public void doGetBoard(NoticeComment noticecomment){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		try{
			
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(countCommentSQL);
			stmt.setInt(1, noticecomment.getnPostId());
			stmt.executeUpdate();
			stmt.clearParameters();
			
			stmt = conn.prepareStatement(getBoardSQL);
			stmt.setInt(1, noticecomment.getnPostId());
			rst = stmt.executeQuery();
			if(rst.next()){				
//				noticepost.setBoardId(rst.getInt("BoardId"));
//				noticepost.setUserId(rst.getInt("UserId"));
//				noticepost.setfHitNum(rst.getInt("fHitNum"));
//				noticepost.setfRecommendNum(rst.getInt("fRecommendNum"));
//				noticepost.setnCommentNum(rst.getInt("nCommentNum"));
//				noticepost.setfBookmarkNum(rst.getInt("fBookmarkNum"));
//				noticepost.setnPostDate(rst.getString("nPostDate"));
//				noticepost.setnPostTitle(rst.getString("nPostTitle"));
//				noticepost.setnPostContent(rst.getString("nPostContent"));
//				noticepost.setfTags(rst.getString("fTags"));
				//System.out.println("글 정보 : " + noticepost);
			}
		}catch(SQLException e){
			System.out.println("list error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
	}
		
	public ArrayList<NoticeComment> doListComment(NoticeComment noticecomment){
		ArrayList<NoticeComment> clist = new ArrayList<NoticeComment>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		try{
			conn = JDBCUtil.getConnection();			
			stmt = conn.prepareStatement(listCommentSQL);
			stmt.setInt(1, noticecomment.getnPostId());
			rst = stmt.executeQuery();
			while(rst.next()){
				noticecomment = new NoticeComment();
				noticecomment.setnCommentId(rst.getInt("nCommentId"));
				noticecomment.setnPostId(rst.getInt("nPostId"));
				noticecomment.setBoardId(rst.getInt("BoardId"));
				noticecomment.setUserId(rst.getInt("userId"));
				noticecomment.setuProfileImg(rst.getString("uProfileImg"));
				noticecomment.setnCommentDate(rst.getString("nCommentDate"));
				noticecomment.setnCommentContent(rst.getString("nCommentContent"));
				noticecomment.setnCLikeNum(rst.getInt("nCLikeNum"));
				clist.add(noticecomment);
			}
		}catch(SQLException e){
			System.out.println("clist error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
		//System.out.println("리스트정보 : " + list);
		return clist;
	}
	
	public void doAddComment(NoticeComment noticecomment){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(countCommentSQL);
			stmt.setInt(1, noticecomment.getnPostId());
			stmt.executeUpdate();
			stmt.clearParameters();
			
			stmt = conn.prepareStatement(addCommentSQL);
			stmt.setInt(1, noticecomment.getnPostId());
			stmt.setInt(2, noticecomment.getUserId());
			stmt.setString(3, noticecomment.getnCommentContent());
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
	
	public NoticeCommentDAO() {
		// TODO Auto-generated constructor stub
	}
}
