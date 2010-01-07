package com.law.bean;

import java.util.Date;

/**
 * 说明：案件卷宗类，对已经正式进行法律协助的案源进行描述
 * 
 */
public class Dossier {
	//案件标识
	private String id="";
	//系统标识
	private String sysid="";
	//案件编码
	private String code = ""; 
	//案件名称
	private String name ="";
	//案件标的
	private int taget =0;
	//案件收费
	private int charge = 0;
	//案件状态
	private String status = "";
	//案件类型
	private String type = "";
	//当事人
	private String party = "";
	//当事人身份
	private String party_status="";
	//案件主办律师
	private String mlawyer = "";
	//协办律师
	private String slawyer = "";
	//案件建立者
	private String creator="";
	//案件建立时间
	private Date cDate=null;
	//案件编辑者
	private String modify = "";
	//案件编辑时间
	private Date mDate = null;
	//依赖的案件、案卷
	private String dependcase="";
	//案件受理完成日期
	private Date eDate = null;
	//收案方式
	private String admissionType = "";
	//归档日期
	private Date archiveDate = null;
	//审理阶段
	private String judge = "";
	//是否法律援助
	private String isaid = ""; 
	//是否涉外
	private String isforeign = "";
	//司法分类
	private String judicialtype = "";
	//案由
	private String brief = "";
	//案件基本情况
	private String summary = "";
	
	/**
	 * 说明：构造子
	 * 
	 * @param system 系统标识
	 * @param id 案件标识
	 * @param casecode 案件编码
	 * @param name 案件名称
	 */
	public Dossier(String system,String id,String casecode ,String name) {
		this.sysid = system;
		this.id = id;
		this.code = casecode;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getTaget() {
		return taget;
	}

	public void setTaget(int taget) {
		this.taget = taget;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getParty_status() {
		return party_status;
	}

	public void setParty_status(String partyStatus) {
		party_status = partyStatus;
	}

	public String getMlawyer() {
		return mlawyer;
	}

	public void setMlawyer(String mlawyer) {
		this.mlawyer = mlawyer;
	}

	public String getSlawyer() {
		return slawyer;
	}

	public void setSlawyer(String slawyer) {
		this.slawyer = slawyer;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	public String getModify() {
		return modify;
	}

	public void setModify(String modify) {
		this.modify = modify;
	}

	public Date getmDate() {
		return mDate;
	}

	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}

	public String getDependcase() {
		return dependcase;
	}

	public void setDependcase(String dependcase) {
		this.dependcase = dependcase;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	public String getAdmissionType() {
		return admissionType;
	}

	public void setAdmissionType(String admissionType) {
		this.admissionType = admissionType;
	}

	public Date getArchiveDate() {
		return archiveDate;
	}

	public void setArchiveDate(Date archiveDate) {
		this.archiveDate = archiveDate;
	}

	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}

	public String getIsaid() {
		return isaid;
	}

	public void setIsaid(String isaid) {
		this.isaid = isaid;
	}

	public String getIsforeign() {
		return isforeign;
	}

	public void setIsforeign(String isforeign) {
		this.isforeign = isforeign;
	}

	public String getJudicialtype() {
		return judicialtype;
	}

	public void setJudicialtype(String judicialtype) {
		this.judicialtype = judicialtype;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getId() {
		return id;
	}

	public String getSysid() {
		return sysid;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}
}