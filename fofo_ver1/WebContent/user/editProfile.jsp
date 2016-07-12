<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                <!-- text input -->
                <div class="box-body">
                
                	
	                <div class="form-group">
	                
	                  <label for="exampleInputFile">Image</label>
	                  <br>
	                	<input type="image" name="image" src="data:image/png;base64,iVBORw0KGgoAAAANSU
	                	hEUgAAAHkAAAB5CAMAAAAqJH57AAAAMFBMVEXJx8f////x8fHGxMT6+vrW1dXn5ubMysrQzs7b2tr09
	                	PT39/fs7Ozq6enj4uLT0tLh5spbAAACjklEQVRoge2a247rIAxFIQ4BcuP//3ZCJh21PSHY7XYrHbHe+
	                	rQEJuBLjWk0Go1GQx0i+rjSeJ9S3HAp5J8f87q1G3u704/z6vxH3OTXm/WPaQj64jTYU+akqiUTn5f7
	                	Rz9oitNY8u7uoBbuVFzwoY5KalcRb6ioKdTF1joFs7mM8Y1J4fMqfE3PzPD9Zu31vt9gNc1Mse081sxe
	                	MvqQETPKGXCkO765h4oFm20t9BKNArFdgWJJmK1dkGZBmLfvCmmeJOYJ+UWz7mwVs2zNyFdD8lFtuQnQL
	                	Foz1CxaM3K3v3e2ZeYRaRbdJCNOLMgLMtA77Gv3tuytikhzkpihOWCQHG5sCig4YhNU/L0MkASBhh4w
	                	I3gz0JUVf7vhhRWjeD42G17SMa9u7MnOEPMaW/FdA95LCc3+bmbHWjJebFiRxkd5h3G80Q2DA1pr4ln
	                	Fm9WVRU96vc9KE1Bpr3cu71B8Q+qei/ONbgo9cvVaau51pni+B+2Jgi/st9Idck9hv7Va23ecVzq6x+s
	                	wnz6X6lHO5tOeCbJ+LInDaZh7lWb+o7k0r1I3h1KDSm9k9Ev5pVx0zVd5oOaMbsvFLp7JXiHtvOErhYb
	                	KRJbIu6Gehw3OQ+fwtM+6eeXNODjcED7ERdQDtHNM78vJxFmm3em7+Nb3TSa9oj1Y3KsLJ3Ki1t+/dPE
	                	1d3zTmxnlbgrL+97MnGTqy8tKRi8rL6sVlARBH1TWYEWqwWJ22sDtiEjgxVo0d2XSs+pbUf+eC2fCgPue
	                	HmDUe6Ab5Jl63eV1xFtCXlm0xsH+pZYgyiZTEqo1n2gaJ6HS9+b9Ieo1risvydRAyvWUQe+A1boKXzSzW
	                	skaZhM6NfRr+0aj0Wg0/hN+APmaGv2nJYnFAAAAAElFTkSuQmCC" width="100">
	                
	                </div>
					
	                <!-- listall을 거쳐서 돌아오는법? -->		
	                <ul class="list-group list-group-unbordered">
		                <li class="list-group-item">
		             
							<label for="name">Full name</label>
							<br>

	                		<input type="text" class="form-control" placeholder="" name="fullname" value="${data.getUEmail()}">
		                
		                <br>
			                	<label>Date of birth</label>
			                	<br>
								<a href="#" data-toggle="popover"  data-content='<button type="submit" class="btn btn-primary">edit</button>'  data-html="true">생일</a><br>
		                <br>
		                
							
		               </li>
		                <li class="list-group-item">
		                <label id="schoolLabel">학위</label>
		                <br>
						<a href="#" data-toggle="popover"  data-content='<button type="submit" class="btn btn-primary">remove</button>'  data-html="true">dd</a>
		                

			                 <br><br>
			                 <button class="btn btn-default" id="school">학위 추가</button>
		                 </li>
		                 
		                 <li class="list-group-item">
		                 <label id="careerLabel">경력</label>
		                 <br>
		                 
		                   <br><br>
			                 <button class="btn btn-default" id="career">경력 추가</button>
		                 </li>
		                 
		                 <li class="list-group-item">
		                 <label id="skillLabel">스킬</label>
		                   <br><br>
			                 <button class="btn btn-default" id="skill">스킬 추가</button>
		                 </li>
		                 
		                 <li class="list-group-item">
		                 <label id="awardLabel">수상 내역</label>
		                   <br><br>
			                 <button class="btn btn-default" id="award">수상 내역 추가</button>
		                 </li>
		                 
		                 <li class="list-group-item">
		                 <label id="languageLabel">구사 언어</label>
		                   <br><br>
			                 <button class="btn btn-default" id="language">구사 언어 추가</button>
		                 </li>
              		</ul>
	                <div class="col-xs-4">
          			     <button type="submit" class="btn btn-success btn-block btn-flat">OK</button>
         			</div><!-- /.col -->  
                </div>
                <!-- box-body -->            
            </div>
            <!-- /.box-primary -->       
          </div>
          <!-- /.col-md-6 left-->
       <div class="col-md-6" id="addSchool" style="display:none;">
      	    <div class="box box-solid">
	            <div class="box-header with-border">
	              <h3 class="box-title">학위 추가</h3>
	            </div>
           
            <!-- /.box-header -->
            
           <form action="../editProfile.do" method="post" name="frm">
	            <div class="box-body text-left">
	               
               	  <input type="hidden" name="formName" value="school">
               	<!-- name으로 폼구분 -->
		            <div>
		               	<label>학교</label>
		               	<!-- test용으로 id입력 -->
		                <input type="number" class="form-control" placeholder="" name="schoolName" onkeyup="showData(this.value);">
	               	</div>
	                <div>
		               	<label>학위</label>
		                <input type="text" class="form-control" placeholder="" name="degree">
	               	</div>
	                <div>
		               	<label>전공</label>
		                <input type="text" class="form-control" placeholder="" name="major">
	               	</div>
	               	<div>
		               	<label>입학 년월</label>
		                <input type="month" class="form-control" placeholder="" name="entrance">
	               	</div>
	               	<div>
		           		<label>졸업 년월</label>
		                <input type="month" class="form-control" placeholder="" name="graduation">
	               	</div>
               
               
	              <div class="modal-footer">
	                <button type="button" class="btn btn-default pull-left" id="closeSchool">Close</button>
	                <button type="submit" class="btn btn-primary" onclick="">Add</button>
	              </div>
	            </div>
	            </form>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
         <!-- /.col-md-6 -->
         
        <div class="col-md-6" id="addCareer" style="display:none;">
      		<div class="box box-solid">
            	<div class="box-header with-border">
             		<h3 class="box-title">경력 추가</h3>
           		</div>
           
            <!-- /.box-header -->
            
           <form action="../editProfile.do" method="post" name="frm2">
            <div class="box-body text-left">
               
            
               	  <input type="hidden" name="formName" value="career">
                
                <div>
	               	<label>경력사</label>
	                  <input type="text" class="form-control" placeholder="" name="careerName">
               	</div>
               	
                <div>
	               	<label>직위</label>
	                  <input type="text" class="form-control" placeholder="" name="position">
               	</div>
               	
                <div>
	               	<label>시작 년월</label>
	                  <input type="month" class="form-control" placeholder="" name="startDate">
               	</div>
               	 <div>
	               	<label>종료 년월</label>
	                  <input type="month" class="form-control" placeholder="" name="endDate">
               	</div>
                  
            	<div class="modal-footer">
               		 <button type="button" class="btn btn-default pull-left" id="closeCareer">Close</button>
               		 <button type="submit" class="btn btn-primary">Add</button>
              	</div>
            </div>
            <!-- /.box-body -->
            </form>
          </div>
          <!-- /.box -->
        </div>
         <!-- /.col-md-6 -->
         
        <div class="col-md-6" id="addSkill" style="display:none;">
      		<div class="box box-solid">
            	<div class="box-header with-border">
             		<h3 class="box-title">스킬 추가</h3>
           		</div>
           
            <!-- /.box-header -->
            
           <form action="../editProfile.do" method="post" name="frm3">
            <div class="box-body text-left">
               
               	  <input type="hidden" name="formName" value="skill">
                  	
                <div>
	               	<label>기술</label>
	                  <input type="text" class="form-control" placeholder="" name="skillName">
               	</div>
               		
                <div>
	               	<label>코멘트</label>
	                  <input type="text" class="form-control" placeholder="" name="skillComment">
               	</div>
               		
                
            	<div class="modal-footer">
               		 <button type="button" class="btn btn-default pull-left" id="closeSkill">Close</button>
               		 <button type="submit" class="btn btn-primary">Add</button>
              	</div>
            </div>
            </form>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col-md-6 -->
       
         <div class="col-md-6" id="addAward" style="display:none;">
      		<div class="box box-solid">
            	<div class="box-header with-border">
             		<h3 class="box-title">수상 내역 추가</h3>
           		</div>
           
            <!-- /.box-header -->
            
           <form action="../editProfile.do" method="post" name="frm4">
	            <div class="box-body text-left">
	            
               	  <input type="hidden" name="formName" value="award">
	            
	            <div>
	               	<label>상 이름</label>
	                  <input type="text" class="form-control" placeholder="" name="awardName">
               	</div>
  	         	 <div>
	               	<label>코멘트</label>
	                  <input type="date" class="form-control" placeholder="" name="awardComment">
               	</div>
	            	<div class="modal-footer">
	               		 <button type="button" class="btn btn-default pull-left" id="closeAward">Close</button>
	               		 <button type="submit" class="btn btn-primary">Add</button>
	              	</div>
	            </div>
            </form>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col-md-6 -->
        
         <div class="col-md-6" id="addLanguage" style="display:none;">
      		<div class="box box-solid">
            	<div class="box-header with-border">
             		<h3 class="box-title">구사 언어 추가</h3>
           		</div>
           
            <!-- /.box-header -->
            
           <form action="../editProfile.do" method="post" name="frm5">
            <div class="box-body text-left">
           
               	  <input type="hidden" name="formName" value="language">
               	  
              	 <div>
	               	<label>언어</label>
	                  <input type="text" class="form-control" placeholder="" name="languageName">
               	</div>
               	 <div>
	               	<label>언어</label>
	                  <input type="text" class="form-control" placeholder="" name="languageComment">
               	</div>
               	
               	
            	<div class="modal-footer">
               		 <button type="button" class="btn btn-default pull-left" id="closeLanguage">Close</button>
               		 <button type="submit" class="btn btn-primary">Add</button>
              	</div>
            </div>
            </form>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col-md-6 -->
        
      </div>
          <!-- right column -->
            
         <!-- /.right column -->
     
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
	
    <script>
     function showData(value){ 
     	$.ajax({
    	    url : "",
    	    type : "POST",
    	    async : false,
    	    success : function(data) {
    	//Do something with the data here
    	    }
    	});
    } 
 
    
    $(document).ready(function (){
   		//school
    	$("#school").click(function(){

    		$("#addSchool").show(500);
    		$("#addSchool").focus();
    		
        });
    	$("#closeSchool").click(function(){
            $("#addSchool").hide(500);
        });
		//career
    	$("#career").click(function(){

    		$("#addCareer").show(500);
    		$("#addCareer").focus();
    		
        });
    	$("#closeCareer").click(function(){
            $("#addCareer").hide(500);
        });
		//skill
    	$("#skill").click(function(){

    		$("#addSkill").show(500);
    		$("#addSkill").focus();
    		
        });
    	$("#closeSkill").click(function(){
            $("#addSkill").hide(500);
        });
    	//award
    	$("#award").click(function(){

    		$("#addAward").show(500);
    		$("#addAward").focus();
    		
        });
    	$("#closeAward").click(function(){
            $("#addAward").hide(500);
        });
    	//language
    	$("#language").click(function(){

    		$("#addLanguage").show(500);
    		$("#addLanguage").focus();
    		
        });
    	$("#closeLanguage").click(function(){
            $("#addLanguage").hide(500);
        });
    
    });
    
   
    
    $(document).ready(function(){
        $('[data-toggle="popover"]').popover().focus();
    });
    
    function formCheck(){
    	
    }
    
  
    </script>
    
  </body>

<%@ include file="../include/footer.jsp" %>
