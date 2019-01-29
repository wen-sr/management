/**
 * 加载库存信息
 * @returns
 */
function loadInventoryData(pageSize, method, formData){

    $("#data").datagrid({
        url:'/management/jc/inventory/info',
        method: method || 'GET',
        queryParams:formData || '',
        height:'auto',
        fitColumns: true,
        striped:true,
        rownumbers:true,
        border:true,
        singleSelect:true,
        pagination:true,
        pageSize:20,
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
            field:"qtyreceipt",
            title:"总收货数",
            width:50
        },{
            field:"qtyallocated",
            title:"分发数量",
            width:50
        },{
            field:"qtyshipped",
            title:"总发货数",
            width:50
        },{
            field:"qtyfree",
            title:"可用库存",
            width:50
        }]]
    });
    //0 : 表示需配发界面   1 ： 表示已配发界面
    $("#currentType").val("0");
    $('#cancelcompute').linkbutton('disable');
    $('#abcd').linkbutton('enable');
}
/**
 * 工具栏
 */
tool = {
    yes : function (){
        var row = $("#c_subcode").datagrid('getSelected');
        if(row == null){
            $.messager.alert("操作提示","没有选中的记录","error");
            return;
        }
        $("#subcode").textbox('setValue',row.subcode);
        $("#showSubcode").window("close");
    },
    no : function (){
        $("#showSubcode").window("close");
    },
    yes2 : function (){
        var row = $("#t_choosepack").datagrid('getSelected');
        if(row == null){
            $.messager.alert("操作提示","没有选中的记录","error");
            return;
        }
        $("#t_qtyfree").textbox('setValue',row.qtyfree);
        $("#t_qty").textbox('setValue',row.qtyfree);
        $("#t_pack").combobox('setValue',row.pack);
        $("#w_choosePack").window("close");
        $('#data-detail').datagrid('reload');
    },
    no2 : function (){
        $("#showSubcode").window("close");
    },
    detail : function (){
        var row = $('#data').datagrid('getSelected');
        if(row== null) {
            $.messager.alert("操作提示","没有选中记录","error");
            return;
        }
        $("#w-detail").window("open");
        dataDetail();
    },
    split : function(){
        var currentType = $("#currentType").val();
        if(currentType != "0"){
            $.messager.alert("操作提示","请先切换到需配发界面才能进行分书未发","error");
            return;
        }
        var row = $('#data-detail').datagrid('getSelected');
        if(row== null) {
            $.messager.alert("操作提示","没有选中记录","error");
            return;
        }
        $("#w-detail-split").window("open");
        $("#split_id").val(row.id);
        $("#split_issuenumber").textbox('setValue',row.issuenumber);
        $("#split_subcode").textbox('setValue',row.subcode);
        $("#split_qtyfree").textbox('setValue',row.qtyfree);
        $("#split_pack").textbox('setValue',row.pack);
        $("#split_qtysplit").textbox('setValue',"");
        $("#split_toLoc").textbox('setValue',"");
        $("#split_toContainerId").textbox('setValue',"");
        $("#split_loc").textbox('setValue',row.loc);
        $("#split_containerId").textbox('setValue', row.containerId);

    }
}

/**
 * 库存明细
 */
