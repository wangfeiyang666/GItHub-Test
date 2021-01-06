jQuery.noConflict();
jQuery(document)
    .ready(
        function ($) {
            var pageIndex = 1;

            function initlist() {
                $.post("getPage", {"pageIndex": pageIndex}, successList, "JSON")
            }

            function successList(data) {
                $(data.list).each(function () {
                    $mytboy = $("#userTable");
                    $mytboy.append(" <tr>\n" +
                        "            <td>" + this.m_id + "</td>\n" +
                        "            <td>" + this.m_title + "</td>\n" +
                        "            <td>" + this.m_score + "</td>\n" +
                        "            <td>" + this.m_content + "</td>\n" +
                        "            <td>" + this.m_release + "</td>\n" +
                        "            <td><a href='javascript:void(0)' class='del'  value='" + this.m_id + "'>删除</a>\n" +
                        "                <a href='update.html?id=" + this.m_id + "'>修改</a>\n" +
                        "            </td>\n" +
                        "        </tr>")
                })
                var $td = $("<td align='center' colspan=\"8\">当前页[" + data.pageindex + "/" + data.pagecount + "]</td>");
                $("#userTable").append("<tr align='center'> <td id='table_td' colspan='8'></td></tr>")
                if (data.pageindex > 1) {
                    $("#table_td").append(" <a class='pageclick'  href='javascript:void(0)' value='1'>首页</a>" +
                        " <a class='pageclick' href='javascript:void(0)'  value='" + (data.pageindex - 1) + "'>上一页</a>")
                }
                if (data.pageindex < data.pagecount) {
                    $("#table_td").append("  <a class='pageclick' href='javascript:void(0)' value='" + (data.pageindex + 1) + "'>下一页</a>\n" +
                        "<a class='pageclick' href='javascript:void(0)' value='" + data.pagecount + "'>尾页</a>")
                }
                $mytboy.append($td);
                $(".pageclick").click(function () {
                    pageIndex = $(this).attr("value");
                    $("#userTable").html("");
                    initlist();
                });
                $(".del").click(
                    function () {
                        var id = $(this).attr("value");
                        $.get("/lucas/del/" + id, succesDel,
                            "text");
                    });
            }

            function succesDel(data) {
                if (data) {
                    alert("删除项目成功");
                } else {
                    alert("删除项目失败")
                }
                $("#userTable").html("");
                initlist();
            }

            initlist();
        })