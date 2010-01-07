package com.law.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.law.util.DBServices;
import com.law.util.LawyerException;
/**
 * ˵������ȡ������Ϣֵ
 *
 */
public class CodeMessageService {
	//��Ϣ�������
	public enum CODETYPE{
		SEX //�Ա� 1 �� 2 Ů  3δ֪
		,AYTYPE //��Դ����
		,AJBLZT //��������״̬
		,AJLYFS //������Դ��ʽ
		,AJSJ //������
		,DSRSF //��ʱ�����
//		,ISFY //�Ƿ���Ԯ��
		,AQZT //����״̬
		,MZ //����
		,SFFL
		};
		
	private List<String[]> sexs = new ArrayList<String[]>();
	private List<String[]> aytypes = new ArrayList<String[]>();
	private List<String[]> ajblzts = new ArrayList<String[]>();
	private List<String[]> ajlyfss = new ArrayList<String[]>();
	private List<String[]> ajsjs = new ArrayList<String[]>();
	private List<String[]> dsrsfs = new ArrayList<String[]>();
//	private List<String[]> isfys = new ArrayList<String[]>();
	private List<String[]> aqzts = new ArrayList<String[]>();
	private List<String[]> mzs = new ArrayList<String[]>();
	private List<String[]> sffls = new ArrayList<String[]>();
	
	private static CodeMessageService codeServerce = new CodeMessageService();
	
	private CodeMessageService() {
		build();
	}
	
	public static CodeMessageService getInstance(){
		return codeServerce;
	}
	
	private void build(){
		sexs.add(new String[]{"101","��"});
		sexs.add(new String[]{"102","Ů"});
		sexs.add(new String[]{"103","δ֪"});
		
		aytypes.add(new String[]{"201","����"});
		aytypes.add(new String[]{"202","����"});
		aytypes.add(new String[]{"203","֪ʶ��Ȩ"});
		aytypes.add(new String[]{"204","�Ͷ�����"});
		
		ajblzts.add(new String[]{"301","��Դ������"});
		ajblzts.add(new String[]{"302","����ǰ"});
		ajblzts.add(new String[]{"303","����"});
		ajblzts.add(new String[]{"304","��ͥǰ"});
		ajblzts.add(new String[]{"305","��ͥ"});
		ajblzts.add(new String[]{"306","�����˻�̸"});
		ajblzts.add(new String[]{"307","�鵵"});
		ajblzts.add(new String[]{"308","�᰸"});
		
		ajlyfss.add(new String[]{"401","�ϼ�ָ��"});
		ajlyfss.add(new String[]{"402","����ָ��"});
		
		ajsjs.add(new String[]{"501","һ��"});
		ajsjs.add(new String[]{"502","����"});
		ajsjs.add(new String[]{"503","����"});
		
		dsrsfs.add(new String[]{"601","������"});
		dsrsfs.add(new String[]{"602","��������"});
		dsrsfs.add(new String[]{"603","ԭ��"});
		dsrsfs.add(new String[]{"604","����"});
		dsrsfs.add(new String[]{"605","������"});
		dsrsfs.add(new String[]{"606","��Ԯ��"});
		dsrsfs.add(new String[]{"607","������"});
		dsrsfs.add(new String[]{"608","��������"});
		
		aqzts.add(new String[]{"701","��ͥǰ"});
		aqzts.add(new String[]{"702","��ͥ"});
		aqzts.add(new String[]{"703","ִ��"});
		aqzts.add(new String[]{"704","�᰸"});
		
		mzs.add(new String[]{"N01","����"});
		mzs.add(new String[]{"N02","����"});
		mzs.add(new String[]{"N03","����"});
		mzs.add(new String[]{"N04","����"});
		mzs.add(new String[]{"N05","ά��"});
		mzs.add(new String[]{"N06","����"});
		mzs.add(new String[]{"N07","����"});
		mzs.add(new String[]{"N08","׳��"});
		mzs.add(new String[]{"N09","������"});
		mzs.add(new String[]{"N10","������"});
		mzs.add(new String[]{"N11","����"});
		mzs.add(new String[]{"N12","����"});
		mzs.add(new String[]{"N13","����"});
		mzs.add(new String[]{"N14","����"});
		mzs.add(new String[]{"N15","������"});
		mzs.add(new String[]{"N16","������"});
		mzs.add(new String[]{"N17","��������"});
		mzs.add(new String[]{"N18","����"});
		mzs.add(new String[]{"N19","����"});
		mzs.add(new String[]{"N20","������"});
		mzs.add(new String[]{"N21","����"});
		mzs.add(new String[]{"N22","����"});
		mzs.add(new String[]{"N23","��ɽ��"});
		mzs.add(new String[]{"N24","������"});
		mzs.add(new String[]{"N25","ˮ��"});
		mzs.add(new String[]{"N26","������"});
		mzs.add(new String[]{"N27","������"});
		mzs.add(new String[]{"N28","������"});
		mzs.add(new String[]{"N29","�¶�������"});
		mzs.add(new String[]{"N30","����"});
		mzs.add(new String[]{"N31","���Ӷ���"});
		mzs.add(new String[]{"N32","������"});
		mzs.add(new String[]{"N33","Ǽ��"});
		mzs.add(new String[]{"N34","������"});
		mzs.add(new String[]{"N35","������"});
		mzs.add(new String[]{"N36","ë����"});
		mzs.add(new String[]{"N37","������"});
		mzs.add(new String[]{"N38","������"});
		mzs.add(new String[]{"N39","������"});
		mzs.add(new String[]{"N40","������"});
		mzs.add(new String[]{"N41","��������"});
		mzs.add(new String[]{"N42","ŭ��"});
		mzs.add(new String[]{"N43","���α����"});
		mzs.add(new String[]{"N44","����˹��"});
		mzs.add(new String[]{"N45","���¿���"});
		mzs.add(new String[]{"N46","�°���"});
		mzs.add(new String[]{"N47","������"});
		mzs.add(new String[]{"N48","ԣ����"});
		mzs.add(new String[]{"N49","����"});
		mzs.add(new String[]{"N50","��������"});
		mzs.add(new String[]{"N51","������"});
		mzs.add(new String[]{"N52","���״���"});
		mzs.add(new String[]{"N53","������"});
		mzs.add(new String[]{"N54","�Ű���"});
		mzs.add(new String[]{"N55","�����"});
		mzs.add(new String[]{"N56","��ŵ��"});
		mzs.add(new String[]{"N97","*δʶ��"});
		mzs.add(new String[]{"N98","*�����м�"});
		
		sffls.add(new String[]{"801","��ͥ"});
		sffls.add(new String[]{"802","����"});
		sffls.add(new String[]{"803","�Ͷ�"});
	}
	
