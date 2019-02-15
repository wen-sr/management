$(function(){
	var batchno=UrlParm.parm("batchno");
	// $("#batchno").html(batchno);
	$.ajax({
		type:'POST',
		url:'/management/jc/print/t_ticketList',
		data:'batchno=' + batchno,
		dataType:'json',
		success:function(data){
			var html = "";
            for(var i=0;i< data["list"].length;i++){
            html += "<div class='data'>" +
                    "<div class='d_subcode'>" + data['list'][i].issuenumber + data['list'][i].subcode + "</div>" +
                    "<div class='d_batchno'>批次号：" + data['list'][i].batchno +"</div>" +
                "<div class='d_shipno'>运输号：" + data['list'][i].shipno +"</div>" +
                "<div class='d_shipno_1'>*"+ data['list'][i].shipno +"*</div>" +
                    "<div class='d_shortname'>收件方："+ data['list'][i].shortname +"</div>" +
                "<div class='d_caseqty'>包件数："+ data['list'][i].caseqty + "/" + data['list'][i].caseqty +"</div>" +
                "<div class='d_note'>" +
                    "<span style='font-size:25px;font-weight:bold;padding:1px;border:1px solid #000;'>教材</span>" +
                    "</div>" +
                    "<div class='d_buttom'>" +
                    "<h2>江西新华物流有限公司</h2>" +
                    "</div>" +
                    "</div>";
            }
			$("#d").append(html);
		},
		error:function(){
			alert("数据错误，联系管理员");
		}
	});
});

function doJqprint(){
	$("#d").jqprint();
}