<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp"%>

<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Q&A Board
        <small>Write</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="/home.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="/freeboard/listall.jsp">Community</a></li>
        <li class="active">Q&A Board</li>
      </ol>
      <br>
    </section>
    <section class="content">
    <div class = "box box-primary">
	    <div class="box-header">
	    	<h3 class="box-title">QA Board write</h3>
	    </div>
		<div class="box-body pad table-responsive">
			<form role="form" method="post">
				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Title</label>
						<input type="text" name='title' class="form-control" placeholder="Enter Title">
					</div>
					<div class="form-group">
						<div>
						<input type = "text" name="tagString" value placeholder=Tags," data-role="tagsinput" class="form-control" id="tagString" style="display:none;">
						<div class = "bootstrap-tagsinput">
							<label for="exampleInputEmail1">Tags</label>
							<input type="text" name="writer" class="form-control" placeholder="Enter Tags">
						</div>
						</div>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Content</label>
						<textarea class="form-control" name="content" rows="3" placeholder="Enter content"></textarea>
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