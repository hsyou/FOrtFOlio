<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.fofo.member.vo.Member" %>
<%@ page import="org.fofo.member.dao.MemberDAOImpl" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../include/header.jsp" %>

<body class="hold-transition login-page">
 
  <div class="content-wrapper">
  	<!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Profile
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Profile</li>
          </ol>
        </section>
  

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <!-- left column -->
        <div class="col-md-6">
        <!-- profile form -->
			<div class="box box-primary">
            	<div class="box-header with-border">
              		<h3 class="box-title">Profile</h3>
            	</div>
           <form action="/user/editProfile.jsp" method="post" name="frm">
                <!-- text input -->
                <div class="box-body">
                
                	
               	  <input type="hidden" name="from" value="profile">
	                <div class="form-group">
	                
	                		
	                <ul class="list-group list-group-unbordered">
		                <li class="list-group-item">
		                  	
						
							<label>Email</label>
							<br>
								<p>${data.getuEmail()}</p><br>
							
							<label>Full name</label>
							<br>
							${resume.getName()}<a href="#" data-toggle="popover"  data-content='<form action="../editProfile.do?formName=fullName" method="post"><input type="text" class="form-control" value="${resume.getName()}" name="fullName">  <button type="submit" class="btn btn-primary popEdit">edit</button></form>'  data-html="true">    수정</a>
		                    <br><br>
			                
			                <label>English Name</label>
							<br>
							${resume.getEngName()}<a href="#" data-toggle="popover"  data-content='<form action="../editProfile.do?formName=engName" method="post"><input type="text" class="form-control" value="${resume.getEngName()}" name="engName">  <button type="submit" class="btn btn-primary popEdit">edit</button></form>'  data-html="true">    수정</a>
							<br><br>
														
							<label>Nickname</label>
							<br>
							${data.getuNickname()}<a href="#" data-toggle="popover"  data-content='<form action="../editProfile.do?formName=nickName" method="post"><input type="text" class="form-control" value="${data.getuNickname()}" name="nickName">  <button type="submit" class="btn btn-primary popEdit">edit</button></form>'  data-html="true">    수정</a>
							<br><br>
								
			                <label>Date of birth</label>
							<br>
							${resume.getBirth()}<a href="#" data-toggle="popover"  data-content='<form action="../editProfile.do?formName=birth" method="post"><input type="text" class="form-control" value="${resume.getBirth()}" name="birth">  <button type="submit" class="btn btn-primary popEdit">edit</button></form>'  data-html="true">    수정</a>
							<br><br>
		                   
		                
		               </li>
		              

		                 <li class="list-group-item">
		                 <label>학교</label>
		                 	<p>${resume.getSchool()}</p>
		                 	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#school">Edit</button>

		                 </li>
		                  <li class="list-group-item">
		                 <label>경력</label>
		                 	<p>${resume.getCareer()}</p>
		                 	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#career">Edit</button>
		                 </li>
		                  <li class="list-group-item">
		                 <label>스킬</label>
		                 	<p>${resume.getSkill()}</p>
		                 	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#skill">Edit</button>
		                 </li>
		                   <li class="list-group-item">
		                 <label>수상 내역</label>
		                 	<p>${resume.getAward()}</p>
		                 	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#award">Edit</button>
		                 </li>
		                   <li class="list-group-item">
		                 <label>구사 언어</label>
		                 	<p>${resume.getLanguage()}</p>
		                 	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#language">Edit</button>
		                 </li>
              		</ul>
	                
	                
                </div>
                <!-- box-body -->
              </form>
            </div>
            <!-- /.box-primary -->
          </div>
          <!-- /.col-md-6 left-->
          </div>
          <!-- right column -->
         <!-- /.right column -->
     <!-- Modal -->
  <div class="modal fade" id="school" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
      <form action="../editProfile.do?formName=school" method="post">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">학교</h4>
        </div>
        <div class="modal-body">
          <textarea class="form-control" name="school" rows="3">${resume.getSchool()}</textarea>
          </div>
          <div class="modal-footer">
          <button type="submit" class="btn btn-primary" >add</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
        </form>
      </div>
      
    </div>
  </div>
  
      <!-- Modal -->
  <div class="modal fade" id="skill" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
      <form action="../editProfile.do?formName=skill" method="post">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">스킬</h4>
        </div>
        <div class="modal-body">
          <textarea class="form-control" name="skill" rows="3">${resume.getSkill()}</textarea>
          </div>
          <div class="modal-footer">
          <button type="submit" class="btn btn-primary" >add</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
        </form>
      </div>
      
    </div>
  </div>
      <!-- Modal -->
  <div class="modal fade" id="career" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
      <form action="../editProfile.do?formName=career" method="post">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">경력</h4>
        </div>
        <div class="modal-body">
          <textarea class="form-control" name="career" rows="3">${resume.getCareer()}</textarea>
          </div>
          <div class="modal-footer">
          <button type="submit" class="btn btn-primary" >add</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
        </form>
      </div>
      
    </div>
  </div>
      <!-- Modal -->
  <div class="modal fade" id="award" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
      <form action="../editProfile.do?formName=award" method="post">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">수상</h4>
        </div>
        <div class="modal-body">
          <textarea class="form-control" name="award" rows="3">${resume.getAward()}</textarea>
          </div>
          <div class="modal-footer">
          <button type="submit" class="btn btn-primary" >add</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
        </form>
      </div>
      
    </div>
  </div>
      <!-- Modal -->
  <div class="modal fade" id="language" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
      <form action="../editProfile.do?formName=language" method="post">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">언어</h4>
        </div>
        <div class="modal-body">
          <textarea class="form-control" name="language" rows="3">${resume.getLanguage()}</textarea>
          </div>
          <div class="modal-footer">
          <button type="submit" class="btn btn-primary" >add</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
        </form>
      </div>
      
    </div>
  </div>
     
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
	
    <script>
    $(document).ready(function(){
        $('[data-toggle="popover"]').popover().focus();
    });
        
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
      
  /*     $(function () {
        //Datemask dd/mm/yyyy
        $("[data-mask]").inputmask("mm/dd/yyyy", {"placeholder": "mm/dd/yyyy"});      
      });
       */
    </script>
    
  </body>

<%@ include file="../include/footer.jsp" %>
