jQuery.noConflict();//放弃对$的使用权    让渡
jQuery(document).ready(function($) {
    let pageNum=1;
    initTea();
    function initTea() {
        let $myPageShow=$("#myPageShow");
        $myPageShow.html("");
        $.post("/tea/getPage",{"pageNum":pageNum},getPage,"JSON")
        function getPage(data) {
            $(data.list).each(function () {
                $myPageShow.append("<tr align=\"center\">" +
                    "<td>"+this.id+"</td>" +
                    "<td>"+this.t_no+"</td>" +
                    "<td>"+this.t_name+"</td>" +
                    "<td>"+this.position_id+"</td>" +
                    "<td>" +
                    "<a class='delStu' href=javascript:void(0)  value='"+this.id+"'>删除</a>&nbsp;" +
                    "<a href='/update.html?id="+this.id+"'>修改</a>" +
                    "</td></tr>");
            })
            //3.上一页下一页
            let $td=$("<td colspan=\"6\">当前页["+data.pageNum+"/"+data.pages+"]</td>&nbsp;");
            if(data.pageNum>1){
                $td.append("<a class='pageClick' href='javascript:void(0)' value='1'>首页</a>&nbsp;");
                $td.append("<a class='pageClick' href='javascript:void(0)' value='"+(data.pageNum-1)+"'>上一页</a>&nbsp;");
            }
            if(data.pageNum<data.pages){
                $td.append("<a class='pageClick' href='javascript:void(0)' value='"+(data.pageNum+1)+"'>下一页</a>&nbsp;");
                $td.append("<a class='pageClick' href='javascript:void(0)' value='"+data.pages+"'>尾页</a>");
            }
            let $tr=$("<tr align=\"center\"></tr>").append($td);
            $myPageShow.append($tr);

            //上一页下一页点击事件
            $(".pageClick").click(function () {
                pageNum=$(this).attr("value");
                initTea();
            })
        }
    }


})