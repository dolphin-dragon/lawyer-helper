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
 * 说明：系统内部门持久化处理
 * 
 */
public class DeparmentDao {
	private String DEPTABLE="T_DEPARTMENT";
	/**
	 * 说明：获取指定系统的部门列表
	 * 
	 * @param con 数据库连接对象
	 * @param sysid 系统标识
	 * @return 当前系统的部门列表
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
	 * 说明：获取指定系统指定部门标识的部门对象
	 * 
	 * @param con 数据库连接对象
	 * @param sysid 系统标识
	 * @param depid 部门标识
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
	 * 说明：存储给定的部门对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 部门对象
	 * @throws LawyerException
	 */
	public void saveDepartment(Connection con,Department source) throws LawyerException{
		String sql = "INSERT INTO "+DEPTABLE+"(ID,NAME,STATUS,SDATE,EDATE,REMARKS,PRINCIPAl,SYSID) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
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

	        //执行数据库插入处理
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
	 * 说明：删除给定的部门对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 部门对象
	 * @throws LawyerException
	 */
	public void deleteDepartment(Connection con,Department source) throws LawyerException{
		deleteDepartment(con,source.getSysID(),source.getId());
	}
	
	/**
	 * 说明：删除给定系统的、指定部门标识的部门
	 * 
	 * @param con 数据库连接对象
	 * @param sysid 系统标识
	 * @param depid 部门标识
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
	 * 说明：获取系统中当前最大的部门标识
	 * 
	 * @param con 数据库连接对象
	 * @return 返回当前部门表中的最大标识符
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
	 * 说明：检查是否在指定系统中存在同名部门
	 * 
	 * @param con 数据库连接对象
	 * @param systemid 系统标识
	 * @param depName 部门名称
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
	 * 说明：更新给定的部门对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 部门对象
	 * @throws LawyerException
	 */
	public void updateDepartment(Connection con,Department source) throws LawyerException{
		String sql = "UPDATE "+DEPTABLE+" SET NAME=?,STATUS=?,SDATE=?,EDATE=?,REMARKS=?,PRINCIPAl=? WHERE ID='"+source.getId()+"' AND SYSID='"+source.getSysID()+"'";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
			psment.clearBatch();

			psment.setString(1,source.getName());
			psment.setString(2,source.getStatus());
			psment.setDate(3,null == source.getSdate() ? new java.sql.Date(new Date().getTime()): new java.sql.Date(source.getSdate().getTime()));
			psment.setDate(4,null == source.getEdate() ? new java.sql.Date(new Date().getTime()): new java.sql.Date(source.getEdate().getTime()));
			psment.setString(5, source.getRemarks());
			psment.setString(6,source.getPrincipal());
			
			psment.addBatch();

	        //执行数据库插入处理
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