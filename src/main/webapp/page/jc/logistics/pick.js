/**
 * 加载需拣货信息
 * @returns
 */
function loadWaitPickData(pageSize, method, formData){
	$("#data").datagrid({
		url:'/management/jc/compute/pickInfoTotal',
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
		    width:50
		},{
			field:"storerkey",
			title:"供商代码",
		    width:30
		},{
			field:"publisher",
			title:"供商名称",
		    width:30
		},{
			field:"qtyallocated",
			title:"拣货数量",
		    width:50
		},{
			field:"amt",
			title:"分发码洋",
		    width:50
		}]]
	});
}
/**
 * 查看明细
 */
function detail(){
	var row = $('#data').datagrid('getSelected');
	if(row == null){
		$.messager.alert("操作提示","没有选中的记录","error");
		return;
	}
	$("#data_detail").datagrid({
		url:'/management/jc/compute/pickInfo?issuenumber=' + row.issuenumber + '&subcode=' + row.subcode + '&status=6',
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
			field:"pack",
			title:"捆扎",
		    width:30
		},{
			field:"code",
			title:"分发店代码",
		    width:50
		},{
			field:"shortname",
			title:"分发店",
		    width:50
		},{
			field:"qtyallocated",
			title:"总册数",
		    width:50
		},{
			field:"caseqty",
			title:"整件",
			width:50
		},{
			field:"oddpack",
			title:"零捆",
			width:50
		},{
			field:"odd",
			title:"零册",
			width:50
		},{
			field:"amt",
			title:"总码洋",
			width:50
		},{
			field:"loc",
			title:"储位",
			width:50
		},{
			field:"containerid",
			title:"容器号",
			width:50
		},{
			field:"batchno",
			title:"批次号",
			width:50
		},{
			field:"shipno",
			title:"运号",
			width:50
		},{
			field:"pickno",
			title:"拣货流水号",
			width:50
		},{
			field:"picktype",
			title:"拣货类型",
			width:50
		},{
			field:"status",
			title:"状态",
			width:50
		}]]
	});
	$("#w_detail").window("open");
}

/**
 * 生成手拣单
 */
function addPickno(){
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
		url:'/management/jc/compute/startPick',
		data:{"ids" : ids},
		dataType:'json',
		success:function (data){
			if(data){
				$.messager.alert("操作提示",data.msg,"info",function(){
					$('#data_detail').datagrid('reload');
				});
				$("#t_pickno").textbox('setValue',data.data);
			}
		},
		error:function(){
			$.messager.alert("提示","数据错误，联系管理员","info");
		}
	});
}

/**
 * 拣货确认
 */
function pick(){
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
		url:'/management/jc/compute/confirmPick',
		data:{"ids" : ids},
		dataType:'json',
		success:function (data){
			if(data){
				$.messager.alert("操作提示",data.msg,"info",function(){
					$('#data_detail').datagrid('reload');
				});
			}
		},
		error:function(){
			$.messager.alert("提示","数据错误，联系管理员","info");
		}
	});
}

/**
 * 拣货单
 */
function pickList(){
	var pickno = $("#t_pickno").textbox('getValue');
	if(pickno == ''){
		$.messager.alert("操作提示","请先选择拣货流水号","error");
		return;
	}
	window.open('/management/page/jc/print/pickList.jsp?pickno='+pickno,'_blank');
}


/**
 * 工具栏
 */
