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
 * 说明：获取编码消息值
 *
 */
public class CodeMessageService {
	//消息编码分类
	public enum CODETYPE{
		SEX //性别 1 男 2 女  3未知
		,AYTYPE //案源分类
		,AJBLZT //案件办理状态
		,AJLYFS //案件来源方式
		,AJSJ //案件审级
		,DSRSF //当时人身份
//		,ISFY //是否法律援助
		,AQZT //案卷状态
		,MZ //民族
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
		sexs.add(new String[]{"101","男"});
		sexs.add(new String[]{"102","女"});
		sexs.add(new String[]{"103","未知"});
		
		aytypes.add(new String[]{"201","民事"});
		aytypes.add(new String[]{"202","刑事"});
		aytypes.add(new String[]{"203","知识产权"});
		aytypes.add(new String[]{"204","劳动争议"});
		
		ajblzts.add(new String[]{"301","案源跟踪中"});
		ajblzts.add(new String[]{"302","立案前"});
		ajblzts.add(new String[]{"303","立案"});
		ajblzts.add(new String[]{"304","开庭前"});
		ajblzts.add(new String[]{"305","开庭"});
		ajblzts.add(new String[]{"306","当事人会谈"});
		ajblzts.add(new String[]{"307","归档"});
		ajblzts.add(new String[]{"308","结案"});
		
		ajlyfss.add(new String[]{"401","上级指定"});
		ajlyfss.add(new String[]{"402","所里指定"});
		
		ajsjs.add(new String[]{"501","一审"});
		ajsjs.add(new String[]{"502","二审"});
		ajsjs.add(new String[]{"503","再审"});
		
		dsrsfs.add(new String[]{"601","上诉人"});
		dsrsfs.add(new String[]{"602","被上诉人"});
		dsrsfs.add(new String[]{"603","原告"});
		dsrsfs.add(new String[]{"604","被告"});
		dsrsfs.add(new String[]{"605","第三人"});
		dsrsfs.add(new String[]{"606","受援人"});
		dsrsfs.add(new String[]{"607","申请人"});
		dsrsfs.add(new String[]{"608","被申请人"});
		
		aqzts.add(new String[]{"701","开庭前"});
		aqzts.add(new String[]{"702","开庭"});
		aqzts.add(new String[]{"703","执行"});
		aqzts.add(new String[]{"704","结案"});
		
		mzs.add(new String[]{"N01","汉族"});
		mzs.add(new String[]{"N02","蒙族"});
		mzs.add(new String[]{"N03","回族"});
		mzs.add(new String[]{"N04","藏族"});
		mzs.add(new String[]{"N05","维族"});
		mzs.add(new String[]{"N06","苗族"});
		mzs.add(new String[]{"N07","彝族"});
		mzs.add(new String[]{"N08","壮族"});
		mzs.add(new String[]{"N09","布依族"});
		mzs.add(new String[]{"N10","朝鲜族"});
		mzs.add(new String[]{"N11","满族"});
		mzs.add(new String[]{"N12","侗族"});
		mzs.add(new String[]{"N13","瑶族"});
		mzs.add(new String[]{"N14","白族"});
		mzs.add(new String[]{"N15","土家族"});
		mzs.add(new String[]{"N16","哈尼族"});
		mzs.add(new String[]{"N17","哈萨克族"});
		mzs.add(new String[]{"N18","傣族"});
		mzs.add(new String[]{"N19","黎族"});
		mzs.add(new String[]{"N20","傈僳族"});
		mzs.add(new String[]{"N21","佤族"});
		mzs.add(new String[]{"N22","舍族"});
		mzs.add(new String[]{"N23","高山族"});
		mzs.add(new String[]{"N24","拉祜族"});
		mzs.add(new String[]{"N25","水族"});
		mzs.add(new String[]{"N26","东乡族"});
		mzs.add(new String[]{"N27","纳西族"});
		mzs.add(new String[]{"N28","景颇族"});
		mzs.add(new String[]{"N29","柯尔克孜族"});
		mzs.add(new String[]{"N30","土族"});
		mzs.add(new String[]{"N31","达斡尔族"});
		mzs.add(new String[]{"N32","仫佬族"});
		mzs.add(new String[]{"N33","羌族"});
		mzs.add(new String[]{"N34","布朗族"});
		mzs.add(new String[]{"N35","撒拉族"});
		mzs.add(new String[]{"N36","毛南族"});
		mzs.add(new String[]{"N37","仡佬族"});
		mzs.add(new String[]{"N38","锡伯族"});
		mzs.add(new String[]{"N39","阿昌族"});
		mzs.add(new String[]{"N40","普米族"});
		mzs.add(new String[]{"N41","塔吉克族"});
		mzs.add(new String[]{"N42","怒族"});
		mzs.add(new String[]{"N43","乌孜别克族"});
		mzs.add(new String[]{"N44","俄罗斯族"});
		mzs.add(new String[]{"N45","鄂温克族"});
		mzs.add(new String[]{"N46","德昂族"});
		mzs.add(new String[]{"N47","保安族"});
		mzs.add(new String[]{"N48","裕固族"});
		mzs.add(new String[]{"N49","京族"});
		mzs.add(new String[]{"N50","塔塔尔族"});
		mzs.add(new String[]{"N51","独龙族"});
		mzs.add(new String[]{"N52","鄂伦春族"});
		mzs.add(new String[]{"N53","赫哲族"});
		mzs.add(new String[]{"N54","门巴族"});
		mzs.add(new String[]{"N55","珞巴族"});
		mzs.add(new String[]{"N56","基诺族"});
		mzs.add(new String[]{"N97","*未识别"});
		mzs.add(new String[]{"N98","*外入中籍"});
		
		sffls.add(new String[]{"801","刑庭"});
		sffls.add(new String[]{"802","民事"});
		sffls.add(new String[]{"803","劳动"});
	}
	
	//消息编码表
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
	 * 说明：获取指定消息类型的消息列表
	 * 
	 * @param type 消息类型
	 * @param systemid 系统名称
	 * @return
	 */
	public List<String[]> queryCatelogMessage(String type,String systemid){
		//TODO:打桩处理，不进行数据库查询
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
	 * 说明：保存消息列表
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
//			//清除参数
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
//	        //执行数据库插入处理
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
