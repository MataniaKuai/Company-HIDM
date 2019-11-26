function add(){
	
	$('input[name="materialNo"]').val("");
	$('input[name="materialGroup"]').val("");
	$('input[name="materialName"]').val("");
	$('input[name="bomUnit"]').val("");
	$('input[name="coefficient"]').val("");
	$('input[name="materialPrice"]').val("");
	$('input[name="id"]').val("");
	$('#dataModal').modal('show');


	$('#editForm input').attr("disabled", false);
	$('#saveBtn').show();
}

function putFormValue() {
	var selects = $('#materialCoefficientTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var idV = selects[0].id;
		var materialNoV = selects[0].materialNo;
		var materialGroupV = selects[0].materialGroup;
		var materialNameV = selects[0].materialName;
		var bomUnitV = selects[0].bomUnit;
		var coefficientV = selects[0].coefficient;
		var materialPriceV = selects[0].materialPrice;
		
		$('input[name="materialNo"]').val(materialNoV);
		$('input[name="materialGroup"]').val(materialGroupV);
		$('input[name="materialName"]').val(materialNameV);
		$('input[name="bomUnit"]').val(bomUnitV);
		$('input[name="coefficient"]').val(coefficientV);
		$('input[name="materialPrice"]').val(materialPriceV);
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
	var selects = $('#materialCoefficientTable').bootstrapTable('getSelections');
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
	
	var materialNoV = $('input[name="materialNo"]').val().trim();
	var materialGroupV = $('input[name="materialGroup"]').val();
	var materialNameV = $('input[name="materialName"]').val();
	var bomUnitV = $('input[name="bomUnit"]').val();
	var coefficientV = $('input[name="coefficient"]').val();
	var materialPriceV = $('input[name="materialPrice"]').val();
	var idV = $('input[name="id"]').val();
	var checked = true;
	var param1 = {materialNo: materialNoV};
	$.ajax({
		url: "/coo/materialCoefficient/checkData",
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
    	$.post('/coo/materialCoefficient/save',
    			{ 
    		id: idV, materialNo: materialNoV, materialGroup: materialGroupV,materialName: materialNameV,
    		bomUnit:bomUnitV,coefficient:coefficientV,materialPrice:materialPriceV
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
	var rows = $('#materialCoefficientTable').bootstrapTable('getSelections');
	if (rows && rows.length > 0){
		var ids = new Array();
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			
			ids.push(row.id);
		}
		
		$.post('/coo/materialCoefficient/delete',{ids: ids},function(result){
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
	var materialNoV = $('input[id="MaterialNo"]').val();
	var materialGroupV = $('input[id="MaterialGroup"]').val();
	var materialNameV = $('input[id="MaterialName"]').val();
    $('#materialCoefficientTable').bootstrapTable('selectPage', 1);
	$('#materialCoefficientTable').bootstrapTable('refresh', {query:{materialNo: materialNoV, materialGroup: materialGroupV, materialName: materialNameV, page:1}});
	
}
