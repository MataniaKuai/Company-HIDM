function doSearchList(){
	var grNoV = $('input[id="grNo"]').val().trim();
    $('#importInfoTable').bootstrapTable('selectPage', 1);
	$('#importInfoTable').bootstrapTable('refresh', {query:{grNo: grNoV, page:1}});
}

function declarationTimeFormatter(value, row, index) {
	if (value && value.length >= 19) {
		return value.substring(0, 10);
	}
	
	return value;
}

function unReceiveItems(){
	var selects = $('#importInfoTable').bootstrapTable('getSelections');
	var grNoV = $('input[id="grNo"]').val().trim();
	if (selects.length > 0) {
		var itemIdsV = new Array()
		
		for (var i = 0; i < selects.length; i++) {
			var idV = selects[i].id;
			var status = selects[i].status;
			if (status == "0") {
				alert("只有先收货才能取消收货");
				return
			}
			
			itemIdsV[i] = idV;
		}
		$.post('/importexport/receive/unReceive',
				{
					itemIds : itemIdsV
				},
				function(result){
				    if (result == "0"){
					    $('#importInfoTable').bootstrapTable('selectPage', 1);
						$('#importInfoTable').bootstrapTable('refresh', {query:{grNo: grNoV, page:1}});
				    } else {
					    alert(result);
				    }
			    }
			);
		
	} else {
		alert('请选择记录');
	}
}
