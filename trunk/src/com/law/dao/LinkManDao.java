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
 * ˵������ϵ�˳־û�����
 *
 */
public class LinkManDao {
	private String CONTACTERTABLE = "T_CONTACTER";
	private String LINKMAINTABLE = "T_LINKMAN";	
	/**
	 * ˵������ѯָ���û���ָ����ϵ�����͵��б�
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
	 * ˵������ȡָ���û�ָ����ϵ�˷����µ���ϵ���б�
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param userid �û���ʶ
	 * @param linkgroup ��ϵ�˷����ʶ
	 * @return ��ϵ���б�
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
	 * ˵������ѯָ����ϵ�˱�ʶ����ϵ�˶���
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param linkmanid ��ϵ�˱�ʶ
	 * @return ��ϵ�˶���
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
	 * ˵������ȡϵͳ�е�ǰ������ϵ�˱�ʶ
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @return ���ص�ǰ����������е�����ʶ��
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
	 * ˵�����洢��������ϵ�˶���
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source ��ϵ�˶���
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
			 //�������
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
	        //ִ�����ݿ���봦��
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
	        //ִ�����ݿ���봦��
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
	 * ˵����ɾ����������ϵ�˶���
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source ��ϵ�˶���
	 * @throws LawyerException
	 */
	public void deleteLinkMan(Connection con,LinkMan source) throws LawyerException{
		deleteLinkMan(con, source.getId());
	}
	
	/**
	 * ˵����ɾ��ָ����ʶ����ϵ��
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param linkManid ��ϵ�˱�ʶ
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
	 * ˵��������ָ������ϵ�˶���
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source ��ϵ�˶���
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
			 //�������
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
	        //ִ�����ݿ���봦��
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
	        //ִ�����ݿ���봦��
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