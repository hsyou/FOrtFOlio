<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>

<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        notice Board
        <small>Read</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="/home.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="/noticeboard/listall.jsp">Community</a></li>
        <li class="active">notice Board</li>
      </ol>
      <br>
    </section>
    <section class="content">
    <div class = "box box-primary">
	    <div class="box-header">
	    	<h3 class="box-title">notice Board read</h3>
	    </div>
		<div class="box-body pad table-responsive">
			<form role="gpost" method="post">
				<input type="hidden" name="nPostId" id="nPostId" value="${noticepost.nPostId}">
			</form>
			
			<div class="box-body">
				<div class="form-group">
					<label for="exampleInputEmail1">Title</label>
					<input type="text" name='postTitle' class="form-control" value="${noticepost.nPostTitle}" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Writer</label>
					<input type="text" name='userId' class="form-control" value="${noticepost.userId}" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Content</label>
					<textarea class="form-control" name="nPostContent" rows="3" readonly="readonly">${noticepost.nPostContent}</textarea>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Tags</label>
					<input type="text" name='nTags' class="form-control" value="${noticepost.nTags}" readonly="readonly">
				</div>
			</div>
			<div class="box-footer">
				<button id="ModifyPost" type="submit" class="btn btn-warning">Modify</button>
				<button id="RemovePost" type="submit" class="btn btn-danger">REMOVE</button>
				<a href="/noticeboard.do"><button id="listAll" class="btn btn-primary">LIST ALL</button></a>
			</div>
		</div>
	</div>
	<div class = "box box-success" >
	    <div class="box-header">
	    	<h3 class="box-title">Add new comment</h3>
	    </div>
		<form class="box-body" role="addcomt">
			<input type="hidden" name="nPostId" id="nPostId" value="${noticepost.nPostId}">
			<label for="exampleInputEmail1">Writer</label>
			<input class="form-control" type="text" placeholder="USER ID" name="userId" id="userId">
			<label for="exampleInputEmail1">Comment Text</label>
			<input class="form-control" type="text" placeholder="COMMENT TEXT" name="nCommentContent" id="nCommentContent">
		</form>
		<div class="body-footer">
			<button id="addcomment" class="btn btn-primary">ADD COMMENT</button>
		</div>
	</div>
	<ul class="timeline">
		<li class="time-label" id="commentDiv"><span class="bg-green">Comment List</span></li>
		<c:forEach items="${clist}" var="noticecomment">
			<li class="replyLi">
				<i class="fa fa-comments bg-blue"></i>
				<div class="timeline-item">
					<% //System.out.println("modify_comment_movement fail"); %>
					<span class="time">
					<i class="fa fa-clock-o"></i>${noticecomment.nCommentDate}
					</span>
					<h3 class="timeline-header"><strong>${noticecomment.nCommentId}</strong>- ${noticecomment.userId}</h3>
					<div class="timeline-body">
						<p class = "nCommentContent_b" id="nCommentContent_b">${noticecomment.nCommentContent}</p>
						<input class = "nCommentContent_m" type="text" id="nCommentContent_m" value="${noticecomment.nCommentContent}" style="display: none;">
						<input type="hidden" name="nCommentId" id="nCommentId" value="${noticecomment.nCommentId}">
						<input type="hidden" name="nPostId" id="nPostId" value="${noticepost.nPostId}">
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
<script src="../resources/js/noticeboard.js"></script>

