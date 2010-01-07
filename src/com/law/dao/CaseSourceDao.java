package com.law.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.law.bean.CaseSource;
import com.law.util.LawyerException;

/**
 * ˵�����԰�Դ���г־ô���
 *
 */
public class CaseSourceDao {
	private String CASETABLE = "T_CASES_SOURCE";
	private String SYSUSER = "T_SYSUSER";
	private String CONTACTER = "T_CONTACTER";
	
	/**
	 * ˵�����洢һ����Դ����
	 * @param con ���ݿ����Ӷ���
	 * @param source ��Դ����
	 * @throws LawyerException
	 */
	public void saveCaseSource(Connection con,CaseSource source) throws LawyerException{
		PreparedStatement pstmt = null;
		try {
			String sql = "INSERT INTO "+CASETABLE+" (ID,NAME,CONTRACTOR,SDATE,EDATE,PROVIDER,DESCRIP,CREATOR,TYPE,STATUS,SYSID,REASON,UNDERTAKER) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
	        //�������
	        pstmt.clearBatch();

	        pstmt.setString(1,source.getId());
	        pstmt.setString(2,source.getName());
	        pstmt.setString(3,source.getContacterid());
	        pstmt.setDate(4, null == source.getSdate() ? new java.sql.Date(new Date().getTime()) : new java.sql.Date(source.getSdate().getTime()));
	        pstmt.setDate(5, null == source.getEdate() ? new java.sql.Date(new Date().getTime()) : new java.sql.Date(source.getEdate().getTime()));
	        pstmt.setString(6, source.getProviderid());
	        pstmt.setString(7,source.getDesc());
	        pstmt.setString(8,source.getCreatorid());
	        pstmt.setString(9,source.getTypeid());
	        pstmt.setString(10, source.getStatusid());
	        pstmt.setString(11, source.getSysid());
	        pstmt.setString(12, source.getReason());
	        pstmt.setString(13, source.getUndertakerid());

	        pstmt.addBatch();

	        //ִ�����ݿ���봦��
	        pstmt.execute();
		} catch (SQLException e) {
			throw new LawyerException("save Cases Source is error! "+e.getMessage());
		}finally{
			//�رջỰ
	        try {
				pstmt.close();
			} catch (SQLException e) {
				
			}
			pstmt = null;
		}
	}