function dataDetail(){
    var row = $('#data').datagrid('getSelected');
    $("#span_issuenumber").val(row.issuenumber);
    $("#span_subcode").val(row.subcode);

    $("#data-detail").datagrid({
        url:'/management/jc/inventory/infoDetail?issuenumber=' + row.issuenumber + "&subcode=" + row.subcode,
        height:'auto',
        fitColumns: true,
        fit: true,
        striped:true,
        rownumbers:true,
        border:true,
        singleSelect:true,
        pagination:true,
        pageSize:20,
        pageList:[10,20,50],
        showFooter: true,
        toolbar:'#tb3',
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
            width:80
        },{
            field:"price",
            title:"定价",
            width:30
        },{
            field:"pack",
            title:"捆扎",
            width:30
        },{
            field:"loc",
            title:"储位",
            width:40
        },{
            field:"containerId",
            title:"容器号",
            width:40
        },{
            field:"qtyreceipt",
            title:"总收货数",
            width:40
        },{
            field:"qtyallocated",
            title:"分发数量",
            width:40
        },{
            field:"qtyshipped",
            title:"总发货数",
            width:40
        },{
            field:"qtyfree",
            title:"可用库存",
            width:40
        }]],
        // onSelect : function (index, row) {
        //     var t_qtyoccupied = 0;
        //     var t_qtyfree = $("#t_qtyfree").textbox('getValue');
        //     var t_qty = $("#t_qty").textbox('getValue');
        //     if(t_qtyfree == ""){
        //         return;
        //     }
        //     var rows = $('#data-detail').datagrid('getSelections');
        //     for(var i in rows ){
        //         t_qtyoccupied += parseInt(rows[i].qtyallocated);
        //     }
        //     $("#t_qtyoccupied").textbox('setValue',t_qtyoccupied);
        //     $("#t_qty").textbox('setValue',parseInt(t_qtyfree) - t_qtyoccupied);
        //     $("#t_qtyoccupied").css('color','red')
        // },
        // onUnselect : function (index, row) {
        //     var t_qtyoccupied = 0;
        //     var t_qtyfree = $("#t_qtyfree").textbox('getValue');
        //     var t_qty = $("#t_qty").textbox('getValue');
        //     if(t_qtyfree == ""){
        //         return;
        //     }
        //     var rows = $('#data-detail').datagrid('getSelections');
        //     for(var i in rows ){
        //         t_qtyoccupied += parseInt(rows[i].qtyallocated);
        //     }
        //     $("#t_qtyoccupied").textbox('setValue',t_qtyoccupied);
        //     $("#t_qty").textbox('setValue',parseInt(t_qtyfree) - t_qtyoccupied);
        //     $("#t_qtyoccupied").css('color','red')
        // },
        // onSelectAll : function (rows){
        //     var t_qtyoccupied = 0;
        //     var t_qtyfree = $("#t_qtyfree").textbox('getValue');
        //     var t_qty = $("#t_qty").textbox('getValue');
        //     if(t_qtyfree == ""){
        //         return;
        //     }
        //     var rows = $('#data-detail').datagrid('getSelections');
        //     for(var i in rows ){
        //         t_qtyoccupied += parseInt(rows[i].qtyallocated);
        //     }
        //     $("#t_qtyoccupied").textbox('setValue',t_qtyoccupied);
        //     $("#t_qty").textbox('setValue',parseInt(t_qtyfree) - t_qtyoccupied);
        // },
        // onUnselectAll : function (rows){
        //     var t_qtyoccupied = 0;
        //     var t_qtyfree = $("#t_qtyfree").textbox('getValue');
        //     var t_qty = $("#t_qty").textbox('getValue');
        //     if(t_qtyfree == ""){
        //         return;
        //     }
        //     var rows = $('#data-detail').datagrid('getSelections');
        //     for(var i in rows ){
        //         t_qtyoccupied += parseInt(rows[i].qtyallocated);
        //     }
        //     $("#t_qtyoccupied").textbox('setValue',t_qtyoccupied);
        //     $("#t_qty").textbox('setValue',parseInt(t_qtyfree) - t_qtyoccupied);
        // }
    });
    // $.ajax({
    //     type:"post",
    //     url:"jc/inventory_queryInventoryAndBundle.action",
    //     data:"issuenumber=" + row.issuenumber + "&subcode=" + row.subcode,
    //     dataType:"json",
    //     success:function(data){
    //         if(data){
    //             $("#t_qtyfree").textbox('setValue',data.qtyfree);
    //             $("#t_qty").textbox('setValue',data.qtyfree);
    //             $("#t_bundle").textbox('setValue',data.bundle);
    //         }
    //     },
    //     error:function(){
    //         $.messager.alert("操作提示","数据错误，联系管理员！","error");
    //         return;
    //     }
    // });

    // $("#t_pack").combobox({
    //     url:'jc/pack_query.action?issuenumber=' + row.issuenumber + "&subcode=" + row.subcode,
    //     valueField:'pack',
    //     textField:'pack',
    //     panelHeight:'auto',
    //     editable:false,
    //     readonly:true,
    //     onLoadSuccess: function () { //加载完成后,设置选中第一项
    //         var val = $(this).combobox("getData");
    //         if(val.length == 1){
    //             $("#t_pack").combobox('setValue',val[0]['pack']);
    //         }else{
    //             $('#editpack').linkbutton('enable');
    //             $("#t_qtyfree").textbox('setValue','');
    //             $("#t_qty").textbox('setValue','');
    //             $("#t_qtyoccupied").textbox('setValue','');
    //         }
    //     }
    // });
    //
    // $("#span_pack").combobox({
    //     url:'jc/pack_query.action?issuenumber=' + row.issuenumber + "&subcode=" + row.subcode,
    //     valueField:'pack',
    //     textField:'pack',
    //     panelHeight:'auto',
    //     editable:false
    // });

}

