/**
 * 加载数据
 */
function loadData(pageSize, method, formData){
    $("#data").datagrid({
        url:'/management/getGouBao',
        method: method || 'GET',
        queryParams:formData || '',
        height:'auto',
        fit:true,
        fitColumns: true,
        striped:true,
        rownumbers:true,
        border:true,
        singleSelect:true,
        // pagination:true,
        // pageSize: pageSize || 15,
        // pageList:[10,15,20,50,pageSize || 0],
        showFooter: true,
        toolbar:'#tb',
        columns:[[{
            field:"dd",
            title:"日期",
            width:50
        },{
            field:"id",
            title:"单号",
            width:50
        },{
            field:"caseQty",
            title:"件数",
            width:50
        },{
            field:"qty",
            title:"册数",
            width:50
        }]],
        onLoadSuccess:function () {
            var rows = $('#data').datagrid("getRows");
            var sumCaseQty = 0;
            var sumQty = 0;
            var count = rows.length;
            for(var i = 0; i < count ; i++){
                sumCaseQty += rows[i]["caseQty"];
                sumQty += rows[i]["qty"];
            }
            $('#data').datagrid('appendRow', {"dd": "合计", "id": count, "caseQty": sumCaseQty, "qty" : sumQty });
        }
    });
}

function confirm() {
    var dd = $("#dd").datebox('getValue');
    var id = $("#id").textbox('getValue');
    if(dd == ''){
        $.messager.alert("提示","日期不能为空","error");
        return;
    }
    if(id == ''){
        id = undefined;
    }
    var formData = {
        dd : dd,
        id : id
    }
    $.ajax({
        type:'Post',
        url:'/management/gouBaoConfirm',
        data:formData,
        dataType:'json',
        success:function(res){
            $.messager.alert("提示",res.msg,"info",function(){
                $("#data").datagrid('reload');
            });
        },
        error:function(){
            $.messager.alert("提示","数据错误，联系管理员","error");
        }
    });
}


function queryInfo() {
    var dd = $("#dd").datebox('getValue');
    var id = $("#id").textbox('getValue');
    if(dd == ''){
        dd = undefined;
    }
    if(id == ''){
        id = undefined;
    }
    var formData = {
        dd : dd,
        id : id
    };
    loadData(1,'POST', formData)
}

$(function(){
    loadData();
});