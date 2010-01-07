package com.law.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.law.bean.SysUser;
import com.law.util.LawyerException;

/**
 * 说明：系统内用户的持久化处理
 *
 */
public class SysUserDao {
	private String SYSUSERTABLE="T_SYSUSER"; 
	
	/**
	 * 说明：获取指定系统的系统内部用户列表
	 * 
	 * @param con 数据库连接对象
	 * @param sysid 系统标识
	 * @return 返回系统内部用户列表
	 * @throws LawyerException
	 */
	public List<SysUser> querySysUsers(Connection con,String sysid) throws LawyerException{
		String sql = "SELECT ID,NAME,PHONE,SEX,EMAIL,BIRTHDAY,WSDATE,WEDATE,STATUS,AGE,SYSID,ADDRESS,MSN,QQ,NATIONALITY,POSITION,EDUCATION FROM "+SYSUSERTABLE+" WHERE SYSID='"+sysid+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			List<SysUser> resultSet = new ArrayList<SysUser>();
			SysUser sysuser = null;
			while (result.next()) {
				sysuser = new SysUser(result.getString("SYSID"),result.getString("ID"),result.getString("NAME"));
				
				sysuser.setAddress(result.getString("ADDRESS"));
				sysuser.setBirthday(result.getDate("BIRTHDAY"));
				sysuser.setEmail(result.getString("EMAIL"));
				sysuser.setPhone(result.getString("PHONE"));
				sysuser.setSex(result.getString("SEX"));
				sysuser.setStatus(result.getString("STATUS"));
				sysuser.setWorksDate(result.getDate("WSDATE"));
				sysuser.setWorkeDate(result.getDate("WEDATE"));
				
				resultSet.add(sysuser);
			}
			result.close();
			return resultSet;
		} catch (SQLException e) {
			throw new LawyerException("Query Sys User is error! "+ e.getMessage());
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}
	
	/**
	 * 说明：根据用户表示获取系统内部用户对象
	 * 
	 * @param con 数据库连接对象
	 * @param userid 用户标识
	 * @return 返回系统内部用户对象
	 * @throws LawyerException
	 */
	public SysUser querySysUserByID(Connection con ,String sysid ,String userid) throws LawyerException{
		String sql = "SELECT ID,NAME,PHONE,SEX,EMAIL,BIRTHDAY,WSDATE,WEDATE,STATUS,AGE,SYSID,ADDRESS,MSN,QQ,NATIONALITY,POSITION,EDUCATION FROM "+SYSUSERTABLE+" WHERE ID='"+userid+"' AND SYSID='"+sysid+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			SysUser sysuser = null;
			while (result.next()) {
				sysuser = new SysUser(result.getString("SYSID"),result.getString("ID"),result.getString("NAME"));
				
				sysuser.setAddress(result.getString("ADDRESS"));
				sysuser.setBirthday(result.getDate("BIRTHDAY"));
				sysuser.setEmail(result.getString("EMAIL"));
				sysuser.setPhone(result.getString("PHONE"));
				sysuser.setSex(result.getString("SEX"));
				sysuser.setStatus(result.getString("STATUS"));
				sysuser.setWorksDate(result.getDate("WSDATE"));
				sysuser.setWorkeDate(result.getDate("WEDATE"));
				
				break;
			}
			result.close();
			return sysuser;
		} catch (SQLException e) {
			throw new LawyerException("Query Sys User by user id is error! "+ e.getMessage());
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}
	
