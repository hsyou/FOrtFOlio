<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.fofo.project.vo.Project" %>
<%@ page import="org.fofo.project.dao.ProjectDAOImpl" %>
<%@ page import="org.fofo.project.controller.*" %>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link href="../resources/css/project.css" rel="stylesheet" type="text/css" />
	
<!-- <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet"> -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.css" rel="stylesheet">


<%@ include file="../include/header.jsp"%>
<!-- <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>  -->


<div class="content-wrapper">

	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>프로젝트 편집</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Forms</a></li>
			<li class="active">General Elements</li>
		</ol>
	</section>


	<!-- Main Content -->
	<div class="projectEditorContent">
		
		<div role="tabpanel">

			<!-- Nav tabs -->
			<ul id="projectTab" class="nav nav-tabs" role="tablist">
				<!-- <li role="presentation" ><a href="#tab1" role="tab" aria-controls="tab1" data-toggle="tab">기본</a></li> -->
				<li role="presentation" id="liProjectTabAdd">
					<a id="btnProjectTabAdd" href="#newTab" aria-controls="newTab" role="tab" data-toggle="tab">
						new Tab
					</a>
					<!-- <a id="btnProjectTabAdd" role="tab" data-toggle="modal" data-target="#addTabModal">+</a> -->
				</li>
			</ul>

			<!-- Tab panes -->
			<div id="projectTabContent" class="projectTab-content tab-content" onload="loader()">
				<div role="tabpanel" class="tab-pane fade" id="newTab">
  					<div class="projectContent">
						<ul class="blockList list-unstyled draggableList"></ul>
						
						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1">Add할 프로젝트 이름 </span>
							<input id="newProjectName" type="text" name="newProjectName" class="form-control" placeholder="project name" aria-describedby="basic-addon1">
							<span class="input-group-btn">
					        	<button id="addProjectBtn" class="btn btn-success" type="button">ADD!</button>
					      	</span>
						</div>
						
						<div id="projectListDiv">
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
						</div>
						
						
					</div>
  				</div>
			</div>
			
		</div>
	</div>


</div>


<!-- floating menu -->
<div id="floatMenu">
	
	<div>
		<input id="editBlockOrder" class="btn btn-default" type="button" value="순서 편집">
		<input id="endEditBlockOrder" class="btn btn-primary" type="button" value="순서 편집 완료" style="display: none;">
	</div>
	
	<div>
		<input id="saveThisProject" class="btn btn-warning" type="button" value="이 프로젝트 저장">
	</div>
	
</div>
<!-- floatMenu -->




<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">Small modal</button> -->
<!-- load project modal -->
<%-- <div id="addTabModal" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	<div class="modal-dialog">
	    <div class="modal-content">
	    	
	    	
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        	<h4 class="modal-title" id="myModalLabel">프로젝트 불러오기</h4>
	      	</div>
	
	      
			
	      		<input id="method" type="text" name="method" value="addNewProject" style="display: none;">
	      	
				<div class="modal-body">
					
					<div id="projectListTable" style="height:200px; overflow:auto">
						<table border="1" cellpadding="0" cellspacing="0" width="450">
							<tr>
								<th bgcolor="orange" width="140">name</th>
								<th bgcolor="orange" width="260">update</th>
								<th bgcolor="orange" width="50">do</th>
							</tr>
							<c:forEach var="project" items="${ projectList }">
								<tr>					
									<td class="listProjectName">${ project.getProjectName() }</td>
									<td class="listLastUpdate">${ project.getLastUpdate() }</td>
									<td><button class="btn btn-primary loadProjectBtn" data-dismiss="modal" type="submit">Load</button></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					
					<!-- <div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Add할 프로젝트 이름 </span>
						<input id="loadProjectName" type="text" name="loadProjectName" class="form-control" placeholder="project name" aria-describedby="basic-addon1">
						
					</div> -->
				
					<form method="post">
			      		<div class="input-group">
							<span class="input-group-addon" id="basic-addon2">Add할 프로젝트 이름 </span>
							<input id="addProjectName" type="text" name="addProjectName" class="form-control" placeholder="project name" aria-describedby="basic-addon1">
							<span class="input-group-btn">
					  			<button id="addProjectBtn" data-dismiss="modal" type="submit" class="btn btn-primary">Add</button>
		      				</span>
						</div>
					</form>
				</div>
		      
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			
			
		</div>
	</div>
</div> --%>
<!-- load project modal -->





<!-- <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> -->
<script src="../resources/js/project.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.js"></script>
<script src="../resources/summernote-master/lang/summernote-ko-KR.js"></script>

<%@ include file="../include/footer.jsp"%>

