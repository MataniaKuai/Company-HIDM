function formatDate(date) {
	var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    if (month < 10) {
        month ="0" + month;
    }
    
    if (day < 10) {
        day ="0" + day;
    }
    
    return year +"-" + month + "-" + day;
}

function add(){
	$('input[name="materialNo"]').val("");
	$('input[name="assetNo"]').val("");
	$('input[name="irNo"]').val("");
	$('select[name="goodsCode"]').selectpicker('val', "");
	$('input[name="goodsDesc"]').val("");
	$('input[name="chineseName"]').val("");
	$('input[name="releaseTime"]').val("");
	$('input[name="expireTime"]').val("");
	$('select[name="controlStatus"]').selectpicker('val', "");
	$('select[name="relieveMode"]').selectpicker('val', "");
	$('select[name="taxPreperty"]').selectpicker('val', "");
	$('input[name="outTime"]').val("");
	$('select[name="outReason"]').selectpicker('val', "");
	$('select[name="reexportReason"]').selectpicker('val', "");
	$('input[name="reexportNo"]').val("");
	$('input[name="outReleaseNo"]').val("");
	$('input[name="isReturn"]').prop('checked', false);
	$('input[name="isReturn"][value="0"]').prop('checked', true);
	$('input[name="returnTime"]').val("");
	$('input[name="relieveTime"]').val("");
	$('input[name="importItemId"]').val("");
	$('input[name="outQty"]').val("");
	$('input[name="employeeNo"]').val($('input[name="loginName"]').val());
	
	$('input[name="id"]').val("");
	$('#dataModal').modal('show');
	
	$('#editForm input').attr("disabled", false);
	$('#editForm select').attr("disabled", false);
	
	$('#importItemTable').bootstrapTable('removeAll');
	
}

function putFormValue() {
	var selects = $('#controlDetailTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var idV = selects[0].id;
		var materialNoV = selects[0].materialNo;
		var assetNoV = selects[0].assetNo;
		var irNoV = selects[0].irNo;
		var goodsCodeV = selects[0].goodsCode;
		var goodsDescV = selects[0].goodsDesc;
		var chineseNameV = selects[0].chineseName;
		var importItemIdV = selects[0].importItemId;
		
		var releaseTimeV = selects[0].releaseTime;
		if (releaseTimeV && releaseTimeV.length >= 19) {
			releaseTimeV = releaseTimeV.substring(0, 10);
		}
		
		var expireTimeV = selects[0].expireTime;
		if (expireTimeV && expireTimeV.length >= 19) {
			expireTimeV = expireTimeV.substring(0, 10);
		}
		
		var controlStatusV = selects[0].controlStatus;
		var relieveModeV = selects[0].relieveMode;
		var taxPrepertyV = selects[0].taxPreperty;
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
		var relieveTimeV = selects[0].relieveTime;
		if (relieveTimeV && relieveTimeV.length >= 19) {
			relieveTimeV = relieveTimeV.substring(0, 10);
		}
		var outQtyV = selects[0].outQty;
		var employeeNoV = selects[0].employeeNo;

		$('input[name="materialNo"]').val(materialNoV);
		$('input[name="assetNo"]').val(assetNoV);
		$('input[name="irNo"]').val(irNoV);
		$('select[name="goodsCode"]').selectpicker('val', goodsCodeV);
		$('input[name="goodsDesc"]').val(goodsDescV);
		$('input[name="chineseName"]').val(chineseNameV);
		$('input[name="releaseTime"]').val(releaseTimeV);
		$('input[name="expireTime"]').val(expireTimeV);		
		$('select[name="controlStatus"]').selectpicker('val', controlStatusV);
		$('select[name="relieveMode"]').selectpicker('val', relieveModeV);
		$('select[name="taxPreperty"]').selectpicker('val', taxPrepertyV);
		$('input[name="outTime"]').val(outTimeV);
		$('select[name="outReason"]').selectpicker('val', outReasonV);
		$('select[name="reexportReason"]').selectpicker('val', reexportReasonV);
		$('input[name="reexportNo"]').val(reexportNoV);
		$('input[name="outReleaseNo"]').val(outReleaseNoV);
		$('input[name="isReturn"]').prop('checked', false);
		$('input[name="isReturn"][value="' + isReturnV + '"]').prop('checked', true);
		$('input[name="returnTime"]').val(returnTimeV);
		$('input[name="relieveTime"]').val(relieveTimeV);
		$('input[name="importItemId"]').val(importItemIdV);
		$('input[name="outQty"]').val(outQtyV);
		$('input[name="employeeNo"]').val(employeeNoV);
		
		$('input[name="id"]').val(idV);
		$('#dataModal').modal('show');
	}
}

