function queryInfo() {
    // btn.onclick = null;
    var date_begin = $("#date_begin").datebox('getValue');
    var date_end = $("#date_end").datebox('getValue');
    var formData = {
        date_begin      : date_begin,
        date_end        : date_end,
    }

    tools.request({
        url: "/management/report/baoZ",
        data: formData,
        success: function (data,msg) {
            var tab = document.getElementById("t1");
            clearTable();
            tab.rows[0].cells[0].innerHTML = $("#date_begin").datebox('getValue');
            var row;
            //一般图书主配发货
            row = tab.rows[1];
            $('#yzf').html(data.yzf);
            $('#yzf1').html(data.yzf1);
            var yzf = parseInt(data.yzf);
            var yzf1 = parseInt(data.yzf1);
            row.cells[1].innerHTML = yzf+"件/"+yzf1+"册";
            //一般图书主配够包
            $('#yzg').html(data.yzg);
            $('#yzg1').html(data.yzg1);
            var yzg = parseInt(data.yzg);
            var yzg1 = parseInt(data.yzg1);
            row.cells[2].innerHTML = yzg+"件/"+yzg1+"册";
            //一般图书主配发货未完成
            $('#yzw').html(data.yzw);
            $('#yzw1').html(data.yzw1);
            var yzw = parseInt(data.yzw);
            var yzw1 = parseInt(data.yzw1);
            // row.cells[3].innerHTML = yzw+"件/"+yzw1+"册";
            row.cells[3].innerHTML = yzw1;
            //一般图书请配发货
            $('#yqf').html(data.yqf);
            $('#yqf1').html(data.yqf1);
            var yqf = parseInt(data.yqf);
            var yqf1 = parseInt(data.yqf1);
            row.cells[4].innerHTML = yqf+"件/"+yqf1+"册";
            //一般图书请配够包
            $('#yqg').html(data.yqg);
            $('#yqg1').html(data.yqg1);
            var yqg = parseInt(data.yqg);
            var yqg1 = parseInt(data.yqg1);
            row.cells[5].innerHTML = yqg+"件/"+yqg1+"册";
            //一般图书请配未完成
            $('#yqw').html(data.yqw);
            $('#yqw1').html(data.yqw1);
            var yqw = parseInt(data.yqw);
            var yqw1 = parseInt(data.yqw1);
            // row.cells[6].innerHTML = yqw+"件/"+yqw1+"册";
            row.cells[6].innerHTML = yqw1;
            //一般图书退货发货
            $('#ytf').html(data.ytf);
            $('#ytf1').html(data.ytf1);
            var ytf = parseInt(data.ytf);
            var ytf1 = parseInt(data.ytf1);
            row.cells[7].innerHTML = ytf+"件/"+ytf1+"册";
            // //一般图书退货够包
            $('#ytg').html(data.ytg);
            $('#ytg1').html(data.ytg1);
            var ytg = parseInt(data.ytg);
            var ytg1 = parseInt(data.ytg1);
            row.cells[8].innerHTML = ytg+"件/"+ytg1+"册";
            //一般图书退货发货未完成
            $('#ytw').html(data.ytw);
            $('#ytw1').html(data.ytw1);
            var ytw = parseInt(data.ytw);
            var ytw1 = parseInt(data.ytw1);
            // row.cells[9].innerHTML = ytw+"件/"+ytw1+"册";
            row.cells[9].innerHTML = ytw1;


            //农家书屋主配发货
            row = tab.rows[2];
            $('#nzf').html(data.nzf);
            $('#nzf1').html(data.nzf1);
            var nzf = parseInt(data.nzf);
            var nzf1 = parseInt(data.nzf1);
            row.cells[1].innerHTML = nzf+"件/"+nzf1+"册";
            //农家书屋主配够包
            $('#nzg').html(data.nzg);
            $('#nzg1').html(data.nzg1);
            var nzg = parseInt(data.nzg);
            var nzg1 = parseInt(data.nzg1);
            row.cells[2].innerHTML =nzg+"件/"+ nzg1+"册";
            //农家书屋主配发货未完成
            $('#nzw').html(data.nzw);
            $('#nzw1').html(data.nzw1);
            var nzw = parseInt(data.nzw);
            var nzw1 = parseInt(data.nzw1);
            // row.cells[3].innerHTML = nzw+"件/"+nzw1+"册";
            row.cells[3].innerHTML = nzw1;
            // 手工单
            row.cells[4].innerHTML = "手工单";
            row.cells[5].innerHTML = "主配拒收";
            row.cells[7].innerHTML = "客退拒收";
            //主配拒收
            $('#zj').html(data.zj);
            var zj = parseInt(data.zj);
            row.cells[6].innerHTML = zj;
            //客退拒收
            $('#kj').html(data.kj);
            $('#kj1').html(data.kj1);
            var kj = parseInt(data.kj);
            var kj1 = parseInt(data.kj1);
            row.cells[8].innerHTML = kj+"件/"+kj1+"册";



            row = tab.rows[3];
            //大中专退货发货
            $('#dtf').html(data.dtf);
            $('#dtf1').html(data.dtf1);
            var dtf = parseInt(data.dtf);
            var dtf1 = parseInt(data.dtf1);
            row.cells[7].innerHTML = dtf+"件/"+dtf1+"册";



            //汇总
            //主配发货
            var hzf = yzf + nzf;
            var hzf1 = yzf1 + nzf1;
            row = tab.rows[4];
            row.cells[1].innerHTML = hzf+"件/"+hzf1+"册";
            //主配够包
            var hzg = yzg + nzg;
            var hzg1= yzg1+nzg1;
            row.cells[2].innerHTML = hzg + "件/" + hzg1 + "册";
            //主配发未完成
            var hzw = yzw + nzw;
            var hzw1 = yzw1 + nzw1;
            // row.cells[3].innerHTML = hzw + "件/" + hzw1 + "册";
            row.cells[3].innerHTML = hzw1;
            //发货汇总
            row.cells[4].innerHTML ="发货汇总";
            var fh = hzf + hzg + yqf + yqg;
            var fh1 = hzf1 + hzg1 + yqf1 +yqg1;
            row.cells[5].innerHTML = fh + "件/" + fh1 + "册";
            //退货汇总
            row.cells[6].innerHTML ="退货汇总";
            var th = ytf + ytg;
            var th1 = ytf1 + ytg1;
            row.cells[7].innerHTML = th + "件/" + th1 + "册";
            //包装总产量
            row.cells[8].innerHTML ="包装总产量";
            var zz = fh + th;
            var zz1 = fh1 + th1;
            row.cells[9].innerHTML = zz + "件/" + zz1 + "册";


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








