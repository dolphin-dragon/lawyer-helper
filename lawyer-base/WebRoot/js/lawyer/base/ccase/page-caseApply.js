$package('otter.caseApply');
otter.caseApply = function(){
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
  				title:'案件确立阶段信息',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
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
					{field:'src',title:'案件来源',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.src;
							}
						},
					{field:'supply',title:'案源人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.supply;
							}
						},
					{field:'apply_date',title:'申请公证日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.applyDate;
							}
						},
					{field:'applicant',title:'公证书申请人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.applicant;
							}
						},
					{field:'forensics',title:'取证人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.forensics;
							}
						},
					{field:'violate_type',title:'侵权类型',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.violateType;
							}
						},
					{field:'violate_desc',title:'侵权概况',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.violateDesc;
							}
						},
					{field:'action_date',title:'案件可诉确认日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.actionDate;
							}
						},
					{field:'litigant_ac_date',title:'当事人确认日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.litigantAcDate;
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
	otter.caseApply.init();
});