/**
 * 加载需整件发货的信息
 * @returns
 */
function loadWaitShipData(pageSize, method, formData){

	$("#data").datagrid({
		url:'/management/jc/compute/wholeShipInfoTotal',
		method: method || 'GET',
		queryParams:formData || '',
		height:'auto',	
		fitColumns: true,
		striped:true,
		rownumbers:true,
		border:true,
		singleSelect:true,
		pagination:true,
        pageSize:pageSize || 20,
        pageList:[10,20,50],
		showFooter: true,
		toolbar:'#tb',
		columns:[[{
			field:"id",
		    title:"编号",
		    checkbox:true,
		    width:50
		},{
			field:"issuenumber",
			title:"期号",
		    width:50
		},{
			field:"subcode",
			title:"征订代码",
		    width:50
		},{
			field:"barcode",
			title:"条码",
		    width:50
		},{
			field:"descr",
			title:"书名",
		    width:50
		},{
			field:"price",
			title:"定价",
		    width:30
		},{
			field:"storerkey",
			title:"出版社代码",
		    width:40
		},{
			field:"publisher",
			title:"出版社",
		    width:40
		},{
			field:"qtyallocated",
			title:"已分发数量",
		    width:50
		}]]
	});
    //0 : 表示需发界面   1 ： 表示已发界面
    $("#currentType").val("0");
    $('#remove_delivery').linkbutton('disable');
    $('#delivery').linkbutton('enable');
}
/**
 * 工具栏
 */
tool = {
		delivery : function (){
			var row = $("#data").datagrid('getSelected');
			if(row== null){
				$.messager.alert("操作提示","没有选中的记录","error");
				return;
			}
			
			delivery();
		},
		remove_delivery : function(){
			var row = $("#data").datagrid('getSelected');
			if(row== null){
				$.messager.alert("操作提示","没有选中的记录","error");
				return;
			}
		    $.messager.confirm("操作提示", "您确定要取消发货吗？", function (data) {
	            if (data) {  
	            	remove_delivery();
	            }  
	            else {  
	               return; 
	            }  
	        }); 
			
		},
		yes : function (){
			var row = $("#c_subcode").datagrid('getSelected');
			if(row== null){
				$.messager.alert("操作提示","没有选中的记录","error");
				return;
			}
			$("#subcode").textbox('setValue',row.subcode);
			$("#showSubcode").window("close");
		},
		no : function (){
			$("#showSubcode").window("close");
		}
	}
/**
 * 取消批次
 * @returns
 */
function remove_delivery(){
	var rows = $("#data").datagrid('getSelections');
	var ids = [];
	for(var i=0; i<rows.length; i++){
		var row = rows[i];
		ids.push(row.id);
	}
	var formData = {
		'ids'	: ids
	};
	$.ajax({
		type:'post',
		url:'/management/jc/compute/cancel',
		data:formData,
		dataType:'json',
		success:function (data){
			if(data){
				$.messager.alert("操作提示",data.msg,"info",function(){
					$("#data").datagrid('reload');
				});
			}
		},
		error:function(){
			$.messager.alert("提示","数据错误，联系管理员","info");
		}
	});
}

/**
 * 生成批次
 * @returns
 */
function addBatchno (){
	var rows = $('#data_detail').datagrid('getSelections');
	if(!rows || rows.length == 0) {
		$.messager.alert("操作提示","没有选中记录","error");
		return;
	}
	var ids = [];
	for(var i=0; i<rows.length; i++){
		var row = rows[i];
		ids.push(row.id);
	}
	$.ajax({
		type:'post',
		url:'/management/jc/compute/addBatchno',
		data:{"ids" : ids},
		dataType:'json',
		success:function (data){
			if(data){
				$("#t_batchno").textbox('setValue',data.data);
				$.messager.alert("操作提示",data.msg,"info",function(){
					delivery();
				});
			}
		},
		error:function(){
			$.messager.alert("提示","数据错误，联系管理员","info");
		}
	});
}

/**
 *  发货明细
 * @returns
 */
