$(function(){
    initData()
    refresh()
})

/**
 * 初始化文本框数据
 */
function initData() {
    //清空文本框
            $("#id").val("");
            $("#studentNo").val("");
            $("#name").val("");
            $("#sex").val("0")
            $("#age").val("");
            $("#profession").val("");
}
/**
 * 刷新表格
 */
function refresh() {
    var page = $("#page option:selected").val();
    var pageSize = $("#pageSize option:selected").val();
    queryAll(page,pageSize);
}

/**
 * 收集文本框数据
 */
function getSeleteData() {
    //创建json对象
	var studentModel = {};
    studentModel.studentNo = $("#studentNo").val();
    studentModel.name = $("#name").val();
    studentModel.sex = $("#sex option:selected").val();
    studentModel.age = Number($("#age").val());
    studentModel.profession = $("#profession").val();
    return studentModel;
}

/**
 * 查询全部数据
 * @param page
 * @param pageSize
 */
function queryAll(page,pageSize){
    var data = getSeleteData();
    page = page == null ? $("#page option:selected").val() : page;
    pageSize = pageSize == null ? $("#pageSize option:selected").val() : pageSize;
    data.page = Number(page);
    data.pageSize = Number(pageSize);
    //JSON.parse()【从一个字符串中解析出json对象】
    //JSON.stringify()【从一个对象中解析出字符串】
    var formData = JSON.stringify(data);
	$.ajax({
		url :"queryAll",
		data :formData,
        dataType:"json",
		type : "POST",
        contentType: 'application/json',
		success : function(data){
			var list = data.list;
			$("#t1 tr").remove();
            for (var i = 0; i < list.length; i++) {
                var tr = $("<tr>" +
                    "<td><input type='checkbox' name='ids' value='"+ list[i].id +"'/></td>" +
                    "<td>"+list[i].studentNo +"</td>" +
                    "<td>"+list[i].name +"</td>" +
                    "<td>"+formaterSex(list[i].sex) +"</td>" +
                    "<td>"+list[i].age +"</td>" +
                    "<td>"+list[i].profession +"</td>" +
                    "<td><input type='button' onclick='delStudent(this)' value='删除'>&emsp;" +
                    "<input type='button' onclick='getStudent(this)' value='编辑' >&emsp;" +
                    "<input type='button' onclick='detailStudent(this)' value='详情' >" +
                    "</td>" +
                    "</tr>")
                $("#t1").append(tr);
            }
            var maxPage = data.maxPage;
            $("#maxPage").text(maxPage);
            var _page = data.page;
            $("#page").empty();
            for(var i=1;i<= maxPage;i++){
                if (_page == i) {
                    $("#page").append("<option value=' " +i+ " ' selected >" + i + "</option>");
                } else {
                    $("#page").append("<option value=' " +i+ " '>"+ i +"</option>");
                }
            }
            $("#pageSize").unbind().change(function () {
                $("#page option").each(function (i,e) {
                    $(this).attr('selected',false)
                    if ($(e).val() == "1") {
                        $(this).attr('selected','selected');
                    }
                })
                refresh();
            });
            $("#page").unbind().change(function () {
                refresh();
            });
            checkboxChecked();
            //为上一页绑定事件
            if (data.isFirstPage == false) {
                $("#backPage").unbind().click(function () {
                    var pageSize = $("#pageSize option:selected").val();
                    queryAll(data.backPage, pageSize)
                    $("#backPage").unbind();
                });
            } else{
                $("#backPage").unbind();
            }
            //为下一页绑定事件
            if (data.isLastPage == false) {
                $("#nextPage").unbind().click(function () {
                    var pageSize = $("#pageSize option:selected").val();
                    queryAll(data.nextPage, pageSize)
                    $("#nextPage").unbind();
                });
            } else {
                $("#nextPage").unbind();
            }
		}
	})
}
function checkboxChecked() {
    //绑定选中事件

    $("tbody tr").mouseover(function(){
        $(this).css("background-color","aqua");
    });
    $("tbody tr").mouseout(function(){
        $(this).css("background-color","white");
    });
    $("tbody tr").click(function(){
        var box = $(this).find("input")[0];
        if(box.checked){
            box.checked=false;
        }else{
            box.checked=true;
        }
        selectOne();
    });

}
/**
 * 性别格式化函数
 */
function formaterSex(val) {
    if (val == 1) {
        return "男";
    } else if (val == 2) {
        return "女";
    } else {
    	return "未选择";
    }
}
/**
 * 判断是新增还是修改
 */
