function doSearch() {
	var titleV = $('input[id="title"]').val();
	var courseStartDateV = $('input[id="courseStartDate"]').val();
	var courseEndDateV = $('input[id="courseEndDate"]').val();
	var lecturerNameV = $('input[id="lecturerName"]').val();
    
    $('#scoreResultTable').bootstrapTable('selectPage', 1);
	$('#scoreResultTable').bootstrapTable('refresh', {
		query:{
			title: titleV, 
			courseStartDate:courseStartDateV,
			courseEndDate:courseEndDateV,
			lecturerName:lecturerNameV,
			page:1
		}
	});
}

function putFormValue() {
	var selects = $('#scoreResultTable').bootstrapTable('getSelections');
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
		var filePathV = selects[0].filePath;
		var scoreV = selects[0].score;
		var idV = selects[0].id;
		var commentsV = selects[0].comments;
		
		$('input[name="title"]').val(titleV);
		$('input[name="address"]').val(addressV);
		$('input[name="phase"]').val(phaseV);
		$('input[name="week"]').val(weekV);
		$('input[name="duration"]').val(durationV);
		$('input[name="lecturerName"]').val(lecturerNameV);
		$('input[name="courseStartDate"]').val(courseStartDateV);
		$('input[name="courseEndDate"]').val(courseEndDateV);
		$('#download').text(fileNameV);
		$('#download').attr('href',filePathV);
		$('input[name="score"]').val(scoreV);
		$('textarea[name="comments"]').val(commentsV);
		$('input[name="id"]').val(idV);
		$('#dataDiv').show();
		$('#listDiv').hide();
		
		return true;
	}
	
	return false;
}

function closeDataDiv() {
	$('#dataDiv').hide();
	$('#listDiv').show();
}

function view(){
	if (!putFormValue()) {
		alert('只能选择一条记录查看');
		
		return;
	}
	
	$('#editForm input').attr("disabled", true);
	$('#editForm textarea[name=comments]').attr("disabled", true);
	$('#comments').hide();
	$('#commentsLabel').hide();
	$('#syncDiv').hide();
	$('#downloadFile').show();
	$('#myTab a[href="#home"]').tab('show');
}