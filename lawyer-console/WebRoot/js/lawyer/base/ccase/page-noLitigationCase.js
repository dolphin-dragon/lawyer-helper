$package('otter.noLitigationCase');
otter.noLitigationCase = function(){
	var _box = null;
	var _this = {
		config:{
			event:{
				add:function(){
					var selected = _box.utils.getCheckedRows();
					if ( _box.utils.checkSelectOne(selected)){
						otter.confirm("提示","确认对["+selected[0]['client']+"]客户增加工作项,请确认?",function(r){
							if(r){
								otter.progress();
								var data ={};
			 					data['id'] = (selected[0]['nolitigationCustomerId']);
								otter.getById('getCustId.do',data,function(result){
									otter.closeProgress();
									_box.form.edit.form('load',result.data);
									
									$('#etype').attr('value', '1');
									$('input,textarea',$('#cust')).attr('readonly',true);
									$('#nolitigationCustomerId').attr('value', selected[0]['nolitigationCustomerId']);
									$('#id').attr('value', '');
									$('input,textarea',$('#case')).removeAttr('value');
									$('#case').css("display", "block");
									
									_box.win.edit.dialog('open'); 
								});
							}
						});
						//_box.handler.add();
					}
				},
				edit:function(){
					var selected = _box.utils.getCheckedRows();
					if(null == selected[0]['id'] || 'null' == selected[0]['id'] || '' == selected[0]['id']){
						otter.alert('提示','当前客户没有可编辑的工作项！');
						return;
					}
					if ( _box.utils.checkSelectOne(selected)){
						$('#etype').attr('value', '1');
						$('#case').css("display", "block");
						$('input,textarea',$('#cust')).attr('readonly',true);

						_box.handler.edit();
					}
				},
				remove: function(){
					$('#etype').attr('value', '1');
					_box.handler.remove();
				}
			},
  			dataGrid:{
  				title:'非诉业务信息表',
	   			url:'dataList.do',
	   			toolbar:[
	   				{id:'btnadd',text:'添加客户',btnType:'btnaddCust',iconCls:'icon-add',handler:function(){
	   					$('input,textarea',$('#cust')).removeAttr('value');
	   					$('input,textarea',$('#cust')).removeAttr('readonly');

						$('#etype').attr('value', '0');
						_box.handler.add(new function(){
							//控制界面原始不可用
							$('#case').css("display", "none");
						});
					}},
					{id:'btnedit',text:'修改客户',btnType:'btneditCust',iconCls:'icon-edit',handler:function(){
						var selected = _box.utils.getCheckedRows();
						if ( _box.utils.checkSelectOne(selected)){
							otter.confirm("提示","修改客户信息后,影响后续案件信息,请确认?",function(r){
								if(r){
									otter.progress();
									var data ={};
				 					data['id'] = (selected[0]['nolitigationCustomerId']);
									otter.getById('getCustId.do',data,function(result){
										otter.closeProgress();
										_box.form.edit.form('load',result.data);
										
										$('#etype').attr('value', '0');
										$('input,textarea',$('#cust')).removeAttr('readonly');
										$('#nolitigationCustomerId').attr('value', selected[0]['nolitigationCustomerId']);
										$('#case').css("display", "none");
										
										_box.win.edit.dialog('open'); 
									});
									
								}
							});
						}
					}},
					{id:'btndelete',text:'删除客户',btnType:'btndeleteCust',iconCls:'icon-remove',handler:function(){
						var records = _box.utils.getCheckedRows();
						if ( _box.utils.checkSelectOne(records)){
							$('#etype').attr('value', '0');
							otter.confirm("提示","删除客户后,将不能对当前客户做任何操作,请确认?",function(r){
								if(r){
									otter.progress();
							    	var arr = []; //主键名称
							    	$.each(records,function(i,record){
							    		arr.push('id='+record['nolitigationCustomerId']);
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
					{id:'btnadd',text:'添加工作项',btnType:'add'},
					{id:'btnedit',text:'修改工作项',btnType:'edit'},
					{id:'btndelete',text:'删除工作项',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
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
						},*/
					{field:'nolitigation_customer_id',title:'非诉业务客户ID',align:'center',sortable:true,hidden:true,
							formatter:function(value,row,index){
								return row.nolitigationCustomerId;
							}
					},
					{field:'client',title:'委托人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.client;
							}
					},
					{field:'principal',title:'被委托人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.principal;
							}
					},
					{field:'commission_sdate',title:'委托开始时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.commissionSdate;
							}
					},
					{field:'commission_edate',title:'委托结束时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.commissionEdate;
							}
					},
					{field:'custDelFlag',title:'委托人状态',align:'center',sortable:true,
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

					{field:'billing_model',title:'计费模式',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.billingModel;
							}
						},
					{field:'billing_standard',title:'计费标准',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.billingStandard;
							}
						},
					{field:'receive_date',title:'需求接收日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.receiveDate;
							}
						},
					{field:'src',title:'接收途径',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.src;
							}
						},
					{field:'work_content',title:'工作内容',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.workContent;
							}
						},
					{field:'party_draft_name',title:'当事人底稿名称',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.partyDraftName;
							}
						},
					{field:'contract_party',title:'合同相对放',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.contractParty;
							}
						},
					{field:'resp_date',title:'返稿日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.respDate;
							}
						},
					{field:'resp_file_name',title:'律师返稿文件名称',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.respFileName;
							}
						},
					{field:'account_time',title:'核算用时',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.accountTime;
							}
						},
					{field:'delFlag',title:'工作项状态',align:'center',sortable:true,
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
					{field:'remark',title:'特殊情况备注',align:'center',sortable:true,
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
	otter.noLitigationCase.init();
});