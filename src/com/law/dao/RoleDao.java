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
 * ˵������ɫ����־û�����
 *
 */
public class RoleDao {
	private String ROLETABLE = "T_ROLE";
	
	/**
	 * ˵������ѯ����ϵͳ�Ľ�ɫ��ʶ
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param sysid ϵͳ��ʶ
	 * @return ��ɫ�б�
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
	 * ˵������ȡָ��ϵͳָ����ʶ�Ľ�ɫ����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param sysid ϵͳ��ʶ
	 * @param roleid ��ɫ��ʶ
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
	 * ˵�����洢�����Ľ�ɫ����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source ��ɫ����
	 * @throws LawyerException
	 */
	public void saveRole(Connection con,Role source) throws LawyerException{
		String sql = "INSERT INTO "+ROLETABLE+" (ID,NAME,DESCRIP,STATUS,SYSID) VALUES(?,?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
			psment.clearBatch();

			psment.setString(1,source.getId());
			psment.setString(2,source.getName());
			psment.setString(3,source.getDescript());
			psment.setString(4,source.getStatus());
			psment.setString(5,source.getSysid());
			
			psment.addBatch();
	        //ִ�����ݿ���봦��
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
	 * ˵�������¸����Ľ�ɫ����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source ��ɫ����
	 * @throws LawyerException
	 */
	public void updataRole(Connection con,Role source) throws LawyerException{
		String sql = "UPDATE "+ROLETABLE+" SET NAME=?,DESCRIP=?,STATUS=? WHERE ID='"+source.getId()+"' AND SYSID='"+source.getSysid()+"'";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
			psment.clearBatch();

			psment.setString(1,source.getName());
			psment.setString(2,source.getDescript());
			psment.setString(3,source.getStatus());
			
			psment.addBatch();
	        //ִ�����ݿ���봦��
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
	 * ˵����ɾ�������Ľ�ɫ����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source ��ɫ����
	 * @throws LawyerException
	 */
	public void deleteRole(Connection con,Role source) throws LawyerException{
		deleteRole(con, source.getId());
	}

	/**
	 * ˵����ɾ��ָ����ʶ�Ľ�ɫ
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param roleid ��ɫ��ʶ
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
	 * ˵�������ϵͳ�и����Ľ�ɫ�����Ƿ��Ѿ�����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param sysid ϵͳ��ʶ
	 * @param roleName ��ɫ����
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
	 * ˵������ȡ��ɫ��ʶ���ֵ
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @return ��ɫ��ʶ
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