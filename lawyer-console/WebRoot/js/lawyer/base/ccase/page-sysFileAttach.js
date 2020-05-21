$package('otter.sysFileAttach');
otter.sysFileAttach = function(){
	var _box = null;
	var _this = {
		config:{
			event:{
				add:function(){
					//$("#uploadAttach").click();
					_box.handler.add();
				},
				edit:function(){
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
					{field:'note',title:'说明',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.note;
						}
					},
					{field:'ext',title:'扩展名',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.ext;
							}
						},
					{field:'filetype',title:'文件类型',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.filetype;
							}
						},
					{field:'size',title:'文件大小',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.size;
						}
					},
					{field:'createdTime',title:'创建时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createdTime;
							}
						},
					{field:'createdBy',title:'上传者',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createdName;
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