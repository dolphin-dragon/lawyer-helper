package com.law.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.law.bean.IContacter;
import com.law.bean.LinkMan;
import com.law.util.LawyerException;

/**
 * 说明：联系人持久化处理
 *
 */
public class LinkManDao {
	private String CONTACTERTABLE = "T_CONTACTER";
	private String LINKMAINTABLE = "T_LINKMAN";	
	/**
	 * 说明：查询指定用户的指定联系人类型的列表
	 * 
	 * @param con
	 * @param userid
	 * @return
	 * @throws LawyerException
	 */
	public List<LinkMan> queryUserLinkMans(Connection con , String userid) throws LawyerException{
		String sql = "SELECT ID,NAME,TYPE,CDATE,MDATE,REMARKS,CREATOR,STATUS,GROUPID,VISIBLE,SYSID  FROM "+CONTACTERTABLE+" WHERE CREATOR='"+userid+"' " +
				"AND TYPE = '"+IContacter.USER_TYPE.PERSON.ordinal()+"'";
		Statement statement = null;
		try {
			ResultSet result = null;
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			List<LinkMan> resultSet = new ArrayList<LinkMan>();
			LinkMan linkMan = null;
			while(result.next()){
				linkMan = new LinkMan(result.getString("SYSID"),result.getString("ID"),result.getString("NAME"));
				linkMan.setCreator(result.getString("CREATOR"));
				
				resultSet.add(linkMan);
			}
			return resultSet;
		} catch (SQLException e) {
			throw new LawyerException("Query User Link Man is error! "	+ e.getMessage());
		}finally{
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}
	
	/**
	 * 说明：获取指定用户指定联系人分组下的联系人列表
	 * 
	 * @param con 数据库连接对象
	 * @param userid 用户标识
	 * @param linkgroup 联系人分组标识
	 * @return 联系人列表
	 * @throws LawyerException
	 */
	public List<LinkMan> queryUserGroupLinkMans(Connection con,String userid,String linkgroup) throws LawyerException{
		String sql = "SELECT ID,NAME,TYPE,CDATE,MDATE,REMARKS,CREATOR,STATUS,GROUPID,VISIBLE,SYSID  FROM "+CONTACTERTABLE+" WHERE " +
				"CREATOR='"+userid+"' AND GROUPID = '"+linkgroup+"'";
		Statement statement = null;
		try {
			ResultSet result = null;
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			List<LinkMan> resultSet = new ArrayList<LinkMan>();
			LinkMan linkMan = null;
			while(result.next()){
				linkMan = new LinkMan(result.getString("SYSID"),result.getString("ID"),result.getString("NAME"));
				resultSet.add(linkMan);
			}
			return resultSet;
		} catch (SQLException e) {
			throw new LawyerException("Query User Group Link Man is error! "	+ e.getMessage());
		}finally{
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}
	
	/**
	 * 说明：查询指定联系人标识的联系人对象
	 * 
	 * @param con 数据库连接对象
	 * @param linkmanid 联系人标识
	 * @return 联系人对象
	 * @throws LawyerException
	 */
	public LinkMan queryLinkMan(Connection con,String linkmanid) throws LawyerException{
		String sql = "SELECT A.ID,A.NAME,A.TYPE,A.CDATE,A.MDATE,A.REMARKS,A.CREATOR,A.STATUS,A.GROUPID,A.VISIBLE,A.SYSID  " +
				"FROM "+CONTACTERTABLE+" AS A, " +LINKMAINTABLE+" AS B "+
				"WHERE A.ID='"+linkmanid+"' AND A.ID =B.ID";
		
		Statement statement = null;
		try {
			ResultSet result = null;
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			
			LinkMan linkMan = null;
			while(result.next()){
				linkMan = new LinkMan(result.getString("SYSID"),result.getString("ID"),result.getString("NAME"));
				break;
			}
			return linkMan;
		} catch (SQLException e) {
			throw new LawyerException("Query Link Man is error! "	+ e.getMessage());
		}finally{
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}
	
	/**
	 * 说明：获取系统中当前最大的联系人标识
	 * 
	 * @param con 数据库连接对象
	 * @return 返回当前案件案卷表中的最大标识符
	 * @throws LawyerException
	 */
	public String getMaxContacteID(Connection con) throws LawyerException {
		String sql = "SELECT MAX(ID) AS MAXID FROM " + CONTACTERTABLE;
		Statement statment = null;
		try {
			ResultSet result = null;
			statment = con.createStatement();
			result = statment.executeQuery(sql);
			String value = "";
			while (result.next()) {
				value = result.getString("MAXID");
				if(null != value)
					return value;
			}
			return "L_00000000";
		} catch (SQLException e) {
			throw new LawyerException("Get Max Contacter ID is error! "	+ e.getMessage());
		} finally {
			try {
				statment.close();
			} catch (SQLException e) {
			}
			statment = null;
		}
	}
	
	/**
	 * 说明：存储给定的联系人对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 联系人对象
	 * @throws LawyerException
	 */
	public void saveLinkMan(Connection con,LinkMan source) throws LawyerException{
		PreparedStatement psment = null;
		boolean commit = false;
		try {
			commit = con.getAutoCommit();

			con.setAutoCommit(false);
			String sql = "INSERT INTO "+CONTACTERTABLE+" (ID,NAME,TYPE,CDATE,MDATE,REMARKS,CREATOR,STATUS,GROUPID,VISIBLE,SYSID) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			psment = con.prepareStatement(sql);
			 //清除参数
			psment.clearBatch();

			psment.setString(1,source.getId());
			psment.setString(2,source.getName());
			psment.setString(3, IContacter.USER_TYPE.PERSON.ordinal()+"");
			psment.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			psment.setDate(5, new java.sql.Date(System.currentTimeMillis()));
			psment.setString(6, "");
			psment.setString(7, source.getCreator());
			psment.setString(8, "");
			psment.setString(9, "");
			psment.setString(10, "");
			psment.setString(11, source.getSysid());;

			psment.addBatch();
	        //执行数据库插入处理
			psment.execute();			
			psment.close();

			sql = "INSERT INTO "+LINKMAINTABLE+" (ID,NAME,PHONE,EMAIL,SEX) VALUES(?,?,?,?,?)";
			psment = con.prepareStatement(sql);
			psment.clearBatch();

			psment.setString(1,source.getId());
			psment.setString(2,source.getName());
			psment.setString(3, source.getPhone());
			psment.setString(4, source.getEmail());
			psment.setString(5, source.getSex());

			psment.addBatch();
	        //执行数据库插入处理
			psment.execute();
			psment.close();

			con.commit();
		} catch (SQLException e) {
			throw new LawyerException("Save Link Man is error! " + e.getMessage());
		}finally{
			try {
				con.setAutoCommit(commit);
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
	
	/**
	 * 说明：删除给定的联系人对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 联系人对象
	 * @throws LawyerException
	 */
	public void deleteLinkMan(Connection con,LinkMan source) throws LawyerException{
		deleteLinkMan(con, source.getId());
	}
	
	/**
	 * 说明：删除指定标识的联系人
	 * 
	 * @param con 数据库连接对象
	 * @param linkManid 联系人标识
	 * @throws LawyerException
	 */
	public void deleteLinkMan(Connection con,String linkManid) throws LawyerException{
		Statement sment = null;
		boolean commit = false;
		try {
			commit = con.getAutoCommit();
			con.setAutoCommit(false);
			String sql = "DELETE "+CONTACTERTABLE+" FROM "+CONTACTERTABLE+" WHERE ID='"+linkManid+"'";
			sment = con.createStatement();
			sment.execute(sql);
			sql = "DELETE "+LINKMAINTABLE+" FROM "+LINKMAINTABLE+" WHERE ID='"+linkManid+"'";
			sment.execute(sql);
			con.commit();
		} catch (SQLException e) {
			throw new LawyerException("delete Link Man is error! " + e.getMessage());
		}finally{
			try {
				con.setAutoCommit(commit);
				sment.close();
			} catch (SQLException e) {
			}
			sment = null;
		}
	}
	
	/**
	 * 说明：更新指定的联系人对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 联系人对象
	 * @throws LawyerException
	 */
	public void updateLinkMan(Connection con,LinkMan source) throws LawyerException{
		PreparedStatement psment = null;
		boolean commit = false;
		try {
			commit = con.getAutoCommit();
			con.setAutoCommit(false);
			String sql = "UPDATE "+CONTACTERTABLE+" SET ID=?,NAME=?,TYPE=?,CDATE=?,MDATE=?,REMARKS=?,CREATOR=?,STATUS=?,GROUPID=?,VISIBLE=?,SYSID=? WHERE ID='"+source.getId()+"' AND SYSID='"+source.getSysid()+"'";
			psment = con.prepareStatement(sql);
			 //清除参数
			psment.clearBatch();

			psment.setString(1,source.getId());
			psment.setString(2,source.getName());
			psment.setString(3, IContacter.USER_TYPE.PERSON.ordinal()+"");
			psment.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			psment.setDate(5, new java.sql.Date(System.currentTimeMillis()));
			psment.setString(6, "");
			psment.setString(7, source.getCreator());
			psment.setString(8, "");
			psment.setString(9, "");
			psment.setString(10, "");
			psment.setString(11, source.getSysid());;

			psment.addBatch();
	        //执行数据库插入处理
			psment.execute();			
			psment.close();

			sql = "UPDATE "+LINKMAINTABLE+" SET ID=?,NAME=?,PHONE=?,EMAIL=?,SEX=? WHERE ID='"+source.getId()+"'";
			psment = con.prepareStatement(sql);
			psment.clearBatch();

			psment.setString(1,source.getId());
			psment.setString(2,source.getName());
			psment.setString(3, source.getPhone());
			psment.setString(4, source.getEmail());
			psment.setString(5, source.getSex());

			psment.addBatch();
	        //执行数据库插入处理
			psment.execute();
			psment.close();

			con.commit();
		} catch (SQLException e) {
			throw new LawyerException("Update Link Man is error! " + e.getMessage());
		}finally{
			try {
				con.setAutoCommit(commit);
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
}