function view(){
	var selects = $('#controlDetailTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录编辑');
		return;
	}
	
	$('#editForm input').attr("disabled", true);
	$('#editForm select').attr("disabled", true);
	$('#saveBtn').hide();
	$('#itemEditBtn').hide();
	$('#saveBtn').hide();
	
	putFormValue();
	getItemByMateOrAsset();
}

function edit(){
	var selects = $('#controlDetailTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录编辑');
		return;
	}
	
	$('#editForm input').attr("disabled", false);
	$('#editForm select').attr("disabled", false);
	$('#saveBtn').show();
	$('#itemEditBtn').show();
	$('#saveBtn').show();
	
	putFormValue();
	
	getItemByMateOrAsset();
}

function save(){
	var materialNoV = $('input[name="materialNo"]').val();
	var assetNoV = $('input[name="assetNo"]').val();
	var irNoV = $('input[name="irNo"]').val();
	var goodsCodeV = $('select[name="goodsCode"]').val();
	var goodsDescV = $('input[name="goodsDesc"]').val();
	var chineseNameV = $('input[name="chineseName"]').val();
	var releaseTimeV = $('input[name="releaseTime"]').val();
	var expireTimeV = $('input[name="expireTime"]').val();
	var controlStatusV = $('select[name="controlStatus"]').selectpicker('val');
	var relieveModeV = $('select[name="relieveMode"]').selectpicker('val');
	var taxPrepertyV = $('select[name="taxPreperty"]').selectpicker('val');
	var outTimeV = $('input[name="outTime"]').val();
	var outReasonV = $('select[name="outReason"]').selectpicker('val');
	var reexportReasonV = $('select[name="reexportReason"]').selectpicker('val');
	var reexportNoV = $('input[name="reexportNo"]').val();
	var outReleaseNoV = $('input[name="outReleaseNo"]').val();
	var relieveTimeV = $('input[name="relieveTime"]').val();
	var importItemIdV = $('input[name="importItemId"]').val();
	var outQtyV = $('input[name="outQty"]').val();
	var employeeNoV = $('input[name="employeeNo"]').val();
	
	var isReturnV = 0;
	if ($('#isReturn1').prop('checked')) {
		isReturnV = 1;
	}
	
	var returnTimeV = $('input[name="returnTime"]').val();
		
	var idV = $('input[name="id"]').val();
	$.post('/importexport/controlDetail/save',
		{
		materialNo: materialNoV, assetNo: assetNoV, irNo: irNoV, goodsCode: goodsCodeV, goodsDesc: goodsDescV, 
		chineseName: chineseNameV, releaseTime: releaseTimeV, expireTime: expireTimeV, controlStatus: controlStatusV, 
		relieveMode: relieveModeV, taxPreperty: taxPrepertyV, outTime: outTimeV, outReason: outReasonV, 
		reexportReason: reexportReasonV, reexportNo: reexportNoV, outReleaseNo: outReleaseNoV, isReturn: isReturnV, 
		returnTime: returnTimeV, id: idV, relieveTime: relieveTimeV, importItemId: importItemIdV, outQty: outQtyV, employeeNo : employeeNoV
		},
		function(result){
		if (result){
			doSearch();
			if(idV.length == 0){
				$('select[name="controlStatus"]').selectpicker('val', "");
				$('select[name="relieveMode"]').selectpicker('val', "");
				$('select[name="taxPreperty"]').selectpicker('val', "");
				$('input[name="outTime"]').val("");
				$('select[name="outReason"]').selectpicker('val', "");
				$('select[name="reexportReason"]').selectpicker('val', "");
				$('input[name="reexportNo"]').val("");
				$('input[name="outReleaseNo"]').val("");
				$('input[name="isReturn"]').prop('checked', false);
				$('input[name="isReturn"][value="0"]').prop('checked', true);
				$('input[name="returnTime"]').val("");
				$('input[name="relieveTime"]').val("");
				$('input[name="outQty"]').val("");
			}
			$('#itemDataModal').modal('hide');
		} else {
			alert('该记录已存在，不能重复增加');
		}
	},'json');
}

