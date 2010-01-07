package com.law.service;

import java.util.List;

import com.law.bean.Role;
import com.law.dao.RoleDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;

/**
 * 说明：角色服务类
 *
 */
public class RoleService {
	private RoleDao roleDao = new RoleDao();
	/**
	 * 说明：获取指定系统标识的角色列表
	 * 
	 * @param systemid 系统标识
	 * @return 角色列表对象
	 */
	public List<Role> getSystemRole(String systemid){
		try {
			return roleDao.querySysRoles(DBServices.getDBService().getConnection(), systemid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 说明：获取指定标识的角色对象
	 * 
	 * @param roleid 角色标识
	 * @return 角色对象
	 */
	public Role getRole(String sysid,String roleid){
		try {
			roleDao.queryRole(DBServices.getDBService().getConnection(),sysid,roleid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 说明：给指定的系统增加角色对象
	 * 
	 * @param systemid 系统标识
	 * @param source 角色对象
	 * @return 
	 */
	public boolean addRole(String systemid, Role source){
		try {
			roleDao.saveRole(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：删除指定系统的指定角色对象
	 * 
	 * @param systemid 系统标识
	 * @param source 角色对象
	 * @return 
	 */
	public boolean deleteRole(String systemid,Role source){
		try {
			roleDao.deleteRole(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：更新给定的角色对象
	 * 
	 * @param systemid 系统标识
	 * @param source 角色对象
	 * @return
	 */
	public boolean updateRole(String systemid,Role source){
		try {
			roleDao.updataRole(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：检查系统中是否存在给定名称的角色
	 * 
	 * @param system 系统标识
	 * @param roleName 角色名称
	 * @return
	 */
	public boolean checkRoleNameExist(String system,String roleName){
		try {
			return roleDao.ckeckRoleNameExist(DBServices.getDBService().getConnection(),system,roleName);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：根据给定的信息构建角色对象
	 * 
	 * @param sysid 系统标识
	 * @param roleName 角色名称
	 * @return
	 */
	public synchronized Role createRole(String sysid,String roleName){
		try {
			//RO_0000000
			String maxid = roleDao.getMaxRoleID(DBServices.getDBService().getConnection());
			String newid = "RO_"+Utils.getNextStr(7, Long.valueOf(maxid.substring(3)));
			Role source = new Role(sysid,newid);
			source.setName(roleName);
			roleDao.saveRole(DBServices.getDBService().getConnection(), source);
			return source;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
}