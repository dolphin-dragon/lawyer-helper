$package('otter.caseInfo');
otter.caseInfo = function(){
	var _box = null;
	var _this = {
			audit:function(){
				otter.confirm("提示","请仔细检查案件信息，确认审核?",function(r){
					if(r){
//						_box.form.edit.attr('action','pushNext.do');
//						otter.saveForm(_box.form.edit,function(data){
//							otter.closeProgress();//关闭缓冲条
//							_box.win.edit.dialog('close');
//						});
						$('#sp-edit-win').dialog('close');
					}
				});
			},
		config:{
			event:{
				add:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.add(function(){
						$(".ui-edit").show();
					});
				},
				edit:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.edit(function(){
						$(".ui-edit").show();
					});
				}
			},
  			dataGrid:{
  				title:'案件基础信息',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'},
					{id:'btnedit',text:'案件审核',btnType:'audit',iconCls:'icon-tip',handler:function(){
						var record = _box.utils.getCheckedRows();
						if ( _box.utils.checkSelectOne(record)){
							$('#sp-edit-win').dialog({
								buttons:[
									{
										text:'通过',
										handler:_this.audit
									},
									{
										text:'驳回',
										handler:_this.audit
									}
								],
								onClose : function(){
									_box.handler.refresh();
								}
							});

							otter.progress();
							var data = {};
							var idKey = _this.config.dataGrid.idField || 'id'; // 主键名称
							data[idKey] = (record[0][idKey]);
							otter.getById('getAuditId.do', data, function(result) {
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
								
								$('#sp-edit-win').dialog('open');
								
								$(".ui-edit").show();
							});
						}
					}}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'status',title:'状态',align:'center',sortable:true,
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
					{field:'litigant',title:'当事人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.litigant;
							}
						},
					{field:'defendant_name',title:'被告名称',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.defendantName;
							}
						},
					{field:'defendant_reg_capital',title:'被告注册资本',align:'right',sortable:false,
							formatter:function(value,row,index){
								return row.defendantRegCapital;
							}
						},
					{field:'defendant_area',title:'被告所在地',align:'center',sortable:true,
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