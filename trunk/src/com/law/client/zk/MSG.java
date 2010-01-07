package com.law.client.zk;

import java.util.HashMap;
import java.util.Map;

import bsh.This;

public class MSG {
	
	//初始化树节点名称
	public static String[][] _strTreeNode = {
		{"CONTACT","CASE","DOSS", "WORKSTATUS", "WORKDOC", "RIZHI","SYSTEM" },
		{"/pages/sysset/contactmain.zul",
			"/pages/sysset/contactmain.zul",
			"/pages/sysset/contactmain.zul", 
			"/pages/sysset/contactmain.zul", 
			"/pages/sysset/contactmain.zul",
			"/pages/sysset/contactmain.zul",
			"/pages/sysset/contactmain.zul"}
		};
	
	//系统管理下的子节点
	private static String[][] _systemStr = {
		{
			"SYSSET","DEPTMAN","USERMAN","ORGMAN","ROLEMAN","LOGINMAN"
		},
		{
			"/pages/sysset/systemmain.zul",
			"/pages/sysset/deptmain.zul",
			"/pages/sysset/usermain.zul",
			"/pages/sysset/orgmain.zul",
			"/pages/sysset/rolemain.zul",
			"/pages/sysset/loginmain.zul",
		}
	};
	
	//案源管理下的子节点
	private static String[][] _dossierStr = {
		{
			"NEWDOSSIER","NEWREPORT"
		},
		{
			"/pages/sysset/dossiermain.zul",
			"/pages/sysset/dossiermain.zul"
		}
	};
	
	//案件管理下的子节点
	private static String[][] _caseStr = {
		{
			"NEWCASE"
		},
		{
			"/pages/sysset/casemain.zul",
		}
	};
	
	//联系人管理下的子节点
	private static String[][] _contacterStr = {
		{
			"NEWCONTACTER","NEWCONTACTUNIT"
		},
		{
			"/pages/sysset/contactmain.zul",
			"/pages/sysset/contactUnitMain.zul"
		}
	};
	
	private static String[][] _RICHENG = {
		{
			"RICHENG"
		},
		{
			"http://202.100.101.168:8080/Calendar/schedule/calendar.zul"
		}
	};
	
	private static String[] _tabNameStr = { "今天", "三天内", "本周", "本月" };
	private static Map _parMsg= new HashMap();//消息集
	private static Map _codeNameMap = new HashMap();//树节点名称	
	private static Map _objMap = new HashMap();//
	
	static{		
		_objMap.put("SYSTEM", _systemStr);
		_objMap.put("DOSS",_dossierStr);
		_objMap.put("CASE",_caseStr);
		_objMap.put("CONTACT", _contacterStr);
		_objMap.put("RIZHI", _RICHENG);
		
		_codeNameMap.put("CONTACT", "联系人管理");
		_codeNameMap.put("CASE", "案源管理");
		_codeNameMap.put("DOSS", "案件管理");
		_codeNameMap.put("WORKSTATUS", "工作状况");
		_codeNameMap.put("WORKDOC", "工作文档");
		_codeNameMap.put("RIZHI", "日程、日务");
		_codeNameMap.put("RICHENG", "日程、日务");
		_codeNameMap.put("SYSTEM", "系统管理");
		_codeNameMap.put("SYSSET", "系统设置");
		_codeNameMap.put("DEPTMAN", "部门管理");
		_codeNameMap.put("DEPTMAN", "部门管理");
		_codeNameMap.put("USERMAN", "用户管理");
		_codeNameMap.put("ORGMAN", "组织管理");
		_codeNameMap.put("ROLEMAN", "角色管理");
		_codeNameMap.put("LOGINMAN", "登录管理");
		_codeNameMap.put("NEWDOSSIER", "新建案件");
		_codeNameMap.put("NEWREPORT", "新建报告");
		_codeNameMap.put("NEWCASE", "新建案源");		
		_codeNameMap.put("NEWCONTACTER", "新建联系人");
		_codeNameMap.put("NEWCONTACTUNIT", "新建联系单位");
		
		
		_parMsg.put("100", "提示");
		_parMsg.put("101", "请输入用户名！");
		_parMsg.put("102", "请输入密码！");
		_parMsg.put("103", "请输入用户ID！");
		_parMsg.put("104", "请选择用户！");
		_parMsg.put("105", "请输入密码！");
		_parMsg.put("106", "请确认密码！");
		_parMsg.put("107", "确认密码与密码不匹配！");
		_parMsg.put("108", "请输入部门名称！");
		_parMsg.put("109", "请输入部门编号！");
		_parMsg.put("110", "请选择成立时间！");
		_parMsg.put("111", "请输入案源编号！");
		_parMsg.put("112", "请选择联系人！");
		_parMsg.put("113", "请选案源分类！");
		_parMsg.put("114", "请输选择案件来源方式！");
		_parMsg.put("115", "请输入案源名称！");
		_parMsg.put("116", "请输入角色名称！");
		_parMsg.put("117", "角色已经创建！");
		_parMsg.put("118", "请选择登录系统！");
		_parMsg.put("119", "用户不存在！");
		_parMsg.put("120", "密码不正确！");
		_parMsg.put("121", "请输入生日！");
		_parMsg.put("122", "请选择用户！");
		_parMsg.put("123", "登录ID已经存在，请您换个更靓的吧！");
		_parMsg.put("124", "请选择一条记录！");
		_parMsg.put("125", "请输入案卷编号！");
		_parMsg.put("126", "请输入案卷名称！");
	}
			
	public static String getContent(String type,String code){
		if("MSG".equals(type)){
			return getMsg(code);
		}else if("NODENAME".equals(type)){
			return getNodeStr(code);
		}
		return null;
	}
	
	private static String getNodeStr(String keyStr){
		return _codeNameMap.get(keyStr).toString();
	}
	
	private static String getMsg(String number){
		return _parMsg.get(number).toString();
	}
	
	public static String[][] getChildrenName(String partentId){
		if(null == _objMap.get(partentId)){
			return null;
		}
		return (String[][])_objMap.get(partentId);
	}
	
	public static String[] getTabName(){
		return _tabNameStr;
	}
}
