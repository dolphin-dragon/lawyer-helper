SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS law_case_close_stat;
DROP TABLE IF EXISTS law_case_legal;
DROP TABLE IF EXISTS law_case_source;
DROP TABLE IF EXISTS law_customer;




/* Create Tables */

-- 结案统计数据表
CREATE TABLE law_case_close_stat
(
	-- 结案ID标识
	id int NOT NULL AUTO_INCREMENT COMMENT '结案ID标识',
	-- 案件编号
	ccode varchar(64) COMMENT '案件编号',
	-- 原告信息
	plaintiff varchar(90) COMMENT '原告',
	-- 被告信息
	defendant varchar(600) COMMENT '被告',
	-- 结案文书明细:结案方式
	close_type varchar(12) COMMENT '结案方式',
	-- 结案文书明细:结案时间
	close_date datetime COMMENT '结案时间',
	-- 结案文书明细:赔偿金额信息
	compensation_amont numeric(19,2) COMMENT '赔偿金额',
	-- 结案文书明细:公证费用信息
	fair_fee numeric(19,2) COMMENT '公证费用',
	-- 结案文书明细:差旅费用信息
	travel_expenses numeric(19,2) COMMENT '差旅费',
	-- 结案文书明细:被告负担诉讼费用信息
	defendant_legal_fare numeric(19,2) COMMENT '被告负担诉费',
	-- 实际垫付:公证费用信息
	advance_fair_fee numeric(19,2) COMMENT '实际垫付公证费',
	-- 实际垫付:诉讼费/公告费信息
	advance_legal_fare numeric(19,2) COMMENT '实际垫付诉讼费/公告费',
	-- 法院尚欠应退诉费信息:应退诉费
	refund_fee numeric(19,2) COMMENT '应退诉费',
	-- 法院尚欠应退诉费信息:实退诉费
	return_fee numeric(19,2) COMMENT '实退诉费',
	-- 成本(除差旅):公证费信息
	cost_fair_fee numeric(19,2) COMMENT '公证费',
	-- 成本(除差旅):诉讼费信息
	cost_legal_fare numeric(19,2) COMMENT '诉讼费',
	-- 应收金额:应收总计信息
	receive_due numeric(19,2) COMMENT '应收总计',
	-- 到账时间
	receive_date datetime COMMENT '到账时间',
	-- 实收金额:实收总计信息
	receive_account numeric(19,2) COMMENT '实收总计',
	-- 律师费计算基数
	lawyer_pay_base numeric(19,2) COMMENT '律师费计算基数',
	-- 总律师费用信息
	lawyer_pay numeric(19,2) COMMENT '总律师费',
	-- 主办律师信息
	master_lawyer varchar(16) COMMENT '主办律师',
	-- 协办律师
	slave_lawyer_one varchar(16) COMMENT '协办律师1',
	-- 协办律师
	slave_lawyer_two varchar(16) COMMENT '协办律师2',
	-- 协办律师
	slave_lawyer_three varchar(16) COMMENT '协办律师3',
	-- 账户信息
	account_info varchar(120) COMMENT '账户信息',
	-- 案件绩效信息
	achievement numeric(19,2) COMMENT '绩效',
	-- 应支付给艺人信息
	due numeric(19,2) COMMENT '应支付给艺人',
	-- 成本回款
	cost numeric(19,2) COMMENT '成本回款',
	-- 案件分类：A/B/C/D
	ctype varchar(1) COMMENT '案件分类',
	-- 线索提供者
	provider varchar(16) COMMENT '线索人',
	-- 线索费
	provider_fee numeric(19,2) COMMENT '线索费',
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记',
	PRIMARY KEY (id),
	UNIQUE (ccode)
) ENGINE = InnoDB COMMENT = '结案统计数据表' DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


-- 案件信息登记数据表
CREATE TABLE law_case_legal
(
	-- 案件ID
	id int NOT NULL AUTO_INCREMENT COMMENT '案件ID',
	-- 案源编号
	scode varchar(64) COMMENT '案源编号',
	-- 立案案号信息
	code varchar(64) COMMENT '案件案号',
	-- 案由信息
	cause varchar(300) COMMENT '案由',
	-- 案件原告信息
	plaintiff varchar(64) COMMENT '原告',
	-- 案件被告信息
	defendant varchar(64) COMMENT '被告',
	-- 案件适用程序
	cprocedure varchar(30) COMMENT '适用程序',
	-- 立案日期
	case_date datetime COMMENT '立案日期',
	-- 开庭日期
	open_date datetime COMMENT '开庭日期',
	-- 关联案源信息编号
	case_source_id varchar(64) COMMENT '案源编号',
	-- 承办法官信息
	judge varchar(20) COMMENT '承办法官',
	-- 承办律师信息
	lawyer varchar(64) COMMENT '承办律师',
	-- 案件情况简介说明
	cdesc varchar(600) COMMENT '案件情况',
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记',
	PRIMARY KEY (id),
	UNIQUE (code)
) ENGINE = InnoDB COMMENT = '案件信息登记数据表' DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


-- 案源信息收集数据表
CREATE TABLE law_case_source
(
	-- 案源ID
	id int NOT NULL AUTO_INCREMENT COMMENT '案源ID',
	-- 案源编码
	code varchar(64) COMMENT '案源编码',
	-- 案源名称信息
	title varchar(120) NOT NULL COMMENT '案源名称',
	-- 案源描述
	c_desc varchar(900) COMMENT '案源描述',
	-- 案源接收日期
	record_date date COMMENT '案源接收日期',
	-- 结案日期
	close_date date COMMENT '结案日期',
	-- 案件回款接收日期
	receive_date date COMMENT '回款日期',
	-- 主办律师
	m_lawyer varchar(64) COMMENT '主办律师',
	-- 案源提供者信息
	provider varchar(64) COMMENT '案源提供者',
	-- 案源受理状态， 0案源登记 1案源受理 4案源不受理 6立案处理 9结案处理 
	status varchar(2) DEFAULT '0' NOT NULL COMMENT '处理状态',
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记',
	PRIMARY KEY (id),
	UNIQUE (code)
) ENGINE = InnoDB COMMENT = '案源信息收集数据表' DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


-- 客户信息数据表
CREATE TABLE law_customer
(
	-- 客户ID
	id int NOT NULL AUTO_INCREMENT COMMENT '客户ID',
	-- 客户编码
	code varchar(64) COMMENT '客户编码',
	-- 客户名称
	name varchar(60) NOT NULL COMMENT '客户名称',
	-- 客户类别信息 0个人 1企业
	ctype varchar(2) DEFAULT '0' NOT NULL COMMENT '客户类别',
	-- 客户身份证信息
	id_card varchar(30) COMMENT '客户身份证信息',
	-- 企业组织结构代码信息
	e_code varchar(40) COMMENT '企业组织机构代码',
	-- 联系电话信息
	phone varchar(20) COMMENT '联系电话',
	-- 联系人信息
	linkman varchar(16) COMMENT '联系人',
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记',
	PRIMARY KEY (id),
	UNIQUE (code)
) ENGINE = InnoDB COMMENT = '客户信息数据表' DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;



