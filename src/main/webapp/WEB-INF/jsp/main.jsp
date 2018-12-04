<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<input type="text" id="id" name="id" value="学号"/>
<input type="text" id="name" name="id" value="姓名"/>
<input type="text" id="sex" name="id" value="性别"/>
<input type="text" id="age" name="id" value="年龄"/>
<input type="text" id="profession" name="id" value="专业"/>
<input type="button" onclick="query()" value="查询" id="query"/>
<input type="button" onclick="add()" value="增加" id="add"/>
<table border=1>
    <thead>
    <tr>
        <td><input type ="checkbox" id="checkbox" onclick="checkAll()"/>全选</td>
        <td>学号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>专业</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody id="t1"></tbody>
=======
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/queryAll.js"></script>
</head>
<body>
	<input type="text" id="id" name="id" value="学号"/>
	<input type="text" id="name" name="id" value="姓名"/>
	<input type="text" id="sex" name="id" value="性别"/>
	<input type="text" id="age" name="id" value="年龄"/>
	<input type="text" id="profession" name="id" value="专业"/>
	<input type="button" onclick="query()" value="查询" id="query"/>
	<input type="button" onclick="add()" value="增加" id="add"/>
<table border=1>
<thead>
	<tr>
		<td><input type ="checkbox" id="checkbox" onclick="checkAll()"/>全选</td>
		<td>学号</td>
		<td>姓名</td>
		<td>性别</td>
		<td>年龄</td>
		<td>专业</td>
		<td>操作</td>
	</tr>
</thead>
<tbody id="t1"></tbody>
>>>>>>> 7757b75ab7394e6fbb5902a21942eae003e4df9c
</table>
<input type="button" value="上一页" id="backPage"/>
<input type="button" value="下一页" id="nextPage"/>
<!-- 隐藏域存放当前页数 -->
<input type="hidden" id="page" value="1"/>
</body>
<<<<<<< HEAD
</html>
=======
</html>
>>>>>>> 7757b75ab7394e6fbb5902a21942eae003e4df9c
