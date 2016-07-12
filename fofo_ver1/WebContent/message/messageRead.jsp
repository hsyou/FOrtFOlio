<%@ page import="org.fofo.board.vo.FreePost"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="org.fofo.board.dao.FreeBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp"%>

<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">      <h1>
        Message
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
		<!-- DIRECT CHAT -->
        <div class="box box-warning direct-chat direct-chat-warning">
          <div class="box-header with-border">
            <h3 class="box-title">${SuserId}</h3>
            <div class="box-tools pull-right">
              <span data-toggle="tooltip" title="3 New Messages" class="badge bg-yellow">3</span>
              <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
              <button class="btn btn-box-tool" data-toggle="tooltip" title="Contacts" data-widget="chat-pane-toggle"><i class="fa fa-comments"></i></button>
              <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
            </div>
          </div><!-- /.box-header -->
          <div class="box-body">
            <!-- Conversations are loaded here -->
            <div class="direct-chat-messages">
            <c:forEach items="${mlist}" var="message">
              <c:choose>
              	<c:when test="${RuserId=='1234'}">
	              <!-- Message. Default to the left -->
	              <div class="direct-chat-msg">
	                <div class="direct-chat-info clearfix">
	                  <span class="direct-chat-name pull-left">${message.getSuserId()}</span>
	                  <span class="direct-chat-timestamp pull-right">${message.getSendDate()}</span>
	                </div><!-- /.direct-chat-info -->
	                <img class="direct-chat-img" src="resources/dist/img/user1-128x128.jpg" alt="message user image"><!-- /.direct-chat-img -->
	                <div class="direct-chat-text">
	                  ${message.getmContent()}
	                </div><!-- /.direct-chat-text -->
	              </div><!-- /.direct-chat-msg -->
				</c:when>
				<c:otherwise>
	              <!-- Message to the right -->
	              <div class="direct-chat-msg right">
	                <div class="direct-chat-info clearfix">
	                  <span class="direct-chat-name pull-right"><%session.getAttribute("name");%></span>
	                  <span class="direct-chat-timestamp pull-left">${message.getSendDate()}</span>
	                </div><!-- /.direct-chat-info -->
	                <img class="direct-chat-img" src="resources/dist/img/user3-128x128.jpg" alt="message user image"><!-- /.direct-chat-img -->
	                <div class="direct-chat-text">
	                  ${message.getmContent()}
	                </div><!-- /.direct-chat-text -->
	              </div><!-- /.direct-chat-msg -->
	             </c:otherwise>
	            </c:choose>
            </c:forEach>
            </div>


            <!-- Contacts are loaded here -->
            <div class="direct-chat-contacts">
              <ul class="contacts-list">
                <li>
                  <a href="#">
                    <img class="contacts-list-img" src="dist/img/user1-128x128.jpg">
                    <div class="contacts-list-info">
                      <span class="contacts-list-name">
                        Count Dracula
                        <small class="contacts-list-date pull-right">2/28/2015</small>
                      </span>
                      <span class="contacts-list-msg">How have you been? I was...</span>
                    </div><!-- /.contacts-list-info -->
                  </a>
                </li><!-- End Contact Item -->
                <li>
                  <a href="#">
                    <img class="contacts-list-img" src="dist/img/user7-128x128.jpg">
                    <div class="contacts-list-info">
                      <span class="contacts-list-name">
                        Sarah Doe
                        <small class="contacts-list-date pull-right">2/23/2015</small>
                      </span>
                      <span class="contacts-list-msg">I will be waiting for...</span>
                    </div><!-- /.contacts-list-info -->
                  </a>
                </li><!-- End Contact Item -->
                <li>
                  <a href="#">
                    <img class="contacts-list-img" src="dist/img/user3-128x128.jpg">
                    <div class="contacts-list-info">
                      <span class="contacts-list-name">
                        Nadia Jolie
                        <small class="contacts-list-date pull-right">2/20/2015</small>
                      </span>
                      <span class="contacts-list-msg">I'll call you back at...</span>
                    </div><!-- /.contacts-list-info -->
                  </a>
                </li><!-- End Contact Item -->
                <li>
                  <a href="#">
                    <img class="contacts-list-img" src="dist/img/user5-128x128.jpg">
                    <div class="contacts-list-info">
                      <span class="contacts-list-name">
                        Nora S. Vans
                        <small class="contacts-list-date pull-right">2/10/2015</small>
                      </span>
                      <span class="contacts-list-msg">Where is your new...</span>
                    </div><!-- /.contacts-list-info -->
                  </a>
                </li><!-- End Contact Item -->
                <li>
                  <a href="#">
                    <img class="contacts-list-img" src="dist/img/user6-128x128.jpg">
                    <div class="contacts-list-info">
                      <span class="contacts-list-name">
                        John K.
                        <small class="contacts-list-date pull-right">1/27/2015</small>
                      </span>
                      <span class="contacts-list-msg">Can I take a look at...</span>
                    </div><!-- /.contacts-list-info -->
                  </a>
                </li><!-- End Contact Item -->
                <li>
                  <a href="#">
                    <img class="contacts-list-img" src="dist/img/user8-128x128.jpg">
                    <div class="contacts-list-info">
                      <span class="contacts-list-name">
                        Kenneth M.
                        <small class="contacts-list-date pull-right">1/4/2015</small>
                      </span>
                      <span class="contacts-list-msg">Never mind I found...</span>
                    </div><!-- /.contacts-list-info -->
                  </a>
                </li><!-- End Contact Item -->
              </ul><!-- /.contatcts-list -->
            </div><!-- /.direct-chat-pane -->
          </div><!-- /.box-body -->
          <div class="box-footer">
            <form action="#" method="post">
              <div class="input-group">
                <input type="text" name="message" placeholder="Type Message ..." class="form-control">
                <span class="input-group-btn">
                  <button type="button" class="btn btn-warning btn-flat">Send</button>
                </span>
              </div>
            </form>
          </div><!-- /.box-footer-->
        </div><!--/.direct-chat -->
	</section>
</div>

<%@ include file="../include/footer.jsp"%>l>