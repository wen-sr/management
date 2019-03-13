$(function () {
    $("#begin").calendar({
        onChange: function (p, values, displayValues) {
            console.log(values, displayValues);
        }
    });
    $("#end").calendar({
        onChange: function (p, values, displayValues) {
            console.log(values, displayValues);
        }
    });
})

function go() {
    var begin = $("#begin").val();
    var end = $("#end").val();
    $('#list').html('');
    tools.request({
        url     : "/management/wechat/salesInfo",
        data    : {begin : begin, end : end},
        success : function (res) {
            if(res != null && res.length > 0){
                var tpl =
                    '{{#list}}' +
                    '<div class="weui-cell">' +
                    '<div class="weui-cell__bd">' +
                    '<div>{{receiptDate}},运号：{{shipno}},收货件数：{{caseQty}}</div>' +
                    '</div>' +
                    '</div>' +
                    '{{/list}}';
                var result = '<div class="list-header" style="color: #D74D49;height: 30px;line-height: 30px;padding-left: 15px;">收货明细:</div>';
                result += tools.renderHtml(tpl, {list: res["list"]});
                $('#list').append(result);
            }
        }
    })

}