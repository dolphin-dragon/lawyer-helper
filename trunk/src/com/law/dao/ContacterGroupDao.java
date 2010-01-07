package com.law.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.law.bean.ContacterGroup;
import com.law.util.LawyerException;

/**
 * ˵��������ϵ�˷�����г־ô���
 * 
 */
public class ContacterGroupDao {
	private String CGTABLE="T_CONTACT_GROUP";
	/**
	 * ˵������ȡָ��ϵͳ��ʶ��ָ���û���ʶ����ϵ�˷����б�
	 * 
	 * @param con 
	 * @param userid
	 * @return
	 * @throws LawyerException
	 */
	public List<ContacterGroup> queryContacterGroupByUser(Connection con,String sysid, String userid) throws LawyerException{
		String sql = "SElECT ID,NAME,STATUS,CREATOR,SYSID FROM "+CGTABLE+" WHERE CREATOR='"+userid+"'";
		Statement statment = null;
		ResultSet result = null;
		try {
			statment = con.createStatement();
			result = statment.executeQuery(sql);
			List<ContacterGroup> resultset= new ArrayList<ContacterGroup>();
			ContacterGroup cgroup = null;
			while (result.next()) {
				cgroup = new ContacterGroup(sysid,userid,result.getString("ID"));
				cgroup.setCreator(result.getString("CREATOR"));
				cgroup.setCreatorid(result.getString("CREATOR"));
				cgroup.setName(result.getString("NAME"));
				cgroup.setStatus(result.getString("STATUS"));
				
				resultset.add(cgroup);
			}
			return resultset;
		} catch (SQLException e) {
			throw new LawyerException("Query Contacter Groups is error! "	+ e.getMessage());
		}finally{
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
	 * ˵�����洢��������ϵ�˷������
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source ��ϵ�˷������
	 * @throws LawyerException
	 */
	public void saveContacterGroup(Connection con,ContacterGroup source) throws LawyerException{
		String sql = "INSERT INTO "+CGTABLE+"(ID,NAME,STATUS,CREATOR,SYSID) VALUES(?,?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
			psment.clearBatch();

			psment.setString(1,source.getId());
			psment.setString(2,source.getName());
			psment.setString(3,source.getStatus());
			psment.setString(4,source.getCreatorid());
			
			psment.addBatch();

	        //ִ�����ݿ���봦��
			psment.execute();			
		} catch (SQLException e) {
			throw new LawyerException("Save Contacter Groups is error! "	+ e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
	
	/**
	 * ˵����ɾ����������ϵ�˷������
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source ��ϵ�˷������
	 * @throws LawyerException
	 */
	public void deleteContacterGroup(Connection con,ContacterGroup source) throws LawyerException{
		deleteContacterGroup(con, source.getSysid(), source.getId());
	}
	
	/**
	 * ˵����ɾ��ָ��ϵͳ�µ���ϵ�˷���
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param sysid ϵͳ��ʶ
	 * @param groupid �����ʶ
	 * @throws LawyerException
	 */
	public void deleteContacterGroup(Connection con,String sysid,String groupid) throws LawyerException{
		String sql = "DELETE "+CGTABLE+" FROM "+CGTABLE+" WHERER ID='"+groupid+"' AND SYSID='"+sysid+"'";
		Statement statment = null;
		try {
			statment = con.createStatement();
			statment.execute(sql);
		} catch (SQLException e) {
			throw new LawyerException("Delete Contacter Groups is error! "	+ e.getMessage());
		}finally{
			try {
				statment.close();
			} catch (SQLException e) {
				statment = null;
			}
		}
	}
	
	/**
	 * ˵����ɾ��ϵͳ��ָ���û�ָ�������ʶ�ķ������
	 * 
	 * @param con ���ݿ�����
	 * @param sysid ϵͳ��ʶ
	 * @param userid �û���ʶ
	 * @param groupid �����ʶ
	 * @throws LawyerException
	 */
	public void deleteContacterGroup(Connection con,String sysid,String userid,String groupid) throws LawyerException{
		String sql = "DELETE "+CGTABLE+" FROM "+CGTABLE+" WHERER ID='"+groupid+"' AND SYSID='"+sysid+"' AND CREATOR='"+userid+"'";
		Statement statment = null;
		try {
			statment = con.createStatement();
			statment.execute(sql);
		} catch (SQLException e) {
			throw new LawyerException("Delete Contacter Groups is error! "	+ e.getMessage());
		}finally{
			try {
				statment.close();
			} catch (SQLException e) {
				statment = null;
			}
		}
	}
	
	/**
	 * ˵��������ָ���ķ������
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source �������
	 * @throws LawyerException
	 */
	public void updateContacterGroup(Connection con,ContacterGroup source) throws LawyerException{
		PreparedStatement pstmt = null;
		try {
			String sql = "UPDATE "+CGTABLE+" SET NAME=?,STATUS=?,CREATOR=? WHERE ID=? AND SYSID=?";	
			pstmt = con.prepareStatement(sql);
			// �������
			pstmt.clearBatch();
			
			pstmt.setString(1, source.getName());
			pstmt.setString(2, source.getStatus());
			pstmt.setString(3, source.getCreatorid());
			pstmt.setString(4, source.getId());
			pstmt.setString(5, source.getSysid());
			
			pstmt.addBatch();

			// ִ�����ݿ���봦��
			pstmt.execute();
		} catch (SQLException e) {
			throw new LawyerException("update Contacter Group is error! "	+ e.getMessage());
		} finally {
			// �رջỰ
			try {
				pstmt.close();
			} catch (SQLException e) {
				pstmt = null;
			}
			pstmt = null;
		}
	}

	/**
	 * ˵�����ж�ϵͳ�е�ǰ�û������ķ��������Ƿ����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param sysid ϵͳ��ʶ
	 * @param userid �û���ʶ
	 * @param gname ��ϵ�˷�������
	 * @return
	 * @throws LawyerException
	 */
	public boolean checkNameExist(Connection con,String sysid,String userid,String gname) throws LawyerException{
		String sql = "SELECT NAME FROM "+CGTABLE+" WHERE CREATOR='"+userid+"' AND NAME = '"+gname+"' AND SYSID='"+sysid+"'";
		Statement statment = null;
		ResultSet result = null;
		try {
			statment = con.createStatement();
			result = statment.executeQuery(sql);
			while(result.next()){
				String value = result.getString("NAME");
				if(null != value)
					return true;
			}
		} catch (SQLException e) {
			throw new LawyerException("Check Contacter Group name exist is error! "	+ e.getMessage());
		}finally{
			try {
				result.close();
				statment.close();
			} catch (SQLException e) {
			}
			result = null;
			statment = null;
		}
		return false;
	}

	/**
	 * ˵������ȡϵͳ�е�ǰ������ϵ�˷����ʶ
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @return ���ص�ǰ��ϵ�˷��������ʶ��
	 * @throws LawyerException
	 */
	public String getMaxContacterGroupID(Connection con) throws LawyerException {
		String sql = "SELECT MAX(ID) AS MAXID FROM " + CGTABLE;
		Statement statment = null;
		ResultSet result = null;
		try {
			statment = con.createStatement();
			result = statment.executeQuery(sql);
			String value = "";
			while (result.next()) {
				value = result.getString("MAXID");
				if(null != value )
				return value;
			}
			return "CG_0000000";
		} catch (SQLException e) {
			throw new LawyerException("add Cases Source is error! "	+ e.getMessage());
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
	
	public String getMaxContacterGroupID(Connection con,String sysid) throws LawyerException {
		throw new LawyerException("The method isn't support!");
	}
}