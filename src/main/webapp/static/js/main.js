$(function(){
	queryGoods("","",1,5);
	var type=$("#s1").val();
	var key=$("#key").val();
	
	$("#nextPage").click(function(){
		var page = parseInt($("#page").val());
		page++;
		var key01=$("#key").val();
		var type01= $("#s1").val();
		
		if(key01!=key){
			page=1;
		}
		type=type01;
		key=key01;
		
		queryGoods(type,key,page,5);
		
	})
	
	$("#backPage").click(function(){
		var page = parseInt($("#page").val());
		page--;
		var key01=$("#key").val();
		var type01= $("#s1").val();
		if(type01!=type || key01!=key){
			page=1;
		}
		type=type01;
		key=key01;
		queryGoods(type,key,page,5);
		
	})
	$("#bt").click(function(){
		var key01=$("#key").val();
		var type01= $("#s1").val();
		if(type01!=type ||key01!=key){
			page=1;
		}
		type=type01;
		key=key01;
		queryGoods(type,key,page,5);
	})
})
	


function queryGoods(type,key,page,count){
	$.ajax({
		url :"queryGoodsByPage.do",
		type : "post",
		data :
		{
			"page" : page,
			"count" : count,
			"key" : key,
			"type":type
		},
		dataType : "json",
		success : function(data){
			$("#page").val(data.page);//将当前页面存在隐藏域中
			$("#t1 tr").remove();
			for (var i = 0; i < data.List.length; i++) {
				var tr = $("<tr>" +
						"<td>"+data.List[i].id+"</td>" +
						"<td>"+data.List[i].name+"</td>" +
						"<td>"+data.List[i].price+"</td>" +
						"<td><a href='javascript:;' onclick='delGoods(this)'>删除</a>  " +
						"<a href='javascript:;' onclick='editGoods(this)'>编辑</a>" +
						"</td>" +
						"</tr>")
				$("#t1").append(tr);
			}
		}
	})
}
function delGoods(obj){
	if(!confirm("确定删除吗？")){
		return;
	}
	//获取商品的id

	var id=$(obj).parent().parent().children().first().text();
	
	$.ajax({
		url:"delGoods.do",
		type:"post",
		data:
		{
			"id":id
			
		},
	   dataType:"text",
		success:function(data){
			if(data=="true"){ 
				 key=$("#key").val();
				 type=$("#s1").val();
				var page = parseInt($("#page").val());
				queryGoods(type,key,page,5);
			}
			
		}
		
	})
}

function editGoods(obj){
	
	$("#editl").css("display","block");
	$("#edit").css("display","block");
	
	//获取商品的id
	var id=$(obj).parent().parent().children().first().text();
	var name1=$(obj).parent().parent().children().next().first().text();
	var price1=$(obj).parent().parent().children().next().next().first().text();
	$("#id").val(id);
	$("#name").val(name1);
	$("#price").val(price1)
}
function submitEdit(){
	var id = $("#id").val();
	var name=$("#name").val();
	var price=$("#price").val();
	var url;
	if(id=="系统自动生成"){
		url="addGoods.do";
	}else{
		url="editGoods.do";
	}
	$.ajax({
		url:url,
		type:"post",
		data:
		{
			"id":id,
			"name":name,
			"price":price
		},
	   dataType:"text",
	   success:function(data){
			if(data){
				 key=$("#key").val();
				 type=$("#s1").val();
				var page = parseInt($("#page").val());
				queryGoods(type,key,page,5);
			}
			$("#editl").css("display","none");
			$("#edit").css("display","none");
		}
		
	})
}
function addGoods(){

	$("#editl").css("display","block");
	$("#edit").css("display","block");
	$("#id").val("系统自动生成");
	$("#name").val("");
	$("#price").val("");
	
}
function closeEdit() {
	$("#editl").css("display","none");
	$("#edit").css("display","none");
}
	
