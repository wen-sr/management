$(function () {
    var id = tools.getUrlParam("id");
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
    })
})
