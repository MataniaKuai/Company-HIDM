	function statusFormatter(value, row, index) {
	     if (value == 0) {
	    	 return "未收货";
	     }
	
	     if (value == 1) {
	    	 return "已收货";
	     }
	}
	
		function getHisModel(itemIdV){
			$('#importItemHistoryTable').bootstrapTable({
				pagination: true,
				cache:false,
				pageNumber:1,
				pageSize:10,
				pageList: [1, 10, 25, 50],
				sidePagination: "server",
				height:530,
			    columns: [{
			        field: 'grNo',
			        title: 'GR NO'
			    }, {
			    	field: 'moveType',
			    	title: 'MoveType'
			    }, {
			    	field: 'status',
			    	title: '状态',
			        formatter: statusFormatter
	   	        }, {
			        field: 'relatedGrNo',
			        title: 'RelatedGr No'
			    }, {
			        field: 'relatedMoveType',
			        title: 'RelatedMoveType'
			    }, {
			    	field: 'addUser',
			    	title: '操作人'
	   	        },{
			        field: 'addTime',
			        title: '操作日期'
			    }, {
	    	       field: 'operate',
	    	       title: '操作',
	    	       align: 'center',
	        	   formatter: operateBatchFormatter,
	    	       events: "operateBatchEvents"
	   	        },{
			       field: 'id',
			       title: 'id',
			       visible: false
			    }],
			    url : '/importexport/importItemHis/searchByItem',
			    queryParams : function (params) {
		            var temp = {   
		                rows: params.limit,
		                page: (params.offset / params.limit) + 1,
		                sort: params.sort,
		                sortOrder: params.order,
		                itemId: itemIdV
		            };
		            return temp;
		        },
			});

		    $('#importItemHistoryTable').bootstrapTable('selectPage', 1);
			$('#importItemHistoryTable').bootstrapTable('refresh', {query:{itemId: itemIdV, page:1}});
			$('#itemHistoryModal').modal('show');
		}
		
		//batch历史记录查看
		function operateBatchFormatter(value, row, index) {
            return ['<button type="button" class="batchHisView btn btn-primary">查看批次</button>',
            ].join('')
 	   }
		window.operateBatchEvents = {
            'click .batchHisView': function (e, value, row, index) {
				var itemHisId = row.id;
					
				$('#importBatchHistoryTable').bootstrapTable({
					pagination: true,
					cache:false,
					pageNumber:1,
					pageSize:10,
					pageList: [1, 10, 25, 50],
					sidePagination: "server",
					height:530,
				    columns: [{
				        field: 'poNo',
				        title: 'PO NO'
				    }, {
				        field: 'poItem',
				        title: 'PO Item'
				    }, {
				        field: 'batchNo',
				        title: 'batchNo'
				    }, {
				    	field: 'sapBatchNo',
				    	title: 'sapBatchNo'
				    }, {
				    	field: 'unit',
				    	title: 'unit'
		   	        },{
				    	field: 'qty',
				    	title: 'qty'
		   	        },{
				    	field: 'produceTime',
				    	title: 'produceTime',
				        formatter: declarationTimeFormatter
		 	        },{
				    	field: 'addUser',
				    	title: '操作人'
		   	        },{
				        field: 'addTime',
				        title: '操作日期'
				    }, {
				       field: 'id',
				       title: 'id',
				       visible: false
				    }],
				    url : '/importexport/importBatchHis/searchByItemHis',
				    queryParams : function (params) {
			            var temp = {   
			                rows: params.limit,
			                page: (params.offset / params.limit) + 1,
			                sort: params.sort,
			                sortOrder: params.order,
			                itemHisId: itemHisId
			            };
			            return temp;
			        },
				});

			    $('#importBatchHistoryTable').bootstrapTable('selectPage', 1);
				$('#importBatchHistoryTable').bootstrapTable('refresh', {query:{itemHisId: itemHisId, page:1}});
				$('#batchHistoryModal').modal('show');
			}	
        }