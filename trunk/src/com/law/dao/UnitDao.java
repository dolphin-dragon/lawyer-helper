package com.law.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.law.bean.Unit;
import com.law.util.LawyerException;

/**
 * 说明：组织结构节点持久化处理
 * 
 */
public class UnitDao {
	private String UNITTABLE="T_UNIT";
	
	/**
	 * 说明：获取指定系统的组织列表
	 * @param con
	 * @param sysid
	 * @return
	 * @throws LawyerException
	 */
	public List<Unit> querySysUnits(Connection con,String sysid) throws LawyerException{
		String sql = "SELECT DEPID,USERID,SDATE,EDATE,STATUS,SUPERDEPID FROM "+UNITTABLE+" WHERE SYSID='"+sysid+"'";
		Statement statement = null;
		try {
			ResultSet result = null;
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			List<Unit> resultSet = new ArrayList<Unit>();
			Unit unit = null;
			while (result.next()) {
				unit = new Unit(sysid,result.getString("DEPID"),result.getString("USERID"));
				unit.setSdate(result.getDate("SDATE"));
				unit.setEdate(result.getDate("EDATE"));
				unit.setStatus(result.getString("STATUS"));
				unit.setSuperdepid("");
				
				resultSet.add(unit);
			}
			return resultSet;
		} catch (SQLException e) {
			throw new LawyerException("Query Sys Units is error! "+ e.getMessage());
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}
	
	/**
	 * 说明：获取指定部门的得组织节点列表
	 * 
	 * @param con 数据库连接对象
	 * @param depid 部门标识
	 * @return 组织节点列表
	 * @throws LawyerException
	 */
	public List<Unit> queryUnit(Connection con,String sysid,String depid) throws LawyerException{
		String sql = "SELECT DEPID,USERID,SDATE,EDATE,STATUS,SUPERDEPID FROM "+UNITTABLE+" WHERE DEPID='"+depid+"' AND SYSID='"+sysid+"'";
		Statement statement = null;
		try {
			ResultSet result = null;
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			List<Unit> resultSet = new ArrayList<Unit>();
			Unit unit = null;
			while (result.next()) {
				unit = new Unit(sysid,result.getString("DEPID"),result.getString("USERID"));
				unit.setSdate(result.getDate("SDATE"));
				unit.setEdate(result.getDate("EDATE"));
				unit.setStatus(result.getString("STATUS"));
				unit.setSuperdepid(result.getString("SUPERDEPID"));
				
				resultSet.add(unit);
			}
			return resultSet;
		} catch (SQLException e) {
			throw new LawyerException("Query Unit is error! "+ e.getMessage());
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}
	
	/**
	 * 说明：存储给定的组织节点
	 * 
	 * @param con 数据库连接对象
	 * @param source 组织节点对象
	 * @throws LawyerException
	 * 
	 * example:
	 * MYSQL:
	 *   INSERT INTO table (a,b,c) VALUES (1,2,3),(4,5,6) ON DUPLICATE KEY UPDATE c=VALUES(a)+VALUES(b);
	 * ORACLE
	 *   MERGE INTO T T1 USING (SELECT '1001' AS a,2 AS b FROM dual) T2 ON ( T1.a=T2.a) WHEN MATCHED THEN UPDATE SET T1.b = T2.b WHEN NOT MATCHED THEN INSERT (a,b) VALUES(T2.a,T2.b);
	 * SQLServer
	 *   if exists(select 1 from T where T.a='1001' ) update T set T.b=2 Where T.a='1001' else insert into T(a,b) values('1001',2);
	 * 
	 */
	public void saveUnit(Connection con,Unit source) throws LawyerException{
		String sql = "INSERT INTO "+UNITTABLE+"(DEPID,USERID,SDATE,EDATE,STATUS,SUPERDEPID,SYSID) VALUES(?,?,?,?,?,?,?)ON DUPLICATE KEY UPDATE DEPID=? AND USERID=? AND SYSID=?";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
			psment.clearBatch();

			psment.setString(1,source.getDepid());
			psment.setString(2,source.getUserid());
			psment.setDate(3,new java.sql.Date(source.getSdate().getTime()));
			psment.setDate(4, new java.sql.Date(source.getEdate().getTime()));
			psment.setString(5, source.getStatus());
			psment.setString(6, source.getSuperdepid());
			psment.setString(7, source.getSysid());
			
			psment.setString(8, source.getDepid());
			psment.setString(9, source.getUserid());
			psment.setString(10, source.getSysid());
			
			psment.addBatch();
			
	        //执行数据库插入处理
			psment.execute();
		} catch (SQLException e) {
			throw new LawyerException("Save Unit is error! " + e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
	
	/**
	 * 说明：存储给定的组织节点列表
	 * 
	 * @param con
	 * @param sources
	 * @throws LawyerException
	 * 
	 * example:
	 * MYSQL:
	 *   INSERT INTO table (a,b,c) VALUES (1,2,3),(4,5,6) ON DUPLICATE KEY UPDATE c=VALUES(a)+VALUES(b);
	 * ORACLE
	 *   MERGE INTO T T1 USING (SELECT '1001' AS a,2 AS b FROM dual) T2 ON ( T1.a=T2.a) WHEN MATCHED THEN UPDATE SET T1.b = T2.b WHEN NOT MATCHED THEN INSERT (a,b) VALUES(T2.a,T2.b);
	 * SQLServer
	 *   if exists(select 1 from T where T.a='1001' ) update T set T.b=2 Where T.a='1001' else insert into T(a,b) values('1001',2);
	 * 
	 */
	public void saveUnits(Connection con,List<Unit> sources) throws LawyerException{
		String sql = "INSERT INTO "+UNITTABLE+"(DEPID,USERID,SDATE,EDATE,STATUS,SUPERDEPID,SYSID) VALUES(?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE DEPID=? AND USERID=? AND SYSID=?";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
			psment.clearBatch();
			for(int i = 0 ;i <sources.size(); i++){
				Unit source = sources.get(i);
				psment.setString(1,source.getDepid());
				psment.setString(2,source.getUserid());
				psment.setDate(3,new java.sql.Date(source.getSdate().getTime()));
				psment.setDate(4, new java.sql.Date(source.getEdate().getTime()));
				psment.setString(5, source.getStatus());
				psment.setString(6, source.getSuperdepid());
				psment.setString(7, source.getSysid());
				
				psment.setString(8, source.getDepid());
				psment.setString(9, source.getUserid());
				psment.setString(10, source.getSysid());
				
				psment.addBatch();	
			}			
	        //执行数据库插入处理
			psment.executeBatch();
		} catch (SQLException e) {
			throw new LawyerException("Save Units is error! " + e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
	
	/**
	 * 说明：删除当前部门下的一个用户
	 * 
	 * @param con 数据库连接对象
	 * @param depid 部门标识
	 * @param userid 用户标识
	 * @throws LawyerException
	 */
	public void deleteUnit(Connection con,String sysid,String depid,String userid) throws LawyerException{
		String sql = "DELETE "+UNITTABLE+" FROM "+UNITTABLE+" WHERE DEPID='"+depid+"' AND USERID='"+userid+"' AND SYSID='"+sysid+"'";
		Statement statement = null;
		try {
			statement = con.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			throw new LawyerException("Delete Unit of user is error! "+ e.getMessage());
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}	
}