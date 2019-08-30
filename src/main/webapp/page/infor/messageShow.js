$(function () {
    getData();
});

function getData() {
    $("#list").html("");
    tools.request({
        url:'/management/infor/likuError',
        success:function(data, msg){
            if(data != null){
                if(data != null && data.length > 0){
                    var tpl =
                        '{{#list}}' +
                        '<div class="weui-cell">' +
                        '<div class="weui-cell__bd">' +
                        '<p>{{bankId}}号立库，{{name}}{{errorMsg}}，故障代码：{{errorCode}}</p>' +
                        '</div>' +
                        '</div>' +
                        '{{/list}}';
                    var result = '<div class="list-header" style="color: #D74D49;height: 30px;line-height: 30px;padding-left: 15px;">立库故障详情:</div>';
                    result += tools.renderHtml(tpl, {list: data});
                    $('#list').append(result);
                }
            }
        }
    });
}