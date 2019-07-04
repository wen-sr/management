$(function () {
    $("#begin").calendar({
        dateFormat: 'yyyy-mm-dd',
        onChange: function (p, values, displayValues) {
            console.log(values, displayValues);
        }
    });
    $("#end").calendar({
        dateFormat: 'yyyy-mm-dd',
        onChange: function (p, values, displayValues) {
            console.log(values, displayValues);
        }
    });
})

function go() {
    var begin = $("#begin").val();
    var end = $("#end").val();
    var orderId = $("#orderId").val();
    var caseid = $("#caseid").val();
    var dateBegin = new Date(begin.replace(/-/g, "/")); //begintime 为开始时间

    var dateEnd = new Date(end.replace(/-/g, "/"));   // endtime 为结束时间
    var dateDiff = dateEnd.getTime() - dateBegin.getTime();//时间差的毫秒数
    var dayDiff = Math.floor(dateDiff / (24 * 3600 * 1000));//计算出相差天数
    if(dayDiff > 30) {
        $.toast("时间区间不能超过1个月", "forbidden");
        return;
    }
    dateEnd = new Date();
    dateDiff = dateEnd.getTime() - dateBegin.getTime();
    dayDiff = Math.floor(dateDiff / (24 * 3600 * 1000));
    if(dayDiff > 365) {
        $.toast("只能查询1年内的数据", "forbidden");
        return;
    }
    if(caseid != "" && caseid != undefined){
        window.open("caseDetail.html.html?caseid=" + caseid, "_self");
    }else {
        window.open("deliveryDetail.html?begin=" + begin + "&end=" + end + "&orderId=" + orderId, "_self");
    }
}