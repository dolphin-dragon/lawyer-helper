package com.law.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.law.bean.Department;
import com.law.util.LawyerException;

/**
 * ˵����ϵͳ�ڲ��ų־û�����
 * 
 */
public class DeparmentDao {
	private String DEPTABLE="T_DEPARTMENT";
	/**
	 * ˵������ȡָ��ϵͳ�Ĳ����б�
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param sysid ϵͳ��ʶ
	 * @return ��ǰϵͳ�Ĳ����б�
	 * @throws LawyerException
	 */
	public List<Department> querySysDeps(Connection con,String sysid) throws LawyerException{
		String sql = "SELECT ID,NAME,STATUS,SDATE,EDATE,REMARKS,PRINCIPAl,SYSID FROM "+DEPTABLE+" WHERE SYSID='"+sysid+"'";
		Statement statment = null;
		ResultSet result = null;
		try {
			statment = con.createStatement();
			result = statment.executeQuery(sql);
			List<Department> resultset= new ArrayList<Department>();
			Department department = null;
			while (result.next()) {
				department = new Department(result.getString("SYSID"),result.getString("ID"));
				
				department.setName(result.getString("NAME"));
				department.setStatus(result.getString("STATUS"));
				department.setSdate(result.getDate("SDATE"));
				department.setEdate(result.getDate("EDATE"));
				department.setPrincipal(result.getString("PRINCIPAl"));
				department.setRemarks(result.getString("REMARKS"));
				
				resultset.add(department);
			}
			return resultset;
		} catch (SQLException e) {
			throw new LawyerException("Query Department is error! "	+ e.getMessage());
		}finally{
			try {
				result.close();
				statment.close();
			} catch (SQLException e) {
			}
			result = null;
			statment = null;
		}
	}
	
	/**
	 * ˵������ȡָ��ϵͳָ�����ű�ʶ�Ĳ��Ŷ���
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param sysid ϵͳ��ʶ
	 * @param depid ���ű�ʶ
	 * @return
	 * @throws LawyerException
	 */
	public Department queryDepartment(Connection con,String sysid,String depid) throws LawyerException{
		String sql = "SELECT ID,NAME,STATUS,SDATE,EDATE,REMARKS,PRINCIPAl,SYSID FROM "+DEPTABLE+" WHERE SYSID='"+sysid+"' AND ID='"+depid+"'";
		Statement statment = null;
		ResultSet result = null;
		try {
			statment = con.createStatement();
			result = statment.executeQuery(sql);		
			Department department = null;
			while (result.next()) {
				department = new Department(result.getString("SYSID"),result.getString("ID"));
				department.setName(result.getString("NAME"));
				department.setStatus(result.getString("STATUS"));
				department.setSdate(result.getDate("SDATE"));
				department.setEdate(result.getDate("EDATE"));
				department.setPrincipal(result.getString("PRINCIPAl"));
				department.setRemarks(result.getString("REMARKS"));
				break;
			}
			return department;
		
		} catch (SQLException e) {
			throw new LawyerException("Query Department is error! "	+ e.getMessage());
		}finally{
			try {
				result.close();
				statment.close();
			} catch (SQLException e) {
			}
			result = null;
			statment = null;
		}
	}
	
