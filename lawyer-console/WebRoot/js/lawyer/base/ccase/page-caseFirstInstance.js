$package('otter.caseFirstInstance');
otter.caseFirstInstance = function(){
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
  				title:'案件一审阶段信息',
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
					
					{field:'firstor',title:'第一责任人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firstor;
							}
						},
					{field:'lawyer',title:'一审主办律师',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.lawyerName;
							}
						},
					{field:'submit_date',title:'提交立案材料日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.submitDate;
							}
						},
					{field:'isPreMediation',title:'是否诉前调解',align:'center',sortable:true,
							formatter:function(value,row,index){
	                       		if(value == 1){
									return "诉前调解";
								}
								if(value == 2){
									return "不调解";
								}
								return "";
							}
						},
					{field:'establish_date',title:'立案日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.establishDate;
							}
						},
					{field:'isActionMediation',title:'是否诉中调解',align:'center',sortable:true,
							formatter:function(value,row,index){
	                       		if(value == 1){
									return "诉中调解";
								}
								if(value == 2){
									return "不调解";
								}
								return "";
							}
						},
					{field:'mediationDate',title:'调解书日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.mediationDate;
							}
						},
					{field:'litigation_costs',title:'诉讼费用',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.litigationCosts;
							}
						},
					{field:'announcement_costs',title:'公告费用',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.announcementCosts;
							}
						},
					{field:'notary_costs',title:'公证费用',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.notaryCosts;
							}
						},
					{field:'other_costs',title:'其它费用',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.otherCosts;
							}
						},
					{field:'adjudication_court',title:'受理法院',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.adjudicationCourt;
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
					{field:'f_court_date',title:'一审开庭日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.fcourtDate;
							}
						},
					{field:'f_verdict_date',title:'一审判决书落款日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.fverdictDate;
							}
						},
					{field:'f_verdict_receive_date',title:'一审判决书收到日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.fverdictReceiveDate;
							}
						},
					{field:'isApology',title:'是否致歉',align:'center',sortable:true,
							formatter:function(value,row,index){
	                       		if(value == 1){
									return "已致歉";
								}
								if(value == 2){
									return "未致歉";
								}
								return "";
							}
						},
					{field:'defendant_compensation_total',title:'被告赔偿总额',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.defendantCompensationTotal;
							}
						},
					{field:'defendant_expenses',title:'被告承担合理开支总额',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.defendantExpenses;
							}
						},
					{field:'plaintiff_costs',title:'原告承担诉费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.plaintiffCosts;
							}
						},
					{field:'defendant_costs',title:'被告承担诉费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.defendantCosts;
							}
						},
					{field:'isClose',title:'是否结案',align:'center',sortable:true,
							formatter:function(value,row,index){
						   		if(value == 1){
									return "已结案";
								}
								if(value == 2){
									return "未结案";
								}
								return "";
							}
						},
					{field:'appeal_date',title:'上诉截止日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.appealDate;
							}
						},
						{field:'isAppeal',title:'是否上诉',align:'center',sortable:true,
							formatter:function(value,row,index){
	                       		if(value == 1){
									return "要上诉";
								}
								if(value == 2){
									return "不上诉";
								}
								return "";
							}
						},
						{field:'appellant',title:'上诉人',align:'left',sortable:true,
							formatter:function(value,row,index){
								return value;
							}
						},
						{field:'isCarryOut',title:'是否需要执行',align:'center',sortable:true,
							formatter:function(value,row,index){
	                       		if(value == 1){
									return "需要执行";
								}
								if(value == 2){
									return "不需要执行";
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
	otter.caseFirstInstance.init();
});