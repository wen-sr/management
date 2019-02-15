/**
 * 整件清单
 */
function wholeCaseList(){
	if(isExistBatchno()){
		var batchno = $("#batchno").combobox('getValue');
		window.open('/management/page/jc/print/wholeCaseList.jsp?batchno='+batchno,'_blank');
	}else{
		$.messager.alert("操作提示","请先选择批次号","error");
	}
}
/**
 * 调拨单
 */
function allocationList(){
	if(isExistBatchno()){
		var batchno = $("#batchno").combobox('getValue');
		window.open('/management/page/jc/print/allocationList.jsp?batchno='+batchno,'_blank');
	}else{
		$.messager.alert("操作提示","请先选择批次号","error");
	}
}
/**
 * 小票
 */
function s_ticketList(){
	if(isExistBatchno()){
		var batchno = $("#batchno").combobox('getValue');
		window.open('/management/page/jc/print/s_ticket.jsp?batchno='+batchno,'_blank');
	}else{
		$.messager.alert("操作提示","请先选择批次号","error");
	}
}
/**
 * 尾包票签
 */
function t_ticketList(){
	if(isExistBatchno()){
		var batchno = $("#batchno").combobox('getValue');
		window.open('/management/page/jc/print/t_ticket.jsp?batchno='+batchno,'_blank');
	}else{
		$.messager.alert("操作提示","请先选择批次号","error");
	}
}

/**
 * 零件清单
 */
function oddCaseList(){
	if(isExistBatchno()){
		var batchno = $("#batchno").combobox('getValue');
		window.open('/management/page/jc/print/oddCaseList.jsp?batchno='+batchno,'_blank');
	}else{
		$.messager.alert("操作提示","请先选择批次号","error");
	}
}
/**
 * 拼包票签
 */
function oddTicketList(){
	if(isExistBatchno()){
		var batchno = $("#batchno").combobox('getValue');
		window.open('/management/page/jc/print/oddTicket.jsp?batchno='+batchno,'_blank');
	}else{
		$.messager.alert("操作提示","请先选择批次号","error");
	}
}

/**
 * 判断是否选中批次号
 */
function isExistBatchno(){
	var batchno = $("#batchno").combobox('getValue');
	if(batchno == ''){
		return false;
	}
	return true;
}
/**
 * 拣货单
 */
function pickList(){
	var pickno = $("#pickno").combobox('getValue');
	if(pickno == ''){
		$.messager.alert("操作提示","请先选择拣货流水号","error");
		return;
	}
	window.open('/management/page/jc/print/pickList.jsp?pickno='+pickno,'_blank');
}

$(function(){
	
});