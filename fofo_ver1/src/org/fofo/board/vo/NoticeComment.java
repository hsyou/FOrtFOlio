package org.fofo.board.vo;

import java.io.Serializable;

public class NoticeComment implements Serializable {

	private static final long serialVersionUID = -4022161635202540887L;
	
	private int nCommentId;
	private int nPostId;
	private int boardId;
	private int userId;
	private String uProfileImg;
	private String nCommentDate;
	private String nCommentContent;
	private int nCLikeNum;

	public NoticeComment() {
		// TODO Auto-generated constructor stub
	}

	public int getnCommentId() {
		return nCommentId;
	}

	public void setnCommentId(int nCommentId) {
		this.nCommentId = nCommentId;
	}

	public int getnPostId() {
		return nPostId;
	}

	public void setnPostId(int nPostId) {
		this.nPostId = nPostId;
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

	public String getnCommentDate() {
		return nCommentDate;
	}

	public void setnCommentDate(String fcommentDate) {
		this.nCommentDate = fcommentDate;
	}

	public String getnCommentContent() {
		return nCommentContent;
	}

	public void setnCommentContent(String nCommentContent) {
		this.nCommentContent = nCommentContent;
	}

	public int getnCLikeNum() {
		return nCLikeNum;
	}

	public void setnCLikeNum(int nCLikeNum) {
		this.nCLikeNum = nCLikeNum;
	}

	@Override
	public String toString() {
		return "NoticeComment [nCommentId=" + nCommentId + ", nPostId=" + nPostId + ", boardId=" + boardId + ", userId="
				+ userId + ", uProfileImg=" + uProfileImg + ", fcommentDate=" + nCommentDate + ", nCommentContent="
				+ nCommentContent + ", nCLikeNum=" + nCLikeNum + "]";
	}
}
