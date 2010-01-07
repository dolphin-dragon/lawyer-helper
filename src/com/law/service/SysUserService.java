package com.law.service;

import java.util.List;

import com.law.bean.SysUser;
import com.law.dao.SysUserDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;

/**
 * 说明：系统用户服务类
 * 
 */
public class SysUserService {
	private SysUserDao sysUserDao = new SysUserDao();
	/**
	 * 说明：获取指定系统的人员列表
	 * 
	 * @param systemid 系统标识
	 * @return 系统人员列表
	 */
	public List<SysUser> getSystemUser(String systemid){
		try {
			return sysUserDao.querySysUsers(DBServices.getDBService().getConnection(), systemid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 说明：删除指定的人员对象
	 * 
	 * @param source 系统人员对象
	 * @return 
	 */
	public boolean deleteSysUser(SysUser source){
		try {
			sysUserDao.deleteSysUser(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：更新人员对象
	 * 
	 * @param source 系统人员对象
	 * @return 
	 */
	public boolean updateSysuse(SysUser source){
		try {
			sysUserDao.updateSysUser(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：根据给定的名称穿件系统内部用户
	 * 
	 * @param userName 系统内部用户名称
	 * @return 返回新构建的系统内部用户对象
	 * @throws LawyerException 
	 */
	public synchronized SysUser createSysUser(String userName, String sysid) throws LawyerException {
		try {
			//SU_0000000
			String maxid = sysUserDao.getMaxSysUserID(DBServices.getDBService().getConnection());
			String newUserID = "SU_"+Utils.getNextStr(7, Long.valueOf(maxid.substring(3)).longValue());
			SysUser user = new SysUser(sysid, newUserID, userName);
			sysUserDao.saveSysUser(DBServices.getDBService().getConnection(), user);
			return user;
		} catch (LawyerException e) {
			throw new LawyerException("Create Sys User is error! "+ e.getMessage());
		} finally {
		}
	}
	
	/**
	 * 说明：获取指定标识的内部用户对象
	 * 
	 * @param userid 系统内部用户标识
	 * @return 系统内部用户对象
	 */
	public SysUser querySysUserByID(String system,String userid){
		try {
			return sysUserDao.querySysUserByID(DBServices.getDBService().getConnection(),system, userid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
}