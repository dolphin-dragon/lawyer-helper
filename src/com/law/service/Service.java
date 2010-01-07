package com.law.service;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Sessions;

import com.law.bean.Login;
/**
 * 说明：服务提供工具类
 *
 */
public class Service {
	/**
	 * 说明：检测指定系统的登陆id是否存在
	 * 
	 * @param system 系统标识
	 * @param loginid 登陆标识
	 * @return
	 */
	public boolean checkExistUser(String system,String loginid){
		LoginService service = new LoginService();
		return service.checkLoginIDExist(system, loginid);
	}
	
	/**
	 * 说明：获取登陆用户，只使用在登陆过程中
	 * 
	 * @param system 系统标识
	 * @param loginid 登陆标识
	 * @return
	 */
	public Login getLogin(String system,String loginid){
		LoginService service = new LoginService();
		return service.getLogin(system, loginid);
	}

	/**
	 * 说明：检测给定系统的登陆标识、登陆密码是否可以登陆
	 * 
	 * @param system 系统标识
	 * @param loginid 登陆标识
	 * @param pw 登陆密码
	 * @return
	 */
	public boolean ckeckLogin(String system,String loginid,String pw){
		LoginService service = new LoginService();
		return service.checkLogin(system, loginid, pw);
	}

	/**
	 * 说明：将登陆对象设置到当前的会话中
	 * 
	 * @param source 登陆对象
	 */
	public static void setCurrentSessionLogin(Login source){
		Sessions.getCurrent().setAttribute("LOGIN",source);
	}
	
	/**
	 * 说明：获取当前会话中的登陆用户
	 * 
	 * @return
	 */
	public static Login getCurrentSessionLogin(){
		return (Login)Sessions.getCurrent().getAttribute("LOGIN");
	}
	
	/**
	 * 说明：检测当前会话是否登陆成功
	 * 
	 * @return
	 */
	public static boolean checkCurrentSessionLogining(){
		return null == (Login)Sessions.getCurrent().getAttribute("LOGIN") ? false : true;
	}
	
	/**
	 * 说明：获取系统中支持的系统列表
	 * String[] 返回的为二维数组，系统编号、系统名称组合
	 */
	public List<String[][]> getSystems(){
		String[][] systems = new String[][]{{"001","测试系统"},{"002","样例系统"}};
		List<String[][]> result = new ArrayList<String[][]>();
		result.add(systems);
		return result;
	}
	
	/**
	 * 说明：获取指定系统的指定角色的功能列表
	 * String[]1、g、m、a 返回的为二维数组，功能名称、操作功能的相对路径
	 * 
	 * @param sysid 系统标识
	 * @param Role 角色标识
	 * @return 角色可操作的功能列表
	 */
	public List<String[]> getRoleActions(String sysid,String Role){
		return null;
	}
	
	/**
	 * 说明：获取系统的公共功能列表，系统的公共功能用户是可以自定制是否显示在桌面中
	 * String[] 返回的为二维数组，功能名称、操作功能的相对路径
	 * 
	 * @return
	 */
	public List<String[]> getPublicActions(){
		return null;
	}
	
	/**
	 * 说明：获取用户配置的公共功能列表
	 * 
	 * @param sysid 系统标识
	 * @param userid 用户标识
	 * @return 返回用户配置的公共功能列表
	 */
	public List<String[]> getSysUserPublicActions(String sysid,String userid){
		return null;
	}
	
	public List<String[]> getDefaultActions(String sysid,String userids) {
		return null;
	}
}