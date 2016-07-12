package org.fofo.member.vo;

public class School {

	private Integer schoolId;
	private String schoolName;
	
	private String degree;
	private String major;
	
	private Integer entrance;
	private Integer graduation;
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Integer getEntrance() {
		return entrance;
	}
	public void setEntrance(Integer entrance) {
		this.entrance = entrance;
	}
	public Integer getGraduation() {
		return graduation;
	}
	public void setGraduation(Integer graduation) {
		this.graduation = graduation;
	}

	
}
