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
 * 说明：对附件进行持久处理
 * 
 */
public class AttachementDao {
	private String ATTACHETABLE="T_ATTACHEMENT ";
	
	/**
	 * 说明：获取指定对象标识的附件列表
	 * 
	 * @param con 数据库连接对象
	 * @param subjectid 主体标识
	 * @return 附件列表
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
	 * 说明：更新附件条目
	 * 
	 * @param con 数据库连接对象
	 * @param source 附件条目
	 * @throws LawyerException
	 */
	public void updateAttachement(Connection con,AttachementItem source) throws LawyerException{
		String sql = "UPDATE "+ATTACHETABLE+" SET SUBJECTID=?,DOCID=?,DESCRIP=?,ORD=? WHERE SUBJECTID='"+source.getSubjectID()+"' AND DOCID='"+source.getDocID()+"'";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
			psment.clearBatch();

			psment.setString(1,source.getSubjectID());
			psment.setString(2,source.getDocID());
			psment.setString(3,source.getDocDesc());
			psment.setInt(4,source.getIndex().intValue());

			psment.addBatch();
		
	        //执行数据库插入处理
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
	 * 说明：存储给定的附件条目
	 * 
	 * @param con 数据库对象
	 * @param source 附件条目对象
	 * @throws LawyerException
	 */
	public void saveAttachement(Connection con,AttachementItem source) throws LawyerException{
		String sql = "INSERT INTO "+ATTACHETABLE+"(SUBJECTID,DOCID,DESCRIP,ORD) VALUES (?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
			psment.clearBatch();

			psment.setString(1,source.getSubjectID());
			psment.setString(2,source.getDocID());
			psment.setString(3,source.getDocDesc());
			psment.setInt(4,source.getIndex().intValue());

			psment.addBatch();
		
	        //执行数据库插入处理
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
	 * 说明：删除指定的主体标识及文件标识的附件条目
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
	 * 说明：获取主体标识附件的最大条目索引
	 * 
	 * @param con 数据库连接对象
	 * @param subjectid 附件主体标识
	 * @return 附件列表中的最大索引
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