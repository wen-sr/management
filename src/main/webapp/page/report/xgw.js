
function goo() {
    $.messager.confirm('操作提示', '确认信息', function(r){
        if (r){
            var doc_number = $("#doc_number").combobox('doc_number');
            var consk = $("#consk").combobox('consk');
            var sku = $("#sku").combobox('sku');
            var qty = $("#qty").combobox('qty');
            var formData = {
                doc_number        : doc_number,
                consk             : consk,
                sku               : sku,
                qty               : qty
            }
            loadData(20, 'POST', formData);
            go(20, 'POST', formData);
            go1(20, 'POST', formData);
            go2(20, 'POST', formData);
            alert('提交成功: '+r);
        }
    });
}


function loadData(pageSize, method, formData){
    $("#data").datagrid({
        url:'/management/report/goo',
        method: method || 'GET',
        queryParams:formData || '',
        height:'auto',
        fit:true,
        fitColumns:true,
        striped:true,
        rownumbers:true,
        border:true,
        singleSelect:true,
        pagination:false,
        pageSize: pageSize || 20,
        pageList:[10,20,50,pageSize || 0],
        showFooter: true,
        toolbar:'#tb',
    });
}
function go() {
    var doc_number = $("#doc_number").combobox('doc_number');
    var consk = $("#consk").combobox('consk');
    var sku = $("#sku").combobox('sku');
    var qty = $("#qty").combobox('qty');
    var formData = {
        doc_number        : doc_number,
        consk             : consk,
        sku               : sku,
        qty               : qty
    }
    loadData(20, 'POST', formData);
}

function go1() {
    var doc_number = $("#doc_number").combobox('doc_number');
    var consk = $("#consk").combobox('consk');
    var sku = $("#sku").combobox('sku');
    var qty = $("#qty").combobox('qty');
    var formData = {
        doc_number        : doc_number,
        consk             : consk,
        sku               : sku,
        qty               : qty
    }
    loadData(20, 'POST', formData);
}
function go2() {
    var doc_number = $("#doc_number").combobox('doc_number');
    var consk = $("#consk").combobox('consk');
    var sku = $("#sku").combobox('sku');
    var qty = $("#qty").combobox('qty');
    var formData = {
        doc_number        : doc_number,
        consk             : consk,
        sku               : sku,
        qty               : qty
    }
    loadData(20, 'POST', formData);
}
function cx() {
    var doc_number = $("#doc_number").textbox('getValue');
    {window.open("xgwShow.html?doc_number=" + doc_number, "_self");}
}
