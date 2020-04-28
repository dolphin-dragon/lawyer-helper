-- 2020-04-28
create table arbitration_case(
    status int   default 1 comment '状态' ,
    del_flag varchar(1)   default 0 comment '删除标记' ,
    org varchar(32)    comment '机构编码' ,
    created_by varchar(32)    comment '创建人' ,
    created_time datetime    comment '创建时间' ,
    updated_by varchar(32)    comment '更新人' ,
    updated_time datetime    comment '更新时间' ,
    id varchar(32) not null   comment '案件序号' ,
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

create table no_litigation_case(
    status int   default 1 comment '状态' ,
    del_flag varchar(1)   default 0 comment '删除标记' ,
    org varchar(32)    comment '机构编码' ,
    created_by varchar(32)    comment '创建人' ,
    created_time datetime    comment '创建时间' ,
    updated_by varchar(32)    comment '更新人' ,
    updated_time datetime    comment '更新时间' ,
    id varchar(32) not null   comment '案件序号' ,
    client varchar(32)    comment '委托人' ,
    principal varchar(32)    comment '被委托人' ,
    commission_sdate date    comment '委托开始时间' ,
    commission_edate date    comment '委托结束时间' ,
    billing_model varchar(32)    comment '计费模式' ,
    billing_standard varchar(32)    comment '计费标准' ,
    receive_date date    comment '需求接收日期' ,
    src varchar(32)    comment '接收途径' ,
    work_content varchar(32)    comment '工作内容' ,
    party_draft_name varchar(1024)    comment '当事人底稿名称' ,
    contract_party varchar(128)    comment '合同相对放' ,
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
    id varchar(32) not null   comment '案件序号' ,
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