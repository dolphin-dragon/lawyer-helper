$package('otter.${lowerName}');
otter.${lowerName} = function(){
	var _box = null;
	var _this = {
		config:{
			event:{
				add:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.add(function(){
						$(".ui-edit").show();
					});
				},
				edit:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.edit(function(){
						$(".ui-edit").show();
					});
				}
			},
  			dataGrid:{
  				title:'${codeName}',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
#foreach($po in $!{columnDatas})
#if  ($po.propertyName !='id')
					{field:'${po.columnName}',title:'${po.columnComment}',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.${po.propertyName};
							}
						},
#end
#end
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
	otter.${lowerName}.init();
});