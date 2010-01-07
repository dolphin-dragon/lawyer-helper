package com.law.service;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Sessions;

import com.law.bean.Login;
/**
 * ˵���������ṩ������
 *
 */
public class Service {
	/**
	 * ˵�������ָ��ϵͳ�ĵ�½id�Ƿ����
	 * 
	 * @param system ϵͳ��ʶ
	 * @param loginid ��½��ʶ
	 * @return
	 */
	public boolean checkExistUser(String system,String loginid){
		LoginService service = new LoginService();
		return service.checkLoginIDExist(system, loginid);
	}
	
	/**
	 * ˵������ȡ��½�û���ֻʹ���ڵ�½������
	 * 
	 * @param system ϵͳ��ʶ
	 * @param loginid ��½��ʶ
	 * @return
	 */
	public Login getLogin(String system,String loginid){
		LoginService service = new LoginService();
		return service.getLogin(system, loginid);
	}

	/**
	 * ˵����������ϵͳ�ĵ�½��ʶ����½�����Ƿ���Ե�½
	 * 
	 * @param system ϵͳ��ʶ
	 * @param loginid ��½��ʶ
	 * @param pw ��½����
	 * @return
	 */
	public boolean ckeckLogin(String system,String loginid,String pw){
		LoginService service = new LoginService();
		return service.checkLogin(system, loginid, pw);
	}

	/**
	 * ˵��������½�������õ���ǰ�ĻỰ��
	 * 
	 * @param source ��½����
	 */
	public static void setCurrentSessionLogin(Login source){
		Sessions.getCurrent().setAttribute("LOGIN",source);
	}
	
	/**
	 * ˵������ȡ��ǰ�Ự�еĵ�½�û�
	 * 
	 * @return
	 */
	public static Login getCurrentSessionLogin(){
		return (Login)Sessions.getCurrent().getAttribute("LOGIN");
	}
	
	/**
	 * ˵������⵱ǰ�Ự�Ƿ��½�ɹ�
	 * 
	 * @return
	 */
	public static boolean checkCurrentSessionLogining(){
		return null == (Login)Sessions.getCurrent().getAttribute("LOGIN") ? false : true;
	}
	
	/**
	 * ˵������ȡϵͳ��֧�ֵ�ϵͳ�б�
	 * String[] ���ص�Ϊ��ά���飬ϵͳ��š�ϵͳ�������
	 */
	public List<String[][]> getSystems(){
		String[][] systems = new String[][]{{"001","����ϵͳ"},{"002","����ϵͳ"}};
		List<String[][]> result = new ArrayList<String[][]>();
		result.add(systems);
		return result;
	}
	
	/**
	 * ˵������ȡָ��ϵͳ��ָ����ɫ�Ĺ����б�
	 * String[]1��g��m��a ���ص�Ϊ��ά���飬�������ơ��������ܵ����·��
	 * 
	 * @param sysid ϵͳ��ʶ
	 * @param Role ��ɫ��ʶ
	 * @return ��ɫ�ɲ����Ĺ����б�
	 */
	public List<String[]> getRoleActions(String sysid,String Role){
		return null;
	}
	
	/**
	 * ˵������ȡϵͳ�Ĺ��������б�ϵͳ�Ĺ��������û��ǿ����Զ����Ƿ���ʾ��������
	 * String[] ���ص�Ϊ��ά���飬�������ơ��������ܵ����·��
	 * 
	 * @return
	 */
	public List<String[]> getPublicActions(){
		return null;
	}
	
	/**
	 * ˵������ȡ�û����õĹ��������б�
	 * 
	 * @param sysid ϵͳ��ʶ
	 * @param userid �û���ʶ
	 * @return �����û����õĹ��������б�
	 */
	public List<String[]> getSysUserPublicActions(String sysid,String userid){
		return null;
	}
	
	public List<String[]> getDefaultActions(String sysid,String userids) {
		return null;
	}
}