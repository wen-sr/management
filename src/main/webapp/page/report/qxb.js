/**
 * 加载数据
 */
function loadData(pageSize, method, formData){
    $("#data").datagrid({
        url:'/management/report/query',
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
            field:"caseoutbatch",
            title:"批次号",
            width:50
        },{
            field:"caseoutid",
            title:"出库流水线",
            width:50
        },{
            field:"qty",
            title:"数量",
            width:50
        },{
            field:"scan_Qty",
            title:"扫描数量",
            width:50
        },{
            field:"mk1",
            title:"完成标记",
            width:50
        },{
            field:"id_Bindtime",
            title:"时间",
            width:50
        }]]
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



function myformatter(date){
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}



function loadData1(pageSize, method, formData){
    $("#data").datagrid({
        url:'/management/report/update',
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
    });
}

// function update() {
//     var caseoutid = $("#caseoutid").combobox('getValue');
//     var formData = {
//         caseoutid            : caseoutid
//     }
//     loadData1(20, 'POST', formData);
// }

function update() {
    $.messager.confirm('操作提示', '确认包件释放信息', function(r){
        if (r){
            var caseoutid = $("#caseoutid").combobox('getValue');
            var formData = {
                caseoutid            : caseoutid
            }
            loadData1(20, 'POST', formData);
            alert('释放成功: '+r);
        }
    });

}