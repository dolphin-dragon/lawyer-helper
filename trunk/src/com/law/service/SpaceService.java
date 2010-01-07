package com.law.service;

import java.util.List;

import com.law.bean.Space;
import com.law.dao.SpaceDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;

/**
 * ˵�����洢�ռ������
 *
 */
public class SpaceService {
	private SpaceDao spaceDao = new SpaceDao();
	/**
	 * ˵������ȡָ��ϵͳ�����г�Ա�Ĵ洢�ռ��б�
	 * @param systemid ϵͳ��ʶ
	 * @return �洢�ռ��б�
	 */
	public List<Space> getMembersSpace(String systemid){
		try {
			return spaceDao.querySpaces(DBServices.getDBService().getConnection(), systemid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ˵�������Ӵ洢�ռ�
	 * 
	 * @param source �洢�ռ����
	 * @return 
	 */
	public boolean addSpace(Space source){
		try {
			spaceDao.saveSpace(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵�������´洢�ռ����
	 * 
	 * @param source �洢�ռ����
	 * @return 
	 */
	public boolean updateSpace(Space source){
		try {
			spaceDao.updataSpace(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵����ɾ��ָ���Ĵ洢�ռ�
	 * 
	 * @param source �洢�ռ����
	 * @return 
	 */
	public boolean deleteSpace(Space source){
		try {
			spaceDao.deleteSpace(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵����ɾ��ָ��ϵͳ��ָ���洢�ռ�
	 * 
	 * @param sysid
	 * @param spaceid
	 * @return 
	 */
	public boolean deleteSpace(String sysid,String spaceid){
		try {
			spaceDao.deleteSpace(DBServices.getDBService().getConnection(), spaceid);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
}