$package('otter.caseCarryOut');
otter.caseCarryOut = function(){
	var _box = null;
	var _this = {
		config:{
			event:{
/*				add:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.add();
				},*/
				edit:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.edit();
				}
			},
  			dataGrid:{
  				title:'案件执行阶段信息',
	   			url:'dataList.do',
	   			toolbar:[
//					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'status',title:'状态',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.status;
							}
						},
					{field:'org',title:'机构编码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.org;
							}
						},
					{field:'created_by',title:'创建人',align:'center',sortable:true,
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
					{field:'case_id',title:'案件序号',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseId;
							}
						},
					{field:'lawyer',title:'执行主办律师',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.lawyer;
							}
						},
					{field:'app_date',title:'执行申请日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.appDate;
							}
						},
					{field:'app_total',title:'申请执行总额',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.appTotal;
							}
						},
					{field:'judge',title:'执行主办法官',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.judge;
							}
						},
					{field:'judge_contact',title:'联系方式',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.judgeContact;
							}
						},
					{field:'actual_total',title:'实际执行总额',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.actualTotal;
							}
						},
					{field:'f_collection_subject',title:'首位收款主体',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.fCollectionSubject;
							}
						},
					{field:'remark',title:'备注',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.remark;
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
	otter.caseCarryOut.init();
});