$package('otter.simpleFlow');
otter.simpleFlow = function(){
	var _box = null;
	var _this = {
		config:{
			event:{
				add:function(){
					_box.handler.add();
				},
				edit:function(){
					var selected = _box.utils.getCheckedRows();
					if ( _box.utils.checkSelectOne(selected)){
						if(!(null == selected[0]['status'] || 0 == selected[0]['status'] || 9 == selected[0]['status'])){
							otter.alert('提示','当前流程在处理中不能进行操作！');
							return;
						}
						_box.handler.edit();
					}
				},
				remove: function(){
					var selected = _box.utils.getCheckedRows();
					if ( _box.utils.checkSelectOne(selected)){
						if(!(null == selected[0]['status'] || 0 == selected[0]['status'] || 9 == selected[0]['status'])){
							otter.alert('提示','当前流程在处理中不能进行操作！');
							return;
						}
						_box.handler.remove();
					}
				}
			},
  			dataGrid:{
  				title:'简单流程信息表',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'title',title:'流程标题',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.title;
							}
						},
					{field:'note',title:'流程说明',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.note;
							}
						},
					{field:'ftype',title:'流程业务类型',align:'center',sortable:true,
							formatter:function(value,row,index){
								if(value == 10){
									return "公章申请";
								}
								if(value == 11){
									return "人力资源章申请";
								}
								return "";
							}
						},
					{field:'created_time',title:'创建时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createdTime;
							}
						},
					{field:'createdBy',title:'发起人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createdName;
							}
						},
					{field:'approver',title:'审批人',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.approverName;
						}
					},
					{field:'status',title:'流程状态',align:'center',sortable:true,
							styler:function(value,row,index){
								if(value == 0){
								  return 'color:black;';  
								}
								if(value == 1){
									return "color:blue;";
								}
								if(value == 2){
									return 'color:green;';  
								}
								if(value == 8){
									return "color:black;";
								}
								if(value == 9){
									return 'color:red;';  
								}
								return 'color:black;';  
							},
							formatter:function(value,row,index){
								if(value == 0){
									  return '草稿';  
								}
								if(value == 1){
									return "待审批";
								}
								if(value == 2){
									return '审批通过';  
								}
								if(value == 8){
									return "已结束";
								}
								if(value == 9){
									return '驳回';  
								}
								return "草稿";
							}
						},
/*					{field:'remark',title:'备注',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.remark;
							}
						},
					{field:'updated_by',title:'更新人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updatedBy;
							}
						},*/
					{field:'updated_time',title:'更新时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updatedTime;
							}
						},

					{field:'delFlag',title:'删除状态',align:'center',sortable:true,
						styler:function(value,row,index){
							if(value == 1){
							  return 'color:red;';  
							}
							if(value == 0){
								return "color:blue;";
							}
							return 'color:blue;';  
						},
						formatter:function(value,row,index){
							if(value == 1){
								return "已删除";
							}
							if(value == 0){
								return "未删除";
							}
							return "未删除";
						}
					},
					]]
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();

$(function(){
	otter.simpleFlow.init();
});