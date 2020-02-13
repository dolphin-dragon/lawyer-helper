SET SESSION FOREIGN_KEY_CHECKS=0;

-- 客户信息数据表
create table case_customer(
    status int    comment '状态' ,
    org varchar(32)    comment '机构编码' ,
    created_by varchar(32)    comment '创建人' ,
    created_time datetime    comment '创建时间' ,
    updated_by varchar(32)    comment '更新人' ,
    updated_time datetime    comment '更新时间' ,
    id int not null auto_increment  comment '客户id' ,
    code varchar(32)    comment '客户编码' ,
    ctype varchar(32)    comment '客户类型' ,
    id_card varchar(32)    comment '客户身份证信息' ,
    e_code varchar(32)    comment '企业组织机构代码' ,
    phone varchar(32)    comment '联系电话' ,
    link_man varchar(32)    comment '联系人' ,
    remark varchar(1024)    comment '备注' ,
    del_flag varchar(1)    comment '删除标记' ,
    primary key (id)
) engine = innodb comment = '客户信息记录表' default character set utf8 collate utf8_bin;

-- 用户信息表
create table sys_user_ext(
    status int    comment '状态' ,
    org varchar(32)    comment '机构编码' ,
    created_by varchar(32)    comment '创建人' ,
    created_time datetime    comment '创建时间' ,
    updated_by varchar(32)    comment '更新人' ,
    updated_time datetime    comment '更新时间' ,
    uid int not null auto_increment  comment '用户id' ,
    name varchar(32)    comment '姓名' ,
    sex varchar(1)    comment '性别' ,
    phone varchar(32)    comment '手机号' ,
    tel varchar(32)    comment '联系电话' ,
    qq varchar(32)    comment 'qq号码' ,
    position varchar(32)    comment '职位类别' ,
    entry_date date    comment '入职时间' ,
    birt date    comment '出生日期' ,
    email varchar(128)    comment '电子邮箱' ,
    remark varchar(1024)    comment '备注' ,
    del_flg varchar(1)    comment '删除标记' ,
    primary key (uid)
) engine = innodb comment = '用户扩展信息表' default character set utf8 collate utf8_bin;

-- 案件执行阶段信息 
create table case_carry_out(
    status int    comment '状态' ,
    org varchar(32)    comment '机构编码' ,
    created_by varchar(32)    comment '创建人' ,
    created_time datetime    comment '创建时间' ,
    updated_by varchar(32)    comment '更新人' ,
    updated_time datetime    comment '更新时间' ,
    case_id int not null   comment '案件序号' ,
    lawyer varchar(32)    comment '执行主办律师' ,
    app_date date    comment '执行申请日期' ,
    app_total decimal(32,8)    comment '申请执行总额' ,
    judge varchar(32)    comment '执行主办法官' ,
    judge_contact varchar(128)    comment '联系方式' ,
    actual_total decimal(32,8)    comment '实际执行总额' ,
    f_collection_subject varchar(1024)    comment '首位收款主体' ,
    remark varchar(1024)    comment '备注' ,
    primary key (case_id)
) engine = innodb comment = '案件执行阶段信息记录表' default character set utf8 collate utf8_bin;

-- 案件二审阶段信息
create table case_second_instance(
    status int    comment '状态' ,
    org varchar(32)    comment '机构编码' ,
    created_by varchar(32)    comment '创建人' ,
    created_time datetime    comment '创建时间' ,
    updated_by varchar(32)    comment '更新人' ,
    updated_time datetime    comment '更新时间' ,
    case_id int not null   comment '案件序号' ,
    lawyer varchar(32)    comment '二审主办律师' ,
    s_court_date date    comment '二审开庭日期' ,
    judge varchar(32)    comment '主办法官' ,
    judge_contact varchar(128)    comment '联系方式' ,
    s_judgment_effective_date varchar(32)    comment '二审判决生效日期' ,
    is_apology varchar(1)    comment '是否致歉' ,
    defendant_compensation_total varchar(32)    comment '一审被告赔偿总额' ,
    defendant_expenses varchar(32)    comment '一审被告承担合理开支费用' ,
    plaintiff_costs varchar(32)    comment '一审原告承担诉费' ,
    defendant_costs decimal(32,8)    comment '一审被告承担诉费' ,
    is_close varchar(1)    comment '是否结案' ,
    execution_deadline date    comment '执行截止日期' ,
    remark varchar(1024)    comment '备注' ,
    primary key (case_id)
) engine = innodb comment = '案件二审阶段信息记录表' default character set utf8 collate utf8_bin;

