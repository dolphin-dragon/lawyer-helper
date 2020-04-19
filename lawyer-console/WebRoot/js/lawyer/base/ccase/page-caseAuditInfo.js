$package('otter.caseAuditInfo');
otter.caseInfo = function(){
	var _box = null;
	var _this = {
			auditY:function(){
				otter.confirm("提示","请仔细检查案件信息，确认审核?",function(r){
					if(r){
						$('#typeIds').val(1);
						$('#base_Form').attr('action','audit.do');
						otter.saveForm($('#base_Form'),function(data){
							otter.closeProgress();//关闭缓冲条
							$('#sp-edit-win').dialog('close');
						});
					}
				});
			},
			auditN:function(){
				otter.confirm("提示","请仔细检查案件信息，确认驳回?",function(r){
					if(r){
						$('#typeIds').val(2);
						$('#base_Form').attr('action','audit.do');
						otter.saveForm($('#base_Form'),function(data){
							otter.closeProgress();//关闭缓冲条
							$('#sp-edit-win').dialog('close');
						});
					}
				});
			},
		config:{
			event:{
				add:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.add();
				},
				edit:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.edit();
				}
			},
  			dataGrid:{
  				title:'案件列表信息',
	   			url:'auditData.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'},
					{id:'btnaudit',text:'案件审核',btnType:'audit',iconCls:'icon-tip',handler:function(){
						var record = _box.utils.getCheckedRows();
						if ( _box.utils.checkSelectOne(record)){
							if(null == record[0]['status'] || 'null' == record[0]['status'] || 0 > record[0]['status'] ||record[0]['status'] >10 ) {
								otter.alert('提示','案件未发起审批，请重新选择待审批案件！');
								return false;
							}
							
							$('#sp-edit-win').dialog({
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
									_box.handler.refresh();
								},
								onOpen : function(){
									$("#ck_actionImg").attr('src','');
					                $("#ck_litigantAcImg").attr('src','');
					                $("#ck_actionImg").css("opacity","0");
					                $("#ck_litigantAcImg").css("opacity","0");
									
									var acimg = $('input[name="actionImg"]',$('#app_Form')).val();
									if(''!=acimg){
										$("#ck_actionImg").attr('src',acimg);
										$("#ck_actionImg").css("opacity","1");
									}
									
									var liacimg = $('input[name="litigantAcImg"]',$('#app_Form')).val();
									if(''!=liacimg){
										$("#ck_litigantAcImg").attr('src',liacimg);
										$("#ck_litigantAcImg").css("opacity","1");
									}
								}
							});

							otter.progress();
							var data = {};
							var idKey = _this.config.dataGrid.idField || 'id'; // 主键名称
							data[idKey] = (record[0][idKey]);
							otter.getById('getAuditId.do', data, function(result) {
								
								//TODO:
//								visibility:hidden/visible 设置为隐藏/显示(始终占位)
//								display:none/block 设置为隐藏(不占位)/显示(不占位)
//								$('#divMain').css("visibility", "hidden"); 
//								$('#divMain').css("visibility", "visible"); 
								
								//$('#sp-edit-win').css("visibility", "visible"); 
								$('div',$('#sp-edit-win')).css("visibility", "visible");
								
								$('#base_Form').form('load', result.data);
								$('#app_Form').form('load', result.app);
								$('#pre_Form').form('load', result.pre);
								$('#first_Form').form('load', result.first);
								$('#second_Form').form('load', result.second);
								$('#out_Form').form('load', result.out);
								
								otter.closeProgress();
								
								//控制界面原始不可用
								$('input,textarea',$('#base_Form')).attr('readonly',true);
								$('.easyui-combobox , .easyui-datebox,.easyui-datetimebox',$('#base_Form')).combobox('disable');
								$('input[type="button"]',$('#base_Form')).attr('disabled',true);
								
								//控制界面原始不可用
								$('input,textarea',$('#app_Form')).attr('readonly',true);
								$('.easyui-combobox , .easyui-datebox',$('#app_Form')).combobox('disable');
								$('input[type="button"]',$('#app_Form')).attr('disabled',true);
								
								//控制界面原始不可用
								$('input,textarea',$('#pre_Form')).attr('readonly',true);
								$('.easyui-combobox , .easyui-datebox',$('#pre_Form')).combobox('disable');
								$('input[type="button"]',$('#pre_Form')).attr('disabled',true);
								
								//控制界面原始不可用
								$('input,textarea',$('#first_Form')).attr('readonly',true);
								$('.easyui-combobox , .easyui-datebox',$('#first_Form')).combobox('disable');
								$('input[type="button"]',$('#first_Form')).attr('disabled',true);
								
								//控制界面原始不可用
								$('input,textarea',$('#second_Form')).attr('readonly',true);
								$('.easyui-combobox , .easyui-datebox',$('#second_Form')).combobox('disable');
								$('input[type="button"]',$('#second_Form')).attr('disabled',true);
								
								//控制界面原始不可用
								$('input,textarea',$('#out_Form')).attr('readonly',true);
								$('.easyui-combobox , .easyui-datebox',$('#out_Form')).combobox('disable');
								$('input[type="button"]',$('#out_Form')).attr('disabled',true);

								$("#sp-tabs").tabs('select',0);
								$('#sp-edit-win').dialog('open');
							});
						}
					}}
				],
	   			columns:[[
					{field:'id',checkbox:true},
//					{field:'status',title:'状态',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.status;
//							}
//						},
//					{field:'org',title:'机构编码',align:'center',sortable:true,
//							formatter:function(value,row,index){
//								return row.org;
//							}
//						},
					{field:'status',title:'案件状态',align:'center',sortable:true,
						styler:function(value,row,index){
							if(null != value){
								if(0< value && value < 10){
									return 'color:green;';
								}
								if(value < 0){
									return 'color:red;';
								}if(value > 90){
									return 'color:blue;';
								}
							}
						},
						formatter:function(value,row,index){
							if(null != value){
								if(0<value && value< 10){
									return "结案申请";
								}
								if(value < 0){
									return "结案驳回";
								}if(value > 90){
									return "结案通过";
								}								
							}
							return "进行中";
						}
					},
					{field:'created_by',title:'创建人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createName;
							}
						},
					{field:'created_time',title:'创建时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createdTime;
							}
						},
					{field:'updated_by',title:'更新人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updateName;
							}
						},
					{field:'updated_time',title:'更新时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updatedTime;
							}
						},
					{field:'litigant',title:'当事人',align:'left',sortable:true,
							formatter:function(value,row,index){
								return row.litigant;
							}
						},
					{field:'defendant_name',title:'被告名称',align:'left',sortable:true,
							formatter:function(value,row,index){
								return row.defendantName;
							}
						},
					{field:'defendant_reg_capital',title:'被告注册资本',align:'left',sortable:true,
							formatter:function(value,row,index){
								return row.defendantRegCapital;
							}
						},
					{field:'defendant_area',title:'被告所在地',align:'left',sortable:true,
							formatter:function(value,row,index){
								return row.defendantArea;
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
	otter.caseInfo.init();
});