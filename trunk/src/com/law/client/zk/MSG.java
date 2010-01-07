package com.law.client.zk;

import java.util.HashMap;
import java.util.Map;

import bsh.This;

public class MSG {
	
	//��ʼ�����ڵ�����
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
	
	//ϵͳ�����µ��ӽڵ�
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
	
	//��Դ�����µ��ӽڵ�
	private static String[][] _dossierStr = {
		{
			"NEWDOSSIER","NEWREPORT"
		},
		{
			"/pages/sysset/dossiermain.zul",
			"/pages/sysset/dossiermain.zul"
		}
	};
	
	//���������µ��ӽڵ�
	private static String[][] _caseStr = {
		{
			"NEWCASE"
		},
		{
			"/pages/sysset/casemain.zul",
		}
	};
	
	//��ϵ�˹����µ��ӽڵ�
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
	
	private static String[] _tabNameStr = { "����", "������", "����", "����" };
	private static Map _parMsg= new HashMap();//��Ϣ��
	private static Map _codeNameMap = new HashMap();//���ڵ�����	
	private static Map _objMap = new HashMap();//
	
	static{		
		_objMap.put("SYSTEM", _systemStr);
		_objMap.put("DOSS",_dossierStr);
		_objMap.put("CASE",_caseStr);
		_objMap.put("CONTACT", _contacterStr);
		_objMap.put("RIZHI", _RICHENG);
		
		_codeNameMap.put("CONTACT", "��ϵ�˹���");
		_codeNameMap.put("CASE", "��Դ����");
		_codeNameMap.put("DOSS", "��������");
		_codeNameMap.put("WORKSTATUS", "����״��");
		_codeNameMap.put("WORKDOC", "�����ĵ�");
		_codeNameMap.put("RIZHI", "�ճ̡�����");
		_codeNameMap.put("RICHENG", "�ճ̡�����");
		_codeNameMap.put("SYSTEM", "ϵͳ����");
		_codeNameMap.put("SYSSET", "ϵͳ����");
		_codeNameMap.put("DEPTMAN", "���Ź���");
		_codeNameMap.put("DEPTMAN", "���Ź���");
		_codeNameMap.put("USERMAN", "�û�����");
		_codeNameMap.put("ORGMAN", "��֯����");
		_codeNameMap.put("ROLEMAN", "��ɫ����");
		_codeNameMap.put("LOGINMAN", "��¼����");
		_codeNameMap.put("NEWDOSSIER", "�½�����");
		_codeNameMap.put("NEWREPORT", "�½�����");
		_codeNameMap.put("NEWCASE", "�½���Դ");		
		_codeNameMap.put("NEWCONTACTER", "�½���ϵ��");
		_codeNameMap.put("NEWCONTACTUNIT", "�½���ϵ��λ");
		
		
		_parMsg.put("100", "��ʾ");
		_parMsg.put("101", "�������û�����");
		_parMsg.put("102", "���������룡");
		_parMsg.put("103", "�������û�ID��");
		_parMsg.put("104", "��ѡ���û���");
		_parMsg.put("105", "���������룡");
		_parMsg.put("106", "��ȷ�����룡");
		_parMsg.put("107", "ȷ�����������벻ƥ�䣡");
		_parMsg.put("108", "�����벿�����ƣ�");
		_parMsg.put("109", "�����벿�ű�ţ�");
		_parMsg.put("110", "��ѡ�����ʱ�䣡");
		_parMsg.put("111", "�����밸Դ��ţ�");
		_parMsg.put("112", "��ѡ����ϵ�ˣ�");
		_parMsg.put("113", "��ѡ��Դ���࣡");
		_parMsg.put("114", "����ѡ�񰸼���Դ��ʽ��");
		_parMsg.put("115", "�����밸Դ���ƣ�");
		_parMsg.put("116", "�������ɫ���ƣ�");
		_parMsg.put("117", "��ɫ�Ѿ�������");
		_parMsg.put("118", "��ѡ���¼ϵͳ��");
		_parMsg.put("119", "�û������ڣ�");
		_parMsg.put("120", "���벻��ȷ��");
		_parMsg.put("121", "���������գ�");
		_parMsg.put("122", "��ѡ���û���");
		_parMsg.put("123", "��¼ID�Ѿ����ڣ��������������İɣ�");
		_parMsg.put("124", "��ѡ��һ����¼��");
		_parMsg.put("125", "�����밸���ţ�");
		_parMsg.put("126", "�����밸�����ƣ�");
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
