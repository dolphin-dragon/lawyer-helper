package com.law.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * 说明：DataBase服务类，提供基本的数据库连接服务
 * 
 */
public class DBServices {
	// 封装数据源对象
	private DataSource ds = null;

	// 采用单例模式进行服务对象的获取
	private final static DBServices dbServices = new DBServices();

	private DBServices() {
		init();
	}

	private void init() {
		try {
			DBConfigs configs = new DBConfigs("");
			if (configs.getDb_type().equals(DBConfigs.DBCONFIGTYPE.LOCAL.name())) {
				BoneCPDBPool dbPool = new BoneCPDBPool(configs);
				ds = dbPool.getDataSource();
			} else {
				// TODO:获取JNDI中的数据源
			}
		} catch (LawyerException e) {
			e.printStackTrace();
		}
	}

	public static DBServices getDBService() {
		return dbServices;
	}

	public Connection getConnection() throws LawyerException {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new LawyerException("DB Services Get Connection is error!\r\n"+e.getMessage());
		}
	}
}