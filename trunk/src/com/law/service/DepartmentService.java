package com.law.service;

import java.util.List;

import com.law.bean.Department;
import com.law.dao.DeparmentDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;
/**
 * 说明：系统组织中部门的服务类
 * 
 */
public class DepartmentService {
	private DeparmentDao depDao = new DeparmentDao();
	/**
	 * 说明：获取相应系统中部门列表
	 * 
	 * @param sysid 系统标识
	 * @return 返回部门列表
	 */
	public List<Department> getSysDepartment(String sysid){
		try {
			return depDao.querySysDeps(DBServices.getDBService().getConnection(), sysid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 说明：获取指定系统、指定部门标识的部门对象
	 * 
	 * @param sysid 系统标识
	 * @param depid 部门标识
	 * @return
	 */
	public Department getDepartment(String sysid,String depid){
		try {
			return depDao.queryDepartment(DBServices.getDBService().getConnection(), sysid, depid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 说明：给指定的系统添加相应的部门
	 * 
	 * @param sysid 系统标识
	 * @param dep 部门对象
	 * @return 
	 */
	public boolean addDepartment(String sysid,Department dep){
		try {
			depDao.saveDepartment(DBServices.getDBService().getConnection(), dep);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 说明：删除指定的系统中的部门
	 * 
	 * @param sysid 系统标识
	 * @param dep 部门对象
	 * @return 
	 */
	public boolean delDepartment(String sysid,Department dep){
		try {
			depDao.deleteDepartment(DBServices.getDBService().getConnection(), dep);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：删除指定系统、指定部门标识的部门
	 * 
	 * @param sysid 系统标识
	 * @param depid 部门标识
	 * @return
	 */
	public boolean delDepartment(String sysid,String depid){
		try {
			depDao.deleteDepartment(DBServices.getDBService().getConnection(), sysid, depid);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：根据给定的名称、系统标识构建部门对象，并在数据库中存储
	 * 
	 * @param sysid 系统标识
	 * @param depname 部门名称
	 * @return
	 */
	public synchronized Department createDepartment(String sysid,String depname){
		try {
			//DEP_000000
			String max = depDao.getMaxDepartmentID(DBServices.getDBService().getConnection());
			String newid = "DEP_" + Utils.getNextStr(6, Long.valueOf(max.substring(4)));
			Department dep = new Department(sysid,newid);
			dep.setName(depname);
			depDao.saveDepartment(DBServices.getDBService().getConnection(), dep);
			return dep;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 说明：更新给定的部门对象
	 * 
	 * @param source 部门对象
	 * @return
	 */
	public boolean updateDepartment(Department source){
		try {
			depDao.updateDepartment(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：检查是否在系统中存在同名部门
	 * 
	 * @param sysid 系统标识
	 * @param depName 部门名称
	 * @return
	 */
	public synchronized boolean chekcDepartmentExist(String sysid,String depName){
		try {
			return depDao.checkDepartment(DBServices.getDBService().getConnection(), sysid, depName);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
}