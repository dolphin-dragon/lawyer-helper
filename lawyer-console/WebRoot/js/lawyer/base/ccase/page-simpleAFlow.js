$package('otter.simpleFlow');
otter.simpleFlow = function(){
	var _box = null;
	var _this = {
			auditY:function(){
				otter.confirm("提示","请仔细检查流程信息，确认审核?",function(r){
					if(r){
						$('#typeIds').val(1);
						_box.form.edit.attr('action','audit.do');
						otter.saveForm(_box.form.edit,function(data){
							otter.closeProgress();//关闭缓冲条
							_box.win.edit.dialog('close');
						});
					}
				});
			},
			auditN:function(){
				otter.confirm("提示","请仔细检查流程信息，确认驳回?",function(r){
					if(r){
						$('#typeIds').val(2);
						_box.form.edit.attr('action','audit.do');
						otter.saveForm(_box.form.edit,function(data){
							otter.closeProgress();//关闭缓冲条
							_box.win.edit.dialog('close');
						});
					}
				});
			},
			flowClose:function(){
				otter.confirm("提示","请仔细检查流程信息，确认完结关闭?",function(r){
					if(r){
						$('#typeIds').val(3);
						_box.form.edit.attr('action','audit.do');
						otter.saveForm(_box.form.edit,function(data){
							otter.closeProgress();//关闭缓冲条
							_box.win.edit.dialog('close');
						});
					}
				});
			},
		config:{
			event:{
//				add:function(){
//					_box.handler.add();
//				},
				edit:function(){
					var selected = _box.utils.getCheckedRows();
					if ( _box.utils.checkSelectOne(selected)){
						if(!(1 == selected[0]['status'])){
							otter.alert('提示','当前流程不是待审批状态，不能进行审批操作！');
							return;
						}
						_box.win.edit.dialog({
							buttons:[
								{
									text:'通过',
									handler:_this.auditY
								},
								{
									text:'驳回',
									handler:_this.auditN
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
		                $("#ck_fileAckImg").hide();
	                	$("#ck_bizAckImg").hide();
	                	attachs_dataGrid.datagrid('loadData', { total: 0, rows: [] });
	                	$("#attachs-dv").hide();
	                	
						_box.handler.edit(function(result){
							$('input,textarea',_box.form.edit).attr('readonly',true);
							$('.easyui-combobox , .easyui-datebox,.easyui-datetimebox',_box.form.edit).combobox('disable');
							$('input[type="button"]',_box.form.edit).attr('disabled',true);
							
							var acimg = $('input[name="fileAckImg"]',$('#editForm')).val();
							if(''!=acimg){
								$("#ck_fileAckImg").css("opacity","1").css("width","200px").css("height","100px");
								$("#ck_fileAckImg").attr('src',acimg);
								$("#ck_fileAckImg").show();
							}
							
							var liacimg = $('input[name="bizAckImg"]',$('#editForm')).val();
							if(''!=liacimg){
								$("#ck_bizAckImg").css("opacity","1").css("width","200px").css("height","100px");
								$("#ck_bizAckImg").attr('src',liacimg);
				                $("#ck_bizAckImg").show();
							}
							
							console.log("attachs :"+result.data.attachs);
							if(null != result.data.attachs){
								attachs_dataGrid.datagrid('loadData',result.data.attachs);
								$("#attachs-dv").hide();
							}
						});
					}
				}
			},
  			dataGrid:{
  				title:'简单流程列表',
	   			url:'adataList.do',
	   			toolbar:[
					//{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'审批',btnType:'edit'},
					{id:'btnclose',text:'关闭',btnType:'close',iconCls:'icon-tip',handler:function(){
						var selected = _box.utils.getCheckedRows();
						if ( _box.utils.checkSelectOne(selected)){
							if(!(2 == selected[0]['status'])){
								otter.alert('提示','当前流程未审批通过，不能进行流程关闭操作！');
								return;
							}
							_box.win.edit.dialog({
								buttons:[
									{
										text:'流程关闭',
										handler:_this.flowClose
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
			                $("#ck_fileAckImg").hide();
		                	$("#ck_bizAckImg").hide();
		                	attachs_dataGrid.datagrid('loadData', { total: 0, rows: [] });
		                	$("#attachs-dv").hide();
			                
							_box.handler.edit(function(result){
								$('input,textarea',_box.form.edit).attr('readonly',true);
								$('.easyui-combobox , .easyui-datebox,.easyui-datetimebox',_box.form.edit).combobox('disable');
								$('input[type="button"]',_box.form.edit).attr('disabled',true);
								
								var acimg = $('input[name="fileAckImg"]',$('#editForm')).val();
								if(''!=acimg){
									$("#ck_fileAckImg").css("opacity","1").css("width","200px").css("height","100px");
									$("#ck_fileAckImg").attr('src',acimg);
									$("#ck_fileAckImg").show();
								}
								
								var liacimg = $('input[name="bizAckImg"]',$('#editForm')).val();
								if(''!=liacimg){
									$("#ck_bizAckImg").css("opacity","1").css("width","200px").css("height","100px");
									$("#ck_bizAckImg").attr('src',liacimg);
					                $("#ck_bizAckImg").show();
								}
								
								console.log("attachs :"+result.data.attachs);
								if(null != result.data.attachs && result.data.attachs.length>0){
									attachs_dataGrid.datagrid('loadData',result.data.attachs);
									$("#attachs-dv").show();
								}
							});
						}
						}
					}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'tid',title:'流程编号',align:'center',sortable:false,
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
	//附件处理
	attachs_dataGrid = $('#attachs-list').datagrid({
			url:'',
			fit:true,
			fitColumns:true,
			width:200,
			height:160,
			/*toolbar:[
			{id:'btnadd',text:'添加附件',btnType:'add',iconCls:'icon-edit',handler:function(){
				commonAjaxFileUploadDG(function(data) {
					//data.url data.path
					//console.log("add attachs :"+JSON.stringify(data));
					
					var url =  urls['msUrl'] + '/sysFileAttach/ajaxSave.do'
					var option = {'filename':data.fname,
								  'filepath':data.path,
								  'filetype':data.ftype,
								  'ext':data.fext,
								  'size':data.fsize,
								  'url':data.url
								  };

					 otter.ajaxJson(url,option,function(result){
						// console.log("ajax save attachs: "+JSON.stringify(result))
						// console.log("ajax save attachs id : "+result.data.id)
							$('#attachs-list').datagrid('insertRow',{
							    index: 0,   // 索引从0开始
							    row: {
							        id: result.data.id,
							        filename: data.fname,
							        filepath: data.path,
							        filetype: data.ftype,
							        url: data.url,
							        ext: data.fext,
							        size: data.fsize,
							    }
							});
					 });
				})
			}},
			{id:'btndelete',text:'删除附件',btnType:'remove',iconCls:'icon-remove',handler:function(){
				var row = attachs_dataGrid.datagrid('getChecked');	
				if (otter.simpleFlow.checkSelectOne(row)){
					 var index = attachs_dataGrid.datagrid("getRowIndex",row[0]);  
					 attachs_dataGrid.datagrid("deleteRow",index);  
				}
			}}
		],*/
			columns:[[
				{field:'id',checkbox:true},
			{field:'filename',title:'附件名称',align:'center',sortable:false,width:200,
					formatter:function(value,row,index){
						var html ="<a href='"+row.url+"' target='_blank'>"+row.filename+"</a>";
						return html;
						//return row.filename;
					}
			},
			{field:'filepath',hidden:true},
			{field:'filetype',hidden:true},
			{field:'ext',hidden:true},
			{field:'url',hidden:true},
			{field:'size',hidden:true},
		]]
	});
});