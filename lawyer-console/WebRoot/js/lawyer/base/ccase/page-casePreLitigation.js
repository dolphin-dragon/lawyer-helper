$package('otter.casePreLitigation');
otter.casePreLitigation = function(){
	var _box = null;
	var _this = {
		config:{
			event:{
				//add:function(){
				//	$('#typeIds_combobox').combobox('reload');
				//	_box.handler.add();
				//},
				edit:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.edit();
				}
			},
  			dataGrid:{
  				title:'案件诉前和解信息',
	   			url:'dataList.do',
	   			toolbar:[
					//{id:'btnadd',text:'添加',btnType:'add'},
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
						},
					{field:'letter',title:'律师函编号',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.letter;
							}
						},
					{field:'letteror',title:'律师函主办人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.letteror;
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
					{field:'is_close',title:'是否结案',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.isClose;
							}
						},
					{field:'remark',title:'备注',align:'center',sortable:true,
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