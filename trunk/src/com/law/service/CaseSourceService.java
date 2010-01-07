package com.law.service;

import java.util.Date;
import java.util.List;

import com.law.bean.CaseSource;
import com.law.dao.CaseSourceDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;

/**
 * 说明：案源服务类
 *
 */
public class CaseSourceService {
	private CaseSourceDao caseSourceDao = new CaseSourceDao();
	
	/**
	 * 说明：获取指定用户的案源列表
	 * 
	 * @param userid 用户标识
	 * @return 案源列表
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
	 * 说明：获取指定用户历史指定天数内的案源列表
	 * 
	 * @param userid 用户标识
	 * @param day 从今天起历史天数内的案源
	 * @return 案源列表
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
	 * 说明：获取特定案源标识的案源对象
	 * 
	 * @param caseSourceID 案源标识
	 * @return 案源对象
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
	 * 说明：删除给定的案源对象
	 * 
	 * @param source 案源对象
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
	 * 说明：删除指定系统指定标识的案源对象
	 * 
	 * @param sysid 系统标识
	 * @param caseid 案源标识
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
	 * 说明：更新给定的案源对象
	 * 
	 * @param source 案源对象
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
	 * 说明：获取新案源的标识
	 * @return
	 * @throws LawyerException
	 */
	private String getNewCaseSourceID() throws LawyerException {
		String maxID = caseSourceDao.getMaxCaseSourceID(DBServices.getDBService().getConnection());
		Long max = Long.valueOf(maxID.substring(2));
		return "S_"+Utils.getNextStr(8,max);
	}
	
	/**
	 * 说明：根据给定的信息构建案源对象，并在数据库中存储
	 * 
	 * @param sysid 系统标识
	 * @param name 案源名称
	 * @param creator 创建者标识
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