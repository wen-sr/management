$(function () {
    var register = tools.getUrlParam("register");
    $('#list').html('');
    if(register == ''){
        return;
    }
    tools.request({
        url     : "/management/logisticsQuery/registerDetail",
        data    : {register : register},
        success : function (res) {
            if(res != null && res.length > 0){
                $("#doc_number").val(res[0].doc_number);
                var tpl =
                    '{{#list}}' +
                    '<div class="weui-cell">' +
                    '<div class="weui-cell__bd">' +
                    '<div>{{doc_company}} : {{doc_compname}}</div>' +
                    '<div>到货登记号：{{register}}</div>' +
                    '<div>作业单号：{{doc_number}}</div>' +
                    '<div>单据状态：{{status}}</div>' +
                    '<div>到货件数：{{caseQty}}</div>' +
                    '<div>应收册数：{{doc_eqty}}</div>' +
                    '<div>实收册数：{{doc_aqty}}</div>' +
                    '</div>' +
                    '</div>' +
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

function diff() {
    var doc_number = $("#doc_number").val();
    if(doc_number == ''){
        return;
    }
    window.open("differenceDetail.html?doc_number=" + doc_number, "_self");
}

function rej() {
    var doc_number = $("#doc_number").val();
    if(doc_number == ''){
        return;
    }
    window.open("rejectDetail.html?doc_number=" + doc_number, "_self");
}