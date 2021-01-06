jQuery.noConflict();//放弃对$的使用权    让渡
jQuery(document).ready(function ($) {
    function initMovies() {
        $("#mytbody").html("");
        $.post("/pos/page",

            getPage,
            "JSON"
        )

        function getPage(data) {
            $(data).each(function () {
                $("#mytbody").append("<tr align=\"center\">\n" +
                    "            <td>" + this.id + "</td>\n" +
                    "            <td>" + this.t_pos_name + "</td>\n" +
                    "            <td>\n" +
                    "                <a class='del' value='" + this.id + "' href=\"javascript:void(0)\">删除</a>\n" +
                    "                <a class='upd'  href=\"/a/upd.html?id=" + this.id + "\">修改</a>\n" +
                    "            </td>\n" +
                    "        </tr>")
            });
            /*$("#mytbody").append("<tr align=\"center\">\n" +
                "        <td colspan=\"7\">\n" +
                "            <a id='sy' href=\"javascript:void(0)\">首页</a>\n" +
                "            <a id='syy' href=\"javascript:void(0)\">上一页</a>\n" +
                "            <a id='xyy' href=\"javascript:void(0)\">下一页</a>\n" +
                "            <a id='wy' href=\"javascript:void(0)\">尾页</a>\n" +
                "        </td>\n" +
                "    </tr>");
            //首页
            $("#sy").click(function () {
                pageindex = 1
                initMovies();
            })
            //上一页
            $("#syy").click(function () {
                pageindex = data.pageindex - 1
                initMovies();
            })
            //下一页
            $("#xyy").click(function () {
                pageindex = data.pageindex + 1
                initMovies();
            })
            //尾页
            $("#wy").click(function () {
                pageindex = data.pagecount
                initMovies();
            })*/

            $(".del").click(function () {
                var id = $(this).attr("value");
                $.post(
                    "del/" + id, delMovies, "text"
                );

                function delMovies(data) {
                    if (data == "true") {
                        alert("删除成功")
                    } else {
                        alert("删除失败")
                    }
                    initMovies();
                }
            })
        }


    }

    initMovies()
});
