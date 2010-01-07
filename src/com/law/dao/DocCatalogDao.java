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
 * 说明：文档目录持久化处理
 *
 */
public class DocCatalogDao {
	private String DOCCATALOGTABLE="T_DOC_CATALOG";
	/**
	 * 说明：获取指定用户的得文档目录列表
	 * @param con 数据库连接对象
	 * @param userid 用户标识
	 * @return 用户一级文档目录列表
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
	 * 说明：获取指定目录下的子目录列表
	 * 
	 * @param con 数据库连接对象
	 * @param superCatalog 给定的目录标识
	 * @return 给定目录的子目录列表
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
	 * 说明：存储给定的文档目录对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 文档目录对象
	 * @throws LawyerException
	 */
	public void saveDocCatalog(Connection con,DocCatalog source) throws LawyerException{
		String sql = "INSERT INTO "+DOCCATALOGTABLE+"(CATALOGID,SUPERCATALOG,CREATOR,CDATE,USESIZE,TYPE,SPACEID,NAME) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
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
	 * 说明：删除给定的文档目录
	 * 
	 * @param con 数据库连接对象
	 * @param source 文档目录对象
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
	 * 说明：删除指定用户的指定文档目录分组
	 * 
	 * @param con 数据库对象
	 * @param userid 用户标识
	 * @param catalogid 分组标识
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
	 * 说明：更新给定的文档目录对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 文档目录对象
	 * @throws LawyerException
	 */
	public void updateDocCatalog(Connection con ,DocCatalog source) throws LawyerException{
		String sql = "UPDATE "+DOCCATALOGTABLE+" SET SUPERCATALOG=?,CREATOR=?,CDATE=?,USESIZE=?,TYPE=?,SPACEID=?,NAME=? WHERE CATALOGID=? ";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
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
	 * 说明：获取文档目录最大标识
	 * 
	 * @param con 数据库连接对象
	 * @return 最大文档目录标识
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