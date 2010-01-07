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
 * 说明：文档对象持久化处理
 * 
 */
public class DocDao {
	private String DOCTABLE="T_DOC";

	/**
	 * 说明：获取指定系统指定目录下的文件列表，文件未读取文件内容
	 * 
	 * @param con 数据库连接对象
	 * @param sysid 系统标识
	 * @param catalogid 目录标识
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
	 * 说明：查询指定系统的指定的文件标识的文件对象，不读取文件内容
	 * 
	 * @param con 数据库连接对象
	 * @param sysid 系统标识
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
	 * 说明：返回指定文件标识的文件内容流对象
	 * 
	 * @param con 数据库连接对象
	 * @param docID 文件标识符
	 * @return 文档内容流
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
	 * 说明：存储给定的文件对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 文档对象
	 * @throws LawyerException
	 */
	public void saveDoc(Connection con,Doc source) throws LawyerException{
		String sql = "INSERT INTO "+DOCTABLE +"" +		
				"(ID,NAME,SHOTNAME,REMARKS,TYPE,CDATE,MDATE,CREATOR,MODIFYOR,SIZE,SPACEID,CONTENT,PATH,SUFFIX,FTYPE,VISIBLE,CATALOGID,SYSID)" +
				" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
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
	        //执行数据库插入处理
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
	 * 说明：更新给定的文档对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 文档对象
	 * @throws LawyerException
	 */
	public void updateDoc(Connection con,Doc source) throws LawyerException{
		String sql = "UPDATE "+DOCTABLE+" SET NAME=?,SHOTNAME=?,REMARKS=?,TYPE=?,CDATE=?,MDATE=?,CREATOR=?,MODIFYOR=?,SIZE=?,SPACEID=?,CONTENT=?,PATH=?,SUFFIX=?,FTYPE=?,VISIBLE=?,CATALOGID=? WHERE ID=? AND SYSID=?";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
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
	        //执行数据库插入处理
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
	 * 说明：删除指定的文件对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 文档对象
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
	 * 说明：删除指定标识的文档
	 * 
	 * @param con 数据库连接
	 * @param docid 文档标识
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
	 * 说明：获取文档最大标识
	 * 
	 * @param con 数据库连接对象
	 * @return 最大文档标识
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