	/**
	 * ˵�����洢�����Ĳ��Ŷ���
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source ���Ŷ���
	 * @throws LawyerException
	 */
	public void saveDepartment(Connection con,Department source) throws LawyerException{
		String sql = "INSERT INTO "+DEPTABLE+"(ID,NAME,STATUS,SDATE,EDATE,REMARKS,PRINCIPAl,SYSID) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
			psment.clearBatch();

			psment.setString(1,source.getId());
			psment.setString(2,source.getName());
			psment.setString(3,source.getStatus());
			psment.setDate(4,null == source.getSdate() ? new java.sql.Date(new Date().getTime()): new java.sql.Date(source.getSdate().getTime()));
			psment.setDate(5,null == source.getEdate() ? new java.sql.Date(new Date().getTime()): new java.sql.Date(source.getEdate().getTime()));
			psment.setString(6, source.getRemarks());
			psment.setString(7,source.getPrincipal());
			psment.setString(8, source.getSysID());
			
			psment.addBatch();

	        //ִ�����ݿ���봦��
			psment.execute();			
		} catch (SQLException e) {
			throw new LawyerException("Save Department is error! "	+ e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
	
	/**
	 * ˵����ɾ�������Ĳ��Ŷ���
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source ���Ŷ���
	 * @throws LawyerException
	 */
	public void deleteDepartment(Connection con,Department source) throws LawyerException{
		deleteDepartment(con,source.getSysID(),source.getId());
	}
	
	/**
	 * ˵����ɾ������ϵͳ�ġ�ָ�����ű�ʶ�Ĳ���
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param sysid ϵͳ��ʶ
	 * @param depid ���ű�ʶ
	 * @throws LawyerException
	 */
	public void deleteDepartment(Connection con,String sysid,String depid) throws LawyerException{
		String sql = "DELETE "+DEPTABLE+" FROM "+DEPTABLE+" WHERE ID ='"+depid+"' AND SYSID ='"+sysid+"'";
		Statement statment = null;
		try {
			statment = con.createStatement();
			statment.execute(sql);
		} catch (SQLException e) {
			throw new LawyerException("Delete Department is error! " + e.getMessage());
		}finally{
			try {
				statment.close();
			} catch (SQLException e) {
			}
			statment = null;
		}
	}
	
	/**
	 * ˵������ȡϵͳ�е�ǰ���Ĳ��ű�ʶ
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @return ���ص�ǰ���ű��е�����ʶ��
	 * @throws LawyerException
	 */
	public String getMaxDepartmentID(Connection con) throws LawyerException {
		String sql = "SELECT MAX(ID) AS MAXID FROM " + DEPTABLE;
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
			return "DEP_000000";
		} catch (SQLException e) {
			throw new LawyerException("Get Department MAX ID is error! "	+ e.getMessage());
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
	 * ˵��������Ƿ���ָ��ϵͳ�д���ͬ������
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param systemid ϵͳ��ʶ
	 * @param depName ��������
	 * @return
	 * @throws LawyerException
	 */
	public boolean checkDepartment(Connection con,String systemid,String depName) throws LawyerException{
		String sql = "SELECT NAME FROM "+DEPTABLE+" WHERE SYSID='"+systemid+"' AND NAME='"+depName+"'";
		Statement statment = null;
		ResultSet result = null;
		try {
			statment = con.createStatement();
			result = statment.executeQuery(sql);
			while (result.next()) {
				String value = result.getString("NAME");
				if(null != value)
					return true;
			}
			return false;
		} catch (SQLException e) {
			throw new LawyerException("Check Department name exist is error! "	+ e.getMessage());
		}finally{
			try {
				result.close();
				statment.close();
			} catch (SQLException e) {
			}
			result = null;
			statment = null;
		}
	}
	
	/**
	 * ˵�������¸����Ĳ��Ŷ���
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source ���Ŷ���
	 * @throws LawyerException
	 */
	public void updateDepartment(Connection con,Department source) throws LawyerException{
		String sql = "UPDATE "+DEPTABLE+" SET NAME=?,STATUS=?,SDATE=?,EDATE=?,REMARKS=?,PRINCIPAl=? WHERE ID='"+source.getId()+"' AND SYSID='"+source.getSysID()+"'";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
			psment.clearBatch();

			psment.setString(1,source.getName());
			psment.setString(2,source.getStatus());
			psment.setDate(3,null == source.getSdate() ? new java.sql.Date(new Date().getTime()): new java.sql.Date(source.getSdate().getTime()));
			psment.setDate(4,null == source.getEdate() ? new java.sql.Date(new Date().getTime()): new java.sql.Date(source.getEdate().getTime()));
			psment.setString(5, source.getRemarks());
			psment.setString(6,source.getPrincipal());
			
			psment.addBatch();

	        //ִ�����ݿ���봦��
			psment.execute();			
		} catch (SQLException e) {
			throw new LawyerException("Update Department is error! "	+ e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
}