	/**
	 * ˵�������°�Դ����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source ��Դ����
	 * @throws LawyerException
	 */
	public void updateCaseSource(Connection con, CaseSource source) throws LawyerException {
		PreparedStatement pstmt = null;
		try {
			String sql = "UPDATE "+CASETABLE+" SET NAME=?,CONTRACTOR=?,SDATE=?,EDATE=?,PROVIDER=?,DESCRIP=?,CREATOR=?,TYPE=?,STATUS=?,REASON=?,UNDERTAKER=? WHERE ID=? AND SYSID=?";
			pstmt = con.prepareStatement(sql);
			// �������
			pstmt.clearBatch();
			
			pstmt.setString(1, source.getName());
			pstmt.setString(2, source.getContacterid());
			pstmt.setDate(3, null == source.getSdate() ? new java.sql.Date(new Date().getTime()) : new java.sql.Date(source.getSdate().getTime()));
			pstmt.setDate(4, null == source.getEdate() ? new java.sql.Date(new Date().getTime()) : new java.sql.Date(source.getEdate().getTime()));
			pstmt.setString(5, source.getProviderid());
			pstmt.setString(6, source.getDesc());
			pstmt.setString(7, source.getCreatorid());
			pstmt.setString(8, source.getTypeid());
			pstmt.setString(9, source.getStatusid());
			pstmt.setString(10, source.getReason());
			pstmt.setString(11, source.getUndertakerid());
			pstmt.setString(12, source.getId());
			pstmt.setString(13, source.getSysid());
			
			pstmt.addBatch();

			// ִ�����ݿ���봦��
			pstmt.execute();
		} catch (SQLException e) {
			throw new LawyerException("update Cases Source is error! "	+ e.getMessage());
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
	 * ˵����ɾ�������İ�Դ����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source �����İ�Դ����
	 * @throws LawyerException
	 */
	public void deleteCaseSource(Connection con,CaseSource source) throws LawyerException {
		PreparedStatement pstmt = null;
		try {
			String sql = "UPDATE " +CASETABLE+ " SET STATUS=?,REASON=? WHERE ID=? AND SYSID=?";
			
			pstmt = con.prepareStatement(sql);
			// �������
			pstmt.clearBatch();
			
			pstmt.setString(1, source.getStatusid());
			pstmt.setString(2, source.getReason());
			pstmt.setString(3, source.getId());
			pstmt.setString(4, source.getSysid());
			
			pstmt.addBatch();

			// ִ�����ݿ���봦��
			pstmt.execute();
		} catch (SQLException e) {
			throw new LawyerException("add Cases Source is error! "	+ e.getMessage());
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
	 * ˵����ɾ��ָ��ϵͳ��ʶָ����Դ��ʶ�İ�Դ����
	 * 
	 * @param con ���ݿ�����
	 * @param sysid ϵͳ��ʶ
	 * @param caseid ��Դ��ʶ
	 * @throws LawyerException
	 */
	public void deleteCaseSource(Connection con,String sysid ,String caseid) throws LawyerException {
		PreparedStatement pstmt = null;
		try {
			String sql = "UPDATE " +CASETABLE+ " SET STATUS='7',REASON='ɾ��' WHERE ID=? AND SYSID=?";
			
			pstmt = con.prepareStatement(sql);
			// �������
			pstmt.clearBatch();
			
			pstmt.setString(1, caseid);
			pstmt.setString(2, sysid);
			
			
			pstmt.addBatch();

			// ִ�����ݿ���봦��
			pstmt.execute();
		} catch (SQLException e) {
			throw new LawyerException("add Cases Source is error! "	+ e.getMessage());
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
	 * ˵������ȡָ����ʶ�ĵİ�Դ����
	 * 
	 * @param con ���ݿ�����
	 * @param caseSourceID ��Դ��ʶ
	 * @return ��Դ����
	 * @throws LawyerException
	 */
	public CaseSource queryCaseSource(Connection con,String sysid,String caseSourceID) throws LawyerException{
		String sql = "SELECT A.ID," +
				"A.NAME," +
				"A.CONTRACTOR," +
				"CC.NAME AS CONTRACTORNAME," +
				"CC.TYPE AS CONTRACTTYPE," +
				"A.SDATE," +
				"A.EDATE," +
				"A.PROVIDER," +
				"BC.NAME AS PROVIDERNAME," +
				"A.DESCRIP," +
				"A.CREATOR," +
				"BB.NAME AS CREATORNAME," +
				"A.TYPE," +
				"A.SYSID,"+
				"A.REASON,"+
				"A.UNDERTAKER,"+
				"A.STATUS " +
				"FROM "+CASETABLE+" AS A " +
				"LEFT JOIN "+SYSUSER+" AS BB ON A.CREATOR=BB.ID " +
				"LEFT JOIN "+SYSUSER+" AS BC ON A.PROVIDER=BC.ID " +
				"LEFT JOIN "+CONTACTER+" AS CC ON A.CONTRACTOR = CC.ID " +
				"WHERE A.ID = '"+caseSourceID+"' AND A.SYSID='"+sysid+"'";
		Statement statment = null;
		try {
			statment = con.createStatement();
			ResultSet result = statment.executeQuery(sql);
			CaseSource caseSource = null;
			while (result.next()) {
				caseSource = new CaseSource(sysid,result.getString("ID"),result.getString("NAME"));
				
				caseSource.setContacter(result.getString("CONTRACTORNAME"));
				caseSource.setContacterid(result.getString("CONTRACTOR"));
				caseSource.setContactType(result.getString("CONTRACTTYPE"));
				
				caseSource.setCreator(result.getString("CREATORNAME"));
				caseSource.setCreatorid(result.getString("CREATOR"));
				
				caseSource.setProvider(result.getString("PROVIDERNAME"));
				caseSource.setProviderid(result.getString("PROVIDER"));
								
				caseSource.setSdate(result.getDate("SDATE"));
				caseSource.setEdate(result.getDate("EDATE"));
								
				caseSource.setUndertaker(result.getString("CREATORNAME"));
				caseSource.setUndertakerid(result.getString("CREATOR"));

				caseSource.setStatusid(result.getString("STATUS"));
				caseSource.setTypeid(result.getString("TYPE"));
				
				caseSource.setDesc(result.getString("DESCRIP"));
				break;
			}
			return caseSource;
		} catch (SQLException e) {
			throw new LawyerException("add Cases Source is error! "	+ e.getMessage());
		} finally {
			try {
				statment.close();
			} catch (SQLException e) {
			}
			statment = null;
		}
	}
	
	/**
	 * ˵������ȡָ���û��İ�Դ�б�
	 * 
	 * @param con ���ݿ����
	 * @param userid �û���ʶ
	 * @return ��Դ�б�
	 * @throws LawyerException
	 */
	public List<CaseSource> getCaseSourcesByUser(Connection con, String userid)	throws LawyerException {
		String sql = "SELECT A.ID," +
		"A.NAME," +
		"A.CONTRACTOR," +
		"CC.NAME AS CONTRACTORNAME," +
		"CC.TYPE AS CONTRACTTYPE," +
		"A.SDATE," +
		"A.EDATE," +
		"A.PROVIDER," +
		"BC.NAME AS PROVIDERNAME," +
		"A.DESCRIP," +
		"A.CREATOR," +
		"BB.NAME AS CREATORNAME," +
		"A.TYPE," +
		"A.SYSID,"+
		"A.REASON,"+
		"A.UNDERTAKER,"+
		"A.STATUS " +
		"FROM "+CASETABLE+" AS A " +
		"LEFT JOIN "+SYSUSER+" AS BB ON A.CREATOR=BB.ID " +
		"LEFT JOIN "+SYSUSER+" AS BC ON A.PROVIDER=BC.ID " +
		"LEFT JOIN "+CONTACTER+" AS CC ON A.CONTRACTOR = CC.ID " +
		" WHERE A.CREATOR = '" + userid + "'";
		Statement statment = null;;
		try {
			statment = con.createStatement();
			ResultSet result = statment.executeQuery(sql);
			List<CaseSource> caselist = new ArrayList<CaseSource>();
			CaseSource caseSource = null;
			while (result.next()) {
				caseSource = new CaseSource(result.getString("SYSID"),result.getString("ID"),result.getString("NAME"));

				caseSource.setContacter(result.getString("CONTRACTORNAME"));
				caseSource.setContacterid(result.getString("CONTRACTOR"));
				caseSource.setContactType(result.getString("CONTRACTTYPE"));
				caseSource.setCreator(result.getString("CREATORNAME"));
				caseSource.setCreatorid(result.getString("CREATOR"));
				caseSource.setProvider(result.getString("PROVIDERNAME"));
				caseSource.setProviderid(result.getString("PROVIDER"));
				caseSource.setSdate(result.getDate("SDATE"));
				caseSource.setEdate(result.getDate("EDATE"));
				caseSource.setUndertaker(result.getString("CREATORNAME"));
				caseSource.setUndertakerid(result.getString("CREATOR"));
				caseSource.setStatusid(result.getString("STATUS"));
				caseSource.setTypeid(result.getString("TYPE"));
				caseSource.setDesc(result.getString("DESCRIP"));
				
				caselist.add(caseSource);
			}
			return caselist;
		} catch (SQLException e) {
			throw new LawyerException("add Cases Source is error! "
					+ e.getMessage());
		} finally {
			try {
				statment.close();
			} catch (SQLException e) {
			}
			statment = null;
		}
	}
	/**
	 * ˵������ȡָ���û�ָ�������ڵİ�Դ�б�
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param userid �û���ʶ
	 * @param date �����޶�
	 * @return
	 * @throws LawyerException 
	 */
	public List<CaseSource> getUserTimesCaseSources(Connection con,String userid, Date sdate, Date edate) throws LawyerException {
		String sql =  "SELECT A.ID," +
		"A.NAME," +
		"A.CONTRACTOR," +
		"CC.NAME AS CONTRACTORNAME," +
		"CC.TYPE AS CONTRACTTYPE," +
		"A.SDATE," +
		"A.EDATE," +
		"A.PROVIDER," +
		"BC.NAME AS PROVIDERNAME," +
		"A.DESCRIP," +
		"A.CREATOR," +
		"BB.NAME AS CREATORNAME," +
		"A.TYPE," +
		"A.SYSID,"+
		"A.REASON,"+
		"A.UNDERTAKER,"+
		"A.STATUS " +
		"FROM "+CASETABLE+" AS A " +
		"LEFT JOIN "+SYSUSER+" AS BB ON A.CREATOR=BB.ID " +
		"LEFT JOIN "+SYSUSER+" AS BC ON A.PROVIDER=BC.ID " +
		"LEFT JOIN "+CONTACTER+" AS CC ON A.CONTRACTOR = CC.ID " +
		" WHERE A.CREATOR = '" + userid + "' AND (A.SDATE BETWEEN ? AND ?) ORDER BY A.SDATE ASC ";
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
				List<CaseSource> caselist = new ArrayList<CaseSource>();
				CaseSource caseSource = null;
				while (result.next()) {
					caseSource = new CaseSource(result.getString("SYSID"),result.getString("ID"),result.getString("NAME"));

					caseSource.setContacter(result.getString("CONTRACTORNAME"));
					caseSource.setContacterid(result.getString("CONTRACTOR"));
					caseSource.setContactType(result.getString("CONTRACTTYPE"));
					caseSource.setCreator(result.getString("CREATORNAME"));
					caseSource.setCreatorid(result.getString("CREATOR"));
					caseSource.setProvider(result.getString("PROVIDERNAME"));
					caseSource.setProviderid(result.getString("PROVIDER"));
					caseSource.setSdate(result.getDate("SDATE"));
					caseSource.setEdate(result.getDate("EDATE"));
					caseSource.setUndertaker(result.getString("CREATORNAME"));
					caseSource.setUndertakerid(result.getString("CREATOR"));
					caseSource.setStatusid(result.getString("STATUS"));
					caseSource.setReason(result.getString("REASON"));
					caseSource.setTypeid(result.getString("TYPE"));
					caseSource.setDesc(result.getString("DESCRIP"));
					
					caselist.add(caseSource);
				}
				return caselist;
			}
		} catch (SQLException e) {
			throw new LawyerException("Query User Cases Source is error! "+ e.getMessage());
		} finally {
			try {
				pstatment.close();
			} catch (SQLException e) {
			}
			pstatment = null;
		}
		return null;
	}

	/**
	 * ˵������ȡϵͳ�е�ǰ���İ�Դ��ʶ
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @return ���ص�ǰ��Դ���е�����ʶ��
	 * @throws LawyerException
	 */
	public String getMaxCaseSourceID(Connection con) throws LawyerException {
		String sql = "SELECT MAX(ID) AS MAXID FROM " + CASETABLE;
		Statement statment = null;
		try {
			statment = con.createStatement();
			ResultSet result = null;
			result = statment.executeQuery(sql);
			String value = "";
			while (result.next()) {
				value = result.getString("MAXID");
				if(null != value)
				return value;
			}
			return "S_00000000";
		} catch (SQLException e) {
			throw new LawyerException("add Cases Source is error! "	+ e.getMessage());
		} finally {
			try {
				statment.close();
			} catch (SQLException e) {
			}
			statment = null;
		}
	}

	public String getMaxCaseSourceIDBySysID(Connection con,String sysid) throws LawyerException {
		throw new LawyerException("The method isn't support!");
	}
}