package com.law.service;

import java.util.Date;
import java.util.List;

import com.law.bean.CaseSource;
import com.law.dao.CaseSourceDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;

/**
 * ˵������Դ������
 *
 */
public class CaseSourceService {
	private CaseSourceDao caseSourceDao = new CaseSourceDao();
	
	/**
	 * ˵������ȡָ���û��İ�Դ�б�
	 * 
	 * @param userid �û���ʶ
	 * @return ��Դ�б�
	 */
	public List<CaseSource> getCaseSources(String userid){
		try {
			return caseSourceDao.getCaseSourcesByUser(DBServices.getDBService().getConnection(), userid);
		} catch (LawyerException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ˵������ȡָ���û���ʷָ�������ڵİ�Դ�б�
	 * 
	 * @param userid �û���ʶ
	 * @param day �ӽ�������ʷ�����ڵİ�Դ
	 * @return ��Դ�б�
	 */
	public List<CaseSource> getCaseSource(String userid,int day){
		Date edate = new Date();
		Date sdate = new Date((edate.getTime())-(day*60*60*24*1000L));
		try {
			return caseSourceDao.getUserTimesCaseSources(DBServices.getDBService().getConnection(), userid,sdate, edate);
		} catch (LawyerException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * ˵������ȡ�ض���Դ��ʶ�İ�Դ����
	 * 
	 * @param caseSourceID ��Դ��ʶ
	 * @return ��Դ����
	 */
	public CaseSource getCaseSource(String sysid,String caseSourceID){
		try {
			return caseSourceDao.queryCaseSource(DBServices.getDBService().getConnection(), sysid,caseSourceID);
		} catch (LawyerException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ˵����ɾ�������İ�Դ����
	 * 
	 * @param source ��Դ����
	 * @return
	 */
	public boolean deleteCaseSource(CaseSource source){
		try {
			caseSourceDao.deleteCaseSource(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵����ɾ��ָ��ϵͳָ����ʶ�İ�Դ����
	 * 
	 * @param sysid ϵͳ��ʶ
	 * @param caseid ��Դ��ʶ
	 * @return
	 */
	public boolean deleteCaseSource(String sysid,String caseid){
		try {
			caseSourceDao.deleteCaseSource(DBServices.getDBService().getConnection(), sysid, caseid);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵�������¸����İ�Դ����
	 * 
	 * @param source ��Դ����
	 * @return
	 */
	public boolean updateCaseSource(CaseSource source){
		try {
			caseSourceDao.updateCaseSource(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵������ȡ�°�Դ�ı�ʶ
	 * @return
	 * @throws LawyerException
	 */
	private String getNewCaseSourceID() throws LawyerException {
		String maxID = caseSourceDao.getMaxCaseSourceID(DBServices.getDBService().getConnection());
		Long max = Long.valueOf(maxID.substring(2));
		return "S_"+Utils.getNextStr(8,max);
	}
	
	/**
	 * ˵�������ݸ�������Ϣ������Դ���󣬲������ݿ��д洢
	 * 
	 * @param sysid ϵͳ��ʶ
	 * @param name ��Դ����
	 * @param creator �����߱�ʶ
	 * @return
	 * @throws LawyerException 
	 */
	public synchronized CaseSource createNewCaseSoruce(String sysid,String name,String creator) throws LawyerException{
		try {
			String newcaseid = getNewCaseSourceID();
			CaseSource source = new CaseSource(sysid,newcaseid,name);
			source.setCreatorid(creator);
			caseSourceDao.saveCaseSource(DBServices.getDBService().getConnection(), source);
			return source;
		} catch (LawyerException e) {
			throw new LawyerException("Create Case Source is error! "+ e.getMessage());
		}
	}
}