package org.fofo.project.vo;

import java.io.Serializable;

public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5954991272983179999L;

	private int projectId;
	private int userId;
	private String projectName;
	private String startDate;
	private String endDate;
//	private int peopleNum
	private String part;
	private String skill;
	private String developReason;
	private String createDate;
	private String lastUpdate;
	private String projectContent;
	private String attachment;
	
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getDevelopReason() {
		return developReason;
	}
	public void setDevelopReason(String developReason) {
		this.developReason = developReason;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getProjectContent() {
		return projectContent;
	}
	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", userId=" + userId + ", projectName=" + projectName
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", part=" + part + ", skill=" + skill
				+ ", developReason=" + developReason + ", createDate=" + createDate + ", lastUpdate=" + lastUpdate
				+ ", projectContent=" + projectContent + ", attachment=" + attachment + "]";
	}
	

	
	
	
}
