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
            field:"newscontent",
            title:"内容",
            width:50,
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
function queryInfo() {
    var createDate = $("#createDate").datebox('getValue');
    var contNo = $("#contNo").textbox('getValue');
    var zt = $("#zt").combobox('getValue');
    if(createDate == ''){
        createDate = undefined;
    }
    if(contNo == ''){
        contNo = undefined;
    }
    var formData = {
        createDate  : createDate,
        contNo      : contNo,
        zt          : zt
    };
    loadData(1,'POST', formData);
}

$(function(){
    loadData(1, 'POST', {zt : "0"});
});