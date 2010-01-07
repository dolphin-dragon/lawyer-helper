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
 * 说明：对联系人分组进行持久处理
 * 
 */
public class ContacterGroupDao {
	private String CGTABLE="T_CONTACT_GROUP";
	/**
	 * 说明：获取指定系统标识下指定用户标识的联系人分组列表
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
	 * 说明：存储给定的联系人分组对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 联系人分组对象
	 * @throws LawyerException
	 */
	public void saveContacterGroup(Connection con,ContacterGroup source) throws LawyerException{
		String sql = "INSERT INTO "+CGTABLE+"(ID,NAME,STATUS,CREATOR,SYSID) VALUES(?,?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
			psment.clearBatch();

			psment.setString(1,source.getId());
			psment.setString(2,source.getName());
			psment.setString(3,source.getStatus());
			psment.setString(4,source.getCreatorid());
			
			psment.addBatch();

	        //执行数据库插入处理
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
	 * 说明：删除给定的联系人分组对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 联系人分组对性
	 * @throws LawyerException
	 */
	public void deleteContacterGroup(Connection con,ContacterGroup source) throws LawyerException{
		deleteContacterGroup(con, source.getSysid(), source.getId());
	}
	
	/**
	 * 说明：删除指定系统下的联系人分组
	 * 
	 * @param con 数据库连接对象
	 * @param sysid 系统标识
	 * @param groupid 分组标识
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
	 * 说明：删除系统中指定用户指定分组标识的分组对象
	 * 
	 * @param con 数据库连接
	 * @param sysid 系统标识
	 * @param userid 用户标识
	 * @param groupid 分组标识
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
	 * 说明：更新指定的分组对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 分组对象
	 * @throws LawyerException
	 */
	public void updateContacterGroup(Connection con,ContacterGroup source) throws LawyerException{
		PreparedStatement pstmt = null;
		try {
			String sql = "UPDATE "+CGTABLE+" SET NAME=?,STATUS=?,CREATOR=? WHERE ID=? AND SYSID=?";	
			pstmt = con.prepareStatement(sql);
			// 清除参数
			pstmt.clearBatch();
			
			pstmt.setString(1, source.getName());
			pstmt.setString(2, source.getStatus());
			pstmt.setString(3, source.getCreatorid());
			pstmt.setString(4, source.getId());
			pstmt.setString(5, source.getSysid());
			
			pstmt.addBatch();

			// 执行数据库插入处理
			pstmt.execute();
		} catch (SQLException e) {
			throw new LawyerException("update Contacter Group is error! "	+ e.getMessage());
		} finally {
			// 关闭会话
			try {
				pstmt.close();
			} catch (SQLException e) {
				pstmt = null;
			}
			pstmt = null;
		}
	}

	/**
	 * 说明：判断系统中当前用户创建的分组名称是否存在
	 * 
	 * @param con 数据库连接对象
	 * @param sysid 系统标识
	 * @param userid 用户标识
	 * @param gname 联系人分组名称
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
	 * 说明：获取系统中当前最大的联系人分组标识
	 * 
	 * @param con 数据库连接对象
	 * @return 返回当前联系人分组的最大标识符
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