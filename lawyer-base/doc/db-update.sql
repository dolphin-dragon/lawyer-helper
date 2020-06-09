-- 2020-05-24
ALTER TABLE sys_file_attach ADD url varchar(1024) NULL COMMENT 'url请求地址';

-- 2020-05-19
CREATE OR REPLACE case_m_info AS
select
    cap.src AS cp_src,
    cap.supply AS cp_supply,
    cap.apply_date AS cp_apply_date,
    cap.applicant AS cp_applicant,
    cap.forensics AS cp_forensics,
    cap.violate_type AS cp_violate_type,
    cap.violate_desc AS cp_violate_desc,
    cap.action_date AS cp_action_date,
    cap.litigant_ac_date AS cp_litigant_ac_date,
    cap.action_img AS cp_action_img,
    cap.litigant_ac_img AS cp_litigant_ac_img,
    cap.is_direct_action AS cp_is_direct_action,
    m.status AS case_status,
    m.del_flag AS case_del_flag,
    m.org AS case_org,
    m.created_by AS case_created_by,
    m.created_time AS case_created_time,
    m.updated_by AS case_updated_by,
    m.updated_time AS case_updated_time,
    m.id AS id,
    m.litigant AS case_litigant,
    m.defendant_name AS case_defendant_name,
    m.defendant_reg_capital AS case_defendant_reg_capital,
    m.defendant_area AS case_defendant_area,
    cpre.letter AS pr_letter,
    cpre.letteror AS pr_letteror,
    cpre.send_date AS pr_send_date,
    cpre.delivery_date AS pr_delivery_date,
    cpre.is_close AS pr_is_close,
    cpre.is_direct_action AS pr_is_direct_action,
    cfir.firstor AS fir_firstor,
    cfir.lawyer AS fir_lawyer,
    cfir.submit_date AS fir_submit_date,
    cfir.establish_date AS fir_establish_date,
    cfir.litigation_costs AS fir_litigation_costs,
    cfir.announcement_costs AS fir_announcement_costs,
    cfir.notary_costs AS fir_notary_costs,
    cfir.other_costs AS fir_other_costs,
    cfir.adjudication_court AS fir_adjudication_court,
    cfir.judge AS fir_judge,
    cfir.judge_contact AS fir_judge_contact,
    cfir.f_court_date AS fir_f_court_date,
    cfir.f_verdict_date AS fir_f_verdict_date,
    cfir.f_verdict_receive_date AS fir_f_verdict_receive_date,
    cfir.is_apology AS fir_is_apology,
    cfir.defendant_compensation_total AS fir_defendant_compensation_total,
    cfir.defendant_expenses AS fir_defendant_expenses,
    cfir.plaintiff_costs AS fir_plaintiff_costs,
    cfir.defendant_costs AS fir_defendant_costs,
    cfir.is_close AS fir_is_close,
    cfir.appeal_date AS fir_appeal_date,
    cfir.is_pre_mediation AS fir_is_pre_mediation,
    cfir.is_action_mediation AS fir_is_action_mediation,
    cfir.mediation_date AS fir_mediation_date,
    cfir.is_appeal AS fir_is_appeal,
    cfir.appellant AS fir_appellant,
    cfir.is_carry_out AS fir_is_carry_out,
    csec.lawyer AS two_lawyer,
    csec.s_court_date AS two_s_court_date,
    csec.judge AS two_judge,
    csec.judge_contact AS two_judge_contact,
    csec.s_judgment_effective_date AS two_s_judgment_effective_date,
    csec.is_apology AS two_is_apology,
    csec.defendant_compensation_total AS two_defendant_compensation_total,
    csec.defendant_expenses AS two_defendant_expenses,
    csec.plaintiff_costs AS two_plaintiff_costs,
    csec.defendant_costs AS two_defendant_costs,
    csec.is_close AS two_is_close,
    csec.execution_deadline AS two_execution_deadline,
    csec.is_carry_out AS two_is_carry_out,
    cout.lawyer AS out_lawyer,
    cout.app_date AS out_app_date,
    cout.app_total AS out_app_total,
    cout.judge AS out_judge,
    cout.judge_contact AS out_judge_contact,
    cout.actual_total AS out_actual_total,
    cout.f_collection_subject AS out_f_collection_subject,
    cout.is_reconcile AS out_is_reconcile,
    cout.is_close AS out_is_close
