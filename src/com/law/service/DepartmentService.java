package com.law.service;

import java.util.List;

import com.law.bean.Department;
import com.law.dao.DeparmentDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;
/**
 * ˵����ϵͳ��֯�в��ŵķ�����
 * 
 */
public class DepartmentService {
	private DeparmentDao depDao = new DeparmentDao();
	/**
	 * ˵������ȡ��Ӧϵͳ�в����б�
	 * 
	 * @param sysid ϵͳ��ʶ
	 * @return ���ز����б�
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
	 * ˵������ȡָ��ϵͳ��ָ�����ű�ʶ�Ĳ��Ŷ���
	 * 
	 * @param sysid ϵͳ��ʶ
	 * @param depid ���ű�ʶ
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
	 * ˵������ָ����ϵͳ�����Ӧ�Ĳ���
	 * 
	 * @param sysid ϵͳ��ʶ
	 * @param dep ���Ŷ���
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
	 * ˵����ɾ��ָ����ϵͳ�еĲ���
	 * 
	 * @param sysid ϵͳ��ʶ
	 * @param dep ���Ŷ���
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
	 * ˵����ɾ��ָ��ϵͳ��ָ�����ű�ʶ�Ĳ���
	 * 
	 * @param sysid ϵͳ��ʶ
	 * @param depid ���ű�ʶ
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
	 * ˵�������ݸ��������ơ�ϵͳ��ʶ�������Ŷ��󣬲������ݿ��д洢
	 * 
	 * @param sysid ϵͳ��ʶ
	 * @param depname ��������
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
	 * ˵�������¸����Ĳ��Ŷ���
	 * 
	 * @param source ���Ŷ���
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
	 * ˵��������Ƿ���ϵͳ�д���ͬ������
	 * 
	 * @param sysid ϵͳ��ʶ
	 * @param depName ��������
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