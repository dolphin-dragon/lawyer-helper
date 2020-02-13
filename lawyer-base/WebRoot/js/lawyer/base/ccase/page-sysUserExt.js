$package('otter.sysUserExt');
otter.sysUserExt = function(){
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
  				title:'用户信息设置',
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
					{field:'uid',title:'用户id',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.uid;
							}
						},
					{field:'name',title:'姓名',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.name;
							}
						},
					{field:'sex',title:'性别',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.sex;
							}
						},
					{field:'phone',title:'手机号',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.phone;
							}
						},
					{field:'tel',title:'联系电话',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.tel;
							}
						},
					{field:'qq',title:'qq号码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.qq;
							}
						},
					{field:'position',title:'职位类别',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.position;
							}
						},
					{field:'entry_date',title:'入职时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.entryDate;
							}
						},
					{field:'birt',title:'出生日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.birt;
							}
						},
					{field:'remark',title:'备注',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.remark;
							}
						},
					{field:'del_flg',title:'删除标记',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.delFlg;
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
	otter.sysUserExt.init();
});