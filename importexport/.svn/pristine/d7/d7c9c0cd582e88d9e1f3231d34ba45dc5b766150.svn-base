function add() {
	$('input[name="materialNo"]').val("");
	$('select[name="goodsCode"]').selectpicker('val', "");
	$('input[name="hiTech"]').prop('checked', false);
	$('input[name="hiTech"][value="0"]').prop('checked', true);
	$('select[name="customOffice"]').selectpicker('val', "");
	$('input[name="unit"]').val("");
	$('select[name="bondCla1"]').selectpicker('val', "");
	$('select[name="bondCla2"]').selectpicker('val', "");
	$('input[name="hsCode"]').val("");
	$('select[name="currency"]').selectpicker('val', "");
	$('input[name="goodsDesc"]').val("");
	$('input[name="chineseName"]').val("");
	$('select[name="taxPreperty"]').selectpicker('val', "");
	$('select[name="freeNo"]').selectpicker('val', "");
	$('select[name="iterm"]').selectpicker('val', "");
	$('input[name="text1"]').val("");
	$('input[name="text2"]').val("");
	$('input[name="text3"]').val("");
	
	$('input[name="employeeNo"]').val($('input[name="loginName"]').val());

	$('input[name="id"]').val("");
	$('#dataModal').modal('show');
	
	$('#editForm input').attr("disabled", false);
	$('#editForm select').attr("disabled", false);
	$('#editForm input[name=employeeNo]').attr("disabled", true);
	$('#saveBtn').show();
	$('#myImage').hide();
}

function putFormValue() {
	var selects = $('#materialTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var idV = selects[0].id;
		var materialNoV = selects[0].materialNo;
		var goodsCodeV = selects[0].goodsCode;
		var hiTechV = selects[0].hiTech;
		var customOfficeV = selects[0].customOffice;
		var unitV = selects[0].unit;
		var bondCla1V = selects[0].bondCla1;
		var bondCla2V = selects[0].bondCla2;
		var hsCodeV = selects[0].hsCode;
		var currencyV = selects[0].currency;
		var goodsDescV = selects[0].goodsDesc;
		var chineseNameV = selects[0].chineseName;
		var taxPrepertyV = selects[0].taxPreperty;
		var freeNoV = selects[0].freeNo;
		var itermV = selects[0].iterm;
		var text1V = selects[0].text1;
		var text2V = selects[0].text2;
		var text3V = selects[0].text3;
		var filePathV = selects[0].filePath;
		var employeeNoV = selects[0].employeeNo;

		$('input[name="materialNo"]').val(materialNoV);
		$('select[name="goodsCode"]').selectpicker('val', goodsCodeV);
		$('input[name="hiTech"]').prop('checked', false);
		$('input[name="hiTech"][value="' + hiTechV + '"]')
				.prop('checked', true);
		$('select[name="customOffice"]').selectpicker('val', customOfficeV);
		$('input[name="unit"]').val(unitV);
		$('select[name="bondCla1"]').selectpicker('val', bondCla1V);
		$('select[name="bondCla2"]').selectpicker('val', bondCla2V);
		$('input[name="hsCode"]').val(hsCodeV);
		$('select[name="currency"]').selectpicker('val', currencyV);
		$('input[name="goodsDesc"]').val(goodsDescV);
		$('input[name="chineseName"]').val(chineseNameV);
		$('select[name="taxPreperty"]').selectpicker('val', taxPrepertyV);
		$('select[name="freeNo"]').selectpicker('val', freeNoV);
		$('input[name="iterm"]').val(itermV);
		$('input[name="text1"]').val(text1V);
		$('input[name="text2"]').val(text2V);
		$('input[name="text3"]').val(text3V);
		$('input[name="employeeNo"]').val(employeeNoV);
		
		$('#fileName').attr('src', filePathV);

		$('input[name="id"]').val(idV);
		$('#dataModal').modal('show');
	}
}

function view() {
	var selects = $('#materialTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录编辑');
		return;
	}
	
	$('#editForm input').attr("disabled", true);
	$('#editForm select').attr("disabled", true);
	$('#saveBtn').hide();
	$('#myImage').show();
	
	putFormValue();
}

