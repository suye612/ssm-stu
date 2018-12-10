<%--
  Created by IntelliJ IDEA.
  User: SEELE
  Date: 2018/12/9
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="static/js/jquery-3.3.1.js"></script>
    <link rel="stylesheet" href="static/layui/css/layui.css"  media="all">
</head>
<body style="text-align: center">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>分销系统分成!</legend>
    </fieldset>
    <div id="main">
    </div>

<%--<p>点击每一级菜单，都会执行一个回调，返回该节点的一些信息</p>--%>
<div id="insert" style="display: none; width: 400px; height: 150px;text-align: center;margin: 0 auto;border: 1px solid aqua">
    <p style="margin-top: 20px">
        <label>上级姓名:</label>&emsp;&emsp;
        <input type="hidden" id="pid" name="pid" value="">
        <input type="text" id="pName" name="pName" value="">
    </p>
    <p style="margin-top: 20px">
        <label>姓&emsp;&emsp;名:</label>&emsp;&emsp;
        <input type="text" id="name" name="name" value="">
    </p>
    <p style="margin-top: 20px">
        <input type="button" id="submit" value="添加" onclick="insert()">&emsp;&emsp;&emsp;&emsp;
        <input type="button" id="delete" value="删除" onclick="del()">&emsp;&emsp;&emsp;&emsp;
        <input type="button" id="reset" value="取消" onclick="cancle()">
    </p>
</div>

<script src="static/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    $(function () {
        selectAll()
    })

    function selectAll() {
        var ul = " <ul id='demo1'></ul>";
        $("#main").append(ul)
        $.ajax({
            url : "selectAllPyramide",
            type : "GET",
            success : function (data) {
                layui.use(['tree', 'layer'], function(){
                    var layer = layui.layer
                        ,$ = layui.jquery;

                    layui.tree({
                        elem: '#demo1' //指定元素
                        ,target: '_blank' //是否新选项卡打开（比如节点返回href才有效）
                        ,click: function(item){ //点击节点回调
                            $("#pid").val(item.id)
                            $("#pName").val(item.name)
                            $("#insert").css('display','block')
                            /*layer.msg('当前节名称：'+ item.name + '<br>全部参数：'+ JSON.stringify(item));
                            console.log(item);*/
                        }
                        ,nodes: data
                    });
                });
            }
        })
    }
  function insert() {
      var pid = $("#pid").val()
      var name = $("#name").val()
      $.ajax({
          url : 'insertPyramid',
          data : {
              pid : pid,
              name : name
          },
          success : function (data) {
              $("#main").empty();
              selectAll();
              $("#insert").css('display','none');
          },
          error : function () {
              alert(00)
          }
      })
  }
  function del() {
      var pid = $("#pid").val()
      $.ajax({
          url : 'deletePyramid',
          data : {
              id : pid
          },
          success : function (data) {
              $("#main").empty();
              selectAll();
              $("#insert").css('display','none');
          },
          error : function () {
              alert(00)
          }
      })
  }
function cancle() {
    $("#insert").css('display','none');
}
</script>

</body>

</html>
