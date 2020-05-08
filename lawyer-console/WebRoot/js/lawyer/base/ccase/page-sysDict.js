$package('otter.sysDict');
otter.sysDict = function(){
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
  				title:'字典信息表',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'dictName',title:'字典名称',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.dictName;
							}
						},
					{field:'dictCode',title:'字典编码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.dictCode;
							}
						},
					{field:'description',title:'描述',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.description;
							}
						},
					{field:'delFlag',title:'删除状态',align:'center',sortable:true,
							formatter:function(value,row,index){
								if(value == 1){
									return "删除";
								}
								if(value == 0){
									return "有效";
								}
								return "有效";
							}
						},
						{field:'_',title:'操作',align:'center',sortable:true,
							formatter:function(value,row,index){
								return "<a href='#' onclick='otter.sysDict.qItems("+row.id+",\""+row.dictName+"\")'>查看条目</a> <a href='#' style='color:green;' onclick='otter.sysDict.addItems("+row.id+",\""+row.dictName+"\")'>添加条目</a>";
							}
						}
					/*{field:'created_by',title:'创建人',align:'center',sortable:true,
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
					{field:'type',title:'字典类型0为string,1为number',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.type;
							}
						},*/
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
	otter.sysDict.init();
});