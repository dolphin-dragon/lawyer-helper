$package('otter.criminalCase');
otter.criminalCase = function(){
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
  				title:'刑事案件信息表',
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
					{field:'src',title:'案件来源',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.src;
							}
						},
					{field:'supply',title:'案源人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.supply;
							}
						},
					{field:'commission_date',title:'签署委托日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.commissionDate;
							}
						},
					{field:'client',title:'委托人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.client;
							}
						},
					{field:'lawyer',title:'代理律师',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.lawyer;
							}
						},
					{field:'litigant',title:'当事人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.litigant;
							}
						},
					{field:'suspected_charges',title:'涉嫌罪名',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.suspectedCharges;
							}
						},
					{field:'action_stage',title:'诉讼阶段',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.actionStage;
							}
						},
					{field:'judgment_date',title:'判决日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.judgmentDate;
							}
						},
					{field:'is_close',title:'是否结案',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.isClose;
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
	otter.criminalCase.init();
});