function add(){
	
	$('input[name="title"]').val("");
	$('input[name="lecturerName"]').val("");
	$('input[name="lecturerNo"]').val("");
	$('input[name="address"]').val("");
	$('input[name="fileName"]').val("");
	$('input[name="fileNameTmp"]').val("");
	$('input[name="courseStartDate"]').val("");
	$('input[name="courseEndDate"]').val("");
	$('input[name="phase"]').val("");
	$('input[name="week"]').val("");
	$('input[name="duration"]').val("");

	$('input[name="id"]').val("");
	$('#dataDiv').show();
	$('#listDiv').hide();
	$('#downloadFile').hide();
	$('#uploadFile').show();
	$('#editForm input').attr("disabled", false);
	$('#editForm input[name=duration]').attr("disabled", true);
	$('#saveBtn').show();
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
	var selects = $('#courseTable').bootstrapTable('getSelections');
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
		$('#download').attr('href',filePathV);
		$('input[name="fileNameTmp"]').val(fileNameV);
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
	$('#saveBtn').hide();
	$('#syncDiv').hide();
	$('#downloadFile').show();
	$('#uploadFile').hide();
	
	$('#myTab a[href="#home"]').tab('show');
}

function edit(){
	var selects = $('#courseTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录编辑');
		return;
	}
	
	if(selects[0].status != 1) {
		alert("只能编辑状态为待开课的记录");
		return;
	}
	
	
	putFormValue();
	
	$('#editForm input').attr("disabled", false);
	$('#editForm input[name=duration]').attr("disabled", true);
	$('#saveBtn').show();
	$('#syncDiv').show();
	$('#myTab a[href="#home"]').tab('show');
	
	$('#downloadFile').hide();
	$('#uploadFile').show();
	
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
	
	var titleV = $('input[name="title"]').val();
	var lecturerNameV = $('input[name="lecturerName"]').val();
	var lecturerNoV = $('input[name="lecturerNo"]').val();
	var addressV = $('input[name="address"]').val();
	var idV = $('input[name="id"]').val();
	var courseStartDateV = $('input[name="courseStartDate"]').val();
	var courseEndDateV = $('input[name="courseEndDate"]').val();
	var phaseV = $('input[name="phase"]').val();
	var weekV = $('input[name="week"]').val();
	var durationV = $('input[name="duration"]').val();
	$.post('/booksharingscore/course/save',
		{
		title: titleV,lecturerName: lecturerNameV, lecturerNo: lecturerNoV, address: addressV,
		courseStartDate: courseStartDateV, courseEndDate:courseEndDateV, phase:phaseV, week:weekV, duration:durationV,
		id:idV
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

function removeCourse(){
	var rows = $('#courseTable').bootstrapTable('getSelections');
	if (rows && rows.length > 0){
		var ids = new Array();
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			if (row.status != 1) {
				alert("只能删除状态为待开课的记录");
				return;
			}
			
			ids.push(row.id);
		}
		
		$.post('/booksharingscore/course/delete',{ids: ids},function(result){
			if(!result){
				alert("删除失败！");
				return;
			}
			doSearch();
		},'json');
	} else {
		alert('至少选择一条记录。');
	}
}

function doSearch() {
	var titleV = $('input[id="title"]').val();
	var courseStartDateV = $('input[id="courseStartDate"]').val();
	var courseEndDateV = $('input[id="courseEndDate"]').val();
	var lecturerNameV = $('input[id="lecturerName"]').val();
	var statusV = $('select[id="status"]').val();
    
    $('#courseTable').bootstrapTable('selectPage', 1);
	$('#courseTable').bootstrapTable('refresh', {
		query:{
			title: titleV, 
			courseStartDate:courseStartDateV,
			courseEndDate:courseEndDateV,
			lecturerName:lecturerNameV,
			status:statusV,
			page:1
		}
	});
}
function upload() {
	var formData = new FormData();
	// 获取文件
	var fileData = $("#fileName").prop("files")[0];
	if(fileData == null){
		alert("上传文件为空，请重新上传");
		return;
	}
	formData.append("file", fileData);
	
	$.ajax({
        url: "/booksharingscore/course/upload",
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
        	alert(data.msg);
        }
    });	
 }
function change() {
	$('input[name="fileNameTmp"]').val($('input[name="fileName"]').val());
}

function startScore(){
	var selects = $('#courseTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录开始评分');
		return;
	}
	
	if(selects[0].status != 1) {
		alert("只能启动状态为待开课的课程进行评分！");
		return;
	}
	
	var idV = selects[0].id;
	
	$.post('/booksharingscore/course/startScore',
			{
			id:idV
			},
			function(result){
			if (result){
				doSearch();
				$('#dataDiv').hide();
				$('#listDiv').show();
			} else {
				alert('启动开始评分错误！');
			}
		},'json');
}

function stopScore(){
	var selects = $('#courseTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录开始评分');
		return;
	}
	
	if(selects[0].status != 2) {
		alert("只能结束状态为待评分的课程！");
		return;
	}
	
	var idV = selects[0].id;
	
	$.post('/booksharingscore/course/stopScore',
			{
			id:idV
			},
			function(result){
			if (result){
				doSearch();
				$('#dataDiv').hide();
				$('#listDiv').show();
			} else {
				alert('结束开始评分错误！');
			}
		},'json');
}

function durationCalculate() {
	var startDateV = $('input[name="courseStartDate"]').val();
	var endDateV = $('input[name="courseEndDate"]').val();

	var dt1 = startDateV + "";
	var dt2 = endDateV + "";
	var re = getHoursDiff(dt1, dt2);
	var h = parseInt(re);
	var m = parseInt((re - h) * 60);
	var m = m / 60.0;
	var duration = h + m;
	duration = Number(duration.toFixed(2));
	$('input[name="duration"]').val(duration + "h");
}
function getHoursDiff(dt1, dt2) {
	if (typeof (dt1) == "string") {
		dt1 = new Date(dt1.replace(/-/, '/'));
		dt2 = new Date(dt2.replace(/-/, '/'));
	}
	var res = dt2 - dt1;
	if (isNaN(res))
		throw Error("invalid dates arguments");
	return res / (1000 * 60 * 60);
}