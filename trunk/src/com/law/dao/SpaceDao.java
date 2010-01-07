package com.law.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.law.bean.Space;
import com.law.util.LawyerException;

/**
 * 说明：存储空间持久化处理
 *
 */
public class SpaceDao {
	private String SPACETABLE="T_SPACE";
	
	public void saveSpace(Connection con,Space source) throws LawyerException{
		String sql = "INSERT INTO "+SPACETABLE+" (ID,NAME,CREATOR,CDATE,SIZE,ISUSED) VALUES(?,?,?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
			psment.clearBatch();

			psment.setString(1,source.getId());
			psment.setString(2,source.getName());
			psment.setString(3,source.getCreator());
			psment.setDate(4,new java.sql.Date(new Date().getTime()));
			psment.setInt(5,50);
			psment.setString(6, "1");
			
			psment.addBatch();
	        //执行数据库插入处理
			psment.execute();			
			
		} catch (SQLException e) {
			throw new LawyerException("Save Space is error! " + e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
	
	/**
	 * 说明：获取系统的存储空间列表
	 * 
	 * @param con 数据库连接对象
	 * @param sysid 系统标识
	 * @return
	 * @throws LawyerException
	 */
	public List<Space> querySpaces(Connection con,String sysid) throws LawyerException{
		String sql = "SELECT ID,NAME,CREATOR,CDATE,SIZE,ISUSED FROM "+SPACETABLE;
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			List<Space> resultSet = new ArrayList<Space>();
			Space space = null;
			while (result.next()) {
				space = new Space(sysid,result.getString("ID"));
				space.setCreator(result.getString("CREATOR"));
				space.setName(result.getString("NAME"));
				
				resultSet.add(space);
			}
			return resultSet;
		} catch (SQLException e) {
			throw new LawyerException("Query Space is error! "+ e.getMessage());
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
	 * 说明：删除给定的存储空间
	 * 
	 * @param con 数据库连接对象
	 * @param source 存储空间对象
	 * @throws LawyerException
	 */
	public void deleteSpace(Connection con,Space source) throws LawyerException{
		deleteSpace(con, source.getId());
	}
	
	/**
	 * 说明：删除指定标识的存储空间对象
	 * 
	 * @param con 数据库连接对象
	 * @param sourceid 存储空间标识
	 * @throws LawyerException
	 */
	public void deleteSpace(Connection con,String sourceid) throws LawyerException{
		String sql ="DELETE "+SPACETABLE+" FROM "+SPACETABLE+" WHERE ID='"+sourceid+"'";
		Statement statement = null;
		try {
			statement = con.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			throw new LawyerException("Delete Space is error! "+ e.getMessage());
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}
	
	/**
	 * 说明：更新给定的存储空间
	 * 
	 * @param con 数据库连接对象
	 * @param source 存储空间对象
	 * @throws LawyerException
	 */
	public void updataSpace(Connection con,Space source) throws LawyerException{
		String sql = "UPDATE "+SPACETABLE+" SET (NAME=?,CREATOR=?,CDATA=?,SIZE=?,ISUSED=?) FROM "+SPACETABLE+" WHERE ID='"+source.getId()+"'";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
			psment.clearBatch();

			psment.setString(1,source.getName());
			psment.setString(2,source.getCreator());
			
			psment.addBatch();
	        //执行数据库插入处理
			psment.execute();			
			
		} catch (SQLException e) {
			throw new LawyerException("UPDATE Space is error! " + e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
}
