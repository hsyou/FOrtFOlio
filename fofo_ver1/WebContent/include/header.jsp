<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
    <title>AdminLTE 2 | Dashboard</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.4 -->
    <link href="/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <link href="/resources/dist/css/AdminLTE.css" rel="stylesheet" type="text/css" />
    <link href="/resources/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
    
    <!-- <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet" /> -->
	<link href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css" />
    

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
 	
    <script src="../resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <script src="../resources/plugins/jQueryUI/jquery-ui-1.10.3.min.js"></script>
    
    <!-- Bootstrap 3.3.2 JS -->
    <script src="../resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- FastClick -->
    <script src="../resources/plugins/fastclick/fastclick.min.js"></script>
    <!-- AdminLTE App -->
    <script src="../resources/dist/js/app.min.js" type="text/javascript"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="../resources/dist/js/demo.js" type="text/javascript"></script>
     <!-- iCheck -->
	<script src="../resources/plugins/iCheck/icheck.min.js"></script>
	
    
  </head>
    
    
  <body class="skin-blue sidebar-mini">
    <div class="wrapper">
      
      <header class="main-header">
        <!-- Logo -->
        <a href="home.jsp" class="logo">
          <!-- mini logo for sidebar mini 50x50 pixels -->
          <span class="logo-mini"><b>FO</b>FO</span>
          <!-- logo for regular state and mobile devices -->
          <span class="logo-lg"><b>For</b>tfolio</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              <%if(session.getAttribute("uid")==null){ %>
                  
                  <%}else{%>
                  
              <!-- Messages: style can be found in dropdown.less-->
              <li class="dropdown messages-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                 <i class="fa fa-envelope-o"></i>
                </a>
                <ul class="dropdown-menu">
                <li class="footer"><a href="/message.do">See All Messages</a></li>
                </ul>
              </li>
          
              <!-- User Account: style can be found in dropdown.less -->
              <li class="dropdown user user-menu">
                <a href="message.do" class="dropdown-toggle" data-toggle="dropdown">
                  <span class="hidden-xs">
                  
                <%=session.getAttribute("nickname")%>
          
                  </span>
                </a>
                <ul class="dropdown-menu">
                  <!-- User image -->
                  <li class="user-header">
                <!--   <img src="/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image" /> -->  
                	
                    <p>
                       <%=session.getAttribute("nickname")%> - Web Developer
                       <%if(session.getAttribute("name")==null){ %>
                      <small>MyPage를 작성해 주세요.</small>
                      <%} else { %>
                      <small><%=session.getAttribute("nickname")%></small>
                      <%} %>
                    </p>
                  </li>

                  <!-- Menu Footer-->
                  <li class="user-footer">
                    <div class="pull-left">
                      <a href="../listAll.do" class="btn btn-default btn-flat">Profile</a>
                    </div>
                    <div class="pull-right">
                      <a href="../doLogout.do" class="btn btn-default btn-flat">Sign out</a>
                    </div>
                  </li>
                </ul>
              </li>
              <!-- Control Sidebar Toggle Button -->
              <li>
                <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
              </li>
              <%} %>
            </ul>
          </div>        
        </nav>
      </header>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
 		 
    <ul class="sidebar-menu">
         
         <!--   <li class="header">MAIN NAVIGATION</li>  --> 
 			
 			 <%
				if(session.getAttribute("uid")==null){
			%>  
			<br>
 			<br>
					<li align="center"><a href = "/user/login.jsp">
          		<i class = "glyphicon glyphicon-ice-lolly"></i>
          		<span>로그인</span>
          	</a></li>
          	<li align="center"><a href = "/user/register.jsp">
          		<i class = "glyphicon glyphicon-user"></i>
          		<span>회원가입</span>
          	</a></li>
          	</br>
          </br>
          	
          	<%}else{//세션 아이디가 로그인 중이면
          	%>
          	<br>
 			<br>
					<li align="center"><a href = "../doLogout.do">
          		<i class = "glyphicon glyphicon-ice-lolly-tasted"></i>
          		<span>로그아웃</span>
          	</a></li>
          	</br>
          </br>
			
			<%} %>
          
     <li class ="header" align = "center">MAIN MENU</li>
   	  	<%
 			 if(session.getAttribute("uid")!=null){ %>
          
   	  		<li>
              <a href="../listAll.do">
              <span class="glyphicons glyphicons-notes-2"></span>
                <i class="fa fa-edit"></i> <span>My page</span>
                <small class="label pull-right bg-yellow">new</small>
              </a>
            </li>
           <li class="treeview">
              <a href="#">
                <i class="fa fa-files-o"></i>
                <span>포트폴리오</span>
                <span class="label label-primary pull-right">준비중</span>
              </a>
              <ul class="treeview-menu">
                <li><a><i class="fa fa-circle-o"></i> 포트폴리오A</a></li>
                <li><a><i class="fa fa-circle-o"></i> 포트폴리오B</a></li>
                <li><a><i class="fa fa-circle-o"></i> 포트폴리오C</a></li>
                <li><a><i class="fa fa-circle-o"></i> 새로만들기</a></li>
              </ul>
            </li>
              <li>
              <a >
                <i class="fa fa-th"></i> <span>프로젝트</span> <small class="label pull-right bg-green">준비중</small>
              </a>
            </li>
            
              <%} %>
            
             <li class="treeview">
             	<a href="#">
                	<i class="fa fa-dashboard"></i> <span>커뮤니티</span> <i class="fa fa-angle-left pull-right"></i>
                </a>
              <ul class="treeview-menu">
              	<li><a href="/freeboard.do"><i class="fa fa-circle-o"></i>자유게시판<small class="label pull-right bg-red">new</small></a></li>
                <li><a href="/noticeboard.do"><i class="fa fa-circle-o"></i>공지사항<small class="label pull-right bg-purple">new</small></a></li>
              </ul>
            </li>
        </ul>
       </section>
        <!-- /.sidebar -->
      </aside>