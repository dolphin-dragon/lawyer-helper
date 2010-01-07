package com.law.service;

import java.util.List;

import com.law.bean.Role;
import com.law.dao.RoleDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;

/**
 * ˵������ɫ������
 *
 */
public class RoleService {
	private RoleDao roleDao = new RoleDao();
	/**
	 * ˵������ȡָ��ϵͳ��ʶ�Ľ�ɫ�б�
	 * 
	 * @param systemid ϵͳ��ʶ
	 * @return ��ɫ�б����
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
	 * ˵������ȡָ����ʶ�Ľ�ɫ����
	 * 
	 * @param roleid ��ɫ��ʶ
	 * @return ��ɫ����
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
	 * ˵������ָ����ϵͳ���ӽ�ɫ����
	 * 
	 * @param systemid ϵͳ��ʶ
	 * @param source ��ɫ����
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
	 * ˵����ɾ��ָ��ϵͳ��ָ����ɫ����
	 * 
	 * @param systemid ϵͳ��ʶ
	 * @param source ��ɫ����
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
	 * ˵�������¸����Ľ�ɫ����
	 * 
	 * @param systemid ϵͳ��ʶ
	 * @param source ��ɫ����
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
	 * ˵�������ϵͳ���Ƿ���ڸ������ƵĽ�ɫ
	 * 
	 * @param system ϵͳ��ʶ
	 * @param roleName ��ɫ����
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
	 * ˵�������ݸ�������Ϣ������ɫ����
	 * 
	 * @param sysid ϵͳ��ʶ
	 * @param roleName ��ɫ����
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