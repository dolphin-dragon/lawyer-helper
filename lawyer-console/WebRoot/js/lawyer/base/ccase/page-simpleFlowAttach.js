$package('otter.simpleFlowAttach');
otter.simpleFlowAttach = function(){
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
  				title:'简单流程关联附件信息表',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'sflow_id',title:'流程id',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.sflowId;
							}
						},
					{field:'sfile_attach_id',title:'附件id',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.sfileAttachId;
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
	otter.simpleFlowAttach.init();
});