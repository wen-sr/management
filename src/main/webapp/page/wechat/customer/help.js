$(function () {
    var begin = tools.getUrlParam("begin");
    var end = tools.getUrlParam("end");
    var orderId = tools.getUrlParam("orderId");
    $('#list').html('');
    tools.request({
        url     : "/management/logisticsQuery/deliveryQuery",
        data    : {begin : begin, end : end, orderId : orderId},
        success : function (res) {
            if(res != null && res.length > 0){
                var tpl =
                    '{{#list}}' +
                    '<a class="weui-cell weui-cell_access" href="orderCaseDetail.html?orderId={{orderId}}" >' +
                    '<div class="weui-cell__bd">' +
                    '<p>单据类型：{{type}}</p>' +
                    '<p>货主：<span style="color:#4883E1;">{{ownerName}}</span>，状态：<span style="color:#E61414;font-weight: bold;">{{status}}</span></p>' +
                    '<p>单号：{{orderId}}</p>' +
                    '<p>关联单号：{{associationOrderId}}</p>' +
                    '</div>' +
                    '<div class="weui-cell__ft" style="margin-right: 10px;">'+
                    '</div>'+
                    '</a>' +
                    '{{/list}}';
                var result = '<div class="list-header" style="color: #D74D49;height: 30px;line-height: 30px;padding-left: 15px;">单据明细:</div>';
                result += tools.renderHtml(tpl, {list: res});
                $('#list').append(result);
            }else {
                var html = '未查询到数据';
                $('#list').append(html);
            }
        }
    })
})
