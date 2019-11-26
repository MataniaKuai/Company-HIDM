function doSearch() {
	var businessNoV = $('input[id="businessNo"]').val();
	var businessIdV = $('input[id="businessId"]').val();
	var businessTypeV = $('select[id="businessType"]').val();
	
	$('#importInfoTable').bootstrapTable('selectPage', 1);
	$('#importInfoTable').bootstrapTable('refresh', {
		query : {
			businessNo : businessNoV,
			businessId : businessIdV,
			businessType : businessTypeV,
			page : 1
		}
	});
}
function businessTypeFormatter(value) {
	if (1 == value) {
		return "进口数据";
	}

	if (2 == value) {
		return "原材料数据";
	}
	
	if (3 == value) {
		return "资产数据";
	}

	if (4 == value) {
		return "监管明细";
	}
	
	if (5 == value) {
		return "进口明细";
	}

}

function actionFormatter(value) {
	if (1 == value) {
		return "增加";
	}
	
	if (2 == value) {
		return "更新";
	}
	
	if(3 == value){
		return "删除";
	}

}
function contentFormatter(value) {
	return "<input type='textarea' value='" + value + "' style='width:200px;height:25px' disabled>";
}