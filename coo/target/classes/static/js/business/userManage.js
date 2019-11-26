function add(){
	
	$('input[name="userName"]').val("");
	$('input[name="password"]').val("");
	$('input[name="id"]').val("");
	$('#dataModal').modal('show');


	$('#editForm input').attr("disabled", false);
	$('#saveBtn').show();
}

function putFormValue() {
	var selects = $('#userManageTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var idV = selects[0].id;
		var userNameV = selects[0].userName;
		var passwordV = selects[0].password;
		
		$('input[name="userName"]').val(userNameV);
		$('input[name="password"]').val(passwordV);
		$('input[name="id"]').val(idV);

		$('#dataModal').modal('show');
		
		return true;
	}
	
	return false;
}

function view(){
	if (!putFormValue()) {
		alert('只能选择一条记录查看');
		
		return;
	}
	
	$('#editForm input').attr("disabled", true);
	$('#saveBtn').hide();
	
	putFormValue();
}

function edit(){
	var selects = $('#userManageTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录编辑');
		return;
	}

	$('#editForm input').attr("disabled", false);
	$('#saveBtn').show();
	
	putFormValue();
}

function save(){
	$("#editForm").bootstrapValidator("validate");
	if (!$("#editForm").data('bootstrapValidator').isValid()) {
		return;
	}
	
	var userNameV = $('input[name="userName"]').val();
	var passwordV = $('input[name="password"]').val();
	
	var idV = $('input[name="id"]').val();
	$.post('/coo/userManage/save',
		{ 
		id: idV, userName: userNameV, password: passwordV
		},
		function(result){
		if (result){
			doSearch();
			$('#dataModal').modal('hide');
		} else {
			alert('系统错误');
		}
	},'json');
}

function remove(){
	var rows = $('#userManageTable').bootstrapTable('getSelections');
	if (rows && rows.length > 0){
		var ids = new Array();
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			
			ids.push(row.id);
		}
		
		$.post('/coo/userManage/delete',{ids: ids},function(result){
			if (result){
				doSearch();
			} else {
				$.messager.show({
					title: '错误',
					msg: '系统错误'
				});
			}
		},'json');
	} else {
		alert('至少选择一条记录。');
	}
}

function doSearch() {
	var eqTypeV = $('input[id="eqType"]').val();
    
    $('#userManageTable').bootstrapTable('selectPage', 1);
	$('#userManageTable').bootstrapTable('refresh', {query:{eqType: eqTypeV, page:1}});
}
