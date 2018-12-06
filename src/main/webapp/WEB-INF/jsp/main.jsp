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
    <input type="text" id="studentNo" name="studentNo" value="" class="show" readonly/>
    <label>姓名:</label>
    <input type="text" id="name" name="name" value="" class="show" />
    <label for="sex">性别:</label>
    <select id="sex"  class="showSelect ">
        <option value="0">--请选择--</option>
        <option value="1">男</option>
        <option value="2">女</option>
    </select>
    <label>年龄:</label>
    <input type="number" id="age" name="age" min="0" value="" class="show" />
    <label>专业:</label>
    <input type="text" id="profession" name="profession" value="" class="show" />&ensp;
    <input type="button" onclick="queryAll()" value="查询" id="query"/>&ensp;
    <input type="button" onclick="saveOrUpdate()" value="增加" id="add"/>&ensp;
    <input type="button" onclick="deleteAll()" value="批量删除" id="deleteAll"/>
    </div>
<table border=1 cellspacing="0" class="table">
    <thead>
    <tr>
        <td style="width: 80px"><input  type ="checkbox" id="all"  onclick="selectAll()"/>全选</td>
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
    <div style="margin-top: 10px; text-align: left">
        <p style="float: left" >
            每页<select id="pageSize">
                    <option value="5">5</option>
                    <option value="10">10</option>
                    <option value="15">15</option>
                 </select>条
         </p>
        <p style="margin-left: 200px; float: left">
            <input type="button" value="上一页" id="backPage"/>&emsp;&emsp;&emsp;
            <input type="button" value="下一页" id="nextPage"/>
        </p>

         <p style=" float: right">
             第<select id="page"><option value="1">1</option></select>页 &emsp;共<span id="maxPage"></span>页
         </p>
    </div>
</div>
<!-- 隐藏域存放当前页数 -->
	<!--opacity: 1,遮罩层,透明度  -->
	<div id="editl" style="width:1400px;height:900px;background:aqua;
	position: absolute;left:0px;top:0px;display:none; opacity: 0.5;">
	</div>
	<div id="detail" style="text-align:center; width:200px;height:170px;background:white;position:absolute;left:300px;top:55px;display:none;">
	<p>
		<label>学号</label>
		<input style="width:80px;background:aqua " id="stuId" readonly="readonly"/>
	</p>
	<p> <label>姓名:</label> <input style="width:80px;" id=stuName></p>
	<p> <label>性别:</label> <input style="width:80px;" id="stuSex"></p>
	<p> <label>年龄:</label> <input style="width:80px;" id="stuAge"></p>
	<p> <label>专业:</label> <input style="width:80px;" id="stuProfession"></p>
	<p> <label>手机号:</label> <input style="width:80px;" id="stuTel"></p>
	<br>
	成绩：
	<table>
	<thead>
		<th>语文</th>
		<th>数学</th>
		<th>英语</th>
		<th>艺术</th>
		<th>音乐</th>
		<th>历史</th>
	</thead>
	<tbody id="score">
	</tbody>
	</table>
	</div>
</body>

</html>
