package lawyer.base.ccase.entity;

import com.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import cn.afterturn.easypoi.excel.annotation.Excel;
/**
 * <b>功能：</b>CaseMInfoEntity<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-04-11 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class CaseMInfo extends BaseEntity {
	@Excel(name = "案件编号")
	private java.lang.Integer id;//   序号
	@Excel(name = "案件来源" , replace = { "当事人提供_1", "所内自行搜证_2", "律师个人案源_3", "_null"})
	private java.lang.String cpSrc;//   案件来源
	@Excel(name = "案源人")
	private java.lang.String supplyName;	private java.lang.String cpSupply;//   案源人
    @Excel(name = "申请公证日期", exportFormat="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date cpApplyDate;//   申请公证日期
    @Excel(name = "公证书申请人")
	private java.lang.String cpApplicant;//   公证书申请人    private java.lang.String applicantName;
    @Excel(name = "取证人")
    private java.lang.String forensicsName;	private java.lang.String cpForensics;//   取证人
    @Excel(name = "侵权类型" ,replace = { "肖像权_1", "肖像权(含名誉权)_2", "肖像权(含姓名权)_3","肖像权(含姓名权、名誉权)_4","名誉权_3", "_null"})	private java.lang.String cpViolateType;//   侵权类型
    @Excel(name = "侵权概况")	private java.lang.String cpViolateDesc;//   侵权概况
	@Excel(name = "案件可诉确认日期", exportFormat="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date cpActionDate;//   案件可诉确认日期
	@Excel(name = "当事人确认日期", exportFormat="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date cpLitigantAcDate;//   当事人确认日期
	private java.lang.String cpActionImg;//   案件可诉确认截图	private java.lang.String cpLitigantAcImg;//   当事人确认截图
	@Excel(name = "当事人是否要求直接诉讼" ,replace = { "是_1", "否_2","_null"})	private java.lang.String cpIsDirectAction;//   当事人是否要求直接诉讼
	
	@Excel(name = "状态",replace = { "结案通过_91","结案通过_92","结案通过_93","结案通过_94","结案通过_95", 
			"进行中_21","进行中_22","进行中_23","进行中_24","进行中_25",
			"进行中_31","进行中_32","进行中_33","进行中_34","进行中_35",
			"进行中_41","进行中_42","进行中_43","进行中_43","进行中_44",
			"进行中_51","进行中_52","进行中_53","进行中_54","进行中_55",
			"进行中_-1","进行中_-2","进行中_-3","进行中_-4","进行中_-5",
			"进行中_null"})	private java.lang.Integer caseStatus;//   状态
		private java.lang.String caseDelFlag;//   删除标记	private java.lang.String caseOrg;//   机构编码
	@Excel(name = "创建人")
	private java.lang.String createName;	private java.lang.String caseCreatedBy;//   创建人
	@Excel(name = "创建时间", exportFormat="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date caseCreatedTime;//   创建时间
	@Excel(name = "更新人")
	private java.lang.String updateName;	private java.lang.String caseUpdatedBy;//   更新人
	@Excel(name = "创建时间", exportFormat="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date caseUpdatedTime;//   更新时间	@Excel(name = "当事人")	private java.lang.String caseLitigant;//   当事人
	@Excel(name = "被告名称")	private java.lang.String caseDefendantName;//   被告名称
	@Excel(name = "被告注册资本")	private java.lang.String caseDefendantRegCapital;//   被告注册资本
	@Excel(name = "被告所在地")	private java.lang.String caseDefendantArea;//   被告所在地
	
	@Excel(name = "律师函编号")	private java.lang.String prLetter;//   律师函编号
	@Excel(name = "律师函主办人")
	private java.lang.String letterorName;	private java.lang.String prLetteror;//   律师函主办人
	@Excel(name = "律师函发送日期", exportFormat="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date prSendDate;//   律师函发送日期
	@Excel(name = "律师函送达日期", exportFormat="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date prDeliveryDate;//   律师函送达日期
	@Excel(name = "是否结案" ,replace = { "是_1", "否_2","_null"})	private java.lang.String prIsClose;//   是否结案
	@Excel(name = "是否诉讼" ,replace = { "是_1", "否_2","_null"})	private java.lang.String prIsDirectAction;//   是否诉讼
	
	@Excel(name = "第一责任人")	private java.lang.String firFirstor;//   第一责任人
	@Excel(name = "一审主办律师")
	private java.lang.String firLawyerName;	private java.lang.String firLawyer;//   一审主办律师
	@Excel(name = "提交立案材料日期", exportFormat="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date firSubmitDate;//   提交立案材料日期
	@Excel(name = "立案日期", exportFormat="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date firEstablishDate;//   立案日期
	@Excel(name = "诉讼费用")	private java.math.BigDecimal firLitigationCosts;//   诉讼费用
	@Excel(name = "公告费用")	private java.math.BigDecimal firAnnouncementCosts;//   公告费用
	@Excel(name = "公证费用")	private java.math.BigDecimal firNotaryCosts;//   公证费用
	@Excel(name = "其它费用")	private java.math.BigDecimal firOtherCosts;//   其它费用
	@Excel(name = "受理法院")	private java.lang.String firAdjudicationCourt;//   受理法院
	@Excel(name = "主办法官")	private java.lang.String firJudge;//   主办法官
	@Excel(name = "联系方式")	private java.lang.String firJudgeContact;//   联系方式
	@Excel(name = "一审开庭日期", exportFormat="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date firFCourtDate;//   一审开庭日期
	@Excel(name = "一审判决书落款日期", exportFormat="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date firFVerdictDate;//   一审判决书落款日期
	@Excel(name = "一审判决书收到日期", exportFormat="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date firFVerdictReceiveDate;//   一审判决书收到日期
	@Excel(name = "是否致歉" ,replace = { "是_1", "否_2","_null"})	private java.lang.String firIsApology;//   是否致歉
	@Excel(name = "被告赔偿总额")	private java.math.BigDecimal firDefendantCompensationTotal;//   被告赔偿总额
	@Excel(name = "被告承担合理开支总额")	private java.math.BigDecimal firDefendantExpenses;//   被告承担合理开支总额
	@Excel(name = "原告承担诉费")	private java.math.BigDecimal firPlaintiffCosts;//   原告承担诉费
	@Excel(name = "被告承担诉费")	private java.math.BigDecimal firDefendantCosts;//   被告承担诉费
	@Excel(name = "是否结案" ,replace = { "是_1", "否_2","_null"})	private java.lang.String firIsClose;//   是否结案
	@Excel(name = "上诉截止日期", exportFormat="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date firAppealDate;//   上诉截止日期
	@Excel(name = "是否诉前调解",replace = { "是_1", "否_2","_null"})	private java.lang.String firIsPreMediation;//   是否诉前调解
	@Excel(name = "是否诉中调解",replace = { "是_1", "否_2","_null"})	private java.lang.String firIsActionMediation;//   是否诉中调解
	@Excel(name = "调解书日期", exportFormat="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date firMediationDate;//   调解书日期
	@Excel(name = "是否上诉" ,replace = { "是_1", "否_2","_null"})	private java.lang.String firIsAppeal;//   是否上诉
	@Excel(name = "上诉人")	private java.lang.String firAppellant;//   上诉人
	@Excel(name = "是否需要执行" ,replace = { "是_1", "否_2","_null"})	private java.lang.String firIsCarryOut;//   是否需要执行
	
	@Excel(name = "二审主办律师")
	private java.lang.String twoLawyerName;	private java.lang.String twoLawyer;//   二审主办律师
	@Excel(name = "调解书日期", exportFormat="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date twoSCourtDate;//   二审开庭日期
	@Excel(name = "主办法官")	private java.lang.String twoJudge;//   主办法官
	@Excel(name = "二审主办律师")	private java.lang.String twoJudgeContact;//   联系方式
	@Excel(name = "二审判决生效日期", exportFormat="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date twoSJudgmentEffectiveDate;//   二审判决生效日期
	@Excel(name = "是否致歉" ,replace = { "是_1", "否_2","_null"})	private java.lang.String twoIsApology;//   是否致歉
	@Excel(name = "一审被告赔偿总额")	private java.lang.String twoDefendantCompensationTotal;//   一审被告赔偿总额
	@Excel(name = "一审被告承担合理开支费用")	private java.lang.String twoDefendantExpenses;//   一审被告承担合理开支费用
	@Excel(name = "一审原告承担诉费")	private java.lang.String twoPlaintiffCosts;//   一审原告承担诉费
	@Excel(name = "一审被告承担诉费")	private java.math.BigDecimal twoDefendantCosts;//   一审被告承担诉费
	@Excel(name = "是否结案" ,replace = { "是_1", "否_2","_null"})	private java.lang.String twoIsClose;//   是否结案
	@Excel(name = "执行截止日期", exportFormat="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date twoExecutionDeadline;//   执行截止日期
	@Excel(name = "是否需要执行",replace = { "是_1", "否_2","_null"})	private java.lang.String twoIsCarryOut;//   是否需要执行
	
	@Excel(name = "执行主办律师")
	private java.lang.String outLawyerName;	private java.lang.String outLawyer;//   执行主办律师
	@Excel(name = "执行申请日期", exportFormat="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date outAppDate;//   执行申请日期
	@Excel(name = "申请执行总额")	private java.math.BigDecimal outAppTotal;//   申请执行总额
	@Excel(name = "执行主办法官")	private java.lang.String outJudge;//   执行主办法官
	@Excel(name = "联系方式")	private java.lang.String outJudgeContact;//   联系方式
	@Excel(name = "实际执行总额")	private java.math.BigDecimal outActualTotal;//   实际执行总额
	@Excel(name = "首位收款主体")	private java.lang.String outFCollectionSubject;//   首位收款主体
	@Excel(name = "是否执行和解",replace = { "是_1", "否_2","_null"})	private java.lang.String outIsReconcile;//   是否执行和解
	@Excel(name = "是否结案",replace = { "是_1", "否_2","_null"})	private java.lang.String outIsClose;//   是否结案
	
	public java.lang.String getCpSrc() {	    return this.cpSrc;	}	public void setCpSrc(java.lang.String cpSrc) {	    this.cpSrc=cpSrc;	}	public java.lang.String getCpSupply() {	    return this.cpSupply;	}	public void setCpSupply(java.lang.String cpSupply) {	    this.cpSupply=cpSupply;	}	public java.util.Date getCpApplyDate() {	    return this.cpApplyDate;	}	public void setCpApplyDate(java.util.Date cpApplyDate) {	    this.cpApplyDate=cpApplyDate;	}	public java.lang.String getCpApplicant() {	    return this.cpApplicant;	}	public void setCpApplicant(java.lang.String cpApplicant) {	    this.cpApplicant=cpApplicant;	}	public java.lang.String getCpForensics() {	    return this.cpForensics;	}	public void setCpForensics(java.lang.String cpForensics) {	    this.cpForensics=cpForensics;	}	public java.lang.String getCpViolateType() {	    return this.cpViolateType;	}	public void setCpViolateType(java.lang.String cpViolateType) {	    this.cpViolateType=cpViolateType;	}	public java.lang.String getCpViolateDesc() {	    return this.cpViolateDesc;	}	public void setCpViolateDesc(java.lang.String cpViolateDesc) {	    this.cpViolateDesc=cpViolateDesc;	}	public java.util.Date getCpActionDate() {	    return this.cpActionDate;	}	public void setCpActionDate(java.util.Date cpActionDate) {	    this.cpActionDate=cpActionDate;	}	public java.util.Date getCpLitigantAcDate() {	    return this.cpLitigantAcDate;	}	public void setCpLitigantAcDate(java.util.Date cpLitigantAcDate) {	    this.cpLitigantAcDate=cpLitigantAcDate;	}	public java.lang.String getCpActionImg() {	    return this.cpActionImg;	}	public void setCpActionImg(java.lang.String cpActionImg) {	    this.cpActionImg=cpActionImg;	}	public java.lang.String getCpLitigantAcImg() {	    return this.cpLitigantAcImg;	}	public void setCpLitigantAcImg(java.lang.String cpLitigantAcImg) {	    this.cpLitigantAcImg=cpLitigantAcImg;	}	public java.lang.String getCpIsDirectAction() {	    return this.cpIsDirectAction;	}	public void setCpIsDirectAction(java.lang.String cpIsDirectAction) {	    this.cpIsDirectAction=cpIsDirectAction;	}	public java.lang.Integer getCaseStatus() {	    return this.caseStatus;	}	public void setCaseStatus(java.lang.Integer caseStatus) {	    this.caseStatus=caseStatus;	}	public java.lang.String getCaseDelFlag() {	    return this.caseDelFlag;	}	public void setCaseDelFlag(java.lang.String caseDelFlag) {	    this.caseDelFlag=caseDelFlag;	}	public java.lang.String getCaseOrg() {	    return this.caseOrg;	}	public void setCaseOrg(java.lang.String caseOrg) {	    this.caseOrg=caseOrg;	}	public java.lang.String getCaseCreatedBy() {	    return this.caseCreatedBy;	}	public void setCaseCreatedBy(java.lang.String caseCreatedBy) {	    this.caseCreatedBy=caseCreatedBy;	}	public java.util.Date getCaseCreatedTime() {	    return this.caseCreatedTime;	}	public void setCaseCreatedTime(java.util.Date caseCreatedTime) {	    this.caseCreatedTime=caseCreatedTime;	}	public java.lang.String getCaseUpdatedBy() {	    return this.caseUpdatedBy;	}	public void setCaseUpdatedBy(java.lang.String caseUpdatedBy) {	    this.caseUpdatedBy=caseUpdatedBy;	}	public java.util.Date getCaseUpdatedTime() {	    return this.caseUpdatedTime;	}	public void setCaseUpdatedTime(java.util.Date caseUpdatedTime) {	    this.caseUpdatedTime=caseUpdatedTime;	}	public java.lang.Integer getId() {	    return this.id;	}	public void setId(java.lang.Integer id) {	    this.id=id;	}	public java.lang.String getCaseLitigant() {	    return this.caseLitigant;	}	public void setCaseLitigant(java.lang.String caseLitigant) {	    this.caseLitigant=caseLitigant;	}	public java.lang.String getCaseDefendantName() {	    return this.caseDefendantName;	}	public void setCaseDefendantName(java.lang.String caseDefendantName) {	    this.caseDefendantName=caseDefendantName;	}	public java.lang.String getCaseDefendantRegCapital() {	    return this.caseDefendantRegCapital;	}	public void setCaseDefendantRegCapital(java.lang.String caseDefendantRegCapital) {	    this.caseDefendantRegCapital=caseDefendantRegCapital;	}	public java.lang.String getCaseDefendantArea() {	    return this.caseDefendantArea;	}	public void setCaseDefendantArea(java.lang.String caseDefendantArea) {	    this.caseDefendantArea=caseDefendantArea;	}	public java.lang.String getPrLetter() {	    return this.prLetter;	}	public void setPrLetter(java.lang.String prLetter) {	    this.prLetter=prLetter;	}	public java.lang.String getPrLetteror() {	    return this.prLetteror;	}	public void setPrLetteror(java.lang.String prLetteror) {	    this.prLetteror=prLetteror;	}	public java.util.Date getPrSendDate() {	    return this.prSendDate;	}	public void setPrSendDate(java.util.Date prSendDate) {	    this.prSendDate=prSendDate;	}	public java.util.Date getPrDeliveryDate() {	    return this.prDeliveryDate;	}	public void setPrDeliveryDate(java.util.Date prDeliveryDate) {	    this.prDeliveryDate=prDeliveryDate;	}	public java.lang.String getPrIsClose() {	    return this.prIsClose;	}	public void setPrIsClose(java.lang.String prIsClose) {	    this.prIsClose=prIsClose;	}	public java.lang.String getPrIsDirectAction() {	    return this.prIsDirectAction;	}	public void setPrIsDirectAction(java.lang.String prIsDirectAction) {	    this.prIsDirectAction=prIsDirectAction;	}	public java.lang.String getFirFirstor() {	    return this.firFirstor;	}	public void setFirFirstor(java.lang.String firFirstor) {	    this.firFirstor=firFirstor;	}	public java.lang.String getFirLawyer() {	    return this.firLawyer;	}	public void setFirLawyer(java.lang.String firLawyer) {	    this.firLawyer=firLawyer;	}	public java.util.Date getFirSubmitDate() {	    return this.firSubmitDate;	}	public void setFirSubmitDate(java.util.Date firSubmitDate) {	    this.firSubmitDate=firSubmitDate;	}	public java.util.Date getFirEstablishDate() {	    return this.firEstablishDate;	}	public void setFirEstablishDate(java.util.Date firEstablishDate) {	    this.firEstablishDate=firEstablishDate;	}	public java.math.BigDecimal getFirLitigationCosts() {	    return this.firLitigationCosts;	}	public void setFirLitigationCosts(java.math.BigDecimal firLitigationCosts) {	    this.firLitigationCosts=firLitigationCosts;	}	public java.math.BigDecimal getFirAnnouncementCosts() {	    return this.firAnnouncementCosts;	}	public void setFirAnnouncementCosts(java.math.BigDecimal firAnnouncementCosts) {	    this.firAnnouncementCosts=firAnnouncementCosts;	}	public java.math.BigDecimal getFirNotaryCosts() {	    return this.firNotaryCosts;	}	public void setFirNotaryCosts(java.math.BigDecimal firNotaryCosts) {	    this.firNotaryCosts=firNotaryCosts;	}	public java.math.BigDecimal getFirOtherCosts() {	    return this.firOtherCosts;	}	public void setFirOtherCosts(java.math.BigDecimal firOtherCosts) {	    this.firOtherCosts=firOtherCosts;	}	public java.lang.String getFirAdjudicationCourt() {	    return this.firAdjudicationCourt;	}	public void setFirAdjudicationCourt(java.lang.String firAdjudicationCourt) {	    this.firAdjudicationCourt=firAdjudicationCourt;	}	public java.lang.String getFirJudge() {	    return this.firJudge;	}	public void setFirJudge(java.lang.String firJudge) {	    this.firJudge=firJudge;	}	public java.lang.String getFirJudgeContact() {	    return this.firJudgeContact;	}	public void setFirJudgeContact(java.lang.String firJudgeContact) {	    this.firJudgeContact=firJudgeContact;	}	public java.util.Date getFirFCourtDate() {	    return this.firFCourtDate;	}	public void setFirFCourtDate(java.util.Date firFCourtDate) {	    this.firFCourtDate=firFCourtDate;	}	public java.util.Date getFirFVerdictDate() {	    return this.firFVerdictDate;	}	public void setFirFVerdictDate(java.util.Date firFVerdictDate) {	    this.firFVerdictDate=firFVerdictDate;	}	public java.util.Date getFirFVerdictReceiveDate() {	    return this.firFVerdictReceiveDate;	}	public void setFirFVerdictReceiveDate(java.util.Date firFVerdictReceiveDate) {	    this.firFVerdictReceiveDate=firFVerdictReceiveDate;	}	public java.lang.String getFirIsApology() {	    return this.firIsApology;	}	public void setFirIsApology(java.lang.String firIsApology) {	    this.firIsApology=firIsApology;	}	public java.math.BigDecimal getFirDefendantCompensationTotal() {	    return this.firDefendantCompensationTotal;	}	public void setFirDefendantCompensationTotal(java.math.BigDecimal firDefendantCompensationTotal) {	    this.firDefendantCompensationTotal=firDefendantCompensationTotal;	}	public java.math.BigDecimal getFirDefendantExpenses() {	    return this.firDefendantExpenses;	}	public void setFirDefendantExpenses(java.math.BigDecimal firDefendantExpenses) {	    this.firDefendantExpenses=firDefendantExpenses;	}	public java.math.BigDecimal getFirPlaintiffCosts() {	    return this.firPlaintiffCosts;	}	public void setFirPlaintiffCosts(java.math.BigDecimal firPlaintiffCosts) {	    this.firPlaintiffCosts=firPlaintiffCosts;	}	public java.math.BigDecimal getFirDefendantCosts() {	    return this.firDefendantCosts;	}	public void setFirDefendantCosts(java.math.BigDecimal firDefendantCosts) {	    this.firDefendantCosts=firDefendantCosts;	}	public java.lang.String getFirIsClose() {	    return this.firIsClose;	}	public void setFirIsClose(java.lang.String firIsClose) {	    this.firIsClose=firIsClose;	}	public java.util.Date getFirAppealDate() {	    return this.firAppealDate;	}	public void setFirAppealDate(java.util.Date firAppealDate) {	    this.firAppealDate=firAppealDate;	}	public java.lang.String getFirIsPreMediation() {	    return this.firIsPreMediation;	}	public void setFirIsPreMediation(java.lang.String firIsPreMediation) {	    this.firIsPreMediation=firIsPreMediation;	}	public java.lang.String getFirIsActionMediation() {	    return this.firIsActionMediation;	}	public void setFirIsActionMediation(java.lang.String firIsActionMediation) {	    this.firIsActionMediation=firIsActionMediation;	}	public java.util.Date getFirMediationDate() {	    return this.firMediationDate;	}	public void setFirMediationDate(java.util.Date firMediationDate) {	    this.firMediationDate=firMediationDate;	}	public java.lang.String getFirIsAppeal() {	    return this.firIsAppeal;	}	public void setFirIsAppeal(java.lang.String firIsAppeal) {	    this.firIsAppeal=firIsAppeal;	}	public java.lang.String getFirAppellant() {	    return this.firAppellant;	}	public void setFirAppellant(java.lang.String firAppellant) {	    this.firAppellant=firAppellant;	}	public java.lang.String getFirIsCarryOut() {	    return this.firIsCarryOut;	}	public void setFirIsCarryOut(java.lang.String firIsCarryOut) {	    this.firIsCarryOut=firIsCarryOut;	}	public java.lang.String getTwoLawyer() {	    return this.twoLawyer;	}	public void setTwoLawyer(java.lang.String twoLawyer) {	    this.twoLawyer=twoLawyer;	}	public java.util.Date getTwoSCourtDate() {	    return this.twoSCourtDate;	}	public void setTwoSCourtDate(java.util.Date twoSCourtDate) {	    this.twoSCourtDate=twoSCourtDate;	}	public java.lang.String getTwoJudge() {	    return this.twoJudge;	}	public void setTwoJudge(java.lang.String twoJudge) {	    this.twoJudge=twoJudge;	}	public java.lang.String getTwoJudgeContact() {	    return this.twoJudgeContact;	}	public void setTwoJudgeContact(java.lang.String twoJudgeContact) {	    this.twoJudgeContact=twoJudgeContact;	}	public java.util.Date getTwoSJudgmentEffectiveDate() {	    return this.twoSJudgmentEffectiveDate;	}	public void setTwoSJudgmentEffectiveDate(java.util.Date twoSJudgmentEffectiveDate) {	    this.twoSJudgmentEffectiveDate=twoSJudgmentEffectiveDate;	}	public java.lang.String getTwoIsApology() {	    return this.twoIsApology;	}	public void setTwoIsApology(java.lang.String twoIsApology) {	    this.twoIsApology=twoIsApology;	}	public java.lang.String getTwoDefendantCompensationTotal() {	    return this.twoDefendantCompensationTotal;	}	public void setTwoDefendantCompensationTotal(java.lang.String twoDefendantCompensationTotal) {	    this.twoDefendantCompensationTotal=twoDefendantCompensationTotal;	}	public java.lang.String getTwoDefendantExpenses() {	    return this.twoDefendantExpenses;	}	public void setTwoDefendantExpenses(java.lang.String twoDefendantExpenses) {	    this.twoDefendantExpenses=twoDefendantExpenses;	}	public java.lang.String getTwoPlaintiffCosts() {	    return this.twoPlaintiffCosts;	}	public void setTwoPlaintiffCosts(java.lang.String twoPlaintiffCosts) {	    this.twoPlaintiffCosts=twoPlaintiffCosts;	}	public java.math.BigDecimal getTwoDefendantCosts() {	    return this.twoDefendantCosts;	}	public void setTwoDefendantCosts(java.math.BigDecimal twoDefendantCosts) {	    this.twoDefendantCosts=twoDefendantCosts;	}	public java.lang.String getTwoIsClose() {	    return this.twoIsClose;	}	public void setTwoIsClose(java.lang.String twoIsClose) {	    this.twoIsClose=twoIsClose;	}	public java.util.Date getTwoExecutionDeadline() {	    return this.twoExecutionDeadline;	}	public void setTwoExecutionDeadline(java.util.Date twoExecutionDeadline) {	    this.twoExecutionDeadline=twoExecutionDeadline;	}	public java.lang.String getTwoIsCarryOut() {	    return this.twoIsCarryOut;	}	public void setTwoIsCarryOut(java.lang.String twoIsCarryOut) {	    this.twoIsCarryOut=twoIsCarryOut;	}	public java.lang.String getOutLawyer() {	    return this.outLawyer;	}	public void setOutLawyer(java.lang.String outLawyer) {	    this.outLawyer=outLawyer;	}	public java.util.Date getOutAppDate() {	    return this.outAppDate;	}	public void setOutAppDate(java.util.Date outAppDate) {	    this.outAppDate=outAppDate;	}	public java.math.BigDecimal getOutAppTotal() {	    return this.outAppTotal;	}	public void setOutAppTotal(java.math.BigDecimal outAppTotal) {	    this.outAppTotal=outAppTotal;	}	public java.lang.String getOutJudge() {	    return this.outJudge;	}	public void setOutJudge(java.lang.String outJudge) {	    this.outJudge=outJudge;	}	public java.lang.String getOutJudgeContact() {	    return this.outJudgeContact;	}	public void setOutJudgeContact(java.lang.String outJudgeContact) {	    this.outJudgeContact=outJudgeContact;	}	public java.math.BigDecimal getOutActualTotal() {	    return this.outActualTotal;	}	public void setOutActualTotal(java.math.BigDecimal outActualTotal) {	    this.outActualTotal=outActualTotal;	}	public java.lang.String getOutFCollectionSubject() {	    return this.outFCollectionSubject;	}	public void setOutFCollectionSubject(java.lang.String outFCollectionSubject) {	    this.outFCollectionSubject=outFCollectionSubject;	}	public java.lang.String getOutIsReconcile() {	    return this.outIsReconcile;	}	public void setOutIsReconcile(java.lang.String outIsReconcile) {	    this.outIsReconcile=outIsReconcile;	}	public java.lang.String getOutIsClose() {	    return this.outIsClose;	}	public void setOutIsClose(java.lang.String outIsClose) {	    this.outIsClose=outIsClose;	}
	public java.lang.String getSupplyName() {
		return supplyName;
	}
	public void setSupplyName(java.lang.String supplyName) {
		this.supplyName = supplyName;
	}
	public java.lang.String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(java.lang.String applicantName) {
		this.applicantName = applicantName;
	}
	public java.lang.String getForensicsName() {
		return forensicsName;
	}
	public void setForensicsName(java.lang.String forensicsName) {
		this.forensicsName = forensicsName;
	}
	public java.lang.String getLetterorName() {
		return letterorName;
	}
	public void setLetterorName(java.lang.String letterorName) {
		this.letterorName = letterorName;
	}
	public java.lang.String getFirLawyerName() {
		return firLawyerName;
	}
	public void setFirLawyerName(java.lang.String firLawyerName) {
		this.firLawyerName = firLawyerName;
	}
	public java.lang.String getTwoLawyerName() {
		return twoLawyerName;
	}
	public void setTwoLawyerName(java.lang.String twoLawyerName) {
		this.twoLawyerName = twoLawyerName;
	}
	public java.lang.String getOutLawyerName() {
		return outLawyerName;
	}
	public void setOutLawyerName(java.lang.String outLawyerName) {
		this.outLawyerName = outLawyerName;
	}
	public java.lang.String getCreateName() {
		return createName;
	}
	public void setCreateName(java.lang.String createName) {
		this.createName = createName;
	}
	public java.lang.String getUpdateName() {
		return updateName;
	}
	public void setUpdateName(java.lang.String updateName) {
		this.updateName = updateName;
	}
}