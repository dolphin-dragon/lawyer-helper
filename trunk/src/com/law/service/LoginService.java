package com.law.service;

import java.util.List;

import com.law.bean.Login;
import com.law.dao.LoginDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;

/**
 * 说明：登陆对象服务类
 * 
 */
public class LoginService {
	private LoginDao loginDao = new LoginDao();
	
	/**
	 * 说明：获取指定系统的登陆用户列表
	 * 
	 * @param sysID 系统标识
	 * @return 登陆对象列表
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
	 * 说明：给指定的系统添加登陆对象
	 * 
	 * @param systemid 系统标识
	 * @param source 登陆对象
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
	 * 说明：删除给定的登陆对象
	 * 
	 * @param source 登陆对象
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
	 * 说明：删除指定标识的登陆对象
	 * 
	 * @param system 系统标识
	 * @param loginid 登陆标识
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
	 * 说明：删除指定的登陆对象
	 * 
	 * @param source 登陆对象
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
	 * 说明：检查指定的系统的指定登陆标识是否存在
	 * 
	 * @param sysid 系统标识
	 * @param loginid 登陆标识
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
	 * 说明：获取指定登陆标识的登陆对象
	 * 
	 * @param loginid 登陆标识
	 * @return 登陆对象
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
	 * 说明：检测是否进行系统登录，必须给定系统标识、登陆标识、登陆密码
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