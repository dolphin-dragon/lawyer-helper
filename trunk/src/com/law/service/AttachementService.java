package com.law.service;

import com.law.bean.Attachement;
import com.law.bean.AttachementItem;
import com.law.dao.AttachementDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
/**
 * ˵��������������
 * 
 * ������Ҫʹ���ڰ�Դ�������������������渽���У��ڸ�������REPORTID
 * �����Ǳ���ı�ʶ�������ı�ʶ����Դ�ı�ʶ
 */
public class AttachementService {
	//�����־û�������
	private AttachementDao attacheDao = new AttachementDao();
	//�ĵ��־û�������
	private DocService docServer = new DocService();
	/**
	 * ˵�������ݸ����ı�ʶ��ȡ��Ӧ�ĸ����б�
	 * 
	 * @param subjectID �����ǰ�Դ�ı�ʶ�������ı�ʶ������ı�ʶ
	 * @return ������Ӧ�ĸ���
	 */
	public Attachement getReportAttachements(String subjectID){
		try {
			return attacheDao.queryAttachementBySubject(DBServices.getDBService().getConnection(), subjectID);
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ˵����������Ӧ����ĸ���������ı�ʶ�����ǰ�Դ��ʶ��������ʶ�������ʶ
	 * 
	 * @param subjectID �����ʶ
	 * @param attachement ������Ŀ
	 */
	public boolean addReportAttachement(String subjectID,AttachementItem attachement){
		try {
			attacheDao.saveAttachement(DBServices.getDBService().getConnection(), attachement);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ˵����ɾ������ָ������Ŀ
	 * 
	 * @param attachement ��Ҫ���µĸ�������
	 */
	public boolean deleteAttachementItem(String sysid,AttachementItem attachement){
		try {
			attacheDao.deleteAttachement(DBServices.getDBService().getConnection(), attachement.getSubjectID(), attachement.getDocID());
			docServer.deleteDoc(sysid,attachement.getDocID());
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵����ɾ��ָ����ʶ��ָ���ļ��ĸ�������
	 * 
	 * @param subjectid �����ʶ
	 * @param docid �����ļ���ʶ
	 * @return
	 */
	public boolean deleteAttachementItem(String subjectid,String docid,String sysid){
		try {
			attacheDao.deleteAttachement(DBServices.getDBService().getConnection(), subjectid, docid);
			docServer.deleteDoc(sysid,docid);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ˵�����洢�������塢�����ļ���ʶ���ļ������ĸ����ļ�
	 * 
	 * @param subjectid ���������ʶ
	 * @param docid �ļ���ʶ
	 * @param docdesc �����ļ�����
	 * @return
	 */
	public synchronized boolean saveAttacheItem(String subjectid,String docid,String docdesc){
		try {
			AttachementItem item = new AttachementItem(subjectid,docid);
			item.setDocDesc(docdesc);
			Integer index = attacheDao.getMaxAttachementItemIndex(DBServices.getDBService().getConnection(), subjectid);
			item.setIndex(Integer.valueOf(index.intValue()+1));
			attacheDao.saveAttachement(DBServices.getDBService().getConnection(), item);
			return true;
		} catch (LawyerException e) {
			e.printStackTrace();
		}
		return false;
	}
}