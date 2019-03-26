function checkLogin() {
    tools.request({
        url     :   "/management/wechat/common/checkLogin",
        success :   function (data) {
            $("#name").html(data.name);
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