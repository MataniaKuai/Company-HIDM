function upload() {
	var poNoV = $('input[id="batchPoNo"]').val();
	var importIdV = $('input[name="id"]').val();
	
	if (!importIdV) {
		alert("请先创建进口基本信息");
		return;
	}
	
	var formData = new FormData();
	// 获取文件
	var fileData = $("#fileName").prop("files")[0];
	// 把所以表单信息
	formData.append("importId", importIdV);
	formData.append("file", fileData);
	
	$.ajax({
        url: "/importexport/importBatch/upload",
        type: 'POST',
        cache: false,
        data: formData,
        processData: false,
        contentType: false,
        dataType:"json",
        beforeSend: function() {
            uploading = true;
        },
        success: function(data) {
        	var status = data.status;
        	if("1" == status){
            	batchDoSearch();
        	}else{
        		alert(data.msg);
        	}
        }
    });	
}

function putBatchValue() {
	var selects = $('#importBatchTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var idV = selects[0].id;
		var poNoV = selects[0].poNo;
		var poItemV = selects[0].poItem;
		var factoryV = selects[0].factory;
		var materialNoV = selects[0].materialNo;
		var batchNoV = selects[0].batchNo;
		var unitV = selects[0].unit;
		var qtyV =  selects[0].qty;
		var produceTimeV = selects[0].produceTime;
		var itemIdV = selects[0].itemId;
		var importIdV = selects[0].importId;
		var stockV = selects[0].stock;
		if (produceTimeV && produceTimeV.length >= 19) {
			produceTimeV = produceTimeV.substring(0, 10);
		}

		$('input[name="batchPoNo"]').val(poNoV);
		$('input[name="batchPoItem"]').val(poItemV);
		$('input[name="factory"]').val(factoryV);
		$('input[name="batchMaterialNo"]').val(materialNoV);
		$('input[name="batchNo"]').val(batchNoV);
		$('input[name="batchUnit"]').val(unitV);
		$('input[name="batchQty"]').val(qtyV);
		$('input[name="produceTime"]').val(produceTimeV);
		$('input[name="importId"]').val(importIdV);
		$('input[name="id"]').val(itemIdV);
		$('input[name="stock"]').val(stockV);
		$('input[name="batchId"]').val(idV);
		$('#batchDataModal').modal('show');
		
		return true;
	}
	
	return false;
}

function batchView() {
	if (!putBatchValue()) {
	    alert('只能选择一条记录查看');
	    return;
	}

}

function batchEdit(){
	var selects = $('#importBatchTable').bootstrapTable('getSelections');
	if(selects.length > 1) {
		alert('只能选择一条记录查看');
	    return;
	}
	var idV = selects[0].itemId;
	var stockV = selects[0].stock;
	$('input[name="batchstock"]').val(stockV);
	$('input[name="batchid"]').val(idV);	

}

function batchSave(){
	var poNoV = $('input[name="batchPoNo"]').val();
	var poItemV = $('input[name="batchPoItem"]').val();
	var factoryV = $('input[name="factory"]').val();
	var materialNoV = $('input[name="batchMaterialNo"]').val();
	var batchNoV = $('input[name="batchNo"]').val();
	var unitV = $('input[name="batchUnit"]').val();
	var qtyV =  $('input[name="batchQty"]').val();
	var produceTimeV = $('input[name="produceTime"]').val();
	var idV = $('input[name="batchId"]').val();
	$.post('/importexport/importBatch/save',
		{
		  poNo: poNoV, poItem: poItemV, factory: factoryV, materialNo: materialNoV, batchNo: batchNoV,
		  unit: unitV, qty: qtyV, produceTime: produceTimeV, id: idV
		},
		function(result){
		    if (result){
			    batchDoSearch();
			    $('#batchDataModal').modal('hide');
		    } else {
			    alert('系统错误');
		    }
	    },
	    'json'
	);
}

