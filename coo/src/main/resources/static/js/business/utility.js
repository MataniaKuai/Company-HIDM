function add(){
	
	$('input[name="utilityNo"]').val("");
	$('input[name="utilityGroup"]').val("");
	$('input[name="utilityName"]').val("");
	$('input[name="utilityUnit"]').val("");
	$('input[name="coefficient"]').val("");
	$('input[name="utilityPrice"]').val("");
	$('input[name="id"]').val("");
	$('#dataModal').modal('show');

	$('#editForm input').attr("disabled", false);
	$('#saveBtn').show();
}

function putFormValue() {
	var selects = $('#utilityTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var idV = selects[0].id;
		var utilityNoV = selects[0].utilityNo;
		var utilityGroupV = selects[0].utilityGroup;
		var utilityNameV = selects[0].utilityName;
		var utilityUnitV = selects[0].utilityUnit;
		var coefficientV = selects[0].coefficient;
		var utilityPriceV = selects[0].utilityPrice;
		var issapV = selects[0].isSap;
		$('input[name="utilityNo"]').val(utilityNoV);
		$('input[name="utilityGroup"]').val(utilityGroupV);
		$('input[name="utilityName"]').val(utilityNameV);
		$('input[name="utilityUnit"]').val(utilityUnitV);
		$('input[name="coefficient"]').val(coefficientV);
		$('input[name="utilityPrice"]').val(utilityPriceV);
        if(issapV == 1)
        	$('input[name="utilityPrice"]').val('***');
		$('input[name="id"]').val(idV);        
		$('#dataModal').modal('show');
		
		return true;
	}
	
	return false;
}

function putFormValue2() {
	var selects = $('#utilityTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var idV = selects[0].id;
		var utilityNoV = selects[0].utilityNo;
		var utilityGroupV = selects[0].utilityGroup;
		var utilityNameV = selects[0].utilityName;
		var utilityUnitV = selects[0].utilityUnit;
		var coefficientV = selects[0].coefficient;
		var utilityPriceV = selects[0].utilityPrice;
		var issapV = selects[0].isSap;
		$('input[name="utilityNo"]').val(utilityNoV);
		$('input[name="utilityGroup"]').val(utilityGroupV);
		$('input[name="utilityName"]').val(utilityNameV);
		$('input[name="utilityUnit"]').val(utilityUnitV);
		$('input[name="coefficient"]').val(coefficientV);
		$('input[name="utilityPrice"]').val(utilityPriceV);
		$('input[name="id"]').val(idV);        
		$('#dataModal').modal('show');
		if(issapV == 1)
			{
			$('input[name="utilityPrice"]').attr("disabled", true);
    	    $('input[name="utilityPrice"]').val('***');
			}
		
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
	var selects = $('#utilityTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录编辑');
		return;
	}
	$('#editForm input').attr("disabled", false);
	$('#saveBtn').show();
	
	putFormValue2();
}

function save(){
	$("#editForm").bootstrapValidator("validate");
	if (!$("#editForm").data('bootstrapValidator').isValid()) {
		return;
	}
	
	var utilityNoV = $('input[name="utilityNo"]').val().trim();
	var utilityGroupV = $('input[name="utilityGroup"]').val();
	var utilityNameV = $('input[name="utilityName"]').val();
	var utilityUnitV = $('input[name="utilityUnit"]').val();
	var coefficientV = $('input[name="coefficient"]').val();
	var utilityPriceV = $('input[name="utilityPrice"]').val();
	var idV = $('input[name="id"]').val();

	var checked = true;
	var param1 = {utilityNo: utilityNoV};
	$.ajax({
		url: "/coo/utility/checkData",
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
    	$.post('/coo/utility/save',
    			{ id: idV, utilityNo: utilityNoV, utilityGroup: utilityGroupV, utilityName: utilityNameV
    			, utilityUnit: utilityUnitV, coefficient: coefficientV, utilityPrice: utilityPriceV
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
	var rows = $('#utilityTable').bootstrapTable('getSelections');
	if (rows && rows.length > 0){
		var ids = new Array();
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];		
			ids.push(row.id);
		}
		
		$.post('/coo/utility/delete',{ids: ids},function(result){
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
	var utilityNoV = $('input[id="utilityNo"]').val();  
	var utilityGroupV = $('input[id="utilityGroup"]').val();  
	var utilityNameV = $('input[id="utilityName"]').val();  
    $('#utilityTable').bootstrapTable('selectPage', 1);
	$('#utilityTable').bootstrapTable('refresh', {query:{utilityNo: utilityNoV, utilityGroup: utilityGroupV, utilityName: utilityNameV, page:1}});
}

function actionFormatter(value, row, index) {
	if (1 == row.isSap) {
		return "***";
	}
	return value;
	
}
function actionissap(value, row, index) {
	if (1 == value) {
		return "是";
	}
	
	if (0 == value) {
		return "否";
	}
	
}