	/**
	 * 说明：存储给定的系统内部用户对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 系统内部用户对象
	 * @throws LawyerException
	 */
	public void saveSysUser(Connection con,SysUser source) throws LawyerException{
		String sql = "INSERT INTO "+SYSUSERTABLE+"(ID,NAME,PHONE,SEX,EMAIL,BIRTHDAY,WSDATE,WEDATE,STATUS,AGE,SYSID,ADDRESS,MSN,QQ,NATIONALITY,POSITION,EDUCATION) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
			psment.clearBatch();

			psment.setString(1,source.get_ID());
			psment.setString(2,source.getName());
			psment.setString(3, source.getPhone());
			psment.setString(4, source.getSex());
			psment.setString(5, source.getEmail());
			psment.setDate(6,null == source.getBirthday()? null:new java.sql.Date(source.getBirthday().getTime()));
			psment.setDate(7,null == source.getWorksDate()? null : new java.sql.Date(source.getWorksDate().getTime()));
			psment.setDate(8,null == source.getWorkeDate() ? null : new java.sql.Date(source.getWorkeDate().getTime()));
			psment.setString(9, source.getStatus());
			psment.setInt(10,source.getAge());
			psment.setString(11, source.getSysid());
			psment.setString(12, source.getAddress());
			psment.setString(13, source.getMSN());
			psment.setString(14, source.getQQ());
			psment.setString(15, source.getNationality());
			psment.setString(16, source.getPosition());
			psment.setString(17, source.getEducation());
			
			psment.addBatch();
	        //执行数据库插入处理
			psment.execute();
		} catch (SQLException e) {
			throw new LawyerException("Save Sys User is error! " + e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
	
	/**
	 * 说明：删除给定的系统内部用户对象
	 * 
	 * @param con
	 * @param source
	 * @throws LawyerException
	 */
	public void deleteSysUser(Connection con,SysUser source) throws LawyerException{
		deleteSysUser(con, source.getSysid(),source.get_ID());
	}
	
	/**
	 * 说明：删除指定标识的系统内部用户
	 * 
	 * @param con
	 * @param userid
	 * @throws LawyerException
	 */
	public void deleteSysUser(Connection con,String sysid ,String userid) throws LawyerException{
		String sql = "DELETE "+SYSUSERTABLE+" FROM "+SYSUSERTABLE+" WHERE ID='"+userid+"' AND SYSID='"+sysid+"'";
		Statement statement = null;
		try {
			statement = con.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			throw new LawyerException("Delete Sys user is error! "+ e.getMessage());
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}
	
	/**
	 * 说明：更新给定的系统内部用户对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 系统内部用户对象
	 * @throws LawyerException
	 */
	public void updateSysUser(Connection con , SysUser source) throws LawyerException{
		String sql = "UPDATE "+SYSUSERTABLE+" SET NAME=?,PHONE=?,SEX=?,EMAIL=?,BIRTHDAY=?,WSDATE=?,WEDATE=?,STATUS=?,AGE=?,SYSID=?,ADDRESS=?,MSN=?,QQ=?,NATIONALITY=?,POSITION=?,EDUCATION=? WHERE ID='"+source.get_ID()+"' AND SYSID='"+source.getSysid()+"'";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
			psment.clearBatch();

			psment.setString(1,source.getName());
			psment.setString(2,source.getPhone());
			psment.setString(3,source.getSex());
			psment.setString(4,source.getEmail());
			psment.setDate(5,null == source.getBirthday()? null:new java.sql.Date(source.getBirthday().getTime()));
			psment.setDate(6,null == source.getWorksDate()? null : new java.sql.Date(source.getWorksDate().getTime()));
			psment.setDate(7,null == source.getWorkeDate() ? null : new java.sql.Date(source.getWorkeDate().getTime()));
			psment.setString(8, source.getStatus());
			psment.setInt(9, source.getAge());
			psment.setString(10, source.getSysid());
			psment.setString(11, source.getAddress());
			psment.setString(12, source.getMSN());
			psment.setString(13, source.getQQ());
			psment.setString(14, source.getNationality());
			psment.setString(15, source.getPosition());
			psment.setString(16, source.getEducation());

			psment.addBatch();
		
	        //执行数据库插入处理
			psment.execute();			
			
		} catch (SQLException e) {
			throw new LawyerException("UPDATE Sys User is error! " + e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}	
	}
	
	/**
	 * 说明：获取系统中当前最大的案件案卷报告标识
	 * 
	 * @param con 数据库连接对象
	 * @return 返回当前案件案卷表中的最大标识符
	 * @throws LawyerException
	 */
	public String getMaxSysUserID(Connection con) throws LawyerException {
		String sql = "SELECT MAX(ID) AS MAXID FROM " + SYSUSERTABLE;
		Statement statment = null;
		ResultSet result = null;
		try {
			statment = con.createStatement();
			result = statment.executeQuery(sql);
			String value = "";
			while (result.next()) {
				value =result.getString("MAXID");
				if(null != value )
					return value;
			}
			return "SU_0000000";
		} catch (SQLException e) {
			throw new LawyerException("Get Max Sys User id is error! "	+ e.getMessage());
		} finally {
			try {
				result.close();
				statment.close();
			} catch (SQLException e) {
			}
			result = null;
			statment = null;
		}
	}
	
	public String getMaxSysUserIDBySysID(Connection con,String sysid) throws LawyerException{
		throw new LawyerException("The method isn't support!");
	}
}