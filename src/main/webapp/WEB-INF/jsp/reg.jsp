<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="static/css/index.css">
	<script src="static/js/jquery-3.3.1.js"></script>
<title>注册</title>
	<style>
		.msg {
			color: red;
			font-size: 12px;
		}
		.p {

		}
	</style>
</head>
<body>
<div class="div2">
<h2 class="title">注册</h2>
	<form action="reg" method="post" onsubmit="return checkData()">
		<p class="p">
			<input type="text" id="name" name="username" placeholder="请输入姓名" class="aa">
		</p>
		<span id="name_msg" class="msg"></span>
		<p>
		手机&emsp;号：
		<input type="text" id="tel" name="tel" placeholder="请输入手机号" class="aa">
		</p>
		<span id="tel_msg" class="msg"></span>
		<p>
		身份证号：
		<input type="text" id="idcard" name="idcard" placeholder="请输入身份证号" class="aa">
		</p>
		<p class="sex">	性&emsp;别&emsp;：&emsp;
		<input type="radio" id="man" name="sex" checked="checked" value="0"/>男
			&emsp;&emsp;&emsp;
		<input type="radio" id="female" name="sex" value="1"/>女
		<span id="idcard_msg" class="msg"></span>
		<p>
			<input type="radio" id="man" name="sex" checked="checked" value="1"/><label for="man">男</label>
			<input type="radio" id="female" name="sex" value="2"/><label for="female" >女</label>
		</p>
		<p >
		<input type="submit"  value="立即注册" class="reg1" />&emsp;
		</p>
	</form>
</div>
</body>
<script>
	var flag = false;
	$(function () {
	    //验证姓名是否合法
		$("#name").blur(function () {
			var name = $("#name").val();
			//验证是否为空
            flag = isNameNull(name);
        })
		//验证 手机号是否合法
        $("#tel").blur(function () {
            var tel = $("#tel").val();
            //验证是否为空
            flag = isTelNull(tel);
        })
		//验证身份证号是否合法
        $("#idcard").blur(function () {
            var idcard = $("#idcard").val();
            //验证是否为空
            flag = isIdCardNull(idcard);
        })
    })
	function isNameNull(name) {
        $("#name_msg").text('')
        if (name == null || name == '') {
            $("#name_msg").text('姓名不能为空!')
            return false;
        } else {
            //验证是否已存在
            $.ajax({
                url : '/admin/checkName',
                data : {
                    name : name
                },
                type : "GET",
                success : function (data) {
                    alert(data)
                    if (data != null && data.length > 0) {
                        $("#name_msg").text('用户名已存在!')
                        return false;
                    } else {
                        $("#name_msg").css('color','green')
                        $("#name_msg").text('√')
                        return true;
                    }
                }
            })

        }
    }
	function isTelNull(tel) {
        $("#tel_msg").text('')
        if (tel == null || tel == '') {
            $("#tel_msg").text('手机号不能为空!')
            return false;
        } else {
            var reg = /^1[34578]\d{9}$/;
            if (!reg.test(tel)) {
                $("#tel_msg").text('手机号格式不正确!')
                return false;
            } else {
				//验证是否已存在
                $.ajax({
                    url : '/admin/checkTel',
                    data : {
                        tel : tel
                    },
                    type : "GET",
                    success : function (data) {
                        if (data != null && data.length > 0) {
                            $("#tel_msg").text('手机号已经被注册!')
                            return false;
                        } else {
                            $("#tel_msg").css('color','green')
                            $("#tel_msg").text('√')
                            return true;
                        }
                    }
                })
                return true
            }
        }

    }
	function isIdCardNull(idcard) {
        $("#idcard_msg").text("")
        if (idcard == null || idcard == '') {
            $("#idcard_msg").text("身份证号不能为空!")
            return false;
        } else {
            var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
            if (!reg.test(idcard)) {
                $("#idcard_msg").text("身份证号格式不正确!")
                return false;
            } else {
                //验证是否已存在
                $.ajax({
                    url : '/admin/checkIdcard',
                    data : {
                        idcard : idcard
                    },
                    type : "GET",
                    success : function (data) {
                        if (data != null && data.length > 0) {
                            $("#idcard_msg").text("身份证号已经被注册!")
                            return false;
                        } else {
                            $("#idcard_msg").css('color','green')
                            $("#idcard_msg").text('√')
                            return true;
                        }
                    }
                })
                return true
            }
        }
    }
    function checkData() {
		return flag;
    }
</script>
</html>