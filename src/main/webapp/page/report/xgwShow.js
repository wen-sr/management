$(function () {
    var doc_number = tools.getUrlParam("doc_number");
    $('#data').html('');
    if(doc_number == ''){
        return;
    }
    tools.request({
        url     : "/management/report/xgw",
        data    : {doc_number : doc_number},
        success : function (data, msg) {
            if(data != null){
                var tpl =
                    "{{#list}}" +
                    "<table class='t1' frame=hsides width='90%' rules='rows' align='center'>" +
                    "<tr><td>单号</td><td width='25%'>客户代码</td><td>客户名称</td></tr>" +
                    "<tr><td>{{doc_number}}</td><td width='25%'>{{consk}}</td><td>{{doc_shortname}}</td></tr>" +
                    "</table>" +
                    "<table class='t2' style='margin: 0px auto 10px auto' frame=hsides width='90%' rules='rows' align='center'>" +
                    "<tr><td>条码</td><td>书名</td><td>定价</td><td>开单数</td><td>实收数</td><td>差异数</td><td>差异码洋</td></tr>"+
                    "{{#xgwVoList}}" +
                    "<tr><td>{{barcode}}</td><td>{{doc_descr}}</td><td>{{doc_price}}</td><td>{{kd}}</td><td>{{ss}}</td><td>{{cy}}</td><td>{{cym}}</td></tr>"+
                    "{{/xgwVoList}}" +
                    "</table>" +
                    "{{/list}}";

                var result = tools.renderHtml(tpl, {list: data});
                $('#data').append(result);
            }else {
                var html = '未查询到数据';
                $('#data').append(html);
            }
        }
    })
});

function doJqprint(){
    $("#data").jqprint();
}