function edit() {
	var selects = $('#materialTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录编辑');
		return;
	}
	
	$('#editForm input').attr("disabled", false);
	$('#editForm select').attr("disabled", false);
	$('#editForm input[name=employeeNo]').attr("disabled", true);
	$('#saveBtn').show();
	$('#myImage').show(); 

	putFormValue();
}

function upload() {
	var selects = $('#materialTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var idV = selects[0].id;
		var materialNoV = selects[0].materialNo;

		$('input[name="id"]').val(idV);
		$('input[name="materialNo"]').val(materialNoV);
		$('#picModal').modal('show');
	} else {
		alert('只能选择一条记录上传');
	}
}

var uploading = false;
function doUpload() {
	$.ajax({
		url : "/importexport/material/fileUpload",
		type : 'POST',
		cache : false,
		data : new FormData($('#picForm')[0]),
		processData : false,
		contentType : false,
		dataType : "json",
		beforeSend : function() {
			uploading = true;
		},
		success : function(data) {
			if (data) {
				doSearch();
			} else {
				alert("上传失败");
			}
			uploading = false;
		}
	});

	$('#picModal').modal('hide');
}


function getDescription() {
	var materialNo = $('input[name="materialNo"]').val();
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
}

function save() {
	$("#editForm").bootstrapValidator("validate");
	if (!$("#editForm").data('bootstrapValidator').isValid()) {
		return;
	}
	
	var materialNoV = $('input[name="materialNo"]').val().trim();
	var goodsCodeV = $('select[name="goodsCode"]').val();
	var hiTechV = 0;
	if ($('#hiTech1').prop('checked')) {
		hiTechV = 1;
	}
	var customOfficeV = $('select[name="customOffice"]').val();
	var unitV = $('input[name="unit"]').val();
	var bondCla1V = $('select[name="bondCla1"]').val();
	var bondCla2V = $('select[name="bondCla2"]').val();
	var hsCodeV = $('input[name="hsCode"]').val();
	var currencyV = $('select[name="currency"]').val();
	var goodsDescV = $('input[name="goodsDesc"]').val();
	var chineseNameV = $('input[name="chineseName"]').val();
	var taxPrepertyV = $('select[name="taxPreperty"]').val();
	var freeNoV = $('select[name="freeNo"]').val();
	var itermV = $('input[name="iterm"]').val();
	var text1V = $('input[name="text1"]').val();
	var text2V = $('input[name="text2"]').val();
	var text3V = $('input[name="text3"]').val();
	var employeeNoV = $('input[name="employeeNo"]').val();

	var idV = $('input[name="id"]').val();
	$.post('/importexport/material/save', {
		materialNo : materialNoV,
		goodsCode : goodsCodeV,
		hiTech : hiTechV,
		customOffice : customOfficeV,
		unit : unitV,
		bondCla1 : bondCla1V,
		bondCla2 : bondCla2V,
		hsCode : hsCodeV,
		currency : currencyV,
		goodsDesc : goodsDescV,
		chineseName : chineseNameV,
		taxPreperty : taxPrepertyV,
		freeNo : freeNoV,
		iterm : itermV,
		text1: text1V, text2: text2V, text3: text3V,
		employeeNo : employeeNoV,
		id : idV
	}, function(result) {
		if (result) {
			doSearch();
			$('#dataModal').modal('hide');
		} else {
			alert('系统错误');
		}
	}, 'json');
}
function remove() {
	var rows = $('#materialTable').bootstrapTable('getSelections');
	if (rows && rows.length > 0) {
		var ids = new Array();
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			ids.push(row.id);
		}

		$.post('/importexport/material/delete', {
			ids : ids
		}, function(result) {
			if (result) {
				doSearch();
			} else {
				$.messager.show({
					title : '错误',
					msg : '系统错误'
				});
			}
		}, 'json');
	} else {
		alert('至少选择一条记录。');
	}
}

function doSearch() {
	var materialNoV = $('input[id="materialNo"]').val();
	var goodsCodeV = $('select[id="goodsCode"]').val();

	$('#materialTable').bootstrapTable('selectPage', 1);
	$('#materialTable').bootstrapTable('refresh', {
		query : {
			materialNo : materialNoV,
			goodsCode : goodsCodeV,
			page : 1
		}
	});
}