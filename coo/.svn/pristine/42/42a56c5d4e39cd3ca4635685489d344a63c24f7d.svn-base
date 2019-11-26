function doSearch() {
	var businessNoV = $('input[id="businessNo"]').val();
	var businessIdV = $('input[id="businessId"]').val();
	var businessTypeV = $('select[id="businessType"]').val();
	
	$('#busHisTable').bootstrapTable('selectPage', 1);
	$('#busHisTable').bootstrapTable('refresh', {
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
		return "USER数据";
	}

	if (2 == value) {
		return "PRO数据";
	}
	
	if (3 == value) {
		return "OP数据";
	}

	if (4 == value) {
		return "MFG数据";
	}
	
	if (5 == value) {
		return "其他参数";
	}
	
	if (6 == value) {
		return "EQ_Type数据";
	}

	
	if (7 == value) {
		return "Material coefficient数据";
	}

	
	if (8 == value) {
		return "Utility数据";
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