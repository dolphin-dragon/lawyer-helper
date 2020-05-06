$package('otter.sysFileAttach');
otter.sysFileAttach = function(){
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
  				title:'附件信息表',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'filename',title:'文件名',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.filename;
							}
						},
					{field:'filepath',title:'文件路径',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.filepath;
							}
						},
					{field:'ext',title:'扩展名',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.ext;
							}
						},
					{field:'filetype',title:'fileType',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.filetype;
							}
						},
					{field:'note',title:'说明',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.note;
							}
						},
					{field:'created_time',title:'创建时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createdTime;
							}
						},
					{field:'created_by',title:'上传者',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createdBy;
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
	otter.sysFileAttach.init();
});