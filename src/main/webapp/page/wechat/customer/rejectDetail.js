$(function () {
    var doc_number = tools.getUrlParam("doc_number");
    $('#list').html('');
    if(doc_number == ''){
        return;
    }
    tools.request({
        url     : "/management/logisticsQuery/rejectDetail",
        data    : {doc_number : doc_number},
        success : function (res) {
            if(res != null && res.length > 0){
                var tpl =
                    '{{#list}}' +
                    '<div class="weui-cell">' +
                    '<div class="weui-cell__bd">' +
                    '<div>{{descr}}</div>' +
                    '<div>条码：{{barcode}}</div>' +
                    '<div>定价：{{price}}</div>' +
                    '<div>拒收数量：{{diffQty}}</div>' +
                    '<div>拒收原因：{{reason}}</div>' +
                    '</div>' +
                    '</div>' +
                    '{{/list}}';
                var result = '<div class="list-header" style="color: #D74D49;height: 30px;line-height: 30px;padding-left: 15px;">拒收明细:</div>';
                result += tools.renderHtml(tpl, {list: res});
                $('#list').append(result);
            }else {
                var html = '未查询到数据';
                $('#list').append(html);
            }
        }
    })
})
