package com.law.service;

import java.util.List;

import com.law.bean.Organization;
import com.law.dao.OrganizationDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;

/**
 * 说明：联系单位服务类
 * 
 */
public class OrganizationService {
	private OrganizationDao orgDao = new OrganizationDao();
	/**
	 * 说明：获取指定用户的联系单位列表
	 * 
	 * @param userid 用户标识
	 * @return
	 */
	public List<Organization> getUserOrganizations(String sysid,String userid){
		try {
			return orgDao.queryUserOrganizations(DBServices.getDBService().getConnection(),sysid, userid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 说明：获取指定标识的联系单位对象
	 * 
	 * @param linkManID 联系单位标识
	 * @return 联系单位对象
	 */
	public Organization getOrganization(String sysid,String organizationID){
		try {
			return orgDao.queryOrganization(DBServices.getDBService().getConnection(), sysid,organizationID);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 说明：给指定用户添加联系单位
	 * 
	 * @param userid 用户标识
	 * @param source 联系单位对象
	 */
	public boolean addOrganization(Organization source){
		try {
			orgDao.saveOrganization(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：更新联系单位
	 * 
	 * @param source 联系单位对象
	 */
	public boolean updateOrganization(Organization source){
		try {
			orgDao.updateOrganization(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 说明：删除指定用户的特定联系单位
	 * 
	 * @param userid 用户标识
	 * @param source 联系单位对象
	 */
	public boolean deleteOrganization(String userid,Organization source){
		//实现必须效验该联系人是否是userid创建
		try {
			orgDao.deleteOrganization(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：删除给定的联系单位
	 * 
	 * @param source 联系单位对象
	 * @return
	 */
	public boolean deleteOrganization(Organization source){
		//直接删除
		try {
			orgDao.deleteOrganization(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：删除指定用户指定联系单位
	 * @param userid 用户标识
	 * @param organizationID 联系单位标识
	 */
	public boolean deleteOrganization(String userid,String organizationID,String sysid){
		//实现必须效验该联系人是否是userid创建
		try {
			orgDao.deleteOrganization(DBServices.getDBService().getConnection(), organizationID);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：删除指定标识的联系单位
	 * @param organizationID
	 * @param sysid
	 * @return
	 */
	public boolean deleteOrganization(String organizationID,String sysid){
		//直接删除
		try {
			orgDao.deleteOrganization(DBServices.getDBService().getConnection(), organizationID);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：根据给定的信息构建联系单位对象
	 * 
	 * @param organizationName 联系单位名称
	 * @param sysid 系统标识
	 * @return
	 */
	public synchronized Organization createOrganization(String organizationName,String sysid){
		try {
			//LP_0000000
			String maxid = orgDao.getMaxContacteID(DBServices.getDBService().getConnection());
			String newid = "LP_"+Utils.getNextStr(7, Long.valueOf(maxid.substring(3)));
			Organization source = new Organization(sysid,newid,organizationName);
			orgDao.saveOrganization(DBServices.getDBService().getConnection(), source);
			return source;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
}
