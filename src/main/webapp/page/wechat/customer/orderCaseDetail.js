$(function () {
    var begin = tools.getUrlParam("begin");
    var end = tools.getUrlParam("end");
    var orderId = tools.getUrlParam("orderId");
    $('#list').html('');
    tools.request({
        url     : "/management/logisticsQuery/orderCaseQuery",
        data    : {begin : begin, end : end, orderId : orderId},
        success : function (res) {
            if(res != null && res.length > 0){
                var tpl =
                    '{{#list}}' +
                    '<a class="weui-cell weui-cell_access" href="caseDetail.html?caseid={{caseid}}" >' +
                    '<div class="weui-cell__bd">' +
                    '<p>货主：<span style="color:#4883E1;">{{ownerName}}</span>，状态：<span style="color:#E61414;font-weight: bold;">{{status}}</span></p>' +
                    '<p>包件号：{{caseid}}</p>' +
                    '<p>件数：{{caseQty}}，册数：{{qty}}</p>' +
                    '</div>' +
                    '<div class="weui-cell__ft" style="margin-right: 10px;">'+
                    '</div>'+
                    '</a>' +
                    '{{/list}}';
                var result = '<div class="list-header" style="color: #D74D49;height: 30px;line-height: 30px;padding-left: 15px;">包件明细:</div>';
                result += tools.renderHtml(tpl, {list: res});
                $('#list').append(result);
            }else {
                var html = '未查询到数据';
                $('#list').append(html);
            }
        }
    })
})
