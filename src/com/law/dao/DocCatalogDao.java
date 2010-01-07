package com.law.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.law.bean.DocCatalog;
import com.law.util.LawyerException;

/**
 * ˵�����ĵ�Ŀ¼�־û�����
 *
 */
public class DocCatalogDao {
	private String DOCCATALOGTABLE="T_DOC_CATALOG";
	/**
	 * ˵������ȡָ���û��ĵ��ĵ�Ŀ¼�б�
	 * @param con ���ݿ����Ӷ���
	 * @param userid �û���ʶ
	 * @return �û�һ���ĵ�Ŀ¼�б�
	 * @throws LawyerException
	 */
	public List<DocCatalog> queryUserDocCatalog(Connection con,String userid) throws LawyerException{
		String sql = "SELECT CATALOGID,SUPERCATALOG,CREATOR,CDATE,USESIZE,TYPE,SPACEID,NAME FROM "+DOCCATALOGTABLE+" WHERE CREATOR='"+userid+"' AND SUPERCATALOG='"+userid+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			List<DocCatalog> resultSet = new ArrayList<DocCatalog>();
			DocCatalog docCatalog = null;
			while(result.next()){
				docCatalog = new DocCatalog(result.getString("SUPERCATALOG"),result.getString("CATALOGID"),result.getString("NAME"),result.getString("SPACEID"));
				docCatalog.setCdate(result.getDate("CDATE"));
				docCatalog.setCreator(result.getString("CREATOR"));
				docCatalog.setEdate(result.getDate("CDATE"));
				docCatalog.setType(result.getString("TYPE"));
				docCatalog.setUsesize(result.getInt("USESIZE"));
				resultSet.add(docCatalog);
			}
			return resultSet;
		} catch (SQLException e) {
			throw new LawyerException("Query Doc Catalog is error! "	+ e.getMessage());
		}finally{
			try {
				result.close();
				statement.close();
			} catch (SQLException e) {
			}
			result = null;
			statement = null;
		}
	}
	
	/**
	 * ˵������ȡָ��Ŀ¼�µ���Ŀ¼�б�
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param superCatalog ������Ŀ¼��ʶ
	 * @return ����Ŀ¼����Ŀ¼�б�
	 * @throws LawyerException
	 */
	public List<DocCatalog> querySubCatalog(Connection con,String superCatalog) throws LawyerException{
		String sql = "SELECT CATALOGID,SUPERCATALOG,CREATOR,CDATE,USESIZE,TYPE,SPACEID,NAME FROM "+DOCCATALOGTABLE+" WHERE SUPERCATALOG='"+superCatalog+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			List<DocCatalog> resultSet = new ArrayList<DocCatalog>();
			DocCatalog docCatalog = null;
			while(result.next()){
				docCatalog = new DocCatalog(result.getString("SUPERCATALOG"),result.getString("CATALOGID"),result.getString("NAME"),result.getString("SPACEID"));
				docCatalog.setCdate(result.getDate("CDATE"));
				docCatalog.setCreator(result.getString("CREATOR"));
				docCatalog.setEdate(result.getDate("CDATE"));
				docCatalog.setType(result.getString("TYPE"));
				docCatalog.setUsesize(result.getInt("USESIZE"));
				resultSet.add(docCatalog);
			}
			return resultSet;
		} catch (SQLException e) {
			throw new LawyerException("Query Doc Catalog is error! "	+ e.getMessage());
		}finally{
			try {
				result.close();
				statement.close();
			} catch (SQLException e) {
			}
			result = null;
			statement = null;
		}
	}

	/**
	 * ˵�����洢�������ĵ�Ŀ¼����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source �ĵ�Ŀ¼����
	 * @throws LawyerException
	 */
	public void saveDocCatalog(Connection con,DocCatalog source) throws LawyerException{
		String sql = "INSERT INTO "+DOCCATALOGTABLE+"(CATALOGID,SUPERCATALOG,CREATOR,CDATE,USESIZE,TYPE,SPACEID,NAME) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
			psment.clearBatch();

			psment.setString(1,source.getId());
			psment.setString(2,source.getSuperCatalogID());
			psment.setString(3,source.getCreator());
			psment.setDate(4,null == source.getCdate() ? new java.sql.Date(new Date().getTime()) : new java.sql.Date(source.getCdate().getTime()));
			psment.setInt(5, source.getUsesize());
			psment.setString(6, source.getType());
			psment.setString(7,source.getSpaceid());
			psment.setString(9, source.getName());
			
			psment.addBatch();
	        //ִ�����ݿ���봦��
			psment.execute();			
		} catch (SQLException e) {
			throw new LawyerException("Save Doc Catalog is error! "	+ e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
	
	/**
	 * ˵����ɾ���������ĵ�Ŀ¼
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source �ĵ�Ŀ¼����
	 * @throws LawyerException
	 */
	public void deleteDocCatalog(Connection con,DocCatalog source) throws LawyerException{
		String sql = "SELECT * FROM "+DOCCATALOGTABLE+" WHERE SUPERCATALOG='"+source.getId()+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				throw new LawyerException("The Doc Catalog has sub catalog!");
			}
			sql = "DElETE "+DOCCATALOGTABLE+" FROM "+DOCCATALOGTABLE+" WHERE CATALOGID='"+source.getId()+"'";
			statement.execute(sql);
		} catch (SQLException e) {
			throw new LawyerException("Delete Doc Catalog is error! "	+ e.getMessage());
		}finally{
			try {
				result.close();
				statement.close();
			} catch (SQLException e) {
			}
			result = null;
			statement = null;
		}
	}
	
	/**
	 * ˵����ɾ��ָ���û���ָ���ĵ�Ŀ¼����
	 * 
	 * @param con ���ݿ����
	 * @param userid �û���ʶ
	 * @param catalogid �����ʶ
	 * @throws LawyerException
	 */
	public void deleteDocCatalog(Connection con,String userid,String catalogid) throws LawyerException{
		String sql = "SELECT * FROM "+DOCCATALOGTABLE+" WHERE SUPERCATALOG='"+catalogid+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				throw new LawyerException("The Doc Catalog has sub catalog!");
			}
			sql = "DElETE "+DOCCATALOGTABLE+" FROM "+DOCCATALOGTABLE+" WHERE CATALOGID='"+catalogid+"' AND CREATOR='"+userid+"'";
			statement.execute(sql);
		} catch (SQLException e) {
			throw new LawyerException("Delete Doc Catalog is error! "	+ e.getMessage());
		}finally{
			try {
				result.close();
				statement.close();
			} catch (SQLException e) {
			}
			result = null;
			statement = null;
		}
	}
	
	/**
	 * ˵�������¸������ĵ�Ŀ¼����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source �ĵ�Ŀ¼����
	 * @throws LawyerException
	 */
	public void updateDocCatalog(Connection con ,DocCatalog source) throws LawyerException{
		String sql = "UPDATE "+DOCCATALOGTABLE+" SET SUPERCATALOG=?,CREATOR=?,CDATE=?,USESIZE=?,TYPE=?,SPACEID=?,NAME=? WHERE CATALOGID=? ";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
			psment.clearBatch();

			psment.setString(1,source.getSuperCatalogID());
			psment.setString(2,source.getCreator());
			psment.setDate(3, null == source.getCdate() ? new java.sql.Date(new Date().getTime()) : new java.sql.Date(source.getCdate().getTime()));
			psment.setInt(4, source.getUsesize());
			psment.setString(5, source.getType());
			psment.setString(6,source.getSpaceid());
			psment.setString(7,source.getName());
			psment.setString(8, source.getId());
			
			psment.addBatch();

	        //ִ�����ݿ���봦��
			psment.execute();			
		} catch (SQLException e) {
			throw new LawyerException("Update Doc Catalog is error! " + e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
	
	/**
	 * ˵������ȡ�ĵ�Ŀ¼����ʶ
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @return ����ĵ�Ŀ¼��ʶ
	 * @throws LawyerException
	 */
	public String getMaxDocCatalogID(Connection con) throws LawyerException{
		String sql = "SELECT MAX(ID) AS MAXID FROM "+DOCCATALOGTABLE;
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			String value ="";
			while(result.next()){
				value = result.getString("MAXID");
				if(null != value)
					return value;
			}
			return "DC_0000000";
		} catch (SQLException e) {
			throw new LawyerException("Query Max Doc Catalog ID is error! "	+ e.getMessage());
		}finally{
			try {
				result.close();
				statement.close();
			} catch (SQLException e) {
			}
			result = null;
			statement = null;
		}
	}
}