from
    (((((lawyerdb.case_info m
left join lawyerdb.case_apply cap on
    (m.id = cap.case_id))
left join lawyerdb.case_pre_litigation cpre on
    (m.id = cpre.case_id))
left join lawyerdb.case_first_instance cfir on
    (m.id = cfir.case_id))
left join lawyerdb.case_second_instance csec on
    (m.id = csec.case_id))
left join lawyerdb.case_carry_out cout on
    (m.id = cout.case_id))

-- 2020-05-13 update
alter table simple_flow add file_ack_img varchar(1024)    comment '文件审核截图';
alter table simple_flow add biz_ack_img varchar(1024)    comment '业务确认截图';

-- 2020-05-06
CREATE TABLE simple_flow (
  id int NOT NULL AUTO_INCREMENT,
  title varchar(120) NOT NULL COMMENT '流程标题',
  note varchar(1024) NOT NULL COMMENT '流程说明',
  ftype varchar(32) DEFAULT NULL COMMENT '流程业务类型',
  created_time datetime NOT NULL COMMENT '创建时间',
  created_by varchar(32) NOT NULL COMMENT '发起人',
  del_flag varchar(1) default 0 comment '删除标记 1删除 0正常' ,
  status varchar(1) DEFAULT 0 COMMENT '状态（0草稿 1待审批 2审批通过 9驳回 8已结束）',
  remark varchar(1024) DEFAULT NULL comment '备注' ,
  updated_by varchar(32) DEFAULT NULL COMMENT '更新人',
  updated_time datetime DEFAULT NULL COMMENT '更新时间',
  approver varchar(32) DEFAULT NULL COMMENT '审批人',
  PRIMARY KEY (id)
) ENGINE=InnoDB comment = '简单流程信息表' default character set utf8 collate utf8_bin;

CREATE TABLE simple_flow_attach(
  sflow_id int DEFAULT NULL COMMENT '流程id',
  sfile_attach_id int DEFAULT NULL COMMENT '附件id',
)ENGINE=InnoDB comment = '简单流程附件关联表' default character set utf8 collate utf8_bin;

CREATE TABLE sys_file_attach (
  id int NOT NULL AUTO_INCREMENT,
  filename varchar(120) NOT NULL COMMENT '文件名',
  filepath varchar(1024) NOT NULL COMMENT '文件路径',
  ext varchar(32) DEFAULT NULL COMMENT '扩展名',
  filetype varchar(32) DEFAULT NULL,
  fsize varchar(32) DEFAULT NULL COMMENT '文件大小',
  note varchar(1024) DEFAULT NULL COMMENT '说明',
  created_time datetime NOT NULL COMMENT '创建时间',
  created_by varchar(32) NOT NULL COMMENT '上传者',
  PRIMARY KEY (id)
) ENGINE=InnoDB comment = '附件信息表' default character set utf8 collate utf8_bin;

CREATE TABLE sys_dict (
  id int not null auto_increment comment '字典id',
  dict_name varchar(100) DEFAULT NULL COMMENT '字典名称',
  dict_code varchar(100) DEFAULT NULL COMMENT '字典编码',
  description varchar(255) DEFAULT NULL COMMENT '描述',
  del_flag varchar(1) default 0 comment '删除标记 1删除 0正常' ,
  created_by varchar(32) DEFAULT NULL COMMENT '创建人',
  created_time datetime DEFAULT NULL COMMENT '创建时间',
  updated_by varchar(32) DEFAULT NULL COMMENT '更新人',
  updated_time datetime DEFAULT NULL COMMENT '更新时间',
  type int(1) unsigned zerofill DEFAULT '0' COMMENT '字典类型0为string,1为number',
  PRIMARY KEY (id) USING BTREE,
  UNIQUE KEY indextable_dict_code (dict_code) USING BTREE
) ENGINE=InnoDB comment = '系统字典信息表' default character set utf8 collate utf8_bin;

