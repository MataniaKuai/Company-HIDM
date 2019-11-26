function add(){
	
	$('input[name="vendor"]').val("");
	$('input[name="id"]').val("");
	$('#dataModal').modal('show');


	$('#editForm input').attr("disabled", false);
	$('#vendorDiv').hide();
	$('#saveBtn').show();
}

function putFormValue() {
	var selects = $('#vendorTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var idV = selects[0].id;
		var vendorNoV = selects[0].vendorNo;
		var vendorV = selects[0].vendor;
		
		$('input[name="vendorNo"]').val(vendorNoV);
		$('input[name="vendor"]').val(vendorV);
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
	$('#vendorDiv').show();
	$('#editForm input').attr("disabled", true);
	$('#saveBtn').hide();
	
	putFormValue();
}

function edit(){
	var selects = $('#vendorTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录编辑');
		return;
	}
	$('#vendorDiv').show();
	$('#editForm input').attr("disabled", false);
	$('input[name="vendorNo"]').attr("disabled", true);
	$('#saveBtn').show();
	
	putFormValue();
}

function save(){
	$("#editForm").bootstrapValidator("validate");
	if (!$("#editForm").data('bootstrapValidator').isValid()) {
		return;
	}
	var vendorNoV = $('input[name="vendorNo"]').val();
	var vendorV = $('input[name="vendor"]').val();	
	var idV = $('input[name="id"]').val();
	var checked = true;
	var param1 = {vendor: vendorV};
	$.ajax({
		url: "/coo/vendor/checkData",
		type: 'POST',
		cache: false,
		async:false,
		data: param1,
		success: function(data) {
			if(idV.length == 0){
				if (data && data.list.length > 0) {
					alert('该记录已存在');
					checked = false;
				}
			}else{
				if (data.list.length > 0 && idV != data.list[0].id) {
					alert('该记录已存在');
					checked = false;
				}
			}
		}
	});
	 if(checked){
	$.post('/coo/vendor/save',
		{ id: idV, vendorNo: vendorNoV, vendor: vendorV
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
}

function remove(){
	var rows = $('#vendorTable').bootstrapTable('getSelections');
	if (rows && rows.length > 0){
		var ids = new Array();
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];		
			ids.push(row.id);
		}
		
		$.post('/coo/vendor/delete',{ids: ids},function(result){
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
	var vendorV = $('input[id="vendor"]').val();    
    $('#vendorTable').bootstrapTable('selectPage', 1);
	$('#vendorTable').bootstrapTable('refresh', {query:{vendor: vendorV, page:1}});
}

