$(function () {
    var caseid = tools.getUrlParam("caseid");
    $('#list').html('');
    tools.request({
        url     : "/management/logisticsQuery/caseSkuDetail",
        data    : {caseid : caseid},
        success : function (res) {
            if(res != null && res.length > 0){
                var tpl =
                    '{{#list}}' +
                    '<div class="weui-cell">' +
                    '<div class="weui-cell__bd">' +
                    '<div>包件号：{{caseid}}</div>' +
                    '<div>书名：{{descr}}</div>' +
                    '<div>条码：{{barcode}}</div>' +
                    '<div>定价：{{price}}</div>' +
                    '<div>数量：{{qty}}</div>' +
                    '</div>' +
                    '</div>' +
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
