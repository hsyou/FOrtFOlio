<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>

<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Free Board
        <small>Read</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="/home.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="/freeboard/listall.jsp">Community</a></li>
        <li class="active">Free Board</li>
      </ol>
      <br>
    </section>
    <section class="content">
    <div class = "box box-primary">
	    <div class="box-header">
	    	<h3 class="box-title">Free Board read</h3>
	    </div>
		<div class="box-body pad table-responsive">
			<form role="gpost" method="post">
				<input type="hidden" name="fPostId" id="fPostId" value="${freepost.fPostId}">
			</form>
			
			<div class="box-body">
				<div class="form-group">
					<label for="exampleInputEmail1">Title</label>
					<input type="text" name='postTitle' class="form-control" value="${freepost.fPostTitle}" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Writer</label>
					<input type="text" name='userId' class="form-control" value="${freepost.userId}" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Content</label>
					<textarea class="form-control" name="fPostContent" rows="3" readonly="readonly">${freepost.fPostContent}</textarea>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Tags</label>
					<input type="text" name='fTags' class="form-control" value="${freepost.fTags}" readonly="readonly">
				</div>
			</div>
			<div class="box-footer">
				<button id="ModifyPost" type="submit" class="btn btn-warning">Modify</button>
				<button id="RemovePost" type="submit" class="btn btn-danger">REMOVE</button>
				<a href="/freeboard.do"><button id="listAll" class="btn btn-primary">LIST ALL</button></a>
			</div>
		</div>
	</div>
	<div class = "box box-success" >
	    <div class="box-header">
	    	<h3 class="box-title">Add new comment</h3>
	    </div>
		<form class="box-body" role="addcomt">
			<input type="hidden" name="fPostId" id="fPostId" value="${freepost.fPostId}">
			<label for="exampleInputEmail1">Writer</label>
			<input class="form-control" type="text" placeholder="USER ID" name="userId" id="userId">
			<label for="exampleInputEmail1">Comment Text</label>
			<input class="form-control" type="text" placeholder="COMMENT TEXT" name="fCommentContent" id="fCommentContent">
		</form>
		<div class="body-footer">
			<button id="addcomment" class="btn btn-primary">ADD COMMENT</button>
		</div>
	</div>
	<ul class="timeline">
		<li class="time-label" id="commentDiv"><span class="bg-green">Comment List</span></li>
		<c:forEach items="${clist}" var="freecomment">
			<li class="replyLi">
				<i class="fa fa-comments bg-blue"></i>
				<div class="timeline-item">
					<% //System.out.println("modify_comment_movement fail"); %>
					<span class="time">
					<i class="fa fa-clock-o"></i>${freecomment.fcommentDate}
					</span>
					<h3 class="timeline-header"><strong>${freecomment.fCommentId}</strong>- ${freecomment.userId}</h3>
					<div class="timeline-body">
						<p class = "fCommentContent_b" id="fCommentContent_b">${freecomment.fCommentContent}</p>
						<input class = "fCommentContent_m" type="text" id="fCommentContent_m" value="${freecomment.fCommentContent}" style="display: none;">
						<input type="hidden" name="fCommentId" id="fCommentId" value="${freecomment.fCommentId}">
						<input type="hidden" name="fPostId" id="fPostId" value="${freepost.fPostId}">
					</div>
					<div class="timeline-footer">
						<input id="modifyCbtn" type="button" class="btn btn-primary btn-xs modifyCbtn" value="Modify">
						<input id="removeCbtn" type="button" class="btn btn-danger btn-xs removeCbtn" value="Delete">
						<input id="saveCbtn" type="button" class="btn btn-primary btn-xs saveCbtn" value="Save" style="display: none;">
						<input id="cancelCbtn" type="button" class="btn btn-danger btn-xs cancelCbtn" value="Cancel" style="display: none;">
					</div>
				</div>
			</li>
		</c:forEach>
	</ul>
	</section>
</div>

<%@ include file="../include/footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="../resources/js/freeboard.js"></script>