CREATE TABLE sys_dict_item (
  id int not null auto_increment comment '字典项id',
  dict_id int DEFAULT NULL COMMENT '字典id',
  item_text varchar(100) DEFAULT NULL COMMENT '字典项文本',
  item_value varchar(100) DEFAULT NULL COMMENT '字典项值',
  description varchar(255) DEFAULT NULL COMMENT '描述',
  sort_order int(10) DEFAULT NULL COMMENT '排序',
  status int(11) DEFAULT 1 COMMENT '状态（1启用 0不启用）',
  del_flag varchar(1)   default 0 comment '删除标记 1删除 0正常' ,
  created_by varchar(32) DEFAULT NULL,
  created_time datetime DEFAULT NULL,
  updated_by varchar(32) DEFAULT NULL,
  updated_time datetime DEFAULT NULL,
  PRIMARY KEY (id) USING BTREE,
  KEY index_table_dict_id (dict_id) USING BTREE,
  KEY index_table_sort_order (sort_order) USING BTREE,
  KEY index_table_dict_status (status) USING BTREE
) ENGINE=InnoDB comment = '系统字典项目信息表' default character set utf8 collate utf8_bin;

-- 2020-04-28
create table arbitration_case(
    status int   default 1 comment '状态' ,
    del_flag varchar(1)   default 0 comment '删除标记' ,
    org varchar(32)    comment '机构编码' ,
    created_by varchar(32)    comment '创建人' ,
    created_time datetime    comment '创建时间' ,
    updated_by varchar(32)    comment '更新人' ,
    updated_time datetime    comment '更新时间' ,
    id int not null auto_increment  comment '案件序号' ,
    src varchar(32)    comment '案件来源' ,
    supply varchar(32)    comment '案源人' ,
    litigant varchar(32)    comment '当事人' ,
    cause varchar(3072)    comment '案由' ,
    applicant varchar(32)    comment '申请人' ,
    respondent varchar(32)    comment '被申请人' ,
    request varchar(32)    comment '反请求状况' ,
    trust_date date    comment '委托协议日期' ,
    lawyer varchar(32)    comment '主办律师' ,
    agent varchar(32)    comment '出庭代理人' ,
    chief_arbitrator varchar(32)    comment '首席仲裁员' ,
    our_side varchar(32)    comment '我方边裁' ,
    other_side varchar(32)    comment '对方边裁' ,
    arb_secretary varchar(32)    comment '仲裁秘书' ,
    secretary_contact varchar(32)    comment '仲裁秘书联系方式' ,
    op_court_nums varchar(32)    comment '开庭次数' ,
    op_court_date date    comment '开庭日期' ,
    clos_type varchar(32)    comment '结案方式' ,
    primary key (id)
) engine = innodb comment = '仲裁案件信息表 仲裁案件信息表' default character set utf8 collate utf8_bin;

create table no_litigation_customer(
    status int   default 1 comment '状态' ,
    del_flag varchar(1)   default 0 comment '删除标记' ,
    org varchar(32)    comment '机构编码' ,
    created_by varchar(32)    comment '创建人' ,
    created_time datetime    comment '创建时间' ,
    updated_by varchar(32)    comment '更新人' ,
    updated_time datetime    comment '更新时间' ,
    id int not null auto_increment comment '客户ID' ,
    client varchar(180)    comment '委托人' ,
    principal varchar(180)    comment '被委托人' ,
    commission_sdate date    comment '委托开始时间' ,
    commission_edate date    comment '委托结束时间' ,
    billing_model varchar(180)    comment '计费模式' ,
    billing_standard varchar(180)    comment '计费标准' ,
    primary key (id)
) engine = innodb comment = '非诉业务客户信息表 非诉业务信息表' default character set utf8 collate utf8_bin;

