
function putFormValue() {
	var selects = $('#currencyTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var idV = selects[0].id;
		var itemV = selects[0].item;
		var valueV = selects[0].value;
		var unitV = selects[0].unit;
		
		$('input[name="item"]').val(itemV);
		$('input[name="value"]').val(valueV);
		$('input[name="unit"]').val(unitV);
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
	putFormValue();
}

