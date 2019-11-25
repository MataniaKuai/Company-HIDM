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
	var selects = $('#mycourseTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var titleV = selects[0].title;
		var phaseV = selects[0].phase;
		var weekV = selects[0].week;
		var durationV = selects[0].duration;
		var addressV = selects[0].address;
		var lecturerNameV = selects[0].lecturerName;
		var courseStartDateV = selects[0].courseStartDate;
		if (courseStartDateV && courseStartDateV.length >= 19) {
			courseStartDateV = courseStartDateV.substring(0, 16);
		}
		var courseEndDateV = selects[0].courseEndDate;
		if (courseEndDateV && courseEndDateV.length >= 19) {
			courseEndDateV = courseEndDateV.substring(0, 16);
		}
		var fileNameV = selects[0].fileName;
		var scoreV = selects[0].score;
		var idV = selects[0].id;
		var commentsV = selects[0].comments;
		var fileNameV = selects[0].fileName;
		var filePathV = selects[0].filePath;
		
		$('input[name="title"]').val(titleV);
		$('input[name="phase"]').val(phaseV);
		$('input[name="week"]').val(weekV);
		$('input[name="duration"]').val(durationV);
		$('input[name="courseStartDate"]').val(courseStartDateV);
		$('input[name="courseEndDate"]').val(courseEndDateV);
		$('input[name="address"]').val(addressV);
		$('input[name="fileName"]').val(fileNameV);
		$('input[name="score"]').val(scoreV);
		$('input[name="id"]').val(idV);
		$('textarea[name="comments"]').val(commentsV);
		$('#download').text(fileNameV);
		$('#download').attr('href',filePathV);
		

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
	$('#editForm textarea').attr("disabled", true);
	$('#editForm input').attr("disabled", true);
	$('#saveBtn').hide();
	$('#syncDiv').hide();
	$('#dataDiv').show();
	$('#myTab a[href="#home"]').tab('show');
}

function closeDataDiv() {
	$('#dataDiv').hide();
	$('#listDiv').show();
}

function Search() {
	var titleV = $('input[id="title"]').val();
	var courseStartDateV = $('input[id="courseStartDate"]').val();
	var courseEndDateV = $('input[id="courseEndDate"]').val();
    $('#mycourseTable').bootstrapTable('selectPage', 1);
	$('#mycourseTable').bootstrapTable('refresh', {
		query:{
			title: titleV, 
			courseStartDate:courseStartDateV,
			courseEndDate:courseEndDateV,
			page:1
		}
	});
}