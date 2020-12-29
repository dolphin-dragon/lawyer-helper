$package('otter.meetingInfo');
otter.meetingInfo = function(){
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
  				title:'会议基本信息表',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					/*
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
					*/
					{field:'mt_name',title:'会议名称',align:'left',sortable:false,width:200,
							formatter:function(value,row,index){
								return row.mtName;
							}
						},
					{field:'mtr_id',title:'会议室',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.mtrName;
							}
						},
					{field:'mt_topics',title:'会议议题',align:'left',sortable:false,width:300,
							formatter:function(value,row,index){
								return row.mtTopics;
							}
						},
					{field:'mt_sponsor',title:'会议发起人',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.mtSponsorName;
							}
						},
					{field:'mt_members',title:'会议参会人列表',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.mtMembers;
							}
						},
					{field:'mt_start_time',title:'预定开始时间',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.mtStartTime;
							}
						},
					{field:'mt_end_time',title:'预定结束时间',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.mtEndTime;
							}
						},
					/*
					{field:'mt_resolution',title:'会议决议内容',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.mtResolution;
							}
						},
						*/
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
	otter.meetingInfo.init();
});