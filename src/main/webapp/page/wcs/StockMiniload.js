function queryInfo() {
    var containerCodeTmp = $("#containerCodeTmp").val();
    var formData = {
        containerCodeTmp        : containerCodeTmp,
    }
    tools.request({
        url     : "/management/wcs/queryInfo",
        data    : formData,
        success : function (data, msg) {
            $('#detail').html('');
            if(data != null && data.length > 0){
                var result = "";
                var tpl =
                    '{{#list}}' +
                    '<ul>' +
                    '<li>箱号：<span>{{containerCodeTmp}}</span></li>' +
                    '<li>仓库：<span>{{bankLocn}}</span></li>' +
                    '<li>立库编号：<span>{{bankId}}</span></li>' +
                    '<li>所在层：<span>{{bankLayer}}</span></li>' +
                    '<li>储位：<span>{{bankColumn}}</span></li>' +
                    '</ul><br/>' +
                    '{{/list}}';
                result += tools.renderHtml(tpl, {list: data});
                $('#detail').append(result);
            }else {
                var html = '未查询到数据';
                $('#detail').append(html);
            }
        }
    })
}


function queryInfo1() {
    var bankId=$("#bankId").val();
    var bankLayer=$("#bankLayer").val();
    var bankColumn=$("#bankColumn").val();
    var formData = {
        bankId         :bankId,
        bankLayer      :bankLayer,
        bankColumn     :bankColumn,
    }
    tools.request({
        url     : "/management/wcs/queryInfo1",
        data    : formData,
        success : function (data, msg) {
            $('#detail1').html('');
            if(data != null && data.length > 0){
                var result = "";
                var tpl =
                    '{{#list}}' +
                    '<ul>' +
                    '<li>箱号：<span>{{containerCodeTmp}}</span></li>' +
                    '<li>立库编号：<span>{{bankLocn}}</span></li>' +
                    '<li>所在层：<span>{{bankLayer}}</span></li>' +
                    '<li>储位：<span>{{bankColumn}}</span></li>' +
                    '</ul><br/>' +
                    '{{/list}}';
                result += tools.renderHtml(tpl, {list: data});
                $('#detail1').append(result);
            }else {
                var html = '未查询到数据';
                $('#detail1').append(html);
            }
        }
    })
}


function queryInfo2() {
    var bankId1=$("#bankId1").is(':checked');//返回的值是true or false
    var bankId2=$("#bankId2").is(':checked');
    var bankId3=$("#bankId3").is(':checked');
    var bankId4=$("#bankId4").is(':checked');
    var bankId5=$("#bankId5").is(':checked');
    var bankId6=$("#bankId6").is(':checked');
    var bankId7=$("#bankId7").is(':checked');
    var bankId8=$("#bankId8").is(':checked');
    var bankId9=$("#bankId9").is(':checked');
    var bankId10=$("#bankId10").is(':checked');
    var ids = [];//数组
    if(bankId1){
        ids.push(1);
    }
    if(bankId2){
        ids.push(2)
    }
    if(bankId3){
        ids.push(3)
    }
    if(bankId4){
        ids.push(4)
    }
    if(bankId5){
        ids.push(5)
    }
    if(bankId6){
        ids.push(6)
    }
    if(bankId7){
        ids.push(7)
    }
    if(bankId8){
        ids.push(8)
    }
    if(bankId9){
        ids.push(9)
    }
    if(bankId10){
        ids.push(10)
    }
    var formData = {
        ids     : ids
    }

    tools.request({
        url     : "/management/wcs/queryInfo2",
        data    : formData,
        success : function (data, msg) {
            $('#detail2').html('');
            $('#detail6').html('');
            $('#detail7').html('');
            if(data != null){
                $('#detail2').append('<div style="padding-top:10px">' +data[0].flag + '：<span>' + data[0].locQty + '</span></div>');
                $('#detail6').append('<div style="padding-top:10px">' +data[1].flag + '：<span>' + data[1].locQty + '</span></div>');
                $('#detail7').append('<div style="padding-top:10px">' +data[2].flag + '：<span>' + data[2].locQty + '</span></div>');
            }else {
                var html = '未查询到数据';
                $('#detail2').append(html);
                $('#detail6').append(html);
                $('#detail7').append(html);
            }
        }
    })
}
$(function() {
    $("#selectAll").click(function() {
        $(":checkbox[name='bank']").prop("checked", this.checked); // this指代的你当前选择的这个元素的JS对象
    });
});



