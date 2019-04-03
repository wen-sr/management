$(function(){
    $("#businessType").select({
        title: "选择业务类型",
        items: [{
            title: "一般图书",
            value: 1
        },{
            title: "农家书屋",
            value: 1
        },{
            title: "大中专",
            value: 1
        },{
            title: "教材",
            value: 2
        }]
    });
    $("#customerType").select({
        title: "选择客户类型",
        items: [{
            title: "门市店",
            value: 66
        },{
            title: "出版社",
            value: 65
        }]
    });

});

function register() {
    var id = $.trim($("#id").val());
    var pwd = $.trim($("#password").val());
    var pwd_2 = $.trim($("#password_confirm").val());
    var organization_id = $('#organization_id').data("values");
    var businessType = $('#businessType').data("values");
    if(id == ''){
        $.toast("请先输入客户代码", "forbidden");
        return;
    }
    if(organization_id == ''){
        $.toast("请选择客户类型", "forbidden");
        return;
    }
    if(businessType == ''){
        $.toast("请选择业务类型", "forbidden");
        return;
    }
    if(pwd == ''){
        $.toast("密码不能为空", "forbidden");
        return;
    }
    if(pwd_2 == ''){
        $.toast("确认密码不能为空", "forbidden");
        return;
    }
    if(pwd != pwd_2){
        $.toast("两次次输入的密码不相同", "forbidden");
        return;
    }
    var formData = {
        id                  : id,
        pwd                 : pwd,
        organizationId      : organization_id,
        bk5                 : businessType
    }

    tools.request({
        url     :   '/management/wechat/common/register',
        data    :   formData,
        success:function(data, msg){
            $.alert({
                title: '提示',
                text: msg,
                onOK: function () {
                    window.open("customerIndex.html", "_self");
                }
            });
        }
    });
}

