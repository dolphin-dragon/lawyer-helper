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