/**
 * 上架移库
 */
function move(){
    var id = $("#split_id").val();
    var issuenumber = $("#split_issuenumber").textbox('getValue');
    var subcode = $("#split_subcode").textbox('getValue');
    var qtyfree = $("#split_qtysplit").textbox('getValue');
    var loc = $("#split_loc").textbox('getValue');
    var toLoc = $("#split_toLoc").textbox('getValue');
    var containerId = $("#split_containerId").textbox('getValue');
    var toContainerId = $("#split_toContainerId").textbox('getValue');
    var pack = $("#split_pack").textbox('getValue');
    if(qtyfree == ""){
        $.messager.alert("操作提示","移动数量不能为空","error");
        return;
    }
    if(toLoc == ""){
        $.messager.alert("操作提示","目的储位不能为空","error");
        return;
    }
    if(toLoc == loc){
        $.messager.alert("操作提示","目的储位不能和原储位一样","error");
        return;
    }
    var formData = {
        'id'            : id,
        'issuenumber'   : issuenumber,
        'subcode'       : subcode,
        'qtyfree'       : qtyfree,
        'loc'           : loc,
        'toLoc'         : toLoc,
        'pack'          : pack,
        'containerId'   : containerId,
        'toContainerId' : toContainerId
    };
    $.ajax({
        type:'post',
        url:'/management/jc/inventory/move',
        data:formData,
        dataType:'json',
        success : function(data){
            $.messager.alert("操作提示",data.msg,"info", function () {
                $("#w-detail-split").window("close");
                $('#data-detail').datagrid('reload');
            });
        },
        error:function(){
            $.messager.alert("提示","数据错误，联系管理员","info");
        }
    });
}

function go(){
    var issuenumber = $("#issuenumber").combobox("getValue");
    var subcode = $("#subcode").textbox('getValue');
    var barcode = $("#barcode").textbox('getValue');
    var formData = {
        'issuenumber'   : issuenumber,
        'subcode'       : subcode
    };
    loadInventoryData(20,'POST',formData);

}

/**
 * 根据期号选择征订代码
 * @returns
 */
function chooseSubcode(){
    var issuenumber = $("#issuenumber").combobox("getValue");
    $("#showSubcode").window("open");
    $("#c_subcode").datagrid({
        url:'/management/jc/inventory/info?issuenumber=' + issuenumber,
        height:'auto',
        fitColumns: true,
        striped:true,
        rownumbers:true,
        border:true,
        pagination:true,
        pageSize:20,
        pageList:[10,20,50],
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
        }]]
    });
}

$(function(){
    loadInventoryData(20, 'POST', '');
});


