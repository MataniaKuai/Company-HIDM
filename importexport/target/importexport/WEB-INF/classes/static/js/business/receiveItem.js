
function putItemValue() {
	var selects = $('#importItemTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var idV = selects[0].id;
		var poNoV = selects[0].poNo;
		var poItemV = selects[0].poItem;
		var vendorV = selects[0].vendor;
		var materialNoV = selects[0].materialNo;
		var goodsDescV = selects[0].goodsDesc;
		var unitV = selects[0].unit;
		var qtyV =  selects[0].qty;
		var unitPriceV = selects[0].unitPrice;
		var totalAmountV = selects[0].totalAmount;
		var currencyV =  selects[0].currency;
		var assetNoV = selects[0].assetNo;
		var childAssetNoV = selects[0].childAssetNo;
		var tradeTermV = selects[0].tradeTerm;
		var chineseNameV = selects[0].chineseName;
		var hsCodeV = selects[0].hsCode;
		var grNoV = selects[0].grNo;
		var stockV = selects[0].stock;
		var statusV = selects[0].status;
		var tariffRateV = selects[0].tariffRate;
		var tradingUnitV = selects[0].tradingUnit;
		var transactionVolumeV = selects[0].transactionVolume;
		var legalUnitV = selects[0].legalUnit;
		var legalQuantityV = selects[0].legalQuantity;
		
		$('input[name="poNo"]').val(poNoV);
		$('input[name="poItem"]').val(poItemV);
		$('input[name="vendor"]').val(vendorV);
		$('input[name="materialNo"]').val(materialNoV);
		$('input[name="goodsDesc"]').val(goodsDescV);
		$('input[name="unit"]').val(unitV);
		$('input[name="qty"]').val(qtyV);
		$('input[name="unitPrice"]').val(unitPriceV);
		$('input[name="totalAmount"]').val(totalAmountV);
		$('input[name="currency"]').val(currencyV);
		$('input[name="assetNo"]').val(assetNoV);
		$('input[name="childAssetNo"]').val(childAssetNoV);
		$('input[name="tradeTerm"]').val(tradeTermV);
		$('input[name="chineseName"]').val(chineseNameV);
		$('input[name="hsCode"]').val(hsCodeV);
		$('input[name="grNo"]').val(grNoV);
		$('input[name="stock"]').val(stockV);

		$('input[name="tariffRate"]').val(tariffRateV);
		$('input[name="tradingUnit"]').val(tradingUnitV);
		$('input[name="transactionVolume"]').val(transactionVolumeV);
		$('input[name="legalUnit"]').val(legalUnitV);
		$('input[name="legalQuantity"]').val(legalQuantityV);
		$('input[name="itemId"]').val(idV);
		$('#dataModal').modal('show');
		
		return true;
	}
	
	return false;
}

function itemView() {
	if (!putItemValue()) {
	    alert('只能选择一条记录查看');
	    return;
	}
	
	$('#itemEditForm input').attr("disabled", true);
	$('#itemEditForm select').attr("disabled", true);
	$('#itemSaveBtn').hide();
}

function editStock() {
	var selects = $('#importItemTable').bootstrapTable('getSelections');
	if(selects.length > 1) {
		alert('只能选择一条记录查看');
	    return;
	}
	var idV = selects[0].id;
	var stockV = selects[0].stock;
	$('input[name="itemStock"]').val(stockV);
	$('input[name="itemId"]').val(idV);
}

function itemSave(){
	var stockV = $('input[name="stock"]').val();
	var idV = $('input[name="itemId"]').val();
	$.post('/importexport/importItem/save',
		{
		  stock: stockV,
		  id: idV
		},
		function(result){
		    if (result){
			    itemDoSearch();
			    $('#dataModal').modal('hide');
		    } else {
			    alert('系统错误');
		    }
	    },
	    'json'
	);
}

function receiveItems(){
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
	
	var selects = $('#importItemTable').bootstrapTable('getSelections');
	if (selects.length > 0) {
		var itemIdsV = new Array()
		var stocksV = new Array();
		
		for (var i = 0; i < selects.length; i++) {
			var idV = selects[i].id;
			var grNoV = selects[i].grNo;
			var stockV = $("#stock_"+idV).val();
			var itemStatus = selects[i].status;
			var itemIsBatch = selects[i].isBatch;
			if (itemStatus == 1) {
				alert("不能重复收货");
				return
			}
			if(itemIsBatch != isBatchV){
				alert("批次类型不匹配");
				return
			}
			stocksV[i] = stockV;
			itemIdsV[i] = idV;
		}
	    $.post('/importexport/receive/receive', {itemIds : itemIdsV, importId : importIdV, isBatch : isBatchV, stocks: stocksV},
		function(resultStr) {
	      if (resultStr) {
	    	var result = $.parseJSON(resultStr);
		    if (result.status == 0){
			    itemDoSearch();
			    $('#dataModal').modal('hide');
		    } else if (result.status == 1) {
		    	alert('参数错误');
		    } else if(result.status == 2) {
		    	$('#receiveQtyErrorTbody').empty();
		    	$('#receiveOverdueErrorTbody').empty();
		    	$('#receiveErrorModal').modal('show');
		    	
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
		    			$('#receiveQtyErrorTbody').append(rowStr);
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
		    			$('#receiveOverdueErrorTbody').append(rowStr);
		    		}
		    	}
		    } else if (result.status == 3) {
		    	itemDoSearch();
			    $('#dataModal').modal('hide');
			    alert('收货失败 :'+result.sapError);
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

function unReceiveItems(){
	var statusV = $('input[name="status"]').val();
	var importIdV = $('input[name="id"]').val();
	
	if (statusV != 1) {
		alert("只有已经Release的记录才能收货");
		return;
	}
	
	var selects = $('#importItemTable').bootstrapTable('getSelections');
	if (selects.length > 0) {
		var itemIdsV = new Array()
		
		for (var i = 0; i < selects.length; i++) {
			var idV = selects[i].id;
			var grNoV = selects[i].grNo;
			
			if (!grNoV || grNoV.trim().length == 0) {
				alert("只有先收货才能取消收货");
				return
			}
			
			itemIdsV[i] = idV;
		}
	
	    $.post('/importexport/receive/unReceive', {itemIds : itemIdsV, importId : importIdV},
		function(result) {
		    if (result){
			    itemDoSearch();
			    $('#dataModal').modal('hide');
		    } else {
			    alert('系统错误');
		    }
	    },
	    'html'
	    );
	} else {
		alert('请选择进口明细记录');
	}
}

function itemDoSearch() {
	var irNoV = $('input[id="itemIrNo"]').val();
	if (!irNoV) {
		irNoV = "empty";
	}
    
    $('#importItemTable').bootstrapTable('selectPage', 1);
	$('#importItemTable').bootstrapTable('refresh', {query:{irNo: irNoV, page:1}});
}

function statusFormatter(value, row, index) {
    if (value == 0) {
   	 return "未收货";
    }

    if (value == 1) {
   	 return "已收货";
    }
}