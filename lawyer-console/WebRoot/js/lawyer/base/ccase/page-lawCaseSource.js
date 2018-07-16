$package('otter.lawCaseSource');
otter.lawCaseSource = function(){
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
  				title:'案源信息收集数据表',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'code',title:'案源编码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.code;
							}
						},
					{field:'title',title:'案源名称',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.title;
							}
						},
					{field:'c_desc',title:'案源描述',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cDesc;
							}
						},
					{field:'record_date',title:'案源接收日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.recordDate;
							}
						},
					{field:'close_date',title:'结案日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.closeDate;
							}
						},
					{field:'receive_date',title:'回款日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.receiveDate;
							}
						},
					{field:'m_lawyer',title:'主办律师',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.mLawyer;
							}
						},
					{field:'provider',title:'案源提供者',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.provider;
							}
						},
					{field:'status',title:'处理状态',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.status;
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
	otter.lawCaseSource.init();
});