-- 案件一审阶段信息
create table case_first_instance(
    status int    comment '状态' ,
    org varchar(32)    comment '机构编码' ,
    created_by varchar(32)    comment '创建人' ,
    created_time datetime    comment '创建时间' ,
    updated_by varchar(32)    comment '更新人' ,
    updated_time datetime    comment '更新时间' ,
    case_id int not null   comment '案件序号' ,
    firstor varchar(32)    comment '第一责任人' ,
    lawyer varchar(32)    comment '一审主办律师' ,
    submit_date date    comment '提交立案材料日期' ,
    establish_date date    comment '立案日期' ,
    litigation_costs decimal(32,8)    comment '诉讼费用' ,
    announcement_costs decimal(32,8)    comment '公告费用' ,
    notary_costs decimal(32,8)    comment '公证费用' ,
    other_costs decimal(32,8)    comment '其它费用' ,
    adjudication_court varchar(1024)    comment '受理法院' ,
    judge varchar(32)    comment '主办法官' ,
    judge_contact varchar(128)    comment '联系方式' ,
    f_court_date date    comment '一审开庭日期' ,
    f_verdict_date date    comment '一审判决书落款日期' ,
    f_verdict_receive_date date    comment '一审判决书收到日期' ,
    is_apology varchar(1)    comment '是否致歉' ,
    defendant_compensation_total decimal(32,8)    comment '被告赔偿总额' ,
    defendant_expenses decimal(32,8)    comment '被告承担合理开支总额' ,
    plaintiff_costs decimal(32,8)    comment '原告承担诉费' ,
    defendant_costs decimal(32,8)    comment '被告承担诉费' ,
    is_close varchar(1)    comment '是否结案' ,
    appeal_date date    comment '上诉截止日期' ,
    remark varchar(1024)    comment '备注' ,
    primary key (case_id)
) engine = innodb comment = '案件一审阶段信息记录表' default character set utf8 collate utf8_bin;

-- 案件诉前和解信息
create table case_pre_litigation(
    status int    comment '状态' ,
    org varchar(32)    comment '机构编码' ,
    created_by varchar(32)    comment '创建人' ,
    created_time datetime    comment '创建时间' ,
    updated_by varchar(32)    comment '更新人' ,
    updated_time datetime    comment '更新时间' ,
    case_id int not null   comment '案件序号' ,
    letter varchar(32)    comment '律师函编号' ,
    letteror varchar(32)    comment '律师函主办人' ,
    send_date date    comment '律师函发送日期' ,
    delivery_date date    comment '律师函送达日期' ,
    is_close varchar(1)    comment '是否结案' ,
    remark varchar(1024)    comment '备注' ,
    primary key (case_id)
) engine = innodb comment = '案件诉前和解信息登记表' default character set utf8 collate utf8_bin;

-- 案件确立阶段信息
create table case_apply(
    status int    comment '状态' ,
    org varchar(32)    comment '机构编码' ,
    created_by varchar(32)    comment '创建人' ,
    created_time datetime    comment '创建时间' ,
    updated_by varchar(32)    comment '更新人' ,
    updated_time datetime    comment '更新时间' ,
    case_id int not null   comment '案件序号' ,
    src varchar(32)    comment '案件来源' ,
    supply varchar(32)    comment '案源人' ,
    apply_date date    comment '申请公证日期' ,
    applicant varchar(32)    comment '公证书申请人' ,
    forensics varchar(32)    comment '取证人' ,
    violate_type varchar(32)    comment '侵权类型' ,
    violate_desc varchar(3072)    comment '侵权概况' ,
    action_date date    comment '案件可诉确认日期' ,
    litigant_ac_date date    comment '当事人确认日期' ,
    primary key (case_id)
) engine = innodb comment = '案件确立阶段信息记录表' default character set utf8 collate utf8_bin;

-- 案件基本信息
create table case_info(
    status int    comment '状态' ,
    org varchar(32)    comment '机构编码' ,
    created_by varchar(32)    comment '创建人' ,
    created_time datetime    comment '创建时间' ,
    updated_by varchar(32)    comment '更新人' ,
    updated_time datetime    comment '更新时间' ,
    id int not null auto_increment  comment '序号' ,
    litigant varchar(128)    comment '当事人' ,
    defendant_name varchar(1024)    comment '被告名称' ,
    defendant_reg_capital varchar(32)    comment '被告注册资本' ,
    defendant_area varchar(1024)    comment '被告所在地' ,
    primary key (id)
) engine = innodb comment = '案件基本信息登记表'  default character set utf8 collate utf8_bin;


