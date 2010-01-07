package com.law.bean;

import java.util.Date;

/**
 * ˵�������������࣬���Ѿ���ʽ���з���Э���İ�Դ��������
 * 
 */
public class Dossier {
	//������ʶ
	private String id="";
	//ϵͳ��ʶ
	private String sysid="";
	//��������
	private String code = ""; 
	//��������
	private String name ="";
	//�������
	private int taget =0;
	//�����շ�
	private int charge = 0;
	//����״̬
	private String status = "";
	//��������
	private String type = "";
	//������
	private String party = "";
	//���������
	private String party_status="";
	//����������ʦ
	private String mlawyer = "";
	//Э����ʦ
	private String slawyer = "";
	//����������
	private String creator="";
	//��������ʱ��
	private Date cDate=null;
	//�����༭��
	private String modify = "";
	//�����༭ʱ��
	private Date mDate = null;
	//�����İ���������
	private String dependcase="";
	//���������������
	private Date eDate = null;
	//�հ���ʽ
	private String admissionType = "";
	//�鵵����
	private Date archiveDate = null;
	//����׶�
	private String judge = "";
	//�Ƿ���Ԯ��
	private String isaid = ""; 
	//�Ƿ�����
	private String isforeign = "";
	//˾������
	private String judicialtype = "";
	//����
	private String brief = "";
	//�����������
	private String summary = "";
	
	/**
	 * ˵����������
	 * 
	 * @param system ϵͳ��ʶ
	 * @param id ������ʶ
	 * @param casecode ��������
	 * @param name ��������
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