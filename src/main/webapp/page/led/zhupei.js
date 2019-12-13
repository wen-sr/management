$(function () {
    getData();
    setInterval("GetTime()", 1000);
    $('body').everyTime('8s', function() {
        switchWindow();
    });
    $('body').everyTime('6hs', function() {
        getData();
    });
})

function switchWindow() {
    var oneStatus= $("#one").is(":visible");
    var twoStatus= $("#two").is(":visible");
    var threeStatus= $("#three").is(":visible");
    if(oneStatus == true){
        two();
        return;
    }
    if(twoStatus == true){
        three();
        return;
    }
    if(threeStatus == true){
        one();
        return;
    }

}

function one(){
    var html = $("#one").html();
    if(html == ''){
        two();
        return;
    }
    $("#one").show();
    $("#two").hide();
    $("#three").hide();
}

function two() {
    var html = $("#two").html();
    if(html == ""){
        three();
        return;
    }
    $("#two").show();
    $("#one").hide();
    $("#three").hide();
}

function three() {
    var html = $("#three").html();
    if(html == ''){
        one();
        return;
    }
    $("#three").show();
    $("#two").hide();
    $("#one").hide();
}

function getData(){
    $.ajax({
        type:"POST",
        url:"/management/led/zhupei",
        success:function (res) {
            if(res.data == null) {
                return;
            }

            var zhuPeiLedList = res.data.zhuPeiLedList;
            var zhuPeiZongBiaoList = res.data.zhuPeiZongBiaoList;
            $("#one").html("");
            $("#two").html("");
            $("#three").html("");
            $("#four").html("");
            $("#five").html("");
            var header = "<tr><td>作业线</td><td>上线册数</td><td>上线品种</td><td>效率值</td><td>排名</td></tr>";
            var t1 = "<table cellpadding='0' cellspacing='0' style='font-size: 18px;width: 100%;font-weight:normal;border-spacing:0px 1.5px;'>" +
                header;
            for(var i = 0; i < (zhuPeiLedList.length > 8 ? 8 : zhuPeiLedList.length); i++ ){
                var data = zhuPeiLedList[i];
                t1 += "<tr><td>" + data.ailid + "</td><td>" + data.sorqty + "</td><td>" + data.skucount + "</td><td>" + data.efficiency + "</td><td>" + (i+1) + "</td></tr>"
            }

            var t2 = "";
            if(zhuPeiLedList.length >= 8){
                t2 = "<table cellpadding='0' cellspacing='0' style='font-size: 18px;width: 100%;font-weight:normal;border-spacing:0px 1.5px;'>" +
                    header;
                for(var i = 8; i < (zhuPeiLedList.length > 16 ? 16 : zhuPeiLedList.length); i++ ){
                    var data = zhuPeiLedList[i];
                    t2 += "<tr><td>" + data.ailid + "</td><td>" + data.sorqty + "</td><td>" + data.skucount + "</td><td>" + data.efficiency + "</td><td>" + (i+1) + "</td></tr>"
                }
            }
            var t3 = "";
            if(zhuPeiLedList.length >= 16){
                t3 = "<table cellpadding='0' cellspacing='0' style='font-size: 18px;width: 100%;font-weight:normal;border-spacing:0px 1.5px;'>" +
                    header;
                for(var i = 16; i < (zhuPeiLedList.length > 24 ? 24 : zhuPeiLedList.length); i++ ){
                    var data = zhuPeiLedList[i];
                    t3 += "<tr><td>" + data.ailid + "</td><td>" + data.sorqty + "</td><td>" + data.skucount + "</td><td>" + data.efficiency + "</td><td>" + (i+1) + "</td></tr>"
                }
            }
            var t4 = "";
            if(zhuPeiLedList.length >= 24){
                t4 = "<table cellpadding='0' cellspacing='0' style='font-size: 18px;width: 100%;font-weight:normal;border-spacing:0px 1.5px;'>" +
                    header;
                for(var i = 24; i < (zhuPeiLedList.length > 32 ? 32 : zhuPeiLedList.length); i++ ){
                    var data = zhuPeiLedList[i];
                    t4 += "<tr><td>" + data.ailid + "</td><td>" + data.sorqty + "</td><td>" + data.skucount + "</td><td>" + data.efficiency + "</td><td>" + (i+1) + "</td></tr>"
                }
            }
            var t5 = "";
            if(zhuPeiLedList.length >= 32){
                t5 = "<table cellpadding='0' cellspacing='0' style='font-size: 18px;width: 100%;font-weight:normal;border-spacing:0px 1.5px;'>" +
                    header;
                for(var i = 32; i < (zhuPeiLedList.length > 40 ? 40 : zhuPeiLedList.length); i++ ){
                    var data = zhuPeiLedList[i];
                    t5 += "<tr><td>" + data.ailid + "</td><td>" + data.sorqty + "</td><td>" + data.skucount + "</td><td>" + data.efficiency + "</td><td>" + (i+1) + "</td></tr>"
                }
            }

            var sumqty = 0;
            var sumsku = 0;
            for(var j = 0; j < zhuPeiLedList.length ; j++){
                sumqty += zhuPeiLedList[j].sorqty;
                sumsku += zhuPeiLedList[j].skucount;
            }
            var length = parseInt(zhuPeiLedList.length);
            if(length < 8){
                t1 += "<tr><td>合计</td><td>" + sumqty + "</td><td> " + sumsku +"</td><td>&nbsp;</td><td>&nbsp;</td></tr>";
            }else if (8 <= length && length < 16){
                t2 += "<tr><td>合计</td><td>" + sumqty + "</td><td> " + sumsku +"</td><td>&nbsp;</td><td>&nbsp;</td></tr>";
            }else if(16 <= length && length < 24){
                t3 += "<tr><td>合计</td><td>" + sumqty + "</td><td> " + sumsku +"</td><td>&nbsp;</td><td>&nbsp;</td></tr>";
            }else if(24 <= length && length < 32){
                t3 += "<tr><td>合计</td><td>" + sumqty + "</td><td> " + sumsku +"</td><td>&nbsp;</td><td>&nbsp;</td></tr>";
            }else if(32 <= length && length < 40){
                t3 += "<tr><td>合计</td><td>" + sumqty + "</td><td> " + sumsku +"</td><td>&nbsp;</td><td>&nbsp;</td></tr>";
            }

            while (true){
                if(t1 == ""){
                    t1 += getHTML(zhuPeiZongBiaoList);
                    break;
                }
                if(t2 == ""){
                    t2 += getHTML(zhuPeiZongBiaoList);
                    break;
                }
                if(t3 == ""){
                    t3 += getHTML(zhuPeiZongBiaoList);
                    break;
                }
                if(t4 == ""){
                    t4 += getHTML(zhuPeiZongBiaoList);
                    break;
                }
                if(t5 == ""){
                    t5 += getHTML(zhuPeiZongBiaoList);
                    break;
                }
                break;
            }

            $("#one").html(t1);
            $("#two").html(t2);
            $("#three").html(t3);
            $("#four").html(t4);
            $("#five").html(t5);


            $("#two").hide();
            $("#one").show();
            $("#three").hide();
            $("#four").hide();
            $("#five").hide();
        },
        error:function(){
            getData();
        }
    });
}

