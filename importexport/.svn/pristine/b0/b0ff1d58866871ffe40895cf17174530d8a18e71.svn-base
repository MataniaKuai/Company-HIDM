function doSearch() {
	var irNoV = $('input[id="irNo"]').val().trim();

	$('#importInfoTable').bootstrapTable('selectPage', 1);
	$('#importInfoTable').bootstrapTable('refresh', {
		query : {
			irNo : irNoV,
			page : 1
		}
	});
}

function actionFormatter(value, row, index) {
	if (1 == value) {
		return "RELEASE";
	}
	
	if (0 == value) {
		return "UNRELEASE";
	}

}
