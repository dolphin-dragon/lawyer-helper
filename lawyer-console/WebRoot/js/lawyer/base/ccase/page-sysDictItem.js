$package('otter.sysDictItem');
otter.sysDictItem = function(){
	var _box = null;
	var _this = {
		config:{
			event:{
				add:function(){
					var selected = _box.utils.getCheckedRows();
					if ( _box.utils.checkSelectOne(selected)){
						$('#dictId').attr('value', selected[0]['dictId']);
						$('#dictName').attr('value', selected[0]['dictName']);
						$('#dictCode').attr('value', selected[0]['dictCode']);
						$('#etype').attr('value', '1');
						$('#itemText').css("display", "block");
						$('#itemValue').css("display", "block");
						
						_box.handler.add(new function(){
							//控制界面原始不可用
							$('input[name="dictName"]',$('#editForm')).attr('readonly',true);//.attr("disabled","disabled");
							$('input[name="dictCode"]',$('#editForm')).attr('readonly',true);//.attr("disabled","disabled");
						});
					}
				},
				edit:function(){
					var selected = _box.utils.getCheckedRows();
					if ( _box.utils.checkSelectOne(selected)){
						if(null == selected[0]['id'] || 'null' == selected[0]['id'] || '' == selected[0]['id']){
							otter.alert('提示','当前字典未设置项目不可编辑！');
							return;
						}
						$('#dictId').attr('value', selected[0]['dictId']);
						$('#dictName').attr('value', selected[0]['dictName']);
						$('#dictCode').attr('value', selected[0]['dictCode']);
						$('#etype').attr('value', '1');
						$('#itemText').css("display", "block");
						$('#itemValue').css("display", "block");
						_box.handler.edit(new function(){
							//控制界面原始不可用
							$('input[name="dictName"]',$('#editForm')).attr('readonly',true);//.attr("disabled","disabled");
							$('input[name="dictCode"]',$('#editForm')).attr('readonly',true);//.attr("disabled","disabled");
						});
					}
				},
				remove: function(){
					$('#etype').attr('value', '1');
					_box.handler.remove();
				}
			},
  			dataGrid:{
  				title:'字典项目信息表',
	   			url:'dataList.do',
	   			toolbar:[
	   				{id:'btnadd',text:'添加字典',btnType:'btnaddDict',iconCls:'icon-add',handler:function(){
	   					$('input,textarea',$('#editForm')).removeAttr('value');
	   					$('input,textarea',$('#editForm')).removeAttr('readonly');
	   					
						$('#etype').attr('value', '0');
						_box.handler.add(new function(){
							//控制界面原始不可用
							$('#itemText').css("display", "none");
							$('#itemValue').css("display", "none");
						});
					}},
					{id:'btnedit',text:'修改字典',btnType:'btneditDict',iconCls:'icon-edit',handler:function(){
						var selected = _box.utils.getCheckedRows();
						if ( _box.utils.checkSelectOne(selected)){
							otter.confirm("提示","编辑字典后,影响所有字典条目,请确认?",function(r){
								if(r){
									$('input,textarea',$('#editForm')).removeAttr('readonly');
									$('#etype').attr('value', '0');
									$('#dictId').attr('value', selected[0]['dictId']);
									$('#dictName').attr('value', selected[0]['dictName']);
									$('#dictCode').attr('value', selected[0]['dictCode']);
									$('input[name="description"]',$('#editForm')).attr("value",selected[0]['dictDescription']);
									_box.handler.add(new function(){
										//控制界面原始不可用
										$('#itemText').css("display", "none");
										$('#itemValue').css("display", "none");
									});
								}
							});
						}
					}},
					{id:'btndelete',text:'删除字典',btnType:'btndeleteDict',iconCls:'icon-remove',handler:function(){
						var records = _box.utils.getCheckedRows();
						if ( _box.utils.checkSelectOne(records)){
							$('#etype').attr('value', '0');
							otter.confirm("提示","删除字典后,所有字典条目不可用,请确认?",function(r){
								if(r){
									otter.progress();
							    	var arr = []; //主键名称
							    	$.each(records,function(i,record){
							    		arr.push('id='+record['dictId']);
							    	});
							    	arr.push('etype=0');
							    	var data = arr.join("&");
							   		otter.deleteForm('delete.do',data,function(result){
										otter.closeProgress();
										_box.events.refresh();
									});
								}
							});
						}
					}},
					{id:'btnadd',text:'添加条目',btnType:'add'},
					{id:'btnedit',text:'修改条目',btnType:'edit'},
					{id:'btndelete',text:'删除条目',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'dictId',title:'字典标识',align:'center',sortable:true,hidden:true,
							formatter:function(value,row,index){
								return row.dictId;
							}
					},
					{field:'dictCode',title:'字典编码',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.dictCode;
						}
					},
					{field:'dictName',title:'字典名称',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.dictName;
						}
					},
					{field:'dictDescription',title:'字典说明',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.dictDescription;
						}
					},
					{field:'dictDelFlag',title:'字典状态',align:'center',sortable:true,
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

					{field:'item_value',title:'条目编码',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.itemValue;
						}
					},
					{field:'item_text',title:'条目名称',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.itemText;
							}
					},
					{field:'description',title:'条目说明',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.description;
							}
					},
			/*		{field:'sort_order',title:'排序',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.sortOrder;
							}
						},*/
					{field:'status',title:'是否启用',align:'center',sortable:true,
							styler:function(value,row,index){
								if(value == 1){
								  return 'color:green;';  
								}
								if(value == 0){
									return "color:red;";
								}
								return 'color:green;';  
							},
							formatter:function(value,row,index){
								if(value == 1){
									return "已启用";
								}
								if(value == 0){
									return "未启用";
								}
								return "已启用";
							}
						},
					{field:'delFlag',title:'条目状态',align:'center',sortable:true,
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
					/*{field:'created_by',title:'created_by',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createdBy;
							}
						},
					{field:'created_time',title:'created_time',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createdTime;
							}
						},
					{field:'updated_by',title:'updated_by',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updatedBy;
							}
						},
					{field:'updated_time',title:'updated_time',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updatedTime;
							}
						},*/
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
	otter.sysDictItem.init();
});