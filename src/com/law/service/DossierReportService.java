package com.law.service;

import java.util.List;

import com.law.bean.DossierReport;
import com.law.dao.DossierReportDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;

/**
 * ˵�����������������
 * 
 */
public class DossierReportService {
	private DossierReportDao dossierReportDao = new DossierReportDao();
	/**
	 * ˵������ȡָ��������ʶ�ı����б�
	 * 
	 * @param dossierID ������ʶ
	 * @return ���������б�
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
	 * ˵������ȡָ�������ʶ�ı������
	 * 
	 * @param dossierReportID �����ʶ
	 * @return �������
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
	 * ˵�������Ӱ����ı���
	 * 
	 * @param report �����������
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
	 * ˵��������ָ���İ������������
	 * 
	 * @param report �������������
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
	 * ˵����ɾ��ָ���İ������������
	 * 
	 * @param report ��������������
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
	 * ˵����ɾ��ָ����ʶ�İ���������
	 * 
	 * @param dossierReportid �����������ʶ
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
	 * ˵�������ݸ����ı��ⴴ���������������
	 * 
	 * @param reportTitle ������������������
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