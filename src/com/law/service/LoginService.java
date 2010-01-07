package com.law.service;

import java.util.List;

import com.law.bean.Login;
import com.law.dao.LoginDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;

/**
 * ˵������½���������
 * 
 */
public class LoginService {
	private LoginDao loginDao = new LoginDao();
	
	/**
	 * ˵������ȡָ��ϵͳ�ĵ�½�û��б�
	 * 
	 * @param sysID ϵͳ��ʶ
	 * @return ��½�����б�
	 */
	public List<Login> getSysLogins(String sysID){
		try {
			return loginDao.querySysLogins(DBServices.getDBService().getConnection(), sysID);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ˵������ָ����ϵͳ��ӵ�½����
	 * 
	 * @param systemid ϵͳ��ʶ
	 * @param source ��½����
	 */
	public boolean saveLogin(Login source){
		try {
			loginDao.saveLogin(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵����ɾ�������ĵ�½����
	 * 
	 * @param source ��½����
	 * @return
	 */
	public boolean deleteLogin(Login source){
		try {
			loginDao.deleteLogin(DBServices.getDBService().getConnection(), source);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵����ɾ��ָ����ʶ�ĵ�½����
	 * 
	 * @param system ϵͳ��ʶ
	 * @param loginid ��½��ʶ
	 * @return
	 */
	public boolean deleteLogin(String system,String loginid){
		try {
			loginDao.deleteLogin(DBServices.getDBService().getConnection(), loginid);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	/**
	 * ˵����ɾ��ָ���ĵ�½����
	 * 
	 * @param source ��½����
	 * @return
	 */
	public boolean updateLogin(Login source){
		try {
			loginDao.updataLogin(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵�������ָ����ϵͳ��ָ����½��ʶ�Ƿ����
	 * 
	 * @param sysid ϵͳ��ʶ
	 * @param loginid ��½��ʶ
	 * @return
	 */
	public synchronized boolean checkLoginIDExist(String sysid,String loginid){
		try {
			return loginDao.checkLoginID(DBServices.getDBService().getConnection(), loginid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵������ȡָ����½��ʶ�ĵ�½����
	 * 
	 * @param loginid ��½��ʶ
	 * @return ��½����
	 */
	public Login getLogin(String sysid,String loginid){
		try {
			return loginDao.queryLogin(DBServices.getDBService().getConnection(), sysid, loginid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ˵��������Ƿ����ϵͳ��¼���������ϵͳ��ʶ����½��ʶ����½����
	 * @param sysid
	 * @param loginid
	 * @param pw
	 * @return
	 */
	public boolean checkLogin(String sysid,String loginid,String pw){
		try {
			return loginDao.checkLogin(DBServices.getDBService().getConnection(), sysid, loginid, pw);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
}