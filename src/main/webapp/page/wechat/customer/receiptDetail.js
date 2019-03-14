$(function () {
    var begin = tools.getUrlParam("begin");
    var end = tools.getUrlParam("end");
    var shipno = tools.getUrlParam("shipno");
    $('#list').html('');
    tools.request({
        url     : "/management/logisticsQuery/receiptQuery",
        data    : {begin : begin, end : end, shipno : shipno},
        success : function (res) {
            if(res != null && res.length > 0){
                var tpl =
                    '{{#list}}' +
                    '<a class="weui-cell weui-cell_access" href="registerDetail.html?register={{register}}" >' +
                    '<div class="weui-cell__bd">' +
                    '<p>{{receiveDate}},运号：{{shipno}},件数：{{caseQty}}</p>' +
                    '</div>' +
                    '<div class="weui-cell__ft" style="margin-right: 10px;">'+
                    '</div>'+
                    '</a>' +
                    '{{/list}}';
                var result = '<div class="list-header" style="color: #D74D49;height: 30px;line-height: 30px;padding-left: 15px;">收货明细:</div>';
                result += tools.renderHtml(tpl, {list: res});
                $('#list').append(result);
            }else {
                var html = '未查询到数据';
                $('#list').append(html);
            }
        }
    })
})
