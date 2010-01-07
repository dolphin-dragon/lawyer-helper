package com.law.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.law.bean.Dossier;
import com.law.util.LawyerException;

/**
 * ˵�����־û�������������
 *
 */
public class DossierDao {
	private String DOSSIRETABLE="T_CASE_DOSSIER";
	/**
	 * ˵������ȡָ���û��İ��������б�
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param userid �û���ʶ
	 * @return �û������б�
	 * @throws LawyerException
	 */
	public List<Dossier> queryUserDossiers(Connection con,String sysid,String userid) throws LawyerException{
		String sql = "SELECT ID,NAME,CREATOR,CDATE,MODIFYOR,MDATE,DEPENDCASE,EDATE,TYPE," +
				"SYSID,STATUS,CODE,TARGET,CHARGE,PARTY,PARTY_STATUS,MLAWYER,SLAWYER," +
				"ADMISSIONTYPE,ARCHIVEDATE,JUDGE,ISAID,ISFOREIGN,JUDICIALTYPE,BRIEF,SUMMARY FROM "+DOSSIRETABLE+" WHERE CREATOR='"+userid+"' AND SYSID='"+sysid+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			List<Dossier> resultSet = new ArrayList<Dossier>();
			Dossier dossier = null;
			//ID,NAME,CREATOR,CDATE,MODIFYOR,MDATE,DEPENDCASE,EDATE,TYPE,SYSID,STATUS,CODE,TARGET,CHARGE,PARTY,PARTY_STATUS,MLAWYER,SLAWYER,ADMISSIONTYPE,ARCHIVEDATE,JUDGE,ISAID,ISFOREIGN,JUDICIALTYPE,BRIEF,SUMMARY
			while(result.next()){
				dossier = new Dossier(result.getString("SYSID"),result.getString("ID"),result.getString("CODE"),result.getString("NAME"));
				dossier.setName(result.getString("NAME"));
				dossier.setCreator(result.getString("CREATOR"));
				dossier.setcDate(result.getDate("CDATE"));
				dossier.setModify(result.getString("MODIFYOR"));
				dossier.setmDate(result.getDate("MDATE"));
				dossier.setDependcase(result.getString("DEPENDCASE"));
				dossier.seteDate(result.getDate("EDATE"));
				dossier.setType(result.getString("TYPE"));
				dossier.setParty(result.getString("PARTY"));
				dossier.setParty_status(result.getString("PARTY_STATUS"));				
				dossier.setMlawyer(result.getString("MLAWYER"));
				dossier.setSlawyer(result.getString("SLAWYER"));
				dossier.setStatus(result.getString("STATUS"));
				dossier.setAdmissionType(result.getString("ADMISSIONTYPE"));
				dossier.setArchiveDate(result.getDate("ARCHIVEDATE"));
				dossier.setBrief(result.getString("BRIEF"));
				dossier.setIsaid(result.getString("ISAID"));
				dossier.setIsforeign(result.getString("ISFOREIGN"));
				dossier.setJudge(result.getString("JUDGE"));
				dossier.setJudicialtype(result.getString("JUDICIALTYPE"));
				dossier.setSummary(result.getString("SUMMARY"));
				dossier.setTaget(result.getInt("TARGET"));
				dossier.setCharge(result.getInt("CHARGE"));
				
				resultSet.add(dossier);
			}
			return resultSet;
		} catch (SQLException e) {
			throw new LawyerException("Query User Dossier is error! "	+ e.getMessage());
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
	 * ˵������ȡָ��ϵͳָ����ʶ�İ����������
	 * 
	 * @param con ���ݿ�����
	 * @param sysid ϵͳ��ʶ
	 * @param dossierid ���������ʶ
	 * @return
	 * @throws LawyerException
	 */
	public Dossier queryDossier(Connection con,String sysid,String dossierid) throws LawyerException{
		String sql = "SELECT ID,NAME,CREATOR,CDATE,MODIFYOR,MDATE,DEPENDCASE,EDATE,TYPE,SYSID,STATUS,CODE,TARGET,CHARGE,PARTY,PARTY_STATUS,MLAWYER,SLAWYER,ADMISSIONTYPE,ARCHIVEDATE,JUDGE,ISAID,ISFOREIGN,JUDICIALTYPE,BRIEF,SUMMARY FROM "
			+DOSSIRETABLE+" WHERE ID='"+dossierid+"' AND SYSID='"+sysid+"'";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			Dossier dossier = null;
			//ID,NAME,CREATOR,CDATE,MODIFYOR,MDATE,DEPENDCASE,EDATE,TYPE,SYSID,STATUS,CODE,TARGET,CHARGE,PARTY,PARTY_STATUS,MLAWYER,SLAWYER,ADMISSIONTYPE,ARCHIVEDATE,JUDGE,ISAID,ISFOREIGN,JUDICIALTYPE,BRIEF,SUMMARY
			while(result.next()){
				dossier = new Dossier(result.getString("SYSID"),result.getString("ID"),result.getString("CODE"),result.getString("NAME"));
				dossier.setName(result.getString("NAME"));
				dossier.setCreator(result.getString("CREATOR"));
				dossier.setcDate(result.getDate("CDATE"));
				dossier.setModify(result.getString("MODIFYOR"));
				dossier.setmDate(result.getDate("MDATE"));
				dossier.setDependcase(result.getString("DEPENDCASE"));
				dossier.seteDate(result.getDate("EDATE"));
				dossier.setType(result.getString("TYPE"));
				dossier.setParty(result.getString("PARTY"));
				dossier.setParty_status(result.getString("PARTY_STATUS"));				
				dossier.setMlawyer(result.getString("MLAWYER"));
				dossier.setSlawyer(result.getString("SLAWYER"));
				dossier.setStatus(result.getString("STATUS"));
				dossier.setAdmissionType(result.getString("ADMISSIONTYPE"));
				dossier.setArchiveDate(result.getDate("ARCHIVEDATE"));
				dossier.setBrief(result.getString("BRIEF"));
				dossier.setIsaid(result.getString("ISAID"));
				dossier.setIsforeign(result.getString("ISFOREIGN"));
				dossier.setJudge(result.getString("JUDGE"));
				dossier.setJudicialtype(result.getString("JUDICIALTYPE"));
				dossier.setSummary(result.getString("SUMMARY"));
				dossier.setTaget(result.getInt("TARGET"));
				dossier.setCharge(result.getInt("CHARGE"));
				
				break;
			}
			return dossier;
		} catch (SQLException e) {
			throw new LawyerException("Query Dossier is error! "	+ e.getMessage());
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
	 * ˵�������¸����İ�������
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source �����������
	 * @throws LawyerException
	 */
	public void updateDossier(Connection con,Dossier source) throws LawyerException{
		
		String sql = "UPDATE "+DOSSIRETABLE+" SET " +
				"NAME=?,CREATOR=?,CDATE=?,MODIFYOR=?,MDATE=?,DEPENDCASE=?,EDATE=?,TYPE=?,SYSID=?,STATUS=?," +
				"CODE=?,TARGET=?,CHARGE=?,PARTY=?,PARTY_STATUS=?,MLAWYER=?,SLAWYER=?,ADMISSIONTYPE=?,ARCHIVEDATE=?,JUDGE=?,ISAID=?," +
				"ISFOREIGN=?,JUDICIALTYPE=?,BRIEF=?,SUMMARY=? WHERE ID=? AND SYSID=? ";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
			psment.clearBatch();

			psment.setString(1,source.getName());
			psment.setString(2,source.getCreator());
			psment.setDate(3,null == source.getcDate() ? null : new java.sql.Date(source.getcDate().getTime()));
			psment.setString(4,source.getModify());
			psment.setDate(5,null == source.getmDate() ? null : new java.sql.Date(source.getmDate().getTime()));
			psment.setString(6, source.getDependcase());
			psment.setDate(7,null == source.geteDate() ? null : new java.sql.Date(source.geteDate().getTime()));
			psment.setString(8, source.getType());
			psment.setString(9,source.getSysid());
			psment.setString(10, source.getStatus());
			psment.setString(11, source.getCode());
			
			psment.setInt(12, source.getTaget());			
			psment.setInt(13,source.getCharge());
			psment.setString(14, source.getParty());
			psment.setString(15, source.getParty_status());
			psment.setString(16, source.getMlawyer());
			psment.setString(17, source.getSlawyer());
			psment.setString(18, source.getAdmissionType());
			psment.setDate(19, null == source.getArchiveDate() ? null : new java.sql.Date(source.getArchiveDate().getTime()));
			psment.setString(20, source.getJudge());
			psment.setString(21, source.getIsaid());
			psment.setString(22, source.getIsforeign());
			psment.setString(23,source.getJudicialtype());
			psment.setString(24, source.getBrief());
			psment.setString(25, source.getSummary());
			
			psment.setString(26, source.getId());
			psment.setString(27, source.getSysid());
			
			psment.addBatch();
	        //ִ�����ݿ���봦��
			psment.execute();			
		} catch (SQLException e) {
			throw new LawyerException("Update Dossier is error! " + e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
	
	/**
	 * ˵�����洢�����İ�������
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source ������Դ����
	 * @throws LawyerException
	 */
	public void saveDossier(Connection con,Dossier source) throws LawyerException{
		String sql = "INSERT INTO "+DOSSIRETABLE+"(NAME,CREATOR,CDATE,MODIFYOR,MDATE," +
				"DEPENDCASE,EDATE,TYPE,SYSID,STATUS,CODE,TARGET,CHARGE,PARTY,PARTY_STATUS,MLAWYER," +
				"SLAWYER,ADMISSIONTYPE,ARCHIVEDATE,JUDGE,ISAID,ISFOREIGN,JUDICIALTYPE,BRIEF,SUMMARY,ID)" +
				" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
			psment.clearBatch();

			psment.setString(1,source.getName());
			psment.setString(2,source.getCreator());
			psment.setDate(3,null == source.getcDate() ? null : new java.sql.Date(source.getcDate().getTime()));
			psment.setString(4,source.getModify());
			psment.setDate(5,null == source.getmDate() ? null : new java.sql.Date(source.getmDate().getTime()));
			psment.setString(6, source.getDependcase());
			psment.setDate(7,null == source.geteDate() ? null : new java.sql.Date(source.geteDate().getTime()));
			psment.setString(8, source.getType());
			psment.setString(9,source.getSysid());
			psment.setString(10, source.getStatus());
			psment.setString(11, source.getCode());
			
			psment.setInt(12, source.getTaget());			
			psment.setInt(13,source.getCharge());
			psment.setString(14, source.getParty());
			psment.setString(15, source.getParty_status());
			psment.setString(16, source.getMlawyer());
			psment.setString(17, source.getSlawyer());
			psment.setString(18, source.getAdmissionType());
			psment.setDate(19, null == source.getArchiveDate() ? null : new java.sql.Date(source.getArchiveDate().getTime()));
			psment.setString(20, source.getJudge());
			psment.setString(21, source.getIsaid());
			psment.setString(22, source.getIsforeign());
			psment.setString(23,source.getJudicialtype());
			psment.setString(24, source.getBrief());
			psment.setString(25, source.getSummary());
			
			psment.setString(26, source.getId());
			
			psment.addBatch();
	        //ִ�����ݿ���봦��
			psment.execute();			
		} catch (SQLException e) {
			throw new LawyerException("Save Dossier is error! "	+ e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
	
	/**
	 * ˵����ɾ��ָ���İ����������
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source �����������
	 * @throws LawyerException
	 */
	public void deleteDossier(Connection con,Dossier source) throws LawyerException{
		//Ŀǰ�԰���������ɾ������ֻ������״̬����Ϊɾ��״̬
		String sql = "DELETE "+DOSSIRETABLE+" FROM "+DOSSIRETABLE+" WHERE ID='"+source.getId()+"'";
		sql = "UPDATE "+DOSSIRETABLE+" SET STATUS='3' FROM "+DOSSIRETABLE+" WHERE ID='"+source.getId()+"'";
		
		Statement statement = null;
		try {
			statement = con.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			throw new LawyerException("Query User Dossier is error! "	+ e.getMessage());
		}finally{
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}
	
	/**
	 * ˵����ɾ��ָ��ϵͳ�е�ָ�������������
	 * 
	 * @param con ���ݿ�����
	 * @param sysid ϵͳ��ʶ
	 * @param dossierid ���������ʶ
	 * @throws LawyerException
	 */
	public void deleteDossier(Connection con,String sysid,String dossierid) throws LawyerException{
		//Ŀǰ�԰���������ɾ������ֻ������״̬����Ϊɾ��״̬
		String sql = "DELETE "+DOSSIRETABLE+" FROM "+DOSSIRETABLE+" WHERE ID='"+dossierid+"' AND SYSID='"+sysid+"'";
		sql = "UPDATE "+DOSSIRETABLE+" SET STATUS='3' FROM "+DOSSIRETABLE+" WHERE ID='"+dossierid+"' AND SYSID='"+sysid+"'";
		
		Statement statement = null;
		try {
			statement = con.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			throw new LawyerException("Query User Dossier is error! "	+ e.getMessage());
		}finally{
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}
	
	/**
	 * ˵������ȡ������������ʶ
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @return ��󰸼������ʶ
	 * @throws LawyerException
	 */
	public String getMaxDossierID(Connection con) throws LawyerException{
		String sql = "SELECT MAX(ID) AS MAXID FROM "+DOSSIRETABLE;
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			String value = "";
			while(result.next()){
				value = result.getString("MAXID");
				if(null != value)
					return value;
			}
			return "D_00000000";
		} catch (SQLException e) {
			throw new LawyerException("Query Max Doc Catalog ID is error! "	+ e.getMessage());
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
	
	public String getMaxDossierIDBySysid(Connection con,String sysid) throws LawyerException{
		throw new LawyerException("The method isn't support!");
	}

	/**
	 * ˵������ȡָ�����ڼ���ض�ϵͳ�û������İ��������б�
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param sysid ϵͳ��ʶ
	 * @param userid �û���ʶ
	 * @param sdate ��ʼʱ��
	 * @param edate ����ʱ��
	 * @return
	 * @throws LawyerException
	 */
	public List<Dossier> getUserTimesDossiers(Connection con, String sysid,String userid, Date sdate, Date edate) throws LawyerException {
		String sql = "SELECT ID,NAME,CREATOR,CDATE,MODIFYOR,MDATE,DEPENDCASE,EDATE,TYPE,"
				+ "SYSID,STATUS,CODE,TARGET,CHARGE,PARTY,PARTY_STATUS,MLAWYER,SLAWYER,"
				+ "ADMISSIONTYPE,ARCHIVEDATE,JUDGE,ISAID,ISFOREIGN,JUDICIALTYPE,BRIEF,SUMMARY FROM "
				+ DOSSIRETABLE
				+ " WHERE CREATOR='"
				+ userid
				+ "' AND SYSID='"
				+ sysid + "' AND (CDATE BETWEEN ? AND ?) ORDER BY CDATE ASC ";
		PreparedStatement pstatment = null;
		try {
			pstatment = con.prepareStatement(sql);
			// �������
			pstatment.clearBatch();
			
			pstatment.setDate(1, new java.sql.Date(sdate.getTime()));
			pstatment.setDate(2,new java.sql.Date(edate.getTime()));
			
			pstatment.addBatch();

			// ִ�����ݿ��ѯ����
			boolean qtag = pstatment.execute();
			if(qtag){
				ResultSet result = null;
				result = pstatment.getResultSet();
				List<Dossier> resultSet = new ArrayList<Dossier>();
				Dossier dossier = null;
				while (result.next()) {
					dossier = new Dossier(result.getString("SYSID"), result.getString("ID"), result.getString("CODE"), result.getString("NAME"));
					dossier.setName(result.getString("NAME"));
					dossier.setCreator(result.getString("CREATOR"));
					dossier.setcDate(result.getDate("CDATE"));
					dossier.setModify(result.getString("MODIFYOR"));
					dossier.setmDate(result.getDate("MDATE"));
					dossier.setDependcase(result.getString("DEPENDCASE"));
					dossier.seteDate(result.getDate("EDATE"));
					dossier.setType(result.getString("TYPE"));
					dossier.setParty(result.getString("PARTY"));
					dossier.setParty_status(result.getString("PARTY_STATUS"));
					dossier.setMlawyer(result.getString("MLAWYER"));
					dossier.setSlawyer(result.getString("SLAWYER"));
					dossier.setStatus(result.getString("STATUS"));
					dossier.setAdmissionType(result.getString("ADMISSIONTYPE"));
					dossier.setArchiveDate(result.getDate("ARCHIVEDATE"));
					dossier.setBrief(result.getString("BRIEF"));
					dossier.setIsaid(result.getString("ISAID"));
					dossier.setIsforeign(result.getString("ISFOREIGN"));
					dossier.setJudge(result.getString("JUDGE"));
					dossier.setJudicialtype(result.getString("JUDICIALTYPE"));
					dossier.setSummary(result.getString("SUMMARY"));
					dossier.setTaget(result.getInt("TARGET"));
					dossier.setCharge(result.getInt("CHARGE"));

					resultSet.add(dossier);
				}
				return resultSet;
			}
		} catch (SQLException e) {
			throw new LawyerException("Query User times Dossiers is error! "+ e.getMessage());
		} finally {
			try {
				pstatment.close();
			} catch (SQLException e) {
			}
			pstatment = null;
		}
		return null;
	}
}