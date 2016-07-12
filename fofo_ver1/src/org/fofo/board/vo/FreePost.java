package org.fofo.board.vo;

import java.io.Serializable;

public class FreePost implements Serializable {

	private static final long serialVersionUID = -4022161635202540887L;
	
	private int fPostId;
	private int BoardId;
	private int UserId;
	private int fHitNum;
	private int fRecommendNum;
	private int fCommentNum;
	private int fBookmarkNum;
	private String fPostDate;
	private String fPostTitle;
	private String fPostContent;
	private String fTags;

	public FreePost() {
		// TODO Auto-generated constructor stub
	}

	public int getfPostId() {
		return fPostId;
	}

	public void setfPostId(int fPostId) {
		this.fPostId = fPostId;
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

	public int getfHitNum() {
		return fHitNum;
	}

	public void setfHitNum(int fHitNum) {
		this.fHitNum = fHitNum;
	}

	public int getfRecommendNum() {
		return fRecommendNum;
	}

	public void setfRecommendNum(int fRecommendNum) {
		this.fRecommendNum = fRecommendNum;
	}

	public int getfCommentNum() {
		return fCommentNum;
	}

	public void setfCommentNum(int fCommentNum) {
		this.fCommentNum = fCommentNum;
	}

	public int getfBookmarkNum() {
		return fBookmarkNum;
	}

	public void setfBookmarkNum(int fBookmarkNum) {
		this.fBookmarkNum = fBookmarkNum;
	}

	public String getfPostDate() {
		return fPostDate;
	}

	public void setfPostDate(String fPostDate) {
		this.fPostDate = fPostDate;
	}

	public String getfPostTitle() {
		return fPostTitle;
	}

	public void setfPostTitle(String fPostTitle) {
		this.fPostTitle = fPostTitle;
	}

	public String getfPostContent() {
		return fPostContent;
	}

	public void setfPostContent(String fPostContent) {
		this.fPostContent = fPostContent;
	}

	public String getfTags() {
		return fTags;
	}

	public void setfTags(String fTags) {
		this.fTags = fTags;
	}

	@Override
	public String toString() {
		return "FreePost [fPostId=" + fPostId + ", BoardId=" + BoardId + ", UserId=" + UserId + ", fHitNum=" + fHitNum
				+ ", fRecommendNum=" + fRecommendNum + ", fCommentNum=" + fCommentNum + ", fBookmarkNum=" + fBookmarkNum
				+ ", fPostDate=" + fPostDate + ", fPostTitle=" + fPostTitle + ", fPostContent=" + fPostContent
				+ ", fTags=" + fTags + "]";
	}

}
