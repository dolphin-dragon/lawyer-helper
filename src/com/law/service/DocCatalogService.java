package com.law.service;

import java.util.List;

import com.law.bean.DocCatalog;
import com.law.dao.DocCatalogDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;

/**
 * ˵�����ļ�Ŀ¼������
 * 
 */
public class DocCatalogService {
	private DocCatalogDao dcgDao = new DocCatalogDao();
	
	/**
	 * ˵������ȡָ���û���һ��Ŀ¼�б�
	 * 
	 * @param userid �û���ʶ
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
	 * ˵������ȡָ��Ŀ¼���¼�Ŀ¼�б�
	 * 
	 * @param userid �û���ʶ
	 * @param catalogid Ŀ¼��ʶ
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
	 * ˵������ָ���û���ǰĿ¼��������Ŀ¼����
	 * 
	 * @param userid �û���ʶ
	 * @param superCatalogid ��ǰĿ¼��ʶ
	 * @param catalog ���ӵ���Ŀ¼����
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
	 * ˵��������ָ���û���Ŀ¼����
	 * @param userid �û���ʶ
	 * @param catalog ���µ�Ŀ¼����
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
	 * ˵����ɾ��ָ���û���ָ��Ŀ¼
	 * @param userid �û���ʶ
	 * @param catalog Ŀ¼����
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
	 * ˵����ɾ��ָ���û���ָ��Ŀ¼
	 * @param userid �û���ʶ
	 * @param catalogID Ŀ¼��ʶ
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
	 * ˵��������ָ�����Ƶķ���
	 * 
	 * @param userid �û���ʶ
	 * @param catalogName ��������
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