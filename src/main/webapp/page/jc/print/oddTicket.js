$(function(){
	var batchno=UrlParm.parm("batchno");
	// $("#batchno").html(batchno);
	$.ajax({
		type:'POST',
		url:'/management/jc/print/oddTicketList',
		data:'batchno=' + batchno,
		dataType:'json',
		success:function(data){
			$("#batchno").html(batchno);
			$("#shipno").html(shipno);
			$("#shipno_1").html("*" + shipno + "*");
			$("#shortname").html(shortname);
		},
		error:function(){
			alert("数据错误，联系管理员");
		}
	});
});

function doJqprint(){
	$("#d").jqprint();
}