//pickList配置信息
	var val = {};

	var pick = $("#pickList").pickList({
		data : val
	});

	var option = '';

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
	var selects = $('#personsigninTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var idV = selects[0].id;
		var titleV = selects[0].title;
		var phaseV = selects[0].phase;
		var weekV = selects[0].week;
		var durationV = selects[0].duration;
		var addressV = selects[0].address;
		var lecturerNameV = selects[0].lecturerName;
		var lecturerNoV = selects[0].lecturerNo;
		var courseStartDateV = selects[0].courseStartDate;
		if (courseStartDateV && courseStartDateV.length >= 19) {
			courseStartDateV = courseStartDateV.substring(0, 16);
		}
		var courseEndDateV = selects[0].courseEndDate;
		if (courseEndDateV && courseEndDateV.length >= 19) {
			courseEndDateV = courseEndDateV.substring(0, 16);
		}
		var fileNameV = selects[0].fileName;
		var filePathV = selects[0].filePath;

		$('input[name="title"]').val(titleV);
		$('input[name="phase"]').val(phaseV);
		$('input[name="week"]').val(weekV);
		$('input[name="duration"]').val(durationV);
		$('input[name="address"]').val(addressV);
		$('input[name="lecturerName"]').val(lecturerNameV);
		$('input[name="lecturerNo"]').val(lecturerNoV);
		$('input[name="courseStartDate"]').val(courseStartDateV);
		$('input[name="courseEndDate"]').val(courseEndDateV);
		$('#download').text(fileNameV);
		$('#download').attr('href', filePathV);
		$('input[name="fileNameTmp"]').val(fileNameV);
		$('input[name="id"]').val(idV);
		$('#dataDiv').show();
		$('#listDiv').hide();

		return true;
	}

	return false;
}

function input() {
	var selects = $('#personsigninTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录编辑');
		return;
	}

	if (selects[0].status != 1) {
		alert("只能编辑状态为待开课的记录");
		return;
	}

	putFormValue();

	//针对pickList 获取已签到人员信息 及 未签到人员信息 进行展示
	getSigninInfo();

	$('#editForm input').attr("disabled", true);
	$('#editForm input[name=duration]').attr("disabled", true);
	$('#saveBtn').show();
	$('#sendScoreEmail').hide();
	$('#editForm select').attr("disabled", false);
	$('#editForm button').attr("disabled", false);
	$('#myTab a[href="#home"]').tab('show');

	$("#editForm").bootstrapValidator("resetForm");
}

function closeDataDiv() {
	$('#dataDiv').hide();
	$('#listDiv').show();
}

function save() {
	$("#editForm").bootstrapValidator("validate");
	if (!$("#editForm").data('bootstrapValidator').isValid()) {
		return;
	}

	var idV = $('input[name="id"]').val();
	
	var formData = new FormData();
	formData.append("courseId", idV);
	var pickValues = '';
	for(var i = 0; i < pick.getValues().length; i++){
		pickValues += pick.getValues()[i].text + ",";
	}
	formData.append("pickValues", pickValues);

	$.ajax({
		url : "/booksharingscore/score/saveSigninInfo",
		type : 'POST',
		cache : false,
		data : formData,
		processData : false,
		contentType : false,
		dataType : "json",
		beforeSend : function() {
		},
		success : function(data) {
			doSearch();
			$('#dataDiv').hide();
			$('#listDiv').show();
		}
	});
}

function doSearch() {
	var titleV = $('input[id="title"]').val();
	var courseStartDateV = $('input[id="courseStartDate"]').val();
	var courseEndDateV = $('input[id="courseEndDate"]').val();
	var lecturerNameV = $('input[id="lecturerName"]').val();
	var statusV = $('select[id="status"]').val();

	$('#personsigninTable').bootstrapTable('selectPage', 1);
	$('#personsigninTable').bootstrapTable('refresh', {
		query : {
			title : titleV,
			courseStartDate : courseStartDateV,
			courseEndDate : courseEndDateV,
			lecturerName : lecturerNameV,
			status : statusV,
			page : 1
		}
	});
}

function startScore() {
	var selects = $('#personsigninTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录开始评分');
		return;
	}

	if (selects[0].status != 1) {
		alert("只能启动状态为待开课的课程进行评分！");
		return;
	}

	view();
	$('#sendScoreEmail').show();
	$('#sendScoreEmail').attr("disabled", false);
}

function sendScoreEmailFunction() {
	var selects = $('#personsigninTable').bootstrapTable('getSelections');
	var idV = selects[0].id;
	var titleV = selects[0].title;
	
	$.post('/booksharingscore/course/startScore', {
		id : idV, title : titleV
	}, function(result) {
		if (result) {
			doSearch();
			$('#dataDiv').hide();
			$('#listDiv').show();
		} else {
			alert('启动开始评分错误！');
		}
	}, 'json');
}


function stopScore() {
	var selects = $('#personsigninTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录开始评分');
		return;
	}

	if (selects[0].status != 2) {
		alert("只能结束状态为待评分的课程！");
		return;
	}

	var idV = selects[0].id;

	$.post('/booksharingscore/course/stopScore', {
		id : idV
	}, function(result) {
		if (result) {
			doSearch();
			$('#dataDiv').hide();
			$('#listDiv').show();
		} else {
			alert('结束开始评分错误！');
		}
	}, 'json');
}

function getSigninInfo() {
	var idV;
	var selects = $('#personsigninTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		idV = selects[0].id;
	}

	//页面加载 获取当前课程签到人员信息
	var formData = new FormData();
	formData.append("courseId", idV);

	$.ajax({
		url : "/booksharingscore/user/selectUserByCourseId",
		type : 'POST',
		cache : false,
		data : formData,
		processData : false,
		contentType : false,
		dataType : "json",
		beforeSend : function() {
			uploading = true;
		},
		success : function(data) {
			option = '';
			var result1 = data.users;
			var arr1 = [];
			for ( var item in result1) {
				arr1.push(result1[item]);
			}
			for (var i = 0; i < arr1.length; i++) {
				option += '<option data-id=' + arr1[i].userName + '>' + arr1[i].userName
						+ '</option>';
			}
			pick.find('.pickListResult').html(option);

			option = '';
			var result2 = data.usersNoSignin;
			var arr2 = [];
			for ( var item in result2) {
				arr2.push(result2[item]);
			}
			for (var i = 0; i < arr2.length; i++) {
				option += '<option data-id=' + arr2[i].userName + '>' + arr2[i].userName
						+ '</option>';
			}
			pick.find('.pickData').html(option);
		}
	});
}
function view(){
	if (!putFormValue()) {
		alert('只能选择一条记录查看');
		
		return;
	}
	getSigninInfo();
	$('#editForm input').attr("disabled", true);
	$('#editForm select').attr("disabled", true);
	$('#editForm button').attr("disabled", true);
	$('#editForm button[name=returnButton]').attr("disabled", false);
	$('#saveBtn').hide();
	$('#syncDiv').hide();
	$('#sendScoreEmail').hide();
	
	$('#myTab a[href="#home"]').tab('show');
}
