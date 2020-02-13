$package('otter.caseCustomer');
otter.caseCustomer = function(){
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
  				title:'客户信息',
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
					{field:'code',title:'客户编码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.code;
							}
						},
					{field:'ctype',title:'客户类型',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.ctype;
							}
						},
					{field:'id_card',title:'客户身份证信息',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.idCard;
							}
						},
					{field:'e_code',title:'企业组织机构代码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.eCode;
							}
						},
					{field:'phone',title:'联系电话',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.phone;
							}
						},
					{field:'link_man',title:'联系人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.linkMan;
							}
						},
					{field:'remark',title:'备注',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.remark;
							}
						},
					{field:'del_flag',title:'删除标记',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.delFlag;
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
	otter.caseCustomer.init();
});