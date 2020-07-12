$package('otter.casePreLitigation');
otter.casePreLitigation = function(){
	var _box = null;
	var _this = {
			pushNext:function(){
				otter.confirm("提示","请仔细检查案件信息，案件推进后将不能更改信息，是否确定?",function(r){
					if(r){
						_box.form.edit.attr('action','pushNext.do');
						otter.saveForm(_box.form.edit,function(data){
							otter.closeProgress();//关闭缓冲条
							_box.win.edit.dialog('close');
						});
					}
				});
			},
		config:{
			event:{
				//add:function(){
				//	$('#typeIds_combobox').combobox('reload');
				//	_box.handler.add();
				//},
				edit:function(){
//					$('#typeIds_combobox').combobox('reload');
					$('input,textarea',$('#editForm')).removeAttr('readonly');
					$('.easyui-combobox , .easyui-datebox',$('#editForm')).combobox('enable');
					$('input[type="button"]',$('#editForm')).removeAttr('disabled');

					var selected = _box.utils.getCheckedRows();
					if ( _box.utils.checkSelectOne(selected)){
						if(!(null==selected[0]['status'] || 0 == selected[0]['status'] ) || 1==selected[0]['isClose']) {
							if(3 == selected[0]['status'] ){
								_box.handler.edit();
								return false;
							}
							otter.alert('提示','案件已推送下阶段处理不能进行编辑！');
							return false;
						}
					}

					_box.handler.edit(function(){
						$(".ui-edit").show();
					});
				},
				save:function(){
					var selected = _box.utils.getCheckedRows();
					if (_box.utils.checkSelectOne(selected)){
						if(1==selected[0]['isClose']){
							otter.confirm("提示","案件结案将不能更改任何信息,是否确定?",function(r){
								if(r){
									//_box.handler.save();
									otter.closeProgress();//关闭缓冲条
									_box.win.edit.dialog('close');
								}
							});
						}else{
							_box.handler.save();
						}
					}
				}
			},
  			dataGrid:{
  				title:'案件诉前和解信息',
	   			url:'dataList.do',
	   			toolbar:[
					//{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'},
					{id:'btnedit',text:'案件推进',btnType:'push',iconCls:'icon-tip',handler:function(){
						var selected = _box.utils.getCheckedRows();
						if ( _box.utils.checkSelectOne(selected)){
							if(!(null==selected[0]['status'] || 0 == selected[0]['status'] || 3 == selected[0]['status'])) {
								otter.alert('提示','案件已推送下阶段处理不能操作处理！');
								return false;
							}
							_box.win.edit.dialog({
								buttons:[
									{
										text:'案件推进',
										handler:_this.pushNext
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
							
							_box.handler.edit(new function(){
								//控制界面原始不可用
								$('input,textarea',$('#editForm')).attr('readonly',true);
								$('.easyui-combobox , .easyui-datebox',$('#editForm')).combobox('disable');
								$('input[type="button"]',$('#editForm')).attr('disabled',true);

								$(".ui-edit").show();
							});
						}
					}}
				],
				idField:'caseId',
	   			columns:[[
					{field:'case_id',checkbox:true},
					{field:'status',title:'案件状态',align:'center',sortable:true,
						styler:function(value,row,index){
							if(value == 1){
							  return 'color:blue;';  
							}
							if(value == 2){
								return "color:green;";
							}
							if(value == 3){
								return "color:red;";
							}
						},
						formatter:function(value,row,index){
                    		if(value == 1){
								return "已推进";
							}
							if(value == 2){
								return "结案通过";
							}
							if(value == 3){
								return "结案驳回";
							}
							return "进行中";
						}
					},
					{field:'delFlag',title:'是否有效',align:'center',sortable:true,
						styler:function(value,row,index){
							if(value == 0){
								return "color:green;";
							}
							if(value == 1){
							  return 'color:red;';  
							}
							return "color:green;";
						},
						formatter:function(value,row,index){
                    		if(value == 0){
								return "有效";
							}
							if(value == 1){
								return "已删除";
							}
							return "有效";
						}
					},
					/*{field:'status',title:'状态',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.status;
							}
						},
					{field:'org',title:'机构编码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.org;
							}
						},
					{field:'created_by',title:'创建人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createdBy;
							}
						},
					{field:'created_time',title:'创建时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createdTime;
							}
						},
					{field:'updated_by',title:'更新人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updatedBy;
							}
						},
					{field:'updated_time',title:'更新时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updatedTime;
							}
						},
					{field:'case_id',title:'案件序号',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseId;
							}
						},*/
					{field:'litigant',title:'当事人',align:'left',sortable:true,
						formatter:function(value,row,index){
							return row.litigant;
						}
					},
				{field:'defendant_name',title:'被告名称',align:'left',sortable:false,width:200,
						formatter:function(value,row,index){
							return row.defendantName;
						}
					},
				{field:'defendant_reg_capital',title:'被告注册资本',align:'right',sortable:false,
						formatter:function(value,row,index){
							return row.defendantRegCapital;
						}
					},
				{field:'defendant_area',title:'被告所在地',align:'left',sortable:false,width:200,
						formatter:function(value,row,index){
							return row.defendantArea;
						}
					},
					
					{field:'letter',title:'律师函编号',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.letter;
							}
						},
					{field:'letteror',title:'律师函主办人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.letterorName;
							}
						},
					{field:'send_date',title:'律师函发送日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.sendDate;
							}
						},
					{field:'delivery_date',title:'律师函送达日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.deliveryDate;
							}
						},
					{field:'isClose',title:'是否结案',align:'center',sortable:true,
							styler:function(value,row,index){
								if(value == 1){
								  return 'color:red;';  
								}
							},
							formatter:function(value,row,index){
						   		if(value == 1){
									return "是";//"已结案";
								}
								if(value == 2){
									return "否";//"未结案";
								}
								return "";
							}
						},
					{field:'isDirectAction',title:'是否诉讼',align:'center',sortable:true,
							formatter:function(value,row,index){
						   		if(value == 1){
									return "是";//"诉讼";
								}
								if(value == 2){
									return "否";//"不诉讼";
								}
								return "";
							}
						},
					{field:'remark',title:'备注',align:'left',sortable:false,width:200,
							formatter:function(value,row,index){
								return row.remark;
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
	otter.casePreLitigation.init();
});