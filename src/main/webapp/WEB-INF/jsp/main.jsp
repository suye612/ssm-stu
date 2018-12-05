<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="static/css/index.css">
    <title>Insert title here</title>
	<script type="application/javascript" src="static/js/jquery-3.3.1.js"></script>
	<script type="application/javascript"  src="static/js/layer/layer.js"></script>
	<script type="application/javascript"  src="static/js/amin.js"></script>
	<script type="application/javascript"  src="static/js/queryAll.js"></script>
</head>
<body >
<div class="main">
    <input type="hidden" id="id" name="id" value="" class="show" />
  <div class="contend">
    <label>学号:</label>
    <input type="text" id="studentNo" name="studentNo" value="" class="show"/>
    <label>姓名:</label>
    <input type="text" id="name" name="name" value="" class="show" />
    <label for="sex">性别:</label>
    <select id="sex"  class="showSelect">
        <option value="0">---请选择性别---</option>
        <option value="1">男</option>
        <option value="2">女</option>
    </select>
    <label>年龄:</label>
    <input type="text" id="age" name="age" value="" class="show" />
    <label>专业:</label>
    <input type="text" id="profession" name="profession" value="" class="show" />&ensp;
    <input type="button" onclick="queryAll()" value="查询" id="query"/>&ensp;
    <input type="button" onclick="saveOrUpdate()" value="增加" id="add"/>
    <input type="button" onclick="deleteAll()" value="批量删除" id="deleteAll"/>
    </div>
<table border=1 cellspacing="0" class="table">
    <thead>
    <tr>
        <td style="width: 80px"><input  type ="checkbox" id="ids"  onclick="checkAll()"/>全选</td>
        <td>学号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>专业</td>
        <td style="width: 200px">操作</td>
    </tr>
    </thead>
    <tbody id="t1"></tbody>

</table>
<input type="button" value="上一页" id="backPage"/>
<input type="button" value="下一页" id="nextPage"/>
</div>
<!-- 隐藏域存放当前页数 -->
<input type="hidden" id="page" value="1"/>
</body>

</html>