	//��Ϣ�����
//	private String MESSAGETABLE = "T_CODE";
	
	
	private List<String[]> queryMessage(String type){
		if(CODETYPE.AJBLZT.name().equals(type)){
			return ajblzts;
		}else if(CODETYPE.AJLYFS.name().equals(type)){
			return ajlyfss;
		}else if(CODETYPE.AJSJ.name().equals(type)){
			return ajsjs;
		}else if(CODETYPE.AQZT.name().equals(type)){
			return aqzts;
		}else if(CODETYPE.AYTYPE.name().equals(type)){
			return aytypes;
		}else if(CODETYPE.DSRSF.name().equals(type)){
			return dsrsfs;
		}else if(CODETYPE.MZ.name().equals(type)){
			return mzs;
		}else if(CODETYPE.SEX.name().equals(type)){
			return sexs;
		}else if(CODETYPE.SFFL.name().equals(type)){
			return sffls;
		}else
			return null;
	}
	/**
	 * ˵������ȡָ����Ϣ���͵���Ϣ�б�
	 * 
	 * @param type ��Ϣ����
	 * @param systemid ϵͳ����
	 * @return
	 */
	public List<String[]> queryCatelogMessage(String type,String systemid){
		//TODO:��׮�������������ݿ��ѯ
		return queryMessage(type);
		
//		String sql = "SELECT CODE,VALUE FROM "+MESSAGETABLE+" WHERE TYPE='"+type+"' AND SYSID='"+systemid+"' ORDER BY ORD";
//		Connection con = null;
//		try {
//			con = DBServices.getDBService().getConnection();
//			Statement statement = con.createStatement();
//			ResultSet result = statement.executeQuery(sql);
//			List<String[]> messages = new ArrayList<String[]>();
//			String[] message = null;
//			while(result.next()){
//				String code = result.getString("CODE");
//				String value = result.getString("VALUE");
//				message = new String[]{code,value};
//				messages.add(message);
//			}
//			return messages;
//		} catch (LawyerException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				con.close();
//			} catch (SQLException e) {
//			}
//		}
//		return null;
	}
	
	/**
	 * ˵����������Ϣ�б�
	 * 
	 * @param systemid
	 * @param type
	 * @param code
	 * @param value
	 * @param shortv
	 * @param ord
	 */
	public void saveCataLogMessage(String systemid,String type,String code,String value,String shortv,int ord){
//		String sql = "INSERT INTO "+MESSAGETABLE+" (SYSID,TYPE,CODE,VALUE,SHORTV,ORD) VALUES (?,?,?,?,?,?)";
//		Connection con = null;
//		try {
//			con = DBServices.getDBService().getConnection();
//			PreparedStatement psment = con.prepareStatement(sql);
//			
//			//�������
//			psment.clearBatch();
//
//			psment.setString(1,systemid);
//			psment.setString(2,type);
//			psment.setString(3,code);
//			psment.setString(4, value);
//			psment.setString(5, shortv);
//			psment.setInt(6,ord);
//			
//			psment.addBatch();
//	        //ִ�����ݿ���봦��
//			psment.execute();
//		} catch (LawyerException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				con.close();
//			} catch (SQLException e) {
//			}
//		}
	}
}
