$(function(){


    $("#go").click(function () {
        go();
    });
});


function go(){
    var containercode = $("#containercode").textbox('getValue');
    var sourcelayer = $("#sourcelayer").textbox('getValue');
    var formData = {
        "containercode"   : containercode,
        "sourcelayer"   : sourcelayer
    }
    if(sourcelayer == ""){
        $.messager.alert("操作提示","所在层不能为空！","error");
        return;
    }
    if(containercode == ""){
        $.messager.alert("操作提示","箱号不能为空！","error");
        return;
    }
    $.ajax({
        type:'Post',
        url:'/management/wcs/taskCar/updateStatus',
        data:formData,
        dataType:'json',
        success:function(res){
            $.messager.alert("提示",res.msg,"info");
        },
        error:function(){
            $.messager.alert("提示","数据错误，联系管理员","error");
        }
    });

}

