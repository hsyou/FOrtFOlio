package org.fofo.message.vo;

import java.io.Serializable;


public class Message implements Serializable {

	private static final long serialVersionUID = -3615424174143181240L;

	private int RuserId;
	private int SuserId;
	private String mContent;
	private String SendDate;
	private Boolean ReadorNot;
	private String ReceiveDate;
	
	
	public int getRuserId() {
		return RuserId;
	}


	public void setRuserId(int ruserId) {
		RuserId = ruserId;
	}


	public int getSuserId() {
		return SuserId;
	}


	public void setSuserId(int suserId) {
		SuserId = suserId;
	}


	public String getmContent() {
		return mContent;
	}


	public void setmContent(String mContent) {
		this.mContent = mContent;
	}


	public String getSendDate() {
		return SendDate;
	}


	public void setSendDate(String sendDate) {
		SendDate = sendDate;
	}


	public Boolean getReadorNot() {
		return ReadorNot;
	}


	public void setReadorNot(Boolean readorNot) {
		ReadorNot = readorNot;
	}


	public String getReceiveDate() {
		return ReceiveDate;
	}


	public void setReceiveDate(String receivetDate) {
		ReceiveDate = receivetDate;
	}

	
	@Override
	public String toString() {
		return "Message [RuserId=" + RuserId + ", SuserId=" + SuserId + ", mContent=" + mContent + ", SendDate="
				+ SendDate + ", ReadorNot=" + ReadorNot + ", ReceiveDate=" + ReceiveDate + "]";
	}


	public Message() {
		// TODO Auto-generated constructor stub
	}

}
