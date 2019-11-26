function addIrNo() {
	var orgV = $('select[name="org"]').selectpicker('val');
	var freightTypeV = $('select[name="freightType"]').selectpicker('val');
	var goodsCodeV = $('select[name="goodsCode"]').selectpicker('val');
	
	if((orgV == "" || null == orgV)) {
		alert("ORG字段不能为空");
		return;
	}else if((freightTypeV == "" || null == freightTypeV)) {
		alert("FreightType字段不能为空");
		return;
	}else if((goodsCodeV == "" || null == goodsCodeV)) {
		alert("GoodsCode字段不能为空");
		return;
	}else {
		$.post('/importexport/importInfo/generateSeqNo', 
				{org: orgV, freightType: freightTypeV, goodsCode: goodsCodeV}, 
				function(result) {
					if (result) {
						$('input[name="irNo"]').val(result);
					} else {
						alert('系统错误');
					}
				}
		);
	}
	
}

function add(){
	
	$('select[name="org"]').selectpicker('val', "");
	$('select[name="freightType"]').selectpicker('val', "");
	$('select[name="goodsCode"]').selectpicker('val', "");
	$('input[name="irNo"]').val("");
	$('input[name="declarationNo"]').val("");
	$('input[name="declarationTime"]').val("");
	$('input[name="releaseTime"]').val("");
	$('input[name="arriveTime"]').val("");
	$('input[name="receiveTime"]').val("");
	$('input[name="sailingTime"]').val("");
	$('input[name="gw"]').val("");
	$('input[name="nw"]').val("");
	$('input[name="chw"]').val("");
	$('input[name="totalPackage"]').val("");
	$('select[name="packingType"]').selectpicker('val', "");
	$('input[name="recordNo"]').val("");
	$('input[name="unusual"]').prop('checked', false);
	$('input[name="unusual"][value="0"]').prop('checked', true);
	$('select[name="appType"]').selectpicker('val', "");
	$('input[name="broker"]').val("");
	$('input[name="forwarder"]').val("");
	$('select[name="freightTerm"]').selectpicker('val', "");
	$('input[name="bl"]').val("");
	$('input[name="mawb"]').val("");
	$('input[name="hawb"]').val("");
	$('input[name="flightVesselVoy"]').val("");
	$('select[name="shipFromCountry"]').selectpicker('val', "");
	$('select[name="shipFromPort"]').selectpicker('val', "");
	$('select[name="loadingPort"]').selectpicker('val', "");
	$('select[name="dischargePort"]').selectpicker('val', "");
	$('input[name="inhouseDate"]').val("");
	$('input[name="outhouseDate"]').val("");
	$('input[name="invoiceNo"]').val("");
	$('select[name="importCustom"]').selectpicker('val', "");
	$('input[name="lcNo"]').val("");
	$('input[name="containerNo"]').val("");
	$('select[name="carType"]').selectpicker('val', "");
	$('input[name="carNo"]').val("");
	$('input[name="rmaNO"]').val("");
	$('input[name="rmaQty"]').val("");
	$('input[name="originalDeclarationNo"]').val("");
	$('input[name="originalIrNo"]').val("");
	$('input[name="importPerson"]').val("");
	$('select[name="declaringCustom"]').selectpicker('val', "");
	$('select[name="originalCountry"]').selectpicker('val', "");
	$('select[name="tradingType"]').selectpicker('val', "");
	$('select[name="taxPreperty"]').selectpicker('val', "");

	$('input[name="lastModifiedTime"]').val(getNowFormatDate());
	$('input[name="remarks"]').val("");
	$('input[name="text1"]').val("");
	$('input[name="text2"]').val("");
	$('input[name="text3"]').val("");
	
	$('input[name="id"]').val("");
	$('#dataDiv').show();
	$('#listDiv').hide();

	
	$('#editForm input').attr("disabled", false);
	$('#editForm select').attr("disabled", false);
	$('#editForm input[name=lastModifiedTime]').attr("disabled", true);
	$('#editForm input[name=finalReviser]').attr("disabled", true);
	$('#saveBtn').show();
	$('#addIrNoBtn').show();
	
	$('#itemEditBtn').show();
	$('#itemRemoveBtn').show();
	$('#syncDiv').show();
	
	$('#myTab a[href="#home"]').tab('show');
	
	$("#editForm").bootstrapValidator("resetForm");
}