function delivery(){
	var row = $("#data").datagrid('getSelected');
	if(row== null){
		$.messager.alert("操作提示","没有选中的记录","error");
		return;
	}
	var row = $('#data').datagrid('getSelected');
	$("#w_detail").window("open");
	$("#data_detail").datagrid({
		url:'/management/jc/compute/wholeShipInfo?issuenumber=' + row.issuenumber + "&subcode=" + row.subcode + "&status=1&picktype=0",
		height:'auto',	
		fitColumns: true,
		fit: true,
		striped:true,
		rownumbers:true,
		border:true,
		singleSelect:false,
		pagination:true,
        pageSize:1000,
        pageList:[10,20,50,1000],
		showFooter: true,
		toolbar:'#tb3',
		columns:[[{
			field:"id",
		    title:"编号",
		    checkbox:true,
		    width:50
		},{
			field:"issuenumber",
			title:"期号",
		    width:50
		},{
			field:"subcode",
			title:"征订代码",
		    width:60
		},{
			field:"barcode",
			title:"条码",
		    width:70
		},{
			field:"descr",
			title:"书名",
		    width:50
		},{
			field:"price",
			title:"定价",
		    width:30
		},{
			field:"bundle",
			title:"每包捆数",
		    width:30
		},{
			field:"pack",
			title:"包册数",
		    width:30
		},{
			field:"code",
			title:"分发店代码",
		    width:50
		},{
			field:"shortname",
			title:"分发店",
		    width:30
		},{
			field:"qtyallocated",
			title:"已分发数量",
			width:50
		},{
			field:"loc",
			title:"分配储位",
			width:50
		},{
			field:"containerid",
			title:"容器号",
			width:50
		},{
			field:"amt",
			title:"总码洋",
			width:50
		},{
			field:"totalCase",
			title:"总件数",
			width:30
		},{
			field:"computewho",
			title:"配发人",
			width:50
		},{
			field:"computedate",
			title:"配发时间",
			width:50
		}]],
		onSelect: function (index, row) {
			var t_caseqty = 0;
			var rows = $('#data_detail').datagrid('getSelections');
			for(var i in rows ){
				t_caseqty += parseInt(rows[i].totalCase);
			}
			$("#t_caseqty").textbox('setValue',t_caseqty);
		},
		onUnselect: function (index, row) {
			var t_caseqty = 0;
			var rows = $('#data_detail').datagrid('getSelections');
			for(var i in rows ){
				t_caseqty += parseInt(rows[i].totalCase);
			}
			$("#t_caseqty").textbox('setValue',t_caseqty);
		},
		onSelectAll: function (index, row) {
			var t_caseqty = 0;
			var rows = $('#data_detail').datagrid('getSelections');
			for(var i in rows ){
				t_caseqty += parseInt(rows[i].totalCase);
			}
			$("#t_caseqty").textbox('setValue',t_caseqty);
		},
		onUnselectAll: function (index, row) {
			var t_caseqty = 0;
			var rows = $('#data_detail').datagrid('getSelections');
			for(var i in rows ){
				t_caseqty += parseInt(rows[i].totalCase);
			}
			$("#t_caseqty").textbox('setValue',t_caseqty);
		}
	});

}

/**
 * 查询
 * @returns
 */
function go(){
	var type = $("#type").combobox("getValue");
	var issuenumber = $("#issuenumber").combobox("getValue");
	var subcode = $("#subcode").textbox('getValue');
	var barcode = $("#barcode").textbox('getValue');
	var batchno = $("#batchno").textbox('getValue');
	if("0" == type){
		var param = {
			"issuenumber" 		: issuenumber,
			"subcode" 			: subcode,
			"barcode" 			: barcode,
			"batchno"			: batchno,
			"picktype" 			: 0,
			"status"			: "1"
		};
		loadWaitShipData(20, 'POST',param);
	    $("#currentType").val("0");
	    $('#remove_delivery').linkbutton('disable');
	    $('#delivery').linkbutton('enable');
	}else {
		var param = {
			"issuenumber" 		: issuenumber,
			"subcode" 			: subcode,
			"barcode" 			: barcode,
			"batchno"			: batchno,
			"picktype" 			: 0
		};
		loadshippedData(20, 'POST',param);
	    $("#currentType").val("1");
	    $('#remove_delivery').linkbutton('enable');
	    $('#delivery').linkbutton('disable');
	}
}


/**
 * 加载已发信息
 * @returns
 */
function loadshippedData(pageSize, method, formData){

	$("#data").datagrid({
		url:'/management/jc/compute/wholeShipInfoEnd',
		method: method || 'GET',
		queryParams:formData || '',
		height:'auto',	
		fitColumns: true,
		striped:true,
		rownumbers:true,
		border:true,
		singleSelect:false,
		pagination:true,
        pageSize:pageSize || 20,
        pageList:[10,20,50],
		showFooter: true,
		toolbar:'#tb',
		columns:[[{
			field:"id",
		    title:"编号",
		    checkbox:true,
		    width:50
		},{
			field:"issuenumber",
			title:"期号",
		    width:50
		},{
			field:"subcode",
			title:"征订代码",
		    width:50
		},{
			field:"barcode",
			title:"条码",
		    width:50
		},{
			field:"descr",
			title:"书名",
		    width:50
		},{
			field:"price",
			title:"定价",
		    width:50
		},{
			field:"pack",
			title:"包册数",
		    width:30
		},{
			field:"storerkey",
			title:"出版社代码",
		    width:30
		},{
			field:"publisher",
			title:"出版社",
		    width:30
		},{
			field:"code",
			title:"分发店代码",
		    width:50
		},{
			field:"shortname",
			title:"分发店",
		    width:30
		},{
			field:"qtyallocated",
			title:"已分发数量",
		    width:50
		},{
			field:"caseqty",
			title:"整件",
		    width:30
		},{
			field:"oddpack",
			title:"零捆",
		    width:30
		},{
			field:"odd",
			title:"零册",
		    width:30
		},{
			field:"amt",
			title:"总码洋",
		    width:50
		},{
			field:"batchno",
			title:"批次号",
		    width:50
		},{
			field:"shipno",
			title:"运号",
		    width:50
		}]]
	});
    $("#currentType").val("1");
    $('#remove_delivery').linkbutton('enable');
    $('#delivery').linkbutton('disable');
}

