package com.law.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.law.bean.DossierReport;
import com.law.util.LawyerException;

/**
 * 说明：案件案卷报告持久化处理
 *
 */
public class DossierReportDao {
	private String DOSSIERREPORTTABLE="T_CASEREPORT";
	
	/**
	 * 说明：获取指定案件案卷的报告列表
	 * 
	 * @param con 数据库连接对象
	 * @param dossierid 案件案卷标识
	 * @return 案件案卷报告列表
	 * @throws LawyerException
	 */
	public List<DossierReport> queryDossierReports(Connection con,String dossierid) throws LawyerException{
		String sql = "SELECT DATE,REPORTOR,STAGE,DOSSIERID,REPORTID,CONTENT,TITLE FROM "+DOSSIERREPORTTABLE+" WHERE DOSSIERID='"+dossierid+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			List<DossierReport> resultSet = new ArrayList<DossierReport>();
			DossierReport dossierReport = null;
			while(result.next()){
				dossierReport = new DossierReport(result.getString("REPORTID"));

				dossierReport.setContent(result.getString("CONTENT"));
				dossierReport.setDossierID(result.getString("DOSSIERID"));
				dossierReport.setReportDate(result.getDate("DATE"));
				dossierReport.setStage(result.getString("STAGE"));
				dossierReport.setTitle(result.getString("TITLE"));
				dossierReport.setReportor(result.getString("REPORTOR"));

				resultSet.add(dossierReport);
			}
			return resultSet;
		} catch (SQLException e) {
			throw new LawyerException("Query Dossier Reports is error! " + e.getMessage());
		}finally{
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
	 * 说明：存储给定的案件报告对象
	 * 
	 * @param con 数据库连接对象
	 * @param source
	 * @throws LawyerException
	 */
	public void saveDossierReport(Connection con , DossierReport source) throws LawyerException{
		String sql = "INSERT INTO "+DOSSIERREPORTTABLE+"(DATE,REPORTOR,STAGE,DOSSIERID,REPORTID,CONTENT,TITLE) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //清除参数
			psment.clearBatch();

			psment.setDate(1,new java.sql.Date(source.getReportDate().getTime()));
			psment.setString(2,source.getReportor());
			psment.setString(3,source.getStage());
			psment.setString(4,source.getDossierID());
			psment.setString(5,source.getReportID());
			psment.setString(6, source.getContent());
			psment.setString(7,source.getTitle());
			
			psment.addBatch();
	        //执行数据库插入处理
			psment.execute();			
		} catch (SQLException e) {
			throw new LawyerException("Save Doc Catalog is error! "	+ e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
		
	}

	/**
	 * 说明：删除给定的案件案卷报告对象
	 * 
	 * @param con 数据库连接对象
	 * @param source 案件案卷报告对象
	 * @throws LawyerException
	 */
	public void deleteDossierReport(Connection con,DossierReport source) throws LawyerException{
		String sql = "DELETE "+DOSSIERREPORTTABLE+" FROM "+DOSSIERREPORTTABLE+" WHERE REPORTID='"+source.getReportID()+"'";
		Statement statement = null;
		try {
			statement = con.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			throw new LawyerException("Query Dossier Reports is error! " + e.getMessage());
		}finally{
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}
	
	public void deleteDossierReport(Connection con,String dossierReportID) throws LawyerException{
		String sql = "DELETE "+DOSSIERREPORTTABLE+" FROM "+DOSSIERREPORTTABLE+" WHERE REPORTID='"+dossierReportID+"'";
		Statement statement = null;
		try {
			statement = con.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			throw new LawyerException("Query Dossier Reports is error! " + e.getMessage());
		}finally{
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}

	/**
	 * 说明：查询指定的标识的案件案卷报告对象
	 * 
	 * @param con 数据库连接对象
	 * @param dossierReportID 案件案卷报告标识
	 * @return 案件案卷报告对象
	 * @throws LawyerException
	 */
	public DossierReport queryDossierReport(Connection con,String dossierReportID) throws LawyerException{
		String sql = "SELECT DATE,REPORTOR,STAGE,DOSSIERID,REPORTID,CONTENT,TITLE FROM "+DOSSIERREPORTTABLE+" WHERE REPORTID='"+dossierReportID+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
		
			DossierReport dossierReport = null;
			while(result.next()){
				dossierReport = new DossierReport(result.getString("REPORTID"));

				dossierReport.setContent(result.getString("CONTENT"));
				dossierReport.setDossierID(result.getString("DOSSIERID"));
				dossierReport.setReportDate(result.getDate("DATE"));
				dossierReport.setStage(result.getString("STAGE"));
				dossierReport.setTitle(result.getString("TITLE"));
				dossierReport.setReportor(result.getString("REPORTOR"));
				break;		
			}
			return dossierReport;
		} catch (SQLException e) {
			throw new LawyerException("Query Dossier Reports is error! " + e.getMessage());
		}finally{
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
	 * 说明：获取系统中当前最大的案件案卷报告标识
	 * 
	 * @param con 数据库连接对象
	 * @return 返回当前案件案卷表中的最大标识符
	 * @throws LawyerException
	 */
	public String getMaxDossierReportID(Connection con) throws LawyerException {
		String sql = "SELECT MAX(REPORTID) AS MAXID FROM " + DOSSIERREPORTTABLE;
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
			return "RE_0000000";
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
}