function saveOrUpdate() {
    var id = $("#id").val();
    if (id == null || id == '') {
        save();
    } else {
    	update(id);
    }
}
/**
 * 新增学生
 */
function save() {
    var data = getSeleteData();
    //var formData = JSON.stringify(data);
    var formData = JSON.stringify(data);
    $.ajax({
		url : 'insertStudent',
		type : 'POST',
        contentType: 'application/json',
		data : formData ,
		success : function (data) {
			Amin.success("新增成功!");
			initData();
            refresh();
        },
        error : function (data) {
            Amin.error("添加失败!");
        }
	})
}
/**
 *获取学生信息 并回填
 */
function getStudent(obj) {
    var id = $(obj).parent().parent().children().eq(0).children().val();
	$.ajax({
		url : 'getStudent',
		type : 'GET',
		data : {
			id : id
		},
		success : function (data) {
            //赋值
            $("#id").val(data.id);
            $("#studentNo").val(data.studentNo);
            $("#name").val(data.name);
            $("#sex option").each(function (i,e) {
                $(this).attr('selected',false)
                if ($(e).val() == data.sex) {
                    $(this).attr('selected','selected')
                }
            })
            $("#age").val(data.age);
            $("#profession").val(data.profession);
            $("#add").val("修改")

        },
		error : function (data) {
			Amin.error("数据异常!")
        }
	})
}

/***
 * 新增学生
 * @param id
 */
function update(id) {
    var data = getSeleteData();
    data.id = id;
    var formData = JSON.stringify(data);
    $.ajax({
        url : 'updateStudent',
        type : 'POST',
        data : formData ,
        contentType: 'application/json',
        success : function (data) {
            Amin.success("修改成功!");
            $("#add").val("添加")
            initData();
            refresh();
        },
        error : function (data) {
            Amin.error("修改失败!");
        }
    })
}

/**
 * 删除学生
 */
function delStudent(obj) {
    var id = $(obj).parent().parent().children().eq(0).children().val();
    var ids = [id];
    deleteStudents(ids);
}
function selectAll(){
    var id_box = $(":checkbox[name='ids']");
    var all_box = $("#all")[0];
    $.each(id_box, function(index, box){
        box.checked = all_box.checked;
    });
}
function selectOne(){
    var id_box = $(":checkbox[name='ids']");
    var id_box_checked = $(":checkbox[name='ids']:checked");
    var all_box = $("#all")[0];
    all_box.checked = id_box.length==id_box_checked.length;

}

function deleteAll(){
    var id_box = $(":checkbox[name='ids']:checked");
    if(id_box.length==0){
        Amin.alert("请选中一条要删除的数据");
        return false;
    }else{
        var ids = [];
        $(id_box).each(function (i) {
            ids[i] = $(this).val();
        })
        deleteStudents(ids);
    }
}
function deleteStudents(ids) {
    layer.confirm('您确定要删除么?', {
        btn: ['确定', '取消'],
        title: "提示"
    }, function(){
        $.ajax({
            url : 'deleteStudent',
            type : 'GET',
            data : {
                ids : ids
            },
            traditional: true,
            success : function (data) {
                Amin.success("删除成功!");
                initData();
                refresh();
            },
            error : function (data) {
                Amin.error("删除失败!");
            }
        })
    })
}
//詳情
function detailStudent(obj){
	//获取学生的id
    var id = $(obj).parent().parent().children().eq(0).children().val();
    $.ajax({
        url : 'selectScoreByStudentId',
        type : 'GET',
        data : {
            id : id
        },
        success : function (data) {
            $("#stuNo").text(data.studentNo);
            $("#stuName").text(data.name);
            $("#stuSex").text(formaterSex(data.sex));
            $("#stuAge").text(data.age);
            $("#stuProfession").text(data.profession);
            $("#score tr").remove();
            var tr = $("<tr>" +
                "<td class='total'>" + data.chinese + "</td>" +
                "<td class='total'>" + data.math + "</td>" +
                "<td class='total'>" + data.english + "</td>" +
                "<td class='total'>" + data.art + "</td>" +
                "<td class='total'>" + data.music + "</td>" +
                "<td class='total'>" + data.history + "</td>" +
                "<td id='total'></td>" +
                "</tr>")
            $("#score").append(tr);
            $("#total").text(totalScore());
            $("#editl").css("display", "block");
            $("#detail").css("display", "block");
        }
    })
}
function totalScore() {
    var total ;
    $(".total").each(function (i,e) {
        total += parseFloat($(e).text());
    })
    return total;
}