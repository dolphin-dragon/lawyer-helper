package com.law.service;

import java.util.List;

import com.law.bean.LinkMan;
import com.law.dao.LinkManDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;

/**
 * ˵������ϵ������
 * 
 */
public class LinkManService {
	private LinkManDao linkManDao = new LinkManDao();
	/**
	 * ˵������ȡָ���û�����ϵ���б�
	 * @param userid
	 * @return
	 */
	public List<LinkMan> getUserLinkMan(String sysid,String userid){
		try {
			return linkManDao.queryUserLinkMans(DBServices.getDBService().getConnection(), userid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ˵������ȡָ����ʶ����ϵ�˶���
	 * @param linkManID ��ϵ�˱�ʶ
	 * @return ��ϵ�˶���
	 */
	public LinkMan getLinkMan(String sysid,String linkManID){
		try {
			return linkManDao.queryLinkMan(DBServices.getDBService().getConnection(), linkManID);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ˵������ָ���û������ϵ��
	 * 
	 * @param userid �û���ʶ
	 * @param source ��ϵ�˶���
	 */
	public boolean addLinkMan(LinkMan source){
		try {
			linkManDao.saveLinkMan(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵����������ϵ��
	 * 
	 * @param source ��ϵ�˶���
	 */
	public boolean updateLinkMan(LinkMan source){
		try {
			linkManDao.updateLinkMan(DBServices.getDBService().getConnection(),source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ˵����ɾ��ָ���û����ض���ϵ��
	 * 
	 * @param userid �û���ʶ
	 * @param source ��ϵ�˶���
	 */
	public boolean deleteLinkMan(String userid,LinkMan source){
		//ʵ�ֱ���Ч�����ϵ���Ƿ���userid����
		try {
			linkManDao.deleteLinkMan(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵����ɾ��ָ����ϵ�˶���
	 * 
	 * @param source ��ϵ�˶���
	 * @return
	 */
	public boolean deleteLinkMan(LinkMan source){
		//ֱ��ɾ��
		try {
			linkManDao.deleteLinkMan(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ˵����ɾ��ָ��ϵͳ��ָ���û���ָ����ϵ��
	 * 
	 * @param userid �û���ʶ
	 * @param linkManID ��ϵ�˱�ʶ
	 * @param sysid ϵͳ��ʶ
	 * @return
	 */
	public boolean deleteLinkMan(String userid,String linkManID,String sysid){
		//ʵ�ֱ���Ч�����ϵ���Ƿ���userid����
		try {
			linkManDao.deleteLinkMan(DBServices.getDBService().getConnection(), linkManID);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteLinkMan(String linkManID,String sysid){
		//ֱ��ɾ��
		try {
			linkManDao.deleteLinkMan(DBServices.getDBService().getConnection(), linkManID);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵�������ݸ�������Ϣ������ϵ�˶���
	 * 
	 * @param name ��ϵ������
	 * @param sysid ϵͳ��ʶ
	 * @return
	 */
	public synchronized LinkMan createLinkMan(String name,String sysid){
		try {
			//L_00000000
			String maxid = linkManDao.getMaxContacteID(DBServices.getDBService().getConnection());
			String newid = "L_"+Utils.getNextStr(8, Long.valueOf(maxid.substring(2)));
			LinkMan source = new LinkMan(sysid, newid, name);
			linkManDao.saveLinkMan(DBServices.getDBService().getConnection(), source);
			return source;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
}