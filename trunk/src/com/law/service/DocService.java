package com.law.service;

import java.io.InputStream;

import com.law.bean.Doc;
import com.law.dao.DocDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
import com.law.util.Utils;
/**
 * ˵�����ĵ�������
 * 
 */
public class DocService {
	private DocDao docDao = new DocDao();
	
	/**
	 * ˵������ȡ������ʶ���ĵ�
	 * 
	 * @param docid �ĵ���ʶ
	 * @return �ĵ�����
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
	 * ˵������ȡϵͳ��ָ���ļ�������
	 * 
	 * @param sysid ϵͳ��ʶ
	 * @param docid �ĵ���ʶ
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
	 * ˵�����洢һ���ĵ�����
	 * 
	 * @param doc �ĵ�����
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
	 * ˵��������һ���ĵ�����
	 * 
	 * @param Doc �ĵ�����
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
	 * ˵����ɾ��ϵͳ��ָ����ʶ���ļ�
	 * 
	 * @param sysid ϵͳ��ʶ
	 * @param docid �ĵ���ʶ
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
	 * ˵�������ݸ�������Ϣ�����ĵ����󣬽������ݿ�洢
	 * 
	 * @param sysid ϵͳ��ʶ
	 * @param docName �ĵ�����
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