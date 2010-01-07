package com.law.service;

import java.util.List;

import com.law.bean.SysUser;
import com.law.bean.Unit;
import com.law.dao.UnitDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;

/**
 * ˵������֯�ڵ������
 *
 */
public class UnitService {
	private UnitDao unitDao = new UnitDao();
	/**
	 * ˵������ȡָ��ϵͳ����֯�ڵ��б�
	 * 
	 * @param systemid
	 * @return
	 */
	public List<Unit> getSysUnits(String systemid){
		try {
			return unitDao.querySysUnits(DBServices.getDBService().getConnection(), systemid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ˵���������֯�ڵ㵽ϵͳ��
	 * 
	 * @param source ��֯����
	 */
	public boolean addUnit(Unit source){
		try {
			unitDao.saveUnit(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵���������֯�ڵ㵽ϵͳ��
	 * 
	 * @param source ��֯����
	 */
	public boolean addUnits(List<Unit> source){
		try {
			unitDao.saveUnits(DBServices.getDBService().getConnection(), source);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵����ɾ����֯�ڵ�
	 * 
	 * @param source ��֯����
	 * @return 
	 */
	public boolean deleteUnit(Unit source){
		try {
			unitDao.deleteUnit(DBServices.getDBService().getConnection(),source.getSysid(), source.getDepid(), source.getUserid());
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵�����Ƴ�ָ����֯�µ�ָ����Ա
	 * 
	 * @param unit ��֯�ڵ�
	 * @param user ϵͳ��Ա
	 * @return 
	 */
	public boolean removeSysUserFromUnit(Unit unit,SysUser user){
		try {
			unitDao.deleteUnit(DBServices.getDBService().getConnection(),unit.getSysid(),unit.getDepid(), user.get_ID());
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵����ɾ��ָ��ϵͳָ�������µ��û�
	 * 
	 * @param sysid ϵͳ��ʶ
	 * @param depid ���ű�ʶ
	 * @param userid �û���ʶ
	 * @return
	 */
	public boolean removeSysUserFromUnit(String sysid,String depid,String userid){
		try {
			unitDao.deleteUnit(DBServices.getDBService().getConnection(),sysid,depid, userid);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ˵������ȡָ�������µ���֯�ڵ��б�(����֯�µ���Ա�б�)
	 * 
	 * @param depid ���ű�ʶ
	 * @return ��֯�ڵ��б�
	 */
	public List<Unit> getDepUser(String sysid,String depid){
		try {
			return unitDao.queryUnit(DBServices.getDBService().getConnection(),sysid,depid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
}