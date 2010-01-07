package com.law.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.law.bean.Attachement;
import com.law.bean.AttachementItem;
import com.law.util.LawyerException;

/**
 * ˵�����Ը������г־ô���
 * 
 */
public class AttachementDao {
	private String ATTACHETABLE="T_ATTACHEMENT ";
	
	/**
	 * ˵������ȡָ�������ʶ�ĸ����б�
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param subjectid �����ʶ
	 * @return �����б�
	 * @throws LawyerException
	 */
	public Attachement queryAttachementBySubject(Connection con,String subjectid) throws LawyerException{
		String sql = "SELECT SUBJECTID,DOCID,DESCRIP,ORD FROM "+ATTACHETABLE+ " WHERE SUBJECTID='"+subjectid+"' ORDER BY ORD";
		Statement statment = null;
		ResultSet result = null;
		try {
			Attachement attachement = new Attachement(subjectid);
			AttachementItem atchItem = null;
			statment = con.createStatement();
			result = statment.executeQuery(sql);
			while (result.next()) {
				atchItem = new AttachementItem(result.getString("SUBJECTID"),result.getString("DOCID"));
				atchItem.setDocDesc(result.getString("DESCRIP"));
				atchItem.setIndex(result.getInt("ORD"));				
				attachement.addItems(atchItem);
			}
			return attachement;
		} catch (SQLException e) {
			throw new LawyerException("Query Attachement is error! "	+ e.getMessage());
		}finally{
			try {
				result.close();
				statment.close();
			} catch (SQLException e) {
				result = null;
				statment = null;
			}
		}
	}
	
	/**
	 * ˵�������¸�����Ŀ
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source ������Ŀ
	 * @throws LawyerException
	 */
	public void updateAttachement(Connection con,AttachementItem source) throws LawyerException{
		String sql = "UPDATE "+ATTACHETABLE+" SET SUBJECTID=?,DOCID=?,DESCRIP=?,ORD=? WHERE SUBJECTID='"+source.getSubjectID()+"' AND DOCID='"+source.getDocID()+"'";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
			psment.clearBatch();

			psment.setString(1,source.getSubjectID());
			psment.setString(2,source.getDocID());
			psment.setString(3,source.getDocDesc());
			psment.setInt(4,source.getIndex().intValue());

			psment.addBatch();
		
	        //ִ�����ݿ���봦��
			psment.execute();			
			
		} catch (SQLException e) {
			throw new LawyerException("UPDATE Attachement Item is error! " + e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
	
	/**
	 * ˵�����洢�����ĸ�����Ŀ
	 * 
	 * @param con ���ݿ����
	 * @param source ������Ŀ����
	 * @throws LawyerException
	 */
	public void saveAttachement(Connection con,AttachementItem source) throws LawyerException{
		String sql = "INSERT INTO "+ATTACHETABLE+"(SUBJECTID,DOCID,DESCRIP,ORD) VALUES (?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
			psment.clearBatch();

			psment.setString(1,source.getSubjectID());
			psment.setString(2,source.getDocID());
			psment.setString(3,source.getDocDesc());
			psment.setInt(4,source.getIndex().intValue());

			psment.addBatch();
		
	        //ִ�����ݿ���봦��
			psment.execute();			
			
		} catch (SQLException e) {
			throw new LawyerException("save Attachement Item is error! " + e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
	
	/**
	 * ˵����ɾ��ָ���������ʶ���ļ���ʶ�ĸ�����Ŀ
	 * 
	 * @param con 
	 * @param subjectid
	 * @param docid
	 * @throws LawyerException
	 */
	public void deleteAttachement(Connection con,String subjectid,String docid) throws LawyerException{
		String sql = "DELETE "+ATTACHETABLE+" FROM "+ATTACHETABLE+" WHERE SUBJECTID='"+subjectid+"' AND DOCID='"+docid+"'";
		Statement statement = null;
		try {
			statement = con.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			throw new LawyerException("Delete Attachement Item is error! "+ e.getMessage());
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}
	
	/**
	 * ˵������ȡ�����ʶ�����������Ŀ����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param subjectid ���������ʶ
	 * @return �����б��е��������
	 * @throws LawyerException
	 */
	public Integer getMaxAttachementItemIndex(Connection con,String subjectid) throws LawyerException{
		String sql = "SELECT MAX(ORD) AS MAXORD FROM "+ATTACHETABLE+ " WHERE SUBJECTID='"+subjectid+"'";
		Statement statment = null;
		ResultSet result = null;
		try {
			statment = con.createStatement();
			result = statment.executeQuery(sql);
			Integer value = 0;
			while (result.next()) {
				value = result.getInt("MAXORD");
				if(null != value)
				return Integer.valueOf(value);
			}
			return Integer.valueOf(0);
		} catch (SQLException e) {
			throw new LawyerException("Get Max index of Subject Attachement Item is error! " + e.getMessage());
		} finally {
			try {
				result.close();
				statment.close();
			} catch (SQLException e) {
				result = null;
				statment = null;
			}
		}
	}
}