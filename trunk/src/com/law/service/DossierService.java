package com.law.service;

import java.util.Date;
import java.util.List;

import com.law.bean.Dossier;
import com.law.dao.DossierDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;

/**
 * 说明：案件卷宗服务类
 * @author user
 *
 */
public class DossierService {
	private DossierDao dossierDao = new DossierDao();
	/**
	 * 说明：获取指定用户的案件卷列表
	 * 
	 * @param userid 用户标识
	 * @return 案件卷列表
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
	 * 说明：获取指定案件卷标识的案件卷对象
	 * @param dossierid 案件标识
	 * @return 案件卷对象
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
	 * 说明：增加一个案件给指定的用户
	 * @param userid 用户标识
	 * @param source 案件卷
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
	 * 说明：更新指定案件案卷
	 * 
	 * @param source 案件案卷对象
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
	 * 说明：删除给定的案件案卷对象
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
	 * 说明：删除指定系统指定案件案卷
	 * 
	 * @param sysid 系统标识
	 * @param dossierid 案件案卷标识
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
	 * 说明：根据给定的信息构建案件案卷对象，并进行存储处理
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
	 * 说明：获取指定用户历史指定天数内的案件案卷列表
	 * 
	 * @param userid 用户标识
	 * @param day 从今天起历史天数内的案源
	 * @return 案件案卷列表
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