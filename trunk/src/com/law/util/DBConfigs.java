package com.law.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 说明：数据库配置类
 * 
 */
class DBConfigs {
	enum DBCONFIGTYPE{LOCAL,JNDI};
	
	//数据库连接配置文件
	private final static String DBCONFIG= File.separator+"configs"+File.separator+"dbconfigs.properties";
		
	private final String DB_TYPE = "db_type";
	private final String DB_URL = "db_url";
	private final String DB_USER = "db_user";
	private final String DB_PW = "db_pw";
	private final String DB_DRIVER = "db_driver";
	private final String DB_MINCONNECTIONS = "db_minconnections";
	private final String DB_MAXCONNECTIONS = "db_maxconnections";
	private final String DB_JNDI="db_jndi";
	private final String MINDBC="2";
	private final String MAXDBC="5";
	
	private String db_type="";
	
	private String db_url = "";
	private String db_user = "";
	private String db_pw = "";
	private String db_driver = "";
	private int min = 0;
	private int max = 0;
	
	private String db_jndiName = "";

	protected DBConfigs(String configFileName) throws LawyerException {
		if(null == configFileName || "".equals(configFileName))
			configFileName = DBCONFIG;
		loadConfig(configFileName);
	}
	
	private void loadConfig(String fileName) throws LawyerException{
		InputStream inputstream = DBConfigs.class.getClassLoader().getResourceAsStream(fileName);
		Properties properties = new Properties();
		try {
			properties.load(inputstream);			
			db_type = properties.getProperty(DB_TYPE,DBCONFIGTYPE.LOCAL.name());
			if(db_type.equals(DBCONFIGTYPE.LOCAL.name())){
				db_url=properties.getProperty(DB_URL);
				db_user = properties.getProperty(DB_USER);
				db_pw = properties.getProperty(DB_PW);
				db_driver = properties.getProperty(DB_DRIVER);
				min = Integer.valueOf(properties.getProperty(DB_MINCONNECTIONS,MINDBC)).intValue();
				max = Integer.valueOf(properties.getProperty(DB_MAXCONNECTIONS,MAXDBC)).intValue();
			}else{
				db_jndiName = properties.getProperty(DB_JNDI);
			}
		} catch (IOException e) {
			throw new LawyerException("DBConfigs load is error!"+e.getMessage());
		}
	}	

	public String getDb_type() {
		return db_type;
	}

	public String getDb_jndiName() {
		return db_jndiName;
	}

	public String getDb_url() {
		return db_url;
	}

	public String getDb_user() {
		return db_user;
	}

	public String getDb_pw() {
		return db_pw;
	}

	public String getDb_driver() {
		return db_driver;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}
}