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
	private java.lang.String supplyName;
    @Excel(name = "申请公证日期", exportFormat="yyyyMMdd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "公证书申请人")
	private java.lang.String cpApplicant;//   公证书申请人
    @Excel(name = "取证人")
    private java.lang.String forensicsName;
    @Excel(name = "侵权类型" ,replace = { "肖像权_1", "肖像权(含名誉权)_2", "肖像权(含姓名权)_3","肖像权(含姓名权、名誉权)_4","名誉权_3", "_null"})
    @Excel(name = "侵权概况")
	@Excel(name = "案件可诉确认日期", exportFormat="yyyyMMdd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Excel(name = "当事人确认日期", exportFormat="yyyyMMdd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private java.lang.String cpActionImg;//   案件可诉确认截图
	@Excel(name = "当事人是否要求直接诉讼" ,replace = { "是_1", "否_2","_null"})
	
	@Excel(name = "状态",replace = { "结案通过_91","结案通过_92","结案通过_93","结案通过_94","结案通过_95", "进行中_*","进行中_null"})
	@Excel(name = "创建人")
	private java.lang.String createName;
	@Excel(name = "创建时间", exportFormat="yyyyMMdd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Excel(name = "更新人")
	private java.lang.String updateName;
	@Excel(name = "创建时间", exportFormat="yyyyMMdd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Excel(name = "被告名称")
	@Excel(name = "被告注册资本")
	@Excel(name = "被告所在地")
	
	@Excel(name = "律师函编号")
	@Excel(name = "律师函主办人")
	private java.lang.String letterorName;
	@Excel(name = "律师函发送日期", exportFormat="yyyyMMdd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Excel(name = "律师函送达日期", exportFormat="yyyyMMdd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Excel(name = "是否结案" ,replace = { "是_1", "否_2","_null"})
	@Excel(name = "是否诉讼" ,replace = { "是_1", "否_2","_null"})
	
	@Excel(name = "第一责任人")
	@Excel(name = "一审主办律师")
	private java.lang.String firLawyerName;
	@Excel(name = "提交立案材料日期", exportFormat="yyyyMMdd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Excel(name = "立案日期", exportFormat="yyyyMMdd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Excel(name = "诉讼费用")
	@Excel(name = "公告费用")
	@Excel(name = "公证费用")
	@Excel(name = "其它费用")
	@Excel(name = "受理法院")
	@Excel(name = "主办法官")
	@Excel(name = "联系方式")
	@Excel(name = "一审开庭日期", exportFormat="yyyyMMdd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Excel(name = "一审判决书落款日期", exportFormat="yyyyMMdd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Excel(name = "一审判决书收到日期", exportFormat="yyyyMMdd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Excel(name = "是否致歉" ,replace = { "是_1", "否_2","_null"})
	@Excel(name = "被告赔偿总额")
	@Excel(name = "被告承担合理开支总额")
	@Excel(name = "原告承担诉费")
	@Excel(name = "被告承担诉费")
	@Excel(name = "是否结案" ,replace = { "是_1", "否_2","_null"})
	@Excel(name = "上诉截止日期", exportFormat="yyyyMMdd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Excel(name = "是否诉前调解",replace = { "是_1", "否_2","_null"})
	@Excel(name = "是否诉中调解",replace = { "是_1", "否_2","_null"})
	@Excel(name = "调解书日期", exportFormat="yyyyMMdd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Excel(name = "是否上诉" ,replace = { "是_1", "否_2","_null"})
	@Excel(name = "上诉人")
	@Excel(name = "是否需要执行" ,replace = { "是_1", "否_2","_null"})
	
	@Excel(name = "二审主办律师")
	private java.lang.String twoLawyerName;
	@Excel(name = "调解书日期", exportFormat="yyyyMMdd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Excel(name = "主办法官")
	@Excel(name = "二审主办律师")
	@Excel(name = "二审判决生效日期", exportFormat="yyyyMMdd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Excel(name = "是否致歉" ,replace = { "是_1", "否_2","_null"})
	@Excel(name = "一审被告赔偿总额")
	@Excel(name = "一审被告承担合理开支费用")
	@Excel(name = "一审原告承担诉费")
	@Excel(name = "一审被告承担诉费")
	@Excel(name = "是否结案" ,replace = { "是_1", "否_2","_null"})
	@Excel(name = "执行截止日期", exportFormat="yyyyMMdd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Excel(name = "是否需要执行",replace = { "是_1", "否_2","_null"})
	
	@Excel(name = "执行主办律师")
	private java.lang.String outLawyerName;
	@Excel(name = "执行申请日期", exportFormat="yyyyMMdd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Excel(name = "申请执行总额")
	@Excel(name = "执行主办法官")
	@Excel(name = "联系方式")
	@Excel(name = "实际执行总额")
	@Excel(name = "首位收款主体")
	@Excel(name = "是否执行和解",replace = { "是_1", "否_2","_null"})
	@Excel(name = "是否结案",replace = { "是_1", "否_2","_null"})
	
	public java.lang.String getCpSrc() {
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