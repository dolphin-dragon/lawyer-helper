package lawyer.base.ccase.page;

import com.base.page.BasePage;

/**
 * <b>功能：</b>LawCaseCloseStatPage<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2018-07-12 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class LawCaseCloseStatPage extends BasePage {
		private java.lang.Integer id;//   结案ID标识	private java.lang.String ccode;//   案件编号	private java.lang.String plaintiff;//   原告	private java.lang.String defendant;//   被告	private java.lang.String closeType;//   结案方式	private java.util.Date closeDate;//   结案时间	private java.math.BigDecimal compensationAmont;//   赔偿金额	private java.math.BigDecimal fairFee;//   公证费用	private java.math.BigDecimal travelExpenses;//   差旅费	private java.math.BigDecimal defendantLegalFare;//   被告负担诉费	private java.math.BigDecimal advanceFairFee;//   实际垫付公证费	private java.math.BigDecimal advanceLegalFare;//   实际垫付诉讼费/公告费	private java.math.BigDecimal refundFee;//   应退诉费	private java.math.BigDecimal returnFee;//   实退诉费	private java.math.BigDecimal costFairFee;//   公证费	private java.math.BigDecimal costLegalFare;//   诉讼费	private java.math.BigDecimal receiveDue;//   应收总计	private java.util.Date receiveDate;//   到账时间	private java.math.BigDecimal receiveAccount;//   实收总计	private java.math.BigDecimal lawyerPayBase;//   律师费计算基数	private java.math.BigDecimal lawyerPay;//   总律师费	private java.lang.String masterLawyer;//   主办律师	private java.lang.String slaveLawyerOne;//   协办律师1	private java.lang.String slaveLawyerTwo;//   协办律师2	private java.lang.String slaveLawyerThree;//   协办律师3	private java.lang.String accountInfo;//   账户信息	private java.math.BigDecimal achievement;//   绩效	private java.math.BigDecimal due;//   应支付给艺人	private java.math.BigDecimal cost;//   成本回款	private java.lang.String ctype;//   案件分类	private java.lang.String provider;//   线索人	private java.math.BigDecimal providerFee;//   线索费	private java.lang.String createBy;//   创建者	private java.util.Date createDate;//   创建时间	private java.lang.String updateBy;//   更新者	private java.util.Date updateDate;//   更新时间	private java.lang.String remarks;//   备注信息	private java.lang.String delFlag;//   删除标记	public java.lang.Integer getId() {	    return this.id;	}	public void setId(java.lang.Integer id) {	    this.id=id;	}	public java.lang.String getCcode() {	    return this.ccode;	}	public void setCcode(java.lang.String ccode) {	    this.ccode=ccode;	}	public java.lang.String getPlaintiff() {	    return this.plaintiff;	}	public void setPlaintiff(java.lang.String plaintiff) {	    this.plaintiff=plaintiff;	}	public java.lang.String getDefendant() {	    return this.defendant;	}	public void setDefendant(java.lang.String defendant) {	    this.defendant=defendant;	}	public java.lang.String getCloseType() {	    return this.closeType;	}	public void setCloseType(java.lang.String closeType) {	    this.closeType=closeType;	}	public java.util.Date getCloseDate() {	    return this.closeDate;	}	public void setCloseDate(java.util.Date closeDate) {	    this.closeDate=closeDate;	}	public java.math.BigDecimal getCompensationAmont() {	    return this.compensationAmont;	}	public void setCompensationAmont(java.math.BigDecimal compensationAmont) {	    this.compensationAmont=compensationAmont;	}	public java.math.BigDecimal getFairFee() {	    return this.fairFee;	}	public void setFairFee(java.math.BigDecimal fairFee) {	    this.fairFee=fairFee;	}	public java.math.BigDecimal getTravelExpenses() {	    return this.travelExpenses;	}	public void setTravelExpenses(java.math.BigDecimal travelExpenses) {	    this.travelExpenses=travelExpenses;	}	public java.math.BigDecimal getDefendantLegalFare() {	    return this.defendantLegalFare;	}	public void setDefendantLegalFare(java.math.BigDecimal defendantLegalFare) {	    this.defendantLegalFare=defendantLegalFare;	}	public java.math.BigDecimal getAdvanceFairFee() {	    return this.advanceFairFee;	}	public void setAdvanceFairFee(java.math.BigDecimal advanceFairFee) {	    this.advanceFairFee=advanceFairFee;	}	public java.math.BigDecimal getAdvanceLegalFare() {	    return this.advanceLegalFare;	}	public void setAdvanceLegalFare(java.math.BigDecimal advanceLegalFare) {	    this.advanceLegalFare=advanceLegalFare;	}	public java.math.BigDecimal getRefundFee() {	    return this.refundFee;	}	public void setRefundFee(java.math.BigDecimal refundFee) {	    this.refundFee=refundFee;	}	public java.math.BigDecimal getReturnFee() {	    return this.returnFee;	}	public void setReturnFee(java.math.BigDecimal returnFee) {	    this.returnFee=returnFee;	}	public java.math.BigDecimal getCostFairFee() {	    return this.costFairFee;	}	public void setCostFairFee(java.math.BigDecimal costFairFee) {	    this.costFairFee=costFairFee;	}	public java.math.BigDecimal getCostLegalFare() {	    return this.costLegalFare;	}	public void setCostLegalFare(java.math.BigDecimal costLegalFare) {	    this.costLegalFare=costLegalFare;	}	public java.math.BigDecimal getReceiveDue() {	    return this.receiveDue;	}	public void setReceiveDue(java.math.BigDecimal receiveDue) {	    this.receiveDue=receiveDue;	}	public java.util.Date getReceiveDate() {	    return this.receiveDate;	}	public void setReceiveDate(java.util.Date receiveDate) {	    this.receiveDate=receiveDate;	}	public java.math.BigDecimal getReceiveAccount() {	    return this.receiveAccount;	}	public void setReceiveAccount(java.math.BigDecimal receiveAccount) {	    this.receiveAccount=receiveAccount;	}	public java.math.BigDecimal getLawyerPayBase() {	    return this.lawyerPayBase;	}	public void setLawyerPayBase(java.math.BigDecimal lawyerPayBase) {	    this.lawyerPayBase=lawyerPayBase;	}	public java.math.BigDecimal getLawyerPay() {	    return this.lawyerPay;	}	public void setLawyerPay(java.math.BigDecimal lawyerPay) {	    this.lawyerPay=lawyerPay;	}	public java.lang.String getMasterLawyer() {	    return this.masterLawyer;	}	public void setMasterLawyer(java.lang.String masterLawyer) {	    this.masterLawyer=masterLawyer;	}	public java.lang.String getSlaveLawyerOne() {	    return this.slaveLawyerOne;	}	public void setSlaveLawyerOne(java.lang.String slaveLawyerOne) {	    this.slaveLawyerOne=slaveLawyerOne;	}	public java.lang.String getSlaveLawyerTwo() {	    return this.slaveLawyerTwo;	}	public void setSlaveLawyerTwo(java.lang.String slaveLawyerTwo) {	    this.slaveLawyerTwo=slaveLawyerTwo;	}	public java.lang.String getSlaveLawyerThree() {	    return this.slaveLawyerThree;	}	public void setSlaveLawyerThree(java.lang.String slaveLawyerThree) {	    this.slaveLawyerThree=slaveLawyerThree;	}	public java.lang.String getAccountInfo() {	    return this.accountInfo;	}	public void setAccountInfo(java.lang.String accountInfo) {	    this.accountInfo=accountInfo;	}	public java.math.BigDecimal getAchievement() {	    return this.achievement;	}	public void setAchievement(java.math.BigDecimal achievement) {	    this.achievement=achievement;	}	public java.math.BigDecimal getDue() {	    return this.due;	}	public void setDue(java.math.BigDecimal due) {	    this.due=due;	}	public java.math.BigDecimal getCost() {	    return this.cost;	}	public void setCost(java.math.BigDecimal cost) {	    this.cost=cost;	}	public java.lang.String getCtype() {	    return this.ctype;	}	public void setCtype(java.lang.String ctype) {	    this.ctype=ctype;	}	public java.lang.String getProvider() {	    return this.provider;	}	public void setProvider(java.lang.String provider) {	    this.provider=provider;	}	public java.math.BigDecimal getProviderFee() {	    return this.providerFee;	}	public void setProviderFee(java.math.BigDecimal providerFee) {	    this.providerFee=providerFee;	}	public java.lang.String getCreateBy() {	    return this.createBy;	}	public void setCreateBy(java.lang.String createBy) {	    this.createBy=createBy;	}	public java.util.Date getCreateDate() {	    return this.createDate;	}	public void setCreateDate(java.util.Date createDate) {	    this.createDate=createDate;	}	public java.lang.String getUpdateBy() {	    return this.updateBy;	}	public void setUpdateBy(java.lang.String updateBy) {	    this.updateBy=updateBy;	}	public java.util.Date getUpdateDate() {	    return this.updateDate;	}	public void setUpdateDate(java.util.Date updateDate) {	    this.updateDate=updateDate;	}	public java.lang.String getRemarks() {	    return this.remarks;	}	public void setRemarks(java.lang.String remarks) {	    this.remarks=remarks;	}	public java.lang.String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(java.lang.String delFlag) {	    this.delFlag=delFlag;	}
}