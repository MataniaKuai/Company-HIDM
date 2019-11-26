function add(){
	
	$('input[name="model"]').val("");
	$('input[name="id"]').val("");
	$('#dataModal').modal('show');


	$('#editForm input').attr("disabled", false);
	$('#modelDiv').hide();
	$('#saveBtn').show();
}

function putFormValue() {
	var selects = $('#modelTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var idV = selects[0].id;
		var modelNoV = selects[0].modelNo;
		var modelV = selects[0].model;
		
		$('input[name="modelNo"]').val(modelNoV);
		$('input[name="model"]').val(modelV);
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
	$('#modelDiv').show();
	$('#saveBtn').hide();
	
	putFormValue();
}

function edit(){
	var selects = $('#modelTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录编辑');
		return;
	}
	$('#modelDiv').show();
	$('#editForm input').attr("disabled", false);
	$('input[name="modelNo"]').attr("disabled", true);
	$('#saveBtn').show();
	
	putFormValue();
}

function save(){
	$("#editForm").bootstrapValidator("validate");
	if (!$("#editForm").data('bootstrapValidator').isValid()) {
		return;
	}
	
	var modelNoV = $('input[name="modelNo"]').val();
	var modelV = $('input[name="model"]').val();
	
	var idV = $('input[name="id"]').val();

	var checked = true;
	var param1 = {model: modelV};
	$.ajax({
		url: "/coo/model/checkData",
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
    	$.post('/coo/model/save',
    			{ id: idV, modelNo: modelNoV, model: modelV
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
	var rows = $('#modelTable').bootstrapTable('getSelections');
	if (rows && rows.length > 0){
		var ids = new Array();
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];		
			ids.push(row.id);
		}
		
		$.post('/coo/model/delete',{ids: ids},function(result){
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
	var modelV = $('input[id="model"]').val();    
    $('#modelTable').bootstrapTable('selectPage', 1);
	$('#modelTable').bootstrapTable('refresh', {query:{model: modelV, page:1}});
}

