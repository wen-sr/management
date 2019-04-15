$(function () {
    var id = tools.getUrlParam("id");
    getData(id);
});

function getData(id) {
    if(id == ''){
        return;
    }
    $("#list").html("");
    tools.request({
        url:'/management/busi/busiMessageWx/queryInfo2',
        data:{id : id},
        success:function(data, msg){
            if(data != null){
                if(data != null && data.length > 0){
                    var tpl =
                        '{{#list}}' +
                        '<div class="weui-cell">' +
                        '<div class="weui-cell__bd">' +
                        '<p>今日收货：{{qtyReceiptMouth}}</p>' +
                        '<p>累计收货：{{qtyReceiptMouth}}</p>' +
                        '<p>今日发货：{{qtyDeliveryDay}}</p>' +
                        '<p>累计发货：{{qtyDeliveryMouth}}</p>' +
                        '<p>库存：{{qtyStock}}</p>' +
                        '<p>录入人：{{addwho}}</p>' +
                        '<p>备注：{{remark}}</p>' +
                        '</div>' +
                        '</div>' +
                        '{{/list}}';
                    var result = '<div class="list-header" style="color: #D74D49;height: 30px;line-height: 30px;padding-left: 15px;">产量详情:</div>';
                    result += tools.renderHtml(tpl, {list: data});
                    $('#list').append(result);
                }
            }
        }
    });
}