package com.law.service;

import java.util.List;

import com.law.bean.LinkMan;
import com.law.dao.LinkManDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;

/**
 * 说明：联系服务类
 * 
 */
public class LinkManService {
	private LinkManDao linkManDao = new LinkManDao();
	/**
	 * 说明：获取指定用户的联系人列表
	 * @param userid
	 * @return
	 */
	public List<LinkMan> getUserLinkMan(String sysid,String userid){
		try {
			return linkManDao.queryUserLinkMans(DBServices.getDBService().getConnection(), userid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 说明：获取指定标识的联系人对象
	 * @param linkManID 联系人标识
	 * @return 联系人对象
	 */
	public LinkMan getLinkMan(String sysid,String linkManID){
		try {
			return linkManDao.queryLinkMan(DBServices.getDBService().getConnection(), linkManID);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 说明：给指定用户添加联系人
	 * 
	 * @param userid 用户标识
	 * @param source 联系人对象
	 */
	public boolean addLinkMan(LinkMan source){
		try {
			linkManDao.saveLinkMan(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：更新联系人
	 * 
	 * @param source 联系人对象
	 */
	public boolean updateLinkMan(LinkMan source){
		try {
			linkManDao.updateLinkMan(DBServices.getDBService().getConnection(),source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 说明：删除指定用户的特定联系人
	 * 
	 * @param userid 用户标识
	 * @param source 联系人对象
	 */
	public boolean deleteLinkMan(String userid,LinkMan source){
		//实现必须效验该联系人是否是userid创建
		try {
			linkManDao.deleteLinkMan(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：删除指定联系人对象
	 * 
	 * @param source 联系人对象
	 * @return
	 */
	public boolean deleteLinkMan(LinkMan source){
		//直接删除
		try {
			linkManDao.deleteLinkMan(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 说明：删除指定系统、指定用户的指定联系人
	 * 
	 * @param userid 用户标识
	 * @param linkManID 联系人标识
	 * @param sysid 系统标识
	 * @return
	 */
	public boolean deleteLinkMan(String userid,String linkManID,String sysid){
		//实现必须效验该联系人是否是userid创建
		try {
			linkManDao.deleteLinkMan(DBServices.getDBService().getConnection(), linkManID);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteLinkMan(String linkManID,String sysid){
		//直接删除
		try {
			linkManDao.deleteLinkMan(DBServices.getDBService().getConnection(), linkManID);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：根据给定的信息创建联系人对象
	 * 
	 * @param name 联系人名称
	 * @param sysid 系统标识
	 * @return
	 */
	public synchronized LinkMan createLinkMan(String name,String sysid){
		try {
			//L_00000000
			String maxid = linkManDao.getMaxContacteID(DBServices.getDBService().getConnection());
			String newid = "L_"+Utils.getNextStr(8, Long.valueOf(maxid.substring(2)));
			LinkMan source = new LinkMan(sysid, newid, name);
			linkManDao.saveLinkMan(DBServices.getDBService().getConnection(), source);
			return source;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
}