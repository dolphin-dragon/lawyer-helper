$package('otter.caseSecondInstance');
otter.caseSecondInstance = function(){
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
  				title:'案件二审阶段信息',
	   			url:'dataList.do',
	   			toolbar:[
//					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
				idField:'caseId',
	   			columns:[[
					{field:'case_id',checkbox:true},
					/*{field:'status',title:'状态',align:'center',sortable:true,
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
						},*/
					{field:'litigant',title:'当事人',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.litigant;
						}
					},
				{field:'defendant_name',title:'被告名称',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.defendantName;
						}
					},
				{field:'defendant_reg_capital',title:'被告注册资本',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.defendantRegCapital;
						}
					},
				{field:'defendant_area',title:'被告所在地',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.defendantArea;
						}
					},
					
					{field:'lawyer',title:'二审主办律师',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.lawyerName;
							}
						},
					{field:'s_court_date',title:'二审开庭日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.scourtDate;
							}
						},
					{field:'judge',title:'主办法官',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.judge;
							}
						},
					{field:'judge_contact',title:'联系方式',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.judgeContact;
							}
						},
					{field:'s_judgment_effective_date',title:'二审判决生效日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.sjudgmentEffectiveDate;
							}
						},
					{field:'isApology',title:'是否致歉',align:'center',sortable:true,
							formatter:function(value,row,index){
				          		if(value == 1){
									return "是";//"已致歉";
								}
								if(value == 2){
									return "否";//"未致歉";
								}
								return "";
							}
						},
					{field:'defendant_compensation_total',title:'一审被告赔偿总额',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.defendantCompensationTotal;
							}
						},
					{field:'defendant_expenses',title:'一审被告承担合理开支费用',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.defendantExpenses;
							}
						},
					{field:'plaintiff_costs',title:'一审原告承担诉费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.plaintiffCosts;
							}
						},
					{field:'defendant_costs',title:'一审被告承担诉费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.defendantCosts;
							}
						},
					{field:'isClose',title:'是否结案',align:'center',sortable:true,
							formatter:function(value,row,index){
						   		if(value == 1){
									return "是";//"已结案";
								}
								if(value == 2){
									return "否";//"未结案";
								}
								return "";
							}
						},
					{field:'execution_deadline',title:'执行截止日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.executionDeadline;
							}
						},
					{field:'isCarryOut',title:'是否需要执行',align:'center',sortable:true,
							formatter:function(value,row,index){
						   		if(value == 1){
									return "是";//"需要";
								}
								if(value == 2){
									return "否";//"不需要";
								}
								return "";
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
	otter.caseSecondInstance.init();
});