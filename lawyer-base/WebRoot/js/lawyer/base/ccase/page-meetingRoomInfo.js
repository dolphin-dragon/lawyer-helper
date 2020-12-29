$package('otter.meetingRoomInfo');
otter.meetingRoomInfo = function(){
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
  				title:'会议室基本信息表',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'status',title:'状态',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.status;
							}
						},
					{field:'del_flag',title:'删除标记',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.delFlag;
							}
						},
					{field:'org',title:'机构编码',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.org;
							}
						},
					{field:'created_by',title:'创建人',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.createdBy;
							}
						},
					{field:'created_time',title:'创建时间',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.createdTime;
							}
						},
					{field:'updated_by',title:'更新人',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.updatedBy;
							}
						},
					{field:'updated_time',title:'更新时间',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.updatedTime;
							}
						},
					{field:'mtr_name',title:'会议室名称',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.mtrName;
							}
						},
					{field:'mtr_code',title:'会议室编号',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.mtrCode;
							}
						},
					{field:'mtr_maxpersonnums',title:'会议室最大容纳人数',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.mtrMaxpersonnums;
							}
						},
					{field:'mtr_description',title:'会议室说明',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.mtrDescription;
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
	otter.meetingRoomInfo.init();
});