package com.law.bean;

import java.util.Date;
import java.util.List;
/**
 * 说明：案件报告类
 *
 */
public class DossierReport {
	//报告标识
	private String reportID="";
	//案件标识
	private String dossierID="";
	//案件阶段
	private String stage = "";
	//报告日期
	private Date reportDate = null;
	//报告人
	private String reportor = "";
	//报告标题
	private String title="";
	//报告内容
	private String content = "";
	
	//报告中使用到的附件列表，主要记录附件的ID号
	private List<String> attachements=null;
	
	public DossierReport(String reportid) {
		reportID = reportid;
	}

	public String getDossierID() {
		return dossierID;
	}

	public void setDossierID(String dossierID) {
		this.dossierID = dossierID;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportor() {
		return reportor;
	}

	public void setReportor(String reportor) {
		this.reportor = reportor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getAttachements() {
		return attachements;
	}

	public void setAttachements(List<String> attachements) {
		this.attachements = attachements;
	}

	public String getReportID() {
		return reportID;
	}	
}
