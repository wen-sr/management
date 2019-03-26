$(function(){
    $("#type").select({
        title: "选择业务类型",
        items: [{
            title: "一般图书",
            value: 1
        },{
            title: "教材",
            value: 2
        }]
    });
});

function go() {
    var storerkey = $.trim($("#storerkey").val());
    var password = $.trim($("#password").val());
    var type = $('#type').data("values");
    if(storerkey == ''){
        $.toast("请先输入客户代码", "forbidden");
        return;
    }
    if(type == ''){
        $.toast("请选择业务类型", "forbidden");
        return;
    }
    if(password == ''){
        $.toast("密码不能为空", "forbidden");
        return;
    }
    var formData = {
        id                  : storerkey,
        pwd                 : password,
        bk5                 : type
    }

    tools.request({
        url     :   '/management/wechat/common/login',
        data    :   formData,
        success:function(data, msg){
             window.open("customerIndex.html", "_self");
        }
    });
}