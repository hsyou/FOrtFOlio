<%@ page import="org.fofo.board.vo.NoticePost"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="org.fofo.board.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp"%>

<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">      <h1>
        Notice Board
        <small>View</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="/home.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="/noticeboard.do">Community</a></li>
        <li class="active">notice Board</li>
      </ol>
      <br>
    </section>
    <section class="content">
    <div class = "box box-primary">
	    <div class="box-header">
	    	<h3 class="box-title">notice Board</h3>
	    </div>
		<div class="box-body pad table-responsive">
			<table>
		    	<tr>
			    	<th><a href = "/noticeboard/write.jsp"><button class="btn bg-purple margin">Write</button></a></th>
			    	<th style="width: 820px"></th>
				    <th><div class="btn-group">
				    	<button type="button" class="btn bg-purple">recent</button>
				    	<button type="button" class="btn bg-purple">like</button>
				    	<button type="button" class="btn bg-purple">view</button>
			    	</div></th>
		    	</tr>
    		</table>
			<table class="table table-bordered text-center">
				<tr>
					<th style="width: 15px">PostNum</th>
					<th style="width: 600px">TITLE</th>
					<th>WRITER</th>
					<th>REGDATE</th>
					<th style="width: 40px">VIEWCNT</th>
				</tr>
				
				<c:forEach items="${list}" var="noticepost">
					<tr>
						<td>${noticepost.nPostId}</td>
						<td><a href='/getnoticeboard.do?nPostId=${noticepost.nPostId}'>${noticepost.nPostTitle}</a></td>
						<td>${noticepost.userId}</td>
						<td>${noticepost.nPostDate}</td>
						<td><span class="badge bg-red">${noticepost.nHitNum }</span></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	</section>
</div>

<%@ include file="../include/footer.jsp"%>