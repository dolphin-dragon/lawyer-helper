$package('otter.simpleFlow');
otter.simpleFlow = function(){
	var _box = null;
	var _this = {
			pushTask:function(){
				otter.confirm("提示","提交后将等待审批处理，不可进行任何变更操作请仔细检查信息，是否提交?",function(r){
					if(r){
						_box.form.edit.attr('action','push.do');
						otter.saveForm(_box.form.edit,function(data){
							otter.closeProgress();//关闭缓冲条
							_box.win.edit.dialog('close');
						});
					}
				});
			},
		config:{
			event:{
				add:function(){
					$("#ck_fileAckImg").attr('src','');
	                $("#ck_bizAckImg").attr('src','');
	                $("#ck_fileAckImg").css("opacity","0");
	                $("#ck_bizAckImg").css("opacity","0");
	                
					_box.win.edit.dialog({
						buttons:[
							{
								text:'保存',
								handler:_box.events.save
							},{
								text:'关闭',
								handler:_box.events.close
							},{
								text:'提交',
								handler:_this.pushTask
							}
						],
					onClose : function(){
							_box.win.edit.dialog({
								buttons:[
									{
										text:'保存',
										handler:_box.events.save
									},{
										text:'关闭',
										handler:_box.events.close
									}
								]
							});
							_box.handler.refresh();
						}
					});
					_box.handler.add();
				},
				edit:function(){
					var selected = _box.utils.getCheckedRows();
					if ( _box.utils.checkSelectOne(selected)){
						if(!(null == selected[0]['status'] || 0 == selected[0]['status'] || 9 == selected[0]['status'])){
							otter.alert('提示','当前流程在处理中不能进行操作！');
							return;
						}
						_box.win.edit.dialog({
							buttons:[
								{
									text:'保存',
									handler:_box.events.save
								},{
									text:'关闭',
									handler:_box.events.close
								},{
									text:'提交',
									handler:_this.pushTask
								}
							],
						onClose : function(){
								_box.win.edit.dialog({
									buttons:[
										{
											text:'保存',
											handler:_box.events.save
										},{
											text:'关闭',
											handler:_box.events.close
										}
									]
								});
								_box.handler.refresh();
							}
						});
						
						$("#ck_fileAckImg").attr('src','');
		                $("#ck_bizAckImg").attr('src','');
		                $("#ck_fileAckImg").css("opacity","0");
		                $("#ck_bizAckImg").css("opacity","0");
		                    
						_box.handler.edit(function(){
							var acimg = $('input[name="fileAckImg"]',$('#editForm')).val();
							if(''!=acimg){
								$("#ck_fileAckImg").attr('src',acimg);
								$("#ck_fileAckImg").css("opacity","1");
							}
							
							var liacimg = $('input[name="bizAckImg"]',$('#editForm')).val();
							if(''!=liacimg){
								$("#ck_bizAckImg").attr('src',liacimg);
				                $("#ck_bizAckImg").css("opacity","1");
							}
						});
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
  				title:'简单流程列表',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'tid',title:'流程编号',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.id;
						}
					},
					{field:'title',title:'审批事项',align:'center',sortable:true,
							formatter:function(value,row,index){
								if(value == 10){
									  return '加盖公章';  
								}
								if(value == 11){
									return "加盖合同专用章";
								}
								if(value == 12){
									return '加盖人力资源章';  
								}
								return value;
							}
						},
					{field:'note',title:'事项内容',align:'left',sortable:true,width:200,
							formatter:function(value,row,index){
								return row.note;
							}
						},
					{field:'ftype',title:'文件类型/事项类型',align:'center',sortable:true,width:200,
							formatter:function(value,row,index){
								return row.ftypeName;
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