//获取当前时间，格式YYYY-MM-DD
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

function putFormValue() {
	var selects = $('#importInfoTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var idV = selects[0].id;
		var orgV = selects[0].org;
		var freightTypeV = selects[0].freightType;
		var goodsCodeV = selects[0].goodsCode;
		var irNoV = selects[0].irNo;
		var declarationNoV = selects[0].declarationNo;
		var declarationTimeV = selects[0].declarationTime;
		if (declarationTimeV && declarationTimeV.length >= 19) {
			declarationTimeV = declarationTimeV.substring(0, 10);
		}

		var releaseTimeV = selects[0].releaseTime;
		if (releaseTimeV && releaseTimeV.length >= 19) {
			releaseTimeV = releaseTimeV.substring(0, 10);
		}
		
		var arriveTimeV = selects[0].arriveTime;
		if (arriveTimeV && arriveTimeV.length >= 19) {
			arriveTimeV = arriveTimeV.substring(0, 10);
		}
		
		var receiveTimeV = selects[0].receiveTime;
		if (receiveTimeV && receiveTimeV.length >= 19) {
			receiveTimeV = receiveTimeV.substring(0, 10);
		}
		
		var sailingTimeV = selects[0].sailingTime;
		if (sailingTimeV && sailingTimeV.length >= 19) {
			sailingTimeV = sailingTimeV.substring(0, 10);
		}
		
		var inhouseDateV = selects[0].inhouseDate;
		if(inhouseDateV && inhouseDateV.length >= 19) {
			inhouseDateV = inhouseDateV.substring(0, 10);
		}
		
		var outhouseDateV = selects[0].outhouseDate;
		if(outhouseDateV && outhouseDateV.length >= 19) {
			outhouseDateV = outhouseDateV.substring(0, 10);
		}
		
		var lastModifiedTimeV = selects[0].lastModifiedTime;
		if(lastModifiedTimeV && lastModifiedTimeV.length >= 19) {
			lastModifiedTimeV = lastModifiedTimeV.substring(0, 10);
		}
		
		
		var gwV = selects[0].gw;
		var nwV = selects[0].nw;
		var chwV = selects[0].chw;
		var totalPackageV = selects[0].totalPackage;
		var packingTypeV = selects[0].packingType;
		var recordNoV = selects[0].recordNo;
		var unusualV = selects[0].unusual;
		var appTypeV = selects[0].appType;
		var brokerV = selects[0].broker;
		var forwarderV = selects[0].forwarder;
		var freightTermV = selects[0].freightTerm;
		var blV = selects[0].bl;
		var mawbV = selects[0].mawb;
		var hawbV = selects[0].hawb;
		var flightVesselVoyV = selects[0].flightVesselVoy;
		var shipFromCountryV = selects[0].shipFromCountry;
		var shipFromPortV = selects[0].shipFromPort;
		var loadingPortV = selects[0].loadingPort;
		var dischargePortV = selects[0].dischargePort;
		var invoiceNoV = selects[0].invoiceNo;
		var importCustomV = selects[0].importCustom;
		var importPortV = selects[0].importPort;
		var lcNoV = selects[0].lcNo;
		var containerNoV = selects[0].containerNo;
		var carTypeV = selects[0].carType;
		var carNoV = selects[0].carNo;
		var rmaNoV = selects[0].rmaNo;
		var rmaQtyV = selects[0].rmaQty;
		var originalDeclarationNoV = selects[0].originalDeclarationNo;
		var originalIrNoV = selects[0].originalIrNo;
		var importPersonV = selects[0].importPerson;
		var finalReviserV = selects[0].finalReviser;
		var remarksV = selects[0].remarks;
		var declaringCustomV = selects[0].declaringCustom;
		var originalCountryV = selects[0].originalCountry;
		var tradingTypeV = selects[0].tradingType;
		var taxPrepertyV = selects[0].taxPreperty;
		var tariffTaxV = selects[0].tariffTax;
		var tariffV = selects[0].tariff;
		var valueAddedTaxV = selects[0].valueAddedTax;
		var text1V = selects[0].text1;
		var text2V = selects[0].text2;
		var text3V = selects[0].text3;
		
		$('select[name="org"]').selectpicker('val', orgV);
		$('select[name="freightType"]').selectpicker('val', freightTypeV);
		$('select[name="goodsCode"]').selectpicker('val', goodsCodeV);
		$('input[name="irNo"]').val(irNoV);
		$('input[name="declarationNo"]').val(declarationNoV);
		$('input[name="declarationTime"]').val(declarationTimeV);
		$('input[name="releaseTime"]').val(releaseTimeV);
		$('input[name="arriveTime"]').val(arriveTimeV);
		$('input[name="receiveTime"]').val(receiveTimeV);
		$('input[name="sailingTime"]').val(sailingTimeV);
		$('input[name="gw"]').val(gwV);
		$('input[name="nw"]').val(nwV);
		$('input[name="chw"]').val(chwV);
		$('input[name="totalPackage"]').val(totalPackageV);
		$('select[name="packingType"]').selectpicker('val', packingTypeV);
		$('input[name="recordNo"]').val(recordNoV);
		$('input[name="unusual"]').prop('checked', false);
		$('input[name="unusual"][value="' + unusualV + '"]').prop('checked', true);
		$('select[name="appType"]').selectpicker('val', appTypeV);
		$('input[name="broker"]').val(brokerV);
		$('input[name="forwarder"]').val(forwarderV);
		$('select[name="freightTerm"]').selectpicker('val', freightTermV);
		$('input[name="bl"]').val(blV);
		$('input[name="mawb"]').val(mawbV);
		$('input[name="hawb"]').val(hawbV);
		$('input[name="flightVesselVoy"]').val(flightVesselVoyV);
		$('select[name="shipFromCountry"]').selectpicker('val', shipFromCountryV);
		$('select[name="shipFromPort"]').selectpicker('val', shipFromPortV);
		$('select[name="loadingPort"]').selectpicker('val', loadingPortV);
		$('select[name="dischargePort"]').selectpicker('val', dischargePortV);
		$('input[name="inhouseDate"]').val(inhouseDateV);
		$('input[name="outhouseDate"]').val(outhouseDateV);
		$('input[name="invoiceNo"]').val(invoiceNoV);
		$('select[name="importCustom"]').selectpicker('val', importCustomV);
		$('input[name="lcNo"]').val(lcNoV);
		$('input[name="containerNo"]').val(containerNoV);
		$('select[name="carType"]').selectpicker('val', carTypeV);
		$('input[name="carNo"]').val(carNoV);
		$('input[name="rmaNo"]').val(rmaNoV);
		$('input[name="rmaQty"]').val(rmaQtyV);
		$('input[name="originalDeclarationNo"]').val(originalDeclarationNoV);
		$('input[name="originalIrNo"]').val(originalIrNoV);
		$('input[name="importPerson"]').val(importPersonV);
		$('input[name="finalReviser"]').val(finalReviserV);
		$('input[name="lastModifiedTime"]').val(lastModifiedTimeV);
		$('input[name="remarks"]').val(remarksV);
		$('select[name="declaringCustom"]').selectpicker('val', declaringCustomV);
		$('select[name="originalCountry"]').selectpicker('val', originalCountryV);
		$('select[name="tradingType"]').selectpicker('val', tradingTypeV);
		$('select[name="taxPreperty"]').selectpicker('val', taxPrepertyV);
		$('input[name="tariffTax"]').val(tariffTaxV);
		$('input[name="tariff"]').val(tariffV);
		$('input[name="valueAddedTax"]').val(valueAddedTaxV);
		$('input[name="text1"]').val(text1V);
		$('input[name="text2"]').val(text2V);
		$('input[name="text3"]').val(text3V);
		
		$('input[name="id"]').val(idV);

		$('#dataDiv').show();
		$('#listDiv').hide();
		
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
	$('#editForm select').attr("disabled", true);
	$('#saveBtn').hide();
	$('#addIrNoBtn').hide();
	
	$('#itemEditBtn').hide();
	$('#itemRemoveBtn').hide();
	$('#syncDiv').hide();
	
	$('#myTab a[href="#home"]').tab('show');
}

function edit(){
	var selects = $('#importInfoTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录编辑');
		return;
	}
	
	if(selects[0].status != 0) {
		alert("只能编辑状态为已保存的记录");
		return;
	}
	
	
	putFormValue();
	
	$('#editForm input').attr("disabled", false);
	$('#editForm select').attr("disabled", false);
	$('#editForm input[name=lastModifiedTime]').attr("disabled", true);
	$('#editForm input[name=finalReviser]').attr("disabled", true);
	
	$('#saveBtn').show();
	$('#addIrNoBtn').show();
	
	$('#itemEditBtn').show();
	$('#itemRemoveBtn').show();
	$('#syncDiv').show();
	
	$('#myTab a[href="#home"]').tab('show');
	
	$("#editForm").bootstrapValidator("resetForm");
}

