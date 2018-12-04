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
<div class="div">
<h2 class="title">注册</h2>
	<form action="reg" method="post" >
		<p >
		<input type="text" id="name" name="name" placeholder="请输入姓名" class="aa">
		</p>
		<p>
		<input type="text" id="tel" name="tel" placeholder="请输入手机号" class="aa">
		</p>
		<p>
		<input type="text" id="idcard" name="idcard" placeholder="请输入身份证号" class="aa">
		</p>
		<p>	<input type="radio" id="man" name="sex" checked="checked"/>男
			<input type="radio" id="female" name="sex"/>女
		</p>
		<p >
		<input type="button" id="reg1" value="立即注册" class="reg"/>&emsp;
		</p>
	</form>
</div>

</body>
</html>