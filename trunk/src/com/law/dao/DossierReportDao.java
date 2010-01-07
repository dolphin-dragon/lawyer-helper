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
 * ˵��������������־û�����
 *
 */
public class DossierReportDao {
	private String DOSSIERREPORTTABLE="T_CASEREPORT";
	
	/**
	 * ˵������ȡָ����������ı����б�
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param dossierid ���������ʶ
	 * @return �����������б�
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
	 * ˵�����洢�����İ����������
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source
	 * @throws LawyerException
	 */
	public void saveDossierReport(Connection con , DossierReport source) throws LawyerException{
		String sql = "INSERT INTO "+DOSSIERREPORTTABLE+"(DATE,REPORTOR,STAGE,DOSSIERID,REPORTID,CONTENT,TITLE) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
			psment.clearBatch();

			psment.setDate(1,new java.sql.Date(source.getReportDate().getTime()));
			psment.setString(2,source.getReportor());
			psment.setString(3,source.getStage());
			psment.setString(4,source.getDossierID());
			psment.setString(5,source.getReportID());
			psment.setString(6, source.getContent());
			psment.setString(7,source.getTitle());
			
			psment.addBatch();
	        //ִ�����ݿ���봦��
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
	 * ˵����ɾ�������İ������������
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source �������������
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
	 * ˵������ѯָ���ı�ʶ�İ������������
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param dossierReportID �����������ʶ
	 * @return �������������
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
	 * ˵������ȡϵͳ�е�ǰ���İ����������ʶ
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @return ���ص�ǰ����������е�����ʶ��
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