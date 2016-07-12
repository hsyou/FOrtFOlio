/**
 * 		Writer	: Yeajee Kim
 */

$(document).ready(function(){
	
	var formObj = $("form[role = 'readm']");
	console.log(formObj);
	
	$(".item").on("click", function(){
		formObj.attr("action", "/readmessage.do");
		formObj.attr("method", "post");
		formObj.submit();
	});
	
});

jQuery(document).ready(function() {
	
	$(".modifyCbtn").click(function(){
		$(this).hide();
		var removeCbtn = $(this).siblings(".removeCbtn");
		removeCbtn.hide();
		var fCommentContent_b = $(this).parent().siblings(".timeline-body").children(".fCommentContent_b");
		fCommentContent_b.hide();
		
		var saveCbtn = $(this).siblings(".saveCbtn");
		saveCbtn.show();
		var cancelCbtn = $(this).siblings(".cancelCbtn");
		cancelCbtn.show();
		var fCommentContent_m = $(this).parent().siblings(".timeline-body").children(".fCommentContent_m");
		fCommentContent_m.show();
	});
	
	$(".removeCbtn").click(function(){
		var fCommentId = $(this).parent().siblings(".timeline-body").children("#fCommentId").val();
		var fPostId = $(this).parent().siblings(".timeline-body").children("#fPostId").val();
	    $.post("removefreecomment.do",
	    {
	    	fPostId: fPostId,
	    	fCommentId: fCommentId
	    },
	    function(data){
	    	alert(""+fCommentId+"번댓글 삭제되었습네다");
	    });
	    var remove_replyLi = $(this).parent().parent().parent(".replyLi");
	    remove_replyLi.remove();
	});
	
	$(".saveCbtn").click(function(){
		var fPostId = $(this).parent().siblings(".timeline-body").children("#fPostId").val();
		var fCommentId = $(this).parent().siblings(".timeline-body").children("#fCommentId").val();
		var fCommentContent = $(this).parent().siblings(".timeline-body").children("#fCommentContent_m").val();
	    $.post("modifyfreecomment.do",
	    {
	    	fPostId: fPostId,
	    	fCommentId: fCommentId,
	    	fCommentContent: fCommentContent
	    },
	    function(data){
	    	alert(""+fCommentId+"번 댓글 수정되었습니당");
	    });
	    
	    $(this).hide();
		var cancelCbtn = $(this).siblings(".cancelCbtn");
		cancelCbtn.hide();
		var fCommentContent_m = $(this).parent().siblings(".timeline-body").children(".fCommentContent_m");
		fCommentContent_m.hide();
		
		var removeCbtn = $(this).siblings(".removeCbtn");
		removeCbtn.show();
		var modifyCbtn = $(this).siblings(".modifyCbtn");
		modifyCbtn.show();
		var fCommentContent_b = $(this).parent().siblings(".timeline-body").children(".fCommentContent_b");
		fCommentContent_b.text(""+fCommentContent);
		fCommentContent_b.show();
	});
	
	$(".cancelCbtn").click(function(){
		var fPostId = $(this).parent().siblings(".timeline-body").children("#fPostId").val();
		$.post("getfreeboard.do", {
			 fPostId: fPostId
		}, function(data){
			alert("취소되었습니다");
		});
 
		$(this).hide();
		var saveCbtn = $(this).siblings(".saveCbtn");
		saveCbtn.hide();
		var fCommentContent_m = $(this).parent().siblings(".timeline-body").children(".fCommentContent_m");
		fCommentContent_m.hide();
		
		var removeCbtn = $(this).siblings(".removeCbtn");
		removeCbtn.show();
		var modifyCbtn = $(this).siblings(".modifyCbtn");
		modifyCbtn.show();
		var fCommentContent_b = $(this).parent().siblings(".timeline-body").children(".fCommentContent_b");
		fCommentContent_b.show();
	});
});