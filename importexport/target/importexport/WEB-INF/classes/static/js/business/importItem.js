function sync() {
	var poNoV = $('input[id="poNo"]').val();
	var importIdV = $('input[name="id"]').val();
	
	if (!importIdV) {
		alert("请先创建进口基本信息");
		return;
	}
	
	$.post('/importexport/importItem/sync',
		{
		    poNo: poNoV, importId: importIdV
		},
		
		function(result){
		    if (result == 0) {
		    	itemDoSearch();
		    } else if (result == 1) {
		    	alert("参数不正确");
		    } else if (result == 2) {
		    	alert("已同步");
		    } else {
			    alert('系统错误');
		    }
	    },
	    'html'
	);
}

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
		var deptV = selects[0].dept;
		var employeeNoV = selects[0].employeeNo;
		var stockV = selects[0].stock;
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
		if(assetNoV == null){
			$('input[name="assetNo"]').val('');
		}else{
			$('input[name="assetNo"]').val(assetNoV);
		}
		$('input[name="tradeTerm"]').val(tradeTermV);
		$('input[name="chineseName"]').val(chineseNameV);
		$('input[name="hsCode"]').val(hsCodeV);
		$('input[name="grNo"]').val(grNoV);
		$('input[name="dept"]').val(deptV);
		$('input[name="employeeNo"]').val(employeeNoV);
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

function itemEdit(){
	if (!putItemValue()) {
	    alert('只能选择一条记录编辑');
	    return;
	}
	
	$('#itemEditForm input').attr("disabled", false);
	$('#itemEditForm select').attr("disabled", false);

	$('input[name="poNo"]').attr("disabled", true);
	$('input[name="vendor"]').attr("disabled", true);
	$('input[name="goodsDesc"]').attr("disabled", true);
	$('input[name="poItem"]').attr("disabled", true);
	$('input[name="materialNo"]').attr("disabled", true);
	$('input[name="assetNo"]').attr("disabled", true);
	$('input[name="unit"]').attr("disabled", true);
	$('input[name="employeeNo"]').attr("disabled", true);
	$('#itemSaveBtn').show();
}

function itemSave(){
	var poNoV = $('input[name="poNo"]').val();
	var poItemV = $('input[name="poItem"]').val();
	var vendorV = $('input[name="vendor"]').val();
	var materialNoV = $('input[name="materialNo"]').val();
	var goodsDescV = $('input[name="goodsDesc"]').val();
	var unitV = $('input[name="unit"]').val();
	var qtyV =  $('input[name="qty"]').val();
	var unitPriceV = $('input[name="unitPrice"]').val();
	var totalAmountV = $('input[name="totalAmount"]').val();
	var currencyV =  $('input[name="currency"]').val();
	var assetNoV = $('input[name="assetNo"]').val();
	var tradeTermV = $('input[name="tradeTerm"]').val();
	var chineseNameV = $('input[name="chineseName"]').val();
	var hsCodeV = $('input[name="hsCode"]').val();
	var grNoV = $('input[name="grNo"]').val();
	var deptV = $('input[name="dept"]').val();
	var employeeNoV = $('input[name="employeeNo"]').val();
	var stockV = $('input[name="stock"]').val();
	var tariffRateV = $('input[name="tariffRate"]').val();
	var tradingUnitV = $('input[name="tradingUnit"]').val();
	var transactionVolumeV = $('input[name="transactionVolume"]').val();
	var legalUnitV = $('input[name="legalUnit"]').val();
	var legalQuantityV = $('input[name="legalQuantity"]').val();
	var isEditV = 1;
	
	var idV = $('input[name="itemId"]').val();
	$.post('/importexport/importItem/save',
		{
		  poNo: poNoV, poItem: poItemV, vendor: vendorV, materialNo: materialNoV, goodsDesc: goodsDescV,
		  unit: unitV, qty: qtyV, unitPrice: unitPriceV, totalAmount: totalAmountV, currency: currencyV,
		  assetNo: assetNoV, tradeTerm: tradeTermV, chineseName: chineseNameV, hsCode: hsCodeV, grNo: grNoV, dept: deptV, employeeNo: employeeNoV, stock: stockV, isEdit: isEditV,
		  id: idV, tradingUnit: tradingUnitV, transactionVolume: transactionVolumeV, tariffRate: tariffRateV,
		  legalUnit: legalUnitV, legalQuantity: legalQuantityV
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

function itemRemove(){
	var rows = $('#importItemTable').bootstrapTable('getSelections');
	if (rows && rows.length > 0){
		var ids = new Array();
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			var grNo = row.grNo;
			if(grNo != "" && grNo != null) {
				alert("grNo: "+grNo+"已经执行过收货不允许删除");
				return;
			}
			ids.push(row.id);
		}
		
		$.post('/importexport/importItem/delete',{ids: ids},function(result){
			if (result){
				itemDoSearch();
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

function itemDoSearch() {
	var irNoV = $('input[id="itemIrNo"]').val();
	if (!irNoV) {
		irNoV = "empty";
	}
    
    $('#importItemTable').bootstrapTable('selectPage', 1);
	$('#importItemTable').bootstrapTable('refresh', {query:{irNo: irNoV, page:1}});
}
