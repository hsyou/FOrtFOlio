package org.fofo.board.vo;

import java.io.Serializable;

public class FreeComment implements Serializable {

	private static final long serialVersionUID = -4022161635202540887L;
	
	private int fCommentId;
	private int fPostId;
	private int boardId;
	private int userId;
	private String uProfileImg;
	private String fcommentDate;
	private String fCommentContent;
	private int fCLikeNum;

	public FreeComment() {
		// TODO Auto-generated constructor stub
	}

	public int getfCommentId() {
		return fCommentId;
	}

	public void setfCommentId(int fCommentId) {
		this.fCommentId = fCommentId;
	}

	public int getfPostId() {
		return fPostId;
	}

	public void setfPostId(int fPostId) {
		this.fPostId = fPostId;
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

	public String getFcommentDate() {
		return fcommentDate;
	}

	public void setFcommentDate(String fcommentDate) {
		this.fcommentDate = fcommentDate;
	}

	public String getfCommentContent() {
		return fCommentContent;
	}

	public void setfCommentContent(String fCommentContent) {
		this.fCommentContent = fCommentContent;
	}

	public int getfCLikeNum() {
		return fCLikeNum;
	}

	public void setfCLikeNum(int fCLikeNum) {
		this.fCLikeNum = fCLikeNum;
	}

	@Override
	public String toString() {
		return "FreeComment [fCommentId=" + fCommentId + ", fPostId=" + fPostId + ", boardId=" + boardId + ", userId="
				+ userId + ", uProfileImg=" + uProfileImg + ", fcommentDate=" + fcommentDate + ", fCommentContent="
				+ fCommentContent + ", fCLikeNum=" + fCLikeNum + "]";
	}
}
