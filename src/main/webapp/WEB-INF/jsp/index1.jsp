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
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <script>
        $(function () {
            selectAll()
        })

        function selectAll() {
             $.ajax({
                 url : "/selectAllPyramide",
                 type : "GET",
                 success : function (data) {
                     alert(11)
                 }
             })
        }
    </script>
</head>
<body>
<h3>分销系统分成!</h3>
</body>

</html>
