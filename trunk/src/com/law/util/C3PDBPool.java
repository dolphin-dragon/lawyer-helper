package com.law.util;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

public class C3PDBPool {
	// 使用数据源对象
	private DataSource datasource = null;

	C3PDBPool(DBConfigs configs) {
		try {
			Class.forName(configs.getDb_driver());
			datasource = DataSources.pooledDataSource(DataSources.unpooledDataSource(configs.getDb_url(),configs.getDb_user(),configs.getDb_pw()));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public DataSource getDataSource() {
		return datasource;
	}
}
