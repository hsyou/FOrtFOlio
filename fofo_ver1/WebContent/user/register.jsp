<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../include/header.jsp" %>

 <body class="hold-transition register-page">
  <div class="wrapper">
  <div class="content-wrapper">
  	<!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            User Register
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">User Register</li>
          </ol>
        </section>
        
    <div class="register-box">
      <div class="register-logo">
        <a href="../home.jsp"><b>Admin</b>LTE</a>
      </div>

      <div class="register-box-body">
        <p class="login-box-msg">Register a new membership</p>
        <%if(request.getAttribute("join")=="error"){
		          	%>
		          <div class="alert alert-danger alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                <h4><i class="icon fa fa-ban"></i> Alert!</h4>
               	이메일 중복
              </div>
		          <%} %>
           <form action="../doJoin.do" method="post" name="frm">
          <div class="form-group has-feedback">
            <input type="text" class="form-control" placeholder="Nickname" name="name" id="name" >
            <span class="glyphicon glyphicon-user form-control-feedback" ></span>
             <p id="namecheck"></p>
          </div>
          <div class="form-group has-feedback">
            <input type="text" class="form-control" placeholder="Email" name="email" id="email">
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
             <p id="emailcheck"></p>
          </div>
        	
          <div class="form-group has-feedback">
            <input type="password" class="form-control" placeholder="Password" name="pw" id="pw" >
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="password" class="form-control" placeholder="Retype password" name="pw2" id="pw2" >
            <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
            <p id="pwcheck"></p>
          </div>
         <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox" required> I agree to the <a href="#">terms</a>
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat">Register</button>
        </div>
        <!-- /.col -->
      </div>
    </form>

       
        

        <div class="social-auth-links text-center">
          <p>- OR -</p>
          <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign up using Facebook</a>
          <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign up using Google+</a>
        </div>
        <a href="login.html" class="text-center">I already have a membership</a>
      </div><!-- /.form-box -->
    </div><!-- /.register-box -->
    </div>

  
    </div>
  </body>
  
  <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
     
      function joinCheck(){
		var count=0;
    	  if(document.frm["name"].value==""){
    		  $("#name").css("border","1px solid red");
    		  $("#namecheck").text("Please Check your name");
    		  $("#namecheck").css("color","red");
    		  count++;
    	  }else{
    		  $("#namecheck").text("");
    		  $("#name").css("border","1px solid #66cc33");
    		  
    	  }
    	  if(document.frm["pw"].value!=(document.frm["pw2"].value)||document.frm["pw"].value==""){
    		  $("#pwcheck").text("Password does not match");
    		  $("#pwcheck").css("color","red");
    		  $("#pw").css("border","1px solid red");
    		  $("#pw2").css("border","1px solid red");
    		  count++;
    	  }else{
    		  $("#pwcheck").text("");
    		  $("#pw").css("border","1px solid #66cc33");
    		  $("#pw2").css("border","1px solid #66cc33");
    		  
    	  }
    	 
    	  if(document.frm["name"].value==""){
    		  $("#name").css("border","1px solid red");
    		  $("#namecheck").text("Please Check your name");
    		  $("#namecheck").css("color","red");
    		  count++;
    	  }else{
    		  $("#namecheck").text("");
    		  $("#name").css("border","1px solid #66cc33");
    		  
    	  }
    	  if(document.frm["email"].value==""){
    		  
    		  $("#email").css("border","1px solid red");
    		  $("#emailcheck").text("Please Check your email");
    		  $("#emailcheck").css("color","red");
    		  count++;
    		  
    	  }
    	    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		    if( re.test(document.frm["email"].value)){
		    	$("#emailcheck").text("");
	    		  $("#email").css("border","1px solid #66cc33");
	    		  
		    }else{
		    	$("#email").css("border","1px solid red");
	    		  $("#emailcheck").text("Please Check your email");
	    		  $("#emailcheck").css("color","red");
	    		  count++;
		    }   
		      
    	  if(count!=0){
    		  return false;
    	  }else{
    		  return true;
    	  } 
      }
      
    </script>


<%@ include file="../include/footer.jsp" %>
    