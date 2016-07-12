<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp"%>

<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Q&A Board
        <small>Read</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="/home.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="/qaboard/qalisr.jsp">Community</a></li>
        <li class="active">Q&A Board</li>
      </ol>
      <br>
    </section>
    <section class="content"> <!-- 투표 공간을 위해 content를 새로 만들 것. -->
    <div class = "box box-primary">
	    <div class="box-header">
	    	<h3 class="box-title">Q&A Board read</h3>
	    </div>
		<div class="box-body pad table-responsive">
			<form role="gpost" method="post">
				<input type="hidden" name="qaPostId" value="${qapost.qaPostId}">
			</form>
			<div class = "col-md-1 col-lg-1 col-sm-1">
				<div class = "vote-box"  align="center">
					<button type="button" class="btn btn-link">
  						<span class="glyphicon glyphicon-chevron-up" aria-hidden="true"></span>
					</button>
					<h2 style='text-align:center'>${qapost.qaRecommendNum}</h2>
					<button type="button" class="btn btn-link">
  						<span class="glyphicon glyphicon-chevron-down" aria-hidden="false"></span>
					</button>
				</div>
			</div>
			<div class="col-md-10 col-lg-10 col-sm-10">
				<div class="form-group">
					<label for="exampleInputEmail1">Title</label>
					<input type="text" name='postTitle' class="form-control" value="${qapost.qaPostTitle}" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Tags</label>
					<input type="text" name='fTags' class="form-control" value="${qapost.qaTags}" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Writer</label>
					<input type="text" name='userId' class="form-control" value="${qapost.userId}" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Content</label>
					<textarea class="form-control" name="qaPostContent" rows="3" readonly="readonly">${qapost.qaPostContent}</textarea>
				</div>
			</div>
		</div>
			<div class="box-footer container-fluid">
				<button id="ModifyPost" type="submit" class="btn btn-warning">Modify</button>
				<button id="RemovePost" type="submit" class="btn btn-danger">REMOVE</button>
				<a href="/qaboard.do"><button id="qalist" class="btn btn-primary">LIST ALL</button></a>
			</div>
		
	</div>
	<div class = "box box-success" >
		<form role="addcomt">
			<input class="hidden" name="qaPostId" value="${qapost.qaPostId}">
		    <div class="box-header">
		    	<h3 class="box-title">Add new comment</h3>
		    </div>
			<div class="box-body">
				<label for="exampleInputEmail1">Writer</label>
				<input class="form-control" type="text" placeholder="USER ID" name="userId">
				<label for="exampleInputEmail1">Comment Text</label>
				<Input class="form-control" type="text" placeholder="COMMENT TEXT" name="qaCommentContent">
			</div>
			<div class="body-footer">
				<button id="addcomment" type="submit" class="btn btn-primary">ADD COMMENT</button>
			</div>
		</form>
	</div>
	<ul class="timeline">
		<li class="time-label" id="commentDiv"><span class="bg-green">Comment List</span></li>
		<c:forEach items="${clist}" var="qacomment">
			<li class="replyLi">
			<i class="fa fa-comments bg-blue"></i>
				<form class="timeline-item" role="comt" method="post">
					<input type="hidden" name="qaPostId" value="${qapost.qaPostId}">
					<c:choose>
						<c:when test="${qacomment.qaCommentId == qamodifyCId}">
							<% System.out.println("modify_comment_movement success"); %>
								<span class="time">
									<i class="fa fa-clock-o"></i>${qacomment.qacommentDate}
								</span>
								<h3 class="timeline-header"><strong>${qacomment.qaCommentId}</strong>- ${qacomment.userId}</h3>
								<div class="timeline-body">
								<input class="form-control" type="text" id="qaCommentContent" name="qaCommentContent" value="${qacomment.qaCommentContent}"></div>
								<input type="hidden" name="qaCommentId" value="${qacomment.qaCommentId}">
								<input type="hidden" name="qamodifyCId" value="">
								<div class="timeline-footer">
									<button id="saveCbtn" type="submit" class="btn btn-primary btn-xs">Save</button>
									<button id="cancelCbtn" type="submit" class="btn btn-danger btn-xs">Cancel</button>
								</div>
						</c:when>
						<c:otherwise>
							<% //System.out.println("modify_comment_movement fail"); %>
							<span class="time">
							<i class="fa fa-clock-o"></i>${qacomment.qacommentDate}
							</span>
							<h3 class="timeline-header"><strong>${qacomment.qaCommentId}</strong>- ${qacomment.userId}</h3>
							<div class="timeline-body">${qacomment.qaCommentContent}</div>
							<input type="hidden" name="fCommentId" value="${qacomment.qaCommentId}">
							<input type="hidden" name="fmodifyCId" value="${qacomment.qaCommentId}">
							<div class="timeline-footer">
								<button id="modifyCbtn" type="submit" class="btn btn-primary btn-xs">Modify</button>
								<button id="removeCbtn" type="submit" class="btn btn-danger btn-xs">Delete</button>
							</div>
						</c:otherwise>
					</c:choose>
				</form>
			</li>
		</c:forEach>
	</ul>
	</section>
</div>
<%@ include file="../include/footer.jsp" %>


<script>
$(document).ready(function(){
	var formObj = $("form[role = 'gpost']");
	console.log(formObj);
	
	$("#ModifyPost").on("click", function(){
		formObj.attr("action", "/modifyviewfreeboard.do");
		formObj.attr("method", "post");
		formObj.submit();
	});
	
	$("#RemovePost").on("click", function(){
		formObj.attr("action", "/removefreeboard.do");
		formObj.attr("method", "post");
		formObj.submit();
	});
	
	var formObj3 = $("form[role = 'addcomt']");
	console.log(formObj3);
	
	$("#addcomment").on("click", function(){
		formObj3.attr("action", "/addfreecomment.do");
		formObj3.attr("method", "post");
		formObj3.submit();
	});
	
	var formObj2 = $("form[role = 'comt']");
	console.log(formObj2);
	
	$("#saveCbtn").on("click", function(){
		formObj2.attr("action", "/modifyfreecomment.do");
		formObj2.attr("method", "post");
		formObj2.submit();
	});
	
	$("#cancelCbtn").on("click", function(){
		formObj2.attr("action", "/getfreeboard.do");
		formObj2.attr("method", "post");
		formObj2.submit();
	});
	
	$("#modifyCbtn").on("click", function(){
		formObj2.attr("action", "/modifyviewfreecomment.do");
		formObj2.attr("method", "post");
		formObj2.submit();
	});
	
	$("#removeCbtn").on("click", function(){
		formObj2.attr("action", "/removefreecomment.do");
		formObj2.attr("method", "post");
		formObj2.submit();
	});
});

</script>