function queryInfo3() {
    var bankId11=$("#bankId11").is(':checked');//返回的值是true or false
    var bankId12=$("#bankId12").is(':checked');
    var ids1 = [];//数组
    if(bankId11){
        ids1.push(11);
    }
    if(bankId12){
        ids1.push(12);
    }
    var formData1 = {
        ids1     : ids1
    }
    tools.request({
        url     : "/management/wcs/queryInfo3",
        data    : formData1,
        success : function (data, msg) {
            $('#detail3').html('');
            $('#detail8').html('');
            $('#detail9').html('');
            //利用vo下的locqtyvo来取值
            //一共有三个数据,因此在这里用0,1,2来表示那三个数据.名字+值.记得用单引号括起来.
            if(data != null){
                $('#detail3').append('<div style="padding-top:10px">' +data[0].flag + '：<span>' + data[0].locQty + '</span></div>');
                $('#detail8').append('<div style="padding-top:10px">' +data[1].flag + '：<span>' + data[1].locQty + '</span></div>');
                $('#detail9').append('<div style="padding-top:10px">' +data[2].flag + '：<span>' + data[2].locQty + '</span></div>');
            }else {
                var html = '未查询到数据';
                $('#detail3').append(html);
                $('#detail8').append(html);
                $('#detail9').append(html);
            }
        }
    })
}
$(function() {
    $("#selectAll1").click(function() {
        $(":checkbox[name='bank1']").prop("checked", this.checked); // this指代的你当前选择的这个元素的JS对象
    });
});


function queryInfo4() {
    var connbr = $("#connbr").val();
    var formData = {
        connbr        : connbr,
    }
    tools.request({
        url     : "/management/wcs/queryInfo4",
        data    : formData,
        success : function (data, msg) {
            $('#detail4').html('');
            if(data != null && data.length > 0){
                var result = "";
                var tpl =
                    '{{#list}}' +
                    '<ul>' +
                    '<li>箱号：<span>{{connbr}}</span></li>' +
                    '<li>任务类型：<span>{{taskType}}</span></li>' +
                    '<li>状态：<span>{{status}}</span></li>' +
                    '<li>时间：<span>{{timestampTransInsert}}</span></li>' +
                    '<li>订单号：<span>{{ordernbr}}</span></li>' +
                    '</ul><br/>' +
                    '{{/list}}';
                result += tools.renderHtml(tpl, {list: data});
                $('#detail4').append(result);
            }else {
                var html = '未查询到数据';
                $('#detail4').append(html);
            }
        }
    })
}


function queryInfo5() {
    var connbr = $("#connbr1").val();
    var formData = {
        connbr        : connbr,
    }
    tools.request({
        url     : "/management/wcs/queryInfo5",
        data    : formData,
        success : function (data, msg) {
            $('#detail5').html('');
            if(data != null && data.length > 0){
                var result = "";
                var tpl =
                    '{{#list}}' +
                    '<ul>' +
                    '<li>箱号：<span>{{connbr}}</span></li>' +
                    '<li>订单号：<span>{{ordernbr}}</span></li>' +
                    '<li>任务类型：<span>{{tasktype}}</span></li>' +
                    '<li>时间：<span>{{timestampItf}}</span></li>' +
                    '<li>备注：<span>{{mark}}</span></li>' +
                    '</ul><br/>' +
                    '{{/list}}';
                result += tools.renderHtml(tpl, {list: data});
                $('#detail5').append(result);
            }else {
                var html = '未查询到数据';
                $('#detail5').append(html);
            }
        }
    })
}