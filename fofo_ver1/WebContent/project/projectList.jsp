<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.ArrayList"%>
<table border="1" cellpadding="0" cellspacing="0" width="650">
	<tr>
		<th width="50">고유 번호</th>
		<th bgcolor="orange" width="200">프로젝트 이름</th>
		<th bgcolor="orange" width="250">최근 수정일시</th>
		<th bgcolor="orange" width="150">기능</th>
	</tr>
	<c:forEach var="project" items="${projectList}">
		<tr>
			<th class="listProjectId">${ project.projectId }</th>					
			<td class="listProjectName">${ project.projectName }</td>
			<td class="listLastUpdate">${ project.lastUpdate }</td>
			<td>
				<button class="btn btn-primary loadProjectBtn" type="submit">Load</button>
				<button class="btn btn-danger deleteProjectBtn" type="submit">Delete</button>
			</td>
		</tr>
	</c:forEach>
</table>

<script src="../resources/js/project.js"></script>