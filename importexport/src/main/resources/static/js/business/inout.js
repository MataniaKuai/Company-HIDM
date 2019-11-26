function add(){
	$('input[name="materialNo"]').val("");
	$('input[name="assetNo"]').val("");
	$('select[name="goodsCode"]').selectpicker('val', "");
	$('input[name="goodsDesc"]').val("");
	$('input[name="chineseName"]').val("");
	$('select[name="controlStatus"]').selectpicker('val', "");
	$('select[name="relieveMode"]').selectpicker('val', "");
	$('input[name="outTime"]').val("");
	$('select[name="outReason"]').selectpicker('val', "");
	$('select[name="reexportReason"]').selectpicker('val', "");
	$('input[name="reexportNo"]').val("");
	$('input[name="outReleaseNo"]').val("");
	$('input[name="isReturn"]').prop('checked', false);
	$('input[name="isReturn"][value="0"]').prop('checked', true);
	$('input[name="returnTime"]').val("");
	
	$('input[name="id"]').val("");
	$('#dataModal').modal('show');
	
	$('#editForm input').attr("disabled", false);
	$('#editForm select').attr("disabled", false);
	$('#saveBtn').show();
}

function putFormValue() {
	var selects = $('#inoutTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var idV = selects[0].id;
		var materialNoV = selects[0].materialNo;
		var assetNoV = selects[0].assetNo;
		var goodsCodeV = selects[0].goodsCode;
		var goodsDescV = selects[0].goodsDesc;
		var chineseNameV = selects[0].chineseName;
		var controlStatusV = selects[0].controlStatus;
		var relieveModeV = selects[0].relieveMode;
		var outTimeV = selects[0].outTime;
		if (outTimeV && outTimeV.length >= 19) {
			outTimeV = outTimeV.substring(0, 10);
		}
		var outReasonV = selects[0].outReason;
		var reexportReasonV = selects[0].reexportReason;
		var reexportNoV = selects[0].reexportNo;
		var outReleaseNoV = selects[0].outReleaseNo;
		var isReturnV = selects[0].isReturn;
		var returnTimeV = selects[0].returnTime;
		if (returnTimeV && returnTimeV.length >= 19) {
			returnTimeV = returnTimeV.substring(0, 10);
		}
		
		$('input[name="materialNo"]').val(materialNoV);
		$('input[name="assetNo"]').val(assetNoV);
		$('select[name="goodsCode"]').selectpicker('val', goodsCodeV);
		$('input[name="goodsDesc"]').val(goodsDescV);
		$('input[name="chineseName"]').val(chineseNameV);
		$('select[name="controlStatus"]').selectpicker('val', controlStatusV);
		$('select[name="relieveMode"]').selectpicker('val', relieveModeV);
		$('input[name="outTime"]').val(outTimeV);
		$('select[name="outReason"]').selectpicker('val', outReasonV);
		$('select[name="reexportReason"]').selectpicker('val', reexportReasonV);
		$('input[name="reexportNo"]').val(reexportNoV);
		$('input[name="outReleaseNo"]').val(outReleaseNoV);
		$('input[name="isReturn"]').prop('checked', false);
		$('input[name="isReturn"][value="' + isReturnV + '"]').prop('checked', true);
		$('input[name="returnTime"]').val(returnTimeV);
		
		$('input[name="id"]').val(idV);
		$('#dataModal').modal('show');
	}
}

function view(){
	var selects = $('#inoutTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录编辑');
		return;
	}
	
	$('#editForm input').attr("disabled", true);
	$('#editForm select').attr("disabled", true);
	$('#saveBtn').hide();
	
	putFormValue();
}

function edit(){
	var selects = $('#inoutTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录编辑');
		return;
	}
	
	$('#editForm input').attr("disabled", false);
	$('#editForm select').attr("disabled", false);
	$('#saveBtn').show();
	
	putFormValue();
}

function save(){
	var materialNoV = $('input[name="materialNo"]').val();
	var assetNoV = $('input[name="assetNo"]').val();
	var goodsCodeV = $('select[name="goodsCode"]').val();
	var goodsDescV = $('input[name="goodsDesc"]').val();
	var chineseNameV = $('input[name="chineseName"]').val();
	var controlStatusV = $('select[name="controlStatus"]').selectpicker('val');
	var relieveModeV = $('select[name="relieveMode"]').selectpicker('val');
	var outTimeV = $('input[name="outTime"]').val();
	var outReasonV = $('select[name="outReason"]').selectpicker('val');
	var reexportReasonV = $('select[name="reexportReason"]').selectpicker('val');
	var reexportNoV = $('input[name="reexportNo"]').val();
	var outReleaseNoV = $('input[name="outReleaseNo"]').val();
	
	var isReturnV = 0;
	if ($('#isReturn1').prop('checked')) {
		isReturnV = 1;
	}
	
	var returnTimeV = $('input[name="returnTime"]').val();
		
	var idV = $('input[name="id"]').val();
	$.post('/importexport/inout/save',
		{
		materialNo: materialNoV, assetNo: assetNoV, goodsCode: goodsCodeV, goodsDesc: goodsDescV, 
		chineseName: chineseNameV, controlStatus: controlStatusV, relieveMode: relieveModeV, outTime: outTimeV,
		outReason: outReasonV, reexportReason: reexportReasonV, reexportNo: reexportNoV, outReleaseNo: outReleaseNoV,
		isReturn: isReturnV, returnTime: returnTimeV, id: idV
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
	var rows = $('#inoutTable').bootstrapTable('getSelections');
	if (rows && rows.length > 0){
		var ids = new Array();
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			ids.push(row.id);
		}
		
		$.post('/importexport/inout/delete',{ids: ids},function(result){
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

function doSearch(){
	var materialNoV = $('input[id="materialNo"]').val();
	var assetNoV = $('input[id="assetNo"]').val();
	var goodsCodeV = $('select[id="goodsCode"]').val();
    
    $('#inoutTable').bootstrapTable('selectPage', 1);
	$('#inoutTable').bootstrapTable('refresh', {query:{materialNo: materialNoV, assetNo: assetNoV, goodsCode: goodsCodeV, page:1}});
}