function remove(){
	var rows = $('#controlDetailTable').bootstrapTable('getSelections');
	if (rows && rows.length > 0){
		var ids = new Array();
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			ids.push(row.id);
		}
		
		$.post('/importexport/controlDetail/delete',{ids: ids},function(result){
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
    
    $('#controlDetailTable').bootstrapTable('selectPage', 1);
	$('#controlDetailTable').bootstrapTable('refresh', {query:{materialNo: materialNoV, assetNo: assetNoV, goodsCode: goodsCodeV, page:1}});
}

function getOtherInfo() {
	var irNo = $('input[name="irNo"]').val();
	$.ajax({
		url : "/importexport/controlDetail/getOtherInfo",
		type : 'POST',
		data : {irNo:irNo},
		async : false,
		dataType : "json",
		success : function(data) {
			if(data != null){
				var releaseTimeV = data.releaseTime;
				var arriveTimeV = "";
				if (releaseTimeV && releaseTimeV.length >= 19) {
					releaseTimeV = releaseTimeV.substring(0, 10);

					var result = new Date(Date.parse(releaseTimeV));
					result.setFullYear(result.getFullYear()+3);
					var month = result.getMonth() + 1;
					var day = result.getDate();
					month = (month.toString().length == 1) ? ("0" + month) : month;
					day = (day.toString().length == 1) ? ("0" + day) : day;
					arriveTimeV = result.getFullYear() + '-' + month + '-' + day;
				}
				
				
				//var arriveTimeV = data.arriveTime;
				$('select[name="goodsCode"]').selectpicker('val', data.goodsCode);
				$('input[name="releaseTime"]').val(releaseTimeV);
				$('input[name="expireTime"]').val(arriveTimeV);
			}
		},
        error: function (e) {
        }
	});
	getItemByMateOrAsset();
}


function getDescriptionByMate() {
	var materialNo = $('input[name="materialNo"]').val();
	if(materialNo.length > 0){
		$.ajax({
			url : "/importexport/material/getDescription",
			type : 'POST',
			data : {materialNo:materialNo},
			async : false,
			dataType : "text",
			success : function(data) {
				$('input[name="goodsDesc"]').val(data);
			},
			error: function (e) {
				alert(e.message);
			}
		});
		getItemByMateOrAsset();
	}
}

function getDescriptionByAsset() {
	var assetNo = $('input[name="assetNo"]').val();
	if(assetNo.length > 0){
		$.ajax({
			url : "/importexport/asset/getDescription",
			type : 'POST',
			data : {assetNo:assetNo},
			async : false,
			dataType : "text",
			success : function(data) {
				$('input[name="goodsDesc"]').val(data);
			},
			error: function (e) {
				alert(e.message);
			}
		});
		getItemByMateOrAsset();
	}
	
}

//根据irNo、materialNo/assetNo查询已收货item
function getItemByMateOrAsset() {
	var assetNo = $('input[name="assetNo"]').val();
	var materialNo = $('input[name="materialNo"]').val();
	var irNo = $('input[name="irNo"]').val();
	var importItemId = $('input[name="importItemId"]').val();
	if(irNo.trim().length == 0 || (materialNo.trim().length == 0 && assetNo.trim().length == 0)){
		return;
	}
    
    $('#importItemTable').bootstrapTable('selectPage', 1);
	$('#importItemTable').bootstrapTable('refresh', {
		query:{materialNo: materialNo, assetNo: assetNo, irNo: irNo, importItemId:importItemId, page:1}
	});
}

function importItemView() {
	var selects = $('#importItemTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录查看');
		return;
	}
	var importItemIdV = selects[0].id;
	$('input[name="importItemId"]').val(importItemIdV);
	
	$('#itemEditForm input').attr("disabled", true);
	$('#itemEditForm select').attr("disabled", true);
	$('#saveBtn').hide();
	$('#itemDataModal').modal('show');
}

function importItemEdit(){
	//获取item的id
	var selects = $('#importItemTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录编辑');
		return;
	}
	var importItemIdV = selects[0].id;
	$('input[name="importItemId"]').val(importItemIdV);
	
	$('#itemEditForm input').attr("disabled", false);
	$('#itemEditForm select').attr("disabled", false);
	$("input[name='employeeNo']").attr("disabled", true);
	$('#saveBtn').show();

	$('#itemDataModal').modal('show');
}

function editClose(){
	$('#itemDataModal').modal('hide');
}


