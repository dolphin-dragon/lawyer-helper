package com.law.service;

import java.util.List;

import com.law.bean.SysUser;
import com.law.dao.SysUserDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;

/**
 * ˵����ϵͳ�û�������
 * 
 */
public class SysUserService {
	private SysUserDao sysUserDao = new SysUserDao();
	/**
	 * ˵������ȡָ��ϵͳ����Ա�б�
	 * 
	 * @param systemid ϵͳ��ʶ
	 * @return ϵͳ��Ա�б�
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
	 * ˵����ɾ��ָ������Ա����
	 * 
	 * @param source ϵͳ��Ա����
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
	 * ˵����������Ա����
	 * 
	 * @param source ϵͳ��Ա����
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
	 * ˵�������ݸ��������ƴ���ϵͳ�ڲ��û�
	 * 
	 * @param userName ϵͳ�ڲ��û�����
	 * @return �����¹�����ϵͳ�ڲ��û�����
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
	 * ˵������ȡָ����ʶ���ڲ��û�����
	 * 
	 * @param userid ϵͳ�ڲ��û���ʶ
	 * @return ϵͳ�ڲ��û�����
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