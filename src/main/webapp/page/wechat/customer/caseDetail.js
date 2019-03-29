$(function () {
    var caseid = tools.getUrlParam("caseid");
    $('#list').html('');
    tools.request({
        url     : "/management/logisticsQuery/deliveryQuery",
        data    : {shipno: caseid},
        success : function (res) {
            var check_zy_results_data = $('#check_zy_results_data');
            check_zy_results_data.html('');
            if (res != null && res.length > 0) {
                var check_zy_results_data_str = "";
                var check_zy_results_data_strs = '<table border="0" cellpadding="0" cellspacing="0" style="width: 100%;">'+
                    '<tbody>';
                var rows = res;
                for (var i = 0; i < rows.length; i++) {

                    var data = rows[i];
                    check_zy_results_data_str = "";

                    if (data != null) {

                        check_zy_results_data_strs = check_zy_results_data_strs + '<tr><th colspan="2" class="today_th">';


                        var shipkey = data.shipno; //运号
                        var caseid = data.caseid; //包件号


                        var shortname = data.shortname;	//客户简称

                        var adddate = data.addDate; //新增时间

                        var loaddate = data.loadDate; //装车时间

                        var shipdate = data.shipDate; //发运时间

                        var status = data.status;

                        var ownerName = data.ownerName;

                        // state// 0:新增；1：装车；2：运输；
                        var img_sta_1 = '<img src="../../../image/wechat/sta_1_gray.png">';
                        var em_1 = '作业中';
                        var img_sta_2 = '<img src="../../../image/wechat/sta_2_gray.png">';
                        var em_2 = '已装车';
                        var img_sta_3 = '<img src="../../../image/wechat/sta_3_gray.png">';
                        var em_3 = '运输中';
                        var img_sta_4 = '<img src="../../../image/wechat/sta_4_gray.png">';
                        var em_4 = '已签收';
                        var img_sta_5 = '<img src="../../../image/wechat/sta_5_gray.jpg">';
                        var em_5 = '已回单';

                        var detile_th = ''; //当所输入查询信息为专线快运

                        if (status != null) {
                            if (status === '运输中') { // 运输中
                                img_sta_3 = '<img src="../../../image/wechat/sta_3_orange.png">';
                                em_1 = '作业中';
                                em_2 = '已装车';
                                em_3 = '运输中';
                                detile_th = '<tr class="over ">' +
                                    '<td width="10%" class="img0 over"><p><img src="../../../image/wechat/right_icon.png" alt="" /></p></td>' +
                                    '<th width="60%"><em class="detail_item green">' +
                                    '【' + shortname + '】</span>的包件<span class="red">【' + caseid + '】</span>' + em_3 + ' <br>' +
                                    ' <em class="tx_1">' + shipdate + '</em></em>' +
                                    '</th>' +
                                    '</tr>' +
                                    '<tr class="over ">' +
                                    '<td width="10%" class="img0 over"><p><img src="../../../image/wechat/right_icon.png"></p></td>' +
                                    '<th width="60%"><em class="detail_item green">' +
                                    '【' + shortname + '】</span>的包件<span class="red">【' + caseid + '】</span>' + em_2 + ' <br> ' +
                                    '<em class="tx_1">' + loaddate + '</em>' +
                                    '</th>' +
                                    '</tr>'+
                                    '<tr class="over ">' +
                                    '<td width="10%" class="img0 over"><p><img src="../../../image/wechat/right_icon.png"></p></td>' +
                                    '<th width="60%"><em class="detail_item green">' +
                                    '【' + shortname + '】</span>的<span class="red">包件【' + caseid + '】</span>' + em_1 + '<br>' +
                                    '<em class="tx_1">' + adddate + '</em></em>' +
                                    '</th>' +
                                    '</tr>';
                            }else if (status === '已签收') { // 已签收
                                img_sta_4 = '<img src="../../../image/wechat/sta_4_orange.png">';
                                em_1 = '作业中';
                                em_2 = '已装车';
                                em_3 = '运输中';
                                em_4 = '已签收';
                                detile_th =
                                    '<tr class="over ">' +
                                    '<td width="10%" class="img0 over"><p><img src="../../../image/wechat/right_icon.png" alt="" /></p></td>' +
                                    '<th width="60%"><em class="detail_item green">' +
                                    '【' + shortname + '】</span>的包件<span class="red">【' + caseid + '】</span>' + em_4 + ' <br>' +
                                    ' <em class="tx_1">' + shipdate + '</em></em>' +
                                    '</th>' +
                                    '</tr>' +
                                    '<tr class="over ">' +
                                    '<td width="10%" class="img0 over"><p><img src="../../../image/wechat/right_icon.png" alt="" /></p></td>' +
                                    '<th width="60%"><em class="detail_item green">' +
                                    '【' + shortname + '】</span>的包件<span class="red">【' + caseid + '】</span>' + em_3 + ' <br>' +
                                    ' <em class="tx_1">' + shipdate + '</em></em>' +
                                    '</th>' +
                                    '</tr>' +
                                    '<tr class="over ">' +
                                    '<td width="10%" class="img0 over"><p><img src="../../../image/wechat/right_icon.png"></p></td>' +
                                    '<th width="60%"><em class="detail_item green">' +
                                    '【' + shortname + '】</span>的包件<span class="red">【' + caseid + '】</span>' + em_2 + ' <br> ' +
                                    '<em class="tx_1">' + loaddate + '</em>' +
                                    '</th>' +
                                    '</tr>'+
                                    '<tr class="over ">' +
                                    '<td width="10%" class="img0 over"><p><img src="../../../image/wechat/right_icon.png"></p></td>' +
                                    '<th width="60%"><em class="detail_item green">' +
                                    '【' + shortname + '】</span>的包件<span class="red">【' + caseid + '】</span>' + em_1 + '<br>' +
                                    '<em class="tx_1">' + adddate + '</em></em>' +
                                    '</th>' +
                                    '</tr>';
                            }else if (status === '已回单') { // 已回单
                                img_sta_5 = '<img src="../../../image/wechat/sta_5_orange.png">';
                                em_1 = '作业中';
                                em_2 = '已装车';
                                em_3 = '运输中';
                                em_4 = '已签收';
                                em_5 = '已回单';
                                detile_th =
                                    '<tr class="over ">' +
                                    '<td width="10%" class="img0 over"><p><img src="../../../image/wechat/right_icon.png" alt="" /></p></td>' +
                                    '<th width="60%"><em class="detail_item green">' +
                                    '【' + shortname + '】</span>的包件<span class="red">【' + caseid + '】</span>' + em_5 + ' <br>' +
                                    ' <em class="tx_1">' + shipdate + '</em></em>' +
                                    '</th>' +
                                    '</tr>' +
                                    '<tr class="over ">' +
                                    '<td width="10%" class="img0 over"><p><img src="../../../image/wechat/right_icon.png" alt="" /></p></td>' +
                                    '<th width="60%"><em class="detail_item green">' +
                                    '【' + shortname + '】</span>的包件<span class="red">【' + caseid + '】</span>' + em_4 + ' <br>' +
                                    ' <em class="tx_1">' + shipdate + '</em></em>' +
                                    '</th>' +
                                    '</tr>' +
                                    '<tr class="over ">' +
                                    '<td width="10%" class="img0 over"><p><img src="../../../image/wechat/right_icon.png" alt="" /></p></td>' +
                                    '<th width="60%"><em class="detail_item green">' +
                                    '【' + shortname + '】</span>的包件<span class="red">【' + caseid + '】</span>' + em_3 + ' <br>' +
                                    ' <em class="tx_1">' + shipdate + '</em></em>' +
                                    '</th>' +
                                    '</tr>' +
                                    '<tr class="over ">' +
                                    '<td width="10%" class="img0 over"><p><img src="../../../image/wechat/right_icon.png"></p></td>' +
                                    '<th width="60%"><em class="detail_item green">' +
                                    '【' + shortname + '】</span>的包件<span class="red">【' + caseid + '】</span>' + em_2 + ' <br> ' +
                                    '<em class="tx_1">' + loaddate + '</em>' +
                                    '</th>'+
                                    '</tr>' +
                                    '<tr class="over ">' +
                                    '<td width="10%" class="img0 over"><p><img src="../../../image/wechat/right_icon.png"></p></td>' +
                                    '<th width="60%"><em class="detail_item green">' +
                                    '【' + shortname + '】</span>的包件<span class="red">【' + caseid + '】</span>' + em_1 + '<br>' +
                                    '<em class="tx_1">' + adddate + '</em></em>' +
                                    '</th>' +
                                    '</tr>';
                            } else if (status === '已装车') { // 装车中
                                img_sta_2 = '<img src="../../../image/wechat/sta_2_orange.png">';
                                em_1 = '作业中';
                                em_2 = '已装车';
                                detile_th = '<tr class="over ">' +
                                    '<td width="10%" class="img0 over"><p><img src="../../../image/wechat/right_icon.png"></p></td>' +
                                    '<th width="60%"><em class="detail_item green">' +
                                    '【' + shortname + '】</span>的包件<span class="red">【' + caseid + '】</span>' + em_2 + ' <br>' +
                                    ' <em class="tx_1">' + loaddate + '</em></em>' +
                                    '</th>' +
                                    '</tr>'+
                                    '<tr class="over ">' +
                                    '<td width="10%" class="img0 over"><p><img src="../../../image/wechat/right_icon.png"></p></td>' +
                                    '<th width="60%"><em class="detail_item green">' +
                                    '【' + shortname + '】</span>的包件<span class="red">【' + caseid + '】</span>' + em_1 + ' <br>' +
                                    '<em class="tx_1">' + adddate + '</em></em>' +
                                    '</th>' +
                                    '</tr>';
                            } else if (status === '作业中') { //新增中
                                img_sta_1 = '<img src="../../../image/wechat/sta_1_orange.png">';
                                em_1 = '作业中';
                                detile_th = '<tr class="over ">' +
                                    '<td width="10%" class="img0 over"><p><img src="../../../image/wechat/right_icon.png"></p></td>' +
                                    '<th width="60%"><em class="detail_item green">' +
                                    '【' + shortname + '】</span>的包件<span class="red">【' + caseid + '】</span>' + em_1 + ' <br>' +
                                    ' <em class="tx_1">' + adddate + '</em></em>' +
                                    '</th>' +
                                    '</tr>';
                            }
                        }

                        var date = new Date();
                        var y = date.getFullYear();
                        var m = date.getMonth() + 1;
                        var d = date.getDate();
                        var taday = y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);

                        var in_state =
                            '<div class="in_state" align="center" >' +
                            '<div class="sta_item">' +
                            '<i class="ck"></i> <span class="state-icon">' + img_sta_1 + ' </span> <em class="state-line"></em>' +
                            '<em class="state-text">' + em_1 + '</em>' +
                            '</div>' +
                            '<div class="sta_item ">' +
                            '<i class="ck"></i> <span class="icon">' + img_sta_2 + ' </span> <em class="state-line"></em>' +
                            '<em class="state-text">' + em_2 + '</em>' +
                            '</div>' +
                            '<div class="sta_item">' +
                            '<i class="ck"></i> <span class="icon">' + img_sta_3 + ' </span> ' +
                            	'<em class="state-line"></em>'+
                            '<em class="state-text">' + em_3 + '</em>' +
                            '</div>' +
                             '<div class="sta_item">'+
                               '<i class="ck"></i> <span class="icon">'+ img_sta_4 +' </span> ' +
                            '<em class="state-line"></em>'+
                                '<em class="state-text">'+ em_4 +'</em>'+
                             '</div>'+
                             '<div class="sta_item">'+
                               '<i class="ck"></i> <span class="icon">'+ img_sta_5 +' </span> ' +
                            // '<em class="state-line"></em>'+
                            '<em class="state-text">'+ em_5 +'</em>'+
                             '</div>'+
                            '</div>';

                        var detile_list = '<div class="detile_list" id="detile_list" >' +
                            '<div class="scroller" style="transition-property: transform; transform-origin: 0px 0px 0px; transform: translate(0px, 0px) translateZ(0px);">' +
                            '<table border="0" cellpadding="0" cellspacing="0" class="u-record">' +
                            '<tbody>' +
                            '<tr>' +
                            '<th colspan="2" class="today_th">' +
                            '<div class="shipkey">运号:' + shipkey + '</div></th>' +
                            '</tr>' +
                            '<tr>' +
                            '<th colspan="2" class="today_th">' +
                            '<div class="today">货主:' + ownerName + '</div></th>' +
                            '</tr>' + detile_th +
                            '</tbody>' +
                            '</table>' +
                            '</div>' +
                            '</div>';


                        check_zy_results_data_str = '<div id="search-results" class="search-results auto" >' + in_state + detile_list + '</div>';

                        //check_zy_results_data_str = check_zy_results_data_str + '<div> -----------------</div>';


                        check_zy_results_data_strs = check_zy_results_data_strs + check_zy_results_data_str;

                        check_zy_results_data_strs = check_zy_results_data_strs + '</th></tr>';

                    }


                    check_zy_results_data_strs = check_zy_results_data_strs + '</tbody></table>';

                }
            } else {
                var html = '未查询到数据';
                $('#list').append(html);
            }
            check_zy_results_data.html(check_zy_results_data_strs);
        }
    })
});

function myformatter(date){
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}