function getHTML(zhuPeiZongBiaoList) {
    var t1 = "";
    t1 += "<table cellpadding='0' cellspacing='0' style='font-size: 16px;width: 100%;font-weight:normal;border-spacing:0px 1.5px;'>";
    t1 += "<tr><td>作业类型</td><td>总任务(册/单)</td><td>已完成(册/单)</td><td>未完成(册/单)</td><td>完成率</td></tr>";
    for(var i = 0; i<zhuPeiZongBiaoList.length; i++){
        t1 += "<tr><td>" + zhuPeiZongBiaoList[i].tt + "</td><td>" + zhuPeiZongBiaoList[i].totalQty + "/" + zhuPeiZongBiaoList[i].totalCount + "</td><td>" + zhuPeiZongBiaoList[i].completeQty + "/" + zhuPeiZongBiaoList[i].completeCount + "</td><td>" + zhuPeiZongBiaoList[i].incompleteQty + "/" + zhuPeiZongBiaoList[i].incompleteCount + "</td><td>" + Math.round(parseFloat(zhuPeiZongBiaoList[i].completeQty)/parseFloat(zhuPeiZongBiaoList[i].totalQty)*100) +"%</td></tr>";
    }
    var sumTotalQty = 0;
    var sumCompleteQty = 0;
    var sumIncompleteQty = 0;
    var sumTotalCount = 0;
    var sumCompleteCount = 0;
    var sumIncompleteCount = 0;
    for(var i = 0; i<zhuPeiZongBiaoList.length; i++){
        sumTotalQty += zhuPeiZongBiaoList[i].totalQty;
        sumCompleteQty += zhuPeiZongBiaoList[i].completeQty;
        sumIncompleteQty += zhuPeiZongBiaoList[i].incompleteQty;
        sumTotalCount += zhuPeiZongBiaoList[i].totalCount;
        sumCompleteCount += zhuPeiZongBiaoList[i].completeCount;
        sumIncompleteCount += zhuPeiZongBiaoList[i].incompleteCount;

    }
    t1 += "<tr><td>合计</td><td>"+ sumTotalQty + "/" + sumTotalCount +"</td><td>" + sumCompleteQty + "/" + sumCompleteCount +"</td><td>"+ sumIncompleteQty + "/" + sumIncompleteCount +"</td><td>"+ Math.round(parseFloat(sumCompleteQty)/parseFloat(sumTotalQty)*100) +"%</td></tr>";
    return t1;
}

//获取时间并设置格式
function GetTime() {
    var mon, day, now, hour, min, ampm, time, str, tz, end, beg, sec;
    /*
    mon = new Array("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec");
    */
    mon = new Array("一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月",
        "九月", "十月", "十一月", "十二月");
    /*
    day = new Array("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
    */
    day = new Array("周日", "周一", "周二", "周三", "周四", "周五", "周六");
    now = new Date();
    hour = now.getHours();
    min = now.getMinutes();
    sec = now.getSeconds();
    if (hour < 10) {
        hour = "0" + hour;
    }
    if (min < 10) {
        min = "0" + min;
    }
    if (sec < 10) {
        sec = "0" + sec;
    }
    $("#Timer").html(
        now.getFullYear() + "年" + (now.getMonth() + 1) + "月" + now.getDate() + "日" + "  " + hour + ":" + min + ":" + sec
    );
}

