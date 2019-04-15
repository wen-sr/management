/**
 * 加载数据
 */
function loadData(pageSize, method, formData){
    $("#data").datagrid({
        url:'/management/busi/busiMessageWx/queryInfo',
        method: method || 'GET',
        queryParams:formData || '',
        height:'auto',
        fit:true,
        fitColumns: true,
        striped:true,
        rownumbers:true,
        border:true,
        singleSelect:true,
        pagination:true,
        pageSize: pageSize || 20,
        pageList:[10,20,50,pageSize || 0],
        showFooter: true,
        toolbar:'#tb',
        columns:[[{
            field:"id",
            title:"编号",
            width:50
        },{
            field:"qtyReceiptDay",
            title:"今日收货",
            width:50
        },{
            field:"qtyReceiptMouth",
            title:"累计收货",
            width:50
        },{
            field:"qtyDeliveryDay",
            title:"今日发货",
            width:50
        },{
            field:"qtyDeliveryMouth",
            title:"累计发货",
            width:50
        },{
            field:"qtyStock",
            title:"库存",
            width:50
        },{
            field:"dd",
            title:"日期",
            width:50
        },{
            field:"remark",
            title:"备注",
            width:50
        },{
            field:"addwho",
            title:"添加人",
            width:50
        }]]

    });
}
function add() {
    $("#w-addInfo").window("open");
}
function addInfo() {
    var dd = $("#add_dd").datebox('getValue');
    var qtyReceiptDay = $("#add_qtyReceiptDay").textbox('getValue');
    var qtyReceiptMouth = $("#add_qtyReceiptMouth").textbox('getValue');
    var qtyDeliveryMouth = $("#add_qtyDeliveryMouth").textbox('getValue');
    var qtyDeliveryDay = $("#add_qtyDeliveryDay").textbox('getValue');
    var qtyStock = $("#add_qtyStock").textbox('getValue');
    var remark = $("#add_remark").textbox('getValue');
    if(dd === ""){
        $.messager.alert("操作提示", "日期不能为空","info");
        return;
    }
    if(qtyReceiptDay === ""){
        $.messager.alert("操作提示", "今日收货不能为空","info");
        return;
    }
    if(qtyReceiptMouth === ""){
        $.messager.alert("操作提示", "累计收货总数不能为空","info");
        return;
    }
    if(qtyDeliveryMouth === ""){
        $.messager.alert("操作提示", "累计发货总数不能为空","info");
        return;
    }
    if(qtyDeliveryDay === ""){
        $.messager.alert("操作提示", "今日发货数不能为空","info");
        return;
    }
    if(qtyStock === ""){
        $.messager.alert("操作提示", "库存不能为空","info");
        return;
    }
    var formData = {
        dd                  : dd,
        qtyReceiptDay       : qtyReceiptDay,
        qtyReceiptMouth     : qtyReceiptMouth,
        qtyDeliveryMouth    : qtyDeliveryMouth,
        qtyDeliveryDay      : qtyDeliveryDay,
        qtyStock            : qtyStock,
        remark              : remark
    }
    _util.request({
        url     : "/management/busi/busiMessageWx/addInfo",
        data    : formData,
        success : function (data, msg) {
            $.messager.alert("操作提示",msg,"info", function () {
                $("#w-addInfo").window("close");
                $("#data").datagrid('reload');
            });
        },
        error   : function (msg) {
            $.messager.alert("操作提示",msg,"error");
        }
    });
}
function query() {
    var dd = $("#dd").textbox('getValue');
    loadData(20, 'POST', {dd : dd});
}

$(function(){
    loadData(20, 'POST', '');
});