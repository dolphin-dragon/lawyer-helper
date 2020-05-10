$package('otter.noLitigationCustomer');
otter.noLitigationCustomer = function(){
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
  				title:'非诉业务客户信息表',
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
	otter.noLitigationCustomer.init();
});