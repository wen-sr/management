$(function(){
    getCurrentConfig();
});

function getCurrentConfig(){
    $.ajax({
        type:"POST",
        url:"/management/wcs/config/select",
        success:function (res) {
            if(res.status == "0"){
                $("#current").html("");
                if(res.data.paraValue == "Y"){
                    $("#current").html("入4#箱库");
                }else {
                    $("#current").html("差异口回收");
                }
            }
        },
        error:function(){
            $.messager.alert("提示","数据错误，联系管理员","error");
        }
    });
}

function submitConfig() {
    var value = $("#value").combobox('getValue');
    var formData = {
        key     : '3#_4#_TRANS_MODE',
        value   : value
    }
    $.ajax({
        type:"POST",
        data:formData,
        dataType:'json',
        url:"/management/wcs/config/update",
        success:function (res) {
            $.messager.alert("提示",res.msg,"info", function () {
                getCurrentConfig();
            });
        },
        error:function(){
            $.messager.alert("提示","数据错误，联系管理员","error");
        }
    });

}