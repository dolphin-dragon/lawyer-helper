$package('otter.sysDictItem');
otter.sysDictItem = function(){
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
  				title:'字典项目信息表',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'dict_id',title:'字典id',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.dictId;
							}
						},
					{field:'item_text',title:'字典项文本',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.itemText;
							}
						},
					{field:'item_value',title:'字典项值',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.itemValue;
							}
						},
					{field:'description',title:'描述',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.description;
							}
						},
					{field:'sort_order',title:'排序',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.sortOrder;
							}
						},
					{field:'status',title:'状态（1启用 0不启用）',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.status;
							}
						},
					{field:'del_flag',title:'删除标记 1删除 0正常',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.delFlag;
							}
						},
					{field:'created_by',title:'created_by',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createdBy;
							}
						},
					{field:'created_time',title:'created_time',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createdTime;
							}
						},
					{field:'updated_by',title:'updated_by',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updatedBy;
							}
						},
					{field:'updated_time',title:'updated_time',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updatedTime;
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
	otter.sysDictItem.init();
});