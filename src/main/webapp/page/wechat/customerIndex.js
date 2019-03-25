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