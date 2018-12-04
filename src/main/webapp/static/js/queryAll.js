$(function(){

	queryAll(1,5);
})

function queryAll(page,count){
$.ajax({
		url :"/queryAll",
		type : "get",
		data :
		{
			"page" : page,
			"pageSize" : count
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