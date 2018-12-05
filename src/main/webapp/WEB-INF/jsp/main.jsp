<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
	<script type="application/javascript" src="static/js/jquery-3.3.1.js"></script>
	<script type="application/javascript"  src="static/js/queryAll.js"></script>
</head>
<body>
    <input type="hidden" id="id" name="id" value=""/>
    <label>序号:&ensp;</label>
    <input type="text" id="studentNo" name="studentNo" value=""/>
    <label>姓名:&ensp;</label>
    <input type="text" id="name" name="name" value=""/>
    <label for="sex">性别:&ensp;</label>
    <select id="sex" style="width: 160px">
        <option value="1">男</option>
        <option value="2">女</option>
    </select>
    <label>年龄:&ensp;</label>
    <input type="text" id="age" name="age" value=""/>
    <label>专业:&ensp;</label>
    <input type="text" id="profession" name="profession" value=""/>&ensp;
    <input type="button" onclick="queryAll()" value="查询" id="query"/>&ensp;
    <input type="button" onclick="save()" value="增加" id="add"/>
<table border=1>
    <thead>
    <tr>
        <td><input type ="checkbox" id="ids" onclick="checkAll()"/>全选</td>
        <td>学号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>专业</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody id="t1"></tbody>

</table>
<input type="button" value="上一页" id="backPage"/>
<input type="button" value="下一页" id="nextPage"/>
<!-- 隐藏域存放当前页数 -->
<input type="hidden" id="page" value="1"/>
</body>

</html>