function batchRemove(){
	var rows = $('#importBatchTable').bootstrapTable('getSelections');
	if (rows && rows.length > 0){
		var ids = new Array();
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			ids.push(row.id);
		}
		
		$.post('/importexport/importBatch/delete',{ids: ids},function(result){
			if (result){
				batchDoSearch();
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

function batchDoSearch() {
	var irNoV = $('input[id="batchIrNo"]').val();
	if (!irNoV) {
		irNoV = "empty";
	}
    
    $('#importBatchTable').bootstrapTable('selectPage', 1);
	$('#importBatchTable').bootstrapTable('refresh', {query:{irNo: irNoV, page:1}});
}

function receiveBatches(){
	var isBatchV = 0;
	if($("#batchY").prop('checked')) {
		isBatchV = 1;
	}
	var statusV = $('input[name="status"]').val();
	var importIdV = $('input[name="id"]').val();
	if (statusV == 0) {
		alert("只有已经Release的记录才能收货");
		return;
	}
	
	var selects = $('#importBatchTable').bootstrapTable('getSelections');
	if (selects.length > 0) {
		var itemIdsV = new Array();
		var stocksV = new Array();
		var importIdV;
		for (var i = 0; i < selects.length; i++) {
			var itemId = selects[i].itemId;
			var statusV = selects[i].status;
			importIdV = selects[i].importId;
			var itemStatus = selects[i].status;
			var stockV = $("#stock_"+itemId).val();
			var itemIsBatch = selects[i].isBatch;
			
			if (itemStatus == 1) {
				alert("不能重复收货");
				return
			}
			if(itemIsBatch != isBatchV){
				alert("批次类型不匹配");
				return
			}
			itemIdsV[i] = itemId;
			stocksV[i] = stockV;
		}
	    $.post('/importexport/receive/receive', {itemIds : itemIdsV, importId : importIdV, isBatch : isBatchV, stocks: stocksV},
		function(resultStr) {
	      if (resultStr) {
	    	var result = $.parseJSON(resultStr);
	    	
		    if (result.status == 0){
			    itemDoSearch();
			    receivedbatchDoSearch();
			    $('#dataModal').modal('hide');
		    } else if (result.status == 1) {
		    	alert('参数错误');
		    } else if(result.status == 2) {
		    	$('#receivebatchQtyErrorTbody').empty();
		    	$('#receivebatchOverdueErrorTbody').empty();
		    	$('#receivebatchErrorModal').modal('show');
		    	
		    	var qtyErrors = result.qtyErrors;
		    	if (qtyErrors && qtyErrors.length > 0) {
		    		for (var i = 0; i < qtyErrors.length; i++) {
		    			var rowStr = "<tr>" 
		    				+ "<td>" + qtyErrors[i].poNo + "</td>"
		    				+ "<td>" + qtyErrors[i].poItem + "</td>"
		    				+ "<td>" + qtyErrors[i].materialNo + "</td>"
		    				+ "<td>" + qtyErrors[i].qty + "</td>"
		    				+ "<td>" + qtyErrors[i].batchQty + "</td>"
		    			    + "</tr>";
		    			$('#receivebatchQtyErrorTbody').append(rowStr);
		    		}
		    	}
		    	
		    	var overdueErrors = result.overdueErrors;
		    	if (overdueErrors && overdueErrors.length > 0) {
		    		for (var i = 0; i < overdueErrors.length; i++) {
		    			var rowStr = "<tr>" 
		    				+ "<td>" + overdueErrors[i].poNo + "</td>"
		    				+ "<td>" + overdueErrors[i].poItem + "</td>"
		    				+ "<td>" + overdueErrors[i].materialNo + "</td>"
		    				+ "<td>" + overdueErrors[i].batchNo + "</td>"
		    				+ "<td>" + overdueErrors[i].produceTime + "</td>"
		    				+ "<td>" + overdueErrors[i].overdueTime + "</td>"
		    			    + "</tr>";
		    			$('#receivebatchOverdueErrorTbody').append(rowStr);
		    		}
		    	}
		    } else if (result.status == 3) {
		    	itemDoSearch();
				receivedbatchDoSearch();
				$('#dataModal').modal('hide');
		    	alert('收货失败 :' + result.sapError);
		    } else {
			    alert('系统错误。');
		    }
	      }
	    },
	    'html'
	    );
	} else {
		alert('请选择进口明细记录');
	}
}

function receivedbatchDoSearch(){
	var irNoV = $('input[id="batchIrNo"]').val();
	if (!irNoV) {
		irNoV = "empty";
	}
    $('#importBatchTable').bootstrapTable('selectPage', 1);
	$('#importBatchTable').bootstrapTable('refresh', {query:{irNo: irNoV, stat: null, page:1}});
}

function produceTimeFormatter(value, row, index) {
    if (value && value.length >= 19) {
	    return value.substring(0, 10);
    }

    return value;
}

function overdueTimeFormatter(value, row, index) {
    if (value && value.length >= 19) {
	    return value.substring(0, 10);
    }
    return value;
}

function isOverdueFormatter(value, row, index) {
	if (value == 0) {
	    return "N";
    } else {
    	return "<font color='red'>Y</font>";
    }
}

function mergeCells(data, filterFieldNames, fieldNames, target) {
	if (data.length == 0) {
	    return;
	}
	
	var numArr = [];
	var value = "";
	for (var j = 0; j < filterFieldNames.length; j++) {
		value += data[0][filterFieldNames[j]];
	}
	
	var num = 0;
	for (var i = 0; i < data.length; i++) {
		var cvalue = "";
		for (var j = 0; j < filterFieldNames.length; j++) {
			cvalue += "" + data[i][filterFieldNames[j]];
		}
		
	    if (value != cvalue) {
	        numArr.push(num);
	        value = cvalue;
	        num = 1;
	        continue;
	    }
	    num++;
	}
	numArr.push(num);
	
	var merIndex = 0;
	for (var i = 0; i < numArr.length; i++) {
		console.log(numArr[i]);
		for (var j = 0; j < fieldNames.length; j++) {
	        $(target).bootstrapTable('mergeCells', { index: merIndex, field: fieldNames[j], rowspan: numArr[i] })
		}
		
	    merIndex += numArr[i];
	}
	
	
}