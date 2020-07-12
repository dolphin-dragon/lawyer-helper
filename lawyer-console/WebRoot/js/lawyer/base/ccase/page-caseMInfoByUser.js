$package('otter.caseMInfo');
otter.caseMInfo = function(){
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
  				title:'案件综合信息',
	   			url:'dataList2User.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'},
					{id:'btnexport',text:'数据导出',btnType:'export2user',iconCls:'icon-save',handler:function(){
						var action = 'exportExcel2User.do?';
						//获取查询参数
						var cpSupply = $('input[name="cpSupply"]',$('#searchForm')).val();  
						var caseLitigant = $('input[name="caseLitigant"]',$('#searchForm')).val();  
						var caseDefendantName = $('input[name="caseDefendantName"]',$('#searchForm')).val();  
						//请求参数拼装
						var params = '';
						params+='&cpSupply='+cpSupply;
						params+='&caseLitigant='+caseLitigant;
						params+='&caseDefendantName='+caseDefendantName;
//						console.log("export "+action+ encodeURI(params));
						//下载请求处理
						window.location.href = action+ encodeURI(params);
					}}
				],
	   			columns:[[
					{field:'id',title:'案件编号',rowspan:2,sortable:false,
						formatter:function(value,row,index){
							return row.id;
						}
					},
					{title:'案件确立阶段',colspan:10},
					{title:'案件主体信息',colspan:9},
					{title:'案件诉前和解阶段',colspan:6},
					{title:'案件一审阶段',colspan:27},
					{title:'案件二审阶段',colspan:13},
					{title:'案件执行阶段',colspan:9}],
					[
					{field:'cpSrc',title:'案件来源',align:'center',sortable:true,
							formatter:function(value,row,index){
	                    		if(value == 1){
									return "当事人提供";
								}
								if(value == 2){
									return "所内自行搜证";
								}
								if(value == 3){
									return "律师个人案源";
								}
								return "";
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'cp_supply',title:'案源人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.supplyName;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'cp_apply_date',title:'申请公证日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cpApplyDate;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'cp_applicant',title:'公证书申请人',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.cpApplicant;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'cp_forensics',title:'取证人',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.forensicsName;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'cpViolateType',title:'侵权类型',align:'center',sortable:true,
							formatter:function(value,row,index){
	                    		if(value == 1){
									return "肖像权";
								}
								if(value == 2){
									return "肖像权(含名誉权)";
								}
								if(value == 3){
									return "肖像权(含姓名权)";
								}
								if(value == 4){
									return "肖像权(含姓名权、名誉权)";
								}
								if(value == 5){
									return "名誉权";
								}
								if(value == 6){
									return "不当得利纠纷";
								}
								if(value == 7){
									return "合同纠纷";
								}
								return "";
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'cp_violate_desc',title:'侵权概况',align:'left',sortable:false,width:200,
							formatter:function(value,row,index){
								return row.cpViolateDesc;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'cp_action_date',title:'案件可诉确认日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cpActionDate;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'cp_litigant_ac_date',title:'当事人确认日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cpLitigantAcDate;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					/*{field:'cp_action_img',title:'案件可诉确认截图',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cpActionImg;
							}
						},
					{field:'cp_litigant_ac_img',title:'当事人确认截图',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cpLitigantAcImg;
							}
						},*/
					{field:'cpIsDirectAction',title:'当事人是否要求直接诉讼',align:'center',sortable:true,
							formatter:function(value,row,index){
	                    		if(value == 1){
									return "是";
								}
								if(value == 2){
									return "否";
								}
								return "";
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'caseStatus',title:'状态',align:'center',sortable:true,
							styler:function(value,row,index){
								if(null != value){
									if(0< value && value < 10){
										return 'background-color:#99FFCC;color:green;';
									}
									if(value < 0){
										return 'background-color:#99FFCC;color:red;';
									}if(value > 90){
										return 'background-color:#99FFCC;color:blue;';
									}
								}
								return 'background-color:#99FFCC;';
							},
							formatter:function(value,row,index){
								if(null != value){
									if(0<value && value< 10){
										return "结案申请";
									}
									if(value < 0){
										return "结案驳回";
									}if(value > 90){
										return "结案通过";
									}								
								}
								return "进行中";
							}
						},
					/*{field:'case_del_flag',title:'删除标记',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseDelFlag;
							}
						},
					{field:'case_org',title:'机构编码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseOrg;
							}
						},*/
					{field:'case_created_by',title:'创建人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createName;
							},
							styler:function(index,row){
								  return 'background-color:#99FFCC;';
							}
						},
					{field:'case_created_time',title:'创建时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseCreatedTime;
							},
							styler:function(index,row){
								  return 'background-color:#99FFCC;';
							}
						},
					{field:'case_updated_by',title:'更新人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updateName;
							},
							styler:function(index,row){
								  return 'background-color:#99FFCC;';
							}
						},
					{field:'case_updated_time',title:'更新时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.caseUpdatedTime;
							},
							styler:function(index,row){
								  return 'background-color:#99FFCC;';
							}
						},
					{field:'case_litigant',title:'当事人',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.caseLitigant;
							},
							styler:function(index,row){
								  return 'background-color:#99FFCC;';
							}
						},
					{field:'case_defendant_name',title:'被告名称',align:'left',sortable:false,width:200,
							formatter:function(value,row,index){
								return row.caseDefendantName;
							},
							styler:function(index,row){
								  return 'background-color:#99FFCC;';
							}
						},
					{field:'case_defendant_reg_capital',title:'被告注册资本',align:'right',sortable:false,
							formatter:function(value,row,index){
								return row.caseDefendantRegCapital;
							},
							styler:function(index,row){
								  return 'background-color:#99FFCC;';
							}
						},
					{field:'case_defendant_area',title:'被告所在地',align:'left',sortable:false,width:200,
							formatter:function(value,row,index){
								return row.caseDefendantArea;
							},
							styler:function(index,row){
								  return 'background-color:#99FFCC;';
							}
						},
					{field:'pr_letter',title:'律师函编号',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.prLetter;
							},
							styler:function(index,row){
								  return 'background-color:#FF9999;';
							}
						},
					{field:'pr_letteror',title:'律师函主办人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.letterorName;
							},
							styler:function(index,row){
								  return 'background-color:#FF9999;';
							}
						},
					{field:'pr_send_date',title:'律师函发送日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.prSendDate;
							},
							styler:function(index,row){
								  return 'background-color:#FF9999;';
							}
						},
					{field:'pr_delivery_date',title:'律师函送达日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.prDeliveryDate;
							},
							styler:function(index,row){
								  return 'background-color:#FF9999;';
							}
						},
					{field:'prIsClose',title:'是否结案',align:'center',sortable:true,
							styler:function(value,row,index){
								if(value == 1){
								  return 'background-color:#FF9999;color:red;';  
								}
								 return 'background-color:#FF9999;';
							},
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
					{field:'pr_is_direct_action',title:'是否诉讼',align:'center',sortable:true,
							formatter:function(value,row,index){
						   		if(value == 1){
									return "是";//"诉讼";
								}
								if(value == 2){
									return "否";//"不诉讼";
								}
								return "";
							},
							styler:function(index,row){
								  return 'background-color:#FF9999;';
							}
						},
					{field:'fir_firstor',title:'第一责任人',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.firFirstor;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_lawyer',title:'一审主办律师',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firLawyerName;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_submit_date',title:'提交立案材料日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firSubmitDate;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_establish_date',title:'立案日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firEstablishDate;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_litigation_costs',title:'诉讼费用',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firLitigationCosts;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_announcement_costs',title:'公告费用',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firAnnouncementCosts;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_notary_costs',title:'公证费用',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firNotaryCosts;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_other_costs',title:'其它费用',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firOtherCosts;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_adjudication_court',title:'受理法院',align:'left',sortable:false,width:200,
							formatter:function(value,row,index){
								return row.firAdjudicationCourt;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_judge',title:'主办法官',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.firJudge;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_judge_contact',title:'联系方式',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.firJudgeContact;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_f_court_date',title:'一审开庭日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firFCourtDate;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_f_verdict_date',title:'一审判决书落款日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firFVerdictDate;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_f_verdict_receive_date',title:'一审判决书收到日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firFVerdictReceiveDate;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'firIsApology',title:'是否致歉',align:'center',sortable:true,
							formatter:function(value,row,index){
	                       		if(value == 1){
									return "是";//"已致歉";
								}
								if(value == 2){
									return "否";//"未致歉";
								}
								return "";
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_defendant_compensation_total',title:'被告赔偿总额',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firDefendantCompensationTotal;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_defendant_expenses',title:'被告承担合理开支总额',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firDefendantExpenses;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_plaintiff_costs',title:'原告承担诉费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firPlaintiffCosts;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_defendant_costs',title:'被告承担诉费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firDefendantCosts;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'firIsClose',title:'是否结案',align:'center',sortable:true,
							styler:function(value,row,index){
								if(value == 1){
								  return 'background-color:#CCCCCC;color:red;';  
								}
								 return 'background-color:#CCCCCC;';
							},
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
					{field:'fir_appeal_date',title:'上诉截止日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firAppealDate;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'firIsPreMediation',title:'是否诉前调解',align:'center',sortable:true,
							formatter:function(value,row,index){
	                       		if(value == 1){
									return "是";//"诉前调解";
								}
								if(value == 2){
									return "否";//"不调解";
								}
								return "";
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'firIsActionMediation',title:'是否诉中调解',align:'center',sortable:true,
							formatter:function(value,row,index){
	                       		if(value == 1){
									return "是";//"诉中调解";
								}
								if(value == 2){
									return "否";//"不调解";
								}
								return "";
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_mediation_date',title:'调解书日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.firMediationDate;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'firIsAppeal',title:'是否上诉',align:'center',sortable:true,
							formatter:function(value,row,index){
	                       		if(value == 1){
									return "是";//"要上诉";
								}
								if(value == 2){
									return "否";//"不上诉";
								}
								return "";
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'fir_appellant',title:'上诉人',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.firAppellant;
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'firIsCarryOut',title:'是否需要执行',align:'center',sortable:true,
							formatter:function(value,row,index){
	                       		if(value == 1){
									return "是";//"需要执行";
								}
								if(value == 2){
									return "否";//"不需要执行";
								}
								return "";
							},
							styler:function(index,row){
								  return 'background-color:#CCCCCC;';
							}
						},
					{field:'two_lawyer',title:'二审主办律师',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoLawyerName;
							},
							styler:function(index,row){
								  return 'background-color:#33CC99;';
							}
						},
					{field:'two_s_court_date',title:'二审开庭日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoSCourtDate;
							},
							styler:function(index,row){
								  return 'background-color:#33CC99;';
							}
						},
					{field:'two_judge',title:'主办法官',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.twoJudge;
							},
							styler:function(index,row){
								  return 'background-color:#33CC99;';
							}
						},
					{field:'two_judge_contact',title:'联系方式',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.twoJudgeContact;
							},
							styler:function(index,row){
								  return 'background-color:#33CC99;';
							}
						},
					{field:'two_s_judgment_effective_date',title:'二审判决生效日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoSJudgmentEffectiveDate;
							},
							styler:function(index,row){
								  return 'background-color:#33CC99;';
							}
						},
					{field:'twoIsApology',title:'是否致歉',align:'center',sortable:true,
							formatter:function(value,row,index){
				          		if(value == 1){
									return "是";//"已致歉";
								}
								if(value == 2){
									return "否";//"未致歉";
								}
								return "";
							},
							styler:function(index,row){
								  return 'background-color:#33CC99;';
							}
						},
					{field:'two_defendant_compensation_total',title:'一审被告赔偿总额',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoDefendantCompensationTotal;
							},
							styler:function(index,row){
								  return 'background-color:#33CC99;';
							}
						},
					{field:'two_defendant_expenses',title:'一审被告承担合理开支费用',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoDefendantExpenses;
							},
							styler:function(index,row){
								  return 'background-color:#33CC99;';
							}
						},
					{field:'two_plaintiff_costs',title:'一审原告承担诉费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoPlaintiffCosts;
							},
							styler:function(index,row){
								  return 'background-color:#33CC99;';
							}
						},
					{field:'two_defendant_costs',title:'一审被告承担诉费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoDefendantCosts;
							},
							styler:function(index,row){
								  return 'background-color:#33CC99;';
							}
						},
					{field:'twoIsClose',title:'是否结案',align:'center',sortable:true,
							styler:function(value,row,index){
								if(value == 1){
								  return 'background-color:#33CC99;color:red;';  
								}
								return 'background-color:#33CC99;';
							},
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
					{field:'two_execution_deadline',title:'执行截止日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.twoExecutionDeadline;
							},
							styler:function(index,row){
								  return 'background-color:#33CC99;';
							}
						},
					{field:'twoIsCarryOut',title:'是否需要执行',align:'center',sortable:true,
							formatter:function(value,row,index){
						   		if(value == 1){
									return "是";//"需要";
								}
								if(value == 2){
									return "否";//"不需要";
								}
								return "";
							},
							styler:function(index,row){
								  return 'background-color:#33CC99;';
							}
						},
					{field:'out_lawyer',title:'执行主办律师',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.outLawyerName;
							},
							styler:function(index,row){
								  return 'background-color:#99CC66;';
							}
						},
					{field:'out_app_date',title:'执行申请日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.outAppDate;
							},
							styler:function(index,row){
								  return 'background-color:#99CC66;';
							}
						},
					{field:'out_app_total',title:'申请执行总额',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.outAppTotal;
							},
							styler:function(index,row){
								  return 'background-color:#99CC66;';
							}
						},
					{field:'out_judge',title:'执行主办法官',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.outJudge;
							},
							styler:function(index,row){
								  return 'background-color:#99CC66;';
							}
						},
					{field:'out_judge_contact',title:'联系方式',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.outJudgeContact;
							},
							styler:function(index,row){
								  return 'background-color:#99CC66;';
							}
						},
					{field:'out_actual_total',title:'实际执行总额',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.outActualTotal;
							},
							styler:function(index,row){
								  return 'background-color:#99CC66;';
							}
						},
					{field:'out_f_collection_subject',title:'首位收款主体',align:'left',sortable:false,width:100,
							formatter:function(value,row,index){
								return row.outFCollectionSubject;
							},
							styler:function(index,row){
								  return 'background-color:#99CC66;';
							}
						},
					{field:'outIsReconcile',title:'是否执行和解',align:'center',sortable:true,
							formatter:function(value,row,index){
								if(value == 1){
									return "是";//"执行和解";
								}
								if(value == 2){
									return "否";//"不执行和解";
								}
								return "";
							},
							styler:function(index,row){
								  return 'background-color:#99CC66;';
							}
						},
					{field:'outIsClose',title:'是否结案',align:'center',sortable:true,
							styler:function(value,row,index){
								if(value == 1){
								  return 'background-color:#99CC66;color:red;';  
								}
								return 'background-color:#99CC66;';
							},
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