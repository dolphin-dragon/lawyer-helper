package com.law.service;

import java.util.List;

import com.law.bean.Space;
import com.law.dao.SpaceDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;

/**
 * 说明：存储空间服务类
 *
 */
public class SpaceService {
	private SpaceDao spaceDao = new SpaceDao();
	/**
	 * 说明：获取指定系统下所有成员的存储空间列表
	 * @param systemid 系统标识
	 * @return 存储空间列表
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
	 * 说明：增加存储空间
	 * 
	 * @param source 存储空间对象
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
	 * 说明：更新存储空间对象
	 * 
	 * @param source 存储空间对象
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
	 * 说明：删除指定的存储空间
	 * 
	 * @param source 存储空间对象
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
	 * 说明：删除指定系统的指定存储空间
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