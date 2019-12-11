function queryInfo() {
    btn.onclick = null;
    var date_begin = $("#date_begin").datebox('getValue');
    var date_end = $("#date_end").datebox('getValue');
    var formData = {
        date_begin      : date_begin,
        date_end        : date_end,
    }

    tools.request({
        url: "/management/report/qingPei",
        data: formData,
        success: function (data,msg) {
            var tab = document.getElementById("t1");
            clearTable();
            tab.rows[0].cells[0].innerHTML = $("#date_begin").datebox('getValue');
            var row;
            //箱库上架
            $('#boxUpF').html(data.shangJia.boxUpF);
            $('#boxUpU').html(data.shangJia.boxUpU);
            $('#boxUp').html(parseInt(data.shangJia.boxUpF) + parseInt(data.shangJia.boxUpU));
            var boxUpF = parseInt(data.shangJia.boxUpF);
            var boxUpU = parseInt(data.shangJia.boxUpU);
            var boxUp  =boxUpF+boxUpU;
            row = tab.rows[1];
            row.cells[1].innerHTML = boxUp;
            row.cells[2].innerHTML = boxUpF;
            row.cells[3].innerHTML = boxUpU;
            row.cells[4].innerHTML = Math.floor(boxUpF / boxUp * 100) + "%";
            // 托盘库上架
            $('#trayUpF').html(data.shangJia.trayUpF);
            $('#trayUpF1').html(data.shangJia.trayUpF1);
            $('#trayUpU').html(data.shangJia.trayUpU);
            $('#trayUpU1').html(data.shangJia.trayUpU1);
            $('#trayUp') .html((parseInt(data.shangJia.trayUpF)/parseInt(data.shangJia.trayUpF1))+(parseInt(data.shangJia.trayUpU)/parseInt(data.shangJia.trayUpU1)));
            $('#trayUp1') .html((parseInt(data.shangJia.trayUpF)/parseInt(data.shangJia.trayUpF1))+(parseInt(data.shangJia.trayUpU)/parseInt(data.shangJia.trayUpU1)));
            var trayUpF = parseInt(data.shangJia.trayUpF);
            var trayUpF1 = parseInt(data.shangJia.trayUpF1);
            var trayUpU = parseInt(data.shangJia.trayUpU);
            var trayUpU1 = parseInt(data.shangJia.trayUpU1);
            var trayUp  =trayUpF+trayUpU;
            var trayUp1  =trayUpF1+trayUpU1;
            row = tab.rows[2];
            row.cells[1].innerHTML = trayUp+"册/"+trayUp1+"件";
            row.cells[2].innerHTML = trayUpF+"册/"+trayUpF1+"件";
            row.cells[3].innerHTML = trayUpU+"册/"+trayUpU1+"件";
            row.cells[4].innerHTML = Math.floor(trayUpF / trayUp * 100) + "%";
            // TF上架
            $('#tfUpF').html(data.shangJia.tfUpF);
            $('#tfUpU').html(data.shangJia.tfUpU);
            $('#tfUp') .html(parseInt(data.shangJia.tfUpF)+parseInt(data.shangJia.tfUpU));
            var tfUpF = parseInt(data.shangJia.tfUpF);
            var tfUpU = parseInt(data.shangJia.tfUpU);
            var tfUp = tfUpF + tfUpU;
            row = tab.rows[3];
            row.cells[1].innerHTML = tfUp;
            row.cells[2].innerHTML = tfUpF;
            row.cells[3].innerHTML = tfUpU;
            row.cells[4].innerHTML = Math.floor(tfUpF / tfUp * 100) + "%";
            // 异形品上架
            $('#yxUpF').html(data.shangJia.yxUpF);
            $('#yxUpU').html(data.shangJia.yxUpU);
            $('#yxUp') .html(parseInt(data.shangJia.yxUpF)+parseInt(data.shangJia.yxUpU));
            var yxUpF = parseInt(data.shangJia.yxUpF);
            var yxUpU = parseInt(data.shangJia.yxUpU);
            var yxUp = yxUpF + yxUpU;
            row = tab.rows[4];
            row.cells[1].innerHTML = yxUp;
            row.cells[2].innerHTML = yxUpF;
            row.cells[3].innerHTML = yxUpU;
            row.cells[4].innerHTML = Math.floor(yxUpF / yxUp * 100) + "%";
            // 上架汇总
            $('#utF').html(data.shangJia.utF);
            $('#utU').html(data.shangJia.utU);
            $('#ut') .html(parseInt(data.shangJia.utF)+parseInt(data.shangJia.utU));
            var utF = parseInt(data.shangJia.utF);
            var utU = parseInt(data.shangJia.utU);
            var ut = utF + utU;
            row = tab.rows[5];
            row.cells[1].innerHTML = ut;
            row.cells[2].innerHTML = utF;
            row.cells[3].innerHTML = utU;
            row.cells[4].innerHTML = Math.floor(utF / ut * 100) + "%";


            // 箱库拣货
            $('#bpF').html(data.jianHuo.bpF);
            $('#bpU').html(data.jianHuo.bpU);
            $('#bp') .html(parseInt(data.jianHuo.bpF)+parseInt(data.jianHuo.bpU));
            var bpF = parseInt(data.jianHuo.bpF);
            var bpU = parseInt(data.jianHuo.bpU);
            var bp = bpF + bpU;
            row = tab.rows[6];
            row.cells[1].innerHTML = bp;
            row.cells[2].innerHTML = bpF;
            row.cells[3].innerHTML = bpU;
            row.cells[4].innerHTML = Math.floor(bpF / bp * 100) + "%";
            // 托盘库拣货
            $('#tpF').html(data.jianHuo.tpF);
            $('#tpF1').html(data.jianHuo.tpF1);
            $('#tpU').html(data.jianHuo.tpU);
            $('#tpU1').html(data.jianHuo.tpU1);
            $('#tp') .html((parseInt(data.jianHuo.tpF)/parseInt(data.jianHuo.tpF1))+(parseInt(data.jianHuo.tpU)/parseInt(data.jianHuo.tpU1)));
            $('#tp1') .html((parseInt(data.jianHuo.tpF)/parseInt(data.jianHuo.tpF1))+(parseInt(data.jianHuo.tpU)/parseInt(data.jianHuo.tpU1)));
            var tpF = parseInt(data.jianHuo.tpF);
            var tpF1 = parseInt(data.jianHuo.tpF1);
            var tpU = parseInt(data.jianHuo.tpU);
            var tpU1 = parseInt(data.jianHuo.tpU1);
            var tp = tpF + tpU;
            var tp1 = tpF1 + tpU1;
            row = tab.rows[7];
            row.cells[1].innerHTML = tp+"册/"+tp1+"件";
            row.cells[2].innerHTML = tpF+"册/"+tpF1+"件";
            row.cells[3].innerHTML = tpU+"册/"+tpU1+"件";
            row.cells[4].innerHTML = Math.floor(tpF / tp * 100) + "%";
            // 异形品拣货
            $('#ypF').html(data.jianHuo.ypF);
            $('#ypU').html(data.jianHuo.ypU);
            $('#tp') .html(parseInt(data.jianHuo.ypF)+parseInt(data.jianHuo.ypU));
            var ypF = parseInt(data.jianHuo.ypF);
            var ypU = parseInt(data.jianHuo.ypU);
            var yp = ypF + ypU;
            row = tab.rows[8];
            row.cells[1].innerHTML = yp;
            row.cells[2].innerHTML = ypF;
            row.cells[3].innerHTML = ypU;
            row.cells[4].innerHTML = Math.floor(ypF / yp * 100) + "%";
            // 拣货汇总
            var ptF = bpF + tpF + ypF;
            var ptU = bpU + tpU + ypU;
            var pt = bp + tp + yp;
            row = tab.rows[9];
            row.cells[1].innerHTML = pt;
            row.cells[2].innerHTML = ptF;
            row.cells[3].innerHTML = ptU;
            row.cells[4].innerHTML = Math.floor(ptF / pt * 100) + "%";
            // 请配单
            $('#qpF').html(data.jianHuo.qpF);
            $('#qpU').html(data.jianHuo.qpU);
            $('#qpF1').html(data.jianHuo.qpF1);
            $('#qpU1').html(data.jianHuo.qpU1);
            $('#qp') .html(parseInt(data.jianHuo.qpF)+parseInt(data.jianHuo.qpU));
            $('#qp1') .html(parseInt(data.jianHuo.qpF1)+parseInt(data.jianHuo.qpU1));
            var qpF = parseInt(data.jianHuo.qpF);
            var qpU = parseInt(data.jianHuo.qpU);
            var qpF1 = parseInt(data.jianHuo.qpF1);
            var qpU1 = parseInt(data.jianHuo.qpU1);
            var qp = qpF + qpU;
            var qp1 = qpF1 + qpU1;
            row = tab.rows[10];
            row.cells[1].innerHTML = qp+"单/"+qp1+"册";
            row.cells[2].innerHTML = qpF+"单/"+qpF1+"册";
            row.cells[3].innerHTML = qpU+"单/"+qpU1+"册";
            row.cells[4].innerHTML = Math.floor(qpF / qp * 100) + "%";
            // 补货
            $('#bhF').html(data.buHuo.bhF);
            $('#bhU').html(data.buHuo.bhU);
            $('#bh') .html(parseInt(data.buHuo.bhF)+parseInt(data.buHuo.bhU));
            var bhF = parseInt(data.buHuo.bhF);
            var bhU = parseInt(data.buHuo.bhU);
            var bh = bhF + bhU;
            row = tab.rows[11];
            row.cells[1].innerHTML = bh;
            row.cells[2].innerHTML = bhF;
            row.cells[3].innerHTML = bhU;
            row.cells[4].innerHTML = Math.floor(bhF / bh * 100) + "%";
            // 货阁上架
            $('#hsF').html(data.huoGe.hsF);

            $('#hs') .html=parseInt(data.huoGe.hsF);
            var hsF = parseInt(data.huoGe.hsF);
            var hs = hsF ;
            row = tab.rows[12];
            row.cells[1].innerHTML = hs;
            row.cells[2].innerHTML = hsF;
            row.cells[3].innerHTML = "0";
            row.cells[4].innerHTML = "100%";
            // 货阁下架
            $('#hxF').html(data.huoGe.hxF);
            $('#hx') .html=parseInt(data.huoGe.hxF);
            var hxF = parseInt(data.huoGe.hxF);
            var hx = hxF;
            row = tab.rows[13];
            row.cells[1].innerHTML = hx;
            row.cells[2].innerHTML = hxF;
            row.cells[3].innerHTML = "0";
            row.cells[4].innerHTML = "100%";
        }
    })
}

function clearTable(){
    var tab = document.getElementById("t1");
    var rows = tab.rows.length;
    var colums = tab.rows[0].cells.length;
    for (var i=1; i<rows; i++){
        for (var j = 1;j < colums ;j++){
            tab.rows[i].cells[j].innerHTML = "";
        }
    }
}








