<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="static/css/index.css">
<title>注册</title>
</head>
<body>
<div class="div2">
<h2 class="title">注册</h2>
	<form action="<%=request.getContextPath()%>/reg" method="post" >
		<p >
		姓&emsp;名&emsp;：
		<input type="text" id="name" name="username" placeholder="请输入姓名" class="aa">
		</p>
		<p>
		手机&emsp;号：
		<input type="text" id="tel" name="tel" placeholder="请输入手机号" class="aa">
		</p>
		<p>
		身份证号：
		<input type="text" id="idcard" name="idcard" placeholder="请输入身份证号" class="aa">
		</p>
		<p class="sex">	性&emsp;别&emsp;：&emsp;
		<input type="radio" id="man" name="sex" checked="checked" value="0"/>男
			&emsp;&emsp;&emsp;
		<input type="radio" id="female" name="sex" value="1"/>女
		</p>
		<p >
		<input type="submit"  value="立即注册" class="reg1" />&emsp;
		</p>
	</form>
</div>
</body>
</html>