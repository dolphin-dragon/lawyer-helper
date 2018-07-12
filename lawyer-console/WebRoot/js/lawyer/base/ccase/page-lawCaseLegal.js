$package('otter.lawCaseLegal');
otter.lawCaseLegal = function(){
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
  				title:'案件信息登记数据表',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'scode',title:'案源编号',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.scode;
							}
						},
					{field:'code',title:'案件案号',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.code;
							}
						},
					{field:'cause',title:'案由',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cause;
							}
						},
					{field:'plaintiff',title:'原告',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.plaintiff;
							}
						},
					{field:'defendant',title:'被告',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.defendant;
							}
						},
					{field:'cprocedure',title:'适用程序',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cprocedure;
							}
						},
					{field:'case_date',title:'立案日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseDate;
							}
						},
					{field:'open_date',title:'开庭日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.openDate;
							}
						},
					{field:'case_source_id',title:'案源编号',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseSourceId;
							}
						},
					{field:'judge',title:'承办法官',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.judge;
							}
						},
					{field:'lawyer',title:'承办律师',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.lawyer;
							}
						},
					{field:'cdesc',title:'案件情况',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cdesc;
							}
						},
					{field:'create_by',title:'创建者',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createBy;
							}
						},
					{field:'create_date',title:'创建时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createDate;
							}
						},
					{field:'update_by',title:'更新者',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updateBy;
							}
						},
					{field:'update_date',title:'更新时间',align:'center',sortable:true,
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
	otter.lawCaseLegal.init();
});