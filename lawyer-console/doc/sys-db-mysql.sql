SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL auto_increment COMMENT '主键',
  `name` varchar(50) default NULL COMMENT '菜单名称',
  `url` varchar(100) default NULL COMMENT '系统url',
  `parentId` int(10) default NULL COMMENT ' 父id 关联sys_menu.id',
  `deleted` int(1) NOT NULL default '0' COMMENT '是否删除,0=未删除，1=已删除',
  `createTime` datetime default NULL COMMENT '创建时间',
  `updateTime` datetime default NULL COMMENT '修改时间',
  `rank` int(11) NOT NULL default '0' COMMENT '排序',
  `actions` varchar(500) default '0' COMMENT '注册Action 按钮|分隔',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '', null, '0', '2012-12-23 17:21:58', '2013-01-10 22:30:50', '1', '');
INSERT INTO `sys_menu` VALUES ('2', '菜单管理', '/sysMenu/menu.shtml', '1', '0', '2012-12-23 18:18:32', '2013-01-13 02:29:33', '0', 'dataList.do');
INSERT INTO `sys_menu` VALUES ('6', '系统用户管理', '/sysUser/list.shtml', '1', '0', '2012-12-23 22:15:33', '2013-02-18 11:42:46', '0', 'dataList.do');
INSERT INTO `sys_menu` VALUES ('7', '角色管理', '/sysRole/role.shtml', '1', '0', '2012-12-24 22:17:51', '2013-01-13 01:15:00', '0', 'dataList.do|/sysMenu/getMenuTree.do');
INSERT INTO `sys_menu` VALUES ('8', '系统用户授权', '/sysUser/userRole.shtml', '1', '0', '2013-01-06 11:42:26', '2013-02-18 11:43:19', '0', 'userList.do|/sysRole/loadRoleList.do');

