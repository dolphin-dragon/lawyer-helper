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
 * ˵����ϵͳ���û��ĳ־û�����
 *
 */
public class SysUserDao {
	private String SYSUSERTABLE="T_SYSUSER"; 
	
	/**
	 * ˵������ȡָ��ϵͳ��ϵͳ�ڲ��û��б�
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param sysid ϵͳ��ʶ
	 * @return ����ϵͳ�ڲ��û��б�
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
	 * ˵���������û���ʾ��ȡϵͳ�ڲ��û�����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param userid �û���ʶ
	 * @return ����ϵͳ�ڲ��û�����
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
	 * ˵�����洢������ϵͳ�ڲ��û�����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source ϵͳ�ڲ��û�����
	 * @throws LawyerException
	 */
	public void saveSysUser(Connection con,SysUser source) throws LawyerException{
		String sql = "INSERT INTO "+SYSUSERTABLE+"(ID,NAME,PHONE,SEX,EMAIL,BIRTHDAY,WSDATE,WEDATE,STATUS,AGE,SYSID,ADDRESS,MSN,QQ,NATIONALITY,POSITION,EDUCATION) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
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
	        //ִ�����ݿ���봦��
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
	 * ˵����ɾ��������ϵͳ�ڲ��û�����
	 * 
	 * @param con
	 * @param source
	 * @throws LawyerException
	 */
	public void deleteSysUser(Connection con,SysUser source) throws LawyerException{
		deleteSysUser(con, source.getSysid(),source.get_ID());
	}
	
	/**
	 * ˵����ɾ��ָ����ʶ��ϵͳ�ڲ��û�
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
	 * ˵�������¸�����ϵͳ�ڲ��û�����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source ϵͳ�ڲ��û�����
	 * @throws LawyerException
	 */
	public void updateSysUser(Connection con , SysUser source) throws LawyerException{
		String sql = "UPDATE "+SYSUSERTABLE+" SET NAME=?,PHONE=?,SEX=?,EMAIL=?,BIRTHDAY=?,WSDATE=?,WEDATE=?,STATUS=?,AGE=?,SYSID=?,ADDRESS=?,MSN=?,QQ=?,NATIONALITY=?,POSITION=?,EDUCATION=? WHERE ID='"+source.get_ID()+"' AND SYSID='"+source.getSysid()+"'";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
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
		
	        //ִ�����ݿ���봦��
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
	 * ˵������ȡϵͳ�е�ǰ���İ����������ʶ
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @return ���ص�ǰ����������е�����ʶ��
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