$package('otter.sysDictItem');
otter.sysDictItem = function(){
	var _box = null;
	var _this = {
		config:{
			event:{
				add:function(){
					$('#typeIds_combobox').combobox('reload');
					var selected = _box.utils.getCheckedRows();
					if ( _box.utils.checkSelectOne(selected)){
						$('#dictId').attr('value', selected[0]['dictId']);
						$('#dictName').attr('value', selected[0]['dictName']);
						$('#dictCode').attr('value', selected[0]['dictCode']);
						
						_box.handler.add(new function(){
							//控制界面原始不可用
							$('input[name="dictId"]',$('#editForm')).attr("disabled","disabled");
							$('input[name="dictName"]',$('#editForm')).attr("disabled","disabled");
							$('input[name="dictCode"]',$('#editForm')).attr("disabled","disabled");
						});
					}
				},
				edit:function(){
					$('#typeIds_combobox').combobox('reload');
					var selected = _box.utils.getCheckedRows();
					if ( _box.utils.checkSelectOne(selected)){
						$('#dictId').attr('value', selected[0]['dictId']);
						$('#dictName').attr('value', selected[0]['dictName']);
						$('#dictCode').attr('value', selected[0]['dictCode']);
						_box.handler.edit(new function(){
							//控制界面原始不可用
							$('input[name="dictId"]',$('#editForm')).attr("disabled","disabled");
							$('input[name="dictName"]',$('#editForm')).attr("disabled","disabled");
							$('input[name="dictCode"]',$('#editForm')).attr("disabled","disabled");
						});
					}
				}
			},
  			dataGrid:{
  				title:'字典项目信息表',
	   			url:'dataList.do',
	   			toolbar:[
	   				{id:'btnadd',text:'添加字典类',btnType:'btnaddDict',iconCls:'icon-add',handler:function(){
						alert('添加字典类');
					}},
					{id:'btnedit',text:'修改字典类',btnType:'btneditDict',iconCls:'icon-edit',handler:function(){
						alert('修改字典类');
					}},
					{id:'btndelete',text:'删除字典类',btnType:'btndeleteDict',iconCls:'icon-remove',handler:function(){
						alert('删除字典类');
					}},
					{id:'btnadd',text:'添加字典项目',btnType:'add'},
					{id:'btnedit',text:'修改字典项目',btnType:'edit'},
					{id:'btndelete',text:'删除字典项目',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'dictId',title:'字典标识',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.dictId;
							}
					},
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
					{field:'dictDescription',title:'字典说明',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.dictDescription;
						}
					},

					{field:'item_text',title:'字典项名称',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.itemText;
							}
						},
					{field:'item_value',title:'字典项编码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.itemValue;
							}
						},
					{field:'description',title:'字典项说明',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.description;
							}
						},
			/*		{field:'sort_order',title:'排序',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.sortOrder;
							}
						},*/
					{field:'status',title:'启用状态',align:'center',sortable:true,
							formatter:function(value,row,index){
								if(value == 1){
									return "启用";
								}
								if(value == 0){
									return "不启用";
								}
								return "启用";
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
					/*{field:'created_by',title:'created_by',align:'center',sortable:true,
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
	otter.sysDictItem.init();
});