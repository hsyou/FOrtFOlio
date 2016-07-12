<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp"%>

<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Free Board
        <small>Modify</small>
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
	    	<h3 class="box-title">Free Board</h3>
	    </div>
		<div class="box-body pad table-responsive">
		<form action="modifyfreeboard.do" method="post">
			<input type="hidden" name="fpostid" value="${freepost.fPostId}">
			<div class="form-group">
				<label for="exampleInputEmail1>">Title</label>
				<input type="text" name="title" class="form-control" value="${freepost.fPostTitle}">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1>">Writer</label>
				<input name="writer" class="form-control" value="${freepost.userId}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1>">Content</label>
				<textarea class="form-control" name="content" rows="3">${freepost.fPostContent}</textarea>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1>">Tags</label>
				<input type="text" name="tags" class="form-control" value="${freepost.fTags}">
			</div>
		
			<div class="box-footer">
				<button type="submit" class="btn btn-primary">SAVE</button>
				<a href = "/getfreeboard.do"><button type="submit" class="btn btn-warning">CANCEL</button></a>
			</div>
		</form>
		</div>
	</div>
	</section>
</div>
<%@ include file="../include/footer.jsp" %>


<script>
	$(document).ready(function(){
		var formObj = $("form[role = 'form']");
		console.log(formObj);
		
		$(".btn-warning").on("click", function(){
			self.location = "/post/listAll";
		});
		
		$(".btn-primary").on("click", function(){
			formObj.submit();
		});
		
	});
	
	
	
</script>








