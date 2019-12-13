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
    var fourStatus= $("#four").is(":visible");
    var fiveStatus= $("#five").is(":visible");
    if(oneStatus == true){
        two();
        return;
    }
    if(twoStatus == true){
        three();
        return;
    }
    if(threeStatus == true){
        four();
        return;
    }
    if(fourStatus == true){
        five();
        return;
    }
    if(fiveStatus == true){
        one();
        return;
    }

}

function one(){
    var html = $("#one").html();
    if(html == ''){
        // two();
        return;
    }
    $("#one").show();
    $("#two").hide();
    $("#three").hide();
    $("#four").hide();
    $("#five").hide();
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
    $("#four").hide();
    $("#five").hide();
}

function three() {
    var html = $("#three").html();
    if(html == ''){
        four();
        return;
    }
    $("#three").show();
    $("#four").hide();
    $("#two").hide();
    $("#one").hide();
    $("#five").hide();
}

function four() {
    var html = $("#four").html();
    if(html == ''){
        five();
        return;
    }
    $("#four").show();
    $("#two").hide();
    $("#one").hide();
    $("#three").hide();
    $("#five").hide();
}

function five() {
    var html = $("#five").html();
    if(html == ''){
        one();
        return;
    }
    $("#five").show();
    $("#four").hide();
    $("#two").hide();
    $("#one").hide();
    $("#three").hide();
}

function getData(){
    $.ajax({
        type:"POST",
        url:"/management/led/baozhuang",
        success:function (res) {
            if(res.data == null) {
                return;
            }
            $("#one").html("");
            $("#two").html("");
            $("#three").html("");
            $("#four").html("");

            var theader = "<tr><td>作业人员</td><td>包装册数</td><td>包装品种</td><td>包装件数</td><td>效率</td><td>排名</td></tr>";
            var t1 = "<table cellpadding='0' cellspacing='0' style='font-size: 18px;width: 100%;font-weight:normal;border-spacing:0px 1.5px;'>" + theader;

            for(var i = 0; i < (res.data.length > 8 ? 8 : res.data.length); i++ ){
                var data = res.data[i];
                t1 += "<tr><td>" + data.usrFname + "</td><td>" + data.qty + "</td><td>" + data.skucount + "</td><td>" + data.caseqty + "</td><td>" + data.efficiency + "</td><td>" + (i+1) + "</td></tr>";
            }

            var t2 = "";
            if(res.data.length >= 8){
                t2 = "<table cellpadding='0' cellspacing='0' style='font-size: 18px;width: 100%;font-weight:normal;border-spacing:0px 1.5px;'>" + theader;

                for(var i = 8; i < (res.data.length > 16 ? 16 : res.data.length); i++ ){
                    var data = res.data[i];
                    t2 += "<tr><td>" + data.usrFname + "</td><td>" + data.qty + "</td><td>" + data.skucount + "</td><td>" + data.caseqty + "</td><td>" + data.efficiency + "</td><td>" + (i+1) + "</td></tr>";
                }
            }
            var t3 = "";
            if(res.data.length >= 16){
                t3 = "<table cellpadding='0' cellspacing='0' style='font-size: 18px;width: 100%;font-weight:normal;border-spacing:0px 1.5px;'>" + theader;
                for(var i = 16; i < (res.data.length > 24 ? 24 : res.data.length); i++ ){
                    var data = res.data[i];
                    t3 += "<tr><td>" + data.usrFname + "</td><td>" + data.qty + "</td><td>" + data.skucount + "</td><td>" + data.caseqty + "</td><td>" + data.efficiency + "</td><td>" + (i+1) + "</td></tr>";
                }
            }

            var t4 = "";
            if(res.data.length >= 24){
                t4 = "<table cellpadding='0' cellspacing='0' style='font-size: 18px;width: 100%;font-weight:normal;border-spacing:0px 1.5px;'>" + theader;
                for(var i = 24; i < (res.data.length > 32 ? 32 : res.data.length); i++ ){
                    var data = res.data[i];
                    t4 += "<tr><td>" + data.usrFname + "</td><td>" + data.qty + "</td><td>" + data.skucount + "</td><td>" + data.caseqty + "</td><td>" + data.efficiency + "</td><td>" + (i+1) + "</td></tr>";
                }
            }

            var t5 = "";
            if(res.data.length >= 32){
                t5 = "<table cellpadding='0' cellspacing='0' style='font-size: 18px;width: 100%;font-weight:normal;border-spacing:0px 1.5px;'>" + theader;
                for(var i = 32; i < (res.data.length > 40 ? 40 : res.data.length); i++ ){
                    var data = res.data[i];
                    t5 += "<tr><td>" + data.usrFname + "</td><td>" + data.qty + "</td><td>" + data.skucount + "</td><td>" + data.caseqty + "</td><td>" + data.efficiency + "</td><td>" + (i+1) + "</td></tr>";
                }
            }

            var sumqty = 0;
            var sumsku = 0;
            var sumcaseqty = 0;
            for(var j = 0; j < res.data.length ; j++){
                sumqty += res.data[j].qty;
                sumsku += res.data[j].skucount;
                sumcaseqty += res.data[j].caseqty
            }

            var length = parseInt(res.data.length);
            if(length < 8){
                t1 += "<tr><td colspan='1'>合计</td><td>" + sumqty + "</td><td> " + sumsku +"</td><td colspan='3'>"+ sumcaseqty +"</td></tr></table>";
            }else if (8 <= length && length < 16){
                t2 += "<tr><td colspan='1'>合计</td><td>" + sumqty + "</td><td> " + sumsku +"</td><td colspan='3'>"+ sumcaseqty +"</td></tr></table>";
            }else if(16 <= length && length < 24){
                t3 += "<tr><td colspan='1'>合计</td><td>" + sumqty + "</td><td> " + sumsku +"</td><td colspan='3'>"+ sumcaseqty +"</td></tr></table>";
            }else if(24 <= length && length < 32){
                t4 += "<tr><td colspan='1'>合计</td><td>" + sumqty + "</td><td> " + sumsku +"</td><td colspan='3'>"+ sumcaseqty +"</td></tr></table>";
            }else if(32 <= length && length < 40){
                t5 += "<tr><td colspan='1'>合计</td><td>" + sumqty + "</td><td> " + sumsku +"</td><td colspan='3'>"+ sumcaseqty +"</td></tr></table>";
            }

            $("#one").html(t1);
            $("#two").html(t2);
            $("#three").html(t3);
            $("#four").html(t4);
            $("#five").html(t5);

            $("#five").hide();
            $("#four").hide();
            $("#two").hide();
            $("#one").show();
            $("#three").hide();
        },
        error:function(){
            alert("数据错误，联系管理员");
        }
    });
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

