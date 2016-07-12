package org.fofo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.fofo.board.vo.QAComment;
import org.fofo.board.vo.QAPost;
import org.fofo.common.JDBCUtil;

public class QACommentDAO {

	private static String addCommentSQL = "insert into qacomment (qapostId, boardID, userID, qacommentContent) values(?, 1, ?, ?)";
	private static String listCommentSQL = "select * from qacomment where qaPostId = ? order by qacommentDate desc";
	private static String getBoardSQL = "select * from qacomment where qaCommentId = ?";
	private static String countCommentSQL = "update qapost set qaCommentNum = qaCommentNum + 1 where qaPostId = ?";
	private static String updateCommentSQL = "update qacomment set qaCommentContent = ? where qaCommentId = ?";
	private static String deleteCommentSQL = "delete from qacomment where qaCommentId = ?";
	
	public void doDeleteComment(QAComment qacomment){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(deleteCommentSQL);
			stmt.setInt(1, qacomment.getqaCommentId());
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
	public void doUpdateComment(QAComment qacomment){
			
			Connection conn = null;
			PreparedStatement stmt = null;
			try{
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(updateCommentSQL);
				stmt.setString(1, qacomment.getqaCommentContent());
				stmt.setInt(2, qacomment.getqaCommentId());
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
		
	
	public void doGetBoard(QAComment qacomment){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		try{
			
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(countCommentSQL);
			stmt.setInt(1, qacomment.getqaPostId());
			stmt.executeUpdate();
			stmt.clearParameters();
			
			stmt = conn.prepareStatement(getBoardSQL);
			stmt.setInt(1, qacomment.getqaPostId());
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
				//System.out.println("�� ���� : " + freepost);
			}
		}catch(SQLException e){
			System.out.println("list error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
	}
		
	public ArrayList<QAComment> doListComment(QAComment qacomment){
		ArrayList<QAComment> clist = new ArrayList<QAComment>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		try{
			conn = JDBCUtil.getConnection();			
			stmt = conn.prepareStatement(listCommentSQL);
			stmt.setInt(1, qacomment.getqaPostId());
			rst = stmt.executeQuery();
			while(rst.next()){
				qacomment = new QAComment();
				qacomment.setqaCommentId(rst.getInt("qaCommentId"));
				qacomment.setqaPostId(rst.getInt("qaPostId"));
				qacomment.setBoardId(rst.getInt("BoardId"));
				qacomment.setUserId(rst.getInt("userId"));
				qacomment.setuProfileImg(rst.getString("uProfileImg"));
				qacomment.setQAcommentDate(rst.getString("qacommentDate"));
				qacomment.setqaCommentContent(rst.getString("qaCommentContent"));
				qacomment.setqaLikeNum(rst.getInt("qaLikeNum"));
				clist.add(qacomment);
			}
		}catch(SQLException e){
			System.out.println("clist error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
		//System.out.println("����Ʈ���� : " + list);
		return clist;
	}
	
	public void doAddComment(QAComment qacomment){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(countCommentSQL);
			stmt.setInt(1, qacomment.getqaPostId());
			stmt.executeUpdate();
			stmt.clearParameters();
			
			stmt = conn.prepareStatement(addCommentSQL);
			stmt.setInt(1, qacomment.getqaPostId());
			stmt.setInt(2, qacomment.getUserId());
			stmt.setString(3, qacomment.getqaCommentContent());
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
	
	public QACommentDAO() {
		// TODO Auto-generated constructor stub
	}
}