/**
 * 根据期号选择征订代码
 * @returns
 */
function chooseSubcode(){
	var type = $("#type").combobox("getValue");
	var issuenumber = $("#issuenumber").combobox("getValue");
	$("#showSubcode").window("open");
	if("0" == type) {
		$("#c_subcode").datagrid({
			url:'/management/jc/compute/wholeShipInfoTotalTips?issuenumber=' + issuenumber,
			height:'auto',
			fitColumns: true,
			striped:true,
			rownumbers:true,
			border:true,
			singleSelect:true,
			showFooter: true,
			toolbar:'#tb2',
			columns:[[{
				field:"id",
			    title:"编号",
			    checkbox:true,
			    width:50
			},{
				field:"issuenumber",
				title:"期号",
			    width:50
			},{
				field:"subcode",
				title:"征订代码",
			    width:50
			},{
				field:"barcode",
				title:"条码",
			    width:50
			},{
				field:"descr",
				title:"书名",
			    width:50
			},{
				field:"price",
				title:"定价",
			    width:30
			},{
				field:"storerkey",
				title:"出版社代码",
			    width:40
			},{
				field:"publisher",
				title:"出版社",
			    width:40
			},{
				field:"qtyallocated",
				title:"已分发数量",
			    width:50
			}]]
		});
		$("#showSubcode").window("open");
		
	}else {
		$("#c_subcode").datagrid({
			url:'/management/jc/compute/wholeShipInfoEndTips?issuenumber=' + issuenumber,
			height:'auto',
			fitColumns: true,
			striped:true,
			rownumbers:true,
			border:true,
			singleSelect:true,
			showFooter: true,
			toolbar:'#tb2',
			columns:[[{
				field:"id",
			    title:"编号",
			    checkbox:true,
			    width:50
			},{
				field:"issuenumber",
				title:"期号",
			    width:50
			},{
				field:"subcode",
				title:"征订代码",
			    width:50
			},{
				field:"barcode",
				title:"条码",
			    width:50
			},{
				field:"descr",
				title:"书名",
			    width:50
			},{
				field:"price",
				title:"定价",
			    width:30
			},{
				field:"storerkey",
				title:"出版社代码",
			    width:50
			},{
				field:"publisher",
				title:"出版社",
			    width:50
			},{
				field:"qtyallocated",
				title:"已分发数量",
			    width:50
			}]]
		});
	}
}

/**
 * 整件清单
 */
function wholeCaseList(){
	var batchno = $("#t_batchno").textbox('getValue');
	if(batchno != ""){
		window.open('jc/print_wholeCaseListMid.action?batchno='+batchno,'_blank');
	}else{
		$.messager.alert("操作提示","请先选择批次号","error");
	}
}
/**
 * 调拨单
 */
function allocationList(){
	var batchno = $("#t_batchno").textbox('getValue');
	if(batchno != ""){
		window.open('jc/print_allocationList.action?batchno='+batchno,'_blank');
	}else{
		$.messager.alert("操作提示","请先选择批次号","error");
	}
}
/**
 * 小票
 */
function s_ticketList(){
	var batchno = $("#t_batchno").textbox('getValue');
	if(batchno != ""){
		window.open('jc/print_s_ticketList.action?batchno='+batchno,'_blank');
	}else{
		$.messager.alert("操作提示","请先选择批次号","error");
	}
}
/**
 * 尾包票签
 */
function t_ticketList(){
	var batchno = $("#t_batchno").textbox('getValue');
	if(batchno != ""){
		window.open('jc/print_t_ticketList.action?batchno='+batchno,'_blank');
	}else{
		$.messager.alert("操作提示","请先选择批次号","error");
	}
}


$(function(){
	var formData = {
		"picktype" 	: 0,
		"status"	: "1"

	};
	loadWaitShipData(20, 'POST', formData);
});