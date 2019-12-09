/**
 * 加载数据
 */
function loadData(pageSize, method, formData){
    $("#data").datagrid({
        url:'/management/wes/bx',
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
            field:"sts",
            title:"状态",
            width:70
        },{
            field:"caslbl",
            title:"箱号",
            width:50
        },{
            field:"docid",
            title:"批次号",
            width:30
        },{
            field:"skubar",
            title:"条形码",
            width:30
        }, {
            field:"skufnm",
            title:"书名",
            width:30
        },{
            field:"docidsrc",
            title:"单号",
            width:30
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
function queryInfo() {
    var docid = $("#docid").val();
    var formData = {
        docid      : docid,
    }
    loadData(20, 'POST', formData);
}

$(function(){
    loadData('', 'POST', '');
});