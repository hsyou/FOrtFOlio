package org.fofo.board.vo;

import java.io.Serializable;
import java.util.ArrayList;


public class QABoardList implements Serializable {

	private static final long serialVersionUID = 3081784380658324897L;

	private String status;
	private int count;
	private ArrayList<QAPost> list = new ArrayList<QAPost>();

	public QABoardList() {
		// TODO Auto-generated constructor stub
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ArrayList<QAPost> getList() {
		return list;
	}
	public void setList(ArrayList<QAPost> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "QABoardListResult [status=" + status + ", count=" + count + ", list=" + list + "]";
	}
	
}