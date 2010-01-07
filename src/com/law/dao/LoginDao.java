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
 * ˵����ϵͳ��¼�û��־û�����
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
			 //�������
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
	        //ִ�����ݿ���봦��
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
	 * ˵����ɾ�������ĵ�¼����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source ��¼����
	 * @throws LawyerException
	 */
	public void deleteLogin(Connection con,Login source) throws LawyerException{
		deleteLogin(con,source.getId());
		
	}
	
	/**
	 * ˵����ɾ��ָ����ʶ�ĵ�½����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param loginid ��¼��ʶ
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
	 * ˵�������¸����ĵ�½����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source ��¼����
	 * @throws LawyerException
	 */
	public void updataLogin(Connection con,Login source) throws LawyerException{
		String sql = "UPDATE " + LOGINTABLE+" SET (USERID=?,NAME=?,PW=?,STATUS=?,SDATE=?,EDATE=?,ROLE=?) FROM "+LOGINTABLE+" WHERE ID='"+source.getId()+"'";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
			psment.clearBatch();

			psment.setString(1,source.getUserid());
			psment.setString(2,source.getName());
			psment.setString(3,source.getPw());
			psment.setString(4,source.getStatus());
			psment.setDate(5,new java.sql.Date(source.getSdate().getTime()));
			psment.setDate(6,new java.sql.Date(source.getEdate().getTime()));
			psment.setString(7,Arrays.toString(source.getRole().toArray(new Role[]{})));
			
			psment.addBatch();
	        //ִ�����ݿ���봦��
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
	 * ˵�������������û���¼��ʶ�Ƿ���ڣ����ڷ���true�������ڷ���false
	 *
	 * @param con ���ݿ����Ӷ���
	 * @param loginid �û���¼��ʶ
	 * @return true��ʾ�˵�¼ID���ڣ�false��ʾ�˵�¼ID������
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
	 * ˵������ȡָ��ϵͳָ����½��ʶ�ĵ�½����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param sysid ϵͳ��ʶ
	 * @param loginid ��½��ʶ
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
	 * ˵�������ָ��ϵͳ��ָ����½��ʶ��ָ��������û��Ƿ���Ե�½
	 * 
	 * @param con ���ݿ�����
	 * @param sysid ϵͳ��ʶ
	 * @param loginid ��¼��ʶ
	 * @param pw ��½����
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
