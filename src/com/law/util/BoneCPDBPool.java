package com.law.util;

import javax.sql.DataSource;

import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;

/**
 * ˵������װ����BoneCP������Դ���ӹ���
 * 
 */
class BoneCPDBPool {
	// ʹ������Դ����
	private BoneCPDataSource datasource = null;

	BoneCPDBPool(DBConfigs configs) {
		BoneCPConfig boneconfig = new BoneCPConfig();
		boneconfig.setJdbcUrl(configs.getDb_url());
		boneconfig.setUsername(configs.getDb_user());
		boneconfig.setPassword(configs.getDb_pw());
		boneconfig.setMinConnectionsPerPartition(configs.getMin());
		boneconfig.setMaxConnectionsPerPartition(configs.getMax());
		boneconfig.setPartitionCount(1);
		datasource = new BoneCPDataSource(boneconfig);
		datasource.setDriverClass(configs.getDb_driver());
	}

	public DataSource getDataSource() {
		return datasource;
	}
}