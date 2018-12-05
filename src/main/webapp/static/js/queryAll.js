$(function(){
    initData()
	queryAll(1,5);
})

/**
 * 初始化文本框数据
 */
function initData() {
    //清空文本框
            $("#id").val("");
            $("#studentNo").val("");
            $("#name").val("");
            $("#sex option:selected").val("0")
            $("#age").val("");
            $("#profession").val("");
}
/**
 * 刷新表格
 */
function refresh() {
    var page = $("#page").val();
    var count  = 5;
    queryAll(page,count);
}

/**
 * 收集文本框数据
 */
function getSeleteData() {
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
 * @param count
 */
function queryAll(page,count){
	var page = $("#page").val();
    count  = 5;
    var data = getSeleteData();
    //JSON.parse()【从一个字符串中解析出json对象】
    //JSON.stringify()【从一个对象中解析出字符串】
    var formData = JSON.stringify(data);
	$.ajax({
		url :"queryAll",
		type : "get",
		data :
		{
			page : page,
			pageSize : count,
            studentModel : formData
        },
		dataType : "json",
        contentType: 'application/json',
		success : function(data){
			var list = data.list;
			$("#page").val(data.page);//将当前页面存在隐藏域中
			$("#t1 tr").remove();
			for (var i = 0; i < list.length; i++) {
				var tr = $("<tr>" +
						"<td><input type='checkbox' name='checkbox' /></td>" +
						"<td>"+list[i].studentNo +"</td>" +
						"<td>"+list[i].name +"</td>" +
						"<td>"+ formaterSex(list[i].sex) +"</td>" +
						"<td>"+list[i].age +"</td>" +
						"<td>"+list[i].profession +"</td>" +
						"<td><input type='button' onclick='delStudent(this)' value='删除' stuId = "+ list[i].id+" >&emsp;" +
						"<input type='button' onclick='getStudent(this)' value='编辑' stuId = " + list[i].id+ ">&emsp;" +
						"<input type='button' onclick='detailStuden(this)' value='详情' stuId = "+ list[i].id+">" +
						"</td>" +
						"</tr>")
				$("#t1").append(tr);
			}
		}
	})
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
	var id = $(obj).attr("stuId");
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
        url : '/updateStudent',
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
    var id = $(obj).attr("stuId");
    layer.confirm('您确定要删除么?', {
        btn: ['确定', '取消'],
        title: "提示"
    }, function(){
        $.ajax({
            url : '/deleteStudent',
            type : 'GET',
            data : {
                id : id
            },
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