$(function(){
	queryAll(1,5);
})

function queryAll(){
$.ajax({
		url :"queryAll",
		type : "post",
		data :
		{
			"page" : page,
			"count" : count,
		},
		dataType : "json",
		success : function(data){
			$("#page").val(data.page);//将当前页面存在隐藏域中
			$("#t1 tr").remove();
			for (var i = 0; i < data.List.length; i++) {
				var tr = $("<tr>" +
						"<td><input type='checkbox' name='checkbox'/></td>" +
						"<td>"+data.List[i].studentNo+"</td>" +
						"<td>"+data.List[i].name+"</td>" +
						"<td>"+data.List[i].sex+"</td>" +
						"<td>"+data.List[i].age+"</td>" +
						"<td>"+data.List[i].profession+"</td>" +
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