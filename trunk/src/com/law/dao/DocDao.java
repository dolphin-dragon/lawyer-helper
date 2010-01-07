package com.law.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.law.bean.Doc;
import com.law.util.LawyerException;

/**
 * ˵�����ĵ�����־û�����
 * 
 */
public class DocDao {
	private String DOCTABLE="T_DOC";

	/**
	 * ˵������ȡָ��ϵͳָ��Ŀ¼�µ��ļ��б��ļ�δ��ȡ�ļ�����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param sysid ϵͳ��ʶ
	 * @param catalogid Ŀ¼��ʶ
	 * @return
	 * @throws LawyerException
	 */
	public List<Doc> queryCataLogDocs(Connection con,String sysid,String catalogid) throws LawyerException{
		String sql = "SELECT ID,NAME,SHOTNAME,REMARKS,TYPE,CDATE,MDATE,CREATOR,MODIFYOR,SIZE,SPACEID,CONTENT,PATH,SUFFIX,FTYPE,VISIBLE,CATALOGID,SYSID FROM "+DOCTABLE+" WHERE CATALOGID='"+catalogid+"' AND SYSID='"+sysid+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			List<Doc> resultSet = new ArrayList<Doc>();
			Doc doc = null;
			while(result.next()){
				doc = new Doc(sysid,result.getString("ID"),result.getString("NAME"));
				doc.setCatalogID(result.getString("CATALOGID"));
				doc.setContent(null);
				doc.setFileName(result.getString("PATH"));
				doc.setRemarks(result.getString("REMARKS"));
				doc.setSize(result.getInt("SIZE"));
				doc.setSname(result.getString("SHOTNAME"));
				doc.setSpaceID(result.getString("SPACEID"));
				doc.setType(result.getString("TYPE"));
				doc.setCdate(result.getDate("CDATE"));
				doc.setMdate(result.getDate("MDATE"));
				doc.setCreator(result.getString("CREATOR"));
				doc.setFilePath(result.getString("PATH"));
				
				resultSet.add(doc);
			}
			return resultSet;
		} catch (SQLException e) {
			throw new LawyerException("Query Docs from Catalog is error! "	+ e.getMessage());
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
	 * ˵������ѯָ��ϵͳ��ָ�����ļ���ʶ���ļ����󣬲���ȡ�ļ�����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param sysid ϵͳ��ʶ
	 * @param docid
	 * @return
	 * @throws LawyerException
	 */
	public Doc queryDoc(Connection con,String sysid,String docid) throws LawyerException{
		String sql = "SELECT ID,NAME,SHOTNAME,REMARKS,TYPE,CDATE,MDATE,CREATOR,MODIFYOR,SIZE,SPACEID,CONTENT,PATH,SUFFIX,FTYPE,VISIBLE,CATALOGID,SYSID FROM "+DOCTABLE+" WHERE ID='"+docid+"' AND SYSID='"+sysid+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			Doc doc = null;
			while(result.next()){
				doc = new Doc(sysid,result.getString("ID"),result.getString("NAME"));
				doc.setCatalogID(result.getString("CATALOGID"));
				doc.setContent(null);
				doc.setFileName(result.getString("PATH"));
				doc.setRemarks(result.getString("REMARKS"));
				doc.setSize(result.getInt("SIZE"));
				doc.setSname(result.getString("SHOTNAME"));
				doc.setSpaceID(result.getString("SPACEID"));
				doc.setType(result.getString("TYPE"));
				doc.setCdate(result.getDate("CDATE"));
				doc.setMdate(result.getDate("MDATE"));
				doc.setCreator(result.getString("CREATOR"));
				doc.setFilePath(result.getString("PATH"));
				break;
			}
			return doc;
		} catch (SQLException e) {
			throw new LawyerException("Query Doc of sysid and docid is error! "	+ e.getMessage());
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
	 * ˵��������ָ���ļ���ʶ���ļ�����������
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param docID �ļ���ʶ��
	 * @return �ĵ�������
	 * @throws LawyerException
	 */
	public InputStream queryFileContent(Connection con,String sysid,String docID) throws LawyerException{
		String sql = "SELECT CONTENT FROM "+DOCTABLE+" WHERE ID='"+docID+"' AND SYSID='"+sysid+"'";
		ByteArrayInputStream ips = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				InputStream content = result.getBlob("CONTENT").getBinaryStream();
				byte[] buffer =new byte[1024];
				int size = 0;
				while((size = content.read(buffer))!=-1){
					out.write(buffer, 0, size);
					buffer =new byte[1024];
				}
				ips = new ByteArrayInputStream(out.toByteArray());
				break;
			}
			return ips;
		} catch (SQLException e) {
			throw new LawyerException("Query Doc is error! "	+ e.getMessage());
		} catch (IOException e) {
			throw new LawyerException("Query Doc Content is error! "	+ e.getMessage());
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
	 * ˵�����洢�������ļ�����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source �ĵ�����
	 * @throws LawyerException
	 */
	public void saveDoc(Connection con,Doc source) throws LawyerException{
		String sql = "INSERT INTO "+DOCTABLE +"" +		
				"(ID,NAME,SHOTNAME,REMARKS,TYPE,CDATE,MDATE,CREATOR,MODIFYOR,SIZE,SPACEID,CONTENT,PATH,SUFFIX,FTYPE,VISIBLE,CATALOGID,SYSID)" +
				" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
			psment.clearBatch();

			psment.setString(1,source.getID());
			psment.setString(2,source.getName());
			psment.setString(3,source.getSname());
			psment.setString(4,source.getRemarks());
			psment.setString(5,source.getType());
			psment.setDate(6,null == source.getCdate() ? new java.sql.Date(new Date().getTime()): new java.sql.Date(source.getCdate().getTime()));
			psment.setDate(7,null == source.getMdate() ? new java.sql.Date(new Date().getTime()): new java.sql.Date(source.getMdate().getTime()));
			psment.setString(8, source.getCreator());
			psment.setString(9, source.getCreator());
			psment.setInt(10, source.getSize());			
			psment.setString(11,source.getSpaceID());
			psment.setBytes(12,null == source.getContent() ? null : (byte[])source.getContent());
			psment.setString(13, source.getFilePath());
			psment.setString(14, source.getSuffix());
			psment.setString(15, source.getFileType());
			psment.setString(16,source.getVisible());
			psment.setString(17, source.getCatalogID());
			psment.setString(18, source.getSysid());
			
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
	 * ˵�������¸������ĵ�����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source �ĵ�����
	 * @throws LawyerException
	 */
	public void updateDoc(Connection con,Doc source) throws LawyerException{
		String sql = "UPDATE "+DOCTABLE+" SET NAME=?,SHOTNAME=?,REMARKS=?,TYPE=?,CDATE=?,MDATE=?,CREATOR=?,MODIFYOR=?,SIZE=?,SPACEID=?,CONTENT=?,PATH=?,SUFFIX=?,FTYPE=?,VISIBLE=?,CATALOGID=? WHERE ID=? AND SYSID=?";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
			psment.clearBatch();

			psment.setString(1,source.getName());
			psment.setString(2,source.getSname());
			psment.setString(3,source.getRemarks());
			psment.setString(4,source.getType());
			psment.setDate(5,new java.sql.Date(source.getCdate().getTime()));
			psment.setDate(6,null == source.getMdate() ? new java.sql.Date(new Date().getTime()): new java.sql.Date(source.getMdate().getTime()));
			psment.setString(7, source.getCreator());
			psment.setString(8, source.getCreator());
			psment.setInt(9, source.getSize());			
			psment.setString(10,source.getSpaceID());
			psment.setBytes(11,null == source.getContent() ? null :(byte[])source.getContent());
			psment.setString(12, source.getFilePath());
			psment.setString(13, source.getSuffix());
			psment.setString(14, source.getFileType());
			psment.setString(15,source.getVisible());
			psment.setString(16, source.getCatalogID());
			
			psment.setString(17,source.getID());
			psment.setString(18, source.getSysid());
			
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
	 * ˵����ɾ��ָ�����ļ�����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source �ĵ�����
	 * @throws LawyerException
	 */
	public void delete(Connection con,Doc source) throws LawyerException{
		String sql = "DELETE "+DOCTABLE+" FROM "+DOCTABLE+" WHERE ID='"+source.getID()+"' AND SYSID='"+source.getSysid()+"'";
		Statement statement = null;
		try {
			statement = con.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			throw new LawyerException("Delete Doc is error! "+ e.getMessage());
		}finally{
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}
	
	/**
	 * ˵����ɾ��ָ����ʶ���ĵ�
	 * 
	 * @param con ���ݿ�����
	 * @param docid �ĵ���ʶ
	 * @throws LawyerException
	 */
	public void delete(Connection con,String sysid,String docid) throws LawyerException{
		String sql = "DELETE "+DOCTABLE+" FROM "+DOCTABLE+" WHERE ID='"+docid+"' AND SYSID='"+sysid+"'";
		Statement statement = null;
		try {
			statement = con.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			throw new LawyerException("Delete Doc is error! "	+ e.getMessage());
		}finally{
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}	

	/**
	 * ˵������ȡ�ĵ�����ʶ
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @return ����ĵ���ʶ
	 * @throws LawyerException
	 */
	public String getMaxDocID(Connection con) throws LawyerException{
		String sql = "SELECT MAX(ID) AS MAXID FROM "+DOCTABLE;
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			String value = "";
			while(result.next()){
				value = result.getString("MAXID");
				if(null != value)
					return value;
			}
			return "F_00000000";
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
	
	public String getMaxDocIDBySysid(Connection con,String sysid) throws LawyerException{
		throw new LawyerException("The method isn't support!");
	}
}