-- ----------------------------
-- Table structure for `sys_menu_btn`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_btn`;
CREATE TABLE `sys_menu_btn` (
  `id` int(11) NOT NULL auto_increment COMMENT '主键',
  `menuid` int(11) NOT NULL COMMENT ' 菜单id关联 sys_menu.id',
  `btnName` varchar(30) default NULL COMMENT '按钮名称',
  `btnType` varchar(30) default NULL COMMENT '按钮类型，用于列表页显示的按钮',
  `actionUrls` varchar(250) default NULL COMMENT 'url注册，用"," 分隔 。用于权限控制UR',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu_btn
-- ----------------------------
INSERT INTO `sys_menu_btn` VALUES ('5', '2', '添加', 'add', 'save.do');
INSERT INTO `sys_menu_btn` VALUES ('6', '2', '修改', 'edit', 'getId.do|save.do');
INSERT INTO `sys_menu_btn` VALUES ('7', '2', '删除', 'remove', 'delete.do');
INSERT INTO `sys_menu_btn` VALUES ('8', '6', '添加', 'add', 'save.do');
INSERT INTO `sys_menu_btn` VALUES ('9', '6', '修改', 'edit', 'getId.do|save.do');
INSERT INTO `sys_menu_btn` VALUES ('10', '6', '修改密码', 'editPwd', 'updatePwd.do');
INSERT INTO `sys_menu_btn` VALUES ('11', '6', '删除', 'remove', 'delete.do');
INSERT INTO `sys_menu_btn` VALUES ('12', '7', '添加', 'add', 'save.do');
INSERT INTO `sys_menu_btn` VALUES ('13', '7', '修改', 'edit', 'getId.do|save.do');
INSERT INTO `sys_menu_btn` VALUES ('14', '7', '删除', 'remove', 'delete.do');
INSERT INTO `sys_menu_btn` VALUES ('15', '8', '授权', 'authRole', '/sysUser/getUser.do|/sysUser/addUserRole.do');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(12) NOT NULL auto_increment COMMENT 'id主键',
  `roleName` varchar(30) default NULL COMMENT '角色名称',
  `createTime` datetime default NULL COMMENT '创建时间',
  `createBy` int(11) default NULL COMMENT '创建人',
  `updateTime` datetime default NULL COMMENT '修改时间',
  `updateBy` int(11) default NULL COMMENT '修改人',
  `state` int(1) default NULL COMMENT '状态0=可用 1=禁用',
  `descr` varchar(200) default NULL COMMENT '角色描述',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系统管理员', '2013-01-05 16:07:00', null, '2013-02-19 17:31:13', null, '0', null);
INSERT INTO `sys_role` VALUES ('3', '管理员', '2013-01-06 10:45:06', null, '2013-01-14 11:22:38', null, '0', null);
INSERT INTO `sys_role` VALUES ('18', '站点管理', '2013-01-13 01:21:46', null, '2013-01-13 01:21:54', null, '0', '站点管理');
INSERT INTO `sys_role` VALUES ('19', '测试管理员', '2013-01-13 17:10:21', null, '2013-02-09 21:11:41', null, '0', null);

-- ----------------------------
-- Table structure for `sys_role_rel`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_rel`;
CREATE TABLE `sys_role_rel` (
  `roleId` int(11) NOT NULL COMMENT '角色主键 sys_role.id',
  `objId` int(11) NOT NULL COMMENT '关联主键 type=0管理sys_menu.id, type=1关联sys_user.id',
  `relType` int(1) default NULL COMMENT '关联类型 0=菜单,1=用户'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_rel
-- ----------------------------
INSERT INTO `sys_role_rel` VALUES ('1', '3', '1');
INSERT INTO `sys_role_rel` VALUES ('18', '4', '0');
INSERT INTO `sys_role_rel` VALUES ('18', '5', '0');
INSERT INTO `sys_role_rel` VALUES ('18', '19', '2');
INSERT INTO `sys_role_rel` VALUES ('18', '20', '2');
INSERT INTO `sys_role_rel` VALUES ('18', '16', '2');
INSERT INTO `sys_role_rel` VALUES ('18', '17', '2');
INSERT INTO `sys_role_rel` VALUES ('18', '5', '1');
INSERT INTO `sys_role_rel` VALUES ('3', '5', '1');
INSERT INTO `sys_role_rel` VALUES ('3', '8', '0');
INSERT INTO `sys_role_rel` VALUES ('3', '1', '0');
INSERT INTO `sys_role_rel` VALUES ('3', '2', '0');
INSERT INTO `sys_role_rel` VALUES ('3', '6', '0');
INSERT INTO `sys_role_rel` VALUES ('3', '7', '0');
INSERT INTO `sys_role_rel` VALUES ('3', '5', '2');
INSERT INTO `sys_role_rel` VALUES ('3', '8', '2');
INSERT INTO `sys_role_rel` VALUES ('3', '9', '2');
INSERT INTO `sys_role_rel` VALUES ('3', '12', '2');
INSERT INTO `sys_role_rel` VALUES ('3', '13', '2');
INSERT INTO `sys_role_rel` VALUES ('3', '15', '2');
INSERT INTO `sys_role_rel` VALUES ('18', '6', '1');
INSERT INTO `sys_role_rel` VALUES ('3', '6', '1');
INSERT INTO `sys_role_rel` VALUES ('1', '6', '1');
INSERT INTO `sys_role_rel` VALUES ('19', '6', '1');
INSERT INTO `sys_role_rel` VALUES ('19', '8', '0');
INSERT INTO `sys_role_rel` VALUES ('19', '1', '0');
INSERT INTO `sys_role_rel` VALUES ('19', '2', '0');
INSERT INTO `sys_role_rel` VALUES ('19', '6', '0');
INSERT INTO `sys_role_rel` VALUES ('19', '7', '0');
INSERT INTO `sys_role_rel` VALUES ('19', '7', '2');
INSERT INTO `sys_role_rel` VALUES ('19', '8', '2');
INSERT INTO `sys_role_rel` VALUES ('19', '10', '2');
INSERT INTO `sys_role_rel` VALUES ('19', '13', '2');
INSERT INTO `sys_role_rel` VALUES ('19', '15', '2');
INSERT INTO `sys_role_rel` VALUES ('3', '1', '1');
INSERT INTO `sys_role_rel` VALUES ('18', '1', '1');
INSERT INTO `sys_role_rel` VALUES ('19', '1', '1');
INSERT INTO `sys_role_rel` VALUES ('1', '1', '1');
INSERT INTO `sys_role_rel` VALUES ('1', '1', '0');
INSERT INTO `sys_role_rel` VALUES ('1', '2', '0');
INSERT INTO `sys_role_rel` VALUES ('1', '6', '0');
INSERT INTO `sys_role_rel` VALUES ('1', '7', '0');
INSERT INTO `sys_role_rel` VALUES ('1', '8', '0');
INSERT INTO `sys_role_rel` VALUES ('1', '9', '0');
INSERT INTO `sys_role_rel` VALUES ('1', '10', '0');
INSERT INTO `sys_role_rel` VALUES ('1', '13', '0');
INSERT INTO `sys_role_rel` VALUES ('1', '5', '2');
INSERT INTO `sys_role_rel` VALUES ('1', '6', '2');
INSERT INTO `sys_role_rel` VALUES ('1', '7', '2');
INSERT INTO `sys_role_rel` VALUES ('1', '8', '2');
INSERT INTO `sys_role_rel` VALUES ('1', '9', '2');
INSERT INTO `sys_role_rel` VALUES ('1', '10', '2');
INSERT INTO `sys_role_rel` VALUES ('1', '11', '2');
INSERT INTO `sys_role_rel` VALUES ('1', '12', '2');
INSERT INTO `sys_role_rel` VALUES ('1', '13', '2');
INSERT INTO `sys_role_rel` VALUES ('1', '14', '2');
INSERT INTO `sys_role_rel` VALUES ('1', '15', '2');
INSERT INTO `sys_role_rel` VALUES ('1', '22', '2');
INSERT INTO `sys_role_rel` VALUES ('1', '23', '2');
INSERT INTO `sys_role_rel` VALUES ('1', '24', '2');
INSERT INTO `sys_role_rel` VALUES ('1', '25', '2');
INSERT INTO `sys_role_rel` VALUES ('1', '26', '2');
INSERT INTO `sys_role_rel` VALUES ('1', '27', '2');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL auto_increment COMMENT 'id主键',
  `email` varchar(50) NOT NULL COMMENT '邮箱也是登录帐号',
  `pwd` varchar(50) default NULL COMMENT '登录密码',
  `nickName` varchar(50) default NULL COMMENT '昵称',
  `state` int(1) NOT NULL default '0' COMMENT '状态 0=可用,1=禁用',
  `loginCount` int(11) default NULL COMMENT '登录总次数',
  `loginTime` datetime default NULL COMMENT '最后登录时间',
  `deleted` int(1) NOT NULL default '0' COMMENT '删除状态 0=未删除,1=已删除',
  `createTime` datetime default NULL COMMENT '创建时间',
  `updateTime` datetime default NULL COMMENT '修改时间',
  `createBy` int(11) default NULL COMMENT '创建人',
  `updateBy` int(11) default NULL COMMENT '修改人',
  `superAdmin` int(1) NOT NULL default '0' COMMENT '是否超级管理员 0= 不是，1=是',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin@qq.com', '28427386A201A2BFB5A6542670A81BF2', '系统管理员', '0', '242', '2013-02-20 21:13:03', '0', '2012-12-23 23:01:15', '2013-02-20 21:13:03', null, null, '1');
INSERT INTO `sys_user` VALUES ('5', 'wolf@qq.com', '6C30734811916B0F0F24A4630B08036F', 'scott', '0', '71', '2013-02-09 10:29:42', '0', '2013-01-07 12:30:10', '2013-02-09 10:29:42', null, null, '0');
INSERT INTO `sys_user` VALUES ('6', 'dr@qq.com', null, ' 游客', '0', null, null, '0', '2013-01-13 03:41:32', '2013-01-13 03:41:32', null, null, '0');
INSERT INTO `sys_user` VALUES ('12', 'cat@163.com', null, null, '0', null, null, '0', '2013-02-20 11:24:28', '2013-02-20 11:24:28', null, null, '0');
