$(function () {
    getTime();
    getData();
    window.setInterval(getData,1000*60*10);

});
function getTime(){
    var attime;
    function clock(){
        var time=new Date();
        var month=time.getMonth()+1;
        attime=time.getFullYear()+"/"+month+"/"+time.getDate()+ "&nbsp;" +time.getHours()+":"+time.getMinutes()+":"+time.getSeconds();
        $("#clock").html(attime);
    }
    setInterval(clock,1000);
}

function getData(){
    tools.request({
        url         :   tools.getServerUrl('/led/lushunku'),
        success     :   function (data, msg) {
            $("#caseQty1").html(data.caseQty1);
            $("#caseQty2").html(data.caseQty2);
            $("#caseQty3").html(data.caseQty3);
            $("#caseQty4").html(data.caseQty4);
            $("#caseQty5").html(data.caseQty5);
            $("#caseQty6").html(data.caseQty6);
            $("#caseQty7").html(data.caseQty7);
            $("#caseQty8").html(data.caseQty8);
        }
    });
}
