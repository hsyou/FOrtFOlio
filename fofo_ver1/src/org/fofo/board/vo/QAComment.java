package org.fofo.board.vo;

import java.io.Serializable;

public class QAComment implements Serializable {

	private static final long serialVersionUID = -4022161635202540887L;
	
	private int qaCommentId;
	private int qaPostId;
	private int boardId;
	private int userId;
	private String uProfileImg;
	private String qacommentDate;
	private String qaCommentContent;
	private int qaLikeNum;

	public QAComment() {
		// TODO Auto-generated constructor stub
	}

	public int getqaCommentId() {
		return qaCommentId;
	}

	public void setqaCommentId(int qaCommentId) {
		this.qaCommentId = qaCommentId;
	}

	public int getqaPostId() {
		return qaPostId;
	}

	public void setqaPostId(int qaPostId) {
		this.qaPostId = qaPostId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getuProfileImg() {
		return uProfileImg;
	}

	public void setuProfileImg(String uProfileImg) {
		this.uProfileImg = uProfileImg;
	}

	public String getQAcommentDate() {
		return qacommentDate;
	}

	public void setQAcommentDate(String qacommentDate) {
		this.qacommentDate = qacommentDate;
	}

	public String getqaCommentContent() {
		return qaCommentContent;
	}

	public void setqaCommentContent(String qaCommentContent) {
		this.qaCommentContent = qaCommentContent;
	}

	public int getqaLikeNum() {
		return qaLikeNum;
	}

	public void setqaLikeNum(int qaLikeNum) {
		this.qaLikeNum = qaLikeNum;
	}

	@Override
	public String toString() {
		return "FreeComment [qaCommentId=" + qaCommentId + ", qaPostId=" + qaPostId + ", boardId=" + boardId + ", userId="
				+ userId + ", uProfileImg=" + uProfileImg + ", qacommentDate=" + qacommentDate + ", qaCommentContent="
				+ qaCommentContent + ", qaLikeNum=" + qaLikeNum + "]";
	}
}
