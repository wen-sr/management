$(function () {
    var id = tools.getUrlParam("id");
    var noticeId = tools.getUrlParam("noticeId");
    if(id != null && noticeId == null){
        tools.request({
            url: "/management/jxlh56/news/queryById",
            data: {id   : id},
            success: function (data, msg) {
                if (data != null) {
                    $("#title").html(data.title);
                    $("#author").html(data.author);
                    $("#newscontent").html(data.newscontent);
                } else {
                    var html = '未查询到数据';
                    $('#list').append(html);
                }
            }
        });
    }else {
        tools.request({
            url: "/management/jxlh56/notice/queryById",
            data: {id   : noticeId},
            success: function (data, msg) {
                if (data != null) {
                    $("#title").html(data.title);
                    $("#author").html(data.author);
                    $("#newscontent").html(data.newscontent);
                } else {
                    var html = '未查询到数据';
                    $('#list').append(html);
                }
            }
        });
    }

});
