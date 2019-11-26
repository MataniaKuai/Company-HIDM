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
	$('input[name="totalUtilityCost"]').val("");
	$('input[name="totalMaterialCost"]').val("");
	
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
	var selects = $('#ieBaseTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var idV = selects[0].id;
		var eqTypeIdV = selects[0].eqTypeId;
		var moduleV = selects[0].module;
		var vendorV = selects[0].vendor;
		var modelV = selects[0].model;
		var userBaseIdV = selects[0].userBaseId;
		var lengthV = selects[0].length;		
		var widthV = selects[0].width;
		var housingV = selects[0].housing;
		var manMachineV = selects[0].manMachine;
		var shiftV = selects[0].shift;
		var uphV = selects[0].uph;
		var uptimeRateV = selects[0].uptimeRate;
		var reworkRateV = selects[0].reworkRate;
		var scrapRateV = selects[0].scrapRate;
		var installationCostV = selects[0].installationCost;
		var hookupCostV = selects[0].hookupCost;
		var installationHookupCostV = selects[0].installationHookupCost;
		var qualificationCostV = selects[0].qualificationCost;
		var partsCostV = selects[0].partsCost;
		
		var waferCostReworkV = selects[0].waferCostRework;
		var waferCostScrapV = selects[0].waferCostScrap;
		var operationalV = selects[0].operational;
		var operatertV = selects[0].operatert;
		
		var operateLaborSalaryV = selects[0].operateLaborSalary;
		var maintainLaborSalaryV = selects[0].maintainLaborSalary;
		var operateLaborCostV = selects[0].operateLaborCost;
		var maintainLaborCostV = selects[0].maintainLaborCost;
		var floorCostV = selects[0].floorCost;
		var floorCostAcountV = selects[0].floorCostAcount;
		var totalUtilityCostV = selects[0].totalUtilityCost;
		var totalMaterialCostV = selects[0].totalMaterialCost;
	
		$('input[name="eqTypeId"]').val(eqTypeIdV);
		$('input[name="module"]').val(moduleV);
		$('input[name="vendor"]').val(vendorV);
		$('input[name="model"]').val(modelV);
		$('input[name="userBaseId"]').val(userBaseIdV);
		$('input[name="length"]').val(lengthV);
		$('input[name="width"]').val(widthV);
		$('input[name="housing"]').val(housingV);
		$('input[name="manMachine"]').val(manMachineV);
		$('input[name="shift"]').val(shiftV);
		$('input[name="uph"]').val(uphV);
		$('input[name="uptimeRate"]').val(uptimeRateV);
		$('input[name="reworkRate"]').val(reworkRateV);
		$('input[name="scrapRate"]').val(scrapRateV);
		$('input[name="installationCost"]').val(installationCostV);
		$('input[name="hookupCost"]').val(hookupCostV);
		$('input[name="installationHookupCost"]').val(installationHookupCostV);
		$('input[name="qualificationCost"]').val(qualificationCostV);
		$('input[name="partsCost"]').val(partsCostV);
		
		$('input[name="waferCostRework"]').val(waferCostReworkV);
		$('input[name="waferCostScrap"]').val(waferCostScrapV);
		$('input[name="operational"]').val(operationalV);
		$('input[name="operatert"]').val(operatertV);
		
		$('input[name="operateLaborSalary"]').val(operateLaborSalaryV);
		$('input[name="maintainLaborSalary"]').val(maintainLaborSalaryV);
		$('input[name="operateLaborCost"]').val(operateLaborCostV);
		$('input[name="maintainLaborCost"]').val(maintainLaborCostV);
		$('input[name="floorCost"]').val(floorCostV);
		$('input[name="floorCostAcount"]').val(floorCostAcountV);
		$('input[name="totalUtilityCost"]').val(totalUtilityCostV);
		$('input[name="totalMaterialCost"]').val(totalMaterialCostV);
		
		//根据userBaseID 查询 Utlity Name,Utility No,Utility Unit,Usage By Year Utility
		$.post('/coo/utilityCostItem/searchInfo',
				{
				userBaseId: userBaseIdV
				},
				function(result){
				if (result){
					$('#displayUtility').empty();
					$('#addUtilityGrpBtn').hide();
					html='<div class="input-group utility" style="width:100%;padding:0 0 1px 0;">'+
					'<label class="input-group-addon" style="width:40%">Utility Name(Utility_No,Utility_Unit)</label>'+
					'<label class="input-group-addon" style="width:20%">Usage By Year Utility</label>'+
					'<label class="input-group-addon" style="width:20%">Price Utility</label>' + 
					'<label class="input-group-addon" style="width:20%">Coefficient Utility</label>' + 
					'</div>';
					$('#displayUtility').append(html);
					for (var i=0; i < result.length; i++)
					{
						var price ;
						var coefficient ;
		    	        var item = result[i];
		    			$.ajax({
		    	            url: "/coo/utility/searchInfoByUtilityNo",
		    	            type: 'POST',
		    	            cache: false,
		    	            data: {utilityNo: item.utility},
		    	            dataType:"json",
		    	    		async:false,
		    	            success: function(result1) {
		    	            	if (result1){
									price=result1[0].utilityPrice;
		    						if (price == null) {
		    							price = '';
	    						    } 
									coefficient=result1[0].coefficient;
									str = "";
					    	        str = result1[0].utilityName + "(" + result1[0].utilityNo + ":" + result1[0].utilityUnit + ")";
					    	        html = '<div class="input-group utility" style="width:100%;padding:0 0 1px 0;">'+
					    	        '<label class="input-group-addon" style="width:40%">' + str + '</label>'+
									'<label class="input-group-addon" style="width:20%">' + item.usageByYear + '</label>'+
									'<label class="input-group-addon" style="width:20%">' + price + '</label>'+
									'<label class="input-group-addon" style="width:20%">' + coefficient + '</label>'+
									'</div>';
					    	        $('#displayUtility').append(html);
								} else {
									alert('系统错误');
								}
		    	            }
		    	        });
					}
					
				} else {
					alert('系统错误');
				}
			},'json');
		
		//根据userBaseID 查询 Materials Name,Materials No,Bom Unit,Usage By Year Utility
		$.post('/coo/materialsCostItem/searchInfo',
				{
				userBaseId: userBaseIdV
				},
				function(result){
				$('#displayMaterial').empty();
				$('#addMaterialsGrpBtn').show();
				html='<div class="input-group material" style="width:100%;padding:0 0 1px 0;">'+
				'<label class="input-group-addon" style="width:40%">Material_Name(Material_No,BOM_Unit)</label>'+
				'<label class="input-group-addon" style="width:20%">Usage By KWafer Material</label>'+
				'<label class="input-group-addon" style="width:20%">Price Material</label>' + 
				'<label class="input-group-addon" style="width:20%">Coefficient Material</label>' + 
				'</div>';
				$('#displayMaterial').append(html);
				if (result){
					for (var i=0; i < result.length; i++)
					{
		    	        var item = result[i];
		    	        var price ;
						var coefficient ;
						$.ajax({
		    	            url: "/coo/materialCoefficient/searchInfoByMaterialNo",
		    	            type: 'POST',
		    	            cache: false,
		    	            data: {materialNo: item.materialNo},
		    	            dataType:"json",
		    	    		async:false,
		    	            success: function(result1) {
		    	            	if (result1){
		    						price=result1[0].materialPrice;
									coefficient=result1[0].coefficient;
									str = result1[0].materialName + "(" + result1[0].materialNo + ":" + result1[0].bomUnit + ")";
									html = '<div class="input-group material" style="width:100%;padding:0 0 1px 0;">'+
					    	        '<label class="input-group-addon" style="width:40%">' + str + '</label>'+
									'<label class="input-group-addon" style="width:20%">' + item.usageByYear + '</label>'+
									'<label class="input-group-addon" style="width:20%">' + price + '</label>'+
									'<label class="input-group-addon" style="width:20%">' + coefficient + '</label>'+
									'</div>';
					    	        $('#displayMaterial').append(html);
		    					} else {
		    						alert('系统错误');
		    					}
		    	            }
		    	        });
					}
				} else {
					alert('系统错误');
				}
			},'json');
		
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
	
	$('#myTab a[href="#home"]').tab('show');
}

