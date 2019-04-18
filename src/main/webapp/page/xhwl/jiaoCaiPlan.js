/**
 * 加载数据
 */
function loadData(pageSize, method, formData){
    $("#data").datagrid({
        url:'/management/jiaoCaiPlan/findAll',
        height:'auto',
        method: method || 'GET',
        queryParams:formData || '',
        fitColumns: true,
        fit:true,
        striped:true,
        rownumbers:true,
        border:true,
        singleSelect:true,
        pagination:false,
        pageSize: pageSize || 20,
        pageList:[10,20,50,pageSize || 0],
        showFooter: true,
        // loadMsg:"请稍等。。。",
        toolbar:'#tb',
        columns:[[{
            field:"id",
            title:"编号",
            checkbox:true,
            width:30
        },{
            field:"issuenumber",
            title:"期号",
            width:30
        },{
            field:"plantingname",
            title:"印刷厂",
            width:70
        },{
            field:"subcode",
            title:"征订代码",
            width:70
        },{
            field:"price",
            title:"定价",
            width:30
        },{
            field:"descr",
            title:"书名",
            width:80
        },{
            field:"publisher",
            title:"出版社",
            width:50
        },{
            field:"qtyperitem",
            title:"每条册数",
            width:30
        },{
            field:"qtydeliver",
            title:"发货数量",
            width:50
        },{
            field:"qtycase",
            title:"件数",
            width:50
        },{
            field:"batchno",
            title:"发货批次号",
            width:70
        },{
            field:"deliverdate",
            title:"发货日期",
            width:50
        },{
            field:"handbagdate",
            title:"交包日期",
            width:50
        },{
            field:"type",
            title:"类型",
            width:50
        },{
            field:"remark",
            title:"备注",
            width:50
        }]]
    });

    var p = $('#data').datagrid('getPager');
    $(p).pagination({
        beforePageText: '第',
        afterPageText: '页    共 {pages} 页',
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
        onBeforeRefresh:function(){
            $(this).pagination('loading');
            $(this).pagination('loaded');
        },
        buttons: [{
            iconCls:'icon-sum',
            handler:function(){
                var d = $("#data").datagrid('getData');
                loadData(d.total);
            }
        }]
    });
}

/**
 * 排序
 * @param a
 * @param b
 * @returns {number}
 */
function sorterNum(a,b){
   return a>b?a:b;
}

/**
 * 查询
 */
function queryInfo(){
    var issuenumber = $.trim($("#issuenumber").combobox('getValue'));
    var plantingname = $.trim($("#plantingname").combobox('getValue'));
    var subcode = $.trim($("#subcode").combobox('getValue'));
    var handbagdate = $.trim($("#handBagDate").datebox('getValue'));
    var handbagdateEnd = $.trim($("#handBagDateEnd").combobox('getValue'));
    var type = $.trim($("#type").combobox('getValue'));
    var flag = $("#flag").checkbox('options').checked;
    var formData = {
        issuenumber         : issuenumber,
        plantingname        : plantingname,
        subcode             : subcode,
        handbagdate         : handbagdate,
        handbagdateEnd      : handbagdateEnd,
        type                : type,
        flag                : flag

    };
    loadData(20,'POST',formData);
}


function editInfo(){
    var issuenumber = $("#edit_issueNumber").textbox('getValue');
    var batchno = $("#edit_batchno").textbox('getValue');
    var handbagdate = $("#edit_handbagdate").datebox('getValue');
    var type = $("#edit_type").textbox('getValue');
    var remark = $("#edit_remark").textbox('getValue');
    var formData = {
        issuenumber         : issuenumber,
        batchno             : batchno,
        handbagdate         : handbagdate,
        type                : type,
        remark              : remark
    }
    _util.request({
        url         : '/management/jiaoCaiPlan/editInfo',
        data        : formData,
        success     : function (data, msg) {
            $.messager.alert("操作提示",msg,"info", function () {
                $("#data").datagrid('reload');
                $("#w-editInfo").window("close");
            });
        }
    })

}

function removeInfo(){
    var row = $('#data').datagrid('getSelected');
    _util.request({
        url         : '/management/jiaoCaiPlan/remove',
        data        : {id   : row.id},
        success     : function (data, msg) {
            $("#data").datagrid('reload');
            $.messager.alert("操作提示",msg,"info");
        }
    })
}

/**
 * 操作工具
 */
tool = {
    query : function (){
        $("#w-queryInfo").window("open");
    },
    add : function (){
        $("#w-addInfo").window("open");
    },
    edit : function (){
        var row = $('#data').datagrid('getSelected');
        if(!row || row.length == 0) {
            $.messager.alert("操作提示","没有选中记录","error");
            return;
        }

        $("#edit_issueNumber").textbox('setValue', row.issuenumber);
        $("#edit_batchno").textbox('setValue', row.batchno);
        $("#edit_handbagdate").datebox('setValue', row.handbagdate);
        $("#edit_type").combobox('setValue', row.type);
        $("#edit_remark").textbox('setValue', row.remark);
        $("#w-editInfo").window("open");
    },
    remove : function(){
        $.messager.confirm("操作提示", "您确定要删除这条记录吗？", function (data) {
            if (data) {
                removeInfo();
            }else {
                return;
            }
        });
    }
}

function uploadFile(){
    if(checkData()){
        $("#tips").window("open");
        $('#form1').ajaxSubmit({
            url:'/management/jiaoCaiPlan/uploadDataExcel',
            dataType: 'json',
        success: function(res){
            $("#tips").window("close");
            if(res){
                    $.messager.alert("操作提示",res.msg,"info");
                    $("#upfile").filebox('clear');
                }else{
                    errorMsg();
                }
            },
            error: errorMsg
        });
        function errorMsg(){
            alert("导入excel出错！");
        }
    }
}
function checkData(){
    var fileDir = $("#upfile").filebox('getValue');
    var suffix = fileDir.substr(fileDir.lastIndexOf("."));
    if("" == fileDir){
        alert("选择需要导入的Excel文件！");
        return false;
    }
    if(".xls" != suffix && ".xlsx" != suffix ){
        alert("选择Excel格式的文件导入！");
        return false;
    }
    return true;
}



$(function(){
    loadData(20,'POST',{flag    : true});
});