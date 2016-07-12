package org.fofo.member.vo;


public class Member {
	
	private Integer userId;
	private String uEmail;
	private String uPw;
	
	private String uNickname;
	private Integer uPoint;
	private Integer uResumeNum;
	private Integer uPortfolioNum;
	private Boolean flag;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuPw() {
		return uPw;
	}
	public void setuPw(String uPw) {
		this.uPw = uPw;
	}
	public String getuNickname() {
		return uNickname;
	}
	public void setuNickname(String uNickname) {
		this.uNickname = uNickname;
	}
	public Integer getuPoint() {
		return uPoint;
	}
	public void setuPoint(Integer uPoint) {
		this.uPoint = uPoint;
	}
	public Integer getuResumeNum() {
		return uResumeNum;
	}
	public void setuResumeNum(Integer uResumeNum) {
		this.uResumeNum = uResumeNum;
	}
	public Integer getuPortfolioNum() {
		return uPortfolioNum;
	}
	public void setuPortfolioNum(Integer uPortfolioNum) {
		this.uPortfolioNum = uPortfolioNum;
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

}