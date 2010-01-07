package com.law.service;

import java.util.List;

import com.law.bean.ContacterGroup;
import com.law.dao.ContacterGroupDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;
/**
 * ˵������ϵ���������
 * 
 */
public class ContacterGroupService {
	private ContacterGroupDao cgDao = new ContacterGroupDao();
	/**
	 * ˵������ȡָ���û���ʶ������������ϵ�����б�
	 * 
	 * @param userid �û���ʶ 
	 * @return ��ϵ���б�
	 */
	public List<ContacterGroup> getContacterGroup(String system,String userid){
		try {
			return cgDao.queryContacterGroupByUser(DBServices.getDBService().getConnection(), system, userid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ˵������ָ�����û�����һ����ϵ����
	 * 
	 * @param userid �û���ʶ
	 * @param group ��ϵ�������
	 * @return 
	 */
	public boolean addContacterGroup(String userid,ContacterGroup group){
		try {
			group.setCreatorid(userid);
			cgDao.saveContacterGroup(DBServices.getDBService().getConnection(), group);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵��������ָ���û�����ϵ��
	 * 
	 * @param userid �û���ʶ
	 * @param group ��ϵ�����
	 * @return 
	 */
	public boolean updateContacterGroup(String userid,ContacterGroup group){
		try {
			group.setCreatorid(userid);
			cgDao.updateContacterGroup(DBServices.getDBService().getConnection(), group);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵����ɾ�������ķ������
	 * 
	 * @param source �������
	 * @return
	 */
	public boolean deleteContacterGroup(ContacterGroup source){
		try {
			cgDao.deleteContacterGroup(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵����ɾ��ϵͳ��ָ���û���ָ�������ʶ�ķ������
	 * 
	 * @param system ϵͳ��ʶ
	 * @param user �û���ʶ
	 * @param groupid �����ʶ
	 * @return
	 */
	public boolean deleteContacterGroup(String system,String user,String groupid){
		try {
			cgDao.deleteContacterGroup(DBServices.getDBService().getConnection(), system,user,groupid);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵�����жϵ�ǰ�û���������ϵ�˷��������Ƿ��Ѿ�����
	 * 
	 * @param system ϵͳ��ʶ
	 * @param user �����߱�ʶ
	 * @param cgname ��������
	 * @return
	 */
	public synchronized boolean checkGnameExist(String system,String user,String cgname){
		try {
			return cgDao.checkNameExist(DBServices.getDBService().getConnection(), system, user, cgname);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * ˵�������ݸ�������Ϣ�����û���ϵ�������
	 * 
	 * @param system ϵͳ��ʶ
	 * @param user �����߱�ʶ
	 * @param gname ��������
	 * @return
	 */
	public synchronized ContacterGroup createContacterGroup(String system,String user,String gname){
		try {
			//CG_0000000
			String maxid = cgDao.getMaxContacterGroupID(DBServices.getDBService().getConnection());
			String newid = "CG_" + Utils.getNextStr(7, Long.valueOf(maxid.substring(3)));
			ContacterGroup group = new ContacterGroup(system,user,newid);
			group.setName(gname);
			cgDao.saveContacterGroup(DBServices.getDBService().getConnection(), group);
			return group;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
}