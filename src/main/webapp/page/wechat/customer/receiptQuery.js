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
    var shipno = $("#shipno").val();
    window.open("receiptDetail.html?begin=" + begin + "&end=" + end + "&shipno=" + shipno, "_self");
}