$(function () {
    $('#list').html('');
    tools.request({
        url     : "/management/jxlh56/notice/queryInfo2",
        data    : {},
        success : function (data, msg) {
            if(data != null && data.length > 0){
                var tpl =
                    '{{#list}}' +
                    '<a class="weui-cell weui-cell_access" href="announcementDetail.html?noticeId={{id}}">' +
                    '<div class="weui-cell__bd">' +
                    '<p>{{title}}</p>' +
                    '</div>' +
                    '<div class="weui-cell__ft">' +
                    '</div>' +
                    '</a>' +
                    '{{/list}}';
                var result = tools.renderHtml(tpl, {list: data});
                $('#list').append(result);
            }else {
                var html = '未查询到数据';
                $('#list').append(html);
            }
        }
    })
})
