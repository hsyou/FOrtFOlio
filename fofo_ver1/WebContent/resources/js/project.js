/**
 * Writer 		: Kyoung-ah Kwon
 * 
 */


$(document).ready(function() {
	
	listEditableFlag = 0;	// 0: unavailable, 1: available
	nTabNum = 0;
	
	$(".blockList").sortable({
		cancel:".blockUnsortable"
	});
	
	
	/* Remote Controller */
	// <![CDATA[
	var name = "#floatMenu";
	var menuYloc = null;
	
//	$(document).ready(function(){
	menuYloc = parseInt($(name).css("top").substring(0,$(name).css("top").indexOf("px")))
	$(window).scroll(function () { 
		offset = menuYloc+$(document).scrollTop()+"px";
		$(name).animate({top:offset},{duration:500,queue:false});
	});
//	}); 
	// ]]>
	
	
	
	
});

jQuery(document).ready(function() {
	
	var uid = 123;
	
	
	
	$("#addProjectBtn").click(function(e){
		var name = $("#newProjectName").val();
		
		$.post("addProject.do",
			{
				projectName: name
			}	
		);
		addNewProject(name);
	});
	
	$("#editBlockOrder").click(function(e){
		editBlockOrder($(this));
	});
	
	$("#endEditBlockOrder").click(function(e){
		endEditBlockOrder($(this));
	});

	$("#saveThisProject").click(function(e){
		var activeTab = document.getElementById("projectTab").getElementsByClassName("active")[0];
		var pId = activeTab.getElementsByClassName("hiddenProjectId")[0].value;
		
		var selectedTab = document.getElementsByClassName("tab-pane fade active in")[0];
		var content = selectedTab.getElementsByClassName("blockList")[0].innerHTML;
		
		$.post("updateThisProject.do",
			{
				projectId: pId,
				projectContent: content
			}
		);
		
	});
	
	
});


	

/*$(document).on('click', '#btnProjectTabAdd', function(){

});*/

$(document).on('click', '.loadProjectBtn', function(e){
	loadProjectContent($(this));
});

$(document).on('click', '.deleteProjectBtn', function(e){
	deleteProject($(this));
});




$(document).on('click', '.addBlock', function(){
	addBlock($(this));
});


$(document).on('click', '.editBlockBtn', function(){ 
	setEditBlockMode($(this));
});

$(document).on('click', '.endEditBlockBtn', function(){ 
	endEditBlockMode($(this));
});

$(document).on('click', '.delBlockBtn', function(){
	delBlock($(this));
});

$(document).on('click', '.closeTab', function(){
	closeTab($(this));
});



/* ============================== Tab Control ============================== */

function closeTab($closeBtn){
	var targetTab = $closeBtn.parent().parent();
	var targetContent = $closeBtn.parent().attr('href');
	
//	alert(parent);
	$(targetContent).remove();
	targetTab.remove();
}

