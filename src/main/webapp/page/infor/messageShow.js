$(function () {
    getData();
});

function getData() {
    $("#list").html("");
    tools.request({
        url:'/management/info/likuError',
        data:{id : id},
        success:function(data, msg){
            if(data != null){
                if(data != null && data.length > 0){
                    var tpl =
                        '{{#list}}' +
                        '<div class="weui-cell">' +
                        '<div class="weui-cell__bd">' +
                        '<p>e.getBankId() + "号立库，" + e.getName() + e.getErrorMsg()</p>' +
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