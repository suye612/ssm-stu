<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</head>
<script type="text/javascript">
$(function() {
    $(".wrapper").numInput({
        width: 200, //宽度
        positive: true, //允许输入正数
        negative: true, //允许输入负数
        //faq：positive，negative不能同时false，同时false按同时为true处理
        floatCount: 4, //小数点后保留位数
        //命名空间，防止样式冲突
        wrapperClass: 'num-input-wrap', //最外层容器
        inputClass: 'num-input', //input输入框
        addClass: 'add', //增加按钮
        subtractClass: 'subtract', //减少按钮
    });
})
</script>
<body>
	<form action="/login" method="post">
		<input type="text" id="name" name="name" placeholder="请输入姓名">
		<input type="password" id="password" name="password" placeholder="请输入密码">
		<input type="text" id="age" name="age" placeholder="请输入年龄" class="wrapper">
		<input type="submit" id="submit" value="登录">
	</form>
</body>
</html>