create table no_litigation_case(
    status int   default 1 comment '状态' ,
    del_flag varchar(1)   default 0 comment '删除标记' ,
    org varchar(32)    comment '机构编码' ,
    created_by varchar(32)    comment '创建人' ,
    created_time datetime    comment '创建时间' ,
    updated_by varchar(32)    comment '更新人' ,
    updated_time datetime    comment '更新时间' ,
    id int not null auto_increment comment '案件序号' ,
    nolitigation_customer_id int not null comment '非诉业务客户ID' ,
    billing_model varchar(180)    comment '计费模式' ,
    billing_standard varchar(180)    comment '计费标准' ,
    receive_date date    comment '需求接收日期' ,
    src varchar(60)    comment '接收途径' ,
    work_content varchar(180)    comment '工作内容' ,
    party_draft_name varchar(1024)    comment '当事人底稿名称' ,
    contract_party varchar(180)    comment '合同相对放' ,
    resp_date date    comment '返稿日期' ,
    resp_file_name varchar(1024)    comment '律师返稿文件名称' ,
    account_time varchar(32)    comment '核算用时' ,
    remark varchar(1024)    comment '特殊情况备注' ,
    primary key (id)
) engine = innodb comment = '非诉业务信息表 非诉业务信息表' default character set utf8 collate utf8_bin;

create table criminal_case(
    status int   default 1 comment '状态' ,
    del_flag varchar(1)   default 0 comment '删除标记' ,
    org varchar(32)    comment '机构编码' ,
    created_by varchar(32)    comment '创建人' ,
    created_time datetime    comment '创建时间' ,
    updated_by varchar(32)    comment '更新人' ,
    updated_time datetime    comment '更新时间' ,
    id int not null auto_increment  comment '案件序号' ,
    src varchar(32)    comment '案件来源' ,
    supply varchar(32)    comment '案源人' ,
    commission_date date    comment '签署委托日期' ,
    client varchar(128)    comment '委托人' ,
    lawyer varchar(32)    comment '代理律师' ,
    litigant varchar(32)    comment '当事人' ,
    suspected_charges varchar(3072)    comment '涉嫌罪名' ,
    action_stage varchar(32)    comment '诉讼阶段' ,
    judgment_date date    comment '判决日期' ,
    is_close varchar(1)    comment '是否结案' ,
    primary key (id)
) engine = innodb comment = '刑事案件信息表 刑事案件信息表' default character set utf8 collate utf8_bin;

-- 2020-04-19 update
alter table case_apply add is_apply varchar(1)    comment '是否公证  1是 2否';

-- 2020-02-22 update
alter table case_apply add is_direct_action varchar(1)    comment '当事人是否要求直接诉讼';
alter table case_pre_litigation add is_direct_action varchar(1)    comment '是否诉讼';
alter table case_first_instance add is_pre_mediation varchar(1)    comment '是否诉前调解' ;
alter table case_first_instance add is_action_mediation varchar(1)    comment '是否诉中调解' ;
alter table case_first_instance add mediation_date date    comment '调解书日期' ;
alter table case_first_instance add is_appeal varchar(1)    comment '是否上诉' ;
alter table case_first_instance add appellant varchar(1024)    comment '上诉人' ;
alter table case_first_instance add is_carry_out varchar(1)    comment '是否需要执行' ;
alter table case_second_instance add is_carry_out varchar(1)    comment '是否需要执行';
alter table case_carry_out add is_reconcile varchar(1)    comment '是否执行和解';
alter table case_carry_out add is_close varchar(1)    comment '是否结案';