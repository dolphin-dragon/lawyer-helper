package com.law.service;

import com.law.bean.Attachement;
import com.law.bean.AttachementItem;
import com.law.dao.AttachementDao;
import com.law.util.DBServices;
import com.law.util.LawyerException;
/**
 * 说明：附件服务类
 * 
 * 附件主要使用在案源附件、案件附件、报告附件中，在附件表中REPORTID
 * 可以是报告的标识、案件的标识、案源的标识
 */
public class AttachementService {
	//附件持久化处理类
	private AttachementDao attacheDao = new AttachementDao();
	//文档持久化处理类
	private DocService docServer = new DocService();
	/**
	 * 说明：根据给定的标识获取对应的附件列表
	 * 
	 * @param subjectID 可以是案源的标识、案件的标识、报告的标识
	 * @return 返回相应的附件
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
	 * 说明：增加相应主题的附件，主题的标识可以是案源标识、案件标识、报告标识
	 * 
	 * @param subjectID 主题标识
	 * @param attachement 附件条目
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
	 * 说明：删除附件指定的条目
	 * 
	 * @param attachement 需要更新的附件对象
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
	 * 说明：删除指定标识、指定文件的附件内容
	 * 
	 * @param subjectid 主体标识
	 * @param docid 附件文件标识
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
	 * 说明：存储给定主体、给定文件标识、文件描述的附件文件
	 * 
	 * @param subjectid 附件主体标识
	 * @param docid 文件标识
	 * @param docdesc 附件文件描述
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