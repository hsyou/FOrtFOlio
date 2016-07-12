<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp"%>

<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        notice Board
        <small>Write</small>
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
	    	<h3 class="box-title">notice Board write</h3>
	    </div>
		<div class="box-body pad table-responsive">
			<form action="/addnoticeboard.do" method="post">
				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Title</label>
						<input type="text" name="title" class="form-control" placeholder="Enter Title">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Writer</label>
						<input name="writer" class="form-control" placeholder="Enter Writer">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Content</label>
						<textarea class="form-control" name="content" rows="3" placeholder="Enter content"></textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Tags</label>
						<input type="text" name="tags" class="form-control" placeholder="Enter Writer">
					</div>
				</div>
			
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</form>
		</div>
	</div>
	</section>
</div>

</body>
</html>