$(function () {
    var doc_number = tools.getUrlParam("doc_number");
    $('#data').html('');
    if(doc_number == ''){
        return;
    }
    tools.request({
        url     : "/management/logisticsQuery/getZhuPeiGouBao",
        data    : {doc_number : doc_number},
        success : function (data, msg) {
            if(data != null && data.length > 0){
                var tpl =
                    "{{#list}}" +
                    "<table class='t1' frame=hsides width='90%' rules='rows' align='center'>" +
                    "<tr><td>单号</td><td width='45%'>书名</td><td>书号</td><td>包册数</td></tr>" +
                    "<tr><td>{{doc_number}}</td><td width='45%'>{{doc_descr}}</td><td>{{doc_sku}}</td><td>{{doc_case_qty}}</td></tr>" +
                    "</table>" +
                    "<table class='t2' style='margin: 0px auto 10px auto' frame=hsides width='90%' rules='rows' align='center'>" +
                        "<tr><td>客户代码</td><td>客户名称</td><td>够包数量</td><td>整件数量</td><td>零册数量</td><td>尾包</td></tr>"+
                        "{{#zhuPeiGouBaoVoList}}" +
                        "<tr><td>{{doc_consk}}</td><td>{{doc_shortname}}</td><td>{{doc_cqty}}</td><td>{{zbs}}</td><td>{{lcs}}</td><td>{{wbjs}}件零{{wblcs}}册</td></tr>"+
                        "{{/zhuPeiGouBaoVoList}}" +
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
