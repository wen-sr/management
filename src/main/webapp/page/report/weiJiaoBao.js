/**
 * 加载数据
 */
function loadData(pageSize, method, formData){
    $("#data").datagrid({
        url:'/management/report/queryInfo',
        method: method || 'GET',
        queryParams:formData || '',
        height:'auto',
        fit:true,
            fitColumns: true,
        striped:true,
        rownumbers:true,
        scrollbarsize:true,
        border:true,
        singleSelect:true,
        pagination:false,
        pageSize: pageSize || 20,
        pageList:[10,20,50,pageSize || 0],
        showFooter: true,
        toolbar:'#tb',
        columns:[[{
            field:"type",
            title:"类型",
            width:30
        },{
            field:"description",
            title:"货主",
            width:50
        },{
            field:"caseid",
            title:"包件号",
            width:50
        },{
            field:"batchno",
            title:"批次号",
            width:70
        },{
            field:"consk",
            title:"客户代码",
            width:40
        },{
            field:"shortname",
            title:"客户名称",
            width:50
        },{
            field:"boxnoBind",
            title:"绑定箱号",
            width:30
        },{
            field:"boxnoBindWho",
            title:"绑箱人",
            width:30
        },{
            field:"caseqty",
            title:"件数",
            width:40
        },{
            field:"qty",
            title:"册数",
            width:40
        },{
            field:"adddate",
            title:"日期",
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
    var type = $("#type").combobox('getValue');
    var formData = {
        date_begin      : date_begin,
        date_end        : date_end,
        type            : type
    }
    loadData(20, 'POST', formData);
}

// $(function(){
//     loadData(20, 'POST', {
//         date_begin      : '2019-06-10',
//         date_end        : '2019-06-11',
//         type            : null
//     });
// });



function myformatter(date){
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}