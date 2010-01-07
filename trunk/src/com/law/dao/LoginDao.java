package com.law.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.law.bean.Login;
import com.law.bean.Role;
import com.law.util.LawyerException;

/**
 * 说明：系统登录用户持久化处理
 *
 */
public class LoginDao {
	private String LOGINTABLE="T_LOGIN";
	
	public List<Login> querySysLogins(Connection con,String sysid) throws LawyerException {
		String sql = "SELECT ID,USERID,NAME,PW,STATUS,SDATE,EDATE,ROLE,SYSID FROM " + LOGINTABLE;
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			List<Login> resultSet = new ArrayList<Login>();
			Login login = null;
			while (result.next()) {
				login = new Login(sysid,result.getString("ID"));
				login.setName(result.getString("NAME"));
				login.setUserid(result.getString("USERID"));
				login.setPw(result.getString("PW"));
				login.setStatus(result.getString("STATUS"));
				login.setSdate(result.getDate("SDATE"));
				login.setEdate(result.getDate("EDATE"));
				login.setRole(null);
				
				resultSet.add(login);
			}
			return resultSet;
		} catch (SQLException e) {
			throw new LawyerException("Query Loigns is error! "+ e.getMessage());
		} finally {
			try {
				result.close();
				statement.close();
			} catch (SQLException e) {
			}
			result = null;
			statement = null;
		}
	}
	public void saveLogin(Connection con,Login source) throws LawyerException{
		String sql = "INSERT INTO " + LOGINTABLE+" (ID,USERID,NAME,PW,STATUS,SDATE,EDATE,ROLE,SYSID) VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
			psment.clearBatch();

			psment.setString(1,source.getId());
			psment.setString(2,source.getUserid());
			psment.setString(3,source.getName());
			psment.setString(4,source.getPw());
			psment.setString(5,source.getStatus());
			psment.setDate(6,null == source.getSdate() ? null : new java.sql.Date(source.getSdate().getTime()));
			psment.setDate(7,null == source.getEdate() ? null : new java.sql.Date(source.getEdate().getTime()));
			psment.setString(8,null == source.getRole() ? null : Arrays.toString(source.getRole().toArray(new Role[]{})));
			psment.setString(9,source.getSysid());
			psment.addBatch();
	        //执行数据库插入处理
			psment.execute();			
			
		} catch (SQLException e) {
			throw new LawyerException("Save Loing is error! " + e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
	/**
	 * 说明：删除给定的登录对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 登录对象
	 * @throws LawyerException
	 */
	public void deleteLogin(Connection con,Login source) throws LawyerException{
		deleteLogin(con,source.getId());
		
	}
	
	/**
	 * 说明：删除指定标识的登陆对象
	 * 
	 * @param con 数据库连接对象
	 * @param loginid 登录标识
	 * @throws LawyerException
	 */
	public void deleteLogin(Connection con,String loginid) throws LawyerException{
		String sql = "DELETE "+LOGINTABLE+" FROM "+LOGINTABLE+" WHERE ID='"+loginid+"'";
		Statement statement = null;
		try {
			statement = con.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			throw new LawyerException("Delete Loign is error! "+ e.getMessage());
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}
	
	/**
	 * 说明：更新给定的登陆对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 登录对象
	 * @throws LawyerException
	 */
	public void updataLogin(Connection con,Login source) throws LawyerException{
		String sql = "UPDATE " + LOGINTABLE+" SET (USERID=?,NAME=?,PW=?,STATUS=?,SDATE=?,EDATE=?,ROLE=?) FROM "+LOGINTABLE+" WHERE ID='"+source.getId()+"'";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
			psment.clearBatch();

			psment.setString(1,source.getUserid());
			psment.setString(2,source.getName());
			psment.setString(3,source.getPw());
			psment.setString(4,source.getStatus());
			psment.setDate(5,new java.sql.Date(source.getSdate().getTime()));
			psment.setDate(6,new java.sql.Date(source.getEdate().getTime()));
			psment.setString(7,Arrays.toString(source.getRole().toArray(new Role[]{})));
			
			psment.addBatch();
	        //执行数据库插入处理
			psment.execute();			
			
		} catch (SQLException e) {
			throw new LawyerException("UPDATE Link Man is error! " + e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
	
	/**
	 * 说明：检查给定的用户登录标识是否存在，存在返回true，不存在返回false
	 *
	 * @param con 数据库连接对象
	 * @param loginid 用户登录标识
	 * @return true表示此登录ID存在，false表示此登录ID不存在
	 * @throws LawyerException 
	 */
	public synchronized boolean checkLoginID(Connection con,String loginid) throws LawyerException{
		String sql = "SELECT ID FROM "+LOGINTABLE +" WHERE ID='"+loginid+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			
			while (result.next()) {
				String tempid = result.getString("ID");
				if(null!=tempid && loginid.equals(tempid))
					return true;
			}
		} catch (SQLException e) {
			throw new LawyerException("Query Loigns is error! "+ e.getMessage());
		} finally {
			try {
				result.close();
				statement.close();
			} catch (SQLException e) {
			}
			result = null;
			statement = null;
		}
		return false;
	}
	
	/**
	 * 说明：获取指定系统指定登陆标识的登陆对象
	 * 
	 * @param con 数据库连接对象
	 * @param sysid 系统标识
	 * @param loginid 登陆标识
	 * @return
	 * @throws LawyerException
	 */
	public Login queryLogin(Connection con,String sysid,String loginid) throws LawyerException{
		String sql = "SELECT ID,USERID,NAME,PW,STATUS,SDATE,EDATE,ROLE,SYSID FROM " + LOGINTABLE+" WHERE ID='"+loginid+"' AND SYSID='"+sysid+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			Login login = null;
			while (result.next()) {
				login = new Login(sysid,result.getString("ID"));
				login.setName(result.getString("NAME"));
				login.setUserid(result.getString("USERID"));
				login.setPw(result.getString("PW"));
				login.setStatus(result.getString("STATUS"));
				login.setSdate(result.getDate("SDATE"));
				login.setEdate(result.getDate("EDATE"));
				break;
			}
			return login;
		} catch (SQLException e) {
			throw new LawyerException("Query Loigns is error! "+ e.getMessage());
		} finally {
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
	 * 说明：检测指定系统、指定登陆标识、指定密码的用户是否可以登陆
	 * 
	 * @param con 数据库连接
	 * @param sysid 系统标识
	 * @param loginid 登录标识
	 * @param pw 登陆密码
	 * @return
	 * @throws LawyerException
	 */
	public boolean checkLogin(Connection con,String sysid,String loginid,String pw)throws LawyerException{
		String sql = "SELECT ID,PW,SYSID FROM " + LOGINTABLE+" WHERE SYSID='"+sysid+"' AND ID='"+loginid+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {
				String pwvalue = result.getString("PW");
				if(pw.equals(pwvalue))
					return true;
			}
			return false;
		} catch (SQLException e) {
			throw new LawyerException("Query Loigns is error! "+ e.getMessage());
		} finally {
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
