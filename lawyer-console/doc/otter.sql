-- MySQL dump 10.13  Distrib 5.6.27, for osx10.8 (x86_64)
--
-- Host: 127.0.0.1    Database: otter
-- ------------------------------------------------------
-- Server version	5.6.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `case_apply`
--

DROP TABLE IF EXISTS `case_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `case_apply` (
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `org` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '机构编码',
  `created_by` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `case_id` int(11) NOT NULL COMMENT '案件序号',
  `src` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '案件来源',
  `supply` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '案源人',
  `apply_date` date DEFAULT NULL COMMENT '申请公证日期',
  `applicant` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '公证书申请人',
  `forensics` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '取证人',
  `violate_type` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '侵权类型',
  `violate_desc` varchar(3072) COLLATE utf8_bin DEFAULT NULL COMMENT '侵权概况',
  `action_date` date DEFAULT NULL COMMENT '案件可诉确认日期',
  `litigant_ac_date` date DEFAULT NULL COMMENT '当事人确认日期',
  PRIMARY KEY (`case_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='案件确立阶段信息记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `case_apply`
--

LOCK TABLES `case_apply` WRITE;
/*!40000 ALTER TABLE `case_apply` DISABLE KEYS */;
INSERT INTO `case_apply` VALUES (NULL,NULL,NULL,NULL,'1','2020-02-14 13:26:06',1,'1','王律师','2020-02-18','李律师','陈律师','王律师','侵权概况侵权概况侵权概况侵权概况','2020-02-19','2020-02-26');
/*!40000 ALTER TABLE `case_apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `case_carry_out`
--

DROP TABLE IF EXISTS `case_carry_out`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `case_carry_out` (
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `org` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '机构编码',
  `created_by` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `case_id` int(11) NOT NULL COMMENT '案件序号',
  `lawyer` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '执行主办律师',
  `app_date` date DEFAULT NULL COMMENT '执行申请日期',
  `app_total` decimal(32,8) DEFAULT NULL COMMENT '申请执行总额',
  `judge` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '执行主办法官',
  `judge_contact` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '联系方式',
  `actual_total` decimal(32,8) DEFAULT NULL COMMENT '实际执行总额',
  `f_collection_subject` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '首位收款主体',
  `remark` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`case_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='案件执行阶段信息记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `case_carry_out`
--

LOCK TABLES `case_carry_out` WRITE;
/*!40000 ALTER TABLE `case_carry_out` DISABLE KEYS */;
/*!40000 ALTER TABLE `case_carry_out` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `case_customer`
--

DROP TABLE IF EXISTS `case_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `case_customer` (
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `org` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '机构编码',
  `created_by` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户id',
  `code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '客户编码',
  `ctype` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '客户类型',
  `id_card` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '客户身份证信息',
  `e_code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '企业组织机构代码',
  `phone` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
  `link_man` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人',
  `remark` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `del_flag` varchar(1) COLLATE utf8_bin DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='客户信息记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `case_customer`
--

LOCK TABLES `case_customer` WRITE;
/*!40000 ALTER TABLE `case_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `case_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `case_first_instance`
--

DROP TABLE IF EXISTS `case_first_instance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `case_first_instance` (
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `org` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '机构编码',
  `created_by` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `case_id` int(11) NOT NULL COMMENT '案件序号',
  `firstor` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '第一责任人',
  `lawyer` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '一审主办律师',
  `submit_date` date DEFAULT NULL COMMENT '提交立案材料日期',
  `establish_date` date DEFAULT NULL COMMENT '立案日期',
  `litigation_costs` decimal(32,8) DEFAULT NULL COMMENT '诉讼费用',
  `announcement_costs` decimal(32,8) DEFAULT NULL COMMENT '公告费用',
  `notary_costs` decimal(32,8) DEFAULT NULL COMMENT '公证费用',
  `other_costs` decimal(32,8) DEFAULT NULL COMMENT '其它费用',
  `adjudication_court` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '受理法院',
  `judge` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '主办法官',
  `judge_contact` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '联系方式',
  `f_court_date` date DEFAULT NULL COMMENT '一审开庭日期',
  `f_verdict_date` date DEFAULT NULL COMMENT '一审判决书落款日期',
  `f_verdict_receive_date` date DEFAULT NULL COMMENT '一审判决书收到日期',
  `is_apology` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '是否致歉',
  `defendant_compensation_total` decimal(32,8) DEFAULT NULL COMMENT '被告赔偿总额',
  `defendant_expenses` decimal(32,8) DEFAULT NULL COMMENT '被告承担合理开支总额',
  `plaintiff_costs` decimal(32,8) DEFAULT NULL COMMENT '原告承担诉费',
  `defendant_costs` decimal(32,8) DEFAULT NULL COMMENT '被告承担诉费',
  `is_close` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '是否结案',
  `appeal_date` date DEFAULT NULL COMMENT '上诉截止日期',
  `remark` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`case_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='案件一审阶段信息记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `case_first_instance`
--

LOCK TABLES `case_first_instance` WRITE;
/*!40000 ALTER TABLE `case_first_instance` DISABLE KEYS */;
/*!40000 ALTER TABLE `case_first_instance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `case_info`
--

DROP TABLE IF EXISTS `case_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `case_info` (
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `del_flag` varchar(1) COLLATE utf8_bin DEFAULT '0' COMMENT '删除标记',
  `org` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '机构编码',
  `created_by` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `litigant` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '当事人',
  `defendant_name` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '被告名称',
  `defendant_reg_capital` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '被告注册资本',
  `defendant_area` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '被告所在地',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='案件基本信息登记表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `case_info`
--

LOCK TABLES `case_info` WRITE;
/*!40000 ALTER TABLE `case_info` DISABLE KEYS */;
INSERT INTO `case_info` VALUES (NULL,'0',NULL,'1','2020-02-14 11:01:59','1','2020-02-14 13:26:06',1,'当事人 _02','被告名称_01','200万','朝阳区高碑店村北京市');
/*!40000 ALTER TABLE `case_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `case_pre_litigation`
--

DROP TABLE IF EXISTS `case_pre_litigation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `case_pre_litigation` (
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `org` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '机构编码',
  `created_by` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `case_id` int(11) NOT NULL COMMENT '案件序号',
  `letter` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '律师函编号',
  `letteror` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '律师函主办人',
  `send_date` date DEFAULT NULL COMMENT '律师函发送日期',
  `delivery_date` date DEFAULT NULL COMMENT '律师函送达日期',
  `is_close` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '是否结案',
  `remark` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`case_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='案件诉前和解信息登记表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `case_pre_litigation`
--

LOCK TABLES `case_pre_litigation` WRITE;
/*!40000 ALTER TABLE `case_pre_litigation` DISABLE KEYS */;
/*!40000 ALTER TABLE `case_pre_litigation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `case_second_instance`
--

DROP TABLE IF EXISTS `case_second_instance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `case_second_instance` (
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `org` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '机构编码',
  `created_by` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `case_id` int(11) NOT NULL COMMENT '案件序号',
  `lawyer` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '二审主办律师',
  `s_court_date` date DEFAULT NULL COMMENT '二审开庭日期',
  `judge` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '主办法官',
  `judge_contact` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '联系方式',
  `s_judgment_effective_date` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '二审判决生效日期',
  `is_apology` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '是否致歉',
  `defendant_compensation_total` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '一审被告赔偿总额',
  `defendant_expenses` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '一审被告承担合理开支费用',
  `plaintiff_costs` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '一审原告承担诉费',
  `defendant_costs` decimal(32,8) DEFAULT NULL COMMENT '一审被告承担诉费',
  `is_close` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '是否结案',
  `execution_deadline` date DEFAULT NULL COMMENT '执行截止日期',
  `remark` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`case_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='案件二审阶段信息记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `case_second_instance`
--

LOCK TABLES `case_second_instance` WRITE;
/*!40000 ALTER TABLE `case_second_instance` DISABLE KEYS */;
/*!40000 ALTER TABLE `case_second_instance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(100) DEFAULT NULL COMMENT '系统url',
  `parentId` int(10) DEFAULT NULL COMMENT ' 父id 关联sys_menu.id',
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '是否删除,0=未删除，1=已删除',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `rank` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `actions` varchar(500) DEFAULT '0' COMMENT '注册Action 按钮|分隔',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,'系统管理','',NULL,0,'2012-12-23 17:21:58','2013-01-10 22:30:50',1,''),(2,'菜单管理','/sysMenu/menu.shtml',1,0,'2012-12-23 18:18:32','2013-01-13 02:29:33',0,'dataList.do'),(6,'用户管理','/sysUser/list.shtml',1,0,'2012-12-23 22:15:33','2018-06-28 23:26:11',0,'dataList.do'),(7,'角色管理','/sysRole/role.shtml',1,0,'2012-12-24 22:17:51','2013-01-13 01:15:00',0,'dataList.do|/sysMenu/getMenuTree.do'),(8,'用户授权','/sysUser/userRole.shtml',1,0,'2013-01-06 11:42:26','2018-06-28 23:26:19',0,'userList.do|/sysRole/loadRoleList.do'),(9,'案件管理','',NULL,0,'2020-02-12 22:05:36',NULL,2,''),(10,'案件确立','/caseApply/list.shtml',9,0,'2020-02-12 22:23:19','2020-02-14 14:19:54',0,'dataList.do'),(11,'诉前和解','/casePreLitigation/list.shtml',9,0,'2020-02-12 22:27:51','2020-02-14 14:20:11',1,'dataList.do'),(12,'一审阶段','/caseFirstInstance/list.shtml',9,0,'2020-02-12 22:28:43','2020-02-14 14:20:30',2,'dataList.do'),(13,'二审阶段','/caseSecondInstance/list.shtml',9,0,'2020-02-12 22:29:20','2020-02-14 14:20:49',3,'dataList.do'),(14,'执行阶段','/caseCarryOut/list.shtml',9,0,'2020-02-12 22:30:18','2020-02-14 14:21:01',4,'dataList.do');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu_btn`
--

DROP TABLE IF EXISTS `sys_menu_btn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu_btn` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menuid` int(11) NOT NULL COMMENT ' 菜单id关联 sys_menu.id',
  `btnName` varchar(30) DEFAULT NULL COMMENT '按钮名称',
  `btnType` varchar(30) DEFAULT NULL COMMENT '按钮类型，用于列表页显示的按钮',
  `actionUrls` varchar(250) DEFAULT NULL COMMENT 'url注册，用"," 分隔 。用于权限控制UR',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu_btn`
--

LOCK TABLES `sys_menu_btn` WRITE;
/*!40000 ALTER TABLE `sys_menu_btn` DISABLE KEYS */;
INSERT INTO `sys_menu_btn` VALUES (5,2,'添加','add','save.do'),(6,2,'修改','edit','getId.do|save.do'),(7,2,'删除','remove','delete.do'),(8,6,'添加','add','save.do'),(9,6,'修改','edit','getId.do|save.do'),(10,6,'修改密码','editPwd','updatePwd.do'),(11,6,'删除','remove','delete.do'),(12,7,'添加','add','save.do'),(13,7,'修改','edit','getId.do|save.do'),(14,7,'删除','remove','delete.do'),(15,8,'授权','authRole','/sysUser/getUser.do|/sysUser/addUserRole.do'),(16,10,'添加','add','save.do'),(17,10,'修改','edit','getId.do|save.do'),(18,10,'删除','remove','delete.do'),(19,11,'修改','edit','getId.do|save.do'),(20,11,'删除','remove','delete.do'),(21,12,'修改','edit','getId.do|save.do'),(22,12,'删除','remove','delete.do'),(23,13,'修改','edit','getId.do|save.do'),(24,13,'删除','remove','delete.do'),(25,14,'修改','edit','getId.do|save.do'),(26,14,'删除','remove','delete.do');
/*!40000 ALTER TABLE `sys_menu_btn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `roleName` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `createBy` int(11) DEFAULT NULL COMMENT '创建人',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `updateBy` int(11) DEFAULT NULL COMMENT '修改人',
  `state` int(1) DEFAULT NULL COMMENT '状态0=可用 1=禁用',
  `descr` varchar(200) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'系统开发管理角色','2013-01-05 16:07:00',NULL,'2018-06-28 23:35:15',NULL,0,NULL),(3,'授权管理角色','2013-01-06 10:45:06',NULL,'2018-06-28 23:34:56',NULL,0,NULL),(18,'记录员角色','2013-01-13 01:21:46',NULL,'2018-06-28 23:34:46',NULL,0,NULL),(19,'访客角色','2013-01-13 17:10:21',NULL,'2020-02-14 14:21:48',NULL,0,NULL);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_rel`
--

DROP TABLE IF EXISTS `sys_role_rel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_rel` (
  `roleId` int(11) NOT NULL COMMENT '角色主键 sys_role.id',
  `objId` int(11) NOT NULL COMMENT '关联主键 type=0管理sys_menu.id, type=1关联sys_user.id',
  `relType` int(1) DEFAULT NULL COMMENT '关联类型 0=菜单,1=用户'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_rel`
--

LOCK TABLES `sys_role_rel` WRITE;
/*!40000 ALTER TABLE `sys_role_rel` DISABLE KEYS */;
INSERT INTO `sys_role_rel` VALUES (1,3,1),(1,1,1),(19,5,1),(18,1,0),(18,2,0),(18,6,0),(18,7,0),(18,5,2),(18,6,2),(18,8,2),(18,9,2),(18,12,2),(18,13,2),(3,8,0),(3,1,0),(3,15,2),(1,1,0),(1,2,0),(1,6,0),(1,7,0),(1,8,0),(1,5,2),(1,6,2),(1,7,2),(1,8,2),(1,9,2),(1,10,2),(1,11,2),(1,12,2),(1,13,2),(1,14,2),(1,15,2),(18,6,1),(3,12,1),(19,10,0),(19,9,0),(19,11,0),(19,12,0),(19,13,0),(19,14,0),(19,16,2),(19,17,2),(19,18,2),(19,19,2),(19,21,2),(19,23,2),(19,25,2);
/*!40000 ALTER TABLE `sys_role_rel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `email` varchar(50) NOT NULL COMMENT '邮箱也是登录帐号',
  `pwd` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `nickName` varchar(50) DEFAULT NULL COMMENT '昵称',
  `state` int(1) NOT NULL DEFAULT '0' COMMENT '状态 0=可用,1=禁用',
  `loginCount` int(11) DEFAULT NULL COMMENT '登录总次数',
  `loginTime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态 0=未删除,1=已删除',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createBy` int(11) DEFAULT NULL COMMENT '创建人',
  `updateBy` int(11) DEFAULT NULL COMMENT '修改人',
  `superAdmin` int(1) NOT NULL DEFAULT '0' COMMENT '是否超级管理员 0= 不是，1=是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'admin@qq.com','5768A86B702B34ABA6422922F48E607C','系统开发管理员',0,18,'2020-02-14 14:08:26',0,'2012-12-23 23:01:15','2020-02-14 14:08:26',NULL,NULL,1),(5,'vis@qq.com','40B3CA3156512B9E0DC20F9313EB2ED3','游客',0,4,'2020-02-14 14:22:08',0,'2013-01-07 12:30:10','2020-02-14 14:22:07',NULL,NULL,0),(6,'recorder@qq.com','40B3CA3156512B9E0DC20F9313EB2ED3','记录员',0,1,'2020-02-14 14:10:28',0,'2013-01-13 03:41:32','2020-02-14 14:10:28',NULL,NULL,0),(12,'grantor@qq.com','40B3CA3156512B9E0DC20F9313EB2ED3','授权管理员',0,0,'2018-06-28 23:38:29',0,'2013-02-20 11:24:28','2018-06-28 23:38:29',NULL,NULL,0);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_ext`
--

DROP TABLE IF EXISTS `sys_user_ext`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_ext` (
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `org` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '机构编码',
  `created_by` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `sex` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `phone` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `tel` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
  `qq` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT 'qq号码',
  `position` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '职位类别',
  `entry_date` date DEFAULT NULL COMMENT '入职时间',
  `birt` date DEFAULT NULL COMMENT '出生日期',
  `email` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '电子邮箱',
  `remark` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `del_flag` varchar(1) COLLATE utf8_bin DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户扩展信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_ext`
--

LOCK TABLES `sys_user_ext` WRITE;
/*!40000 ALTER TABLE `sys_user_ext` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user_ext` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_note`
--

DROP TABLE IF EXISTS `t_note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(255) DEFAULT NULL COMMENT '详细描述',
  `crtuser` varchar(255) DEFAULT NULL,
  `crtuser_name` varchar(255) DEFAULT NULL,
  `create_dt` datetime DEFAULT NULL COMMENT '建创时间',
  `deleted` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_note`
--

LOCK TABLES `t_note` WRITE;
/*!40000 ALTER TABLE `t_note` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_note` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-14 15:01:22
