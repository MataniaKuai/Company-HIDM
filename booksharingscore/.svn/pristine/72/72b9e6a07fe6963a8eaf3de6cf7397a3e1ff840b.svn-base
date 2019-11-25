function doSearch() {
	var titleV = $('input[id="title"]').val();
	var courseStartDateV = $('input[id="courseStartDate"]').val();
	var courseEndDateV = $('input[id="courseEndDate"]').val();
	var lecturerNameV = $('input[id="lecturerName"]').val();
    
    $('#scoreTable').bootstrapTable('selectPage', 1);
	$('#scoreTable').bootstrapTable('refresh', {
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
	var selects = $('#scoreTable').bootstrapTable('getSelections');
	if (selects.length == 1) {
		var courseIdV = selects[0].courseId;
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
		if(null != scoreV && "" != scoreV){
			var scoreVInt = parseInt(scoreV);
			$('input:radio[name=scoreRadiosinline]')[scoreVInt - 1].checked = true;
		}
		
		var commentV = selects[0].comment;
		
		$('input[name="courseId"]').val(courseIdV);
		$('input[name="title"]').val(titleV);
		$('input[name="phase"]').val(phaseV);
		$('input[name="week"]').val(weekV);
		$('input[name="duration"]').val(durationV);
		$('input[name="address"]').val(addressV);
		$('input[name="lecturerName"]').val(lecturerNameV);
		$('input[name="courseStartDate"]').val(courseStartDateV);
		$('input[name="courseEndDate"]').val(courseEndDateV);
		$('#download').text(fileNameV);
		$('#download').attr('href',filePathV);
		$('textarea[name="comment"]').val(commentV);
		$('input[name="id"]').val(idV);
		
		return true;
	}
	
	return false;
}


function score(){
	var selects = $('#scoreTable').bootstrapTable('getSelections');
	if (selects.length != 1) {
		alert('只能选择一条记录编辑');
		return;
	}
	
	putFormValue();
	//判断登陆用户是否已签到
	var courseIdV = $('input[name="courseId"]').val();
	var idV = $('input[name="id"]').val();
	$.post('/booksharingscore/score/isSignin',
		{
		courseId: courseIdV,id:idV
		},
		function(result){
		if (result){
			$('#dataDiv').show();
			$('#listDiv').hide();
			$('#editForm input[name=title]').attr("disabled", true);
			$('#editForm input[name=phase]').attr("disabled", true);
			$('#editForm input[name=week]').attr("disabled", true);
			$('#editForm input[name=duration]').attr("disabled", true);
			$('#editForm input[name=courseStartDate]').attr("disabled", true);
			$('#editForm input[name=courseEndDate]').attr("disabled", true);
			$('#editForm input[name=lecturerName]').attr("disabled", true);
			$('#editForm input[name=address]').attr("disabled", true);
			$('#saveBtn').show();
			$('#syncDiv').show();
			$('#myTab a[href="#home"]').tab('show');
			$('#downloadFile').show();
			$("#editForm").bootstrapValidator("resetForm");
		} else {
			$('#dataDiv').hide();
			$('#listDiv').show();
			alert('您未参加此课程的演讲，故没有权限进行评分！');
		}
	},'json');
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
	
	var scoreV = $("input[name='scoreRadiosinline']:checked").val();
	var commentV = $('textarea[name="comment"]').val();
	var courseIdV = $('input[name="courseId"]').val();
	var idV = $('input[name="id"]').val();
	$.post('/booksharingscore/score/save',
		{
		score: scoreV, comment: commentV, courseId: courseIdV,id:idV
		},
		function(result){
		if (result){
			doSearch();
			$('#dataDiv').hide();
			$('#listDiv').show();
		} else {
			alert('评分失败');
		}
	},'json');
	
}