/* load project and add it to the tab */
function addTabWithMyProject($projectName, pId, data){
	var nextTab = $('#projectTab li').size()+1;
	var tabId = "LoadedMyProject_" + $projectName;
	var projectTab = document.getElementById("projectTab");
	
  	$('<li role="presentation">'
  			+'<a href="#'+tabId+'" aria-controls="'+tabId+'" role="tab" data-toggle="tab">'
  			+$projectName
  			+' <span class="closeTab glyphicon glyphicon-remove" ></span>'
  			+'<input class="hiddenProjectId" type="text" name="projectId" value="'+ pId +'" style="display: none;">'
  			+'</a></li>').insertBefore('#liProjectTabAdd');
  	
  	if(listEditableFlag == 1){
  		$('<div role="tabpanel" class="tab-pane fade" id="'+ tabId + '">'
  	  			+ '<div class="projectContent">'
  				+ '<ul class="blockList list-unstyled draggableList">'
  				+ data
  				+ '</ul>'
  				+ '<div class="table-hover addBlock">'
  				+ '블록 추가 <span id="addBlockGlyp" class="glyphicon glyphicon-plus" aria-hidden="true"></span>'
  				+ '</div></div>'
  	  			+ '</div>').appendTo('.projectTab-content');
	}else{
		$('<div role="tabpanel" class="tab-pane fade" id="'+ tabId + '">'
	  			+ '<div class="projectContent">'
				+ '<ul class="blockList list-unstyled draggableList blockUnsortable">'
				+ data
				+ '</ul>'
				+ '<div class="table-hover addBlock">'
				+ '블록 추가 <span id="addBlockGlyp" class="glyphicon glyphicon-plus" aria-hidden="true"></span>'
				+ '</div></div>'
	  			+ '</div>').appendTo('.projectTab-content');
	}
  	$("#addProjectName").val('');
  	
  	$('#projectTab a:last').tab('show');
//  	$('#projectTab a:nth-last-child(1)').tab('show');	//자잘한 에러
  	
  	$(".blockList").sortable({
		cancel:".blockUnsortable"
  	});
  	
  	
  	
  	/* add project content tag(not real tag) */
  	var thisTab = document.getElementById(tabId);//.find(".blockList");
  	var $thisBlock = thisTab.getElementsByClassName('blockList');
//  	var contentTag = "${ projectContent}";
  	
//  	$("${ projectContent }").appendTo(thisBlock);
//  	$thisBlock.append(contentTag);
  	
  	
  	/* add real content in tab */
}


/* ============================== Project Control ============================== */

/* Add new project */
function addNewProject(projectName){
	var nextTab = $('#projectTab li').size()+1;
	
	var projectTab = document.getElementById("projectTab");
  	$('<li role="presentation">'
  			+'<a href="#'+projectName+'" aria-controls="'+projectName+'" role="tab" data-toggle="tab">'
  			+projectName
  			+' <span class="closeTab glyphicon glyphicon-remove" aria-hidden="true"></span>'
  			+'</a></li>').insertBefore('#liProjectTabAdd');
  	
  	if(listEditableFlag == 1){
  		$('<div role="tabpanel" class="tab-pane fade" id="'+ projectName + '">'
  	  			+ '<div class="projectContent">'
  				+ '<ul class="blockList list-unstyled draggableList"></ul>'
  				+ '<div class="table-hover addBlock">'
  				+ '블록 추가 <span id="addBlockGlyp" class="glyphicon glyphicon-plus" aria-hidden="true"></span>'
  				+ '</div></div>'
  	  			+ '</div>').appendTo('.projectTab-content');
	}else{
		$('<div role="tabpanel" class="tab-pane fade" id="'+ projectName + '">'
	  			+ '<div class="projectContent">'
				+ '<ul class="blockList list-unstyled draggableList blockUnsortable"></ul>'
				+ '<div class="table-hover addBlock">'
				+ '블록 추가 <span id="addBlockGlyp" class="glyphicon glyphicon-plus" aria-hidden="true"></span>'
				+ '</div></div>'
	  			+ '</div>').appendTo('.projectTab-content');
	}
  	$("#addProjectName").val('');
  	
  	$('#projectTab a:last').tab('show');
//  	$('#projectTab a:nth-last-child(1)').tab('show');	//자잘한 에러
  	
  	$(".blockList").sortable({
		cancel:".blockUnsortable"
	});
  	
  	/* 프로젝트 리스트 업데이트*/
  	var uid = 123;
	$.post("loadProjectList.do",
		{
			userId : uid
		}, function(data){
			updateMyProjectList(data);
		}
	);
}


function loadProjectContent($loadBtn){
	var pId = $loadBtn.parent().siblings(".listProjectId").html();
	var name = $loadBtn.parent().siblings(".listProjectName").html();
//	var update = $loadBtn.parent().siblings(".listLastUpdate").html();
	
//	alert("name: " + name + "\nupdate: " + update);
	
//	var uid = 123;
	
	$.post("loadProjectContent.do",
		{
			projectId: pId
		}, function(data){
//			alert(data);
			addTabWithMyProject(name, pId, data);
		}
	);

}

