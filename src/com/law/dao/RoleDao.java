package com.law.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.law.bean.Role;
import com.law.util.LawyerException;

/**
 * 说明：角色对象持久化处理
 *
 */
public class RoleDao {
	private String ROLETABLE = "T_ROLE";
	
	/**
	 * 说明：查询给定系统的角色标识
	 * 
	 * @param con 数据库连接对象
	 * @param sysid 系统标识
	 * @return 角色列表
	 * @throws LawyerException
	 */
	public List<Role> querySysRoles(Connection con,String sysid) throws LawyerException{
		String sql = "SELECT ID,NAME,DESCRIP,STATUS,SYSID FROM "+ROLETABLE+" WHERE SYSID='"+sysid+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			List<Role> resultSet = new ArrayList<Role>();
			Role role = null;
			while (result.next()) {
				role = new Role(sysid,result.getString("ID"));
				role.setDescript(result.getString("DESCRIP"));
				role.setName(result.getString("NAME"));
				role.setStatus(result.getString("STATUS"));
				resultSet.add(role);
			}
			return resultSet;
		} catch (SQLException e) {
			throw new LawyerException("Query Roles is error! "+ e.getMessage());
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
	 * 说明：获取指定系统指定标识的角色对象
	 * 
	 * @param con 数据库连接对象
	 * @param sysid 系统标识
	 * @param roleid 角色标识
	 * @return
	 * @throws LawyerException
	 */
	public Role queryRole(Connection con,String sysid,String roleid) throws LawyerException{
		String sql = "SELECT ID,NAME,DESCRIP,STATUS,SYSID FROM "+ROLETABLE+" WHERE SYSID='"+sysid+"' AND ID='"+roleid+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			
			Role role = null;
			while (result.next()) {
				role = new Role(sysid,result.getString("ID"));
				role.setDescript(result.getString("DESCRIP"));
				role.setName(result.getString("NAME"));
				role.setStatus(result.getString("STATUS"));
				break;
			}
			return role;
		} catch (SQLException e) {
			throw new LawyerException("Query Role is error! "+ e.getMessage());
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
	 * 说明：存储给定的角色对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 角色对象
	 * @throws LawyerException
	 */
	public void saveRole(Connection con,Role source) throws LawyerException{
		String sql = "INSERT INTO "+ROLETABLE+" (ID,NAME,DESCRIP,STATUS,SYSID) VALUES(?,?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
			psment.clearBatch();

			psment.setString(1,source.getId());
			psment.setString(2,source.getName());
			psment.setString(3,source.getDescript());
			psment.setString(4,source.getStatus());
			psment.setString(5,source.getSysid());
			
			psment.addBatch();
	        //执行数据库插入处理
			psment.execute();			
			
		} catch (SQLException e) {
			throw new LawyerException("Save Role is error! " + e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
	
	/**
	 * 说明：更新给定的角色对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 角色对象
	 * @throws LawyerException
	 */
	public void updataRole(Connection con,Role source) throws LawyerException{
		String sql = "UPDATE "+ROLETABLE+" SET NAME=?,DESCRIP=?,STATUS=? WHERE ID='"+source.getId()+"' AND SYSID='"+source.getSysid()+"'";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
			psment.clearBatch();

			psment.setString(1,source.getName());
			psment.setString(2,source.getDescript());
			psment.setString(3,source.getStatus());
			
			psment.addBatch();
	        //执行数据库插入处理
			psment.execute();
		} catch (SQLException e) {
			throw new LawyerException("UPDATE Role is error! " + e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
	
	/**
	 * 说明：删除给定的角色对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 角色对象
	 * @throws LawyerException
	 */
	public void deleteRole(Connection con,Role source) throws LawyerException{
		deleteRole(con, source.getId());
	}

	/**
	 * 说明：删除指定标识的角色
	 * 
	 * @param con 数据库连接对象
	 * @param roleid 角色标识
	 * @throws LawyerException
	 */
	public void deleteRole(Connection con,String roleid) throws LawyerException{
		String sql = "DELETE "+ROLETABLE+" FROM "+ROLETABLE+" WHERE ID='"+roleid+"'";
		Statement statement = null;
		try {
			statement = con.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			throw new LawyerException("Delete Role by id is error! "+ e.getMessage());
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}

	/**
	 * 说明：检查系统中给定的角色名称是否已经存在
	 * 
	 * @param con 数据库连接对象
	 * @param sysid 系统标识
	 * @param roleName 角色名称
	 * @return
	 * @throws LawyerException
	 */
	public boolean ckeckRoleNameExist(Connection con,String sysid,String roleName) throws LawyerException {
		String sql = "SELECT ID,NAME FROM "+ROLETABLE+" WHERE SYSID='"+sysid+"' AND NAME='"+roleName+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			throw new LawyerException("Check Role name is exist error! "+ e.getMessage());
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
	 * 说明：获取角色标识最大值
	 * 
	 * @param con 数据库连接对象
	 * @return 角色标识
	 * @throws LawyerException
	 */
	public String getMaxRoleID(Connection con) throws LawyerException {
		String sql = "SELECT MAX(ID) AS MAXID FROM " + ROLETABLE;
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
			return "RO_0000000";
		} catch (SQLException e) {
			throw new LawyerException("Get Max Role ID is error! "	+ e.getMessage());
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