function edit(){
	var selects = $('#ieBaseTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录编辑');
		return;
	}
	
	putFormValue();
	
	$('#editForm input').attr("disabled", true);
	$('#editForm input[name=eqTypeId]').attr("disabled", true);
	$('#editForm input[name=module]').attr("disabled", true);
	$('#editForm input[name=vendor]').attr("disabled", true);
	$('#editForm input[name=model]').attr("disabled", true);
	$('#saveBtn').show();
	
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

	var eqTypeIdV = $('input[name="eqTypeId"]').val();
	var moduleV = $('input[name="module"]').val();
	var vendorV = $('input[name="vendor"]').val();
	var modelV = $('input[name="model"]').val();
	var userBaseIdV = $('input[name="userBaseId"]').val();
	var housingV = $('input[name="housing"]').val();
	var idV = $('input[name="id"]').val();
	
	$.post('/coo/ieBase/save',
		{
		eqTypeId: eqTypeIdV, module: moduleV, vendor: vendorV, model: modelV, userBaseId: userBaseIdV,
		housing:housingV,id:idV
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
	var vendorV = $('input[id="vendor"]').val();
	var modelV = $('input[id="model"]').val();        
    $('#ieBaseTable').bootstrapTable('selectPage', 1);
	$('#ieBaseTable').bootstrapTable('refresh', {query:{eqTypeId: eqTypeIdV, vendor:vendorV, model: modelV, page:1}});
}