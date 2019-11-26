function add(){
	
	$('input[name="eqTypeId"]').val("");
	$('input[name="module"]').val("");
	$('input[name="vendor"]').val("");
	$('input[name="model"]').val("");
	$('input[name="length"]').val("");
	$('input[name="width"]').val("");
	$('input[name="housing"]').val("");
	$('input[name="manMachine"]').val("");
	$('input[name="shift"]').val("");
	$('input[name="uph"]').val("");
	$('input[name="uptimeRate"]').val("");
	$('input[name="reworkRate"]').val("");
	$('input[name="scrapRate"]').val("");
	$('input[name="installationCost"]').val("");
	$('input[name="hookupCost"]').val("");
	$('input[name="installationHookupCost"]').val("");
	$('input[name="qualificationCost"]').val("");
	$('input[name="partsCost"]').val("");
	
	$('input[name="id"]').val("");
	$('#dataDiv').show();
	$('#listDiv').hide();

	
	$('#editForm input').attr("disabled", false);
	$('#editForm select').attr("disabled", false);
//  	$('#submitBtn').attr("disabled", false);
	$('#editForm input[name=lastModifiedTime]').attr("disabled", true);
	$('#editForm input[name=finalReviser]').attr("disabled", true);
	$('#saveBtn').show();
	$('#submitBtn').show();
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
	var selects = $('#proBaseTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var idV = selects[0].id;
		var eqTypeIdV = selects[0].eqTypeId;
		var moduleV = selects[0].module;
		var vendorV = selects[0].vendor;
		var modelV = selects[0].model;
		var userBaseIdV = selects[0].userBaseId;
		var purchasePriceV = selects[0].purchasePrice;		
		var taxV = selects[0].tax;
		var trainingCostV = selects[0].trainingCost;
		var mainServiceCostV = selects[0].mainServiceCost;
		var additionalCostV = selects[0].additionalCost;
		var addUserIdV = selects[0].addUserId;
		var updateUserIdV = selects[0].updateUserId;
	
		$('input[name="eqTypeId"]').val(eqTypeIdV);
		$('input[name="module"]').val(moduleV);
		$('input[name="vendor"]').val(vendorV);
		$('input[name="model"]').val(modelV);
		$('input[name="userBaseId"]').val(userBaseIdV);
		$('input[name="purchasePrice"]').val(purchasePriceV);
		$('input[name="tax"]').val(taxV);
		$('input[name="trainingCost"]').val(trainingCostV);
		$('input[name="mainServiceCost"]').val(mainServiceCostV);
		$('input[name="additionalCost"]').val(additionalCostV);
		$('input[name="addUserId"]').val(addUserIdV);
		$('input[name="updateUserId"]').val(updateUserIdV);
		
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
	$('#submitBtn').hide();	
	$('#addIrNoBtn').hide();
	
	$('#itemEditBtn').hide();
	$('#itemRemoveBtn').hide();
	$('#syncDiv').hide();
	
	$('#myTab a[href="#home"]').tab('show');
}

function edit(){
	var selects = $('#proBaseTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录编辑');
		return;
	}
	var isSubmitV= selects[0].isSubmit;
	$('input[id="isSubmit"]').val(isSubmitV);
	if(1 == isSubmitV){
	 alert('已提交！');
		 return;
	}
	
	putFormValue();
	
	$('#editForm input').attr("disabled", false);
	$('#editForm input[name=eqTypeId]').attr("disabled", true);
	$('#editForm input[name=module]').attr("disabled", true);
	$('#editForm input[name=vendor]').attr("disabled", true);
	$('#editForm input[name=model]').attr("disabled", true);
  	$('#saveBtn').attr("disabled", false);
  	$('#submitBtn').attr("disabled", false);
	$('#saveBtn').show();
	$('#submitBtn').show();
	$('#addIrNoBtn').show();
	
	$('#itemEditBtn').show();
	$('#itemRemoveBtn').show();
	$('#syncDiv').show();
	
	$('#myTab a[href="#home"]').tab('show');
  	$('#editForm input[name=addUserId]').attr("disabled", true);
  	$('#editForm input[name=updateUserId]').attr("disabled", true);
	
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

	var eqTypeIdV = $('input[name="eqTypeId"]').val();
	var moduleV = $('input[name="module"]').val();
	var vendorV = $('input[name="vendor"]').val();
	var modelV = $('input[name="model"]').val();
	var userBaseIdV = $('input[name="userBaseId"]').val();
	var purchasePriceV = $('input[name="purchasePrice"]').val();
	var taxV = $('input[name="tax"]').val();
	var trainingCostV = $('input[name="trainingCost"]').val();
	var mainServiceCostV = $('input[name="mainServiceCost"]').val();
	var additionalCostV = $('input[name="additionalCost"]').val();
	var addUserIdV = $('input[name="addUserId"]').val();
	var updateUserIdV = $('input[name="updateUserId"]').val();
	
	var idV = $('input[name="id"]').val();
	$('#saveBtn').attr("disabled", true);
	$.post('/coo/proBase/save',
		{
		eqTypeId: eqTypeIdV, module: moduleV, vendor: vendorV, model: modelV, userBaseId: userBaseIdV,
		purchasePrice: purchasePriceV, tax: taxV, trainingCost: trainingCostV, mainServiceCost: mainServiceCostV, additionalCost: additionalCostV, id:idV, 
		addUserId:addUserIdV, updateUserId:updateUserIdV
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
function prosubmit(){
	
	$("#editForm").bootstrapValidator("validate");
	if (!$("#editForm").data('bootstrapValidator').isValid()) {
		return;
	}

	var eqTypeIdV = $('input[name="eqTypeId"]').val();
	var moduleV = $('input[name="module"]').val();
	var vendorV = $('input[name="vendor"]').val();
	var modelV = $('input[name="model"]').val();
	var userBaseIdV = $('input[name="userBaseId"]').val();
	var purchasePriceV = $('input[name="purchasePrice"]').val();
	var taxV = $('input[name="tax"]').val();
	var trainingCostV = $('input[name="trainingCost"]').val();
	var mainServiceCostV = $('input[name="mainServiceCost"]').val();
	var additionalCostV = $('input[name="additionalCost"]').val();
	var addUserIdV = $('input[name="addUserId"]').val();
	var updateUserIdV = $('input[name="updateUserId"]').val();
	
	var idV = $('input[name="id"]').val();
	$('#submitBtn').attr("disabled", true);
	$.post('/coo/proBase/prosubmit',
		{
		eqTypeId: eqTypeIdV, module: moduleV, vendor: vendorV, model: modelV, userBaseId: userBaseIdV,
		purchasePrice: purchasePriceV, tax: taxV, trainingCost: trainingCostV, mainServiceCost: mainServiceCostV, additionalCost: additionalCostV, id:idV, 
		addUserId:addUserIdV, updateUserId:updateUserIdV
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
	var rows = $('#userBaseTable').bootstrapTable('getSelections');
	if (rows && rows.length > 0){
		var ids = new Array();
		for (var i = 0; i < rows.length; i++) {	
			var row = rows[i];
			ids.push(row.id);
		}
		
		$.post('/coo/userBase/delete',{ids: ids},function(result){
				doSearch();
		},'json');
	} else {
		alert('至少选择一条记录。');
	}
}

function doSearch() {
	var eqTypeIdV = $('input[id="eqTypeId"]').val();
	var vendorIdV = $('input[id="vendor"]').val();
	var modelIdV = $('input[id="model"]').val();
    
    $('#proBaseTable').bootstrapTable('selectPage', 1);
    $('#proBaseTable').bootstrapTable('refresh', {
		query : {
			eqTypeId : eqTypeIdV,
			vendor : vendorIdV,
			model : modelIdV,
			page : 1
		}
	});
}
function actionFormatter(value, row, index) {
	if (1 == value) {
		return "已提交";
	}
	
	if (0 == value) {
		return "未提交";
	}

}