function closeDataDiv() {
	$('#dataDiv').hide();
	$('#listDiv').show();
}

function save(){
	$("#editForm").bootstrapValidator("validate");
	if (!$("#editForm").data('bootstrapValidator').isValid()) {
		return;
	}
	
	var orgV = $('select[name="org"]').selectpicker('val');
	var freightTypeV = $('select[name="freightType"]').selectpicker('val');
	var goodsCodeV = $('select[name="goodsCode"]').selectpicker('val');
	var irNoV = $('input[name="irNo"]').val();
	var declarationNoV = $('input[name="declarationNo"]').val();
	var declarationTimeV = $('input[name="declarationTime"]').val();
	var releaseTimeV = $('input[name="releaseTime"]').val();
	var arriveTimeV = $('input[name="arriveTime"]').val();
	var receiveTimeV = $('input[name="receiveTime"]').val();
	var sailingTimeV = $('input[name="sailingTime"]').val();
	var gwV = $('input[name="gw"]').val();
	var nwV = $('input[name="nw"]').val();
	var chwV = $('input[name="chw"]').val();
	var totalPackageV = $('input[name="totalPackage"]').val();
	var packingTypeV = $('select[name="packingType"]').selectpicker('val');
	var recordNoV = $('input[name="recordNo"]').val();
	var tradingTypeV = $('select[name="tradingType"]').val();
	var taxPrepertyV = $('select[name="taxPreperty"]').val();
	var tariffTaxV = $('input[name="tariffTax"]').val();
	var tariffV = $('input[name="tariff"]').val();
	var valueAddedTaxV = $('input[name="valueAddedTax"]').val();
	
	var unusualV = 0;
	if ($('#unusual1').prop('checked')) {
		unusualV = 1;
	}
	
	var appTypeV = $('select[name="appType"]').selectpicker('val');
	var brokerV = $('input[name="broker"]').val();
	var forwarderV = $('input[name="forwarder"]').val();
	var freightTermV = $('select[name="freightTerm"]').selectpicker('val');
	var blV = $('input[name="bl"]').val();
	var mawbV = $('input[name="mawb"]').val();
	var hawbV = $('input[name="hawb"]').val();
	var flightVesselVoyV = $('input[name="flightVesselVoy"]').val();
	var shipFromCountryV = $('select[name="shipFromCountry"]').selectpicker('val');
	var shipFromPortV = $('select[name="shipFromPort"]').selectpicker('val');
	var loadingPortV = $('select[name="loadingPort"]').selectpicker('val');
	var dischargePortV = $('select[name="dischargePort"]').selectpicker('val');
	var inhouseDateV = $('input[name="inhouseDate"]').val();
	var outhouseDateV = $('input[name="outhouseDate"]').val();
	var invoiceNoV = $('input[name="invoiceNo"]').val();
	var importCustomV = $('select[name="importCustom"]').selectpicker('val');
	var lcNoV = $('input[name="lcNo"]').val();
	var containerNoV = $('input[name="containerNo"]').val();
	var carTypeV = $('select[name="carType"]').selectpicker('val');
	var carNoV = $('input[name="carNo"]').val();
	var rmaNoV = $('input[name="rmaNo"]').val();
	var rmaQtyV = $('input[name="rmaQty"]').val();
	var originalDeclarationNoV = $('input[name="originalDeclarationNo"]').val();
	var originalIrNoV = $('input[name="originalIrNo"]').val();
	var importPersonV = $('input[name="importPerson"]').val();
	var finalReviserV = $('input[name="finalReviser"]').val();
	var lastModifiedTimeV = $('input[name="lastModifiedTime"]').val();
	var remarksV = $('input[name="remarks"]').val();
	var declaringCustomV = $('select[name="declaringCustom"]').selectpicker('val');
	var originalCountryV = $('select[name="originalCountry"]').selectpicker('val');
	var text1V = $('input[name="text1"]').val();
	var text2V = $('input[name="text2"]').val();
	var text3V = $('input[name="text3"]').val();
	
	var idV = $('input[name="id"]').val();
	$.post('/importexport/importInfo/save',
		{
		org: orgV, freightType: freightTypeV, goodsCode: goodsCodeV, irNo: irNoV, declarationNo: declarationNoV, 
		declarationTime: declarationTimeV, releaseTime: releaseTimeV, arriveTime: arriveTimeV, receiveTime: receiveTimeV, 
		sailingTime: sailingTimeV, gw: gwV, nw: nwV, chw: chwV, totalPackage:totalPackageV, packingType: packingTypeV, 
		recordNo: recordNoV, unusual: unusualV, appType: appTypeV, broker: brokerV, forwarder: forwarderV, freightTerm: freightTermV,
		bl: blV, mawb: mawbV, hawb: hawbV, flightVesselVoy: flightVesselVoyV, shipFromCountry: shipFromCountryV,
		shipFromPort: shipFromPortV, loadingPort: loadingPortV, dischargePort: dischargePortV, inhouseDate: inhouseDateV,
		outhouseDate: outhouseDateV, invoiceNo: invoiceNoV, importCustom: importCustomV,
		lcNo: lcNoV, containerNo: containerNoV, carType: carTypeV, carNo: carNoV, rmaNo: rmaNoV, rmaQty: rmaQtyV,
		originalDeclarationNo: originalDeclarationNoV, originalIrNo: originalIrNoV, importPerson: importPersonV,
		finalReviser: finalReviserV, lastModifiedTime: lastModifiedTimeV, remarks: remarksV, id: idV, 
		declaringCustom: declaringCustomV, originalCountry: originalCountryV, tradingType: tradingTypeV,
		tariffTax: tariffTaxV, tariff: tariffV, valueAddedTax: valueAddedTaxV, taxPreperty: taxPrepertyV, 
		text1: text1V, text2: text2V, text3: text3V
		},
		function(result){
		if (result){
			doSearch();
			$('#dataDiv').hide();
			$('#listDiv').show();
		} else {
			alert('系统错误');
		}
	},'json');
}

