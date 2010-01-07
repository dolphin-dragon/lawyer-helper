package com.law.service;

import java.util.List;

import com.law.bean.SysUser;
import com.law.bean.Unit;
import com.law.dao.UnitDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;

/**
 * 说明：组织节点服务类
 *
 */
public class UnitService {
	private UnitDao unitDao = new UnitDao();
	/**
	 * 说明：获取指定系统的组织节点列表
	 * 
	 * @param systemid
	 * @return
	 */
	public List<Unit> getSysUnits(String systemid){
		try {
			return unitDao.querySysUnits(DBServices.getDBService().getConnection(), systemid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 说明：添加组织节点到系统中
	 * 
	 * @param source 组织对象
	 */
	public boolean addUnit(Unit source){
		try {
			unitDao.saveUnit(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：添加组织节点到系统中
	 * 
	 * @param source 组织对象
	 */
	public boolean addUnits(List<Unit> source){
		try {
			unitDao.saveUnits(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：删除组织节点
	 * 
	 * @param source 组织对象
	 * @return 
	 */
	public boolean deleteUnit(Unit source){
		try {
			unitDao.deleteUnit(DBServices.getDBService().getConnection(),source.getSysid(), source.getDepid(), source.getUserid());
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：移除指定组织下的指定人员
	 * 
	 * @param unit 组织节点
	 * @param user 系统人员
	 * @return 
	 */
	public boolean removeSysUserFromUnit(Unit unit,SysUser user){
		try {
			unitDao.deleteUnit(DBServices.getDBService().getConnection(),unit.getSysid(),unit.getDepid(), user.get_ID());
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：删除指定系统指定部门下的用户
	 * 
	 * @param sysid 系统标识
	 * @param depid 部门标识
	 * @param userid 用户标识
	 * @return
	 */
	public boolean removeSysUserFromUnit(String sysid,String depid,String userid){
		try {
			unitDao.deleteUnit(DBServices.getDBService().getConnection(),sysid,depid, userid);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 说明：获取指定部门下的组织节点列表(即组织下的人员列表)
	 * 
	 * @param depid 部门标识
	 * @return 组织节点列表
	 */
	public List<Unit> getDepUser(String sysid,String depid){
		try {
			return unitDao.queryUnit(DBServices.getDBService().getConnection(),sysid,depid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
}