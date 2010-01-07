package com.law.service;

import java.io.InputStream;

import com.law.bean.Doc;
import com.law.dao.DocDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;
/**
 * 说明：文档服务类
 * 
 */
public class DocService {
	private DocDao docDao = new DocDao();
	
	/**
	 * 说明：获取给定标识的文档
	 * 
	 * @param docid 文档标识
	 * @return 文档对象
	 */
	public Doc getDoc(String sysid,String docid){
		try {
			return docDao.queryDoc(DBServices.getDBService().getConnection(), sysid, docid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	/**
	 * 说明：获取系统中指定文件的内容
	 * 
	 * @param sysid 系统标识
	 * @param docid 文档标识
	 * @return
	 */
	public InputStream getDocContent(String sysid,String docid){
		try {
			return docDao.queryFileContent(DBServices.getDBService().getConnection(), sysid, docid);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 说明：存储一个文档对象
	 * 
	 * @param doc 文档对象
	 * @return 
	 */
	public boolean addDoc(Doc doc){
		try {
			docDao.saveDoc(DBServices.getDBService().getConnection(), doc);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 说明：更新一个文档对象
	 * 
	 * @param Doc 文档对象
	 * @return 
	 */
	public boolean updataDoc(Doc doc){
		try {
			docDao.updateDoc(DBServices.getDBService().getConnection(), doc);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：删除系统中指定标识的文件
	 * 
	 * @param sysid 系统标识
	 * @param docid 文档标识
	 * @return
	 */
	public boolean deleteDoc(String sysid,String docid){
		try {
			docDao.delete(DBServices.getDBService().getConnection(), sysid, docid);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 说明：根据给定的信息生成文档对象，进行数据库存储
	 * 
	 * @param sysid 系统标识
	 * @param docName 文档名称
	 * @return
	 */
	public synchronized Doc createDoc(String sysid,String docName){
		try {
			//F_00000000
			String maxdoc = docDao.getMaxDocID(DBServices.getDBService().getConnection());
			String newdocid = "F_"+Utils.getNextStr(8, Long.valueOf(maxdoc.substring(2)));
			Doc source = new Doc(sysid,newdocid,docName);
			docDao.saveDoc(DBServices.getDBService().getConnection(), source);
			return source;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
}