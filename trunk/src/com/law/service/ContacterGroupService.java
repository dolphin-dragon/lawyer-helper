package com.law.service;

import java.util.List;

import com.law.bean.ContacterGroup;
import com.law.dao.ContacterGroupDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;
/**
 * 说明：联系人组服务类
 * 
 */
public class ContacterGroupService {
	private ContacterGroupDao cgDao = new ContacterGroupDao();
	/**
	 * 说明：获取指定用户标识创建的所有联系人组列表
	 * 
	 * @param userid 用户标识 
	 * @return 联系组列表
	 */
	public List<ContacterGroup> getContacterGroup(String system,String userid){
		try {
			return cgDao.queryContacterGroupByUser(DBServices.getDBService().getConnection(), system, userid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 说明：给指定的用户增加一个联系人组
	 * 
	 * @param userid 用户标识
	 * @param group 联系人组对象
	 * @return 
	 */
	public boolean addContacterGroup(String userid,ContacterGroup group){
		try {
			group.setCreatorid(userid);
			cgDao.saveContacterGroup(DBServices.getDBService().getConnection(), group);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：更新指定用户的联系组
	 * 
	 * @param userid 用户标识
	 * @param group 联系组对象
	 * @return 
	 */
	public boolean updateContacterGroup(String userid,ContacterGroup group){
		try {
			group.setCreatorid(userid);
			cgDao.updateContacterGroup(DBServices.getDBService().getConnection(), group);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：删除给定的分组对象
	 * 
	 * @param source 分组对象
	 * @return
	 */
	public boolean deleteContacterGroup(ContacterGroup source){
		try {
			cgDao.deleteContacterGroup(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：删除系统中指定用户的指定分组标识的分组对象
	 * 
	 * @param system 系统标识
	 * @param user 用户标识
	 * @param groupid 分组标识
	 * @return
	 */
	public boolean deleteContacterGroup(String system,String user,String groupid){
		try {
			cgDao.deleteContacterGroup(DBServices.getDBService().getConnection(), system,user,groupid);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：判断当前用户创建的联系人分组名称是否已经存在
	 * 
	 * @param system 系统标识
	 * @param user 创建者标识
	 * @param cgname 分组名称
	 * @return
	 */
	public synchronized boolean checkGnameExist(String system,String user,String cgname){
		try {
			return cgDao.checkNameExist(DBServices.getDBService().getConnection(), system, user, cgname);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * 说明：根据给定的信息构建用户联系分组对象
	 * 
	 * @param system 系统标识
	 * @param user 创建者标识
	 * @param gname 分组名称
	 * @return
	 */
	public synchronized ContacterGroup createContacterGroup(String system,String user,String gname){
		try {
			//CG_0000000
			String maxid = cgDao.getMaxContacterGroupID(DBServices.getDBService().getConnection());
			String newid = "CG_" + Utils.getNextStr(7, Long.valueOf(maxid.substring(3)));
			ContacterGroup group = new ContacterGroup(system,user,newid);
			group.setName(gname);
			cgDao.saveContacterGroup(DBServices.getDBService().getConnection(), group);
			return group;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
}