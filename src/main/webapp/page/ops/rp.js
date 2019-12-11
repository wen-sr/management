/**
 * 加载数据
 */
function loadData(pageSize, method, formData){
    $("#data").datagrid({
        url:'/management/ops/queryInfo',
        method: method || 'GET',
        queryParams:formData || '',
        height:'auto',
        fit:true,
        fitColumns:true,
        striped:true,
        rownumbers:true,
        border:true,
        singleSelect:true,
        pagination:false,
        pageSize: pageSize || 20,
        pageList:[10,20,50,pageSize || 0],
        showFooter: true,
        toolbar:'#tb',
        columns:[[{
            field:"ty",
            title:"类型",
            width:50
        },{
            field:"employeeName",
            title:"作业人员",
            width:50
        },{
            field:"operator",
            title:"工号",
            width:50
        },{
            field:"count",
            title:"拣选册数",
            width:50
        },{
            field:"task",
            title:"拣选订单行",
            width:50
        },{
            field:"operationTime",
            title:"时间",
            width:50
        }]],
        //合计显示
        onLoadSuccess:function () {
            var rows = $('#data').datagrid("getRows");
            var sumQtyUp = 0;
            var sumQtyUp1 = 0;
            var sumQtyDn=0;
            var sumQtyDn1=0;
            for(var i = 0; i < rows.length ; i++){
                if(rows[i]["ty"] === "货阁上架"){
                    sumQtyUp += rows[i]["count"];
                    sumQtyUp1 += rows[i]["task"];
                }
                else {
                    sumQtyDn += rows[i]["count"];
                    sumQtyDn1 += rows[i]["task"];
                }
        }
        $('#data').datagrid('appendRow', {"ty": "货阁上架合计", "employeeName": null,"operator": null, "count": sumQtyUp, "task": sumQtyUp1 });
        $('#data').datagrid('appendRow', {"ty": "货阁下架合计", "employeeName": null,"operator": null, "count": sumQtyDn, "task": sumQtyDn1 });
    }

    });
}
function formatZt(val,row,index){
    if (val == "1"){
        return '<span style="color:green;">已回告</span>';
    } else if(val == "0"){
        return '<span style="color:red;">未回告</span>';
    }else {
        return val;
    }
}
function formatSendcode(val,row,index){
    if (val == "1"){
        return '<span style="color:green;">发送成功</span>';
    } else if(val == "2"){
        return '<span style="color:red;">发送失败</span>';
    } else if(val == "0"){
        return '<span style="color:blue;">未发送</span>';
    }else {
        return val;
    }
}
function query() {
    var date_begin = $("#date_begin").datebox('getValue');
    var date_end = $("#date_end").datebox('getValue');
    // var ty = $("#ty").combobox('getValue');
    var formData = {
        date_begin      : date_begin,
        date_end        : date_end
    }
    loadData(20, 'POST', formData);
}
//每个应用easyui表格都要这个加载
$(function(){
    loadData(20, 'POST', {
        date_begin      : '2019-05-23',
        date_end        : '2019-05-24'
    });
});



// function myformatter(date){
//     var y = date.getFullYear();
//     var m = date.getMonth()+1;
//     var d = date.getDate();
//     return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
// }

