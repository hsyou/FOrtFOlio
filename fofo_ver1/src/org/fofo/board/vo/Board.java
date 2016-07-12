package org.fofo.board.vo;

import java.io.Serializable;

public class Board implements Serializable {

	private static final long serialVersionUID = 8725908504307260620L;
	
	private int BoardId;
	private String BoardName;
	private int PostNum;

	public Board() {
		// TODO Auto-generated constructor stub
	}

	public int getBoardId() {
		return BoardId;
	}

	public void setBoardId(int boardId) {
		BoardId = boardId;
	}

	public String getBoardName() {
		return BoardName;
	}

	public void setBoardName(String boardName) {
		BoardName = boardName;
	}

	public int getPostNum() {
		return PostNum;
	}

	public void setPostNum(int postNum) {
		PostNum = postNum;
	}

	@Override
	public String toString() {
		return "Board [BoardId=" + BoardId + ", BoardName=" + BoardName + ", PostNum=" + PostNum + "]";
	}
}