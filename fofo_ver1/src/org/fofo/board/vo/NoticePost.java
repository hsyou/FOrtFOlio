package org.fofo.board.vo;

import java.io.Serializable;

public class NoticePost implements Serializable {

	private static final long serialVersionUID = -4022161635202540887L;
	
	private int nPostId;
	private int BoardId;
	private int UserId;
	private int nHitNum;
	private int nRecommendNum;
	private int nCommentNum;
	private int nBookmarkNum;
	private String nPostDate;
	private String nPostTitle;
	private String nPostContent;
	private String nTags;

	public NoticePost() {
		// TODO Auto-generated constructor stub
	}

	public int getnPostId() {
		return nPostId;
	}

	public void setnPostId(int nPostId) {
		this.nPostId = nPostId;
	}

	public int getBoardId() {
		return BoardId;
	}

	public void setBoardId(int boardId) {
		BoardId = boardId;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public int getnHitNum() {
		return nHitNum;
	}

	public void setnHitNum(int nHitNum) {
		this.nHitNum = nHitNum;
	}

	public int getnRecommendNum() {
		return nRecommendNum;
	}

	public void setnRecommendNum(int nRecommendNum) {
		this.nRecommendNum = nRecommendNum;
	}

	public int getnCommentNum() {
		return nCommentNum;
	}

	public void setnCommentNum(int nCommentNum) {
		this.nCommentNum = nCommentNum;
	}

	public int getnBookmarkNum() {
		return nBookmarkNum;
	}

	public void setnBookmarkNum(int nBookmarkNum) {
		this.nBookmarkNum = nBookmarkNum;
	}

	public String getnPostDate() {
		return nPostDate;
	}

	public void setnPostDate(String nPostDate) {
		this.nPostDate = nPostDate;
	}

	public String getnPostTitle() {
		return nPostTitle;
	}

	public void setnPostTitle(String nPostTitle) {
		this.nPostTitle = nPostTitle;
	}

	public String getnPostContent() {
		return nPostContent;
	}

	public void setnPostContent(String nPostContent) {
		this.nPostContent = nPostContent;
	}

	public String getnTags() {
		return nTags;
	}

	public void setnTags(String fTags) {
		this.nTags = fTags;
	}

	@Override
	public String toString() {
		return "NoticePost [nPostId=" + nPostId + ", BoardId=" + BoardId + ", UserId=" + UserId + ", nHitNum=" + nHitNum
				+ ", nRecommendNum=" + nRecommendNum + ", nCommentNum=" + nCommentNum + ", nBookmarkNum=" + nBookmarkNum
				+ ", nPostDate=" + nPostDate + ", nPostTitle=" + nPostTitle + ", nPostContent=" + nPostContent
				+ ", nTags=" + nTags + "]";
	}

}
