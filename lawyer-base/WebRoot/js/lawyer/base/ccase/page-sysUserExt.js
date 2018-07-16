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
  				title:'用户设置',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
/*					{field:'uid',title:'用户ID',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.uid;
							}
						},*/
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
					{field:'email',title:'注册邮箱',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.email;
							}
					},	
					{field:'phone',title:'手机号码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.phone;
							}
						},
					{field:'tel',title:'联系电话',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.tel;
							}
						},
					{field:'qq',title:'QQ号码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.qq;
							}
						},
					{field:'position',title:'职位类别',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.position;
							}
						},
					{field:'birt',title:'出生日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.birt;
							}
						},
					{field:'entrydate',title:'入职时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.entrydate;
							}
						},
					{field:'create_by',title:'创建者ID',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createBy;
							}
						},
					{field:'create_name',title:'创建人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createName;
							}
						},
					{field:'create_date',title:'创建时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createDate;
							}
						},
					{field:'update_by',title:'修改人ID',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updateBy;
							}
						},
					{field:'update_name',title:'修改人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updateName;
							}
						},
					{field:'update_date',title:'修改时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updateDate;
							}
						},
					{field:'remarks',title:'备注信息',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.remarks;
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
	otter.sysUserExt.init();
});