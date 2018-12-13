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
    <style>
        .span_val{
            margin-left: 20px;
        }
    </style>
</head>
<body style="text-align: center;background-repeat: no repeat;background-size: cover">
    <div class="main">
   		 <input type="hidden" id="id" name="id" value="" class="show" />
    <div class="contend">
	    <label>学号:</label>
	    <input type="text" id="studentNo" name="studentNo" value="" class="show" readonly/>
	    <label>姓名:</label>
	    <input type="text" id="name" name="name" value="" class="show"  required />
	    <label for="sex">性别:</label>
	    <select id="sex"  class="showSelect ">
	        <option value="0">--请选择--</option>
	        <option value="1">男</option>
	        <option value="2">女</option>
	    </select>
	    <label>年龄:</label>
	    <input type="number" id="age" name="age" min="0" value="" class="show" max="120"
	     style="ime-mode:Disabled"  
         onKeypress="return (/[\\d]/.test(String.fromCharCode(event.keyCode)))"  required/>
	    <label>专业:</label>
	    <input type="text" id="profession" name="profession" value="" class="show"  required />&ensp;
	    <input type="button" onclick="queryAll()" value="查询" id="query"/>&ensp;
	    <input type="button" onclick="saveOrUpdate()" value="增加" id="add"/>&ensp;
	    <input type="button" onclick="deleteAll()" value="批量删除" id="deleteAll"/>
    </div>
	<table border=1 cellspacing="0" class="table" style="border-radius: 5px;">
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
			             第<select id="page"><option value="1">1</option></select>页 &emsp;
			             共<span id="maxPage"></span>页
         	</p>
    </div>
</div>
    <!-- 隐藏域存放当前页数 -->
    <%--position: absolute;left:400px;top:400px;

    position:absolute;left:420px;top:450px;--%>

	<div id="detail" style="text-align:left;padding-left:50px ;width:420px;height:400px;background:white;display:none;
	margin: 150px auto 0 ">
			<h2 style="background: black;text-align: center;color: white;width: 470px;margin-left: -50px;margin-top: -20px">詳情頁面</h2>
			<p >
		        <label>学&emsp;号:</label>
		        <span id="stuNo" class="span_val"></span>
		    </p>
			<p >
		        <label>姓&emsp;名:</label>
		        <span id="stuName" class="span_val"></span>
		    </p>
			<p >
		        <label>性&emsp;别:</label>
		        <span id="stuSex" class="span_val"></span>
		    </p>
			<p >
		        <label>年&emsp;龄:</label>
		        <span id="stuAge" class="span_val"></span>
		    </p>
			<p >
		        <label>专&emsp;业:</label>
		        <span id="stuProfession" class="span_val"></span>
		    </p>
			<h4 style="text-align: left;">成績</h4>
			
		<table border=1 cellspacing="0" style="width: 400px;text-align: center">
		<thead>
			<th>语文</th>
			<th>数学</th>
			<th>英语</th>
			<th>艺术</th>
			<th>音乐</th>
			<th>历史</th>
			<th>总计</th>
		</thead>
		<tbody id="score">
		</tbody>
		</table>
		<p style="position:relative;left:0px;top:10px; z-index: 99">
	        <input type="button" value="取  消" style="color: white;width: 80px;height: 30px;background-color: rgba(67,136,176,0.74);
	        outline: none;border-width:0px;border-radius:7px;font-size: 18px" onclick="cancel() "/>
	    </p>
	</div>
    <!--opacity: 1,遮罩层,透明度  -->
    <div id="editl" style="width:500px;height:500px;background:aqua;
	 display:none; opacity: 0.3; margin: -440px auto 0 ">
    </div>
</body>

</html>
