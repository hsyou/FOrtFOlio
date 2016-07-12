package org.fofo.message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.fofo.common.JDBCUtil;
import org.fofo.message.vo.Message;

public class MessageDAO {

	private static String sendMessageSQL = "insert into message (SuserId, RuserId, mContent, ReadorNot) values(?, ?, ?, true);";
	//private static String listMessageSQL = "select * from message order by fpostdate desc";
	private static String listMessageSQL = "select SuserId, mContent, SendDate from message where (SuserId, SendDate) in (select SuserId, MAX(SendDate) from message group by SuserId) order by SendDate desc";
	private static String getMessageSQL = "select * from message where SuserId = ? or RuserId = ? order by SendDate desc";
	private static String deleteMessageSQL = "delete from message where SuserId = ?";
	
	public void doDeleteBoard(Message message){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(deleteMessageSQL);
			stmt.setInt(1, message.getSuserId());
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
	
	public ArrayList<Message> doGetMessage(int SuId, int RuId){
		
		ArrayList<Message> list = new ArrayList<Message>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		Message message = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(getMessageSQL);
			stmt.setInt(1, SuId);
			stmt.setInt(2, RuId);
			rst = stmt.executeQuery();
			while(rst.next()){
				message = new Message();
				message.setSuserId(rst.getInt("RuserId"));
				message.setRuserId(rst.getInt("SuserId"));
				message.setmContent(rst.getString("mContent"));
				message.setSendDate(rst.getString("SendDate"));
				message.setReadorNot(rst.getBoolean("ReadorNot"));
				list.add(message);
			}
		}catch(SQLException e){
			System.out.println("list error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
		System.out.println(""+message.getSuserId()+"와의 메시지불러오기 성공");
		return list;
	}
		
	public ArrayList<Message> doListMessage(){
		
		ArrayList<Message> list = new ArrayList<Message>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		Message message = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(listMessageSQL);
			rst = stmt.executeQuery();
			while(rst.next()){
				message = new Message();
				message.setSuserId(rst.getInt("SuserId"));
				message.setmContent(rst.getString("mContent"));
				message.setSendDate(rst.getString("SendDate"));
				list.add(message);
			}
		}catch(SQLException e){
			System.out.println("list error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
		//System.out.println("리스트정보 : " + list);
		return list;
		
	}
	
	public void doSendMessage(Message message){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(sendMessageSQL);
			stmt.setString(1, message.getmContent());
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
	
	public MessageDAO() {
		// TODO Auto-generated constructor stub
	}
	
}
