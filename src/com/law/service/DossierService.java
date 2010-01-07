package com.law.service;

import java.util.Date;
import java.util.List;

import com.law.bean.Dossier;
import com.law.dao.DossierDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;

/**
 * ˵�����������ڷ�����
 * @author user
 *
 */
public class DossierService {
	private DossierDao dossierDao = new DossierDao();
	/**
	 * ˵������ȡָ���û��İ������б�
	 * 
	 * @param userid �û���ʶ
	 * @return �������б�
	 */
	public List<Dossier> getUserDossier(String system,String userid){
		try {
			return dossierDao.queryUserDossiers(DBServices.getDBService().getConnection(),system,userid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ˵������ȡָ���������ʶ�İ��������
	 * @param dossierid ������ʶ
	 * @return ���������
	 */
	public Dossier getDossier(String sysid,String dossierid){
		try {
			return dossierDao.queryDossier(DBServices.getDBService().getConnection(), sysid, dossierid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;		
	}
	
	/**
	 * ˵��������һ��������ָ�����û�
	 * @param userid �û���ʶ
	 * @param source ������
	 * @return 
	 */
	public boolean addDossier(String userid,Dossier source){
		source.setCreator(userid);
		try {
			dossierDao.saveDossier(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵��������ָ����������
	 * 
	 * @param source �����������
	 * @return 
	 */
	public boolean updateDossier(Dossier source){
		try {
			dossierDao.updateDossier(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵����ɾ�������İ����������
	 * 
	 * @param source
	 * @return
	 */
	public boolean deleteDossier(Dossier source){
		try {
			dossierDao.deleteDossier(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * ˵����ɾ��ָ��ϵͳָ����������
	 * 
	 * @param sysid ϵͳ��ʶ
	 * @param dossierid ���������ʶ
	 * @return
	 */
	public boolean deleteDossier(String sysid,String dossierid){
		try {
			dossierDao.deleteDossier(DBServices.getDBService().getConnection(), sysid, dossierid);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵�������ݸ�������Ϣ��������������󣬲����д洢����
	 * 
	 * @param sysid
	 * @param dossierName
	 * @return
	 */
	public synchronized Dossier createDossier(String sysid,String dossiercode,String dossierName){
		try {
			//D_00000000
			String maxdoc = dossierDao.getMaxDossierID(DBServices.getDBService().getConnection());
			String newdocid = "D_"+Utils.getNextStr(8, Long.valueOf(maxdoc.substring(2)));
			Dossier source = new Dossier(sysid,newdocid,dossiercode,dossierName);
			dossierDao.saveDossier(DBServices.getDBService().getConnection(), source);
			return source;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ˵������ȡָ���û���ʷָ�������ڵİ��������б�
	 * 
	 * @param userid �û���ʶ
	 * @param day �ӽ�������ʷ�����ڵİ�Դ
	 * @return ���������б�
	 */
	public List<Dossier> getDossiers(String system,String userid,int day){
		Date edate = new Date();
		Date sdate = new Date((edate.getTime())-(day*60*60*24*1000L));
		try {
			return dossierDao.getUserTimesDossiers(DBServices.getDBService().getConnection(),system,userid,sdate, edate);
		} catch (LawyerException e) {
			e.printStackTrace();
			return null;
		}
	}
}