$(function(){
	queryAll(1,5);
})
function getSeleteData() {
	var student = {};
    student.studentNo = $("#studentNo").val();
    student.name = $("#name").val();
    student.sex = $("#sex option:selected").val();
    student.age = Number($("#age").val());
    student.profession = $("#profession").val();
    return student;
}
function queryAll(page,count){
    var data = getSeleteData();
    var formData = JSON.stringify(data)
	$.ajax({
		url :"/queryAll",
		type : "get",
		data :
		{
			page : page,
			pageSize : count,
            student : formData
        },
		dataType : "json",
		success : function(data){
			var list = data.list;
			$("#page").val(data.page);//将当前页面存在隐藏域中
			$("#t1 tr").remove();
			for (var i = 0; i < list.length; i++) {
				var tr = $("<tr>" +
						"<td><input type='checkbox' name='checkbox'/></td>" +
						"<td>"+list[i].studentNo +"</td>" +
						"<td>"+list[i].name +"</td>" +
						"<td>"+list[i].sex +"</td>" +
						"<td>"+list[i].age +"</td>" +
						"<td>"+list[i].profession +"</td>" +
						"<td><input type='button' onclick='delStuden(this)' value='删除'>" +
						"<input type='button' onclick='editStuden(this)' value='编辑'>" +
						"<input type='button' onclick='detailStuden(this)' value='详情'>" +
						"</td>" +
						"</tr>")
				$("#t1").append(tr);
			}
		}
	})
}
function save() {
    var data = getSeleteData();
    var formData = JSON.stringify(data);
    $.ajax({
		url : '/insertStudent',
		type : 'POST',
		data : formData,
		success : function (data) {
			Amin.success(data.message)
        },
        error : function (data) {
            Amin.error(data.responseJSON.message );
        }
		
	})
}