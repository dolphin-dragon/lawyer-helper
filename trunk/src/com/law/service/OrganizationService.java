package com.law.service;

import java.util.List;

import com.law.bean.Organization;
import com.law.dao.OrganizationDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;

/**
 * ˵������ϵ��λ������
 * 
 */
public class OrganizationService {
	private OrganizationDao orgDao = new OrganizationDao();
	/**
	 * ˵������ȡָ���û�����ϵ��λ�б�
	 * 
	 * @param userid �û���ʶ
	 * @return
	 */
	public List<Organization> getUserOrganizations(String sysid,String userid){
		try {
			return orgDao.queryUserOrganizations(DBServices.getDBService().getConnection(),sysid, userid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ˵������ȡָ����ʶ����ϵ��λ����
	 * 
	 * @param linkManID ��ϵ��λ��ʶ
	 * @return ��ϵ��λ����
	 */
	public Organization getOrganization(String sysid,String organizationID){
		try {
			return orgDao.queryOrganization(DBServices.getDBService().getConnection(), sysid,organizationID);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ˵������ָ���û������ϵ��λ
	 * 
	 * @param userid �û���ʶ
	 * @param source ��ϵ��λ����
	 */
	public boolean addOrganization(Organization source){
		try {
			orgDao.saveOrganization(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵����������ϵ��λ
	 * 
	 * @param source ��ϵ��λ����
	 */
	public boolean updateOrganization(Organization source){
		try {
			orgDao.updateOrganization(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ˵����ɾ��ָ���û����ض���ϵ��λ
	 * 
	 * @param userid �û���ʶ
	 * @param source ��ϵ��λ����
	 */
	public boolean deleteOrganization(String userid,Organization source){
		//ʵ�ֱ���Ч�����ϵ���Ƿ���userid����
		try {
			orgDao.deleteOrganization(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵����ɾ����������ϵ��λ
	 * 
	 * @param source ��ϵ��λ����
	 * @return
	 */
	public boolean deleteOrganization(Organization source){
		//ֱ��ɾ��
		try {
			orgDao.deleteOrganization(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵����ɾ��ָ���û�ָ����ϵ��λ
	 * @param userid �û���ʶ
	 * @param organizationID ��ϵ��λ��ʶ
	 */
	public boolean deleteOrganization(String userid,String organizationID,String sysid){
		//ʵ�ֱ���Ч�����ϵ���Ƿ���userid����
		try {
			orgDao.deleteOrganization(DBServices.getDBService().getConnection(), organizationID);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵����ɾ��ָ����ʶ����ϵ��λ
	 * @param organizationID
	 * @param sysid
	 * @return
	 */
	public boolean deleteOrganization(String organizationID,String sysid){
		//ֱ��ɾ��
		try {
			orgDao.deleteOrganization(DBServices.getDBService().getConnection(), organizationID);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵�������ݸ�������Ϣ������ϵ��λ����
	 * 
	 * @param organizationName ��ϵ��λ����
	 * @param sysid ϵͳ��ʶ
	 * @return
	 */
	public synchronized Organization createOrganization(String organizationName,String sysid){
		try {
			//LP_0000000
			String maxid = orgDao.getMaxContacteID(DBServices.getDBService().getConnection());
			String newid = "LP_"+Utils.getNextStr(7, Long.valueOf(maxid.substring(3)));
			Organization source = new Organization(sysid,newid,organizationName);
			orgDao.saveOrganization(DBServices.getDBService().getConnection(), source);
			return source;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
}