tool = {
		addBatchno : function (){
			var rows = $('#data').datagrid('getSelections');
			var currentType = $("#currentType").val();
			if("1" == currentType){
				$.messager.alert("操作提示","请先切换到需发界面才能生成批次","error");
				return;
			}
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
				url:'jc/wholeShip_addBatchno.action',
				data:"id=" + ids,
				dataType:'json',
				success:function (data){
					$.messager.alert("操作提示",data,"info");
					$('#data').datagrid('reload');
				},
				error:function(){
					$.messager.alert("提示","数据错误，联系管理员","info");
				}
			});
		},
		
		
		
		compute : function (){
			var rows = $('#data').datagrid('getSelections');
			var currentType = $("#currentType").val();
			if("1" == currentType){
				$.messager.alert("操作提示","请先切换到需配发计算界面才能计算","error");
				return;
			}
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
				url:'jc/compute_compute.action',
				data:"id=" + ids,
				dataType:'json',
				success:function (data){
					$.messager.alert("操作提示",data,"info");
					$('#data').datagrid('reload');
				},
				error:function(){
					$.messager.alert("提示","数据错误，联系管理员","info");
				}
			});
			
		},
		editpack : function (){
			var currentType = $("#currentType").val();
			if("1" == currentType){
				$.messager.alert("操作提示","请先切换到需配发计算界面才能修改捆扎数","error");
				return;
			}
			var rows = $('#data').datagrid('getSelections');
			if(!rows || rows.length == 0) {
				$.messager.alert("操作提示","没有选中记录","error");
				return;
			}
			if(rows.length > 1) {
				$.messager.alert("操作提示","一次只能修改一条记录","error");
				return;
			}
			$("#distributionid").val(rows[0].id);
			$("#spanissuenumber").html(rows[0].issuenumber);
			$("#spansubcode").html(rows[0].subcode);
			$("#spandescr").html(rows[0].descr);
			$("#spanpack").html(rows[0].pack);
			$("#w").window("open");
		},
		commitpack : function (){
			var subcode = $("#spansubcode").html();
			var descr = $("#spandescr").html();
			var subcode = $("#spansubcode").html();
			var issuenumber = $("#spanissuenumber").html();
			var pack = $("#newpack").textbox("getValue");
			var id = $("#distributionid").val();
			$.ajax({
				type:'post',
				url:'jc/compute_commitpack.action',
				data:'id=' + id + '&issuenumber=' + issuenumber + '&subcode=' + subcode + '&pack=' + pack,
				dataType:'json',
				success: function (data){
					$.messager.alert("操作提示",data,"info");
					$("#w").window("close");
					$('#data').datagrid('reload');
				},
				error:function(){
					$.messager.alert("提示","数据错误，联系管理员","info");
				}
			});
		},
		cancelcompute : function (){
			var currentType = $("#currentType").val();
			if("0" == currentType){
				$.messager.alert("操作提示","请先切换到已配发计算界面才能取消计算","error");
				return;
			}
			var rows = $('#data').datagrid('getSelections');
			if(!rows || rows.length == 0) {
				$.messager.alert("操作提示","没有选中记录","error");
				return;
			}
			if(rows.length > 1) {
				$.messager.alert("操作提示","一次只能取消一条记录","error");
				return;
			}
			$.ajax({
				type:'post',
				url:'jc/compute_cancelCompute.action',
				data:'id=' + rows[0].id,
				dataType:'json',
				success : function(data){
					$.messager.alert("操作提示",data,"info");
					$('#data').datagrid('reload');
				},
				error:function(){
					$.messager.alert("提示","数据错误，联系管理员","info");
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
 * 加载已拣信息
 * @returns
 */
function loadshippedData(pageSize, method, formData){

	$("#data").datagrid({
		url:'/management/jc/compute/info',
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
			field:"pickno",
			title:"拣货流水号",
		    width:50
		}]]
	});
    $("#currentType").val("1");
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
			url:'',
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
			    width:50
			},{
				field:"storerkey",
				title:"出版社代码",
			    width:30
			},{
				field:"publisher",
				title:"出版社",
			    width:30
			},{
				field:"qtyallocated",
				title:"已分发数量",
			    width:50
			}]]
		});

	}else {
		$("#c_subcode").datagrid({
			url:'',
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
			    width:50
			},{
				field:"storerkey",
				title:"出版社代码",
			    width:30
			},{
				field:"publisher",
				title:"出版社",
			    width:30
			},{
				field:"qtyallocated",
				title:"已分发数量",
			    width:50
			}]]
		});
		$("#showSubcode").window("open");
	}
}

function go (){
	var type = $("#type").combobox("getValue");
	var picktype = $("#picktype").combobox("getValue");
	var issuenumber = $("#issuenumber").combobox("getValue");
	var subcode = $("#subcode").textbox('getValue');
	var barcode = $("#barcode").textbox('getValue');
	if("0" == type ){
		var formData = {
			'picktype' 		: picktype,
			'issuenumber'	: issuenumber,
			'subcode'		: subcode,
			'barcode'		: barcode
		};
		loadWaitPickData(20, 'POST', formData);
	    $("#currentType").val("0");
	}else {
		var formData = {
			'picktype' 		: picktype,
			'issuenumber'	: issuenumber,
			'subcode'		: subcode,
			'barcode'		: barcode,
			'status'		: '7'
		};
	    $("#currentType").val("1");
	}
}
/**
 * 打包确认
 */
function comfirm(){
	
}

$(function(){
	loadWaitPickData();
});