function add(){
	
	$('input[name="userName"]').val("");
	$('input[name="email"]').val("");
	$('#dataDiv').show();
	$('#listDiv').hide();
	$('#editForm input').attr("disabled", false);
	$('#saveBtn').show();
	$('#syncDiv').show();
	$('#myTab a[href="#home"]').tab('show');
	
	$("#editForm").bootstrapValidator("resetForm");
}

function putFormValue() {
	var selects = $('#userTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var idV = selects[0].id;
		var userNameV = selects[0].userName;
		var emailV = selects[0].email;
		
		$('input[name="userName"]').val(userNameV);
		$('input[name="email"]').val(emailV);
		$('input[name="id"]').val(idV);
		$('#dataDiv').show();
		$('#listDiv').hide();
		
		return true;
	}
	
	return false;
}


function edit(){
	var selects = $('#userTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录编辑');
		return;
	}
	
	putFormValue();
	
	$('#editForm input').attr("disabled", false);
	$('#editForm input[name=userName]').attr("disabled", true);
	$('#saveBtn').show();
	$('#syncDiv').show();
	$('#myTab a[href="#home"]').tab('show');
	
	$("#editForm").bootstrapValidator("resetForm");
}

function closeDataDiv() {
	$('#dataDiv').hide();
	$('#listDiv').show();
}

function save(){
	$("#editForm").bootstrapValidator("validate");
	if (!$("#editForm").data('bootstrapValidator').isValid()) {
		return;
	}
	
	var userNameV = $('input[name="userName"]').val();
	var emailV = $('input[name="email"]').val();
	var idV = $('input[name="id"]').val();
	$.post('/booksharingscore/user/save',
		{
		userName: userNameV,email: emailV,
		id:idV
		},
		function(result){
		if (result){
			doSearch();
			$('#dataDiv').hide();
			$('#listDiv').show();
		} else {
			alert('系统错误');
		}
	},'json');
	
}

function removeUser(){
	var rows = $('#userTable').bootstrapTable('getSelections');
	if (rows && rows.length > 0){
		var ids = new Array();
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			ids.push(row.id);
		}
		
		$.post('/booksharingscore/user/delete',{ids: ids},function(result){
			if(!result){
				alert("删除失败,有相关人员已评价课程或是某课程讲师！");
				return;
			}
			doSearch();
		},'json');
	} else {
		alert('至少选择一条记录。');
	}
}

function doSearch() {
	var userNameV = $('input[id="userName"]').val();
	
    $('#userTable').bootstrapTable('selectPage', 1);
	$('#userTable').bootstrapTable('refresh', {
		query:{
			userName: userNameV, 
			page:1
		}
	});
}