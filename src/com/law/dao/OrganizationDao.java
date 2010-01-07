package com.law.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.law.bean.IContacter;
import com.law.bean.Organization;
import com.law.util.LawyerException;

/**
 * 说明：单位联系人持久化处理
 *
 */
public class OrganizationDao {
	private String CONTACTERTABLE = "T_CONTACTER";
	private String ORGANIZATABLE = "T_CONTACTDEP";

	/**
	 * 说明：获取指定用户的单位联系人列表
	 * 
	 * @param con 数据库连接对象
	 * @param userid 用户标识
	 * @return 单位联系人列表
	 * @throws LawyerException
	 */
	public List<Organization> queryUserOrganizations(Connection con ,String sysid, String userid) throws LawyerException{
		String sql = "SELECT ID,NAME,TYPE,CREATEDATE,MODIFYDATE,REMARKS,CREATOR,STATUS,GROUPID,VISIBLE FROM "+CONTACTERTABLE+" WHERE CREATOR='"+userid+"' " +
				"AND TYPE = '"+IContacter.USER_TYPE.ORGANIZATION.ordinal()+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			List<Organization> resultSet = new ArrayList<Organization>();
			Organization organization = null;
			while(result.next()){
				organization = new Organization(sysid,result.getString("ID"),result.getString("NAME"));
				resultSet.add(organization);
			}
			return resultSet;
		} catch (SQLException e) {
			throw new LawyerException("Query User Link Organizations is error! "	+ e.getMessage());
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
	 * 说明：获取指定用户指定分组的单位联系人列表
	 * 
	 * @param con 数据库连接对象
	 * @param userid 用户标识
	 * @param linkgroup 分组标识
	 * @return 联系单位列表
	 * @throws LawyerException
	 */
	public List<Organization> queryUserGroupOrganizations(Connection con,String sysid,String userid,String linkgroup) throws LawyerException{
		String sql = "SELECT ID,NAME,TYPE,CREATEDATE,MODIFYDATE,REMARKS,CREATOR,STATUS,GROUPID,VISIBLE FROM "+CONTACTERTABLE+" WHERE " +
				"CREATOR='"+userid+"' AND GROUPID = '"+linkgroup+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			List<Organization> resultSet = new ArrayList<Organization>();
			Organization organization = null;
			while(result.next()){
				organization = new Organization(sysid,result.getString("ID"),result.getString("NAME"));
				resultSet.add(organization);
			}
			return resultSet;
		} catch (SQLException e) {
			throw new LawyerException("Query User Link Organizations is error! "	+ e.getMessage());
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
	 * 说明：获取指定标识的联系单位对象
	 * 
	 * @param con 数据库连接对象
	 * @param organizationid 单位联系人标识
	 * @return 单位联系人对象
	 * @throws LawyerException
	 */
	public Organization queryOrganization(Connection con,String sysid,String organizationid) throws LawyerException{
		String sql = "SELECT ID,NAME,TYPE,CREATEDATE,MODIFYDATE,REMARKS,CREATOR,STATUS,GROUPID,VISIBLE " +
				"FROM "+CONTACTERTABLE+" AS A, " +ORGANIZATABLE+" AS B "+
				"WHERE ID='"+organizationid+"' AND A.ID =B.ID";
		
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			
			Organization linkMan = null;
			while(result.next()){
				linkMan = new Organization(sysid,result.getString("ID"),result.getString("NAME"));
				
			}
			return linkMan;
		} catch (SQLException e) {
			throw new LawyerException("Query Link Man is error! "	+ e.getMessage());
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
	 * 说明：获取单位联系最大标识
	 * 
	 * @param con 数据库连接对象
	 * @return 单位联系标识
	 * @throws LawyerException
	 */
	public String getMaxContacteID(Connection con) throws LawyerException {
		String sql = "SELECT MAX(ID) AS MAXID FROM " + CONTACTERTABLE;
		Statement statment = null;
		ResultSet result = null;
		try {
			statment = con.createStatement();
			result = statment.executeQuery(sql);
			String value = "";
			while (result.next()) {
				value = result.getString("MAXID");
				if(null != value)
					return value;
			}
			return "LP_0000000";
		} catch (SQLException e) {
			throw new LawyerException("Get Max Contacter ID is error! "	+ e.getMessage());
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
	
	/**
	 * 说明：存储给定的联系单位
	 * 
	 * @param con 数据库连接对象
	 * @param source 联系单位对象
	 * @throws LawyerException
	 */
	public void saveOrganization(Connection con,Organization source) throws LawyerException{
		PreparedStatement psment = null;
		boolean commit = false;
		try {
			commit = con.getAutoCommit();
			
			con.setAutoCommit(false);
			String sql = "INSERT INTO "+CONTACTERTABLE+" (ID,NAME,TYPE,CREATEDATE,MODIFYDATE,REMARKS,CREATOR,STATUS,GROUPID,VISIBLE,SYSID) VALUES(?,?,?,?,?,?,?,?,?,?)";
			psment = con.prepareStatement(sql);
			 //清除参数
			psment.clearBatch();

			psment.setString(1,source.getId());
			psment.setString(2,source.getName());
			psment.setString(3, IContacter.USER_TYPE.PERSON.ordinal()+"");
			psment.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			psment.setDate(5, new java.sql.Date(System.currentTimeMillis()));
			psment.setString(6, "");
			psment.setString(7, "");
			psment.setString(8, "");
			psment.setString(9, "");
			psment.setString(10, "");
			psment.setString(11, source.getSysid());;
			
			psment.addBatch();
	        //执行数据库插入处理
			psment.execute();			
			psment.close();
			
			sql = "INSERT INTO "+ORGANIZATABLE+" (ID,NAME,SNAME,LAWER,DESCRIP) VALUES(?,?,?,?,?)";
			psment = con.prepareStatement(sql);
			psment.clearBatch();

			psment.setString(1,source.getId());
			psment.setString(2,source.getName());
			psment.setString(3,source.getName());
			psment.setString(4,source.getLawyer());
			psment.setString(5,source.getDesc());
			
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
	 * 说明：删除给定的联系单位
	 * 
	 * @param con 数据库连接对象
	 * @param source 联系单位
	 * @throws LawyerException
	 */
	public void deleteOrganization(Connection con,Organization source) throws LawyerException{
		deleteOrganization(con, source.getId());
	}
	
	/**
	 * 说明：删除指定标识的联系单位
	 * 
	 * @param con
	 * @param organizationid
	 * @throws LawyerException
	 */
	public void deleteOrganization(Connection con,String organizationid) throws LawyerException{
		Statement sment = null;
		boolean commit = false;
		try {
			commit = con.getAutoCommit();
			con.setAutoCommit(false);
			String sql = "DELETE "+CONTACTERTABLE+" FROM "+CONTACTERTABLE+" WHERE ID='"+organizationid+"'";
			sment = con.createStatement();
			sment.execute(sql);
			sql = "DELETE "+ORGANIZATABLE+" FROM "+ORGANIZATABLE+" WHERE ID='"+organizationid+"'";
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
	 * 说明：更新单位联系人
	 * 
	 * @param con 数据库对象
	 * @param source 单位联系人
	 * @throws LawyerException
	 */
	public void updateOrganization(Connection con,Organization source) throws LawyerException{
		throw new LawyerException("The method isn't support!");
	}
}