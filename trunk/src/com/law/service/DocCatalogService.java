package com.law.service;

import java.util.List;

import com.law.bean.DocCatalog;
import com.law.dao.DocCatalogDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;

/**
 * 说明：文件目录服务类
 * 
 */
public class DocCatalogService {
	private DocCatalogDao dcgDao = new DocCatalogDao();
	
	/**
	 * 说明：获取指定用户的一级目录列表
	 * 
	 * @param userid 用户标识
	 * @return
	 */
	public List<DocCatalog> getUserCataLogs(String userid){
		try {
			return dcgDao.queryUserDocCatalog(DBServices.getDBService().getConnection(), userid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 说明：获取指定目录的下级目录列表
	 * 
	 * @param userid 用户标识
	 * @param catalogid 目录标识
	 * @return
	 */
	public List<DocCatalog> getsubCatalogs(String userid,String catalogid){
		try {
			return dcgDao.querySubCatalog(DBServices.getDBService().getConnection(), catalogid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 说明：给指定用户当前目录下增加子目录对象
	 * 
	 * @param userid 用户标识
	 * @param superCatalogid 当前目录标识
	 * @param catalog 增加的子目录对象
	 * @return 
	 */
	public boolean addDocCatalog(String userid,String superCatalogid,DocCatalog catalog){
		try {
			catalog.setSuperCatalogID(superCatalogid);
			catalog.setCreator(userid);
			dcgDao.saveDocCatalog(DBServices.getDBService().getConnection(), catalog);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：更新指定用户的目录对象
	 * @param userid 用户标识
	 * @param catalog 更新的目录对象
	 * @return 
	 */
	public boolean updateDocCatalog(String userid,DocCatalog catalog){
		try {
			dcgDao.updateDocCatalog(DBServices.getDBService().getConnection(), catalog);
			catalog.setCreator(userid);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：删除指定用户的指定目录
	 * @param userid 用户标识
	 * @param catalog 目录对象
	 * @return 
	 */
	public boolean deleteDocCatalog(String userid,DocCatalog catalog){
		try {
			catalog.setCreator(userid);
			dcgDao.deleteDocCatalog(DBServices.getDBService().getConnection(), catalog);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：删除指定用户的指定目录
	 * @param userid 用户标识
	 * @param catalogID 目录标识
	 * @return 
	 */
	public boolean deleteDocCatalog(String userid,String catalogID){
		try {
			dcgDao.deleteDocCatalog(DBServices.getDBService().getConnection(), userid, catalogID);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：构建指定名称的分组
	 * 
	 * @param userid 用户标识
	 * @param catalogName 分组名称
	 * @return
	 */
	public synchronized DocCatalog createDocCatalog(String userid,String catalogName){
		try {
			//DC_0000000
			String max = dcgDao.getMaxDocCatalogID(DBServices.getDBService().getConnection());
			String newid = "DC_"+Utils.getNextStr(7, Long.valueOf(max.substring(3)));
			DocCatalog source = new DocCatalog(newid,catalogName);
			source.setCreator(userid);
			dcgDao.saveDocCatalog(DBServices.getDBService().getConnection(), source);
			return source;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
}