/* 삭제하고 난 다음에도 갖다 쓸 수 ㅇ있도록 고치기 */
function updateMyProjectList(data){
	var listPlace = $("#projectListDiv");//document.getElementById("projectListDiv");
	$("#projectListDiv").html("");

	$(data).appendTo(listPlace);
}


function deleteProject($deleteBtn){
	var pId = $deleteBtn.parent().siblings(".listProjectId").html();
	var name = $deleteBtn.parent().siblings(".listProjectName").html();
//	var update = $loadBtn.parent().siblings(".listLastUpdate").html();
	
//	alert("name: " + name + "\nupdate: " + update);
	
//	var pId = 123;
	
	$.post("deleteProject.do",
		{
			projectId: pId
		}, function(data){
			updateMyProjectList(data);
		}
	);

}

/* ============================== Block Control ============================== */

/* Add new block */
function addBlock($addBlock){
	var blockList = $addBlock.siblings(".blockList");
	
	$('<li class="panel panel-info">'
			+ '<div class="block">'
			+ '<div class="blockMover"><span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span></div>'
			+ '<div class="blockContent"><p></p></div>'
			+ '<input class="btn btn-warning editBlockBtn" type="button" value="수정">'
			+ '<input class="btn btn-success endEditBlockBtn" type="button" value="완료" style="display: none;">'
			+ '<input class="btn btn-danger delBlockBtn" type="button" value="삭제">'
			+ '</div></li>').appendTo(blockList);
	
	if(listEditableFlag == 1){
		editBlockListUpdate();
	}
}



/* Edit Block Order */
function editBlockOrder($this){
	
	listEditableFlag = 1;
	$('.editBlockBtn').attr("disabled","disabled");		//열려있는 탭에 대해서만 하도록 변경? or not?
	$('.endEditBlockBtn').attr("disabled","disabled");
	$('.delBlockBtn').attr("disabled","disabled");
	
	$('.blockList').removeClass("blockUnsortable");
	
	$this.hide();
	$('#endEditBlockOrder').show();
}
/* Edit Block Order (When new block added during 'edit block order' mode) */
function editBlockListUpdate(){
	$('.editBlockBtn').attr("disabled","disabled");
	$('.endEditBlockBtn').attr("disabled","disabled");
	$('.delBlockBtn').attr("disabled","disabled");
}

/* End editing block order */
function endEditBlockOrder($this){
	
	listEditableFlag = 0;
	$('.editBlockBtn').removeAttr( "disabled" );
	$('.endEditBlockBtn').removeAttr( "disabled" );
	$('.delBlockBtn').removeAttr( "disabled" );
	
	$('.blockList').addClass("blockUnsortable");
	
	$this.hide();
	$('#editBlockOrder').show();
}



/* Edit block content */
function setEditBlockMode($editBtn) {
	
	var endEditBtn = $editBtn.siblings(".endEditBlockBtn");
	
	var contentObj = $editBtn.siblings(".blockContent");
	var content = $editBtn.siblings(".blockContent").html();
//	var block = $editBtn.parent();
	var editor = $('<div class="summernote">'+content+'</div>');
	editor.insertBefore($editBtn);	 
	
	var summernote = $editBtn.siblings(".summernote");
	
	/* Initiate editor */
	summernote.summernote({
		lang : 'ko-KR' // default: 'en-US'
	});
	
	
	contentObj.remove();

	$editBtn.hide();
	endEditBtn.show();
}

/* End editing block mode */
function endEditBlockMode($endEditBtn){
	var content = $(".summernote").summernote('code');
	var noteEditor = $endEditBtn.siblings(".note-editor");
	noteEditor.remove();
	
	var editBtn = $endEditBtn.siblings(".editBlockBtn");
	
	var newContent = $('<div class="blockContent">'+ content +'</div>');
	newContent.insertBefore(editBtn);
	
	var summernote = $endEditBtn.siblings(".summernote");
	summernote.remove();
	
	$endEditBtn.hide();
	editBtn.show();
}

/* Delete block */
function delBlock($delBtn){
	var block = $delBtn.parent().parent();
	console.log(block);
	block.remove();
}

