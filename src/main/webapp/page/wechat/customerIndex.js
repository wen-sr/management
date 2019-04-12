function checkLogin() {
    tools.request({
        url     :   "/management/wechat/common/checkLogin",
        success :   function (data) {
            $("#id").val(data.id);
            $("#name").html(data.id + "&nbsp;--&nbsp;"+ data.name);
        }
    })
}

$(function () {
    checkLogin();
})

function logout(){
    tools.request({
        url     :   "/management/wechat/common/logout",
        success :   function (data) {
            $("#name").html("未登录");
        }
    })
}

function modifyPwd() {
    var id = $("#id").val();
    if(id === ""){
        $.toast("未登录", "forbidden");
        return;
    }
    window.open("modifyPassword.html?id=" + id, "_self");
}