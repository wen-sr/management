function queryInfo() {
    var doc_number = $("#doc_number").textbox('getValue');
    window.open("zhuPeiGouBaoShow.html?doc_number=" + doc_number, "_self");
}