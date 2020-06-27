$package('otter.caseApply');
otter.caseApply = function(){
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
				add:function(){
                    $("#ck_actionImg").attr('src','');
                    $("#ck_litigantAcImg").attr('src','');
                    $("#ck_actionImg").css("opacity","0");
                    $("#ck_litigantAcImg").css("opacity","0");
                	$("#ck_actionImg").hide();
                	$("#ck_litigantAcImg").hide();
                	
                	$('input,textarea',$('#editForm')).removeAttr('readonly');
					$('.easyui-combobox , .easyui-datebox',$('#editForm')).combobox('enable');
					$('input[type="button"]',$('#editForm')).removeAttr('disabled');
					//$('#typeIds_combobox').combobox('reload');
					_box.handler.add();
				},
				edit:function(){
					//$('#typeIds_combobox').combobox('reload');
					$('input,textarea',$('#editForm')).removeAttr('readonly');
					$('.easyui-combobox , .easyui-datebox',$('#editForm')).combobox('enable');
					$('input[type="button"]',$('#editForm')).removeAttr('disabled');
					
                    $("#ck_actionImg").attr('src','');
                    $("#ck_litigantAcImg").attr('src','');
                    $("#ck_actionImg").css("opacity","0");
                    $("#ck_litigantAcImg").css("opacity","0");
                    
                	$("#ck_actionImg").hide();
                	$("#ck_litigantAcImg").hide();
					
					var selected = _box.utils.getCheckedRows();
					if ( _box.utils.checkSelectOne(selected)){
						if(!(null==selected[0]['status'] || 0 == selected[0]['status'] || 3 == selected[0]['status'])) {
							otter.alert('提示','案件已推送下阶段处理不能进行编辑！');
							return false;
						}
					}
					
					_box.handler.edit(function(){
						var acimg = $('input[name="actionImg"]',$('#editForm')).val();
						if(''!=acimg){
							$("#ck_actionImg").css("opacity","1");
							$("#ck_actionImg").attr('src',acimg);
							$("#ck_actionImg").show();
						}
						
						var liacimg = $('input[name="litigantAcImg"]',$('#editForm')).val();
						if(''!=liacimg){
							$("#ck_litigantAcImg").css("opacity","1");
							$("#ck_litigantAcImg").attr('src',liacimg);
			                $("#ck_litigantAcImg").show();
						}
					});
				},
				save:function(){
					//判断是否被禁用帐号
//					var state = $("input[name='state']",_box.form.edit).val();
//					if(state != 0){
//						otter.confirm("提示","请仔细检查案件信息是否完整,是否确定?",function(r){
//							if(r){
//								_box.handler.save();
//							}
//						});
//					}else{
//						_box.handler.save();
//					}
					_box.handler.save();
				}
			},
  			dataGrid:{
  				title:'案件确立阶段信息',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
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
						/*
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
				{field:'defendant_name',title:'被告名称',align:'left',sortable:true,width:200,
						formatter:function(value,row,index){
							return row.defendantName;
						}
					},
				{field:'defendant_reg_capital',title:'被告注册资本',align:'left',sortable:true,width:200,
						formatter:function(value,row,index){
							return row.defendantRegCapital;
						}
					},
				{field:'defendant_area',title:'被告所在地',align:'left',sortable:true,width:200,
						formatter:function(value,row,index){
							return row.defendantArea;
						}
					},
					
					{field:'src',title:'案件来源',align:'center',sortable:true,
							formatter:function(value,row,index){
	                    		if(value == 1){
									return "当事人提供";
								}
								if(value == 2){
									return "所内自行搜证";
								}
								if(value == 3){
									return "律师个人案源";
								}
								return "";
							}
						},
					{field:'supply',title:'案源人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.supplyName;
							}
						},
					{field:'isApply',title:'是否公证',align:'center',sortable:true,
							formatter:function(value,row,index){
	                    		if(value == 1){
									return "是";
								}
								if(value == 2){
									return "否";
								}
								return "";
							}
						},
					{field:'apply_date',title:'申请公证日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.applyDate;
							}
						},
					{field:'applicant',title:'公证书申请人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.applicant;
							}
						},
					{field:'forensics',title:'取证人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.forensicsName;
							}
						},
					{field:'violateType',title:'侵权类型',align:'right',sortable:true,
							formatter:function(value,row,index){
	                    		if(value == 1){
									return "肖像权";
								}
								if(value == 2){
									return "肖像权(含名誉权)";
								}
								if(value == 3){
									return "肖像权(含姓名权)";
								}
								if(value == 4){
									return "肖像权(含姓名权、名誉权)";
								}
								if(value == 5){
									return "名誉权";
								}
								if(value == 6){
									return "不当得利纠纷";
								}
								if(value == 7){
									return "合同纠纷";
								}
								return "";
							}
						},
					{field:'violate_desc',title:'侵权概况',align:'left',sortable:true,width:300,
							formatter:function(value,row,index){
								return row.violateDesc;
							}
						},
					{field:'action_date',title:'案件可诉确认日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.actionDate;
							}
						},
					{field:'litigant_ac_date',title:'当事人确认日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.litigantAcDate;
							}
						},
					{field:'isDirectAction',title:'是否直接诉讼',align:'center',sortable:true,
							formatter:function(value,row,index){
	                    		if(value == 1){
									return "是";
								}
								if(value == 2){
									return "否";
								}
								return "";
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
	otter.caseApply.init();
});