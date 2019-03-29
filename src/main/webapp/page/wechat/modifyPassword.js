function go() {
    var id = $("#id").val();
    var password_old = $.trim($("#password_old").val());
    var password = $.trim($("#password").val());
    var password_2 = $.trim($("#password_2").val());
    if(password_old === ''){
        $.toast("请输入您的原密码", "forbidden");
        return;
    }
    if(password === ''){
        $.toast("请输入您的新密码", "forbidden");
        return;
    }
    if(password_2 === ''){
        $.toast("请输入您的确认密码", "forbidden");
        return;
    }
    if(password != password_2) {
        $.toast("两次输入的新密码不一致", "forbidden");
        return;
    }

    tools.request({
        url     :   '/management/wechat/common/modifyPassword',
        data    :   {
            id              : id,
            password_old    : password_old,
            password        : password,
            password_2      : password_2
        },
        success : function (data, msg) {
            $.toast(msg, "success", function() {
                window.open("customerIndex.html", "_self");
            });
        }
    })
}



$(function () {
    var id = tools.getUrlParam("id");
    $("#id").val(id);
});