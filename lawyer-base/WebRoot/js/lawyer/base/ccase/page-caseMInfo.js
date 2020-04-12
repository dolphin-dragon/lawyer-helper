$package('otter.caseMInfo');
otter.caseMInfo = function(){
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
  				title:'案件综合信息',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'cp_src',title:'案件来源',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cpSrc;
							}
						},
					{field:'cp_supply',title:'案源人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cpSupply;
							}
						},
					{field:'cp_apply_date',title:'申请公证日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cpApplyDate;
							}
						},
					{field:'cp_applicant',title:'公证书申请人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cpApplicant;
							}
						},
					{field:'cp_forensics',title:'取证人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cpForensics;
							}
						},
					{field:'cp_violate_type',title:'侵权类型',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cpViolateType;
							}
						},
					{field:'cp_violate_desc',title:'侵权概况',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cpViolateDesc;
							}
						},
					{field:'cp_action_date',title:'案件可诉确认日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cpActionDate;
							}
						},
					{field:'cp_litigant_ac_date',title:'当事人确认日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cpLitigantAcDate;
							}
						},
					{field:'cp_action_img',title:'案件可诉确认截图',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cpActionImg;
							}
						},
					{field:'cp_litigant_ac_img',title:'当事人确认截图',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cpLitigantAcImg;
							}
						},
					{field:'cp_is_direct_action',title:'当事人是否要求直接诉讼',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cpIsDirectAction;
							}
						},
					{field:'case_status',title:'状态',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseStatus;
							}
						},
					{field:'case_del_flag',title:'删除标记',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseDelFlag;
							}
						},
					{field:'case_org',title:'机构编码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseOrg;
							}
						},
					{field:'case_created_by',title:'创建人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseCreatedBy;
							}
						},
					{field:'case_created_time',title:'创建时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseCreatedTime;
							}
						},
					{field:'case_updated_by',title:'更新人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseUpdatedBy;
							}
						},
					{field:'case_updated_time',title:'更新时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseUpdatedTime;
							}
						},
					{field:'case_litigant',title:'当事人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseLitigant;
							}
						},
					{field:'case_defendant_name',title:'被告名称',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseDefendantName;
							}
						},
					{field:'case_defendant_reg_capital',title:'被告注册资本',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseDefendantRegCapital;
							}
						},
					{field:'case_defendant_area',title:'被告所在地',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseDefendantArea;
							}
						},
					{field:'pr_letter',title:'律师函编号',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.prLetter;
							}
						},
					{field:'pr_letteror',title:'律师函主办人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.prLetteror;
							}
						},
					{field:'pr_send_date',title:'律师函发送日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.prSendDate;
							}
						},
					{field:'pr_delivery_date',title:'律师函送达日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.prDeliveryDate;
							}
						},
					{field:'pr_is_close',title:'是否结案',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.prIsClose;
							}
						},
					{field:'pr_is_direct_action',title:'是否诉讼',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.prIsDirectAction;
							}
						},
					{field:'fir_firstor',title:'第一责任人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firFirstor;
							}
						},
					{field:'fir_lawyer',title:'一审主办律师',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firLawyer;
							}
						},
					{field:'fir_submit_date',title:'提交立案材料日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firSubmitDate;
							}
						},
					{field:'fir_establish_date',title:'立案日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firEstablishDate;
							}
						},
					{field:'fir_litigation_costs',title:'诉讼费用',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firLitigationCosts;
							}
						},
					{field:'fir_announcement_costs',title:'公告费用',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firAnnouncementCosts;
							}
						},
					{field:'fir_notary_costs',title:'公证费用',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firNotaryCosts;
							}
						},
					{field:'fir_other_costs',title:'其它费用',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firOtherCosts;
							}
						},
					{field:'fir_adjudication_court',title:'受理法院',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firAdjudicationCourt;
							}
						},
					{field:'fir_judge',title:'主办法官',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firJudge;
							}
						},
					{field:'fir_judge_contact',title:'联系方式',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firJudgeContact;
							}
						},
					{field:'fir_f_court_date',title:'一审开庭日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firFCourtDate;
							}
						},
					{field:'fir_f_verdict_date',title:'一审判决书落款日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firFVerdictDate;
							}
						},
					{field:'fir_f_verdict_receive_date',title:'一审判决书收到日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firFVerdictReceiveDate;
							}
						},
					{field:'fir_is_apology',title:'是否致歉',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firIsApology;
							}
						},
					{field:'fir_defendant_compensation_total',title:'被告赔偿总额',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firDefendantCompensationTotal;
							}
						},
					{field:'fir_defendant_expenses',title:'被告承担合理开支总额',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firDefendantExpenses;
							}
						},
					{field:'fir_plaintiff_costs',title:'原告承担诉费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firPlaintiffCosts;
							}
						},
					{field:'fir_defendant_costs',title:'被告承担诉费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firDefendantCosts;
							}
						},
					{field:'fir_is_close',title:'是否结案',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firIsClose;
							}
						},
					{field:'fir_appeal_date',title:'上诉截止日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firAppealDate;
							}
						},
					{field:'fir_is_pre_mediation',title:'是否诉前调解',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firIsPreMediation;
							}
						},
					{field:'fir_is_action_mediation',title:'是否诉中调解',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firIsActionMediation;
							}
						},
					{field:'fir_mediation_date',title:'调解书日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firMediationDate;
							}
						},
					{field:'fir_is_appeal',title:'是否上诉',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firIsAppeal;
							}
						},
					{field:'fir_appellant',title:'上诉人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firAppellant;
							}
						},
					{field:'fir_is_carry_out',title:'是否需要执行',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firIsCarryOut;
							}
						},
					{field:'two_lawyer',title:'二审主办律师',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoLawyer;
							}
						},
					{field:'two_s_court_date',title:'二审开庭日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoSCourtDate;
							}
						},
					{field:'two_judge',title:'主办法官',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoJudge;
							}
						},
					{field:'two_judge_contact',title:'联系方式',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoJudgeContact;
							}
						},
					{field:'two_s_judgment_effective_date',title:'二审判决生效日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoSJudgmentEffectiveDate;
							}
						},
					{field:'two_is_apology',title:'是否致歉',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoIsApology;
							}
						},
					{field:'two_defendant_compensation_total',title:'一审被告赔偿总额',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoDefendantCompensationTotal;
							}
						},
					{field:'two_defendant_expenses',title:'一审被告承担合理开支费用',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoDefendantExpenses;
							}
						},
					{field:'two_plaintiff_costs',title:'一审原告承担诉费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoPlaintiffCosts;
							}
						},
					{field:'two_defendant_costs',title:'一审被告承担诉费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoDefendantCosts;
							}
						},
					{field:'two_is_close',title:'是否结案',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoIsClose;
							}
						},
					{field:'two_execution_deadline',title:'执行截止日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoExecutionDeadline;
							}
						},
					{field:'two_is_carry_out',title:'是否需要执行',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoIsCarryOut;
							}
						},
					{field:'out_lawyer',title:'执行主办律师',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.outLawyer;
							}
						},
					{field:'out_app_date',title:'执行申请日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.outAppDate;
							}
						},
					{field:'out_app_total',title:'申请执行总额',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.outAppTotal;
							}
						},
					{field:'out_judge',title:'执行主办法官',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.outJudge;
							}
						},
					{field:'out_judge_contact',title:'联系方式',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.outJudgeContact;
							}
						},
					{field:'out_actual_total',title:'实际执行总额',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.outActualTotal;
							}
						},
					{field:'out_f_collection_subject',title:'首位收款主体',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.outFCollectionSubject;
							}
						},
					{field:'out_is_reconcile',title:'是否执行和解',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.outIsReconcile;
							}
						},
					{field:'out_is_close',title:'是否结案',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.outIsClose;
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
	otter.caseMInfo.init();
});