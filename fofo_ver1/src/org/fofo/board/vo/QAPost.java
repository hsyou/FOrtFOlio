package org.fofo.board.vo;

import java.io.Serializable;

public class QAPost implements Serializable {

	private static final long serialVersionUID = -4022161635202540887L;
	
	private int qaPostId;
	private int BoardId;
	private int UserId;
	private int qaHitNum;
	private int qaRecommendNum;
	private int qaCommentNum;
	private int qaBookmarkNum;
	private String qaPostDate;
	private String qaPostTitle;
	private String qaPostContent;
	private String qaTags;

	public QAPost() {
		// TODO Auto-generated constructor stub
	}

	public int getqaPostId() {
		return qaPostId;
	}

	public void setqaPostId(int qaPostId) {
		this.qaPostId = qaPostId;
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

	public int getqaHitNum() {
		return qaHitNum;
	}

	public void setqaHitNum(int qaHitNum) {
		this.qaHitNum = qaHitNum;
	}

	public int getqaRecommendNum() {
		return qaRecommendNum;
	}

	public void setqaRecommendNum(int qaRecommendNum) {
		this.qaRecommendNum = qaRecommendNum;
	}

	public int getqaCommentNum() {
		return qaCommentNum;
	}

	public void setqaCommentNum(int qaCommentNum) {
		this.qaCommentNum = qaCommentNum;
	}

	public int getqaBookmarkNum() {
		return qaBookmarkNum;
	}

	public void setqaBookmarkNum(int qaBookmarkNum) {
		this.qaBookmarkNum = qaBookmarkNum;
	}

	public String getqaPostDate() {
		return qaPostDate;
	}

	public void setqaPostDate(String qaPostDate) {
		this.qaPostDate = qaPostDate;
	}

	public String getqaPostTitle() {
		return qaPostTitle;
	}

	public void setqaPostTitle(String qaPostTitle) {
		this.qaPostTitle = qaPostTitle;
	}

	public String getqaPostContent() {
		return qaPostContent;
	}

	public void setqaPostContent(String qaPostContent) {
		this.qaPostContent = qaPostContent;
	}

	public String getqaTags() {
		return qaTags;
	}

	public void setqaTags(String qaTags) {
		this.qaTags = qaTags;
	}

	@Override
	public String toString() {
		return "FreePost [qaPostId=" + qaPostId + ", BoardId=" + BoardId + ", UserId=" + UserId + ", qaHitNum=" + qaHitNum
				+ ", qaRecommendNum=" + qaRecommendNum + ", qaCommentNum=" + qaCommentNum + ", qaBookmarkNum=" + qaBookmarkNum
				+ ", qaPostDate=" + qaPostDate + ", qaPostTitle=" + qaPostTitle + ", qaPostContent=" + qaPostContent
				+ ", qaTags=" + qaTags + "]";
	}

}