function remove(){
	var rows = $('#importInfoTable').bootstrapTable('getSelections');
	if (rows && rows.length > 0){
		var ids = new Array();
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			if (row.status != 0) {
				alert("只能删除状态为已保存的记录");
				return;
			}
			
			ids.push(row.id);
		}
		
		$.post('/importexport/importInfo/delete',{ids: ids},function(result){
			if (result == -1) {
				alert("删除进口信息之前，需要先删除进口明细信息");
				$.messager.show({
					title: '错误',
					msg: '删除进口信息之前，需要先删除进口明细信息'
				});
			} else if (result == -2) {
				alert("删除进口信息之前，需要先删除批次信息");
			} else if (result == 0){
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

function doSearch() {
	var irNoV = $('input[id="irNo"]').val();
    
    $('#importInfoTable').bootstrapTable('selectPage', 1);
	$('#importInfoTable').bootstrapTable('refresh', {query:{irNo: irNoV, page:1}});
}
function upload() {
	var formData = new FormData();
	// 获取文件
	var fileData = $("#fileName").prop("files")[0];
	formData.append("file", fileData);
	
	$.ajax({
        url: "/importexport/importInfo/upload",
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
        		doSearch();
        	}else{
        		alert(data.msg);
        	}
        }
    });	
}

function addedTaxEdit(){
	var selects = $('#importInfoTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var valueAddedTaxV = selects[0].valueAddedTax;
		var tariffTaxV = selects[0].tariffTax;
		var idV = selects[0].id;
		$('input[name="addedTaxValue"]').val(valueAddedTaxV);
		$('input[name="addTariffTax"]').val(tariffTaxV);
		$('input[name="importId"]').val(idV);
		$('#addTaxModal').modal('show');
	}else{
		alert("请选择一条记录");
	}
}

function addTaxSave(){
	var idV = $('input[name="importId"]').val();
	var addedTaxValueV = $('input[name="addedTaxValue"]').val();
	var tariffTaxV = $('input[name="addTariffTax"]').val();
	$.post('/importexport/importInfo/save',
		{id: idV, valueAddedTax: addedTaxValueV, tariffTax: tariffTaxV},
		function(result){
		if (result){
			doSearch();
			$('#addTaxModal').modal('hide');
		} else {
			alert('系统错误');
		}
	},'json');
}