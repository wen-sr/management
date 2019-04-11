/**
 * 加载数据
 */
function loadData(pageSize, method, formData){
    $("#data").datagrid({
        url:'/management/jxlh56/news/queryInfo',
        method: method || 'GET',
        queryParams:formData || '',
        height:'auto',
        fit:true,
        fitColumns: true,
        striped:true,
        rownumbers:true,
        border:true,
        singleSelect:false,
        // pagination:true,
        // pageSize: pageSize || 15,
        // pageList:[10,15,20,50,pageSize || 0],
        showFooter: true,
        toolbar:'#tb',
        columns:[[{
            field:"id",
            title:"任务编号",
            width:50,
            checkbox:true
        },{
            field:"title",
            title:"标题",
            width:50
        },{
            field:"author",
            title:"作者",
            width:50
        },{
            field:"sysdate",
            title:"发布时间",
            width:50
        },{
            field:"releaseuserid",
            title:"发布人",
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
function go() {
    var rows = $("#data").datagrid('getSelections');
    if(rows == null || rows.length === 0 ){
        return;
    }
    var ids = [];
    for(var i=0; i<rows.length; i++){
        var row = rows[i];
        ids.push(row.id);
    }
    var formData = {
        'ids' : ids
    }
    tools.request({
        url         : '/management/jxlh56/news/sendToWechat',
        data        : formData,
        success     : function (data, msg) {

        }
    });


}

$(function(){
    loadData(1, 'POST', '');
});