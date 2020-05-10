$package('otter.noLitigationCase');
otter.noLitigationCase = function(){
	var _box = null;
	var _this = {
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
  				title:'非诉业务信息表',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'status',title:'状态',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.status;
							}
						},
					{field:'del_flag',title:'删除标记',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.delFlag;
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
					{field:'nolitigation_customer_id',title:'非诉业务客户ID',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.nolitigationCustomerId;
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