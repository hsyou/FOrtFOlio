/**
 * 		Writer	: Yeajee Kim
 */

$(document).ready(function(){
	
	$(".saveCbtn").hide();
	$(".cancelCbtn").hide();
	$(".nCommentContent_m").hide();
	
	var formObj = $("form[role = 'gpost']");
	console.log(formObj);
	
	$("#ModifyPost").on("click", function(){
		formObj.attr("action", "/modifyviewnoticeboard.do");
		formObj.attr("method", "post");
		formObj.submit();
	});
	
	$("#RemovePost").on("click", function(){
		formObj.attr("action", "/removenoticeboard.do");
		formObj.attr("method", "post");
		formObj.submit();
	});
	
	var formObj3 = $("form[role = 'addcomt']");
	console.log(formObj3);
	
	$("#addcomment").on("click", function(){
		formObj3.attr("action", "/addnoticecomment.do");
		formObj3.attr("method", "post");
		formObj3.submit();
	});
});

jQuery(document).ready(function() {
	
	$(".modifyCbtn").click(function(){
		$(this).hide();
		var removeCbtn = $(this).siblings(".removeCbtn");
		removeCbtn.hide();
		var nCommentContent_b = $(this).parent().siblings(".timeline-body").children(".nCommentContent_b");
		nCommentContent_b.hide();
		
		var saveCbtn = $(this).siblings(".saveCbtn");
		saveCbtn.show();
		var cancelCbtn = $(this).siblings(".cancelCbtn");
		cancelCbtn.show();
		var nCommentContent_m = $(this).parent().siblings(".timeline-body").children(".nCommentContent_m");
		nCommentContent_m.show();
	});
	
	$(".removeCbtn").click(function(){
		var nCommentId = $(this).parent().siblings(".timeline-body").children("#nCommentId").val();
		var nPostId = $(this).parent().siblings(".timeline-body").children("#nPostId").val();
	    $.post("removenoticecomment.do",
	    {
	    	nPostId: nPostId,
	    	nCommentId: nCommentId
	    },
	    function(data){
	    	alert(""+nCommentId+"번댓글 삭제되었습네다");
	    });
	    var remove_replyLi = $(this).parent().parent().parent(".replyLi");
	    remove_replyLi.remove();
	});
	
	$(".saveCbtn").click(function(){
		var nPostId = $(this).parent().siblings(".timeline-body").children("#nPostId").val();
		var nCommentId = $(this).parent().siblings(".timeline-body").children("#nCommentId").val();
		var nCommentContent = $(this).parent().siblings(".timeline-body").children("#nCommentContent_m").val();
	    $.post("modifynocicecomment.do",
	    {
	    	nPostId: nPostId,
	    	nCommentId: nCommentId,
	    	nCommentContent: nCommentContent
	    },
	    function(data){
	    	alert(""+nCommentId+"번 댓글 수정되었습니당");
	    });
	    
	    $(this).hide();
		var cancelCbtn = $(this).siblings(".cancelCbtn");
		cancelCbtn.hide();
		var nCommentContent_m = $(this).parent().siblings(".timeline-body").children(".nCommentContent_m");
		nCommentContent_m.hide();
		
		var removeCbtn = $(this).siblings(".removeCbtn");
		removeCbtn.show();
		var modifyCbtn = $(this).siblings(".modifyCbtn");
		modifyCbtn.show();
		var nCommentContent_b = $(this).parent().siblings(".timeline-body").children(".nCommentContent_b");
		nCommentContent_b.text(""+nCommentContent);
		nCommentContent_b.show();
	});
	
	$(".cancelCbtn").click(function(){
		var nPostId = $(this).parent().siblings(".timeline-body").children("#nPostId").val();
		$.post("getnoticeboard.do", {
			 nPostId: nPostId
		}, function(data){
			alert("취소되었습니다");
		});
 
		$(this).hide();
		var saveCbtn = $(this).siblings(".saveCbtn");
		saveCbtn.hide();
		var nCommentContent_m = $(this).parent().siblings(".timeline-body").children(".nCommentContent_m");
		nCommentContent_m.hide();
		
		var removeCbtn = $(this).siblings(".removeCbtn");
		removeCbtn.show();
		var modifyCbtn = $(this).siblings(".modifyCbtn");
		modifyCbtn.show();
		var nCommentContent_b = $(this).parent().siblings(".timeline-body").children(".nCommentContent_b");
		nCommentContent_b.show();
	});
});