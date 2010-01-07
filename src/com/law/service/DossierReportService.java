package com.law.service;

import java.util.List;

import com.law.bean.DossierReport;
import com.law.dao.DossierReportDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;

/**
 * 说明：案件报告服务类
 * 
 */
public class DossierReportService {
	private DossierReportDao dossierReportDao = new DossierReportDao();
	/**
	 * 说明：获取指定案件标识的报告列表
	 * 
	 * @param dossierID 案件标识
	 * @return 案件报告列表
	 */
	public List<DossierReport> getDossierReport(String dossierID){
		try {
			return dossierReportDao.queryDossierReports(DBServices.getDBService().getConnection(), dossierID);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 说明：获取指定报告标识的报告对象
	 * 
	 * @param dossierReportID 报告标识
	 * @return 报告对象
	 */
	public DossierReport getReport(String dossierReportID){
		try {
			return dossierReportDao.queryDossierReport(DBServices.getDBService().getConnection(), dossierReportID);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 说明：增加案件的报告
	 * 
	 * @param report 案件报告对象
	 */
	public boolean addDossierReport(DossierReport report){
		try {
			dossierReportDao.saveDossierReport(DBServices.getDBService().getConnection(), report);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：更新指定的案件案卷报告对象
	 * 
	 * @param report 案件案卷报告对象
	 * @return
	 */
	public boolean updateDossierReport(DossierReport report){
		try {
			throw new Exception("Update Dossier Report isn't support!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：删除指定的案件案卷报告对象
	 * 
	 * @param report 案件案卷报个对象
	 * @return
	 */
	public boolean deleteDossierReport(DossierReport report){
		try {
			dossierReportDao.deleteDossierReport(DBServices.getDBService().getConnection(), report);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：删除指定标识的案件案卷报告
	 * 
	 * @param dossierReportid 案件案卷报告标识
	 * @return
	 */
	public boolean deleteDossierReport(String dossierReportid){
		try {
			dossierReportDao.deleteDossierReport(DBServices.getDBService().getConnection(), dossierReportid);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：根据给定的标题创建案件案卷报告对象
	 * 
	 * @param reportTitle 案件案卷报个对象名称
	 * @return
	 */
	public synchronized DossierReport createDossierReport(String reportTitle){
		try {
			//RE_0000000
			String maxid = dossierReportDao.getMaxDossierReportID(DBServices.getDBService().getConnection());
			String newid = "RE_"+Utils.getNextStr(7, Long.valueOf(maxid.substring(3)));
			DossierReport report = new DossierReport(newid);
			report.setTitle(reportTitle);
			dossierReportDao.saveDossierReport(DBServices.getDBService().getConnection(), report);
			return report;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
}