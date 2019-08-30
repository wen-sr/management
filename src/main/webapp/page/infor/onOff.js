$(function () {
    getData();
});

function getData() {
    $("#list").html("");
    tools.request({
        url: '/management/infor/getOnOff',
        success: function (data, msg) {
            if (data != null) {
                if (data != null && data.length > 0) {
                    var tpl =
                        '{{#list}}' +
                        '<div class="weui-cell weui-cell_switch">' +
                        '<div class="weui-cell__bd">{{name}}</div>' +
                        '<div class="weui-cell__ft">' +
                        '<input class="weui-switch" type="checkbox" name="cb" onclick="change({{id}},{{flag}})" id="{{name}}" {{flag}}>' +
                        '</div>' +
                        '</div>' +
                        '{{/list}}';
                    var result = '<div class="list-header" style="color: #D74D49;height: 30px;line-height: 30px;padding-left: 15px;">故障推送开关:</div>';
                    result += tools.renderHtml(tpl, {list: data});
                    $('#list').append(result);
                }
            }
        }
    });
}

function change(id, flag) {
    var formData = {
        id      : id
    }

    tools.request({
        url:'/management/infor/updateOnOff',
        data: formData,
        success:function(data, msg){
            getData();
            $.toast(msg, 1000);
        }
    });

}