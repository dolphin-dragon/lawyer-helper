package com.law.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * ˵����DataBase�����࣬�ṩ���������ݿ����ӷ���
 * 
 */
public class DBServices {
	// ��װ����Դ����
	private DataSource ds = null;

	// ���õ���ģʽ���з������Ļ�ȡ
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
				// TODO:��ȡJNDI�е�����Դ
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