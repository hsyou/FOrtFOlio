<%@ page import="org.fofo.message.vo.Message"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="org.fofo.message.dao.MessageDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp"%>

<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">      
        <h1>Message
        <small>View</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="/home.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="/user/profile.jsp">My page</a></li>
        <li class="active">Message</li>
      </ol>
      <br>
    </section>
    <section class="content">
		<!-- Chat box -->
	    <div class="box box-success">
	      <div class="box-header">
	        <i class="fa fa-comments-o"></i>
	        <h3 class="box-title">Chat</h3>
	        <div class="box-tools pull-right" data-toggle="tooltip" title="Send">
	          <div class="btn-group" data-toggle="btn-toggle" >
	            <button type="button" class="btn btn-warning btn-sm">메세지 보내기</button>
	          </div>
	          </br>
	        </div>
	      </div>
	      <div class="box-body chat" id="chat-box">
	      
	        <form role='readm' method="post">
	        <c:forEach items="${list}" var="message">
		        <!-- chat item -->
		        <div class="item">
		          <img src="/resources/dist/img/user4-128x128.jpg" alt="user image" class="online">
		          <p class="message">
		            <a href="#" class="name">
		              <small class="text-muted pull-right"><i class="fa fa-clock-o"></i> ${message.getSendDate()}</small>
		              ${message.getSuserId()}
		              <input type="hidden" id="SuserId" name="SuserId" value="${message.getSuserId()}">
		              <input type="hidden" id="RuserId" name="RuserId" value="1234">
		            </a>
		            ${message.getmContent()}
		          </p>
		        </div><!-- /.item -->
	        </c:forEach>
	        </form>
	      </div><!-- /.chat -->
	      <div class="box-footer">
	        <div class="input-group">
	          <input class="form-control" placeholder="Search message...">
	          <div class="input-group-btn">
	            <button class="btn btn-success"><i class="fa fa-plus"></i> 검색</button>
	          </div>
	        </div>
	      </div>
	    </div><!-- /.box (chat box) -->
	</section>
</div>

<%@ include file="../include/footer.jsp"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="../resources/js/message.js"></script>


<%-- <div class="box-body chat" id="chat-box">
	<form role='readm' method="post">
	</form>
	  <c:forEach items="${list}" var="message">
	   <!-- chat item -->
	   <div class="item">
	     <img src="/resources/dist/img/user4-128x128.jpg" alt="user image" class="online">
	     <p class="message">
	         <small class="text-muted pull-right"><i class="fa fa-clock-o"></i> ${message.getSendDate()}</small>
	         <input type="hidden" value="${message.getSuserId()}" name="SuserId" id="SuserId">
	         ${message.getSuserId()}
	       ${message.getmContent()}
	     </p>
	   </div><!-- /.item -->
	  </c:forEach>
	</div><!-- /.chat --> --%>